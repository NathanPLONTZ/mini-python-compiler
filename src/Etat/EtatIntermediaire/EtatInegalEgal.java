package Etat.EtatIntermediaire;

import Automate.Automate;
import Etat.EtatErreur.EtatErreurInegalEgal;
import Etat.EtatFinaux.EtatFinauxOperateur;
import Outils.Outils;

public class EtatInegalEgal extends EtatIntermediaire{
	
	public static final String INEGAL_EGALID = "INEGAL_EGAL";
	public EtatInegalEgal() {
		super();
		setNomEtat(INEGAL_EGALID);
		this.addEtatSuivant(new EtatErreurInegalEgal());
		
	}

	@Override
	public void action(char c, Automate automate) {
		if(Outils.isValideApresInegalEgal(c)) 
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatFinauxOperateur.OPERATEURID));
		else if (Outils.isEgal(c))
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatInegalEgal2.INEGAL_EGALID2));
		else
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatErreurInegalEgal.ERREURINEGALEGALID));
	}
	

}
