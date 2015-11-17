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
	
	public JPLInterface(){
		facts = new ArrayList<String>();
		rules = new ArrayList<String>();
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
		System.out.println("Länge der Map " + solutions.length);
		for(int i = 0; i < solutions.length; i++){
			Iterator it = solutions[i].entrySet().iterator();
			while(it.hasNext()){
				Map.Entry pair = (Map.Entry)it.next();
		        System.out.println(pair.getKey() + " = " + pair.getValue());
		        it.remove();			}
		}
		return solutions;
	}
	
	public boolean queryClause(String fact){
		Query q = new Query(fact);
		return q.hasSolution();
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

}
