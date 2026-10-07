package Etat.EtatFinaux;

import java.io.IOException;

import Outils.Buffer;
import Token.Div;
import Token.Egal;
import Token.EgalBool;
import Token.Inf;
import Token.InfEgal;
import Token.Moins;
import Token.Mult;
import Token.NotEgal;
import Token.Plus;
import Token.Pourcent;
import Token.Sup;
import Token.SupEgal;
import Token.Token;

public class EtatFinauxOperateur extends EtatFinaux {
	
	public static final String OPERATEURID = "OPERATEUR";
	
	public EtatFinauxOperateur() {
		super();
		setNomEtat(OPERATEURID);
	}

	@Override
	public Token creationToken() throws IOException {
		
		Buffer.moveBack();
		Buffer.removeLast();
		String token = Buffer.bufferToString();
		Buffer.clearBuffer();
		if(token.equals("+")) {
			Buffer.clearBuffer();
            return new Plus();
		}else if(token.equals("-")) {
			Buffer.clearBuffer();
			return new Moins();
		}else if(token.equals("*")) {
			Buffer.clearBuffer();
			return new Mult();
		}else if(token.equals("//")) {
			Buffer.clearBuffer();
			return new Div();
		}else if(token.equals("%")) {
			Buffer.clearBuffer();
			return new Pourcent();
		}else if(token.equals("==")) {
			Buffer.clearBuffer();
			return new EgalBool();
		}else if(token.equals("!=")) {
			Buffer.clearBuffer();
			return new NotEgal();
		}else if(token.equals("<=")) {
			Buffer.clearBuffer();
			return new InfEgal();
		}else if(token.equals(">=")) {
			Buffer.clearBuffer();
			return new SupEgal();
		}else if(token.equals("<")) {
				return new Inf();
		}else if(token.equals(">")) {
				return new Sup();
		}else if(token.equals("=")) {
				return new Egal();
		}
		System.out.println("Erreur dans la création du token OPERATEUR");
		return null;
	}
	

}
