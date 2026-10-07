package Test.TestGrammaire;

import Grammaire.Symbole;
import NonTerminal.NonTerminal;

import java.util.ArrayList;

import Token.Token;

public class T extends NonTerminal {
   

    public T() {
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
		return new T();
	}
 
	

    
}