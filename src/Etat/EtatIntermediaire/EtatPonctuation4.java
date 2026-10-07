package Etat.EtatIntermediaire;

import Automate.Automate;
import Etat.EtatErreur.EtatErreurPonctuation4;
import Etat.EtatFinaux.EtatFinauxPonctuation;
import Outils.Outils;

public class EtatPonctuation4 extends EtatIntermediaire{
	
	public static final String PONCTUATION4ID = "PONCTUATION4";

	public EtatPonctuation4() {
		super();
		setNomEtat(PONCTUATION4ID);
		this.addEtatSuivant(new EtatErreurPonctuation4());
	}

	@Override
	public void action(char c, Automate automate) {
		if(Outils.isValideApresPonctuation4(c))
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatFinauxPonctuation.PONCTUATIONID));
		else
        	automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatErreurPonctuation4.ERREURPONCTUATION4ID));
	}
}
