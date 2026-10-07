package NonTerminal;

import java.util.ArrayList;

import Outils.Outils;
import Token.Token;

public class Ident_fact extends NonTerminal{
	
	public Ident_fact() {
		super();
		setValeur("ident_fact");
	}

	@Override
	public void initPremier(ArrayList<Token> listeToken) {

		premiers.add(Outils.getEpsilon(listeToken));
		
		premiers.add(Outils.getParentheseOuvrante(listeToken));
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
		suivants.add(Outils.getEgal(listeToken));
	}
	
	@Override
	public Ident_fact copie() {
		Ident_fact ident_fact = new Ident_fact();
		ident_fact.setValeur(this.getValeur());
		return ident_fact;
	}

	
}
