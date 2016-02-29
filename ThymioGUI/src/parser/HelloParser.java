// Generated from Hello.g4 by ANTLR 4.5.1

package parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HelloParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TK_AND=1, TK_OR=2, TK_POSS=3, TK_DO=4, TK_ID=5, TK_VAR=6, TK_IMP=7, TK_SEP=8, 
		TK_EQUAL=9, TK_NUM_EQUAL=10, TK_DOT=11, TK_NEG=12, TK_BRK_OPEN=13, TK_BRK_CLOSE=14, 
		TK_GEQ=15, TK_GE=16, TK_LEQ=17, TK_LE=18, TK_PLUS=19, TK_MINUS=20, TK_NUM=21, 
		WS=22;
	public static final int
		RULE_th_rule = 0, RULE_th_premise = 1, RULE_th_consequence = 2, RULE_poss_formula = 3, 
		RULE_fluent_formula = 4, RULE_do_formula = 5, RULE_id_formula = 6, RULE_neg_formula = 7, 
		RULE_comp_formula = 8, RULE_expr = 9, RULE_op = 10, RULE_th_formula = 11, 
		RULE_args = 12, RULE_arg = 13;
	public static final String[] ruleNames = {
		"th_rule", "th_premise", "th_consequence", "poss_formula", "fluent_formula", 
		"do_formula", "id_formula", "neg_formula", "comp_formula", "expr", "op", 
		"th_formula", "args", "arg"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'poss'", "'do'", null, null, "'->'", "','", "'='", 
		"'=='", "'.'", null, "'('", "')'", "'>='", "'>'", "'<='", "'<'", "'+'", 
		"'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TK_AND", "TK_OR", "TK_POSS", "TK_DO", "TK_ID", "TK_VAR", "TK_IMP", 
		"TK_SEP", "TK_EQUAL", "TK_NUM_EQUAL", "TK_DOT", "TK_NEG", "TK_BRK_OPEN", 
		"TK_BRK_CLOSE", "TK_GEQ", "TK_GE", "TK_LEQ", "TK_LE", "TK_PLUS", "TK_MINUS", 
		"TK_NUM", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Hello.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HelloParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Th_ruleContext extends ParserRuleContext {
		public Th_premiseContext th_premise() {
			return getRuleContext(Th_premiseContext.class,0);
		}
		public TerminalNode TK_IMP() { return getToken(HelloParser.TK_IMP, 0); }
		public Th_consequenceContext th_consequence() {
			return getRuleContext(Th_consequenceContext.class,0);
		}
		public TerminalNode TK_DOT() { return getToken(HelloParser.TK_DOT, 0); }
		public Th_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_th_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterTh_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitTh_rule(this);
		}
	}

	public final Th_ruleContext th_rule() throws RecognitionException {
		Th_ruleContext _localctx = new Th_ruleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_th_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			th_premise();
			setState(29);
			match(TK_IMP);
			setState(30);
			th_consequence();
			setState(31);
			match(TK_DOT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Th_premiseContext extends ParserRuleContext {
		public String f;
		public Th_formulaContext th_formula;
		public List<Th_formulaContext> th_formula() {
			return getRuleContexts(Th_formulaContext.class);
		}
		public Th_formulaContext th_formula(int i) {
			return getRuleContext(Th_formulaContext.class,i);
		}
		public List<TerminalNode> TK_AND() { return getTokens(HelloParser.TK_AND); }
		public TerminalNode TK_AND(int i) {
			return getToken(HelloParser.TK_AND, i);
		}
		public Th_premiseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_th_premise; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterTh_premise(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitTh_premise(this);
		}
	}

	public final Th_premiseContext th_premise() throws RecognitionException {
		Th_premiseContext _localctx = new Th_premiseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_th_premise);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			((Th_premiseContext)_localctx).th_formula = th_formula();
			((Th_premiseContext)_localctx).f =  ((Th_premiseContext)_localctx).th_formula.f;
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TK_AND) {
				{
				{
				setState(35);
				match(TK_AND);
				setState(36);
				((Th_premiseContext)_localctx).th_formula = th_formula();
				_localctx.f += ", " + ((Th_premiseContext)_localctx).th_formula.f;
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Th_consequenceContext extends ParserRuleContext {
		public String f;
		public Poss_formulaContext poss_formula;
		public Fluent_formulaContext fluent_formula;
		public Th_formulaContext th_formula;
		public Poss_formulaContext poss_formula() {
			return getRuleContext(Poss_formulaContext.class,0);
		}
		public Fluent_formulaContext fluent_formula() {
			return getRuleContext(Fluent_formulaContext.class,0);
		}
		public Th_formulaContext th_formula() {
			return getRuleContext(Th_formulaContext.class,0);
		}
		public Th_consequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_th_consequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterTh_consequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitTh_consequence(this);
		}
	}

	public final Th_consequenceContext th_consequence() throws RecognitionException {
		Th_consequenceContext _localctx = new Th_consequenceContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_th_consequence);
		try {
			setState(53);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				((Th_consequenceContext)_localctx).poss_formula = poss_formula();
				((Th_consequenceContext)_localctx).f =  ((Th_consequenceContext)_localctx).poss_formula.f;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				((Th_consequenceContext)_localctx).fluent_formula = fluent_formula();
				((Th_consequenceContext)_localctx).f =  ((Th_consequenceContext)_localctx).fluent_formula.f;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				((Th_consequenceContext)_localctx).th_formula = th_formula();
				((Th_consequenceContext)_localctx).f =  ((Th_consequenceContext)_localctx).th_formula.f;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Poss_formulaContext extends ParserRuleContext {
		public String f;
		public Token TK_POSS;
		public ArgsContext args;
		public TerminalNode TK_POSS() { return getToken(HelloParser.TK_POSS, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public Poss_formulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_poss_formula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterPoss_formula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitPoss_formula(this);
		}
	}

	public final Poss_formulaContext poss_formula() throws RecognitionException {
		Poss_formulaContext _localctx = new Poss_formulaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_poss_formula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			((Poss_formulaContext)_localctx).TK_POSS = match(TK_POSS);
			setState(56);
			match(TK_BRK_OPEN);
			setState(57);
			((Poss_formulaContext)_localctx).args = args();
			setState(58);
			match(TK_BRK_CLOSE);
			((Poss_formulaContext)_localctx).f =  (((Poss_formulaContext)_localctx).TK_POSS!=null?((Poss_formulaContext)_localctx).TK_POSS.getText():null) + "(" + ((Poss_formulaContext)_localctx).args.s + ")";
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Fluent_formulaContext extends ParserRuleContext {
		public String f;
		public Token TK_ID;
		public ArgsContext args;
		public Do_formulaContext do_formula;
		public TerminalNode TK_ID() { return getToken(HelloParser.TK_ID, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public Do_formulaContext do_formula() {
			return getRuleContext(Do_formulaContext.class,0);
		}
		public Fluent_formulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fluent_formula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterFluent_formula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitFluent_formula(this);
		}
	}

	public final Fluent_formulaContext fluent_formula() throws RecognitionException {
		Fluent_formulaContext _localctx = new Fluent_formulaContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fluent_formula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			((Fluent_formulaContext)_localctx).TK_ID = match(TK_ID);
			setState(62);
			match(TK_BRK_OPEN);
			setState(63);
			((Fluent_formulaContext)_localctx).args = args();
			setState(64);
			match(TK_SEP);
			setState(65);
			((Fluent_formulaContext)_localctx).do_formula = do_formula();
			setState(66);
			match(TK_BRK_CLOSE);

				((Fluent_formulaContext)_localctx).f =  (((Fluent_formulaContext)_localctx).TK_ID!=null?((Fluent_formulaContext)_localctx).TK_ID.getText():null) + "(" + ((Fluent_formulaContext)_localctx).args.s + "," + ((Fluent_formulaContext)_localctx).do_formula.f + ")";

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Do_formulaContext extends ParserRuleContext {
		public String f;
		public Token TK_DO;
		public Token TK_VAR;
		public TerminalNode TK_DO() { return getToken(HelloParser.TK_DO, 0); }
		public List<TerminalNode> TK_VAR() { return getTokens(HelloParser.TK_VAR); }
		public TerminalNode TK_VAR(int i) {
			return getToken(HelloParser.TK_VAR, i);
		}
		public Do_formulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_do_formula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterDo_formula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitDo_formula(this);
		}
	}

	public final Do_formulaContext do_formula() throws RecognitionException {
		Do_formulaContext _localctx = new Do_formulaContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_do_formula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			((Do_formulaContext)_localctx).TK_DO = match(TK_DO);
			((Do_formulaContext)_localctx).f =  (((Do_formulaContext)_localctx).TK_DO!=null?((Do_formulaContext)_localctx).TK_DO.getText():null) + "(";
			setState(71);
			match(TK_BRK_OPEN);
			setState(72);
			((Do_formulaContext)_localctx).TK_VAR = match(TK_VAR);
			_localctx.f += (((Do_formulaContext)_localctx).TK_VAR!=null?((Do_formulaContext)_localctx).TK_VAR.getText():null) + ",";
			setState(74);
			match(TK_SEP);
			setState(75);
			((Do_formulaContext)_localctx).TK_VAR = match(TK_VAR);
			_localctx.f += (((Do_formulaContext)_localctx).TK_VAR!=null?((Do_formulaContext)_localctx).TK_VAR.getText():null) + ")";
			setState(77);
			match(TK_BRK_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Id_formulaContext extends ParserRuleContext {
		public String id;
		public Token TK_VAR;
		public ArgContext arg;
		public Th_formulaContext th_formula;
		public TerminalNode TK_VAR() { return getToken(HelloParser.TK_VAR, 0); }
		public TerminalNode TK_EQUAL() { return getToken(HelloParser.TK_EQUAL, 0); }
		public ArgContext arg() {
			return getRuleContext(ArgContext.class,0);
		}
		public Th_formulaContext th_formula() {
			return getRuleContext(Th_formulaContext.class,0);
		}
		public Id_formulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_formula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterId_formula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitId_formula(this);
		}
	}

	public final Id_formulaContext id_formula() throws RecognitionException {
		Id_formulaContext _localctx = new Id_formulaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_id_formula);
		try {
			setState(89);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				((Id_formulaContext)_localctx).TK_VAR = match(TK_VAR);
				setState(80);
				match(TK_EQUAL);
				setState(81);
				((Id_formulaContext)_localctx).arg = arg();
				 ((Id_formulaContext)_localctx).id =  (((Id_formulaContext)_localctx).TK_VAR!=null?((Id_formulaContext)_localctx).TK_VAR.getText():null) + "=" + ((Id_formulaContext)_localctx).arg.s; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				((Id_formulaContext)_localctx).TK_VAR = match(TK_VAR);
				setState(85);
				match(TK_EQUAL);
				setState(86);
				((Id_formulaContext)_localctx).th_formula = th_formula();
				 ((Id_formulaContext)_localctx).id =  (((Id_formulaContext)_localctx).TK_VAR!=null?((Id_formulaContext)_localctx).TK_VAR.getText():null) + "=" + ((Id_formulaContext)_localctx).th_formula.f; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Neg_formulaContext extends ParserRuleContext {
		public String f;
		public Th_formulaContext th_formula;
		public Comp_formulaContext comp_formula;
		public TerminalNode TK_NEG() { return getToken(HelloParser.TK_NEG, 0); }
		public Th_formulaContext th_formula() {
			return getRuleContext(Th_formulaContext.class,0);
		}
		public TerminalNode TK_BRK_OPEN() { return getToken(HelloParser.TK_BRK_OPEN, 0); }
		public Comp_formulaContext comp_formula() {
			return getRuleContext(Comp_formulaContext.class,0);
		}
		public TerminalNode TK_BRK_CLOSE() { return getToken(HelloParser.TK_BRK_CLOSE, 0); }
		public Neg_formulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_neg_formula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterNeg_formula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitNeg_formula(this);
		}
	}

	public final Neg_formulaContext neg_formula() throws RecognitionException {
		Neg_formulaContext _localctx = new Neg_formulaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_neg_formula);
		try {
			setState(101);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				match(TK_NEG);
				setState(92);
				((Neg_formulaContext)_localctx).th_formula = th_formula();
				((Neg_formulaContext)_localctx).f =  "\\+" + ((Neg_formulaContext)_localctx).th_formula.f; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				match(TK_NEG);
				setState(96);
				match(TK_BRK_OPEN);
				setState(97);
				((Neg_formulaContext)_localctx).comp_formula = comp_formula();
				setState(98);
				match(TK_BRK_CLOSE);
				((Neg_formulaContext)_localctx).f =  "\\+(" + ((Neg_formulaContext)_localctx).comp_formula.f + ")"; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Comp_formulaContext extends ParserRuleContext {
		public String f;
		public Token TK_VAR;
		public ExprContext expr;
		public TerminalNode TK_VAR() { return getToken(HelloParser.TK_VAR, 0); }
		public TerminalNode TK_GEQ() { return getToken(HelloParser.TK_GEQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode TK_GE() { return getToken(HelloParser.TK_GE, 0); }
		public TerminalNode TK_LEQ() { return getToken(HelloParser.TK_LEQ, 0); }
		public TerminalNode TK_LE() { return getToken(HelloParser.TK_LE, 0); }
		public TerminalNode TK_NUM_EQUAL() { return getToken(HelloParser.TK_NUM_EQUAL, 0); }
		public Comp_formulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_formula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterComp_formula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitComp_formula(this);
		}
	}

	public final Comp_formulaContext comp_formula() throws RecognitionException {
		Comp_formulaContext _localctx = new Comp_formulaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_comp_formula);
		try {
			setState(128);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				((Comp_formulaContext)_localctx).TK_VAR = match(TK_VAR);
				setState(104);
				match(TK_GEQ);
				setState(105);
				((Comp_formulaContext)_localctx).expr = expr();
				((Comp_formulaContext)_localctx).f =  (((Comp_formulaContext)_localctx).TK_VAR!=null?((Comp_formulaContext)_localctx).TK_VAR.getText():null) + ">=" + ((Comp_formulaContext)_localctx).expr.e; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				((Comp_formulaContext)_localctx).TK_VAR = match(TK_VAR);
				setState(109);
				match(TK_GE);
				setState(110);
				((Comp_formulaContext)_localctx).expr = expr();
				((Comp_formulaContext)_localctx).f =  (((Comp_formulaContext)_localctx).TK_VAR!=null?((Comp_formulaContext)_localctx).TK_VAR.getText():null) + ">" + ((Comp_formulaContext)_localctx).expr.e; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				((Comp_formulaContext)_localctx).TK_VAR = match(TK_VAR);
				setState(114);
				match(TK_LEQ);
				setState(115);
				((Comp_formulaContext)_localctx).expr = expr();
				((Comp_formulaContext)_localctx).f =  (((Comp_formulaContext)_localctx).TK_VAR!=null?((Comp_formulaContext)_localctx).TK_VAR.getText():null) + "=<" + ((Comp_formulaContext)_localctx).expr.e; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(118);
				((Comp_formulaContext)_localctx).TK_VAR = match(TK_VAR);
				setState(119);
				match(TK_LE);
				setState(120);
				((Comp_formulaContext)_localctx).expr = expr();
				((Comp_formulaContext)_localctx).f =  (((Comp_formulaContext)_localctx).TK_VAR!=null?((Comp_formulaContext)_localctx).TK_VAR.getText():null) + "<" + ((Comp_formulaContext)_localctx).expr.e; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(123);
				((Comp_formulaContext)_localctx).TK_VAR = match(TK_VAR);
				setState(124);
				match(TK_NUM_EQUAL);
				setState(125);
				((Comp_formulaContext)_localctx).expr = expr();
				((Comp_formulaContext)_localctx).f =  (((Comp_formulaContext)_localctx).TK_VAR!=null?((Comp_formulaContext)_localctx).TK_VAR.getText():null) + " is " + ((Comp_formulaContext)_localctx).expr.e; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public String e;
		public OpContext op;
		public List<OpContext> op() {
			return getRuleContexts(OpContext.class);
		}
		public OpContext op(int i) {
			return getRuleContext(OpContext.class,i);
		}
		public TerminalNode TK_PLUS() { return getToken(HelloParser.TK_PLUS, 0); }
		public TerminalNode TK_MINUS() { return getToken(HelloParser.TK_MINUS, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expr);
		try {
			setState(145);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				((ExprContext)_localctx).op = op();
				((ExprContext)_localctx).e =  ((ExprContext)_localctx).op.o;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				((ExprContext)_localctx).op = op();
				((ExprContext)_localctx).e =  ((ExprContext)_localctx).op.o;
				setState(135);
				match(TK_PLUS);
				setState(136);
				((ExprContext)_localctx).op = op();
				_localctx.e += "+" + ((ExprContext)_localctx).op.o;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(139);
				((ExprContext)_localctx).op = op();
				((ExprContext)_localctx).e =  ((ExprContext)_localctx).op.o;
				setState(141);
				match(TK_MINUS);
				setState(142);
				((ExprContext)_localctx).op = op();
				_localctx.e += "-" + ((ExprContext)_localctx).op.o;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpContext extends ParserRuleContext {
		public String o;
		public Token TK_VAR;
		public Token TK_NUM;
		public TerminalNode TK_VAR() { return getToken(HelloParser.TK_VAR, 0); }
		public TerminalNode TK_NUM() { return getToken(HelloParser.TK_NUM, 0); }
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitOp(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_op);
		try {
			setState(151);
			switch (_input.LA(1)) {
			case TK_VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				((OpContext)_localctx).TK_VAR = match(TK_VAR);
				((OpContext)_localctx).o =  (((OpContext)_localctx).TK_VAR!=null?((OpContext)_localctx).TK_VAR.getText():null);
				}
				break;
			case TK_NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				((OpContext)_localctx).TK_NUM = match(TK_NUM);
				((OpContext)_localctx).o =  (((OpContext)_localctx).TK_NUM!=null?((OpContext)_localctx).TK_NUM.getText():null);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Th_formulaContext extends ParserRuleContext {
		public String f;
		public Token TK_ID;
		public ArgsContext args;
		public Id_formulaContext id_formula;
		public Comp_formulaContext comp_formula;
		public Neg_formulaContext neg_formula;
		public TerminalNode TK_ID() { return getToken(HelloParser.TK_ID, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public Id_formulaContext id_formula() {
			return getRuleContext(Id_formulaContext.class,0);
		}
		public Comp_formulaContext comp_formula() {
			return getRuleContext(Comp_formulaContext.class,0);
		}
		public Neg_formulaContext neg_formula() {
			return getRuleContext(Neg_formulaContext.class,0);
		}
		public Th_formulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_th_formula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterTh_formula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitTh_formula(this);
		}
	}

	public final Th_formulaContext th_formula() throws RecognitionException {
		Th_formulaContext _localctx = new Th_formulaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_th_formula);
		try {
			setState(168);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				((Th_formulaContext)_localctx).TK_ID = match(TK_ID);
				setState(154);
				match(TK_BRK_OPEN);
				setState(155);
				((Th_formulaContext)_localctx).args = args();
				setState(156);
				match(TK_BRK_CLOSE);
				((Th_formulaContext)_localctx).f =  (((Th_formulaContext)_localctx).TK_ID!=null?((Th_formulaContext)_localctx).TK_ID.getText():null) + "(" + ((Th_formulaContext)_localctx).args.s + ")";
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				((Th_formulaContext)_localctx).id_formula = id_formula();
				((Th_formulaContext)_localctx).f =  ((Th_formulaContext)_localctx).id_formula.id;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(162);
				((Th_formulaContext)_localctx).comp_formula = comp_formula();
				((Th_formulaContext)_localctx).f =  ((Th_formulaContext)_localctx).comp_formula.f;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(165);
				((Th_formulaContext)_localctx).neg_formula = neg_formula();
				((Th_formulaContext)_localctx).f =  ((Th_formulaContext)_localctx).neg_formula.f;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public String s;
		public ArgContext arg;
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public List<TerminalNode> TK_SEP() { return getTokens(HelloParser.TK_SEP); }
		public TerminalNode TK_SEP(int i) {
			return getToken(HelloParser.TK_SEP, i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_args);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			((ArgsContext)_localctx).arg = arg();
			((ArgsContext)_localctx).s =  ((ArgsContext)_localctx).arg.s;
			setState(178);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(172);
					match(TK_SEP);
					setState(173);
					((ArgsContext)_localctx).arg = arg();
					_localctx.s += ","; _localctx.s += ((ArgsContext)_localctx).arg.s;
					}
					} 
				}
				setState(180);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgContext extends ParserRuleContext {
		public String s;
		public Token TK_ID;
		public ArgsContext args;
		public Token TK_VAR;
		public TerminalNode TK_ID() { return getToken(HelloParser.TK_ID, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode TK_VAR() { return getToken(HelloParser.TK_VAR, 0); }
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitArg(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_arg);
		try {
			setState(191);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				((ArgContext)_localctx).TK_ID = match(TK_ID);
				((ArgContext)_localctx).s =  (((ArgContext)_localctx).TK_ID!=null?((ArgContext)_localctx).TK_ID.getText():null);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				((ArgContext)_localctx).TK_ID = match(TK_ID);
				setState(184);
				match(TK_BRK_OPEN);
				setState(185);
				((ArgContext)_localctx).args = args();
				setState(186);
				match(TK_BRK_CLOSE);
				((ArgContext)_localctx).s =  (((ArgContext)_localctx).TK_ID!=null?((ArgContext)_localctx).TK_ID.getText():null) + "(" + ((ArgContext)_localctx).args.s + ")";
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(189);
				((ArgContext)_localctx).TK_VAR = match(TK_VAR);
				((ArgContext)_localctx).s =  (((ArgContext)_localctx).TK_VAR!=null?((ArgContext)_localctx).TK_VAR.getText():null);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\30\u00c4\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\7\3*\n\3\f\3\16\3-\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\5\48\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\b\\\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\th\n"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0083\n\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0094\n\13\3\f"+
		"\3\f\3\f\3\f\5\f\u009a\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\5\r\u00ab\n\r\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00b3"+
		"\n\16\f\16\16\16\u00b6\13\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\5\17\u00c2\n\17\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\2\2\u00c7\2\36\3\2\2\2\4#\3\2\2\2\6\67\3\2\2\2\b9\3\2\2\2\n?\3\2\2"+
		"\2\fG\3\2\2\2\16[\3\2\2\2\20g\3\2\2\2\22\u0082\3\2\2\2\24\u0093\3\2\2"+
		"\2\26\u0099\3\2\2\2\30\u00aa\3\2\2\2\32\u00ac\3\2\2\2\34\u00c1\3\2\2\2"+
		"\36\37\5\4\3\2\37 \7\t\2\2 !\5\6\4\2!\"\7\r\2\2\"\3\3\2\2\2#$\5\30\r\2"+
		"$+\b\3\1\2%&\7\3\2\2&\'\5\30\r\2\'(\b\3\1\2(*\3\2\2\2)%\3\2\2\2*-\3\2"+
		"\2\2+)\3\2\2\2+,\3\2\2\2,\5\3\2\2\2-+\3\2\2\2./\5\b\5\2/\60\b\4\1\2\60"+
		"8\3\2\2\2\61\62\5\n\6\2\62\63\b\4\1\2\638\3\2\2\2\64\65\5\30\r\2\65\66"+
		"\b\4\1\2\668\3\2\2\2\67.\3\2\2\2\67\61\3\2\2\2\67\64\3\2\2\28\7\3\2\2"+
		"\29:\7\5\2\2:;\7\17\2\2;<\5\32\16\2<=\7\20\2\2=>\b\5\1\2>\t\3\2\2\2?@"+
		"\7\7\2\2@A\7\17\2\2AB\5\32\16\2BC\7\n\2\2CD\5\f\7\2DE\7\20\2\2EF\b\6\1"+
		"\2F\13\3\2\2\2GH\7\6\2\2HI\b\7\1\2IJ\7\17\2\2JK\7\b\2\2KL\b\7\1\2LM\7"+
		"\n\2\2MN\7\b\2\2NO\b\7\1\2OP\7\20\2\2P\r\3\2\2\2QR\7\b\2\2RS\7\13\2\2"+
		"ST\5\34\17\2TU\b\b\1\2U\\\3\2\2\2VW\7\b\2\2WX\7\13\2\2XY\5\30\r\2YZ\b"+
		"\b\1\2Z\\\3\2\2\2[Q\3\2\2\2[V\3\2\2\2\\\17\3\2\2\2]^\7\16\2\2^_\5\30\r"+
		"\2_`\b\t\1\2`h\3\2\2\2ab\7\16\2\2bc\7\17\2\2cd\5\22\n\2de\7\20\2\2ef\b"+
		"\t\1\2fh\3\2\2\2g]\3\2\2\2ga\3\2\2\2h\21\3\2\2\2ij\7\b\2\2jk\7\21\2\2"+
		"kl\5\24\13\2lm\b\n\1\2m\u0083\3\2\2\2no\7\b\2\2op\7\22\2\2pq\5\24\13\2"+
		"qr\b\n\1\2r\u0083\3\2\2\2st\7\b\2\2tu\7\23\2\2uv\5\24\13\2vw\b\n\1\2w"+
		"\u0083\3\2\2\2xy\7\b\2\2yz\7\24\2\2z{\5\24\13\2{|\b\n\1\2|\u0083\3\2\2"+
		"\2}~\7\b\2\2~\177\7\f\2\2\177\u0080\5\24\13\2\u0080\u0081\b\n\1\2\u0081"+
		"\u0083\3\2\2\2\u0082i\3\2\2\2\u0082n\3\2\2\2\u0082s\3\2\2\2\u0082x\3\2"+
		"\2\2\u0082}\3\2\2\2\u0083\23\3\2\2\2\u0084\u0085\5\26\f\2\u0085\u0086"+
		"\b\13\1\2\u0086\u0094\3\2\2\2\u0087\u0088\5\26\f\2\u0088\u0089\b\13\1"+
		"\2\u0089\u008a\7\25\2\2\u008a\u008b\5\26\f\2\u008b\u008c\b\13\1\2\u008c"+
		"\u0094\3\2\2\2\u008d\u008e\5\26\f\2\u008e\u008f\b\13\1\2\u008f\u0090\7"+
		"\26\2\2\u0090\u0091\5\26\f\2\u0091\u0092\b\13\1\2\u0092\u0094\3\2\2\2"+
		"\u0093\u0084\3\2\2\2\u0093\u0087\3\2\2\2\u0093\u008d\3\2\2\2\u0094\25"+
		"\3\2\2\2\u0095\u0096\7\b\2\2\u0096\u009a\b\f\1\2\u0097\u0098\7\27\2\2"+
		"\u0098\u009a\b\f\1\2\u0099\u0095\3\2\2\2\u0099\u0097\3\2\2\2\u009a\27"+
		"\3\2\2\2\u009b\u009c\7\7\2\2\u009c\u009d\7\17\2\2\u009d\u009e\5\32\16"+
		"\2\u009e\u009f\7\20\2\2\u009f\u00a0\b\r\1\2\u00a0\u00ab\3\2\2\2\u00a1"+
		"\u00a2\5\16\b\2\u00a2\u00a3\b\r\1\2\u00a3\u00ab\3\2\2\2\u00a4\u00a5\5"+
		"\22\n\2\u00a5\u00a6\b\r\1\2\u00a6\u00ab\3\2\2\2\u00a7\u00a8\5\20\t\2\u00a8"+
		"\u00a9\b\r\1\2\u00a9\u00ab\3\2\2\2\u00aa\u009b\3\2\2\2\u00aa\u00a1\3\2"+
		"\2\2\u00aa\u00a4\3\2\2\2\u00aa\u00a7\3\2\2\2\u00ab\31\3\2\2\2\u00ac\u00ad"+
		"\5\34\17\2\u00ad\u00b4\b\16\1\2\u00ae\u00af\7\n\2\2\u00af\u00b0\5\34\17"+
		"\2\u00b0\u00b1\b\16\1\2\u00b1\u00b3\3\2\2\2\u00b2\u00ae\3\2\2\2\u00b3"+
		"\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\33\3\2\2"+
		"\2\u00b6\u00b4\3\2\2\2\u00b7\u00b8\7\7\2\2\u00b8\u00c2\b\17\1\2\u00b9"+
		"\u00ba\7\7\2\2\u00ba\u00bb\7\17\2\2\u00bb\u00bc\5\32\16\2\u00bc\u00bd"+
		"\7\20\2\2\u00bd\u00be\b\17\1\2\u00be\u00c2\3\2\2\2\u00bf\u00c0\7\b\2\2"+
		"\u00c0\u00c2\b\17\1\2\u00c1\u00b7\3\2\2\2\u00c1\u00b9\3\2\2\2\u00c1\u00bf"+
		"\3\2\2\2\u00c2\35\3\2\2\2\f+\67[g\u0082\u0093\u0099\u00aa\u00b4\u00c1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}