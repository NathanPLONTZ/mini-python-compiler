package Etat.EtatIntermediaire;

import Automate.Automate;
import Etat.EtatErreur.EtatErreurCaractereInconnu;
import Etat.EtatFinaux.EtatFinauxEspace;
import Etat.EtatFinaux.EtatFinauxNouvelleLigne;
import Outils.Outils;

public class EtatInitial extends EtatIntermediaire {
	
	public EtatInitial() {
		super();
		setNomEtat("INIT");
	}

	@Override
	public void action(char c, Automate automate) {
		if( Outils.isAlpha(c) || Outils.isUnderscore(c)) 
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatIdentifiant.IDFID));
		else if(Outils.isZero(c))
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatZero.ZEROID));
		else if(Outils.isDigit(c))
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatInteger.INTEGERID));
		else if(Outils.isQuote(c))
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatGuillemet.GUILLEMETID));
		else if(Outils.isPonctuation0(c)) 
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatPonctuation0.PONCTUATION0ID));
		else if(Outils.isPonctuation1(c))
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatPonctuation1.PONCTUATION1ID));
		else if(Outils.isPonctuation2(c))
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatPonctuation2.PONCTUATION2ID));
		else if(Outils.isPonctuation3(c))
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatPonctuation3.PONCTUATION3ID));
		else if(Outils.isPonctuation4(c))
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatPonctuation4.PONCTUATION4ID));
		else if(Outils.isPonctuation5(c))
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatPonctuation5.PONCTUATION5ID));
		else if(Outils.isPlusMoins(c))
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatPlusMoins.PLUSMOINSID));
		else if(Outils.isMultPourcent(c))
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatMultPourcent.MULTPOURCENTID));
		else if(Outils.isSlash(c))
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatSlash.SLASHID));
		else if(Outils.isExclamation(c))
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatPointExclamation.POINT_EXCLAMATIONID));
		else if(Outils.isInegalEgal(c)) 
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatInegalEgal.INEGAL_EGALID));
		else if(Outils.isSpace(c)) 
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatFinauxEspace.SPACEID));
		else if(Outils.isNewLineLinux(c))
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatFinauxNouvelleLigne.NEWLINEID));
		else if(Outils.isNewLineWindows(c))
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatWindows.WINDOWSID));
		else if(Outils.isHashtag(c))
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatHashtag.HASHTAGID));
		else
			automate.setEtatCourant(new EtatErreurCaractereInconnu());
			
			
			
	}
	
}


