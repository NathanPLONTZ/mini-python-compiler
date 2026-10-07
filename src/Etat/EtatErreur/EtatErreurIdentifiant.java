package Etat.EtatErreur;

import java.io.IOException;

import Outils.Buffer;
import Outils.Outils;
import Token.ErreurIdentifiant;
import Token.Token;

public class EtatErreurIdentifiant extends EtatErreur{
	

	public static final String ERREURIDENTIFIANTID = "ERREURIDENTIFIANT";
	
	public EtatErreurIdentifiant() {
		super();
		setNomEtat(ERREURIDENTIFIANTID);
	}

	@Override
	public Token creationToken() throws IOException {
		char c = Buffer.readChar();
		if(!Buffer.endOfFile()) {// not at end of file yet
			Buffer.getBuffer().add(c);
			while (!Outils.isValideApresIdentifiant(c)){// keep consuming until the lexeme ends
				c=Buffer.readChar();
				
				if (Buffer.endOfFile()) {// end of file reached
					String token = Buffer.bufferToString();
					Buffer.clearBuffer();
					ErreurIdentifiant erreur = new ErreurIdentifiant(Buffer.getNumLigne());
					erreur.setValeur(token);
					return erreur;
				}
				
				Buffer.getBuffer().add(c);
			}
			
			Buffer.moveBack();
			Buffer.removeLast();
			String token = Buffer.bufferToString();
			Buffer.clearBuffer();
			ErreurIdentifiant erreur = new ErreurIdentifiant(Buffer.getNumLigne());
			erreur.setValeur(token);
			return erreur;
		}else {
			String token = Buffer.bufferToString();
			Buffer.clearBuffer();
			ErreurIdentifiant erreur = new ErreurIdentifiant(Buffer.getNumLigne());
			erreur.setValeur(token);
			return erreur;
		}
	}

}
