package NonTerminal;

import java.util.ArrayList;

import Outils.Outils;
import Token.Token;

public class Stmt_etoile extends NonTerminal{
	
	public Stmt_etoile() {
		super();
		setValeur("stmt_etoile");
	}

	@Override
	public void initPremier(ArrayList<Token> listeToken) {
		premiers.add(Outils.getEpsilon(listeToken));
		
		premiers.add(Outils.getIdent(listeToken));
		premiers.add(Outils.getParentheseOuvrante(listeToken));
		premiers.add(Outils.getIf(listeToken));
		premiers.add(Outils.getFor(listeToken));
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

		suivants.add(Outils.getEOF(listeToken));
		suivants.add(Outils.getEND(listeToken));
	}
	
	@Override
	public Stmt_etoile copie() {
		Stmt_etoile stmt_etoile = new Stmt_etoile();
		stmt_etoile.setValeur(this.getValeur());
		return stmt_etoile;
	}
}
