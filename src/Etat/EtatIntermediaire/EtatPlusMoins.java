package Etat.EtatIntermediaire;

import Automate.Automate;
import Etat.EtatErreur.EtatErreurOperateur;
import Etat.EtatFinaux.EtatFinauxOperateur;
import Outils.Outils;

public class EtatPlusMoins extends EtatIntermediaire {
	
	public static final String PLUSMOINSID = "PLUSMOINS";
	
	public EtatPlusMoins() {
		super();
		setNomEtat(PLUSMOINSID);
		this.addEtatSuivant(new EtatErreurOperateur());
	}

	@Override
	public void action(char c, Automate automate) {
        if(Outils.isValideApresPlusMoins(c))
        	automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatFinauxOperateur.OPERATEURID));
        else
        	automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatErreurOperateur.ERREUROPERATEURID));
	}
	
}
