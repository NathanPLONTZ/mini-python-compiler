package Etat.EtatFinaux;

import java.io.IOException;

import Outils.Buffer;
import Token.Str;
import Token.Token;

public class EtatFinauxStr extends EtatFinaux{

	public static final String STRID = "STR";
	
	public EtatFinauxStr() {
		super();
		setNomEtat(STRID);
	}

	@Override
	public Token creationToken() throws IOException {
		String token = Buffer.bufferToString();
		Buffer.clearBuffer();
		return new Str(token);
	}
}
