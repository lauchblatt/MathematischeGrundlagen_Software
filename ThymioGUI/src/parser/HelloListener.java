// Generated from Hello.g4 by ANTLR 4.5.1

package parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HelloParser}.
 */
public interface HelloListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HelloParser#th_rule}.
	 * @param ctx the parse tree
	 */
	void enterTh_rule(HelloParser.Th_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#th_rule}.
	 * @param ctx the parse tree
	 */
	void exitTh_rule(HelloParser.Th_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#th_premise}.
	 * @param ctx the parse tree
	 */
	void enterTh_premise(HelloParser.Th_premiseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#th_premise}.
	 * @param ctx the parse tree
	 */
	void exitTh_premise(HelloParser.Th_premiseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#th_consequence}.
	 * @param ctx the parse tree
	 */
	void enterTh_consequence(HelloParser.Th_consequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#th_consequence}.
	 * @param ctx the parse tree
	 */
	void exitTh_consequence(HelloParser.Th_consequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#poss_formula}.
	 * @param ctx the parse tree
	 */
	void enterPoss_formula(HelloParser.Poss_formulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#poss_formula}.
	 * @param ctx the parse tree
	 */
	void exitPoss_formula(HelloParser.Poss_formulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#fluent_formula}.
	 * @param ctx the parse tree
	 */
	void enterFluent_formula(HelloParser.Fluent_formulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#fluent_formula}.
	 * @param ctx the parse tree
	 */
	void exitFluent_formula(HelloParser.Fluent_formulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#do_formula}.
	 * @param ctx the parse tree
	 */
	void enterDo_formula(HelloParser.Do_formulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#do_formula}.
	 * @param ctx the parse tree
	 */
	void exitDo_formula(HelloParser.Do_formulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#id_formula}.
	 * @param ctx the parse tree
	 */
	void enterId_formula(HelloParser.Id_formulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#id_formula}.
	 * @param ctx the parse tree
	 */
	void exitId_formula(HelloParser.Id_formulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#th_formula}.
	 * @param ctx the parse tree
	 */
	void enterTh_formula(HelloParser.Th_formulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#th_formula}.
	 * @param ctx the parse tree
	 */
	void exitTh_formula(HelloParser.Th_formulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(HelloParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(HelloParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(HelloParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(HelloParser.ArgContext ctx);
}