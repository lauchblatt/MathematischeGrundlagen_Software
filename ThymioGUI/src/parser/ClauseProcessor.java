package parser;

import jpl.Util;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class ClauseProcessor {
	public ClauseProcessor() {
	}
	
	public String process(String input) {
		HelloParser parser=new HelloParser(new CommonTokenStream(new HelloLexer(new ANTLRInputStream(input))));

		parser.setBuildParseTree(true);  
		HelloParser.Th_ruleContext tree = parser.th_rule();
		ClauseListener listener = new ClauseListener();
		ParseTreeWalker walker = new ParseTreeWalker();
		
		walker.walk(listener,tree);
		
		System.out.println(listener.getPrologClause());
		return listener.getPrologClause();
		//System.out.println(Util.textToTerm(listener.getPrologClause()));
	}
	
	public static void main(String [] args) {
		ClauseProcessor cp = new ClauseProcessor();
		
		cp.process("A=test(X,S) & open(X,S) -> closed(X,do(A,S)).");		
		cp.process("A=hi & open(X,Y) -> closed(X,Y).");		
		cp.process("A=hi & !open(X,Y) -> closed(X,Y).");		
		cp.process("X>=Y -> poss(right(T),S).");		
		cp.process("X>=Y -> poss(right(T),S).");		
		cp.process("X<=Y+1 -> poss(right(T),S).");		
		cp.process("X<Y-5 & Z>=7 -> poss(right(T),S).");		
		cp.process("!(X<Y-5) & Z>=7 -> poss(right(T),S).");		
		cp.process("!(X<Y-5) & Z==X-7 -> poss(right(T),S).");		
		cp.process("!(X==Y-5) & Z<7 -> poss(right(T),S).");
		cp.process("A=right(t) AND position(t,X,Z,S) AND Y == Z+1 -> position(t,X,Y,do(A,S)).");
	}
}
