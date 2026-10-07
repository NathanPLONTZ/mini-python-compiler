package Etat.EtatFinaux;

import Outils.Buffer;
import Token.SPACE;
import Token.Token;

public class EtatFinauxEspace  extends EtatFinaux{
	
	public static final String SPACEID = "SPACE";

	public EtatFinauxEspace() {
		super();
		setNomEtat(SPACEID);
	}


	@Override
	public Token creationToken() {
		String token = Buffer.bufferToString();
		Buffer.clearBuffer();
		return new SPACE();
	}

}

