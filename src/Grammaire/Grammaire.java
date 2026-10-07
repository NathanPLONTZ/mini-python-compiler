package Grammaire;

import java.util.ArrayList;

import NonTerminal.NonTerminal;
import Outils.Outils;
import Token.Token;

/**
 * The Mini Python grammar, built in code rather than read from a file.
 *
 * <p>The default constructor instantiates every terminal and non-terminal,
 * computes their FIRST and FOLLOW sets, builds the productions and designates
 * {@code file} as the axiom.
 */
public class Grammaire {

    private NonTerminal axiome;
    private ArrayList<NonTerminal> nonTerminaux;  
    private ArrayList<Token> terminaux;           
    private ArrayList<Regle> regles;
    
    public Grammaire() {
        this.nonTerminaux = NonTerminal.initNonTerminal();
        this.terminaux = Token.initToken();  
        
        for(NonTerminal tmp : nonTerminaux) {
			tmp.initPremier(terminaux);
			tmp.initSuivant(terminaux);
		}
		
        this.regles = Regle.initRegle(nonTerminaux,terminaux);
        this.axiome = Outils.getFile(nonTerminaux);
    }

    // Secondary constructor, used only by the TestGrammaire toy grammar.
    public Grammaire(NonTerminal axiome, ArrayList<Regle> regles) {
        this.axiome = axiome;
        this.regles = regles;
        this.nonTerminaux = new ArrayList<>(); 
        this.terminaux = new ArrayList<>();     
        
        for (Regle regle : regles) {
			if (!nonTerminaux.contains(regle.getPartieGauche())) {
				nonTerminaux.add(regle.getPartieGauche());
			}else {
				for (Symbole symbole : regle.getPartieDroite()) {
					if (symbole.isTerminal() && !terminaux.contains(symbole)) {
						terminaux.add((Token) symbole);
					}
					if (!symbole.isTerminal() && !nonTerminaux.contains(symbole)) {
						nonTerminaux.add((NonTerminal) symbole);
					}
				}
			}
        	
       }
    }

    public NonTerminal getAxiome() {
        return axiome;
    }

    public ArrayList<Regle> getRegles() {
        return regles;
    }

    public ArrayList<NonTerminal> getNonTerminaux() {
        return nonTerminaux;
    }

    public ArrayList<Token> getTerminaux() {
        return terminaux;
    }
}
