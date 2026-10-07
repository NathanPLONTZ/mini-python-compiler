package NonTerminal;

import java.util.ArrayList;

import Grammaire.Symbole;
import Token.Token;

/**
 * Base class of every non-terminal.
 *
 * <p>Each subclass fills its own FIRST and FOLLOW sets in {@link #initPremier}
 * and {@link #initSuivant}; the sets are written out by hand rather than
 * computed by fixpoint.
 */
public abstract  class NonTerminal extends Symbole{
	
	private String valeur;
	
	public NonTerminal() {
		super();
	}
	
	
	
	
	@Override
	public boolean isTerminal() {
		return false;
	}

	public abstract void initPremier(ArrayList<Token> listeToken);
	
	public abstract void initSuivant(ArrayList<Token> listeToken);
	
	public String getValeur() {
		return valeur;
	}
	
	public void setValeur(String v) {
		valeur=v;
	}
	
	
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    return this.getClass() == obj.getClass();
	}
	
	public static ArrayList<NonTerminal> initNonTerminal() {
		ArrayList<NonTerminal> allNonTerminal=new ArrayList<NonTerminal>();
		allNonTerminal.add(new Affect());
		allNonTerminal.add(new Arg());
		allNonTerminal.add(new Binop());
		allNonTerminal.add(new Const());
		allNonTerminal.add(new Def_etoile());
		allNonTerminal.add(new DefNT());
		allNonTerminal.add(new ElseNT());
		allNonTerminal.add(new Expr_droite());
		allNonTerminal.add(new Expr_etoile_init());
		allNonTerminal.add(new Expr_etoile());
		allNonTerminal.add(new Expr_init());
		allNonTerminal.add(new Expr_prime());
		allNonTerminal.add(new Expr_stmt());
		allNonTerminal.add(new Expr());
		allNonTerminal.add(new File());
		allNonTerminal.add(new Ident_expr());
		allNonTerminal.add(new Ident_fact());
		allNonTerminal.add(new Next_arg());
		allNonTerminal.add(new Simple_stmt());
		allNonTerminal.add(new Stmt_etoile());
		allNonTerminal.add(new Stmt());
		allNonTerminal.add(new Suite());
		
		return allNonTerminal;
	}
	
	
}
