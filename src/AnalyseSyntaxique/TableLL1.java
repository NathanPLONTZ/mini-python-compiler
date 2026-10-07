package AnalyseSyntaxique;

import java.util.HashMap;
import java.util.Map;

import Grammaire.Grammaire;
import Grammaire.Regle;
import Outils.Outils;
import Token.Token;

/**
 * The LL(1) parsing table, stored as a map keyed by
 * {@code "<non-terminal>:<terminal>"}.
 *
 * <p>Cells are filled from the productions: a production goes under every
 * terminal in the FIRST set of its right-hand side, or, when that side derives
 * epsilon, under every terminal in the FOLLOW set of its left-hand side. A
 * handful of cells for the axiom are then written by hand, because the two
 * {@code file} productions (with and without a leading NEWLINE) overlap.
 */
public class TableLL1 {

    public Grammaire grammaire;
    public Map<String, Regle> table = new HashMap<>();

    public TableLL1(Grammaire g) {
        this.grammaire = g;
        constructionTableLL1();
    }

    public void addRegle(Regle regle) {
        grammaire.getRegles().add(regle);
    }

    public void put(String symbole1, String symbole2, Regle regle) {
        String key = createKey(symbole1, symbole2);
        table.put(key, regle);
    }

    public Regle get(String symbole1, String symbole2) {
        String key = createKey(symbole1, symbole2);
        Regle regle = table.get(key);

        if (regle == null) {
            System.out.println("Erreur : Aucune règle dans la case (" + symbole1 + ", " + symbole2 + ") de la table");
        }

        return regle;
    }

    public boolean contains(String symbole1, String symbole2) {
        String key = createKey(symbole1, symbole2);
        return table.containsKey(key);
    }

    private String createKey(String symbole1, String symbole2) {
        return symbole1 + ":" + symbole2;
    }

    public void constructionTableLL1() {
    	int i=0;
        for (Regle regle : grammaire.getRegles()) {	
            for (Token premier : regle.getPartieDroite().get(0).getPremiers()) {
                if (!premier.getValeur().equals("Epsilon")) {
                    put(regle.getPartieGauche().getNom(), premier.getNom(), regle);
                } else {
                    for (Token suivant : regle.getPartieGauche().getSuivants()) {
                        put(regle.getPartieGauche().getNom(), suivant.getNom(), regle);
                    }
                }
            }
        }

        // Hand-written cells resolving the conflict on the axiom <file>.
        put(Outils.getFile(grammaire.getNonTerminaux()).getNom(), Outils.getIdent(grammaire.getTerminaux()).getNom(), grammaire.getRegles().get(1));
        put(Outils.getFile(grammaire.getNonTerminaux()).getNom(), Outils.getParentheseOuvrante(grammaire.getTerminaux()).getNom(), grammaire.getRegles().get(1));
        put(Outils.getFile(grammaire.getNonTerminaux()).getNom(), Outils.getIf(grammaire.getTerminaux()).getNom(), grammaire.getRegles().get(1));
        put(Outils.getFile(grammaire.getNonTerminaux()).getNom(), Outils.getFor(grammaire.getTerminaux()).getNom(), grammaire.getRegles().get(1));
        put(Outils.getFile(grammaire.getNonTerminaux()).getNom(), Outils.getReturn(grammaire.getTerminaux()).getNom(), grammaire.getRegles().get(1));
        put(Outils.getFile(grammaire.getNonTerminaux()).getNom(), Outils.getPrint(grammaire.getTerminaux()).getNom(), grammaire.getRegles().get(1));
        put(Outils.getFile(grammaire.getNonTerminaux()).getNom(), Outils.getMoins(grammaire.getTerminaux()).getNom(), grammaire.getRegles().get(1));
        put(Outils.getFile(grammaire.getNonTerminaux()).getNom(), Outils.getParentheseFermante(grammaire.getTerminaux()).getNom(), grammaire.getRegles().get(1));
        put(Outils.getFile(grammaire.getNonTerminaux()).getNom(), Outils.getNot(grammaire.getTerminaux()).getNom(), grammaire.getRegles().get(1));
        put(Outils.getFile(grammaire.getNonTerminaux()).getNom(), Outils.getInt(grammaire.getTerminaux()).getNom(), grammaire.getRegles().get(1));
        put(Outils.getFile(grammaire.getNonTerminaux()).getNom(), Outils.getStr(grammaire.getTerminaux()).getNom(), grammaire.getRegles().get(1));
        put(Outils.getFile(grammaire.getNonTerminaux()).getNom(), Outils.getTrue(grammaire.getTerminaux()).getNom(), grammaire.getRegles().get(1));
        put(Outils.getFile(grammaire.getNonTerminaux()).getNom(), Outils.getFalse(grammaire.getTerminaux()).getNom(), grammaire.getRegles().get(1));
        put(Outils.getFile(grammaire.getNonTerminaux()).getNom(), Outils.getNone(grammaire.getTerminaux()).getNom(), grammaire.getRegles().get(1));
    }

    public void afficherTableLL1() {
        System.out.println("Taille de la table: " + table.size());
        for (Map.Entry<String, Regle> entry : table.entrySet()) {
            String[] keys = entry.getKey().split(":");
            String nonTerminal = keys[0];
            String token = keys[1];
            System.out.print(nonTerminal + " , " + token + " : ");
            entry.getValue().afficherRegle();
        }
        System.out.println();
    }
}
