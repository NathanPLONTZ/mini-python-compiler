package Etat.EtatErreur;

import java.io.IOException;

import Outils.Buffer;
import Outils.Outils;
import Token.ErreurNot;
import Token.Token;

public class EtatErreurNot extends EtatErreur{
	
	public static final String ERREURNOTID = "ERREURNOT";
	
	public EtatErreurNot () {
		super();
		setNomEtat(ERREURNOTID);
	}

	@Override
	public Token creationToken() throws IOException {
		char c = Buffer.readChar();
		
		if(!Buffer.endOfFile()) {// not at end of file yet
			Buffer.getBuffer().add(c);
			while (!Outils.isValideApresNot(c) ){
				c=Buffer.readChar();
				
				if (Buffer.endOfFile()) {// end of file reached
					String token = Buffer.bufferToString();
					Buffer.clearBuffer();
					ErreurNot erreur = new ErreurNot(Buffer.getNumLigne());
					erreur.setValeur(token);
					return erreur;
				}
				
				Buffer.getBuffer().add(c);
			}
			
			Buffer.moveBack();
			Buffer.removeLast();
			String token = Buffer.bufferToString();
			Buffer.clearBuffer();
			ErreurNot erreur = new ErreurNot(Buffer.getNumLigne());
			erreur.setValeur(token);
			return erreur;
		}else {
			String token = Buffer.bufferToString();
			Buffer.clearBuffer();
			ErreurNot erreur = new ErreurNot(Buffer.getNumLigne());
			erreur.setValeur(token);
			return erreur;
		}
	}

}
