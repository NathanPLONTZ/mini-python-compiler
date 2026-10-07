package NonTerminal;

import java.util.ArrayList;

import Outils.Outils;
import Token.Token;

public class Expr_init extends NonTerminal{
	
	public Expr_init() {
		super();
		setValeur("expr_init");
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
		suivants.add(Outils.getParentheseFermante(listeToken));
		suivants.add(Outils.getDeuxPoints(listeToken));
		suivants.add(Outils.getCrochetOuvrant(listeToken));
		suivants.add(Outils.getCrochetFermant(listeToken));
	}

	@Override
	public Expr_init copie() {
		Expr_init expr_init = new Expr_init();
		expr_init.setValeur(this.getValeur());
		return expr_init;
	}
	
}
