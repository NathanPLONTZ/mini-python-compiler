package Etat.EtatIntermediaire;

import Automate.Automate;
import Etat.EtatErreur.EtatErreurNot;
import Etat.EtatFinaux.EtatFinauxOperateur;
import Outils.Outils;

public class EtatPointExclamation2 extends EtatIntermediaire{
	
	public static final String POINT_EXCLAMATIONID2 = "POINT_EXCLAMATION2";

	public EtatPointExclamation2() {
		super();
		setNomEtat(POINT_EXCLAMATIONID2);
		this.addEtatSuivant(new EtatErreurNot());
	}

	@Override
	public void action(char c, Automate automate) {
		if(Outils.isValideApresNot(c))
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatFinauxOperateur.OPERATEURID));
		else
        	automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatErreurNot.ERREURNOTID));
	}

}
