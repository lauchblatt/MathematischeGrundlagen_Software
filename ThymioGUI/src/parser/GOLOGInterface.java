package parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import jpl.Atom;
import jpl.Compound;
import jpl.Query;
import jpl.Term;
import jpl.Util;
import jpl.Variable;

public class GOLOGInterface {
	private Query currentQuery;

	public static GOLOGInterface myInterface = null;
	
	public static GOLOGInterface getGOLOGInterface() {
		if (myInterface == null) myInterface = new GOLOGInterface();
		
		return myInterface;
	}
	
	private GOLOGInterface() {
		currentQuery = null;

		Query q2 =
				new Query(
						"consult", new Term [] {new Atom("golog_swi.pl")}
						);
		
		System.out.println("GOLOG initialized: " + q2.hasSolution());
		
		q2 =
				new Query(
						"consult", new Term [] {new Atom("boris.pl")}
						);
		
		System.out.println("Cocktailmixer initialized: " + q2.hasSolution());
	}
	
	public boolean performQuery(Query q) {
		boolean result;
		
		currentQuery = q;
		result = currentQuery.hasSolution();
		
		if (result == false) System.out.println("query " + q.toString() + " failed.");
		
		return result;
	}
	
	public void parseJPLTerm(Object t, ArrayList<String> actionStack) {
		if (t instanceof Atom) {
			System.out.println("Atom: " + ((Atom)t).name());
			if (((Atom)t).name().equals("s0")) return;
		}
		
		else if (t instanceof Variable) {
			System.out.println("Variable: " + ((Variable)t).name());			
		}
		else if (t instanceof jpl.Float) {
			
		}
		else if (t instanceof Compound) {
			Compound term = (Compound)t;
			
			if (term.name().equals("do")) {
				// process actions

				Term [] ta = term.args();
				
				parseJPLTerm(ta[0], actionStack);
				parseJPLTerm(ta[1], actionStack);
			}
			else {
				String action = term.name();
				Term [] ta = term.args();
				
				action += "\t" + ta[0];
				for (int i = 1; i < ta.length; i++) action += "\t" + ta[i];
				
				actionStack.add(0, action);
			}
			/*
			else if (term.name().equals("consume")) {
				String ingredient;
				int volume;
				Term [] ta = term.args();
				
				if ((ta[1] instanceof jpl.Integer) && (ta[2] instanceof Atom)) {
					volume = ((jpl.Integer)ta[1]).intValue();
					ingredient = ((Atom)ta[2]).name();
					
					actionStack.add(0, new String("bottle: " + ingredient + " vol: " + volume + " ml"));
				}
				else {
					System.out.println(ta[1].getClass().getName());
					System.out.println(ta[2].getClass().getName());
				}
			}
			else if (term.name().equals("alert_on_display")) {
				actionStack.add(0, term.name());
			}
			else if (term.name().equals("send_sms")) {
				actionStack.add(0, term.name());
			}*/
		}
	}
	
	public static void main(String [] args) {
	    Query q1 =
	            new Query(
	                "consult",
	                new Term[] {new Atom("golog_swi.pl")}
	            );
	    
	    System.out.println( "consult " + (q1.hasSolution() ? "succeeded" : "failed"));

	     q1 =
	            new Query(
	                "consult",
	                new Term[] {new Atom("boris.pl")}
	            );
	    
	    System.out.println( "consult " + (q1.hasSolution() ? "succeeded" : "failed"));
	    
	    Query q2 =
	            new Query(
	            		Util.textToTerm("do(put_glass_on_holder(meier,b) : detect_glass(b) : ?(glass_holder_empty(b)),s0,S)")
	                //new Compound( "do", new Term[] { new Compound("put_glass_on_holder", new Term [] {new Atom("meier"), new Atom("b")}), new Atom("s0"), new Variable("S")})
	            );
	   
	    System.out.println(q2);
	    if (q2.hasSolution()) {
	    	while (q2.hasMoreSolutions()) {
	    		Hashtable assignments = q2.nextSolution();
	    		Enumeration sol = assignments.keys();
	    		 if (sol.hasMoreElements()) {
	    			 while (sol.hasMoreElements()) {
	    				 Object key = sol.nextElement();
	    				 System.out.println(key + " = " + assignments.get(key));
	    			 }
	    		 }
	    		 else System.out.println("this is possible.");
	    	}
	    }
	    else System.out.println("this is NOT possible.");
	}
}
