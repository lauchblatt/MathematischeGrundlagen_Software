package prolog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;

import parser.ClauseProcessor;
import jpl.JPL;

public class JPLInterface {
	
	//True setzen wenn zu Beginn die korrekte L�sung angenommen werden soll
	private static final boolean ASSERT_CORRECT_SOLUTION = false;
	
	//Interne Listen zur Verwaltung der Regeln, Fakten und Fluenten
	private ArrayList<String> facts;
	private ArrayList<String> rules;
	private ArrayList<String> fluents;
	
	//Felder um f�r alle Fehlerarten, korrekte Fehlermeldungen zu formulieren
	private String currentRequestError;
	private String currentMovementError;
	
	//Felder um dynamisch anzupassen ob Bewegung in Prolog und im UI m�glich ist
	private boolean currentMovementPossibleProlog;
	private boolean currentMovementPossibleUi;
	
	//L�nge der Felder
	private int fieldLengthX;
	private int fieldLengthY;
	
	//Position des Thymios
	private int thymioX;
	private int thymioY;
	
	//Blockierte Felder als Tupel aus zwei Koordinaten
	private ArrayList<int[]> blocked;
	
	//Aktuelle und n�chste Situation mit Situationskalk�l sichern z.B. s0 oder do(right(t),s0)
	private String currentSituation;
	private String nextSituation;
	//Line-Seperator zur Versch�nerung der Meldungen
	private String eol;
	
	
	public JPLInterface(){
		//Line-Seperatur auf System-Basis holen, zur Versch�nerung der textuellen Meldungen
		eol = System.getProperty("line.separator");
		
		fluents = new ArrayList<String>();
		facts = new ArrayList<String>();
		rules = new ArrayList<String>();
		currentRequestError = "";
		setCurrentMovementError("");
		blocked = new ArrayList<int[]>();
		//Erste Situation ist s0
		currentSituation = "s0";
		resetAll();
		if(ASSERT_CORRECT_SOLUTION){
			assertCorrectSolution();
		}
		
	}
	
	//Testmetode um Fakten und Regeln auszugeben
	public void test(){
		System.out.println("############ TEST");
		for(int i = 0; i < facts.size(); i++){
			System.out.println(facts.get(i));
		}
		for(int i = 0; i < rules.size(); i++){
			System.out.println(rules.get(i));
		}
		System.out.println("Situation " + currentSituation);
	}
	
	//Testmethode, die die korrekte L�sung am Anfang angibt, !!! Koordinatensystem basiert auf Java-Grafiken
	public void assertCorrectSolution(){
		addRule("poss(right(t),S):-thymio(t), position(t,X,Y,S), Y<1,Y>=0,X>=0,X<2");
		addRule("poss(left(t),S):-thymio(t), position(t,X,Y,S), Y<2, Y>0, X>=0,X<2");
		addRule("poss(down(t),S):-thymio(t), position(t,X,Y,S), Y<2, Y>=0, X<1,X>=0");
		addRule("poss(up(t),S):-thymio(t), position(t,X,Y,S), Y<2, Y>=0, X<2, X>0");
		
		addRule("position(t,X,Y,do(A,S)) :- (A=right(t),position(t,X,Z,S),Y is Z+1)");
		addRule("position(t,X,Y,do(A,S)) :- (A=left(t),position(t,X,Z,S),Y is Z-1)");
		addRule("position(t,X,Y,do(A,S)) :- (A=up(t),position(t,Z,Y,S), X is Z-1)");
		addRule("position(t,X,Y,do(A,S)) :- (A=down(t),position(t,Z,Y,S),X is Z+1)");
		
		//addRule("position(t,X,Y,do(A,S)) :- (A=right(t),position(t,X,Z,S),Y is Z+1);(A=left(t),position(t,X,Z,S),Y is Z-1);(A=up(t),position(t,Z,Y,S), X is Z-1);(A=down(t),position(t,Z,Y,S),X is Z+1)");
	}
	
	//Methode um Zustand zu reseten auf s0, wird gleich bei der Initialisierung aufgerufen
	public void resetAll(){
		currentSituation = "s0";
		//Alle Fakten und Regeln zur�ckziehen
		retractAll();
		if(ASSERT_CORRECT_SOLUTION){
			assertCorrectSolution();
		}
		//Regeln die �ber das UI bereits eingegeben wurden, werden erneut hinzugef�gt
		addAllRules();
	}
	
	public void resetFacts(){
		retractAllFacts();
	}
	
	public void resetRules(){
		retractAllRules();
	}
	
	public void removeRuleByIndex(int index){
		retractClause(rules.get(index));
		rules.remove(index);
	}
	
