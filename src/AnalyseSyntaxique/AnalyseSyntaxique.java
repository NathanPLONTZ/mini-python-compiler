package AnalyseSyntaxique;

import java.util.ArrayList;
import java.util.Stack;

import Arbre.Node;
import Arbre.PrettyPrintTree;
import Grammaire.Grammaire;
import Grammaire.Regle;
import Grammaire.Symbole;
import Token.EOF;
import Token.Epsilon;
import Token.NEWLINE;
import Token.Token;

/**
 * Table-driven LL(1) parser.
 *
 * <p>Runs the classic predictive-parsing loop over a stack of symbols: a
 * terminal on top of the stack is matched against the look-ahead token, a
 * non-terminal is expanded with the production found in the {@link TableLL1}
 * cell. A parallel stack of {@link Node}s records the derivation, which yields
 * the concrete syntax tree; the abstract tree is then derived from it.
 *
 * <p>State is static and shared, so a single run per JVM is supported.
 */
public class AnalyseSyntaxique {

	/** Symbol stack driving the prediction. */
	public static Stack<Symbole> pile = new Stack<Symbole>();
	/** Productions applied so far, in order (used to report the last one). */
	public static ArrayList<Regle> actions = new ArrayList<Regle>();
	/** Root of the tree built during the derivation. */
	public static Node<Symbole> arbre;
	/** Current source line, incremented on every NEWLINE consumed. */
	public static int ligne = 1;
	/** Set by the lexer when it emitted at least one error token. */
	public static boolean erreurLexical = false;

	public AnalyseSyntaxique() {
	}

	/**
	 * Parses a token stream against the grammar and prints both trees on success.
	 *
	 * @param mot       the token stream, which must end with {@link EOF}
	 * @param grammaire the grammar to parse with
	 * @return {@code true} if the stream belongs to the language
	 */
	public static boolean motValide(ArrayList<Token> mot, Grammaire grammaire) {
		if (!mot.get(mot.size() - 1).equals(new EOF())) {
			System.out.println("Il manque le EOF à la fin du mot");
			return false;
		}

		arbre = new Node<Symbole>(grammaire.getAxiome());
		Node<Symbole> noeudCourant = arbre;

		Stack<Node<Symbole>> pileArbre = new Stack<Node<Symbole>>();
		pileArbre.push(noeudCourant);
		pile.push(grammaire.getAxiome());

		TableLL1 table = new TableLL1(grammaire);
		int teteLecture = 0;

		while (!pile.isEmpty() && teteLecture < mot.size()) {
			Symbole sommetPile = pile.peek();
			noeudCourant = pileArbre.peek();

			Token tokenCourant = mot.get(teteLecture);

			if (sommetPile.isTerminal()) {
				Token token = (Token) sommetPile;
				if (token.equals(new Epsilon())) {
					// Epsilon matches without consuming any input.
					pile.pop();
					pileArbre.pop();
				} else if (token.equals(tokenCourant)) {
					if (tokenCourant instanceof NEWLINE)
						ligne++;
					token.setValeur(tokenCourant.getValeur());
					pile.pop();
					pileArbre.pop();
					teteLecture++;
				} else {
					signalerErreurSyntaxique(sommetPile, tokenCourant);
					return false;
				}
			} else {
				if (table.contains(sommetPile.getNom(), tokenCourant.getNom())) {
					// Expand the non-terminal: push the right-hand side in reverse so that
					// its leftmost symbol ends up on top of the stack.
					Regle regle = table.get(sommetPile.getNom(), tokenCourant.getNom()).copie();
					actions.add(regle);
					pile.pop();
					pileArbre.pop();
					for (int i = regle.getPartieDroite().size() - 1; i >= 0; i--) {
						pile.push(regle.getPartieDroite().get(i));
						Node<Symbole> child = noeudCourant.addChild(0, regle.getPartieDroite().get(i));
						pileArbre.push(child);
					}
				} else {
					signalerErreurSyntaxique(sommetPile, tokenCourant);
					return false;
				}
			}
		}

		PrettyPrintTree<Node<Symbole>> pt = new PrettyPrintTree<Node<Symbole>>(
				Node::getChildren,
				Node::getValueToString);

		System.out.println("Arbre syntaxique classique :");
		pt.display(arbre);

		// treeToAbstractTree rewrites the tree in place, so the concrete tree has to
		// be printed first.
		System.out.println("Arbre syntaxique abstrait  :");
		Node<Symbole> arbreAbstrait = arbre.treeToAbstractTree();
		pt.display(arbreAbstrait);

		return true;
	}

	/**
	 * Reports a parse error on the look-ahead token, together with the last
	 * production applied, which is usually the most useful clue.
	 */
	private static void signalerErreurSyntaxique(Symbole sommetPile, Token tokenCourant) {
		System.out.println("Erreur syntaxique ligne " + tokenCourant.getNumLigne() + " sur le token : "
				+ tokenCourant.getValeur() + " | Aucune règle dans la table LL pour (" + sommetPile.getNom() + ","
				+ tokenCourant.getNom() + ")");
		System.out.print("Dernière règle appliquée : ");
		if (actions.isEmpty()) {
			// The very first token already failed, so no production was applied yet.
			System.out.println("aucune");
		} else {
			actions.get(actions.size() - 1).afficherRegle();
		}
	}
}
