package parser;

public class ClauseListener extends HelloBaseListener {
	private String prologClause;

	@Override
    public void exitTh_rule(HelloParser.Th_ruleContext ctx) {
		prologClause = ctx.th_consequence().f + ":-" + ctx.th_premise().f + ".";
    }
	
	public String getPrologClause() {
		return prologClause;
	}
}