	//Methode um die n�chste Situation zu setzen �ber die neue Aktion und den bisherigen Zustand
	private void setNextSituation (String movement){

		nextSituation = "do(" + movement + "(t)," + currentSituation + ")";
		
	}
	
	//Methode um den poss-Fakt f�r die n�chste Situation abzufragen, erh�lt die aktuelle Akion
	private String getPossQuery (String movement){
		String possQuery = "poss(" + movement + "(t)," + currentSituation + ")";
		return possQuery;
	}
	
	//Methode um zu pr�fen ob die Aktion gem�� Prolog-Logik m�glich ist
	public boolean checkMovement (String movement, int newX, int newY){
		currentMovementError = "";
		
		//Aktuelle poss-Abfrage bilden
		String possQuery = getPossQuery(movement);
		
		//poss-Klausel f�r n�chste Situation wird abgefragt
		boolean possible = false;
		//position-Klausel f�r n�chste Situation wird abgefragt
		boolean positionIsCorrect = false;
		
		try {
			Query q = new Query(possQuery);
			//Abfrage ob Bewegung gem�� Prolog m�glich ist, �ber Abfrage der poss-Query
			possible = q.hasSolution();
		} catch (Exception e){
			//If poss is not even defined
		}
		if(!possible){	
			//Wenn m�glich --> negatives Feedback
			currentMovementError = eol + "FALSE: " + possQuery + " kann nicht inferiert werden.";
		}else{
			//Wenn nicht m�glich, positives Feedback
			currentMovementError = eol + "TRUE: " + possQuery + " kann inferiert werden.";
			//Situation wird hochgez�hlt
			setNextSituation(movement);
			
			//Abpr�fen ob neue Position als Fluent auch gefolgert werden kann
			positionIsCorrect = checkNewPosition(newX, newY);
			
			
		}
		
		//return nur true, wenn sowohl poss-Klausel als auch position-Fluent true sind
		return (possible && positionIsCorrect);
	}
	
	public void setNewSituation(){

			currentSituation = nextSituation;

	}
	
	//Methode um abzupr�fen ob position-Fakt auch gefolgert werden kann z.B. position(t, 0, 1, s0)
	private boolean checkNewPosition(int posX, int posY){
		
		// Query zur Abfrage bilden
		String positionString = "position(t," + posX + "," + posY + "," + nextSituation + ")";
		Query q = new Query("position(t," + posX + "," + posY + "," + nextSituation + ")");
		
		System.out.println("positionString" + positionString);
		if(q.hasSolution()){
			//Wenn Abfrage korrekt --> positives Feedbackk
			currentMovementError = currentMovementError + eol + "TRUE: " + positionString + " kann inferiert werden.";
			return true;
		}else{
			//Wenn Abfrage nicht m�glich --> negatives Feedback
			currentMovementError = currentMovementError + eol + "FALSE: " + positionString + " kann nicht inferiert werden.";
			return false;
		}
	}
	
	//Methode um Fakten zu Fluenten hinzuzuf�gen
	public void addToFluents(int posX, int posY){
		String positionString = "position(t," + posX + "," + posY + "," + currentSituation + ")";
		fluents.add(positionString);
	}
	
	//Methode um Text aus dem UI in Prolog Fakten umzuwandeln
	public void updateFacts(String text){
		resetFacts();
		
		//Text wird auf Basis von .\n gesetzt
		String[] facts = text.split("\\.\n");
		
		for(int i = 0; i < facts.length; i++){
			addFact(facts[i]);
		}
		
	}
	
	/* 
	 * Hilfsmethoden um Fakten,Regeln aus der Prolog-Logik zu entfernen
	 */
	
	private void retractAll(){
		retractAllFacts();
		retractAllRules();
	}
	
	private void retractAllFacts(){
		for(int i = 0; i < facts.size(); i++){
			String currentFact = facts.get(i);
			retractClause(currentFact);
		}
		facts.clear();
	}
	
	private void retractAllRules(){
		for(int i = 0; i < rules.size(); i++){
			String currentRule = rules.get(i);
			retractClause(currentRule);
		}
		//rules.clear();
	}
	
	private void retractClause(String clause){
		Query q = new Query(buildRetractQuery(clause));
		q.hasSolution();
	}
	
	private String buildRetractQuery(String clause){
		String retractQuery = "retract((" + clause +"))";
		return retractQuery;
	}
	
	/*
	 * Hilfsmethoden zur Interaktion mit Prolog
	 */
	
	//Methode um generelle Anfragen an Prolog zu stellen und alle L�sungen zur�ckzubekommen
	public Map<String, Term>[] request(String request){
		Query q = new Query(request);
		Map<String, Term>[] solutions = q.allSolutions(request);
		
		return solutions;
	}
	
