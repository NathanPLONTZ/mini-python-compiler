package Etat.EtatIntermediaire;

import Automate.Automate;
import Etat.EtatErreur.EtatErreurDivision;
import Etat.EtatFinaux.EtatFinauxOperateur;
import Outils.Outils;

public class EtatSlash2  extends EtatIntermediaire{
	
	public final static String SLASH2ID = "SLASH";

	public EtatSlash2() {
		super();
		setNomEtat(SLASH2ID);
		this.addEtatSuivant(new EtatErreurDivision());
	}

	@Override
	public void action(char c, Automate automate) {
		if(Outils.isValideApresDivision(c)) 
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatFinauxOperateur.OPERATEURID));
		else
        	automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatErreurDivision.ERREURDIVISIONID));
	}
	
	

}
