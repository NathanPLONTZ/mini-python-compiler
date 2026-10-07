package NonTerminal;

import java.util.ArrayList;

import Outils.Outils;
import Token.Token;

public class Simple_stmt extends NonTerminal{
	
	public Simple_stmt() {
		super();
		setValeur("simple_stmt");
	}

	@Override
	public void initPremier(ArrayList<Token> listeToken) {
		premiers.add(Outils.getIdent(listeToken));
		premiers.add(Outils.getParentheseOuvrante(listeToken));
		premiers.add(Outils.getReturn(listeToken));
		premiers.add(Outils.getPrint(listeToken));
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
		suivants.add(Outils.getNEWLINE(listeToken));
		
	}
	
	@Override
	public Simple_stmt copie() {
		Simple_stmt simple_stmt = new Simple_stmt();
		simple_stmt.setValeur(this.getValeur());
		return simple_stmt;
	}

	
}