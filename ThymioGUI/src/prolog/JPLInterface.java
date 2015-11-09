package prolog;

import java.util.ArrayList;

import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;

import jpl.JPL;

public class JPLInterface {
	
	private ArrayList<String> clauses;
	
	public JPLInterface(){
		clauses = new ArrayList<String>();
		resetKnowledgeBase();	
	}
	
	public void test(){
	}
	
	public void resetKnowledgeBase(){
		retractAll();
		System.out.println("reset Knowledge Base");
	}
	
	public void updateKnowledgeBase(String text){
		resetKnowledgeBase();
		
		String[] facts = text.split("\\.\n");
		
		for(int i = 0; i < facts.length; i++){
			System.out.println(facts[i]);
			addClause(facts[i]);
		}
		
	}
	
	private void retractAll(){
		for(int i = 0; i < clauses.size(); i++){
			String currentFact = clauses.get(i);
			System.out.println(currentFact);
			retractClause(currentFact);
		}
		clauses.clear();
	}
	
	private void retractClause(String clause){
		Query q = new Query(buildRetractQuery(clause));
		q.hasSolution();
	}
	
	private String buildRetractQuery(String clause){
		String retractQuery = "retract(" + clause +")";
		return retractQuery;
	}
	
	public boolean queryFact(String fact){
		Query q = new Query(fact);
		return q.hasSolution();
	}
	
	public void addClause(String clause){
		clauses.add(clause);
		new Query (buildAssertQuery(clause)).hasSolution();
	}
	
	private String buildAssertQuery(String clause){
		String assertQuery = "assert(" + clause + ")";
		return assertQuery;
	}
	
	public ArrayList<String> getClauses(){
		return clauses;
	}

}
