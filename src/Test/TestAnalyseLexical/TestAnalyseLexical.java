package Test.TestAnalyseLexical;

import java.io.IOException;
import java.util.ArrayList;

import AnalyseLexicale.AnalyseLexicale;
import Outils.Buffer;
import Token.Token;

/**
 * Entry point for the lexer alone: echoes the source file character by
 * character, then dumps the token stream twice, first by lexeme and then by
 * token class.
 *
 * <p>Usage: {@code java -cp out Test.TestAnalyseLexical [source-file]}
 */
public class TestAnalyseLexical {

	/** Source file analysed when no argument is given. */
	private static final String FICHIER_PAR_DEFAUT = "./tests/testErreurIdf.txt";

	public static void main(String[] args) throws IOException {

		String filePath = args.length > 0 ? args[0] : FICHIER_PAR_DEFAUT;

		new Buffer(filePath);

		System.out.println("Affichage fichier caractère par caractère:");
		Buffer.afficherFichier();
		System.out.println("");
		System.out.println("");

		System.out.println("Découpage en valeur des tokens:");
		System.out.println("");
		ArrayList<Token> tokens = AnalyseLexicale.decoupageToken(filePath);
		Token.afficherTokenValue(tokens);
		System.out.println("");

		System.out.println("Découpage en classe des tokens:");
		Token.afficherTokenClass(tokens);
		System.out.println("");
	}

}
