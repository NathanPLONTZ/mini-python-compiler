package Grammaire;

import java.util.ArrayList;

import NonTerminal.NonTerminal;
import Outils.Outils;
import Token.Token;

/**
 * A single production, with its left-hand non-terminal and the list of symbols
 * on its right-hand side.
 *
 * <p>{@link #initRegle} holds the whole Mini Python grammar, written out
 * production by production. Right-hand sides reference the pooled symbol
 * instances so that FIRST / FOLLOW stay shared.
 */
public class Regle {
	
	private NonTerminal partieGauche;
	private ArrayList<Symbole> partieDroite=new ArrayList<Symbole>();
	
	public Regle() {
	}
	
	public Regle(NonTerminal partieGauche, ArrayList<Symbole> partieDroite) {
		this.partieGauche = partieGauche;
		this.partieDroite = partieDroite;
	}
	
	public Regle(NonTerminal partieGauche) {
		this.partieGauche = partieGauche;
		this.partieDroite = new ArrayList<Symbole>();
	}
	
	public Regle copie() {
		Regle r = new Regle();
		r.partieGauche=(NonTerminal) this.partieGauche.copie();
		for(Symbole s : partieDroite)
			r.addPartieDroite(s.copie());
		return r;
	}
	
	public NonTerminal getPartieGauche() {
		return partieGauche;
	}
	
	public ArrayList<Symbole> getPartieDroite() {
		return partieDroite;
	}
	
	public void addPartieDroite(Symbole symbole) {
		partieDroite.add(symbole);
	}
	
	public void afficherRegle() {
		System.out.print(partieGauche.getNom() + " -> ");
		for (Symbole symbole : partieDroite) {
			System.out.print(symbole.getNom() + " ");
		}
		System.out.println();
	}
	
