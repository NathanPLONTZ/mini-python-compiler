package NonTerminal;

import java.util.ArrayList;

import Outils.Outils;
import Token.Token;

public class Const extends NonTerminal{
	
	public Const() {
		super();
		setValeur("const");
	}

	@Override
	public void initPremier(ArrayList<Token> listeToken) {
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
		suivants.add(Outils.getVirgule(listeToken));
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
	public Const copie() {
		Const cons = new Const();
		cons.setValeur(this.getValeur());
		return cons;
	}
	
}
