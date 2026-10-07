package Outils;

import java.util.ArrayList;

import NonTerminal.Affect;
import NonTerminal.Arg;
import NonTerminal.Binop;
import NonTerminal.Const;
import NonTerminal.DefNT;
import NonTerminal.Def_etoile;
import NonTerminal.ElseNT;
import NonTerminal.Expr;
import NonTerminal.Expr_droite;
import NonTerminal.Expr_etoile;
import NonTerminal.Expr_etoile_init;
import NonTerminal.Expr_init;
import NonTerminal.Expr_prime;
import NonTerminal.Expr_stmt;
import NonTerminal.File;
import NonTerminal.Ident_expr;
import NonTerminal.Ident_fact;
import NonTerminal.Next_arg;
import NonTerminal.NonTerminal;
import NonTerminal.Simple_stmt;
import NonTerminal.Stmt;
import NonTerminal.Stmt_etoile;
import NonTerminal.Suite;
import Token.And;
import Token.BEGIN;
import Token.CrochetFermant;
import Token.CrochetOuvrant;
import Token.Def;
import Token.DeuxPoints;
import Token.Div;
import Token.END;
import Token.EOF;
import Token.Egal;
import Token.EgalBool;
import Token.Else;
import Token.Epsilon;
import Token.False;
import Token.For;
import Token.Ident;
import Token.If;
import Token.In;
import Token.Inf;
import Token.InfEgal;
import Token.Int;
import Token.Moins;
import Token.Mult;
import Token.NEWLINE;
import Token.None;
import Token.Not;
import Token.NotEgal;
import Token.Or;
import Token.ParentheseFermante;
import Token.ParentheseOuvrante;
import Token.Plus;
import Token.Pourcent;
import Token.Print;
import Token.Return;
import Token.Str;
import Token.Sup;
import Token.SupEgal;
import Token.Token;
import Token.True;
import Token.Virgule;

/**
 * Character and keyword predicates used by the automaton, plus the accessors
 * that fetch pooled grammar symbols.
 *
 * <p>The {@code isX} predicates spell out the character classes of the Mini
 * Python lexical conventions, and the {@code isValideApresX} ones encode which
 * characters may legally follow a given lexeme, which is how the automaton
 * detects malformed tokens.
 *
 * <p>The {@code getX} accessors all delegate to {@link SymboleLookup}.
 */
public class Outils {
	
	public static  String[] motCles = { "and","def","else","for","if","True","False","in","not","or","print","return","None"};
	public static char[] operateur= {'+','-','*','%'};
	public static char[] ponctuation= {',',':','(',')','[',']'};
	public static char[] valideApresInteger= {'+','-','*','/','%','<','>','=','!',',',':',')',']',' ','#', '\n','\r'};
	public static char[] valideApresIdentifiant= {'+','-','*','/','%','<','>','=','!',',',':','(',')','[',']',' ','#','\n','\r'};
	
	
	public Outils() {
		
	}
	
