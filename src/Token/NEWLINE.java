package Token;

import Outils.Buffer;

public class NEWLINE extends Token{

	public NEWLINE() {
		super();
		this.setValeur("NEWLINE");
		Buffer.incNumLigne();
	}
	
	@Override
	public NEWLINE copie() {
		NEWLINE nw = new NEWLINE();
		nw.setValeur(this.getValeur());
		nw.setNumLigne(this.getNumLigne());
		return nw;
	}

}

