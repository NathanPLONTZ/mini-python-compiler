package Etat.EtatIntermediaire;

import Automate.Automate;
import Etat.EtatErreur.EtatErreurOperateur;
import Etat.EtatFinaux.EtatFinauxOperateur;
import Outils.Outils;

public class EtatMultPourcent extends EtatIntermediaire {
	
	public static final String MULTPOURCENTID = "MULTPOURCENT";
	
	public EtatMultPourcent() {
		super();
		setNomEtat(MULTPOURCENTID);
		this.addEtatSuivant(new EtatErreurOperateur());
	}

	@Override
	public void action(char c, Automate automate) {
        if(Outils.isValideApresMultPourcent(c))
        	automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatFinauxOperateur.OPERATEURID));
        else
        	automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatErreurOperateur.ERREUROPERATEURID));
	}
	
}

