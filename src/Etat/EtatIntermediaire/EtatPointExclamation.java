package Etat.EtatIntermediaire;

import Automate.Automate;
import Etat.EtatErreur.EtatErreurCaractereInconnu;
import Outils.Outils;

public class EtatPointExclamation extends EtatIntermediaire{
	
	public static final String POINT_EXCLAMATIONID = "POINT_EXCLAMATION";

	public EtatPointExclamation() {
		super();
		setNomEtat(POINT_EXCLAMATIONID);
		this.addEtatSuivant(new EtatErreurCaractereInconnu());
	}

	@Override
	public void action(char c, Automate automate) {
		if(Outils.isEgal(c))
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatPointExclamation2.POINT_EXCLAMATIONID2));
		else
        	automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatErreurCaractereInconnu.ERREURCARACTEREINCONNUID));
	}

}
