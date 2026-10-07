package Etat.EtatFinaux;

import Outils.Buffer;
import Token.NEWLINE;
import Token.Token;

public class EtatFinauxNouvelleLigne extends EtatFinaux {
	
	public static final String NEWLINEID = "NEWLINE";
	
	public EtatFinauxNouvelleLigne() {
		super();
		setNomEtat(NEWLINEID);
	}

	@Override
	public Token creationToken() {
		String token = Buffer.bufferToString();
		Buffer.clearBuffer();
		return new NEWLINE();
	}
	

}