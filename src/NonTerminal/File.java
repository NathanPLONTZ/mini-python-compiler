package NonTerminal;

import java.util.ArrayList;

import Outils.Outils;
import Token.Token;

public class File extends NonTerminal{
	
	public File() {
		super();
		setValeur("file");
	}

	@Override
	public void initPremier(ArrayList<Token> listeToken) {
		premiers.add(Outils.getNEWLINE(listeToken));
		premiers.add(Outils.getDef(listeToken));
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
	}

	@Override
	public File copie() {
		File file = new File();
		file.setValeur(this.getValeur());
		return file;
	}
	
}
