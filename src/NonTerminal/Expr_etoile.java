package NonTerminal;

import java.util.ArrayList;

import Outils.Outils;
import Token.Token;

public class Expr_etoile extends NonTerminal{
	
	public Expr_etoile() {
		super();
		setValeur("expr_etoile");
	}

	@Override
	public void initPremier(ArrayList<Token> listeToken) {

		premiers.add(Outils.getEpsilon(listeToken));
		
		premiers.add(Outils.getVirgule(listeToken));
	}

	@Override
	public void initSuivant(ArrayList<Token> listeToken) {
		suivants.add(Outils.getParentheseFermante(listeToken));
		suivants.add(Outils.getCrochetFermant(listeToken));
	}
	
	@Override
	public Expr_etoile copie() {
		Expr_etoile expr_etoile = new Expr_etoile();
		expr_etoile.setValeur(this.getValeur());
		return expr_etoile;
	}

	
}
