package Test.TestGrammaire;

import java.util.ArrayList;

import Grammaire.Grammaire;
import Grammaire.Regle;
import Token.Dollar;
import Token.Epsilon;
import Token.Ident;
import Token.Int;
import Token.Moins;
import Token.Plus;
import Token.Token;

public class TestGrammaire {

	public static void main(String[] args) {
		E E = new E();
		Eprime Eprime = new Eprime();
		T T = new T();
		Ident idf = new Ident("id");
		Int constante = new Int("const");
		Plus plus = new Plus();
		Moins moins = new Moins();
		Epsilon epsilon = new Epsilon();
		Dollar dollar = new Dollar();
		
		E.premiers.add(idf);
		E.premiers.add(constante);
		
		E.suivants.add(dollar);
		
		Eprime.premiers.add(plus);
		Eprime.premiers.add(moins);
		Eprime.premiers.add(epsilon);
		
		Eprime.suivants.add(dollar);
		
		T.premiers.add(idf);
		T.premiers.add(constante);
		
		T.suivants.add(plus);
		T.suivants.add(moins);
		T.suivants.add(dollar);
		
		Regle r1 = new Regle(E);
		r1.addPartieDroite(T);
		r1.addPartieDroite(Eprime);
		
		Regle r2 = new Regle(Eprime);
		r2.addPartieDroite(plus);
		r2.addPartieDroite(T);
		r2.addPartieDroite(Eprime);
		
		Regle r3 = new Regle(Eprime);
		r3.addPartieDroite(moins);
		r3.addPartieDroite(T);
		r3.addPartieDroite(Eprime);
		
		Regle r4 = new Regle(Eprime);
		r4.addPartieDroite(epsilon);
		
		Regle r5 = new Regle(T);
		r5.addPartieDroite(idf);
		
		Regle r6 = new Regle(T);
		r6.addPartieDroite(constante);
		
		ArrayList<Regle> regles = new ArrayList<Regle>();
		regles.add(r1);
		regles.add(r2);
		regles.add(r3);
		regles.add(r4);
		regles.add(r5);
		regles.add(r6);
		
		Grammaire g = new Grammaire(E, regles);
		
		ArrayList<Token> mot = new ArrayList<Token>();
		mot.add(idf);
		mot.add(plus);
		mot.add(constante);
		mot.add(plus);
		mot.add(constante);
		mot.add(dollar);
		
	}

}
