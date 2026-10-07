package Etat.EtatErreur;

import java.io.IOException;

import Outils.Buffer;
import Outils.Outils;
import Token.ErreurInegalEgal;
import Token.Token;

public class EtatErreurInegalEgal extends EtatErreur{
	
	public static final String ERREURINEGALEGALID = "ERREURINEGALEGAL";
	
	public EtatErreurInegalEgal () {
		super();
		setNomEtat(ERREURINEGALEGALID);
	}

	@Override
	public Token creationToken() throws IOException {
		char c = Buffer.readChar();
		
		if(!Buffer.endOfFile()) {// not at end of file yet
			Buffer.getBuffer().add(c);
			while (!Outils.isValideApresInegalEgal(c) ){
				c=Buffer.readChar();
				
				if (Buffer.endOfFile()) {// end of file reached
					String token = Buffer.bufferToString();
					Buffer.clearBuffer();
					ErreurInegalEgal erreur = new ErreurInegalEgal(Buffer.getNumLigne());
					erreur.setValeur(token);
					return erreur;
				}
				
				Buffer.getBuffer().add(c);
			}
			
			Buffer.moveBack();
			Buffer.removeLast();
			String token = Buffer.bufferToString();
			Buffer.clearBuffer();
			ErreurInegalEgal erreur = new ErreurInegalEgal(Buffer.getNumLigne());
			erreur.setValeur(token);
			return erreur;
		}else {
			String token = Buffer.bufferToString();
			Buffer.clearBuffer();
			ErreurInegalEgal erreur = new ErreurInegalEgal(Buffer.getNumLigne());
			erreur.setValeur(token);
			return erreur;
		}
	}

}