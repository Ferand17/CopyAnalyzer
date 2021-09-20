package AnalizadorJS;
import Modelos.Token;
import java.util.ArrayList;

%%
%public
%class Jslex
%type Token
%full
%line
%char
%caseless
%ignorecase
%{
    
    public ArrayList<String> comentarios= new ArrayList<>();
    public String dato = "";

%}
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ \t\r\n\f\b]+
%%
/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
"/*"~"*/" {
this.dato=yytext();
this.comentarios.add(dato);
return new Token(dato, "Comentario","Lexico", yychar, yyline);
}

/* Comentarios */
"//"(.)* {
this.dato=yytext();
this.comentarios.add(dato);
return new Token(dato, "Comentario","Lexico", yychar, yyline);
}

/* class */
( "class" ) {
return new Token(yytext(), "Class","Lexico", yychar, yyline);
}

/* Var */
( "var" ) {
return new Token(yytext(), "Var","Lexico", yychar, yyline);
}

/* Let */
( "let" ) {
return new Token(yytext(), "Let","Lexico", yychar, yyline);
}

/* Const */
( "const" ) {
return new Token(yytext(), "Const","Lexico", yychar, yyline);
}

/* if */
( "if" ) {
return new Token(yytext(), "If","Lexico", yychar, yyline);
}

/* Else */
( "else" ) {
return new Token(yytext(), "Else","Lexico", yychar, yyline);
}

/* true */
( "true" ) {
return new Token(yytext(), "True","Lexico", yychar, yyline);
}

/* false */
( "false" ) {
return new Token(yytext(), "False","Lexico", yychar, yyline);
}

/* for */
( "for" ) {
return new Token(yytext(), "For","Lexico", yychar, yyline);
}

/* While */
( "while" ) {
return new Token(yytext(), "While","Lexico", yychar, yyline);
}

/* do */
( "do" ) {
return new Token(yytext(), "Do","Lexico", yychar, yyline);
}

/* switch */
( "switch" ) {
return new Token(yytext(), "Switch","Lexico", yychar, yyline);
}

/* break */
( "break" ) {
return new Token(yytext(), "Break","Lexico", yychar, yyline);
}

/* case */
( "case" ) {
return new Token(yytext(), "Case","Lexico", yychar, yyline);
}

/* default */
( "default" ) {
return new Token(yytext(), "Default","Lexico", yychar, yyline);
}

/* console */
( "console" ) {
return new Token(yytext(), "Console","Lexico", yychar, yyline);
}

/* log */
( "log" ) {
return new Token(yytext(), "Log","Lexico", yychar, yyline);
}

/* require */
( "require" ) {
return new Token(yytext(), "Require","Lexico", yychar, yyline);
}

/* Llave de apertura */
( "{" ) {
return new Token(yytext(), "LlaveA","Lexico", yychar, yyline);
}

/* Llave de cerradura */
( "}" ) {
return new Token(yytext(), "LlaveC","Lexico", yychar, yyline);
}

/* Parentesis Apertura */
( "(" ) {
return new Token(yytext(), "ParenA","Lexico", yychar, yyline);
}

/* Parentesis Cerradura */
( ")" ) {
return new Token(yytext(), "ParenC","Lexico", yychar, yyline);
}

/* Parentesis Cerradura */
( "[" ) {
return new Token(yytext(), "CorcheA","Lexico", yychar, yyline);
}

/* Parentesis Cerradura */
( "]" ) {
return new Token(yytext(), "CorcheC","Lexico", yychar, yyline);
}

/* Coma */
( "," ) {
return new Token(yytext(), "Coma","Lexico", yychar, yyline);
}

/* Punto y Coma */
( ";" ) {
return new Token(yytext(), "PuntoComa","Lexico", yychar, yyline);
}

/* Punto y Coma */
( ":" ) {
return new Token(yytext(), "DosPuntos","Lexico", yychar, yyline);
}

/* DosPuntos */
( "=" ) {
return new Token(yytext(), "Igual","Lexico", yychar, yyline);
}

/* Mayor */
( ">" ) {
return new Token(yytext(), "Mayor","Lexico", yychar, yyline);
}

/* Menor */
( "<" ) {
return new Token(yytext(), "Menor","Lexico", yychar, yyline);
}

/* MayorIgual */
( ">=" ) {
return new Token(yytext(), "MayorIgual","Lexico", yychar, yyline);
}

/* MenorIgual */
( "<=" ) {
return new Token(yytext(), "MenorIgual","Lexico", yychar, yyline);
}

/* Diferencia */
( "!=" ) {
return new Token(yytext(), "Diferencia","Lexico", yychar, yyline);
}

/* AND */
( "&&" ) {
return new Token(yytext(), "AND","Lexico", yychar, yyline);
}

/* OR */
( "||" ) {
return new Token(yytext(), "OR","Lexico", yychar, yyline);
}

/* Negacion */
( "!" ) {
return new Token(yytext(), "Negacion","Lexico", yychar, yyline);
}

/* Incremento */
( "++" ) {
return new Token(yytext(), "Incremento","Lexico", yychar, yyline);
}

/* Incremento */
( "+=" ) {
return new Token(yytext(), "MasIgual","Lexico", yychar, yyline);
}

/* Incremento */
( "-=" ) {
return new Token(yytext(), "MenosIgual","Lexico", yychar, yyline);
}

/* Igualacion */
( "==" ) {
return new Token(yytext(), "Igualacion","Lexico", yychar, yyline);
}

/* Igualacion */
( "===" ) {
return new Token(yytext(), "IgualacionS","Lexico", yychar, yyline);
}

/* Decremento */
( "--" ) {
return new Token(yytext(), "Decremento","Lexico", yychar, yyline);
}

/* Mas */
( "+" ) {
return new Token(yytext(), "Mas","Lexico", yychar, yyline);
}

/* Menos */
( "-" ) {
return new Token(yytext(), "Menos","Lexico", yychar, yyline);
}

/* Multiplicacion */
( "*" ) {
return new Token(yytext(), "Multiplicacion","Lexico", yychar, yyline);
}

/* Division */
( "/" ) {
return new Token(yytext(), "Division","Lexico", yychar, yyline);
}

/* Potencia */
( "**" ) {
return new Token(yytext(), "Potencia","Lexico", yychar, yyline);
}

/* Modulo */
( "%" ) {
return new Token(yytext(), "Modulo","Lexico", yychar, yyline);
}

/* Punto */
( "." ) {
return new Token(yytext(), "Punto","Lexico", yychar, yyline);
}

/* Cadena */
( "\""~"\"" ) {
return new Token(yytext(), "Cadena","Lexico", yychar, yyline);
}

/* CadenaS */
( "\'"~"\'" ) {
return new Token(yytext(), "CadenaS","Lexico", yychar, yyline);
}

/* Identificador */
{L}({L}|{D}|"_")* {
return new Token(yytext(), "Identificador","Lexico", yychar, yyline);
}

/* Numero */
{D}+ {
return new Token(yytext(), "Entero","Lexico", yychar, yyline);
}

/* Numero */
{D}+"."?{D}+ {
return new Token(yytext(), "Decimal","Lexico", yychar, yyline);
}

/* Error de analisis */
 . {
return new Token(yytext(), "Error","Lexico", yychar, yyline);
}
