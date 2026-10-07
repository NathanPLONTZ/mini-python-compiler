package Etat.EtatIntermediaire;

import Automate.Automate;
import Etat.EtatErreur.EtatErreurPonctuation5;
import Etat.EtatFinaux.EtatFinauxPonctuation;
import Outils.Outils;

public class EtatPonctuation5 extends EtatIntermediaire{
	
	public static final String PONCTUATION5ID = "PONCTUATION5";

	public EtatPonctuation5() {
		super();
		setNomEtat(PONCTUATION5ID);
		this.addEtatSuivant(new EtatErreurPonctuation5());
	}

	@Override
	public void action(char c, Automate automate) {
		if(Outils.isValideApresPonctuation5(c))
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatFinauxPonctuation.PONCTUATIONID));
		else
        	automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatErreurPonctuation5.ERREURPONCTUATION5ID));
	}
}
