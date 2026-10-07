package Arbre;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Grammaire.Symbole;
import NonTerminal.Def_etoile;
import NonTerminal.Expr_etoile;
import NonTerminal.Expr_etoile_init;
import NonTerminal.Ident_expr;
import NonTerminal.Next_arg;
import NonTerminal.NonTerminal;
import NonTerminal.Stmt_etoile;
import Token.And;
import Token.BEGIN;
import Token.Commentaire;
import Token.CrochetFermant;
import Token.CrochetOuvrant;
import Token.Def;
import Token.DeuxPoints;
import Token.Div;
import Token.Dollar;
import Token.END;
import Token.EOF;
import Token.Egal;
import Token.EgalBool;
import Token.Else;
import Token.Epsilon;
import Token.For;
import Token.If;
import Token.Inf;
import Token.InfEgal;
import Token.Mult;
import Token.NEWLINE;
import Token.Not;
import Token.NotEgal;
import Token.Or;
import Token.ParentheseFermante;
import Token.ParentheseOuvrante;
import Token.Plus;
import Token.Pourcent;
import Token.Print;
import Token.Return;
import Token.Sup;
import Token.SupEgal;
import Token.Token;
import Token.Virgule;

/**
 * Generic n-ary tree node, used for both the concrete and the abstract syntax
 * tree.
 *
 * <p>The parser fills a tree whose nodes carry {@link Symbole}s and whose shape
 * mirrors the derivation. {@link #treeToAbstractTree()} then rewrites that tree
 * <strong>in place</strong> into the abstract syntax tree, by applying a fixed
 * sequence of simplification passes: dropping punctuation, collapsing chain
 * productions, lifting keywords and operators into their parent, flattening the
 * repetition non-terminals, and finally relabelling a few nodes for readability.
 *
 * @param <T> the payload type (a {@link Symbole} in the compiler, a
 *            {@link String} in the hand-built demo tree)
 */
public class Node<T> {
	private T val;
	private ArrayList<Node<T>> children;
	private Node<T> parent;

	public Node(T val) {
		this.val = val;
		children = new ArrayList<>();
		parent = null;
	}

	/** Appends a child and returns it. */
	public Node<T> addChild(T child) {
		var c = new Node<T>(child);
		children.add(c);
		c.parent = this;
		return c;
	}

	/** Inserts a child at {@code index} and returns it. */
	public Node<T> addChild(int index, T child) {
		var c = new Node<T>(child);
		children.add(index, c);
		c.parent = this;
		return c;
	}

	public void removeChild(Node<T> child) {
		children.remove(child);
	}

	public void removeChild(int i) {
		children.remove(i);
	}

	public Node<T> getParent() {
		return this.parent;
	}

	public T getValue() {
		return this.val;
	}

	public String getValueToString() {
		return this.val.toString();
	}

	public ArrayList<Node<T>> getChildren() {
		return this.children;
	}

	public boolean hasChildren() {
		return !this.children.isEmpty();
	}

	/**
	 * Tells whether a node carries a token that is pure syntax noise: separators,
	 * brackets, layout tokens and comments, which the abstract tree does not keep.
	 */
	public boolean estInutile(Node<T> n) {
		if (n.getValue() instanceof Epsilon || n.getValue() instanceof BEGIN || n.getValue() instanceof Commentaire
				|| n.getValue() instanceof CrochetOuvrant || n.getValue() instanceof CrochetFermant
				|| n.getValue() instanceof DeuxPoints || n.getValue() instanceof Dollar || n.getValue() instanceof END
				|| n.getValue() instanceof EOF || n.getValue() instanceof NEWLINE
				|| n.getValue() instanceof ParentheseOuvrante || n.getValue() instanceof ParentheseFermante
				|| n.getValue() instanceof Virgule) {
			return true;
		}
		return false;
	}

	/** Pass 1: drops every syntax-noise node, recursively. */
	public void removeNodesInutiles() {
		// Walk the children backwards so that removals do not shift the cursor.
		for (int i = children.size() - 1; i >= 0; i--) {
			Node<T> child = children.get(i);

			if (estInutile(child)) {
				children.remove(i);
			}

			// Recurse into the subtree.
			child.removeNodesInutiles();
		}
	}

