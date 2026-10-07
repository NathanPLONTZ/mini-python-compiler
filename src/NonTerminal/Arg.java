package NonTerminal;

import java.util.ArrayList;

import Outils.Outils;
import Token.Token;

public class Arg extends NonTerminal{
	
	public Arg() {
		super();
		setValeur("arg");
	}

	@Override
	public void initPremier(ArrayList<Token> listeToken) {
		premiers.add(Outils.getEpsilon(listeToken));
		
		premiers.add(Outils.getIdent(listeToken));
	}

	@Override
	public void initSuivant(ArrayList<Token> listeToken) {
		suivants.add(Outils.getParentheseFermante(listeToken));
	}

	@Override
	public Arg copie() {
		Arg arg = new Arg();
		arg.setValeur(this.getValeur());
		return arg;
	}
	
}
