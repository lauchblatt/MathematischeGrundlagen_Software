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
	
	private static final boolean ASSERT_CORRECT_SOLUTION = false;
	
	private ArrayList<String> facts;
	private ArrayList<String> rules;
	private String currentRequestError;
	private String currentMovementError;
	private boolean currentMovementPossibleProlog;
	private boolean currentMovementPossibleUi;
	
	private int fieldLengthX;
	private int fieldLengthY;
	private int thymioX;
	private int thymioY;
	private ArrayList<int[]> blocked;
	
	private String currentSituation;
	private String nextSituation;
	private String eol;
	
	private ArrayList<String> fluents;
	
	public JPLInterface(){
		eol = System.getProperty("line.separator");
		
		fluents = new ArrayList<String>();
		facts = new ArrayList<String>();
		rules = new ArrayList<String>();
		currentRequestError = "";
		setCurrentMovementError("");
		blocked = new ArrayList<int[]>();
		currentSituation = "s0";
		resetAll();
		if(ASSERT_CORRECT_SOLUTION){
			assertCorrectSolution();
		}
		
	}
	
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
	
	//Test Method that asserts the correct Solution in the Beginning
	public void assertCorrectSolution(){
		addRule("poss(right(t),S):-thymio(t), position(t,X,Y,S), Y<1,Y>=0,X>=0,X<2");
		addRule("poss(left(t),S):-thymio(t), position(t,X,Y,S), Y<2, Y>0, X>=0,X<2");
		addRule("poss(down(t),S):-thymio(t), position(t,X,Y,S), Y<2, Y>=0, X<1,X>=0");
		addRule("poss(up(t),S):-thymio(t), position(t,X,Y,S), Y<2, Y>=0, X<2, X>0");
		
		addRule("position(t,X,Y,do(A,S)) :- (A=right(t),position(t,X,Z,S),Y is Z+1);(A=left(t),position(t,X,Z,S),Y is Z-1);(A=up(t),position(t,Z,Y,S), X is Z-1);(A=down(t),position(t,Z,Y,S),X is Z+1)");
	}
	
	public void resetAll(){
		currentSituation = "s0";
		retractAll();
		if(ASSERT_CORRECT_SOLUTION){
			assertCorrectSolution();
		}
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
	
	private void setNextSituation (String movement){

		nextSituation = "do(" + movement + "(t)," + currentSituation + ")";
		
	}
	
	private String getPossQuery (String movement){
		String possQuery = "poss(" + movement + "(t)," + currentSituation + ")";
		return possQuery;
	}
	
	public boolean checkMovement (String movement, int newX, int newY){
		currentMovementError = "";
		
		String possQuery = getPossQuery(movement);

		boolean possible = false;
		boolean positionIsCorrect = false;
		
		try {
			Query q = new Query(possQuery);
			possible = q.hasSolution();
		} catch (Exception e){
			//If poss is not even defined
		}
		if(!possible){		
			currentMovementError = eol + "FALSE: " + possQuery + " kann nicht inferiert werden.";
		}else{
			currentMovementError = eol + "TRUE: " + possQuery + " kann inferiert werden.";
			setNextSituation(movement);
			
			positionIsCorrect = checkNewPosition(newX, newY);
			
			
		}

		return (possible && positionIsCorrect);
	}
	
	public void setNewSituation(){

			currentSituation = nextSituation;

	}
	
	private boolean checkNewPosition(int posX, int posY){
		String positionString = "position(t," + posX + "," + posY + "," + nextSituation + ")";
		Query q = new Query("position(t," + posX + "," + posY + "," + nextSituation + ")");
		
		System.out.println("positionString" + positionString);
		if(q.hasSolution()){
			currentMovementError = currentMovementError + eol + "TRUE: " + positionString + " kann inferiert werden.";
			return true;
		}else{
			currentMovementError = currentMovementError + eol + "FALSE: " + positionString + " kann nicht inferiert werden.";
			return false;
		}
	}
	
	public void addToFluents(int posX, int posY){
		String positionString = "position(t," + posX + "," + posY + "," + currentSituation + ")";
		fluents.add(positionString);
	}
	
	public void updateFacts(String text){
		resetFacts();
		
		String[] facts = text.split("\\.\n");
		
		for(int i = 0; i < facts.length; i++){
			addFact(facts[i]);
		}
		
	}
	
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
	
	public Map<String, Term>[] request(String request){
		Query q = new Query(request);
		Map<String, Term>[] solutions = q.allSolutions(request);
		
		return solutions;
	}
	
	public boolean queryClause(String fact){
		try{
			Query q = new Query(fact);
			if(q.hasSolution()){
				currentRequestError = "";
				return true;
			}else{
				currentRequestError = "";
				return false;
			}
		} catch (Exception e){
			currentRequestError = getErrorType(e);
			return false;
		}
	}
	
	private String getErrorType(Exception e){
		String message = e.getMessage();
		int pos1 = ordinalIndexOf(message, '(', 0);
		int pos2 = ordinalIndexOf(message, '(', 1);
		message = message.substring(pos1+1, pos2);

		return message;
	}
	
	private int ordinalIndexOf(String str, char c, int n) {
	    int pos = str.indexOf(c, 0);
	    while (n-- > 0 && pos != -1)
	        pos = str.indexOf(c, pos+1);
	    return pos;
	}
	
	public void addFact(String clause){
		facts.add(clause);
		new Query (buildAssertQuery(clause)).hasSolution();
	}
	
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
	
	private String buildAssertQuery(String clause){
		String assertQuery = "assert((" + clause + "))";
		return assertQuery;
	}
	
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
