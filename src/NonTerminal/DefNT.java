package NonTerminal;

import java.util.ArrayList;

import Outils.Outils;
import Token.Token;

public class DefNT extends NonTerminal{
	
	public DefNT() {
		super();
		setValeur("defNT");
	}

	@Override
	public void initPremier(ArrayList<Token> listeToken) {
		premiers.add(Outils.getDef(listeToken));
	}

	@Override
	public void initSuivant(ArrayList<Token> listeToken) {

		suivants.add(Outils.getDef(listeToken));
		suivants.add(Outils.getIdent(listeToken));
		suivants.add(Outils.getParentheseOuvrante(listeToken));
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
	public DefNT copie() {
		DefNT defNT = new DefNT();
		defNT.setValeur(this.getValeur());
		return defNT;
	}
	
}