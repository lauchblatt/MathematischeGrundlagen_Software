grammar Hello;

@header{
package parser;
}

TK_AND: '&' | 'AND';
TK_POSS: 'poss';
TK_DO:	'do';
TK_ID : [a-z]+ ;             // match lower-case identifiers
TK_VAR : [A-Z]+ | '_';
TK_IMP: '->' ;
TK_SEP: ',';
TK_EQUAL: '=';
TK_DOT: '.';

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

th_rule: th_premise TK_IMP th_consequence TK_DOT;

th_premise returns [String f]: th_formula {$f = $th_formula.f;} (TK_AND th_formula {$f += ", " + $th_formula.f;})*;

th_consequence returns [String f]:	poss_formula {$f = $poss_formula.f;} |
									fluent_formula {$f = $fluent_formula.f;};

poss_formula returns [String f]: TK_POSS '(' args ')' {$f = $TK_POSS.text + "(" + $args.s + ")";};

fluent_formula returns [String f]:	TK_ID '(' args ',' do_formula ')'
{
	$f = $TK_ID.text + "(" + $args.s + "," + $do_formula.f + ")";
};

do_formula returns [String f]:	TK_DO {$f = $TK_DO.text + "(";}
                                '(' TK_VAR {$f += $TK_VAR.text + ",";} ','
                                    TK_VAR {$f += $TK_VAR.text + ")";}
                                ')';

id_formula returns [String id]: TK_VAR TK_EQUAL f=th_formula
{
	$id = $TK_VAR.text + "=" + $th_formula.f;
};

th_formula returns [String f]:	TK_ID '(' args ')' {$f = $TK_ID.text + "(" + $args.s + ")";} |
                                id_formula {$f = $id_formula.id;};

args returns [String s]:	arg {$s = $arg.s;} (TK_SEP arg {$s += ","; $s += $arg.s;})*;

arg returns [String s]: TK_ID {$s = $TK_ID.text;} |
  						TK_VAR {$s = $TK_VAR.text;};