package NonTerminal;

import java.util.ArrayList;

import Outils.Outils;
import Token.Token;

public class Expr_droite extends NonTerminal{
	
	public Expr_droite() {
		super();
		setValeur("expr_droite");
	}

	@Override
	public void initPremier(ArrayList<Token> listeToken) {

		premiers.add(Outils.getEpsilon(listeToken));
		
		premiers.add(Outils.getMoins(listeToken));
		premiers.add(Outils.getPlus(listeToken));
		premiers.add(Outils.getMult(listeToken));
		premiers.add(Outils.getDiv(listeToken));
		premiers.add(Outils.getPourcent(listeToken));
		premiers.add(Outils.getInf(listeToken));
		premiers.add(Outils.getSupEgal(listeToken));
		premiers.add(Outils.getSup(listeToken));
		premiers.add(Outils.getInfEgal(listeToken));
		premiers.add(Outils.getNotEgal(listeToken));
		premiers.add(Outils.getEgalBool(listeToken));
		premiers.add(Outils.getOr(listeToken));
		premiers.add(Outils.getAnd(listeToken));
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
	public Expr_droite copie() {
		Expr_droite expr_droite = new Expr_droite();
		expr_droite.setValeur(this.getValeur());
		return expr_droite;
	}
}
