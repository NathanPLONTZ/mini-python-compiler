package Etat.EtatIntermediaire;

import Etat.EtatFinaux.EtatFinauxNouvelleLigne;

public class EtatWindows extends EtatIntermediaire {
	
	public static final String WINDOWSID = "WINDOWS";
	
	public EtatWindows() {
		super();
		setNomEtat(WINDOWSID);
	}

	@Override
	public void action(char c, Automate.Automate automate) {
		automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatFinauxNouvelleLigne.NEWLINEID));
	}

}
