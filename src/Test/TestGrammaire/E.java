package Test.TestGrammaire;

import java.util.ArrayList;

import Grammaire.Symbole;
import NonTerminal.NonTerminal;
import Token.Token;

public class E extends NonTerminal {
    public E() {
    }

    public boolean isTerminal() {
        return false;
    }

	@Override
	public void initPremier(ArrayList<Token> listeToken) {
		
	}

	@Override
	public void initSuivant(ArrayList<Token> listeToken) {
		
	}

	@Override
	public Symbole copie() {
		return new E();
	}

    

}