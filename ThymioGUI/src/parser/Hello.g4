grammar Hello;

@header{
package parser;
}

TK_AND: '&' | 'AND';
TK_OR: '|' | 'OR';
TK_POSS: 'poss';
TK_DO:	'do';
TK_ID : [a-z][a-z0-9]* ;             // match lower-case identifiers
TK_VAR : [A-Z][A-Za-z0-9]* | '_';
TK_IMP: '->' ;
TK_SEP: ',';
TK_EQUAL: '=';
TK_NUM_EQUAL: '==';
TK_DOT: '.';
TK_NEG: '!' | 'NOT';
TK_BRK_OPEN: '(';
TK_BRK_CLOSE: ')';
TK_GEQ: '>=';
TK_GE: '>';
TK_LEQ: '<=';
TK_LE: '<';
TK_PLUS: '+';
TK_MINUS: '-';
TK_NUM: [0-9]+;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

th_rule: th_premise TK_IMP th_consequence TK_DOT;

th_premise returns [String f]: th_formula {$f = $th_formula.f;} (TK_AND th_formula {$f += ", " + $th_formula.f;})*;

th_consequence returns [String f]:	poss_formula {$f = $poss_formula.f;} |
									fluent_formula {$f = $fluent_formula.f;} |
									th_formula {$f = $th_formula.f;};

poss_formula returns [String f]: TK_POSS '(' args ')' {$f = $TK_POSS.text + "(" + $args.s + ")";};

fluent_formula returns [String f]:	TK_ID '(' args ',' do_formula ')'
{
	$f = $TK_ID.text + "(" + $args.s + "," + $do_formula.f + ")";
};

do_formula returns [String f]:	TK_DO {$f = $TK_DO.text + "(";}
                                '(' TK_VAR {$f += $TK_VAR.text + ",";} ','
                                    TK_VAR {$f += $TK_VAR.text + ")";}
                                ')';

id_formula returns [String id]: TK_VAR TK_EQUAL arg { $id = $TK_VAR.text + "=" + $arg.s; } |
                                TK_VAR TK_EQUAL th_formula { $id = $TK_VAR.text + "=" + $th_formula.f; };

neg_formula returns [String f]:  TK_NEG th_formula {$f = "\\+" + $th_formula.f; } |
                                 TK_NEG TK_BRK_OPEN comp_formula TK_BRK_CLOSE {$f = "\\+(" + $comp_formula.f + ")"; };

comp_formula returns [String f]: TK_VAR TK_GEQ expr {$f = $TK_VAR.text + ">=" + $expr.e; } |
								 TK_VAR TK_GE expr {$f = $TK_VAR.text + ">" + $expr.e; } |
								 TK_VAR TK_LEQ expr {$f = $TK_VAR.text + "<=" + $expr.e; } |
								 TK_VAR TK_LE expr {$f = $TK_VAR.text + "<" + $expr.e; } |
								 TK_VAR TK_NUM_EQUAL expr {$f = $TK_VAR.text + " is " + $expr.e; };
								 
expr returns [String e]:	op {$e = $op.o;} |
							op {$e = $op.o;} TK_PLUS op {$e += "+" + $op.o;} |
							op {$e = $op.o;} TK_MINUS op {$e += "-" + $op.o;};
							
op returns [String o]:	TK_VAR {$o = $TK_VAR.text;} |
						TK_NUM {$o = $TK_NUM.text;};
							

th_formula returns [String f]:	TK_ID '(' args ')' {$f = $TK_ID.text + "(" + $args.s + ")";} |
                                id_formula {$f = $id_formula.id;} |
                                comp_formula {$f = $comp_formula.f;} |
                                neg_formula {$f = $neg_formula.f;};

args returns [String s]:	arg {$s = $arg.s;} (TK_SEP arg {$s += ","; $s += $arg.s;})*;

arg returns [String s]: TK_ID {$s = $TK_ID.text;} |
						TK_ID '(' args ')' {$s = $TK_ID.text + "(" + $args.s + ")";} |
  						TK_VAR {$s = $TK_VAR.text;};