package Etat.EtatErreur;

import java.io.IOException;

import Outils.Buffer;
import Outils.Outils;
import Token.ErreurInt;
import Token.Token;

public class EtatErreurInt extends EtatErreur{
	
	public static final String ERREURINTID = "ERREURINT";
	
	public EtatErreurInt() {
		super();
		setNomEtat(ERREURINTID);
	}

	@Override
	public Token creationToken() throws IOException {
		char c = Buffer.readChar();
		if(!Buffer.endOfFile()) {// not at end of file yet
            Buffer.getBuffer().add(c);
            while (!Outils.isValideApresInteger(c)){// keep consuming until the lexeme ends
                c=Buffer.readChar();
                
                if (Buffer.endOfFile()) {// end of file reached
                    String token = Buffer.bufferToString();
                    Buffer.clearBuffer();
                    ErreurInt erreur = new ErreurInt(Buffer.getNumLigne());
                    erreur.setValeur(token);
                    return erreur;
                }
                
                Buffer.getBuffer().add(c);
            }
		}   
         Buffer.moveBack();
         Buffer.removeLast();
         String token = Buffer.bufferToString();
         Buffer.clearBuffer();
         ErreurInt erreur = new ErreurInt(Buffer.getNumLigne());
         erreur.setValeur(token);
         return erreur;
	}

}