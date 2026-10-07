package Automate;

import Etat.Etat;
import Etat.EtatFinaux.EtatFinauxCommentaire;
import Etat.EtatFinaux.EtatFinauxInt;
import Etat.EtatFinaux.EtatFinauxEspace;
import Etat.EtatFinaux.EtatFinauxIdfKey;
import Etat.EtatFinaux.EtatFinauxNouvelleLigne;
import Etat.EtatFinaux.EtatFinauxOperateur;
import Etat.EtatFinaux.EtatFinauxPonctuation;
import Etat.EtatFinaux.EtatFinauxStr;
import Etat.EtatIntermediaire.EtatGuillemet;
import Etat.EtatIntermediaire.EtatHashtag;
import Etat.EtatIntermediaire.EtatIdentifiant;
import Etat.EtatIntermediaire.EtatInegalEgal;
import Etat.EtatIntermediaire.EtatInegalEgal2;
import Etat.EtatIntermediaire.EtatInitial;
import Etat.EtatIntermediaire.EtatInteger;
import Etat.EtatIntermediaire.EtatMultPourcent;
import Etat.EtatIntermediaire.EtatPlusMoins;
import Etat.EtatIntermediaire.EtatPointExclamation;
import Etat.EtatIntermediaire.EtatPointExclamation2;
import Etat.EtatIntermediaire.EtatSlash;
import Etat.EtatIntermediaire.EtatSlash2;
import Etat.EtatIntermediaire.EtatWindows;
import Etat.EtatIntermediaire.EtatZero;
import Etat.EtatIntermediaire.EtatPonctuation0;
import Etat.EtatIntermediaire.EtatPonctuation1;
import Etat.EtatIntermediaire.EtatPonctuation2;
import Etat.EtatIntermediaire.EtatPonctuation3;
import Etat.EtatIntermediaire.EtatPonctuation4;
import Etat.EtatIntermediaire.EtatPonctuation5;

/**
 * The lexer's finite automaton, wired once in the constructor.
 *
 * <p>This is the State pattern: every state is an {@link Etat} object that
 * knows its own successors. Intermediate states decide where to go for a given
 * character, final states build a token, and error states consume the rest of
 * the faulty lexeme so that the scan can carry on.
 */
public class Automate {
	
	private EtatInitial etatInitial;
	private Etat etatCourant;

	public Automate() {
		etatInitial = new EtatInitial();
		etatCourant = etatInitial;
		
		EtatInteger etatInteger = new EtatInteger();
		EtatZero etatZero = new EtatZero();
		EtatFinauxInt etatInt = new EtatFinauxInt();
		EtatFinauxStr etatStr = new EtatFinauxStr();
		EtatIdentifiant etatIdentifiant = new EtatIdentifiant();
		EtatFinauxIdfKey etatIdfKey = new EtatFinauxIdfKey();
		EtatGuillemet etatGuillemet = new EtatGuillemet();
		EtatPonctuation0 etatPonctuation0 = new EtatPonctuation0();
		EtatPonctuation1 etatPonctuation1 = new EtatPonctuation1();
		EtatPonctuation2 etatPonctuation2 = new EtatPonctuation2();
		EtatPonctuation3 etatPonctuation3 = new EtatPonctuation3();
		EtatPonctuation4 etatPonctuation4 = new EtatPonctuation4();
		EtatPonctuation5 etatPonctuation5 = new EtatPonctuation5();
		EtatFinauxPonctuation etatPonctuation = new EtatFinauxPonctuation();
		EtatFinauxOperateur etatOperateur = new EtatFinauxOperateur();
		EtatPlusMoins etatPlusMoins = new EtatPlusMoins();
		EtatMultPourcent etatMultPourcent = new EtatMultPourcent();
		EtatSlash etatSlash = new EtatSlash();
		EtatSlash2 etatSlash2 = new EtatSlash2();
		EtatPointExclamation etatPointExclamation = new EtatPointExclamation();
		EtatPointExclamation2 etatPointExclamation2 = new EtatPointExclamation2();
		EtatInegalEgal etatInegalEgal = new EtatInegalEgal();
		EtatInegalEgal2 etatInegalEgal2 = new EtatInegalEgal2();
		EtatFinauxEspace etatEspace = new EtatFinauxEspace();
		EtatFinauxNouvelleLigne etatNouvelligne = new EtatFinauxNouvelleLigne();
		EtatWindows etatWindows = new EtatWindows();
		EtatHashtag etatHashtag = new EtatHashtag();
		EtatFinauxCommentaire etatCommentaire = new EtatFinauxCommentaire();
		
		etatInitial.addEtatSuivant(etatInteger);
		etatInitial.addEtatSuivant(etatZero);
		etatInitial.addEtatSuivant(etatIdentifiant);
		etatInitial.addEtatSuivant(etatGuillemet);
		etatInitial.addEtatSuivant(etatPonctuation0);
		etatInitial.addEtatSuivant(etatPonctuation1);
		etatInitial.addEtatSuivant(etatPonctuation2);
		etatInitial.addEtatSuivant(etatPonctuation3);
		etatInitial.addEtatSuivant(etatPonctuation4);
		etatInitial.addEtatSuivant(etatPonctuation5);
		etatInitial.addEtatSuivant(etatPlusMoins);
		etatInitial.addEtatSuivant(etatMultPourcent);
		etatInitial.addEtatSuivant(etatSlash);
		etatInitial.addEtatSuivant(etatPointExclamation);
		etatInitial.addEtatSuivant(etatInegalEgal);
		etatInitial.addEtatSuivant(etatEspace);
		etatInitial.addEtatSuivant(etatNouvelligne);
		etatInitial.addEtatSuivant(etatWindows);
		etatInitial.addEtatSuivant(etatHashtag);
		
		etatInteger.addEtatSuivant(etatInt);
		etatZero.addEtatSuivant(etatInt);
		etatIdentifiant.addEtatSuivant(etatIdfKey);
		etatGuillemet.addEtatSuivant(etatStr);
		etatPonctuation0.addEtatSuivant(etatPonctuation);
		etatPonctuation1.addEtatSuivant(etatPonctuation);
		etatPonctuation2.addEtatSuivant(etatPonctuation);
		etatPonctuation3.addEtatSuivant(etatPonctuation);
		etatPonctuation4.addEtatSuivant(etatPonctuation);
		etatPonctuation5.addEtatSuivant(etatPonctuation);
		etatPlusMoins.addEtatSuivant(etatOperateur);
		etatMultPourcent.addEtatSuivant(etatOperateur);
		etatSlash.addEtatSuivant(etatSlash2);
		etatSlash2.addEtatSuivant(etatOperateur);
		etatPointExclamation.addEtatSuivant(etatPointExclamation2);
		etatPointExclamation2.addEtatSuivant(etatOperateur);
		etatInegalEgal.addEtatSuivant(etatOperateur);
		etatInegalEgal.addEtatSuivant(etatInegalEgal2);
		etatInegalEgal2.addEtatSuivant(etatOperateur);
		etatWindows.addEtatSuivant(etatNouvelligne);
		etatHashtag.addEtatSuivant(etatCommentaire);
		
		
		
	}
	
	public Etat getEtatCourant(){
        return etatCourant;
    }
	
	public EtatInitial getEtatInitial() {
		return etatInitial;
	}
	
	public void setEtatCourant(Etat etat) {
		etatCourant = etat;
	}
	
}
