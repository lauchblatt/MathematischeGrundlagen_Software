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
		TK_AND=1, TK_OR=2, TK_POSS=3, TK_DO=4, TK_ID=5, TK_VAR=6, TK_IMP=7, TK_SEP=8, 
		TK_EQUAL=9, TK_NUM_EQUAL=10, TK_DOT=11, TK_NEG=12, TK_BRK_OPEN=13, TK_BRK_CLOSE=14, 
		TK_GEQ=15, TK_GE=16, TK_LEQ=17, TK_LE=18, TK_PLUS=19, TK_MINUS=20, TK_NUM=21, 
		WS=22;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"TK_AND", "TK_OR", "TK_POSS", "TK_DO", "TK_ID", "TK_VAR", "TK_IMP", "TK_SEP", 
		"TK_EQUAL", "TK_NUM_EQUAL", "TK_DOT", "TK_NEG", "TK_BRK_OPEN", "TK_BRK_CLOSE", 
		"TK_GEQ", "TK_GE", "TK_LEQ", "TK_LE", "TK_PLUS", "TK_MINUS", "TK_NUM", 
		"WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\30\u0083\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3"+
		"\2\5\2\64\n\2\3\3\3\3\3\3\5\39\n\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6"+
		"\3\6\7\6E\n\6\f\6\16\6H\13\6\3\7\3\7\7\7L\n\7\f\7\16\7O\13\7\3\7\5\7R"+
		"\n\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\5\rd\n\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\6\26y\n\26\r\26\16\26z\3\27\6\27~"+
		"\n\27\r\27\16\27\177\3\27\3\27\2\2\30\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"\3\2\b\3\2c|\4\2\62;c|\3\2C\\\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\""+
		"\u008a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3"+
		"\63\3\2\2\2\58\3\2\2\2\7:\3\2\2\2\t?\3\2\2\2\13B\3\2\2\2\rQ\3\2\2\2\17"+
		"S\3\2\2\2\21V\3\2\2\2\23X\3\2\2\2\25Z\3\2\2\2\27]\3\2\2\2\31c\3\2\2\2"+
		"\33e\3\2\2\2\35g\3\2\2\2\37i\3\2\2\2!l\3\2\2\2#n\3\2\2\2%q\3\2\2\2\'s"+
		"\3\2\2\2)u\3\2\2\2+x\3\2\2\2-}\3\2\2\2/\64\7(\2\2\60\61\7C\2\2\61\62\7"+
		"P\2\2\62\64\7F\2\2\63/\3\2\2\2\63\60\3\2\2\2\64\4\3\2\2\2\659\7~\2\2\66"+
		"\67\7Q\2\2\679\7T\2\28\65\3\2\2\28\66\3\2\2\29\6\3\2\2\2:;\7r\2\2;<\7"+
		"q\2\2<=\7u\2\2=>\7u\2\2>\b\3\2\2\2?@\7f\2\2@A\7q\2\2A\n\3\2\2\2BF\t\2"+
		"\2\2CE\t\3\2\2DC\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\f\3\2\2\2HF\3"+
		"\2\2\2IM\t\4\2\2JL\t\5\2\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NR\3"+
		"\2\2\2OM\3\2\2\2PR\7a\2\2QI\3\2\2\2QP\3\2\2\2R\16\3\2\2\2ST\7/\2\2TU\7"+
		"@\2\2U\20\3\2\2\2VW\7.\2\2W\22\3\2\2\2XY\7?\2\2Y\24\3\2\2\2Z[\7?\2\2["+
		"\\\7?\2\2\\\26\3\2\2\2]^\7\60\2\2^\30\3\2\2\2_d\7#\2\2`a\7P\2\2ab\7Q\2"+
		"\2bd\7V\2\2c_\3\2\2\2c`\3\2\2\2d\32\3\2\2\2ef\7*\2\2f\34\3\2\2\2gh\7+"+
		"\2\2h\36\3\2\2\2ij\7@\2\2jk\7?\2\2k \3\2\2\2lm\7@\2\2m\"\3\2\2\2no\7>"+
		"\2\2op\7?\2\2p$\3\2\2\2qr\7>\2\2r&\3\2\2\2st\7-\2\2t(\3\2\2\2uv\7/\2\2"+
		"v*\3\2\2\2wy\t\6\2\2xw\3\2\2\2yz\3\2\2\2zx\3\2\2\2z{\3\2\2\2{,\3\2\2\2"+
		"|~\t\7\2\2}|\3\2\2\2~\177\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		"\u0081\3\2\2\2\u0081\u0082\b\27\2\2\u0082.\3\2\2\2\13\2\638FMQcz\177\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}