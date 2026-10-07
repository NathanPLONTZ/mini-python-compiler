package Etat.EtatErreur;

import java.io.IOException;

import Outils.Buffer;
import Outils.Outils;
import Token.ErreurDivision;
import Token.Token;

public class EtatErreurDivision extends EtatErreur{
	
	public static final String ERREURDIVISIONID = "ERREURDIVISION";
	
	public EtatErreurDivision () {
		super();
		setNomEtat(ERREURDIVISIONID);
	}

	@Override
	public Token creationToken() throws IOException {
		char c = Buffer.readChar();
		
		if(!Buffer.endOfFile()) {// not at end of file yet
			Buffer.getBuffer().add(c);
			while (!Outils.isValideApresDivision(c) ){
				c=Buffer.readChar();
				
				if (Buffer.endOfFile()) {// end of file reached
					String token = Buffer.bufferToString();
					Buffer.clearBuffer();
					ErreurDivision erreur = new ErreurDivision(Buffer.getNumLigne());
					erreur.setValeur(token);
					return erreur;
				}
				
				Buffer.getBuffer().add(c);
			}
			
			Buffer.moveBack();
			Buffer.removeLast();
			String token = Buffer.bufferToString();
			Buffer.clearBuffer();
			ErreurDivision erreur = new ErreurDivision(Buffer.getNumLigne());
			erreur.setValeur(token);
			return erreur;
		}else {
			String token = Buffer.bufferToString();
			Buffer.clearBuffer();
			ErreurDivision erreur = new ErreurDivision(Buffer.getNumLigne());
			erreur.setValeur(token);
			return erreur;
		}
	}

}