	/** Pass 2: drops non-terminals that ended up with no child at all. */
	public void removeNonTerminalWithoutChild() {
		// Backwards again, for the same index-shifting reason.
		for (int i = children.size() - 1; i >= 0; i--) {
			if (getChildren().get(i).getChildren().size() == 0
					&& getChildren().get(i).getValue() instanceof NonTerminal) {
				removeChild(i);
			}
		}

		// Second walk, to recurse into the children that survived.
		for (int i = 0; i < children.size(); i++) {
			getChildren().get(i).removeNonTerminalWithoutChild();
		}
	}

	/**
	 * Pass 3: replaces a non-terminal having a single terminal child by that
	 * terminal, repeatedly until the tree stops changing.
	 */
	public void replaceNonTerminalWithUniqueTerminalChild() {
		boolean changesMade;

		do {
			changesMade = processSingleLevel();
		} while (changesMade);
	}

	/** Processes one level and reports whether anything changed. */
	private boolean processSingleLevel() {
		boolean changesMade = false;

		for (int i = children.size() - 1; i >= 0; i--) {
			Node<T> child = children.get(i);

			// A non-terminal with exactly one child, that child being a terminal.
			if (child.getValue() instanceof NonTerminal && child.getChildren().size() == 1) {
				Node<T> uniqueChild = child.getChildren().get(0);

				if (uniqueChild.getValue() instanceof Symbole && ((Symbole) uniqueChild.getValue()).isTerminal()) {
					// The non-terminal takes the place of its terminal child.
					child.val = uniqueChild.getValue();
					child.children = uniqueChild.getChildren();

					// Re-parent the grandchildren that moved up.
					for (Node<T> grandChild : child.children) {
						grandChild.parent = child;
					}

					changesMade = true;
				}
			}

			// Recurse into the subtree.
			if (child.processSingleLevel()) {
				changesMade = true;
			}
		}

		return changesMade;
	}

	/**
	 * Pass 4: collapses chain productions, where a non-terminal has a single child
	 * that is itself a non-terminal.
	 */
	public void mergeNonTerminalWithSingleChild() {
		boolean merged;

		do {
			merged = false;

			for (int i = 0; i < children.size(); i++) {
				Node<T> child = children.get(i);

				if (child.getValue() instanceof NonTerminal && child.getChildren().size() == 1) {
					Node<T> uniqueChild = child.getChildren().get(0);

					if (uniqueChild.getValue() instanceof NonTerminal) {
						// The child adopts its only child's children.
						child.children = uniqueChild.getChildren();
						for (Node<T> grandChild : uniqueChild.getChildren()) {
							grandChild.parent = child;
						}

						merged = true;
					}
				}

				child.mergeNonTerminalWithSingleChild();
			}
		} while (merged);
	}

	/**
	 * Pass 5: lifts a statement keyword (print, return, if, else, def, for, not)
	 * into its parent, so that the keyword labels the construct instead of hanging
	 * below it.
	 */
	public void remonterFils() {
		for (int i = 0; i <= children.size() - 1; i++) {
			Node<T> child = children.get(i);

			if (child.getValue() instanceof Print || child.getValue() instanceof Else
					|| child.getValue() instanceof Return || child.getValue() instanceof If
					|| child.getValue() instanceof Def || child.getValue() instanceof Not
					|| child.getValue() instanceof For) {
				// The parent takes the keyword as its own label...
				this.val = child.getValue();

				// ...and the now-redundant child goes away.
				this.removeChild(i);

				// Only one keyword can label a node, so stop here.
				break;
			}
		}

		for (Node<T> child : children) {
			child.remonterFils();
		}
	}

	/** Tells whether a payload is a binary operator token. */
	public boolean estOperateur(T noeud) {
		return noeud instanceof EgalBool || noeud instanceof SupEgal || noeud instanceof Div
				|| noeud instanceof Mult || noeud instanceof NotEgal || noeud instanceof Plus
				|| noeud instanceof Sup || noeud instanceof InfEgal || noeud instanceof Inf
				|| noeud instanceof Or || noeud instanceof And || noeud instanceof Pourcent;
	}

