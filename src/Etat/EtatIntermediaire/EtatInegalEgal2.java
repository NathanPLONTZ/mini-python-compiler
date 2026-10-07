package Etat.EtatIntermediaire;

import Automate.Automate;
import Etat.EtatErreur.EtatErreurInegalEgal;
import Etat.EtatFinaux.EtatFinauxOperateur;
import Outils.Outils;

public class EtatInegalEgal2 extends EtatIntermediaire{
	
	public static final String INEGAL_EGALID2 = "INEGAL_EGAL2";
	
	public EtatInegalEgal2() {
		super();
		setNomEtat(INEGAL_EGALID2);
		this.addEtatSuivant(new EtatErreurInegalEgal());
		
	}

	@Override
	public void action(char c, Automate automate) {
		if(Outils.isValideApresInegalEgal(c)) 
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatFinauxOperateur.OPERATEURID));
		else
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatErreurInegalEgal.ERREURINEGALEGALID));
	}
	

}
