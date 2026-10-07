package Etat.EtatFinaux;

import java.io.IOException;

import Outils.Buffer;
import Token.Int;
import Token.Token;

public class EtatFinauxInt extends EtatFinaux{
	
	public static final String INTID = "INT";

	public EtatFinauxInt() {
		super();
		setNomEtat(INTID);
	}

	@Override
	public Token creationToken() throws IOException {
			Buffer.moveBack();
			Buffer.removeLast();
			String token = Buffer.bufferToString();
			Buffer.clearBuffer();
			return new Int(token);
	}
}
