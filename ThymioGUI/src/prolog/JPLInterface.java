package prolog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;

import jpl.JPL;

public class JPLInterface {
	
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
	
	public JPLInterface(){
		facts = new ArrayList<String>();
		rules = new ArrayList<String>();
		currentRequestError = "";
		currentMovementError = "";
		blocked = new ArrayList<int[]>();
		resetAll();	
	}
	
	public void test(){
		System.out.println("############ TEST");
		for(int i = 0; i < facts.size(); i++){
			System.out.println(facts.get(i));
		}
		for(int i = 0; i < rules.size(); i++){
			System.out.println(rules.get(i));
		}
	}
	
	public void resetAll(){
		retractAll();
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
	
	public void checkMovementLeft(){
		currentMovementError = "";
		
		String request = "poss(left(thymio))";
		
	}
	
	public void checkMovementRight(){
		currentMovementError = "";
		
		String request = "poss(right(thymio))";
		
		try {
			if(queryClause(request)){
				setCurrentMovementPossibleProlog(true);
				
			} else{
				setCurrentMovementPossibleProlog(false);
			}
		} catch(Exception e){
			
		}
		
	}
	
	public void checkMovementUp(){
		currentMovementError = "";
		
		String request = "poss(up(thymio))";
		
	}
	
	public void checkMovementDown(){
		currentMovementError = "";
		
		String request = "poss(down(thymio))";
		
	}
	
	private void checkMovementUi(int moveX, int moveY){
		int newPosX = thymioX + moveX;
		int newPosY = thymioY + moveY;
		if(newPosX >= fieldLengthX || newPosX < 0 || newPosY >= fieldLengthY || newPosY < 0){
			if(checkOnBlocked(newPosX, newPosY)){
				
			}
		}
	}
	
	private boolean checkOnBlocked(int x, int y){
		return false;
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
		rules.clear();
	}
	
	private void retractClause(String clause){
		Query q = new Query(buildRetractQuery(clause));
		q.hasSolution();
	}
	
	private String buildRetractQuery(String clause){
		String retractQuery = "retract(" + clause +")";
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
		new Query (buildAssertQuery(rule)).hasSolution();
	}
	
	private String buildAssertQuery(String clause){
		String assertQuery = "assert(" + clause + ")";
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
}
