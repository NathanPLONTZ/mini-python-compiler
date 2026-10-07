package NonTerminal;

import java.util.ArrayList;

import Outils.Outils;
import Token.Token;

public class Expr_stmt extends NonTerminal{
	
	public Expr_stmt() {
		super();
		setValeur("expr_stmt");
	}

	@Override
	public void initPremier(ArrayList<Token> listeToken) {
		premiers.add(Outils.getIdent(listeToken));
		premiers.add(Outils.getParentheseOuvrante(listeToken));
		premiers.add(Outils.getMoins(listeToken));
		premiers.add(Outils.getCrochetOuvrant(listeToken));
		premiers.add(Outils.getNot(listeToken));
		premiers.add(Outils.getInt(listeToken));
		premiers.add(Outils.getStr(listeToken));
		premiers.add(Outils.getTrue(listeToken));
		premiers.add(Outils.getFalse(listeToken));
		premiers.add(Outils.getNone(listeToken));
	}

	@Override
	public void initSuivant(ArrayList<Token> listeToken) {
		suivants.add(Outils.getNEWLINE(listeToken));
		suivants.add(Outils.getEgal(listeToken));
	}
	
	@Override
	public Expr_stmt copie() {
		Expr_stmt expr_stmt = new Expr_stmt();
		expr_stmt.setValeur(this.getValeur());
		return expr_stmt;
	}

	
}