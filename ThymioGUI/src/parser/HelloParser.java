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
		T__0=1, T__1=2, TK_AND=3, TK_POSS=4, TK_DO=5, TK_ID=6, TK_VAR=7, TK_IMP=8, 
		TK_SEP=9, TK_EQUAL=10, TK_DOT=11, WS=12;
	public static final int
		RULE_th_rule = 0, RULE_th_premise = 1, RULE_th_consequence = 2, RULE_poss_formula = 3, 
		RULE_fluent_formula = 4, RULE_do_formula = 5, RULE_id_formula = 6, RULE_th_formula = 7, 
		RULE_args = 8, RULE_arg = 9;
	public static final String[] ruleNames = {
		"th_rule", "th_premise", "th_consequence", "poss_formula", "fluent_formula", 
		"do_formula", "id_formula", "th_formula", "args", "arg"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", null, "'poss'", "'do'", null, null, "'->'", "','", 
		"'='", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "TK_AND", "TK_POSS", "TK_DO", "TK_ID", "TK_VAR", "TK_IMP", 
		"TK_SEP", "TK_EQUAL", "TK_DOT", "WS"
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
			setState(20);
			th_premise();
			setState(21);
			match(TK_IMP);
			setState(22);
			th_consequence();
			setState(23);
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
			setState(25);
			((Th_premiseContext)_localctx).th_formula = th_formula();
			((Th_premiseContext)_localctx).f =  ((Th_premiseContext)_localctx).th_formula.f;
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TK_AND) {
				{
				{
				setState(27);
				match(TK_AND);
				setState(28);
				((Th_premiseContext)_localctx).th_formula = th_formula();
				_localctx.f += ", " + ((Th_premiseContext)_localctx).th_formula.f;
				}
				}
				setState(35);
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
		public Poss_formulaContext poss_formula() {
			return getRuleContext(Poss_formulaContext.class,0);
		}
		public Fluent_formulaContext fluent_formula() {
			return getRuleContext(Fluent_formulaContext.class,0);
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
			setState(42);
			switch (_input.LA(1)) {
			case TK_POSS:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				((Th_consequenceContext)_localctx).poss_formula = poss_formula();
				((Th_consequenceContext)_localctx).f =  ((Th_consequenceContext)_localctx).poss_formula.f;
				}
				break;
			case TK_ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				((Th_consequenceContext)_localctx).fluent_formula = fluent_formula();
				((Th_consequenceContext)_localctx).f =  ((Th_consequenceContext)_localctx).fluent_formula.f;
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
			setState(44);
			((Poss_formulaContext)_localctx).TK_POSS = match(TK_POSS);
			setState(45);
			match(T__0);
			setState(46);
			((Poss_formulaContext)_localctx).args = args();
			setState(47);
			match(T__1);
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
			setState(50);
			((Fluent_formulaContext)_localctx).TK_ID = match(TK_ID);
			setState(51);
			match(T__0);
			setState(52);
			((Fluent_formulaContext)_localctx).args = args();
			setState(53);
			match(TK_SEP);
			setState(54);
			((Fluent_formulaContext)_localctx).do_formula = do_formula();
			setState(55);
			match(T__1);

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
			setState(58);
			((Do_formulaContext)_localctx).TK_DO = match(TK_DO);
			((Do_formulaContext)_localctx).f =  (((Do_formulaContext)_localctx).TK_DO!=null?((Do_formulaContext)_localctx).TK_DO.getText():null) + "(";
			setState(60);
			match(T__0);
			setState(61);
			((Do_formulaContext)_localctx).TK_VAR = match(TK_VAR);
			_localctx.f += (((Do_formulaContext)_localctx).TK_VAR!=null?((Do_formulaContext)_localctx).TK_VAR.getText():null) + ",";
			setState(63);
			match(TK_SEP);
			setState(64);
			((Do_formulaContext)_localctx).TK_VAR = match(TK_VAR);
			_localctx.f += (((Do_formulaContext)_localctx).TK_VAR!=null?((Do_formulaContext)_localctx).TK_VAR.getText():null) + ")";
			setState(66);
			match(T__1);
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
		public Th_formulaContext f;
		public Th_formulaContext th_formula;
		public TerminalNode TK_VAR() { return getToken(HelloParser.TK_VAR, 0); }
		public TerminalNode TK_EQUAL() { return getToken(HelloParser.TK_EQUAL, 0); }
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
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			((Id_formulaContext)_localctx).TK_VAR = match(TK_VAR);
			setState(69);
			match(TK_EQUAL);
			setState(70);
			((Id_formulaContext)_localctx).f = ((Id_formulaContext)_localctx).th_formula = th_formula();

				((Id_formulaContext)_localctx).id =  (((Id_formulaContext)_localctx).TK_VAR!=null?((Id_formulaContext)_localctx).TK_VAR.getText():null) + "=" + ((Id_formulaContext)_localctx).th_formula.f;

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
		public TerminalNode TK_ID() { return getToken(HelloParser.TK_ID, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public Id_formulaContext id_formula() {
			return getRuleContext(Id_formulaContext.class,0);
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
		enterRule(_localctx, 14, RULE_th_formula);
		try {
			setState(82);
			switch (_input.LA(1)) {
			case TK_ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				((Th_formulaContext)_localctx).TK_ID = match(TK_ID);
				setState(74);
				match(T__0);
				setState(75);
				((Th_formulaContext)_localctx).args = args();
				setState(76);
				match(T__1);
				((Th_formulaContext)_localctx).f =  (((Th_formulaContext)_localctx).TK_ID!=null?((Th_formulaContext)_localctx).TK_ID.getText():null) + "(" + ((Th_formulaContext)_localctx).args.s + ")";
				}
				break;
			case TK_VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				((Th_formulaContext)_localctx).id_formula = id_formula();
				((Th_formulaContext)_localctx).f =  ((Th_formulaContext)_localctx).id_formula.id;
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
		enterRule(_localctx, 16, RULE_args);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			((ArgsContext)_localctx).arg = arg();
			((ArgsContext)_localctx).s =  ((ArgsContext)_localctx).arg.s;
			setState(92);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(86);
					match(TK_SEP);
					setState(87);
					((ArgsContext)_localctx).arg = arg();
					_localctx.s += ","; _localctx.s += ((ArgsContext)_localctx).arg.s;
					}
					} 
				}
				setState(94);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
		public Token TK_VAR;
		public TerminalNode TK_ID() { return getToken(HelloParser.TK_ID, 0); }
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
		enterRule(_localctx, 18, RULE_arg);
		try {
			setState(99);
			switch (_input.LA(1)) {
			case TK_ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				((ArgContext)_localctx).TK_ID = match(TK_ID);
				((ArgContext)_localctx).s =  (((ArgContext)_localctx).TK_ID!=null?((ArgContext)_localctx).TK_ID.getText():null);
				}
				break;
			case TK_VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				((ArgContext)_localctx).TK_VAR = match(TK_VAR);
				((ArgContext)_localctx).s =  (((ArgContext)_localctx).TK_VAR!=null?((ArgContext)_localctx).TK_VAR.getText():null);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\16h\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3\"\n\3\f\3\16\3%\13\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\5\4-\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tU\n\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\7\n]\n\n\f\n\16\n`\13\n\3\13\3\13\3\13\3\13\5\13f\n\13\3\13\2"+
		"\2\f\2\4\6\b\n\f\16\20\22\24\2\2b\2\26\3\2\2\2\4\33\3\2\2\2\6,\3\2\2\2"+
		"\b.\3\2\2\2\n\64\3\2\2\2\f<\3\2\2\2\16F\3\2\2\2\20T\3\2\2\2\22V\3\2\2"+
		"\2\24e\3\2\2\2\26\27\5\4\3\2\27\30\7\n\2\2\30\31\5\6\4\2\31\32\7\r\2\2"+
		"\32\3\3\2\2\2\33\34\5\20\t\2\34#\b\3\1\2\35\36\7\5\2\2\36\37\5\20\t\2"+
		"\37 \b\3\1\2 \"\3\2\2\2!\35\3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\5"+
		"\3\2\2\2%#\3\2\2\2&\'\5\b\5\2\'(\b\4\1\2(-\3\2\2\2)*\5\n\6\2*+\b\4\1\2"+
		"+-\3\2\2\2,&\3\2\2\2,)\3\2\2\2-\7\3\2\2\2./\7\6\2\2/\60\7\3\2\2\60\61"+
		"\5\22\n\2\61\62\7\4\2\2\62\63\b\5\1\2\63\t\3\2\2\2\64\65\7\b\2\2\65\66"+
		"\7\3\2\2\66\67\5\22\n\2\678\7\13\2\289\5\f\7\29:\7\4\2\2:;\b\6\1\2;\13"+
		"\3\2\2\2<=\7\7\2\2=>\b\7\1\2>?\7\3\2\2?@\7\t\2\2@A\b\7\1\2AB\7\13\2\2"+
		"BC\7\t\2\2CD\b\7\1\2DE\7\4\2\2E\r\3\2\2\2FG\7\t\2\2GH\7\f\2\2HI\5\20\t"+
		"\2IJ\b\b\1\2J\17\3\2\2\2KL\7\b\2\2LM\7\3\2\2MN\5\22\n\2NO\7\4\2\2OP\b"+
		"\t\1\2PU\3\2\2\2QR\5\16\b\2RS\b\t\1\2SU\3\2\2\2TK\3\2\2\2TQ\3\2\2\2U\21"+
		"\3\2\2\2VW\5\24\13\2W^\b\n\1\2XY\7\13\2\2YZ\5\24\13\2Z[\b\n\1\2[]\3\2"+
		"\2\2\\X\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\23\3\2\2\2`^\3\2\2\2a"+
		"b\7\b\2\2bf\b\13\1\2cd\7\t\2\2df\b\13\1\2ea\3\2\2\2ec\3\2\2\2f\25\3\2"+
		"\2\2\7#,T^e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}