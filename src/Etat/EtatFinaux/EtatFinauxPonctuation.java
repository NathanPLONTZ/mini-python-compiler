package Etat.EtatFinaux;

import java.io.IOException;

import Outils.Buffer;
import Outils.Outils;
import Token.CrochetFermant;
import Token.CrochetOuvrant;
import Token.DeuxPoints;
import Token.ParentheseFermante;
import Token.ParentheseOuvrante;
import Token.Token;
import Token.Virgule;

public class EtatFinauxPonctuation extends EtatFinaux {
	
	public static final String PONCTUATIONID = "PONCTUATION";
	
	public EtatFinauxPonctuation() {
		super();
		setNomEtat(PONCTUATIONID);
	}

	@Override
	public Token creationToken() throws IOException {
		
		Buffer.moveBack();
		Buffer.removeLast();
		String token = Buffer.bufferToString();
		Buffer.clearBuffer();
		if (Outils.isParenthesisOpen(token)) {
			return new ParentheseOuvrante();
		} else if (Outils.isParenthesisClose(token)) {
			return new ParentheseFermante();
		}else if(Outils.isBracketOpen(token)) {
			return new CrochetOuvrant();
		}else if(Outils.isBracketClose(token)) {
            return new CrochetFermant();
		}else if(Outils.isColon(token)) {
            return new DeuxPoints();
		}else if(Outils.isComma(token)) {
            return new Virgule();
		}else {
			return null;
		}
	}
	

}