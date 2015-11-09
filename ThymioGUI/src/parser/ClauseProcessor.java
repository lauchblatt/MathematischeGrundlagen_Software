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
		
		//System.out.println(listener.getPrologClause());
		//System.out.println(Util.textToTerm(listener.getPrologClause()));
		return listener.getPrologClause();
	}
	
	public static void main(String [] args) {
		ClauseProcessor cp = new ClauseProcessor();
		
		cp.process("A=test(X,S) & open(X,S) -> closed(X,do(A,S)).");		
	}
}
