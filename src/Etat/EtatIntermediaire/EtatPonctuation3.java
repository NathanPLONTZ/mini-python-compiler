package Etat.EtatIntermediaire;

import Automate.Automate;
import Etat.EtatErreur.EtatErreurPonctuation3;
import Etat.EtatFinaux.EtatFinauxPonctuation;
import Outils.Outils;

public class EtatPonctuation3 extends EtatIntermediaire{
	
	public static final String PONCTUATION3ID = "PONCTUATION3";

	public EtatPonctuation3() {
		super();
		setNomEtat(PONCTUATION3ID);
		this.addEtatSuivant(new EtatErreurPonctuation3());
	}

	@Override
	public void action(char c, Automate automate) {
		if(Outils.isValideApresPonctuation3(c))
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatFinauxPonctuation.PONCTUATIONID));
		else
        	automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatErreurPonctuation3.ERREURPONCTUATION3ID));
	}
}