	public static ArrayList<Regle> initRegle(ArrayList<NonTerminal> nt,ArrayList<Token> t) {

		ArrayList<Regle> regles = new ArrayList<Regle>();
		
		Regle r1 = new Regle();
		r1.partieGauche=Outils.getFile(nt);
		r1.addPartieDroite(Outils.getNEWLINE(t));
		r1.addPartieDroite(Outils.getDef_etoile(nt));
		r1.addPartieDroite(Outils.getStmt(nt));
		r1.addPartieDroite(Outils.getStmt_etoile(nt));
		r1.addPartieDroite(Outils.getEOF(t));
		
		Regle r2 = new Regle();
		r2.partieGauche=Outils.getFile(nt);
		r2.addPartieDroite(Outils.getDef_etoile(nt));
		r2.addPartieDroite(Outils.getStmt(nt));
		r2.addPartieDroite(Outils.getStmt_etoile(nt));
		r2.addPartieDroite(Outils.getEOF(t));
		
		Regle r3 = new Regle();
		r3.partieGauche=Outils.getDef_etoile(nt);
		r3.addPartieDroite(Outils.getDefNT(nt));
		r3.addPartieDroite(Outils.getDef_etoile(nt));
		
		Regle r4 = new Regle();
		r4.partieGauche=Outils.getDef_etoile(nt);
		r4.addPartieDroite(Outils.getEpsilon(t));
		
		Regle r5 = new Regle();
		r5.partieGauche=Outils.getStmt_etoile(nt);
		r5.addPartieDroite(Outils.getStmt(nt));
		r5.addPartieDroite(Outils.getStmt_etoile(nt));
		
		Regle r6 = new Regle();
		r6.partieGauche=Outils.getStmt_etoile(nt);
		r6.addPartieDroite(Outils.getEpsilon(t));
		
		Regle r7 = new Regle();
		r7.partieGauche=Outils.getDefNT(nt);
		r7.addPartieDroite(Outils.getDef(t));
		r7.addPartieDroite(Outils.getIdent(t));
		r7.addPartieDroite(Outils.getParentheseOuvrante(t));
		r7.addPartieDroite(Outils.getArg(nt));
		r7.addPartieDroite(Outils.getParentheseFermante(t));
		r7.addPartieDroite(Outils.getDeuxPoints(t));
		r7.addPartieDroite(Outils.getSuite(nt));
		
		Regle r8 = new Regle();
		r8.partieGauche = Outils.getArg(nt);
		r8.addPartieDroite(Outils.getIdent(t));
		r8.addPartieDroite(Outils.getNext_arg(nt));
		
		Regle r9 = new Regle();
		r9.partieGauche = Outils.getArg(nt);
		r9.addPartieDroite(Outils.getEpsilon(t));
		
		Regle r10 = new Regle();
		r10.partieGauche = Outils.getNext_arg(nt);
		r10.addPartieDroite(Outils.getVirgule(t));
		r10.addPartieDroite(Outils.getIdent(t));
		r10.addPartieDroite(Outils.getNext_arg(nt));
		
		Regle r11 = new Regle();
		r11.partieGauche = Outils.getNext_arg(nt);
		r11.addPartieDroite(Outils.getEpsilon(t));
		
		Regle r12 = new Regle();
		r12.partieGauche = Outils.getSuite(nt);
		r12.addPartieDroite(Outils.getSimple_stmt(nt));
		r12.addPartieDroite(Outils.getNEWLINE(t));
		
		Regle r13 = new Regle();
		r13.partieGauche = Outils.getSuite(nt);
		r13.addPartieDroite(Outils.getNEWLINE(t));
		r13.addPartieDroite(Outils.getBEGIN(t));
		r13.addPartieDroite(Outils.getStmt(nt));
		r13.addPartieDroite(Outils.getStmt_etoile(nt));
		r13.addPartieDroite(Outils.getEND(t));
		
		Regle r14 = new Regle();
		r14.partieGauche = Outils.getStmt(nt);
		r14.addPartieDroite(Outils.getSimple_stmt(nt));
		r14.addPartieDroite(Outils.getNEWLINE(t));
		
		Regle r15 = new Regle();
		r15.partieGauche = Outils.getStmt(nt);
		r15.addPartieDroite(Outils.getIf(t));
		r15.addPartieDroite(Outils.getExpr_init(nt));
		r15.addPartieDroite(Outils.getDeuxPoints(t));
		r15.addPartieDroite(Outils.getSuite(nt));
		r15.addPartieDroite(Outils.getElseNT(nt));
		
		Regle r16 = new Regle();
		r16.partieGauche = Outils.getStmt(nt);
		r16.addPartieDroite(Outils.getFor(t));
		r16.addPartieDroite(Outils.getIdent(t));
		r16.addPartieDroite(Outils.getIn(t));
		r16.addPartieDroite(Outils.getExpr(nt));
		r16.addPartieDroite(Outils.getDeuxPoints(t));
		r16.addPartieDroite(Outils.getSuite(nt));
		
		Regle r17 = new Regle();
		r17.partieGauche = Outils.getElseNT(nt);
		r17.addPartieDroite(Outils.getElse(t));
		r17.addPartieDroite(Outils.getDeuxPoints(t));
		r17.addPartieDroite(Outils.getSuite(nt));
		
		Regle r18 = new Regle();
		r18.partieGauche = Outils.getElseNT(nt);
		r18.addPartieDroite(Outils.getEpsilon(t));
		
		Regle r19 = new Regle();
		r19.partieGauche = Outils.getSimple_stmt(nt);
		r19.addPartieDroite(Outils.getReturn(t));
		r19.addPartieDroite(Outils.getExpr(nt));
		
		Regle r20 = new Regle();
		r20.partieGauche = Outils.getSimple_stmt(nt);
		r20.addPartieDroite(Outils.getPrint(t));
		r20.addPartieDroite(Outils.getExpr(nt));
		
		Regle r21 = new Regle();
		r21.partieGauche = Outils.getSimple_stmt(nt);
		r21.addPartieDroite(Outils.getExpr_stmt(nt));
		r21.addPartieDroite(Outils.getAffect(nt));
		
		Regle r22 = new Regle();
		r22.partieGauche = Outils.getAffect(nt);
		r22.addPartieDroite(Outils.getEpsilon(t));
		
		Regle r23 = new Regle();
		r23.partieGauche = Outils.getAffect(nt);
		r23.addPartieDroite(Outils.getEgal(t));
		r23.addPartieDroite(Outils.getExpr_init(nt));
		
		Regle r24 = new Regle();
		r24.partieGauche = Outils.getExpr_init(nt);
		r24.addPartieDroite(Outils.getExpr(nt));
		r24.addPartieDroite(Outils.getExpr_droite(nt));
		
		Regle r25 = new Regle();
		r25.partieGauche = Outils.getExpr_stmt(nt);
		r25.addPartieDroite(Outils.getIdent(t));
		r25.addPartieDroite(Outils.getIdent_fact(nt));
		
		Regle r26 = new Regle();
		r26.partieGauche = Outils.getExpr_stmt(nt);
		r26.addPartieDroite(Outils.getMoins(t));
		r26.addPartieDroite(Outils.getExpr_init(nt));
		r26.addPartieDroite(Outils.getCrochetOuvrant(t));
		r26.addPartieDroite(Outils.getExpr_init(nt));
		r26.addPartieDroite(Outils.getCrochetFermant(t));
		
		Regle r27 = new Regle();
		r27.partieGauche = Outils.getExpr_stmt(nt);
		r27.addPartieDroite(Outils.getConst(nt));
		r27.addPartieDroite(Outils.getCrochetOuvrant(t));
		r27.addPartieDroite(Outils.getExpr_init(nt));
		r27.addPartieDroite(Outils.getCrochetFermant(t));
		
		Regle r28 = new Regle();
		r28.partieGauche = Outils.getExpr_stmt(nt);
		r28.addPartieDroite(Outils.getNot(t));
		r28.addPartieDroite(Outils.getExpr_init(nt));
		r28.addPartieDroite(Outils.getCrochetOuvrant(t));
		r28.addPartieDroite(Outils.getExpr_init(nt));
		r28.addPartieDroite(Outils.getCrochetFermant(t));
		
		Regle r29 = new Regle();
		r29.partieGauche = Outils.getExpr_stmt(nt);
		r29.addPartieDroite(Outils.getCrochetOuvrant(t));
		r29.addPartieDroite(Outils.getExpr_etoile_init(nt));
		r29.addPartieDroite(Outils.getCrochetFermant(t));
		r29.addPartieDroite(Outils.getCrochetOuvrant(t));
		r29.addPartieDroite(Outils.getExpr_init(nt));
		r29.addPartieDroite(Outils.getCrochetFermant(t));
		
		Regle r30 = new Regle();
		r30.partieGauche = Outils.getExpr_stmt(nt);
		r30.addPartieDroite(Outils.getParentheseOuvrante(t));
		r30.addPartieDroite(Outils.getExpr_init(nt));
		r30.addPartieDroite(Outils.getParentheseFermante(t));
		r30.addPartieDroite(Outils.getCrochetOuvrant(t));
		r30.addPartieDroite(Outils.getExpr_init(nt));
		r30.addPartieDroite(Outils.getCrochetFermant(t));
		
		
		Regle r31 = new Regle();
		r31.partieGauche = Outils.getIdent_fact(nt);
		r31.addPartieDroite(Outils.getEpsilon(t));
		
		Regle r32 = new Regle();
		r32.partieGauche = Outils.getIdent_fact(nt);
		r32.addPartieDroite(Outils.getBinop(nt));
		r32.addPartieDroite(Outils.getExpr(nt));
		r32.addPartieDroite(Outils.getExpr_prime(nt));
		
		Regle r33 = new Regle();
		r33.partieGauche = Outils.getIdent_fact(nt);
		r33.addPartieDroite(Outils.getParentheseOuvrante(t));
		r33.addPartieDroite(Outils.getExpr_etoile_init(nt));
		r33.addPartieDroite(Outils.getParentheseFermante(t));
		r33.addPartieDroite(Outils.getExpr_prime(nt));
		
		
		Regle r34 = new Regle();
		r34.partieGauche = Outils.getIdent_expr(nt);
		r34.addPartieDroite(Outils.getEpsilon(t));
		
		Regle r35 = new Regle();
		r35.partieGauche = Outils.getIdent_expr(nt);
		r35.addPartieDroite(Outils.getParentheseOuvrante(t));
		r35.addPartieDroite(Outils.getExpr_etoile_init(nt));
		r35.addPartieDroite(Outils.getParentheseFermante(t));
		
		Regle r36 = new Regle();
		r36.partieGauche = Outils.getExpr_droite(nt);
		r36.addPartieDroite(Outils.getExpr_prime(nt));
		r36.addPartieDroite(Outils.getExpr_droite(nt));
		
		Regle r37 = new Regle();
		r37.partieGauche = Outils.getExpr_droite(nt);
		r37.addPartieDroite(Outils.getEpsilon(t));
		
		Regle r38 = new Regle();
		r38.partieGauche = Outils.getExpr(nt);
		r38.addPartieDroite(Outils.getConst(nt));
		
		Regle r39 = new Regle();
		r39.partieGauche = Outils.getExpr(nt);
		r39.addPartieDroite(Outils.getIdent(t));
		r39.addPartieDroite(Outils.getIdent_expr(nt));
		
		Regle r40 = new Regle();
		r40.partieGauche = Outils.getExpr(nt);
		r40.addPartieDroite(Outils.getMoins(t));
		r40.addPartieDroite(Outils.getExpr(nt));
		
		Regle r41 = new Regle();
		r41.partieGauche = Outils.getExpr(nt);
		r41.addPartieDroite(Outils.getNot(t));
		r41.addPartieDroite(Outils.getExpr(nt));
		
		Regle r42 = new Regle();
		r42.partieGauche = Outils.getExpr(nt);
		r42.addPartieDroite(Outils.getCrochetOuvrant(t));
		r42.addPartieDroite(Outils.getExpr_etoile_init(nt));
		r42.addPartieDroite(Outils.getCrochetFermant(t));
		
		Regle r43 = new Regle();
		r43.partieGauche = Outils.getExpr(nt);
		r43.addPartieDroite(Outils.getParentheseOuvrante(t));
		r43.addPartieDroite(Outils.getExpr_init(nt));
		r43.addPartieDroite(Outils.getParentheseFermante(t));
		
		Regle r44 = new Regle();
		r44.partieGauche = Outils.getExpr_prime(nt);
		r44.addPartieDroite(Outils.getBinop(nt));
		r44.addPartieDroite(Outils.getExpr(nt));
		
		Regle r45 = new Regle();
		r45.partieGauche = Outils.getExpr_etoile_init(nt);
		r45.addPartieDroite(Outils.getEpsilon(t));
		
		Regle r46 = new Regle();
		r46.partieGauche = Outils.getExpr_etoile_init(nt);
		r46.addPartieDroite(Outils.getExpr(nt));
		r46.addPartieDroite(Outils.getExpr_etoile(nt));
		
		Regle r47 = new Regle();
		r47.partieGauche = Outils.getExpr_etoile(nt);
		r47.addPartieDroite(Outils.getVirgule(t));
		r47.addPartieDroite(Outils.getExpr(nt));
		r47.addPartieDroite(Outils.getExpr_etoile(nt));
		
		Regle r48 = new Regle();
		r48.partieGauche = Outils.getExpr_etoile(nt);
		r48.addPartieDroite(Outils.getEpsilon(t));
		
		Regle r49 = new Regle();
		r49.partieGauche = Outils.getBinop(nt);
		r49.addPartieDroite(Outils.getPlus(t));
		
		Regle r50 = new Regle();
		r50.partieGauche = Outils.getBinop(nt);
		r50.addPartieDroite(Outils.getMoins(t));
		
		Regle r51 = new Regle();
		r51.partieGauche = Outils.getBinop(nt);
		r51.addPartieDroite(Outils.getMult(t));
		
		Regle r52 = new Regle();
		r52.partieGauche = Outils.getBinop(nt);
		r52.addPartieDroite(Outils.getDiv(t));
		
		Regle r53 = new Regle();
		r53.partieGauche = Outils.getBinop(nt);
		r53.addPartieDroite(Outils.getPourcent(t));
		
		Regle r54 = new Regle();
		r54.partieGauche = Outils.getBinop(nt);
		r54.addPartieDroite(Outils.getInf(t));
		
		Regle r55 = new Regle();
		r55.partieGauche = Outils.getBinop(nt);
		r55.addPartieDroite(Outils.getSupEgal(t));
		
		Regle r56 = new Regle();
		r56.partieGauche = Outils.getBinop(nt);
		r56.addPartieDroite(Outils.getSup(t));
		
		Regle r57 = new Regle();
		r57.partieGauche = Outils.getBinop(nt);
		r57.addPartieDroite(Outils.getInfEgal(t));
		
		Regle r58 = new Regle();
		r58.partieGauche = Outils.getBinop(nt);
		r58.addPartieDroite(Outils.getNotEgal(t));
		
		Regle r59 = new Regle();
		r59.partieGauche = Outils.getBinop(nt);
		r59.addPartieDroite(Outils.getEgalBool(t));
		
		Regle rOr = new Regle();
		rOr.partieGauche = Outils.getBinop(nt);
		rOr.addPartieDroite(Outils.getOr(t));
		
		Regle rAnd = new Regle();
		rAnd.partieGauche = Outils.getBinop(nt);
		rAnd.addPartieDroite(Outils.getAnd(t));
		
		Regle r60 = new Regle();
		r60.partieGauche = Outils.getConst(nt);
		r60.addPartieDroite(Outils.getInt(t));
		
		Regle r61 = new Regle();
		r61.partieGauche = Outils.getConst(nt);
		r61.addPartieDroite(Outils.getStr(t));
		
		Regle r62 = new Regle();
		r62.partieGauche = Outils.getConst(nt);
		r62.addPartieDroite(Outils.getTrue(t));
		
		Regle r63 = new Regle();
		r63.partieGauche = Outils.getConst(nt);
		r63.addPartieDroite(Outils.getFalse(t));
		
		Regle r64 = new Regle();
		r64.partieGauche = Outils.getConst(nt);
		r64.addPartieDroite(Outils.getNone(t));
		

		regles.add(r1);
		regles.add(r2);
		regles.add(r3);
		regles.add(r4);
		regles.add(r5);
		regles.add(r6);
		regles.add(r7);
		regles.add(r8);
		regles.add(r9);
		regles.add(r10);
		regles.add(r11);
		regles.add(r12);
		regles.add(r13);
		regles.add(r14);
		regles.add(r15);
		regles.add(r16);
		regles.add(r17);
		regles.add(r18);
		regles.add(r19);
		regles.add(r20);
		regles.add(r21);
		regles.add(r22);
		regles.add(r23);
		regles.add(r24);
		regles.add(r25);
		regles.add(r26);
		regles.add(r27);
		regles.add(r28);
		regles.add(r29);
		regles.add(r30);
		regles.add(r31);
		regles.add(r32);
		regles.add(r33);
		regles.add(r34);
		regles.add(r35);
		regles.add(r36);
		regles.add(r37);
		regles.add(r38);
		regles.add(r39);
		regles.add(r40);
		regles.add(r41);
		regles.add(r42);
		regles.add(r43);
		regles.add(r44);
		regles.add(r45);
		regles.add(r46);
		regles.add(r47);
		regles.add(r48);
		regles.add(r49);
		regles.add(r50);
		regles.add(r51);
		regles.add(r52);
		regles.add(r53);
		regles.add(r54);
		regles.add(r55);
		regles.add(r56);
		regles.add(r57);
		regles.add(r58);
		regles.add(r59);
		regles.add(r60);
		regles.add(r61);
		regles.add(r62);
		regles.add(r63);
		regles.add(r64);
		regles.add(rOr);
		regles.add(rAnd);
		
		return regles;
	}
	

}