	public static boolean isKeyWord(String mot) {
		for (String motCle : motCles) {
			if (motCle.equals(mot)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isValideApresInteger(char c) {
		for (char valide : valideApresInteger) {
			if (valide == c) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isValideApresIdentifiant(char c) {
		for (char valide : valideApresIdentifiant) {
			if (valide == c) {
				return true;
			}
		}
		return false;
	}
	
	
	
	public static boolean isValideApresInegalEgal(char c) {
		return Outils.isDigit(c) || Outils.isAlpha(c) || Outils.isSpace(c) || Outils.isQuote(c) || c=='(' || c=='[' || c=='-';
	}
	
	public static boolean isValideApresNot(char c) {// characters allowed right after "!="
		return Outils.isDigit(c) || Outils.isAlpha(c) || Outils.isSpace(c) || Outils.isQuote(c) || c=='(' || c=='[' || c=='-';
	}
	
	public static boolean isValideApresDivision(char c) {
		return Outils.isDigit(c) || Outils.isAlpha(c) || Outils.isSpace(c) || c=='(' || c=='-';
	}
	
	public static boolean isValideApresPlusMoins(char c) {
		return Outils.isDigit(c) || Outils.isAlpha(c) || Outils.isSpace(c) || Outils.isQuote(c) || c=='(' || c=='[' || c=='-' ;
	}
	
	public static boolean isValideApresMultPourcent(char c) {
		return Outils.isDigit(c) || Outils.isAlpha(c) || Outils.isSpace(c) || Outils.isQuote(c) || c=='(' || c=='[' || c=='-' ;
	}
	
	public static boolean isPlusMoins(char c) {
		return c == '+' || c == '-';
	}
	
	public static boolean isMultPourcent(char c) {
		return c == '*' || c == '%';
	}
	
	public static boolean isPonctuation0(char c) {
		return   c == '(' ;
	}
	
	public static boolean isPonctuation1(char c) {
		return c == ')' ;
	}
	
	public static boolean isPonctuation2(char c) {
		return c == '[';
	}
	
	public static boolean isPonctuation3(char c) {
		return c == ']';
	}
	
	public static boolean isPonctuation4(char c) {
		return c == ',';
	}
	
	public static boolean isPonctuation5(char c) {
		return c == ':';
	}
	
	public static boolean isValideApresPonctuation0(char c) {
		return Outils.isAlpha(c) || Outils.isDigit(c) || Outils.isSpace(c) || Outils.isQuote(c) || c == '(' || c == '[' || c == '-' || c == ')';
	}
	
	public static boolean isValideApresPonctuation1(char c) {
		return c=='-' || c=='>' || c=='=' || c=='<' || c=='>' || c=='!' || c=='%' || c=='*' || c=='/' || Outils.isSpace(c)  || c == ',' || c==')' || c == ']' || c == ':' || c == '\n' || c == '\r' ;
	}
	
	public static boolean isValideApresPonctuation2(char c) {
		return Outils.isAlpha(c) || Outils.isDigit(c) || Outils.isSpace(c) || Outils.isQuote(c) || c == '(' || c == '[' || c == '-' || c == ']';
	}
	
	public static boolean isValideApresPonctuation3(char c) {
		return c == '-' || c == '>' || c == '=' || c == '<' || c == '>' || c == '!' || c == '%' || c == '*' || c == '/'|| Outils.isSpace(c) || c == ',' || c == ']' || c == ':' || c == '\n' || c == '\r';
	}
	
	public static boolean isValideApresPonctuation4(char c) {
		return Outils.isAlpha(c) || Outils.isDigit(c) || Outils.isSpace(c) || Outils.isQuote(c) || c == '(' || c == '['|| c == '-' ;
	}
	
	public static boolean isValideApresPonctuation5(char c) {
		return Outils.isAlpha(c) || Outils.isDigit(c) || Outils.isSpace(c) || Outils.isQuote(c) || c == '(' || c == '['|| c == '-' || c == '\n' || c == '\r';
	}
	
	public static boolean isAlpha(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}
	
	public static boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}
	
	public static boolean isAlphaOrDigit(char c) {
		return isAlpha(c) || isDigit(c);
	}
	
	public static boolean isUnderscore(char c) {
		return c == '_';
	}
	
	public static boolean isZero(char c) {
		return c == '0';
    }
	
	public static boolean isSlash(char c) {
		return c == '/';
	}
	
	public static boolean isExclamation(char c) {
		return c == '!';
	}
	
	public static boolean isSpace(char c) {
		return c == ' ';
	}
	
	public static boolean isEgal(char c) {
		return c == '=';
	}
	
	public static boolean isInegalEgal(char c) {
		return c == '=' || c == '<' || c == '>';
	}
	
	public static boolean isHashtag(char c) {
		return c == '#';
	}
	
	public static boolean isNewLineLinux(char c) {
		return c == '\n';
	}
	
	public static boolean isNewLineWindows(char c) {
		return c == '\r';
	}
	
	public static boolean isQuote(char c) {
		return c == '"';
	}
	
	public static boolean isBackSlash(char c) {
		return c == '\\';
	}
	
	public static boolean isReturn(String str) {
		return str.equals("return");
	}
	
	public static boolean isPrint(String str) {
		return str.equals("print");
	}
	
	public static boolean isDef(String str) {
		return str.equals("def");
	}
	
	public static boolean isIf(String str) {
		return str.equals("if");
	}
	
	public static boolean isElse(String str) {
		return str.equals("else");
	}
	
	public static boolean isTrue(String str) {
		return str.equals("True");
	}
	
	public static boolean isFalse(String str) {
		return str.equals("False");
	}
	
	public static boolean isNone(String str) {
		return str.equals("None");
	}
	
	public static boolean isFor(String str) {
		return str.equals("for");
	}
	
	public static boolean isNot(String str) {
		return str.equals("not");
	}
	
	public static boolean isIn(String str) {
        return str.equals("in");
    }
	
	public static boolean isParenthesisOpen(String c) {
		return c.equals("(");
	}
	
	public static boolean isParenthesisClose(String c) {
		return c.equals(")");
	}
	
	public static boolean isBracketOpen(String c) {
		return c.equals("[");
	}
	
	public static boolean isBracketClose(String c) {
		return c.equals("]");
	}
	
	public static boolean isComma(String c) {
		return c.equals(",");
	}
	
	public static boolean isColon(String c) {
		return c.equals(":");
	}

	public static boolean isOr(String token) {
		return token.equals("or");
	}
	
	public static boolean isAnd(String token) {
		return token.equals("and");
	}
	
	public static NEWLINE getNEWLINE(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, NEWLINE.class);
	}


	public static EOF getEOF(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, EOF.class);
	}


	public static Def getDef(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, Def.class);
	}


	public static Ident getIdent(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, Ident.class);
	}


