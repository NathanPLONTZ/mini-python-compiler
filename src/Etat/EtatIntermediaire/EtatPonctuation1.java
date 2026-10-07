package Etat.EtatIntermediaire;

import Automate.Automate;
import Etat.EtatErreur.EtatErreurPonctuation1;
import Etat.EtatFinaux.EtatFinauxPonctuation;
import Outils.Outils;

public class EtatPonctuation1 extends EtatIntermediaire{
	
	public static final String PONCTUATION1ID = "PONCTUATION1";

	public EtatPonctuation1() {
		super();
		setNomEtat(PONCTUATION1ID);
		this.addEtatSuivant(new EtatErreurPonctuation1());
	}

	@Override
	public void action(char c, Automate automate) {
		if(Outils.isValideApresPonctuation1(c))
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatFinauxPonctuation.PONCTUATIONID));
		else
        	automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatErreurPonctuation1.ERREURPONCTUATION1ID));
	}
}
