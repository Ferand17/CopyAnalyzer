package AnalizadorJS;
import java_cup.runtime.Symbol;
%%
%public
%class JslexCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
%caseless
%ignorecase
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ \t\r\n\f\b]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
"/*"~"*/" {
}

/* Comentarios */
"//"(.)* {
}

/* class */
( "class" ) {
return new Symbol(sym.Class, yychar, yyline, yytext());
}

/* Var */
( "var" ) {
return new Symbol(sym.Var, yychar, yyline, yytext());
}

/* Let */
( "let" ) {
return new Symbol(sym.Let, yychar, yyline, yytext());
}

/* Const */
( "const" ) {
return new Symbol(sym.Const, yychar, yyline, yytext());
}

/* if */
( "if" ) {
return new Symbol(sym.If, yychar, yyline, yytext());
}

/* Else */
( "else" ) {
return new Symbol(sym.Else, yychar, yyline, yytext());
}

/* true */
( "true" ) {
return new Symbol(sym.True, yychar, yyline, yytext());
}

/* false */
( "false" ) {
return new Symbol(sym.False, yychar, yyline, yytext());
}

/* for */
( "for" ) {
return new Symbol(sym.For, yychar, yyline, yytext());;
}

/* While */
( "while" ) {
return new Symbol(sym.While, yychar, yyline, yytext());
}

/* do */
( "do" ) {
return new Symbol(sym.Do, yychar, yyline, yytext());
}

/* switch */
( "switch" ) {
return new Symbol(sym.Switch, yychar, yyline, yytext());
}

/* break */
( "break" ) {
return new Symbol(sym.Break, yychar, yyline, yytext());
}

/* case */
( "case" ) {
return new Symbol(sym.Case, yychar, yyline, yytext());
}

/* default */
( "default" ) {
return new Symbol(sym.Default, yychar, yyline, yytext());
}

/* console */
( "console" ) {
return new Symbol(sym.Console, yychar, yyline, yytext());
}

/* log */
( "log" ) {
return new Symbol(sym.Log, yychar, yyline, yytext());
}

/* require */
( "require" ) {
return new Symbol(sym.Require, yychar, yyline, yytext());
}

/* Llave de apertura */
( "{" ) {
return new Symbol(sym.LlaveA, yychar, yyline, yytext());
}

/* Llave de cerradura */
( "}" ) {
return new Symbol(sym.LlaveC, yychar, yyline, yytext());
}

/* Parentesis Apertura */
( "(" ) {
return new Symbol(sym.ParenA, yychar, yyline, yytext());
}

/* Parentesis Cerradura */
( ")" ) {
return new Symbol(sym.ParenC, yychar, yyline, yytext());
}

/* Coma */
( "," ) {
return new Symbol(sym.Coma, yychar, yyline, yytext());;
}

/* Punto y Coma */
( ";" ) {
return new Symbol(sym.PuntoComa, yychar, yyline, yytext());
}

/* DosPuntos */
( ":" ) {
return new Symbol(sym.DosPuntos, yychar, yyline, yytext());
}

/* Igual */
( "=" ) {
return new Symbol(sym.Igual, yychar, yyline, yytext());
}

/* Mayor */
( ">" ) {
return new Symbol(sym.Mayor, yychar, yyline, yytext());
}

/* Menor */
( "<" ) {
return new Symbol(sym.Menor, yychar, yyline, yytext());
}

/* MayorIgual */
( ">=" ) {
return new Symbol(sym.MayorIgual, yychar, yyline, yytext());
}

/* MenorIgual */
( "<=" ) {
return new Symbol(sym.MenorIgual, yychar, yyline, yytext());
}

/* Diferencia */
( "!=" ) {
return new Symbol(sym.Diferencia, yychar, yyline, yytext());
}

/* AND */
( "&&" ) {
return new Symbol(sym.AND, yychar, yyline, yytext());
}

/* OR */
( "||" ) {
return new Symbol(sym.OR, yychar, yyline, yytext());
}

/* Negacion */
( "!" ) {
return new Symbol(sym.Negacion, yychar, yyline, yytext());
}

/* Incremento */
( "++" ) {
return new Symbol(sym.Incremento, yychar, yyline, yytext());
}

/* Igualacion */
( "==" ) {
return new Symbol(sym.Igualacion, yychar, yyline, yytext());
}

/* Decremento */
( "--" ) {
return new Symbol(sym.Decremento, yychar, yyline, yytext());
}

/* Mas */
( "+" ) {
return new Symbol(sym.Mas, yychar, yyline, yytext());
}

/* Menos */
( "-" ) {
return new Symbol(sym.Menos, yychar, yyline, yytext());
}

/* Multiplicacion */
( "*" ) {
return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());
}

/* Division */
( "/" ) {
return new Symbol(sym.Division, yychar, yyline, yytext());
}

/* Potencia */
( "**" ) {
return new Symbol(sym.Potencia, yychar, yyline, yytext());
}

/* Modulo */
( "%" ) {
return new Symbol(sym.Modulo, yychar, yyline, yytext());
}

/* Punto */
( "." ) {
return new Symbol(sym.Punto, yychar, yyline, yytext());
}

/* Cadena */
( "\""~"\"" ) {
return new Symbol(sym.Cadena, yychar, yyline, yytext());
}

/* CadenaS */
( "\'"~"\'" ) {
return new Symbol(sym.CadenaS, yychar, yyline, yytext());
}

/* Identificador */
{L}({L}|{D}|"_")* {
return new Symbol(sym.Identificador, yychar, yyline, yytext());
}

/* Numero */
"-"?{D}+ {
return new Symbol(sym.Entero, yychar, yyline, yytext());
}

/* Numero */
"-"?{D}+"."?{D}+ {
return new Symbol(sym.Decimal, yychar, yyline, yytext());
}

/* Error de analisis */
 . {
}