package NonTerminal;

import java.util.ArrayList;

import Outils.Outils;
import Token.Token;

public class Binop extends NonTerminal{
	
	public Binop() {
		super();
		setValeur("binop");
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
		suivants.add(Outils.getIdent(listeToken));
		suivants.add(Outils.getParentheseOuvrante(listeToken));
		suivants.add(Outils.getMoins(listeToken));
		suivants.add(Outils.getCrochetOuvrant(listeToken));
		suivants.add(Outils.getNot(listeToken));
		suivants.add(Outils.getInt(listeToken));
		suivants.add(Outils.getStr(listeToken));
		suivants.add(Outils.getTrue(listeToken));
		suivants.add(Outils.getFalse(listeToken));
		suivants.add(Outils.getNone(listeToken));
	}

	@Override
	public Binop copie() {
		Binop binop = new Binop();
		binop.setValeur(this.getValeur());
		return binop;
	}
	
}
