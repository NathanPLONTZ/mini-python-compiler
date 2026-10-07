package Etat.EtatFinaux;

import java.io.IOException;

import Outils.Buffer;
import Token.Commentaire;
import Token.Token;

public class EtatFinauxCommentaire extends EtatFinaux{
	
	public static final String COMMENTAIREID = "COMMENTAIRE";

	public EtatFinauxCommentaire() {
		super();
		setNomEtat(COMMENTAIREID);
	}

	@Override
	public Token creationToken() throws IOException {
		Buffer.moveBack();
		Buffer.removeLast();
		String token = Buffer.bufferToString();
		Buffer.clearBuffer();
		return new Commentaire(token);
	}
	
	

}
