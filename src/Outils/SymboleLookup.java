package Outils;

import java.util.List;

import Grammaire.Symbole;

/**
 * Shared lookup used to retrieve the single shared instance of a given grammar
 * symbol from the terminal / non-terminal pools built by
 * {@code Token.initToken()} and {@code NonTerminal.initNonTerminal()}.
 *
 * <p>The grammar rules are wired by reference: every occurrence of a symbol in a
 * production must point at the same object, because the FIRST / FOLLOW sets are
 * stored on the symbol itself. Each accessor in {@link Outils} used to repeat the
 * same linear scan; they all delegate here instead.
 *
 * <p>Symbols are matched on exact class identity, which is what
 * {@code Token.equals} and {@code NonTerminal.equals} implement.
 */
public final class SymboleLookup {

	private SymboleLookup() {
	}

	/**
	 * Returns the pooled instance whose class is exactly {@code type}.
	 *
	 * @param symboles the pool to scan
	 * @param type     the exact symbol class to look for
	 * @return the pooled instance, or {@code null} if the pool holds no such
	 *         symbol (an error is then printed, as the original accessors did)
	 */
	public static <S extends Symbole> S find(List<? extends Symbole> symboles, Class<S> type) {
		for (Symbole symbole : symboles) {
			if (symbole.getClass() == type) {
				return type.cast(symbole);
			}
		}
		System.out.println("Erreur get" + type.getSimpleName());
		return null;
	}
}
