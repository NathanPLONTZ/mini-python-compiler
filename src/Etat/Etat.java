package Etat;

import java.util.ArrayList;


/**
 * Base class of the automaton states: a name and a list of successor states.
 */
public abstract class Etat {
	
	private String nomEtat;
	private ArrayList<Etat> listeEtatsSuivants = new ArrayList<Etat>();
	
	public Etat() {
	}
	
	public String getNomEtat() {
		return nomEtat;
	}
	
	public void setNomEtat(String nom) {
		this.nomEtat = nom;
	}

	
	public void addEtatSuivant(Etat etat) {
        listeEtatsSuivants.add(etat);
    }
	
	public ArrayList<Etat> getListeEtatsSuivants() {
		return listeEtatsSuivants;
	}
	
	public Etat getEtatSuivant(String nom) {
		for (Etat etat : listeEtatsSuivants) {
			if (etat.getNomEtat().equals(nom)) {
				return etat;
			}
		}
		System.out.println("Pas de suivant ");
		return null;
	}
	
}
