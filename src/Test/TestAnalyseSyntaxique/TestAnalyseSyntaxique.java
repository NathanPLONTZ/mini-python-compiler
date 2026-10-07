package Test.TestAnalyseSyntaxique;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import AnalyseLexicale.AnalyseLexicale;
import AnalyseSyntaxique.AnalyseSyntaxique;
import Grammaire.Grammaire;
import Token.Token;

/**
 * Main entry point of the compiler: runs the full PCL1 pipeline on one source
 * file (lexing, then LL(1) parsing, then concrete and abstract tree printing).
 *
 * <p>Usage: {@code java -cp out Test.TestAnalyseSyntaxique [source-file]}
 */
public class TestAnalyseSyntaxique {

	/** Source file analysed when no argument is given. */
	private static final String FICHIER_PAR_DEFAUT = "./tests/demonstration.txt";

	public static void main(String[] args) throws IOException {

		String cheminFichier = args.length > 0 ? args[0] : FICHIER_PAR_DEFAUT;

		File fichier = new File(cheminFichier);
		if (!fichier.exists()) {
			System.err.println("Erreur : Le fichier " + cheminFichier + " n'existe pas.");
			return;
		}

		// The grammar and its FIRST / FOLLOW sets are built once, in code.
		Grammaire g = new Grammaire();

		ArrayList<Token> mot = AnalyseLexicale.decoupageToken(cheminFichier);
		System.out.println("");
		System.out.println("");
		System.out.println("Découpage Token:");
		Token.afficherTokenClass(mot);

		System.out.println("");
		System.out.println("");

		// Parsing is only attempted on a lexically sound token stream.
		if (!AnalyseSyntaxique.erreurLexical) {
			AnalyseSyntaxique.motValide(mot, g);
		}
	}
}
