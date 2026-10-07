package Grammaire;

import java.io.IOException;
import java.util.ArrayList;

import NonTerminal.NonTerminal;
import Token.Token;

public class TestPremierSuivantRegle {

	public static void main(String[] args) throws IOException {
		
		ArrayList<NonTerminal> nt = NonTerminal.initNonTerminal();
		ArrayList<Token> t = Token.initToken();
		
		for(NonTerminal tmp : nt) {
			tmp.initPremier(t);
			tmp.initSuivant(t);
		}
		
		for(NonTerminal tmp : nt) {
			System.out.println("///////////");
			System.out.println(tmp.getValeur());
			System.out.print("Premier:");
			tmp.afficherPremiers();
			System.out.print("Suivant:");
			tmp.afficherSuivants();
		}
		
		ArrayList<Regle> r= Regle.initRegle(nt,t);
		for(Regle rr : r)
			rr.afficherRegle();
		
		
	}

}
