package Etat.EtatIntermediaire;

import Automate.Automate;
import Etat.EtatErreur.EtatErreurInt;
import Etat.EtatFinaux.EtatFinauxInt;
import Outils.Outils;

public class EtatZero extends EtatIntermediaire{
	
	public static final String ZEROID = "ZERO";
	
	public EtatZero() {
		super();
		setNomEtat(ZEROID);
		this.addEtatSuivant(new EtatErreurInt());
	}


	@Override
	public void action(char c, Automate automate) {
		if(Outils.isValideApresInteger(c))
            automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatFinauxInt.INTID));
		else {
        	automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatErreurInt.ERREURINTID));
		}
		
	}

}