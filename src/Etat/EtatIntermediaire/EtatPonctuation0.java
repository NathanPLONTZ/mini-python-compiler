package Etat.EtatIntermediaire;

import Automate.Automate;
import Etat.EtatErreur.EtatErreurPonctuation0;
import Etat.EtatErreur.EtatErreurPonctuation1;
import Etat.EtatFinaux.EtatFinauxPonctuation;
import Outils.Outils;

public class EtatPonctuation0 extends EtatIntermediaire{
	
	public static final String PONCTUATION0ID = "PONCTUATION0";

	public EtatPonctuation0() {
		super();
		setNomEtat(PONCTUATION0ID);
		this.addEtatSuivant(new EtatErreurPonctuation0());
	}

	@Override
	public void action(char c, Automate automate) {
		if(Outils.isValideApresPonctuation0(c))
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatFinauxPonctuation.PONCTUATIONID));
		else
        	automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatErreurPonctuation1.ERREURPONCTUATION1ID));
	}
}
