/* Generated By:JJTree&JavaCC: Do not edit this line. PythonGrammar30Constants.java */
package org.python.pydev.parser.grammar30;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface PythonGrammar30Constants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int SPACE = 1;
  /** RegularExpression Id. */
  int CONTINUATION = 4;
  /** RegularExpression Id. */
  int NEWLINE1 = 5;
  /** RegularExpression Id. */
  int NEWLINE = 6;
  /** RegularExpression Id. */
  int NEWLINE2 = 7;
  /** RegularExpression Id. */
  int CRLF1 = 11;
  /** RegularExpression Id. */
  int DEDENT = 13;
  /** RegularExpression Id. */
  int INDENT = 14;
  /** RegularExpression Id. */
  int TRAILING_COMMENT = 15;
  /** RegularExpression Id. */
  int SINGLE_LINE_COMMENT = 16;
  /** RegularExpression Id. */
  int LPAREN = 17;
  /** RegularExpression Id. */
  int RPAREN = 18;
  /** RegularExpression Id. */
  int LBRACE = 19;
  /** RegularExpression Id. */
  int RBRACE = 20;
  /** RegularExpression Id. */
  int LBRACKET = 21;
  /** RegularExpression Id. */
  int RBRACKET = 22;
  /** RegularExpression Id. */
  int SEMICOLON = 23;
  /** RegularExpression Id. */
  int COMMA = 24;
  /** RegularExpression Id. */
  int DOT = 25;
  /** RegularExpression Id. */
  int COLON = 26;
  /** RegularExpression Id. */
  int PLUS = 27;
  /** RegularExpression Id. */
  int MINUS = 28;
  /** RegularExpression Id. */
  int MINUS_GREATER = 29;
  /** RegularExpression Id. */
  int MULTIPLY = 30;
  /** RegularExpression Id. */
  int DIVIDE = 31;
  /** RegularExpression Id. */
  int FLOORDIVIDE = 32;
  /** RegularExpression Id. */
  int POWER = 33;
  /** RegularExpression Id. */
  int LSHIFT = 34;
  /** RegularExpression Id. */
  int RSHIFT = 35;
  /** RegularExpression Id. */
  int MODULO = 36;
  /** RegularExpression Id. */
  int NOT = 37;
  /** RegularExpression Id. */
  int XOR = 38;
  /** RegularExpression Id. */
  int OR = 39;
  /** RegularExpression Id. */
  int AND = 40;
  /** RegularExpression Id. */
  int EQUAL = 41;
  /** RegularExpression Id. */
  int GREATER = 42;
  /** RegularExpression Id. */
  int LESS = 43;
  /** RegularExpression Id. */
  int EQEQUAL = 44;
  /** RegularExpression Id. */
  int EQLESS = 45;
  /** RegularExpression Id. */
  int EQGREATER = 46;
  /** RegularExpression Id. */
  int NOTEQUAL = 47;
  /** RegularExpression Id. */
  int PLUSEQ = 48;
  /** RegularExpression Id. */
  int MINUSEQ = 49;
  /** RegularExpression Id. */
  int MULTIPLYEQ = 50;
  /** RegularExpression Id. */
  int DIVIDEEQ = 51;
  /** RegularExpression Id. */
  int FLOORDIVIDEEQ = 52;
  /** RegularExpression Id. */
  int MODULOEQ = 53;
  /** RegularExpression Id. */
  int ANDEQ = 54;
  /** RegularExpression Id. */
  int OREQ = 55;
  /** RegularExpression Id. */
  int XOREQ = 56;
  /** RegularExpression Id. */
  int LSHIFTEQ = 57;
  /** RegularExpression Id. */
  int RSHIFTEQ = 58;
  /** RegularExpression Id. */
  int POWEREQ = 59;
  /** RegularExpression Id. */
  int OR_BOOL = 60;
  /** RegularExpression Id. */
  int AND_BOOL = 61;
  /** RegularExpression Id. */
  int NOT_BOOL = 62;
  /** RegularExpression Id. */
  int IS = 63;
  /** RegularExpression Id. */
  int IN = 64;
  /** RegularExpression Id. */
  int LAMBDA = 65;
  /** RegularExpression Id. */
  int IF = 66;
  /** RegularExpression Id. */
  int ELSE = 67;
  /** RegularExpression Id. */
  int ELIF = 68;
  /** RegularExpression Id. */
  int WHILE = 69;
  /** RegularExpression Id. */
  int FOR = 70;
  /** RegularExpression Id. */
  int TRY = 71;
  /** RegularExpression Id. */
  int EXCEPT = 72;
  /** RegularExpression Id. */
  int DEF = 73;
  /** RegularExpression Id. */
  int ASYNC = 74;
  /** RegularExpression Id. */
  int CLASS = 75;
  /** RegularExpression Id. */
  int FINALLY = 76;
  /** RegularExpression Id. */
  int PASS = 77;
  /** RegularExpression Id. */
  int BREAK = 78;
  /** RegularExpression Id. */
  int CONTINUE = 79;
  /** RegularExpression Id. */
  int RETURN = 80;
  /** RegularExpression Id. */
  int YIELD = 81;
  /** RegularExpression Id. */
  int IMPORT = 82;
  /** RegularExpression Id. */
  int FROM = 83;
  /** RegularExpression Id. */
  int DEL = 84;
  /** RegularExpression Id. */
  int RAISE = 85;
  /** RegularExpression Id. */
  int GLOBAL = 86;
  /** RegularExpression Id. */
  int NONLOCAL = 87;
  /** RegularExpression Id. */
  int ASSERT = 88;
  /** RegularExpression Id. */
  int AS = 89;
  /** RegularExpression Id. */
  int WITH = 90;
  /** RegularExpression Id. */
  int FALSE = 91;
  /** RegularExpression Id. */
  int TRUE = 92;
  /** RegularExpression Id. */
  int NONE = 93;
  /** RegularExpression Id. */
  int AT = 94;
  /** RegularExpression Id. */
  int NAME = 95;
  /** RegularExpression Id. */
  int LETTER = 96;
  /** RegularExpression Id. */
  int DECNUMBER = 97;
  /** RegularExpression Id. */
  int HEXNUMBER = 98;
  /** RegularExpression Id. */
  int OCTNUMBER = 99;
  /** RegularExpression Id. */
  int BINNUMBER = 100;
  /** RegularExpression Id. */
  int FLOAT = 101;
  /** RegularExpression Id. */
  int COMPLEX = 102;
  /** RegularExpression Id. */
  int EXPONENT = 103;
  /** RegularExpression Id. */
  int DIGIT = 104;
  /** RegularExpression Id. */
  int SINGLE_STRING = 117;
  /** RegularExpression Id. */
  int SINGLE_STRING2 = 118;
  /** RegularExpression Id. */
  int TRIPLE_STRING = 119;
  /** RegularExpression Id. */
  int TRIPLE_STRING2 = 120;
  /** RegularExpression Id. */
  int SINGLE_BSTRING = 121;
  /** RegularExpression Id. */
  int SINGLE_BSTRING2 = 122;
  /** RegularExpression Id. */
  int TRIPLE_BSTRING = 123;
  /** RegularExpression Id. */
  int TRIPLE_BSTRING2 = 124;
  /** RegularExpression Id. */
  int SINGLE_USTRING = 125;
  /** RegularExpression Id. */
  int SINGLE_USTRING2 = 126;
  /** RegularExpression Id. */
  int TRIPLE_USTRING = 127;
  /** RegularExpression Id. */
  int TRIPLE_USTRING2 = 128;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int FORCE_NEWLINE1 = 1;
  /** Lexical state. */
  int FORCE_NEWLINE2 = 2;
  /** Lexical state. */
  int INDENTING = 3;
  /** Lexical state. */
  int INDENTATION_UNCHANGED = 4;
  /** Lexical state. */
  int UNREACHABLE = 5;
  /** Lexical state. */
  int IN_STRING11 = 6;
  /** Lexical state. */
  int IN_STRING21 = 7;
  /** Lexical state. */
  int IN_STRING13 = 8;
  /** Lexical state. */
  int IN_STRING23 = 9;
  /** Lexical state. */
  int IN_BSTRING11 = 10;
  /** Lexical state. */
  int IN_BSTRING21 = 11;
  /** Lexical state. */
  int IN_BSTRING13 = 12;
  /** Lexical state. */
  int IN_BSTRING23 = 13;
  /** Lexical state. */
  int IN_USTRING11 = 14;
  /** Lexical state. */
  int IN_USTRING21 = 15;
  /** Lexical state. */
  int IN_USTRING13 = 16;
  /** Lexical state. */
  int IN_USTRING23 = 17;
  /** Lexical state. */
  int IN_STRING1NLC = 18;
  /** Lexical state. */
  int IN_STRING2NLC = 19;
  /** Lexical state. */
  int IN_USTRING1NLC = 20;
  /** Lexical state. */
  int IN_USTRING2NLC = 21;
  /** Lexical state. */
  int IN_BSTRING1NLC = 22;
  /** Lexical state. */
  int IN_BSTRING2NLC = 23;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\f\"",
    "<CONTINUATION>",
    "<NEWLINE1>",
    "<NEWLINE>",
    "<NEWLINE2>",
    "\"\\t\"",
    "\" \"",
    "\"\\f\"",
    "<CRLF1>",
    "\"\"",
    "\"\"",
    "\"<INDENT>\"",
    "<TRAILING_COMMENT>",
    "<SINGLE_LINE_COMMENT>",
    "\"(\"",
    "\")\"",
    "\"{\"",
    "\"}\"",
    "\"[\"",
    "\"]\"",
    "\";\"",
    "\",\"",
    "\".\"",
    "\":\"",
    "\"+\"",
    "\"-\"",
    "\"->\"",
    "\"*\"",
    "\"/\"",
    "\"//\"",
    "\"**\"",
    "\"<<\"",
    "\">>\"",
    "\"%\"",
    "\"~\"",
    "\"^\"",
    "\"|\"",
    "\"&\"",
    "\"=\"",
    "\">\"",
    "\"<\"",
    "\"==\"",
    "\"<=\"",
    "\">=\"",
    "\"!=\"",
    "\"+=\"",
    "\"-=\"",
    "\"*=\"",
    "\"/=\"",
    "\"//=\"",
    "\"%=\"",
    "\"&=\"",
    "\"|=\"",
    "\"^=\"",
    "\"<<=\"",
    "\">>=\"",
    "\"**=\"",
    "\"or\"",
    "\"and\"",
    "\"not\"",
    "\"is\"",
    "\"in\"",
    "\"lambda\"",
    "\"if\"",
    "\"else\"",
    "\"elif\"",
    "\"while\"",
    "\"for\"",
    "\"try\"",
    "\"except\"",
    "\"def\"",
    "\"async\"",
    "\"class\"",
    "\"finally\"",
    "\"pass\"",
    "\"break\"",
    "\"continue\"",
    "\"return\"",
    "\"yield\"",
    "\"import\"",
    "\"from\"",
    "\"del\"",
    "\"raise\"",
    "\"global\"",
    "\"nonlocal\"",
    "\"assert\"",
    "\"as\"",
    "\"with\"",
    "\"False\"",
    "\"True\"",
    "\"None\"",
    "\"@\"",
    "<NAME>",
    "<LETTER>",
    "<DECNUMBER>",
    "<HEXNUMBER>",
    "<OCTNUMBER>",
    "<BINNUMBER>",
    "<FLOAT>",
    "<COMPLEX>",
    "<EXPONENT>",
    "<DIGIT>",
    "<token of kind 105>",
    "<token of kind 106>",
    "<token of kind 107>",
    "<token of kind 108>",
    "<token of kind 109>",
    "<token of kind 110>",
    "<token of kind 111>",
    "<token of kind 112>",
    "<token of kind 113>",
    "<token of kind 114>",
    "<token of kind 115>",
    "<token of kind 116>",
    "\"\\\'\"",
    "\"\\\"\"",
    "\"\\\'\\\'\\\'\"",
    "\"\\\"\\\"\\\"\"",
    "\"\\\'\"",
    "\"\\\"\"",
    "\"\\\'\\\'\\\'\"",
    "\"\\\"\\\"\\\"\"",
    "\"\\\'\"",
    "\"\\\"\"",
    "\"\\\'\\\'\\\'\"",
    "\"\\\"\\\"\\\"\"",
    "\"\\\\\\r\\n\"",
    "<token of kind 130>",
    "\"\\\\\\r\\n\"",
    "<token of kind 132>",
    "\"\\\\\\r\\n\"",
    "<token of kind 134>",
    "\"\\\\\\r\\n\"",
    "<token of kind 136>",
    "\"\\\\\\r\\n\"",
    "<token of kind 138>",
    "\"\\\\\\r\\n\"",
    "<token of kind 140>",
    "\"\"",
    "\"\"",
    "\"\"",
    "\"\"",
    "\"\"",
    "\"\"",
    "<token of kind 147>",
    "<token of kind 148>",
    "\"\\r\\n\"",
    "\"\\n\"",
    "\"\\r\"",
    "<token of kind 152>",
    "<token of kind 153>",
  };

}
