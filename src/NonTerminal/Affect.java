package NonTerminal;

import java.util.ArrayList;

import Token.Token;
import Outils.Outils;

public class Affect extends NonTerminal{
	
	public Affect() {
		super();
		setValeur("affect");
	}

	@Override
	public void initPremier(ArrayList<Token> listeToken) {

		premiers.add(Outils.getEpsilon(listeToken));
		premiers.add(Outils.getEgal(listeToken));
	}

	@Override
	public void initSuivant(ArrayList<Token> listeToken) {
		suivants.add(Outils.getNEWLINE(listeToken));
	}

	@Override
	public Affect copie() {
		Affect affect = new Affect();
		affect.setValeur(this.getValeur());
		return affect;
	}

	
}