	/**
	 * Pass 6: lifts a binary operator into the node above it, turning the
	 * right-recursive expression chain into an operator node with its operands as
	 * children.
	 */
	public void remonterOperateur() {
		for (int i = children.size() - 1; i >= 0; i--) {
			Node<T> child = children.get(i);
			if (this.getValue() instanceof NonTerminal) {
				if (child.hasChildren() && estOperateur(child.getChildren().get(0).getValue())) {
					this.val = child.getChildren().get(0).getValue();

					// Everything after the operator becomes a sibling operand.
					ArrayList<Node<T>> newChildren = new ArrayList<>(child.getChildren());
					newChildren.remove(0);
					children.addAll(i + 1, newChildren);

					children.remove(i);
				}
			} else if (getParent() != null) {
				// The current node already holds a terminal: push it one level up so the
				// operator can take its place.
				if (this.getValue() instanceof Token && this.getParent().getValue() instanceof NonTerminal) {
					if (child.hasChildren() && estOperateur(child.getChildren().get(0).getValue())) {
						getParent().val = this.val;
						this.val = child.getChildren().get(0).getValue();

						ArrayList<Node<T>> newChildren = new ArrayList<>(child.getChildren());
						newChildren.remove(0);
						children.addAll(i + 1, newChildren);

						children.remove(i);
					}
				}
			}
			child.remonterOperateur();
		}
	}

	/** Pass 7: same lifting as {@link #remonterOperateur()}, for assignments. */
	public void remonterEgal() {
		for (int i = children.size() - 1; i >= 0; i--) {
			Node<T> child = children.get(i);

			if (child.hasChildren() && child.getChildren().get(0).getValue() instanceof Egal) {
				// The parent becomes the "=" node.
				this.val = child.getChildren().get(0).getValue();

				// Everything after the "=" becomes a sibling operand.
				ArrayList<Node<T>> newChildren = new ArrayList<>(child.getChildren());
				newChildren.remove(0);
				children.addAll(i + 1, newChildren);

				children.remove(i);
			}

			child.remonterEgal();
		}
	}

	/**
	 * Pass 8: flattens the repetition non-terminals (the "star" ones) so that a
	 * sequence of definitions, statements or expressions becomes a flat list of
	 * siblings instead of a right-leaning comb.
	 */
	public void remonterEtoile() {
		boolean changesMade;

		do {
			changesMade = false;

			for (int i = children.size() - 1; i >= 0; i--) {
				Node<T> child = children.get(i);

				if (child.getValue() instanceof Def_etoile || child.getValue() instanceof Stmt_etoile
						|| child.getValue() instanceof Expr_etoile_init || child.getValue() instanceof Expr_etoile
						|| child.getValue() instanceof Ident_expr || child.getValue() instanceof Next_arg) {

					ArrayList<Node<T>> grandChildren = child.getChildren();

					// Splice the grandchildren in where the star node was.
					for (Node<T> grandChild : grandChildren) {
						grandChild.parent = this;
					}
					children.addAll(i + 1, grandChildren);

					children.remove(i);

					changesMade = true;
				}

				child.remonterEtoile();
			}
		} while (changesMade);
	}

	/**
	 * Pass 9: cosmetic relabelling for the printed tree. Note that the replacement
	 * values are plain strings, so a renamed node no longer carries a
	 * {@link Symbole}; this pass must therefore stay last.
	 */
	@SuppressWarnings("unchecked")
	public void rename() {
		for (int i = 0; i < children.size(); i++) {
			Node<T> child = children.get(i);

			T value = child.getValue();

			if (value != null) {
				// Every flavour of expression non-terminal prints as a single "Expr".
				Pattern pattern = Pattern.compile(".*Expr.*");
				Matcher matcher = pattern.matcher(value.toString());

				if (matcher.matches()) {
					child.val = (T) "Expr";
				} else if ("Arg".equals(value.toString())) {
					child.val = (T) "Paramètre(s)";
				} else if ("Suite".equals(value.toString())) {
					child.val = (T) "Bloc";
				} else if ("for".equals(value.toString())) {
					// In a for loop, the iterated collection prints as "[]".
					if (child.getChildren().size() >= 3) {
						Node<T> thirdChild = child.getChildren().get(2);
						thirdChild.val = (T) "[]";
					}
				}
			}

			child.rename();
		}
	}

	/**
	 * Rewrites this concrete syntax tree into the abstract syntax tree, in place,
	 * and returns itself. The caller must therefore print the concrete tree before
	 * calling this method.
	 */
	public Node<T> treeToAbstractTree() {
		this.removeNodesInutiles();
		this.removeNonTerminalWithoutChild();
		this.replaceNonTerminalWithUniqueTerminalChild();
		this.mergeNonTerminalWithSingleChild();
		this.remonterFils();
		this.remonterOperateur();
		this.remonterEgal();
		this.remonterEtoile();
		this.rename();
		return this;
	}

}
