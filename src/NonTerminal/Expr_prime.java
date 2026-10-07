package NonTerminal;

import java.util.ArrayList;

import Outils.Outils;
import Token.Token;

public class Expr_prime extends NonTerminal{
	
	public Expr_prime() {
		super();
		setValeur("expr_prime");
	}

	@Override
	public void initPremier(ArrayList<Token> listeToken) {
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
		suivants.add(Outils.getEgal(listeToken));
		suivants.add(Outils.getMoins(listeToken));
		suivants.add(Outils.getCrochetOuvrant(listeToken));
		suivants.add(Outils.getCrochetFermant(listeToken));
		suivants.add(Outils.getPlus(listeToken));
		suivants.add(Outils.getMult(listeToken));
		suivants.add(Outils.getDiv(listeToken));
		suivants.add(Outils.getPourcent(listeToken));
		suivants.add(Outils.getInf(listeToken));
		suivants.add(Outils.getSupEgal(listeToken));
		suivants.add(Outils.getSup(listeToken));
		suivants.add(Outils.getInfEgal(listeToken));
		suivants.add(Outils.getNotEgal(listeToken));
		suivants.add(Outils.getEgalBool(listeToken));
		suivants.add(Outils.getOr(listeToken));
		suivants.add(Outils.getAnd(listeToken));
	}
	
	@Override
	public Expr_prime copie() {
		Expr_prime expr_prime = new Expr_prime();
		expr_prime.setValeur(this.getValeur());
		return expr_prime;
	}

	
}
