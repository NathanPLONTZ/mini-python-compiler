package Etat.EtatErreur;

import java.io.IOException;

import Outils.Buffer;
import Outils.Outils;
import Token.ErreurPonctuation;
import Token.Token;

public class EtatErreurPonctuation5 extends EtatErreur{
	
	public static final String ERREURPONCTUATION5ID = "ERREURPONCTUATION5";
	
	public EtatErreurPonctuation5() {
		super();
		setNomEtat(ERREURPONCTUATION5ID);
	}

	@Override
	public Token creationToken() throws IOException {
		char c = Buffer.readChar();
		
		if(!Buffer.endOfFile()) {// not at end of file yet
			Buffer.getBuffer().add(c);
			while (!Outils.isValideApresPonctuation5(c) ){
				c=Buffer.readChar();
				
				if (Buffer.endOfFile()) {// end of file reached
					String token = Buffer.bufferToString();
					Buffer.clearBuffer();
					ErreurPonctuation erreur = new ErreurPonctuation(Buffer.getNumLigne());
					erreur.setValeur(token);
					return erreur;
				}
				
				Buffer.getBuffer().add(c);
			}
			
			Buffer.moveBack();
			Buffer.removeLast();
			String token = Buffer.bufferToString();
			Buffer.clearBuffer();
			ErreurPonctuation erreur = new ErreurPonctuation(Buffer.getNumLigne());
			erreur.setValeur(token);
			return erreur;
		}else {
			String token = Buffer.bufferToString();
			Buffer.clearBuffer();
			ErreurPonctuation erreur = new ErreurPonctuation(Buffer.getNumLigne());
			erreur.setValeur(token);
			return erreur;
		}
	}

}
