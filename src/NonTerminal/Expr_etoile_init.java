package NonTerminal;

import java.util.ArrayList;

import Outils.Outils;
import Token.Token;

public class Expr_etoile_init extends NonTerminal{
	
	public Expr_etoile_init() {
		super();
		setValeur("expr_etoile_init");
	}

	@Override
	public void initPremier(ArrayList<Token> listeToken) {

		premiers.add(Outils.getEpsilon(listeToken));
		
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
		suivants.add(Outils.getParentheseFermante(listeToken));
		suivants.add(Outils.getCrochetFermant(listeToken));
	}
	
	@Override
	public Expr_etoile_init copie() {
		Expr_etoile_init expr_etoile_init = new Expr_etoile_init();
		expr_etoile_init.setValeur(this.getValeur());
		return expr_etoile_init;
	}

	
}
