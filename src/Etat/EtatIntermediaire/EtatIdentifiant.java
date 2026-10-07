package Etat.EtatIntermediaire;

import Automate.Automate;
import Etat.EtatErreur.EtatErreurIdentifiant;
import Etat.EtatFinaux.EtatFinauxIdfKey;
import Outils.Outils;

public class EtatIdentifiant extends EtatIntermediaire {
	
	public static final String IDFID = "IDF";

	public EtatIdentifiant() {
		super();
		setNomEtat(IDFID);
		this.addEtatSuivant(new EtatErreurIdentifiant());
	}

	@Override
	public void action(char c, Automate automate) {
		if(Outils.isAlphaOrDigit(c) || Outils.isUnderscore(c) || Outils.isAlpha(c)) {
			// stay in this state
		}else if(Outils.isValideApresIdentifiant(c)) {
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatFinauxIdfKey.IDFKEYID));
		}else
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatErreurIdentifiant.ERREURIDENTIFIANTID));
	}
	
	
	
	

}