	public static ParentheseOuvrante getParentheseOuvrante(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, ParentheseOuvrante.class);
	}


	public static ParentheseFermante getParentheseFermante(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, ParentheseFermante.class);
	}


	public static DeuxPoints getDeuxPoints(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, DeuxPoints.class);
	}


	public static Virgule getVirgule(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, Virgule.class);
	}


	public static BEGIN getBEGIN(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, BEGIN.class);
	}


	public static END getEND(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, END.class);
	}


	public static If getIf(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, If.class);
	}


	public static For getFor(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, For.class);
	}


	public static In getIn(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, In.class);
	}


	public static Else getElse(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, Else.class);
	}


	public static Return getReturn(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, Return.class);
	}


	public static Print getPrint(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, Print.class);
	}


	public static Egal getEgal(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, Egal.class);
	}


	public static Moins getMoins(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, Moins.class);
	}


	public static CrochetOuvrant getCrochetOuvrant(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, CrochetOuvrant.class);
	}


	public static CrochetFermant getCrochetFermant(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, CrochetFermant.class);
	}


	public static Not getNot(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, Not.class);
	}


	public static Plus getPlus(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, Plus.class);
	}


	public static Mult getMult(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, Mult.class);
	}


	public static Div getDiv(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, Div.class);
	}


	public static Pourcent getPourcent(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, Pourcent.class);
	}


	public static Inf getInf(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, Inf.class);
	}


	public static SupEgal getSupEgal(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, SupEgal.class);
	}


	public static Sup getSup(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, Sup.class);
	}


	public static InfEgal getInfEgal(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, InfEgal.class);
	}

	
	public static NotEgal getNotEgal(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, NotEgal.class);
	}


	public static EgalBool getEgalBool(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, EgalBool.class);
	}

	
	public static Or getOr(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, Or.class);
	}

	
	public static And getAnd(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, And.class);
	}


	public static Int getInt(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, Int.class);
	}


	public static Str getStr(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, Str.class);
	}


	public static True getTrue(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, True.class);
	}


	public static False getFalse(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, False.class);
	}


	public static None getNone(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, None.class);
	}

	
	public static Epsilon getEpsilon(ArrayList<Token> tokens) {
		return SymboleLookup.find(tokens, Epsilon.class);
	}

	
	public static Affect getAffect(ArrayList<NonTerminal> nt) {
		return SymboleLookup.find(nt, Affect.class);
	}

	
	public static Arg getArg(ArrayList<NonTerminal> nt) {
		return SymboleLookup.find(nt, Arg.class);
	}

	
	public static Binop getBinop(ArrayList<NonTerminal> nt) {
		return SymboleLookup.find(nt, Binop.class);
	}

	
	public static Const getConst(ArrayList<NonTerminal> nt) {
		return SymboleLookup.find(nt, Const.class);
	}

	
	public static Def_etoile getDef_etoile(ArrayList<NonTerminal> nt) {
		return SymboleLookup.find(nt, Def_etoile.class);
	}

	
	public static DefNT getDefNT(ArrayList<NonTerminal> nt) {
		return SymboleLookup.find(nt, DefNT.class);
	}

	
	public static ElseNT getElseNT(ArrayList<NonTerminal> nt) {
		return SymboleLookup.find(nt, ElseNT.class);
	}

	
	public static Expr_droite getExpr_droite(ArrayList<NonTerminal> nt) {
		return SymboleLookup.find(nt, Expr_droite.class);
	}

	
	public static Expr_etoile_init getExpr_etoile_init(ArrayList<NonTerminal> nt) {
		return SymboleLookup.find(nt, Expr_etoile_init.class);
	}

	
	public static Expr_etoile getExpr_etoile(ArrayList<NonTerminal> nt) {
		return SymboleLookup.find(nt, Expr_etoile.class);
	}

	
	public static Expr_init getExpr_init(ArrayList<NonTerminal> nt) {
		return SymboleLookup.find(nt, Expr_init.class);
	}

	
	public static Expr_prime getExpr_prime(ArrayList<NonTerminal> nt) {
		return SymboleLookup.find(nt, Expr_prime.class);
	}

	
	public static Expr_stmt getExpr_stmt(ArrayList<NonTerminal> nt) {
		return SymboleLookup.find(nt, Expr_stmt.class);
	}

	
	public static Expr getExpr(ArrayList<NonTerminal> nt) {
		return SymboleLookup.find(nt, Expr.class);
	}


	public static File getFile(ArrayList<NonTerminal> nt) {
		return SymboleLookup.find(nt, File.class);
	}

	
	public static Ident_expr getIdent_expr(ArrayList<NonTerminal> nt) {
		return SymboleLookup.find(nt, Ident_expr.class);
	}

	
	public static Ident_fact getIdent_fact(ArrayList<NonTerminal> nt) {
		return SymboleLookup.find(nt, Ident_fact.class);
	}

	
	public static Next_arg getNext_arg(ArrayList<NonTerminal> nt) {
		return SymboleLookup.find(nt, Next_arg.class);
	}

	
	public static Simple_stmt getSimple_stmt(ArrayList<NonTerminal> nt) {
		return SymboleLookup.find(nt, Simple_stmt.class);
	}

	
	public static Stmt_etoile getStmt_etoile(ArrayList<NonTerminal> nt) {
		return SymboleLookup.find(nt, Stmt_etoile.class);
	}

	
	public static Stmt getStmt(ArrayList<NonTerminal> nt) {
		return SymboleLookup.find(nt, Stmt.class);
	}

	
	public static Suite getSuite(ArrayList<NonTerminal> nt) {
		return SymboleLookup.find(nt, Suite.class);
	}

	
}
