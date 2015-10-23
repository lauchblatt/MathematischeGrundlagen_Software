// Generated from Hello.g4 by ANTLR 4.5.1

package parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HelloLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, TK_AND=3, TK_POSS=4, TK_DO=5, TK_ID=6, TK_VAR=7, TK_IMP=8, 
		TK_SEP=9, TK_EQUAL=10, TK_DOT=11, WS=12;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "TK_AND", "TK_POSS", "TK_DO", "TK_ID", "TK_VAR", "TK_IMP", 
		"TK_SEP", "TK_EQUAL", "TK_DOT", "WS"
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


	public HelloLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Hello.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\16J\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\5\4$\n\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\7\6\7/\n\7\r\7\16\7\60\3\b\6\b\64\n\b\r\b\16"+
		"\b\65\3\b\5\b9\n\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\6\rE\n\r"+
		"\r\r\16\rF\3\r\3\r\2\2\16\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\3\2\5\3\2c|\3\2C\\\5\2\13\f\17\17\"\"N\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3"+
		"\2\2\2\5\35\3\2\2\2\7#\3\2\2\2\t%\3\2\2\2\13*\3\2\2\2\r.\3\2\2\2\178\3"+
		"\2\2\2\21:\3\2\2\2\23=\3\2\2\2\25?\3\2\2\2\27A\3\2\2\2\31D\3\2\2\2\33"+
		"\34\7*\2\2\34\4\3\2\2\2\35\36\7+\2\2\36\6\3\2\2\2\37$\7(\2\2 !\7C\2\2"+
		"!\"\7P\2\2\"$\7F\2\2#\37\3\2\2\2# \3\2\2\2$\b\3\2\2\2%&\7r\2\2&\'\7q\2"+
		"\2\'(\7u\2\2()\7u\2\2)\n\3\2\2\2*+\7f\2\2+,\7q\2\2,\f\3\2\2\2-/\t\2\2"+
		"\2.-\3\2\2\2/\60\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\16\3\2\2\2\62\64"+
		"\t\3\2\2\63\62\3\2\2\2\64\65\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\669\3"+
		"\2\2\2\679\7a\2\28\63\3\2\2\28\67\3\2\2\29\20\3\2\2\2:;\7/\2\2;<\7@\2"+
		"\2<\22\3\2\2\2=>\7.\2\2>\24\3\2\2\2?@\7?\2\2@\26\3\2\2\2AB\7\60\2\2B\30"+
		"\3\2\2\2CE\t\4\2\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2GH\3\2\2\2H"+
		"I\b\r\2\2I\32\3\2\2\2\b\2#\60\658F\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}