package Analizador;
import java_cup.runtime.Symbol;
%%
%public
%class FcalexCup
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
"#*"~"*#" {
}

/* Comentarios */
"##"(.)* {
}

/* compare */
( "compare" ) {
return new Symbol(sym.Compare, yychar, yyline, yytext());
}

/* definirglobales */
( "definirglobales" ) {
return new Symbol(sym.DefinirGlobales, yychar, yyline, yytext());
}

/* graficabarras */
( "graficabarras" ) {
return new Symbol(sym.GraficaBarras, yychar, yyline, yytext());
}

/* string */
( "string" ) {
return new Symbol(sym.String, yychar, yyline, yytext());
}

/* double */
( "double" ) {
return new Symbol(sym.Double, yychar, yyline, yytext());
}

/* titulo */
( "titulo" ) {
return new Symbol(sym.Titulo, yychar, yyline, yytext());
}

/* ejex */
( "ejex" ) {
return new Symbol(sym.Ejex, yychar, yyline, yytext());
}

/* valores */
( "valores" ) {
return new Symbol(sym.Valores, yychar, yyline, yytext());
}

/* PuntajeEspecifico */
( "puntajeespecifico" ) {
return new Symbol(sym.PuntajeEspecifico, yychar, yyline, yytext());
}

/*  PuntajeGeneral  */
( "puntajegeneral" ) {
return new Symbol(sym.PuntajeGeneral , yychar, yyline, yytext());
}

/* titulox */
( "titulox" ) {
return new Symbol(sym.TituloX, yychar, yyline, yytext());
}

/* tituloy */
( "tituloy" ) {
return new Symbol(sym.TituloY, yychar, yyline, yytext());
}

/* graficapie */
( "graficapie" ) {
return new Symbol(sym.GraficaPie, yychar, yyline, yytext());
}

/* GraficaLineas */
( "graficalineas" ) {
return new Symbol(sym.GraficaLineas, yychar, yyline, yytext());
}

/* generarReporteEstadistico */
( "generarreporteestadistico" ) {
return new Symbol(sym.GenerarReporteEstadistico, yychar, yyline, yytext());
}

/* archivo */
( "archivo" ) {
return new Symbol(sym.Archivo, yychar, yyline, yytext());
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

/* Punto y Coma */
( ";" ) {
return new Symbol(sym.PuntoComa, yychar, yyline, yytext());
}

/* DosPuntos */
( ":" ) {
return new Symbol(sym.DosPuntos, yychar, yyline, yytext());
}

/* Coma */
( "," ) {
return new Symbol(sym.Coma, yychar, yyline, yytext());
}

/* Igual */
( "=" ) {
return new Symbol(sym.Igual, yychar, yyline, yytext());
}

/* Dollar */
( "$" ) {
return new Symbol(sym.Dollar, yychar, yyline, yytext());
}

/* corchete Apertura */
( "[" ) {
return new Symbol(sym.CorcheA, yychar, yyline, yytext());
}

/* Corchete Cerradura */
( "]" ) {
return new Symbol(sym.CorcheC, yychar, yyline, yytext());
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
"-"?{D}+"."?{D}+ {
return new Symbol(sym.Numero, yychar, yyline, yytext());
}

/* Error de analisis */
 . {
}
