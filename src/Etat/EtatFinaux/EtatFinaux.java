package Etat.EtatFinaux;

import java.io.IOException;

import Etat.Etat;
import Token.Token;

/**
 * An accepting state: the lexeme is complete and {@link #creationToken} turns
 * the buffered characters into a {@link Token}.
 */
public abstract class EtatFinaux extends Etat{

	public EtatFinaux() {
		super();
	}


	public abstract Token creationToken() throws IOException ;
}
