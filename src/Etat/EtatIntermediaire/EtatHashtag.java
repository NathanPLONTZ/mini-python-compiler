package Etat.EtatIntermediaire;

import Automate.Automate;
import Etat.EtatFinaux.EtatFinauxCommentaire;
import Outils.Outils;

public class EtatHashtag extends EtatIntermediaire{
	
	public static final String HASHTAGID = "HASHTAG";

	public EtatHashtag() {
		super();
		setNomEtat(HASHTAGID);
	}


	@Override
	public void action(char c, Automate automate) {
		if(Outils.isNewLineLinux(c) || Outils.isNewLineWindows(c))
            automate.setEtatCourant(automate.getEtatCourant().getEtatSuivant(EtatFinauxCommentaire.COMMENTAIREID));
		
	}

}
