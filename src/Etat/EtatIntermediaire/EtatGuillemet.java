package Etat.EtatIntermediaire;

import Automate.Automate;
import Etat.EtatErreur.EtatErreurGuillemet;
import Etat.EtatFinaux.EtatFinauxStr;
import Outils.Buffer;
import Outils.Outils;

public class EtatGuillemet extends EtatIntermediaire{
	
	public static final String GUILLEMETID = "GUILLEMET";
	
	public EtatGuillemet() {
		super();
		setNomEtat(GUILLEMETID);
		this.addEtatSuivant(new EtatErreurGuillemet());
	}


	@Override
	public void action(char c, Automate automate) {
		if(Outils.isQuote(c) && (!Outils.isBackSlash(Buffer.getAvantDernier())))
            automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatFinauxStr.STRID));
		else if(Outils.isNewLineLinux(c) || Outils.isNewLineWindows(c)) {
            automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatErreurGuillemet.ERREURGUILLEMETID));	
		}
		else {
			// stay in this state
		}
		
	}

}
