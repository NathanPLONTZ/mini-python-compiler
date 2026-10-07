package Etat.EtatErreur;

import java.io.IOException;

import Outils.Buffer;
import Outils.Outils;
import Token.ErreurOperateur;
import Token.Token;

public class EtatErreurOperateur extends EtatErreur{
	
	public static final String ERREUROPERATEURID = "ERREUROPERATEUR";
	
	public EtatErreurOperateur() {
		super();
		setNomEtat(ERREUROPERATEURID);
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
					ErreurOperateur erreur = new ErreurOperateur(Buffer.getNumLigne());
					erreur.setValeur(token);
					return erreur;
				}
				
				Buffer.getBuffer().add(c);
			}
			
			Buffer.moveBack();
			Buffer.removeLast();
			String token = Buffer.bufferToString();
			Buffer.clearBuffer();
			ErreurOperateur erreur = new ErreurOperateur(Buffer.getNumLigne());
			erreur.setValeur(token);
			return erreur;
		}else {
			String token = Buffer.bufferToString();
			Buffer.clearBuffer();
			ErreurOperateur erreur = new ErreurOperateur(Buffer.getNumLigne());
			erreur.setValeur(token);
			return erreur;
		}
	}

}
