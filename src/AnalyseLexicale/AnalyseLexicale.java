package AnalyseLexicale;

import java.io.IOException;
import java.util.ArrayList;

import AnalyseSyntaxique.AnalyseSyntaxique;
import Automate.Automate;
import Etat.EtatFinaux.EtatFinaux;
import Etat.EtatIntermediaire.EtatIntermediaire;
import Outils.Buffer;
import Token.EOF;
import Token.Token;

/**
 * Lexical analyser: turns a Mini Python source file into a token stream.
 *
 * <p>The scan is driven by {@link Automate}, a hand-written finite automaton
 * that reads the file one character at a time through {@link Buffer}. Whenever
 * the automaton reaches a final state, that state builds the matching
 * {@link Token} and the automaton is reset to its initial state.
 *
 * <p>Once the whole file is consumed, a fixed sequence of post-passes turns the
 * raw stream into what the parser expects: comments are dropped, BEGIN / END
 * indentation tokens are inserted, lexical errors are reported, and redundant
 * blanks and newlines are removed before the final EOF is appended.
 */
public class AnalyseLexicale {
	
	public static ArrayList<Token> tokens = new ArrayList<Token>();
	

	public static ArrayList<Token> decoupageToken(String path) throws IOException {
		
		
		Buffer buffer = new Buffer(path);
		Automate automate = new Automate();
		buffer.setNumLigne(1);
		while (!Buffer.endOfFile() ) {
			if (automate.getEtatCourant() instanceof EtatIntermediaire) {
				char c = Buffer.readChar();
				Buffer.getBuffer().add(c);
				((EtatIntermediaire) automate.getEtatCourant()).action(c,automate);
				if (automate.getEtatCourant() instanceof EtatFinaux) {
					Token t= ((EtatFinaux) automate.getEtatCourant()).creationToken();
					t.setNumLigne(Buffer.getNumLigne());
					tokens.add(t);
					automate.setEtatCourant(automate.getEtatInitial());
				}
			} 
		}
		
		Token.removeComment(tokens);
		Token.addBeginEnd(tokens);
		AnalyseSyntaxique.erreurLexical=Token.afficherErreur(tokens);
		Token.removeSpacesBetweenNewlines(tokens);
		Token.removeSpace(tokens);
		Token.removeNewlineRedondant(tokens);
		tokens.add(new EOF());
		
			
		return tokens;
	}
	

	
	
}
