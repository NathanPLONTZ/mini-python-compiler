package Etat.EtatIntermediaire;

import Automate.Automate;
import Etat.EtatErreur.EtatErreurInt;
import Etat.EtatFinaux.EtatFinauxInt;
import Outils.Outils;

public class EtatInteger extends EtatIntermediaire {
	
	public static final String INTEGERID = "INETEGER";
	
	public EtatInteger() {
		super();
		setNomEtat(INTEGERID);
		this.addEtatSuivant(new EtatErreurInt());
	}

	@Override
	public void action(char c, Automate automate) {
        if(Outils.isDigit(c)) {
            // stay in this state
        }else if(Outils.isValideApresInteger(c))
            automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatFinauxInt.INTID));
        else
        	automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatErreurInt.ERREURINTID));
	}
	
}
