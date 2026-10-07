package NonTerminal;

import java.util.ArrayList;

import Outils.Outils;
import Token.Token;

public class ElseNT extends NonTerminal{
	
	public ElseNT() {
		super();
		setValeur("elseNT");
	}

	@Override
	public void initPremier(ArrayList<Token> listeToken) {

		premiers.add(Outils.getEpsilon(listeToken));
		
		premiers.add(Outils.getElse(listeToken));
		
	}

	@Override
	public void initSuivant(ArrayList<Token> listeToken) {
		suivants.add(Outils.getEOF(listeToken));
		suivants.add(Outils.getIdent(listeToken));
		suivants.add(Outils.getParentheseOuvrante(listeToken));
		suivants.add(Outils.getEND(listeToken));
		suivants.add(Outils.getIf(listeToken));
		suivants.add(Outils.getFor(listeToken));
		suivants.add(Outils.getReturn(listeToken));
		suivants.add(Outils.getPrint(listeToken));
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
	public ElseNT copie() {
		ElseNT elseNT = new ElseNT();
		elseNT.setValeur(this.getValeur());
		return elseNT;
	}

	
}
