package Etat.EtatIntermediaire;

import Automate.Automate;
import Etat.EtatErreur.EtatErreurPonctuation2;
import Etat.EtatFinaux.EtatFinauxPonctuation;
import Outils.Outils;

public class EtatPonctuation2 extends EtatIntermediaire{
	
	public static final String PONCTUATION2ID = "PONCTUATION2";

	public EtatPonctuation2() {
		super();
		setNomEtat(PONCTUATION2ID);
		this.addEtatSuivant(new EtatErreurPonctuation2());
	}

	@Override
	public void action(char c, Automate automate) {
		if(Outils.isValideApresPonctuation2(c))
			automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatFinauxPonctuation.PONCTUATIONID));
		else
        	automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatErreurPonctuation2.ERREURPONCTUATION2ID));
	}
}
