package Archivos;
import java_cup.runtime.*;
import static Archivos.symCapas.*;

%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%unicode
%column
%public

D = [0-9]+
SEPARADOR = \r|\n|\r\n
ESPACIO = {SEPARADOR} | [ \t\f]
COLOR= [#][[A-F]|[0-9]][[A-F]|[0-9]][[A-F]|[0-9]][[A-F]|[0-9]][[A-F]|[0-9]][[A-F]|[0-9]]
ERRORES = [^]

%{
  private Symbol symbol(int type, String lexema) {
        return new Symbol(type, new Token(lexema, yyline + 1, yycolumn + 1));
      }
%}
%%

/* Espacios en blanco */
{ESPACIO} {/*Ignore*/}

/* Llave de apertura */
( "{" ) {return  symbol(sym.Llave_a, yytext());}

/* Llave de cierre */
( "}" ) {return  symbol(sym.Llave_c, yytext());}

/* Coma */
( "," ) {return symbol(sym.Coma,  yytext());}

/* Punto y Coma */
( ";" ) {return symbol(sym.PuntoComa,  yytext());}

/* Numero */
{D} {return  symbol(sym.Numero, yytext());}

/* Color */
{COLOR} {return  symbol(sym.Color, yytext());}

/* Error */
{ERRORES} {return  symbol(sym.Error, yytext());}


