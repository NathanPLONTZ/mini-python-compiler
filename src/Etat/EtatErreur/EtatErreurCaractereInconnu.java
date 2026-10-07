package Etat.EtatErreur;

import java.io.IOException;

import Outils.Buffer;
import Outils.Outils;
import Token.ErreurCaractereInconnu;
import Token.Token;

public class EtatErreurCaractereInconnu extends EtatErreur{
	

	public static final String ERREURCARACTEREINCONNUID = "ERREURCARACTEREINCONNU";
	
	public EtatErreurCaractereInconnu() {
		super();
		setNomEtat(ERREURCARACTEREINCONNUID);
	}

	@Override
	public Token creationToken() throws IOException {
		if(Outils.isSlash(Buffer.getBuffer().get(0)) || Outils.isExclamation(Buffer.getBuffer().get(0))) {
			Buffer.moveBack();
			Buffer.removeLast();
		}
		String token = Buffer.bufferToString();
		Buffer.clearBuffer();
		ErreurCaractereInconnu erreur = new ErreurCaractereInconnu(Buffer.getNumLigne());
		erreur.setValeur(token);
		return erreur;
	}

}
