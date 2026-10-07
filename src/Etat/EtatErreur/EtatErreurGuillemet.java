package Etat.EtatErreur;

import java.io.IOException;

import Outils.Buffer;
import Token.ErreurGuillemet;
import Token.Token;

public class EtatErreurGuillemet extends EtatErreur{
	
	public static final String ERREURGUILLEMETID = "ERREURGUILLEMET";
	
	public EtatErreurGuillemet () {
		super();
		setNomEtat(ERREURGUILLEMETID);
	}

	@Override
	public Token creationToken() throws IOException {
		Buffer.moveBack();
		Buffer.removeLast();
		String token = Buffer.bufferToString();
		Buffer.clearBuffer();
		ErreurGuillemet erreur = new ErreurGuillemet(Buffer.getNumLigne());
		erreur.setValeur(token);
		return erreur;
		
	}

}