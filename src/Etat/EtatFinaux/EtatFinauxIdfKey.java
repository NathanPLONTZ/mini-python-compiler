package Etat.EtatFinaux;

import java.io.IOException;

import Outils.Buffer;
import Outils.Outils;
import Token.And;
import Token.Def;
import Token.Else;
import Token.False;
import Token.For;
import Token.Ident;
import Token.If;
import Token.In;
import Token.None;
import Token.Not;
import Token.Or;
import Token.Print;
import Token.Return;
import Token.Token;
import Token.True;

public class EtatFinauxIdfKey extends EtatFinaux{
	
	public static final String IDFKEYID="IDFKEY";

	public EtatFinauxIdfKey() {
		super();
		setNomEtat(IDFKEYID);
	}


	@Override
	public Token creationToken() throws IOException {
		Buffer.moveBack();
		Buffer.removeLast();
		String token = Buffer.bufferToString();
		Buffer.clearBuffer();
		
		if (Outils.isDef(token)) {
			return new Def();	
		}else if (Outils.isReturn(token)){
			return new Return();
		}else if (Outils.isPrint(token)){
            return new Print();
		}else if(Outils.isNot(token)){
            return new Not();
		}else if(Outils.isFor(token)){
            return new For();
		}else if(Outils.isIf(token)){
            return new If();
		}else if(Outils.isIn(token)){
            return new In();
		}else if(Outils.isElse(token)) {
			return new Else();
		}else if(Outils.isTrue(token)) {
            return new True();
		}else if(Outils.isFalse(token)) {
            return new False();
		}else if(Outils.isNone(token)) {
            return new None();
		}else if(Outils.isOr(token)) {
			return new Or();
		}else if(Outils.isAnd(token)) {
			return new And();
		}
		else {
			return new Ident(token);
		}
		
	}

}
