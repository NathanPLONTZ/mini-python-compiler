package Etat.EtatIntermediaire;

import Automate.Automate;
import Etat.EtatErreur.EtatErreurCaractereInconnu;
import Outils.Outils;

public class EtatSlash extends EtatIntermediaire{
	
	public final static String SLASHID = "SLASH";

	public EtatSlash() {
		super();
		setNomEtat(SLASHID);
		this.addEtatSuivant(new EtatErreurCaractereInconnu());
	}

	@Override
	public void action(char c, Automate automate) {
		if(Outils.isSlash(c))
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatSlash2.SLASH2ID));
		else
        	automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatErreurCaractereInconnu.ERREURCARACTEREINCONNUID));
	}
	
	

}
