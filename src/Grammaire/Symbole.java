package Grammaire;

import java.util.ArrayList;

import Token.Token;

/**
 * Base class of every grammar symbol, terminal or not.
 *
 * <p>A symbol carries its own FIRST and FOLLOW sets, and reports its name as its
 * simple class name, which is also the key used in the LL(1) table.
 */
public abstract class Symbole {
    public ArrayList<Token> premiers;
    public ArrayList<Token> suivants;

    public Symbole() {
        premiers = new ArrayList<>();
        suivants = new ArrayList<>();
    }

    public abstract boolean isTerminal();

    

	public String getNom() {
		return getClass().getSimpleName();
	}
	
	

    public ArrayList<Token> getPremiers() {
        return premiers;
    }

    public ArrayList<Token> getSuivants() {
        return suivants;
    }

    public void afficherPremiers() {
        for (Token t : premiers) {
            if(t.isTerminal()) {
                t.afficherToken();
            } else {
                t.afficherPremiers();
            }
        }
    }

    public void afficherSuivants() {
        for (Token t : suivants) {
            if(t.isTerminal()) {
                t.afficherToken();
            } else {
                t.afficherSuivants();
            }
        }
    }


	public String toString() {
		return getNom();
	}
	

	public abstract Symbole copie();
	
	
    
}