	//Methode um generelle Anfragen an Prolog zu stellen, gibt nur true oder false zur�ck, oder den Fehler
	public boolean queryClause(String fact){
		try{
			Query q = new Query(fact);
			if(q.hasSolution()){
				//Keine Requestfehler-Text wird gesetzt, wenn L�sung aus Prolog zu folgern ist
				currentRequestError = "";
				return true;
			}else{
				//Keine Requestfehler-Text wird gesetzt, wenn L�sung aus Prolog zu folgern ist
				currentRequestError = "";
				return false;
			}
		} catch (Exception e){
			currentRequestError = getErrorType(e);
			return false;
		}
	}
	
	//Methode um Prolog-Ausgabe-Fehler anzupassen und auszugeben, bei generellen Anfragen
	private String getErrorType(Exception e){
		String message = e.getMessage();
		int pos1 = ordinalIndexOf(message, '(', 0);
		int pos2 = ordinalIndexOf(message, '(', 1);
		message = message.substring(pos1+1, pos2);

		return message;
	}
	
	//Hilfsmethode um obige Fehlerausgabe anzupassen
	private int ordinalIndexOf(String str, char c, int n) {
	    int pos = str.indexOf(c, 0);
	    while (n-- > 0 && pos != -1)
	        pos = str.indexOf(c, pos+1);
	    return pos;
	}
	
	/*
	 * Methoden um Fakten und Regeln der Prolog-Logik hinzuzuf�gen
	 */
	
	//Fakt wird Prolog-Logik und eigener Fakten-Liste hinzugef�gt
	public void addFact(String clause){
		facts.add(clause);
		new Query (buildAssertQuery(clause)).hasSolution();
	}
	
	//Regel wird Prolog-Logik und eigener Regel-Liste hinzugef�gt
	public void addRule(String rule){
		rules.add(rule);
		System.out.println("Rule " + rule);
		System.out.println("ASSErt " + buildAssertQuery(rule));
		new Query (buildAssertQuery(rule)).hasSolution();
	}
	
	public void addAllRules(){
		for(int i = 0; i < rules.size(); i++){
			new Query (buildAssertQuery(rules.get(i))).hasSolution();
		}
	}
	
	//Hilfsmethode um assert-Query f�r Prolog-Logik zu bilden
	private String buildAssertQuery(String clause){
		String assertQuery = "assert((" + clause + "))";
		return assertQuery;
	}
	
	/*
	 * Setter- und Getter-Methoden
	 */
	public ArrayList<String> getFacts(){
		return facts;
	}
	
	public ArrayList<String> getRules(){
		return rules;
	}

	public String getCurrentRequestError() {
		return currentRequestError;
	}

	public void setCurrentRequestError(String currentRequestError) {
		this.currentRequestError = currentRequestError;
	}

	public boolean isCurrentMovementPossibleProlog() {
		return currentMovementPossibleProlog;
	}

	public void setCurrentMovementPossibleProlog(
			boolean currentMovementPossibleProlog) {
		this.currentMovementPossibleProlog = currentMovementPossibleProlog;
	}

	public boolean isCurrentMovementPossibleUi() {
		return currentMovementPossibleUi;
	}

	public void setCurrentMovementPossibleUi(boolean currentMovementPossibleUi) {
		this.currentMovementPossibleUi = currentMovementPossibleUi;
	}
	
	public void addToBlocked(int[] blockedField){
		blocked.add(blockedField);
		
		System.out.println("##### blocked");
		for(int i = 0; i < blocked.size(); i++){
			for(int j = 0; j < blocked.get(i).length; j++){
				System.out.println(blocked.get(i)[j]);
			}
		}
	}
	
	public void resetBlocked(){
		blocked.clear();
	}


	public int getFieldLengthX() {
		return fieldLengthX;
	}


	public void setFieldLengthX(int fieldLengthX) {
		this.fieldLengthX = fieldLengthX;
	}


	public int getFieldLengthY() {
		return fieldLengthY;
	}


	public void setFieldLengthY(int fieldLengthY) {
		this.fieldLengthY = fieldLengthY;
	}


	public ArrayList<int[]> getBlocked() {
		return blocked;
	}


	public void setBlocked(ArrayList<int[]> blocked) {
		this.blocked = blocked;
	}

	public int getThymioX() {
		return thymioX;
	}

	public void setThymioX(int thymioX) {
		this.thymioX = thymioX;
	}

	public int getThymioY() {
		return thymioY;
	}

	public void setThymioY(int thymioY) {
		this.thymioY = thymioY;
	}

	public String getCurrentMovementError() {
		return currentMovementError;
	}

	public void setCurrentMovementError(String currentMovementError) {
		this.currentMovementError = currentMovementError;
	}
	
	public ArrayList<String> getFluents() {
		return fluents;
	}
}
