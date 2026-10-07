package Etat.EtatErreur;

import java.io.IOException;

import Outils.Buffer;
import Outils.Outils;
import Token.ErreurPonctuation;
import Token.Token;

public class EtatErreurPonctuation0 extends EtatErreur{
	
	public static final String ERREURPONCTUATION0ID = "ERREURPONCTUATION0";
	
	public EtatErreurPonctuation0() {
		super();
		setNomEtat(ERREURPONCTUATION0ID);
	}

	@Override
	public Token creationToken() throws IOException {
		char c = Buffer.readChar();
		
		if(Outils.isNewLineLinux(c) || Outils.isNewLineWindows(c)) {// keep newlines out of the reported lexeme
			Buffer.moveBack();
			String token = Buffer.bufferToString();
			Buffer.clearBuffer();
			ErreurPonctuation erreur = new ErreurPonctuation(Buffer.getNumLigne());
			erreur.setValeur(token);
			return erreur;	
		}
		
		if(!Buffer.endOfFile()) {// not at end of file yet
			Buffer.getBuffer().add(c);
			while (!Outils.isValideApresPonctuation0(c) ){
				c=Buffer.readChar();
				if(Outils.isNewLineLinux(c) || Outils.isNewLineWindows(c)) {// keep newlines out of the reported lexeme
					Buffer.getBuffer().add(c);
					break;
				}
				
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
