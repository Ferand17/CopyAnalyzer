package Analizador;
import Modelos.Token;
%%
%public
%class Fcalex
%type Token
%full
%line
%char
%caseless
%ignorecase
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ \t\r\n\f\b]+
%%
/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
"#*"~"*#" {
return new Token(yytext(), "ComentarioM","Lexico", yychar, yyline);
}

/* Comentarios */
"##"(.)* {
return new Token(yytext(), "Comentario","Lexico", yychar, yyline);
}

/* compare */
( "compare" ) {
return new Token(yytext(), "Compare","Lexico", yychar, yyline);
}

/* definirglobales */
( "definirglobales" ) {
return new Token(yytext(), "DefinirGlobales","Lexico", yychar, yyline);
}

/* graficabarras */
( "graficabarras" ) {
return new Token(yytext(), "GraficaBarras","Lexico", yychar, yyline);
}

/* string */
( "string" ) {
return new Token(yytext(), "String","Lexico", yychar, yyline);
}

/* double */
( "double" ) {
return new Token(yytext(), "Double","Lexico", yychar, yyline);
}

/* titulo */
( "titulo" ) {
return new Token(yytext(), "Titulo","Lexico", yychar, yyline);
}

/* ejex */
( "ejex" ) {
return new Token(yytext(), "Ejex","Lexico", yychar, yyline);
}

/* valores */
( "valores" ) {
return new Token(yytext(), "Valores","Lexico", yychar, yyline);
}

/* PuntajeEspecifico */
( "puntajeespecifico" ) {
return new Token(yytext(), "PuntajeEspecifico","Lexico", yychar, yyline);
}

/*  PuntajeGeneral  */
( "puntajegeneral" ) {
return new Token(yytext(), "PuntajeGeneral","Lexico", yychar, yyline);
}

/* titulox */
( "titulox" ) {
return new Token(yytext(), "TituloX","Lexico", yychar, yyline);
}

/* tituloy */
( "tituloy" ) {
return new Token(yytext(), "TituloY","Lexico", yychar, yyline);
}

/* graficapie */
( "graficapie" ) {
return new Token(yytext(), "GraficaPie","Lexico", yychar, yyline);
}

/* GraficaLineas */
( "graficalineas" ) {
return new Token(yytext(), "GraficaLineas","Lexico", yychar, yyline);
}

/* generarReporteEstadistico */
( "generarreporteestadistico" ) {
return new Token(yytext(), "GenerarReporteEstadistico","Lexico", yychar, yyline);
}

/* archivo */
( "archivo" ) {
return new Token(yytext(), "Archivo","Lexico", yychar, yyline);
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

/* Coma */
( "," ) {
return new Token(yytext(), "Coma","Lexico", yychar, yyline);
}

/* Punto y Coma */
( ";" ) {
return new Token(yytext(), "PuntoComa","Lexico", yychar, yyline);
}

/* DosPuntos */
( ":" ) {
return new Token(yytext(), "DosPuntos","Lexico", yychar, yyline);
}

/* Igual */
( "=" ) {
return new Token(yytext(), "Igual","Lexico", yychar, yyline);
}

/* Dollar */
( "$" ) {
return new Token(yytext(), "Dollar","Lexico", yychar, yyline);
}

/* corchete Apertura */
( "[" ) {
return new Token(yytext(), "CorcheA","Lexico", yychar, yyline);
}

/* Corchete Cerradura */
( "]" ) {
return new Token(yytext(), "CorcheC","Lexico", yychar, yyline);
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
"-"?{D}+"."?{D}+ {
return new Token(yytext(), "Numero","Lexico", yychar, yyline);
}

/* Error de analisis */
 . {
return new Token(yytext(), "Error","Lexico", yychar, yyline);
}
