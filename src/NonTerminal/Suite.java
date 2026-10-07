package NonTerminal;

import java.util.ArrayList;

import Outils.Outils;
import Token.Token;

public class Suite extends NonTerminal{
	
	public Suite() {
		super();
		setValeur("suite");
	}

	@Override
	public void initPremier(ArrayList<Token> listeToken) {
		premiers.add(Outils.getNEWLINE(listeToken));
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
		suivants.add(Outils.getEOF(listeToken));
		suivants.add(Outils.getDef(listeToken));
		suivants.add(Outils.getIdent(listeToken));
		suivants.add(Outils.getParentheseOuvrante(listeToken));
		suivants.add(Outils.getEND(listeToken));
		suivants.add(Outils.getIf(listeToken));
		suivants.add(Outils.getFor(listeToken));
		suivants.add(Outils.getElse(listeToken));
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
	public Suite copie() {
		Suite suite = new Suite();
		suite.setValeur(this.getValeur());
		return suite;
	}
}