package Token;

import java.util.ArrayList;
import java.util.Stack;

import Grammaire.Symbole;
import Outils.Buffer;


/**
 * Base class of every terminal produced by the lexer.
 *
 * <p>Beyond the lexeme and its line number, this class hosts the post-passes
 * that run over the raw token stream: comment removal, insertion of the BEGIN
 * and END indentation tokens, error reporting, and the blank / newline cleanups.
 *
 * <p>Equality is class identity, which is what the parser needs to compare the
 * symbol on the stack with the look-ahead token.
 */
public abstract class Token extends Symbole {

	private String valeurToken;
	private int numLigne;
	
	public Token() {
		super();
		this.premiers.add(this);
		this.numLigne=Buffer.getNumLigne();
	}
	
	public int getNumLigne() {
		return numLigne;
	}
	
	public void setNumLigne(int n) {
		this.numLigne=n;
	}

	public Token(String valeurToken) {
		super();
		this.valeurToken=valeurToken;
		this.premiers.add(this);
	}
	
	public boolean isTerminal() {
		return true;
	}
	

	public static ArrayList<Token> addBeginEnd(ArrayList<Token> tokens){
		Buffer.setNumLigne(0);// Restart the line counter: BEGIN/END are inserted after tokenising, so line numbers have to be recomputed here.
		boolean newLine = false;
		Stack<Integer> pile = new Stack<>();
		pile.push(0);
		
		for (int i = 0; i < tokens.size(); i++) {
			if (tokens.get(i).getValeur().equals("NEWLINE")) {
				newLine = true;
				Buffer.incNumLigne();
			}else {
				newLine = false;
			}
			
			if(newLine) {
				int cpt = 0;
				int debutEspace = i+1;
				int j=i+1;
				while (j < tokens.size() && tokens.get(j).getValeur().equals("SPACE")) {
					cpt++;
					j++;
				}
				if(cpt == pile.peek()) {
					
				}else if(cpt > pile.peek()) {
					pile.push(cpt);
					tokens.add(j, new BEGIN());
				}else {
					if(!pile.contains(cpt)) {
						ErreurIndentation erreur =new ErreurIndentation(Buffer.getNumLigne());
						erreur.setValeur("ErreurIndentation");
	    				tokens.add(j, erreur);
					}else {
						while (cpt != pile.peek()) {
	                        pile.pop();
		    				tokens.add(j, new END());
						}
					}
						
				}
			}
		}
		
		return tokens;
		
	}
	
	public String getValeur() {
		return valeurToken;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    return this.getClass() == obj.getClass();
	}

	
	public void afficherToken() {
		if (this.valeurToken != null) {
        	System.out.println(this.valeurToken + " ");
		}
		else {
			System.out.println("Token vide");
		}

    }
	
	public void setValeur(String valeurToken) {
		this.valeurToken = valeurToken;
	}

	public static void removeSpace(ArrayList<Token> tokens) {
        tokens.removeIf(token -> token instanceof SPACE);
    }
	
	public static void removeComment(ArrayList<Token> tokens) {
		tokens.removeIf(token -> token instanceof Commentaire);
	}
	
	public static void removeNewlineRedondant(ArrayList<Token> tokens) {
		for(int i =0 ; i<tokens.size();i++) {
			if(tokens.get(i) instanceof NEWLINE) {
				int j =i+1;
				while(j<tokens.size() && tokens.get(j) instanceof NEWLINE) {
					tokens.remove(j);
				}
				
			}
		}
		
		for(int i =0 ; i<tokens.size()-1;i++) {
			if(tokens.get(i) instanceof END && tokens.get(i+1) instanceof NEWLINE)
				tokens.remove(i+1);
		}
	}
	
	public static void afficherTokenValue(ArrayList<Token> listeToken) {
	    String result = "";
		for (Token t : listeToken) {
			for (int i = 0; i < t.getValeur().length(); i++) {
			    char c = t.getValeur().charAt(i);
				if (c == '\n') {
					result = result+"\\n";
				} else if (c == '\r') {
					result = result+"\\r";
				} else {
					result = result+String.valueOf(c);
				}
			}
			System.out.print(result);
			result = "";
			System.out.print("/");
		}

		System.out.print("\n");
    }
	
	public static void afficherTokenClass(ArrayList<Token> listeToken) {
		for (Token t : listeToken) {
			System.out.print(t.getClass().getSimpleName());
			System.out.print("/");
		}
    }
	
	public static void removeSpacesBetweenNewlines(ArrayList<Token> tokens) {
	    int i = 0;
	    
	    while (i < tokens.size() - 1) {
	        // current token must be a NEWLINE
	        if (tokens.get(i) instanceof NEWLINE) {
	            int start = i + 1;
	            boolean onlySpaces = true;

	            // scan the tokens sitting between two NEWLINEs
	            while (start < tokens.size() && !(tokens.get(start) instanceof NEWLINE)) {
	                if (!(tokens.get(start) instanceof SPACE)) {
	                    onlySpaces = false; // something other than a space: leave the run alone
	                    break;
	                }
	                start++;
	            }
	            
	            // Blank line: drop the spaces between the two NEWLINEs.
	            if (onlySpaces && start < tokens.size() && tokens.get(start) instanceof NEWLINE) {
	                tokens.subList(i + 1, start).clear();
	            }
	            
	            i = start; // resume after the second NEWLINE
	        } else {
	            i++;
	        }
	    }
	}
	
	public static boolean afficherErreur(ArrayList<Token> listeToken) {
		boolean res=false;
		for (Token t : listeToken) {
			if (t instanceof Erreur) {
				t= (Erreur) t;
				System.out.println(((Erreur) t).getMessageErreur());
				res=true;
			}
		}
		return res;
	}
	
	public String toString() {
		return this.valeurToken;
	}
	
	public static ArrayList<Token> initToken(){
		ArrayList<Token> allToken=new ArrayList<Token>();
		allToken.add(new NEWLINE());
		allToken.add(new EOF());
		allToken.add(new Def());
		allToken.add(new Ident());
		allToken.add(new ParentheseOuvrante());
		allToken.add(new ParentheseFermante());
		allToken.add(new DeuxPoints());
		allToken.add(new Virgule());
		allToken.add(new BEGIN());
		allToken.add(new END());
		allToken.add(new If());
		allToken.add(new For());
		allToken.add(new In());
		allToken.add(new Else());
		allToken.add(new Return());
		allToken.add(new Print());
		allToken.add(new Egal());
		allToken.add(new Moins());
		allToken.add(new CrochetOuvrant());
		allToken.add(new CrochetFermant());
		allToken.add(new Not());
		allToken.add(new Plus());
		allToken.add(new Mult());
		allToken.add(new Div());
		allToken.add(new Pourcent());
		allToken.add(new Inf());
		allToken.add(new SupEgal());
		allToken.add(new Sup());
		allToken.add(new InfEgal());
		allToken.add(new NotEgal());
		allToken.add(new EgalBool());
		allToken.add(new Or());
		allToken.add(new And());
		allToken.add(new Int());
		allToken.add(new Str());
		allToken.add(new True());
		allToken.add(new False());
		allToken.add(new None());
		allToken.add(new Epsilon());
		return allToken;
	}
	
	
}
