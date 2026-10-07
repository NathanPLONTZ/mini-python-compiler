package NonTerminal;

import java.util.ArrayList;

import Outils.Outils;
import Token.Token;

public class Next_arg extends NonTerminal{
	
	public Next_arg() {
		super();
		setValeur("next_arg");
	}

	@Override
	public void initPremier(ArrayList<Token> listeToken) {

		premiers.add(Outils.getEpsilon(listeToken));
		
		premiers.add(Outils.getVirgule(listeToken));
		
	}

	@Override
	public void initSuivant(ArrayList<Token> listeToken) {
		suivants.add(Outils.getParentheseFermante(listeToken));
	}
	
	@Override
	public Next_arg copie() {
		Next_arg next_arg = new Next_arg();
		next_arg.setValeur(this.getValeur());
		return next_arg;
	}

	
}
