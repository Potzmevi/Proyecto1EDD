package Archivos;
import java_cup.runtime.*;
import static Archivos.symCapas.*;

%%
%class LexUsuario
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
ERRORES = [^]
TEXTO = [:jletterdigit:]+

%{
  private Symbol symbol(int type, String lexema) {
        return new Symbol(type, new Token(lexema, yyline + 1, yycolumn + 1));
      }
%}
%%

/* Espacios en blanco */
{ESPACIO} {/*Ignore*/}

/* Punto y coma */
( ";" ) {return  symbol(symUsuario.PuntoComa, yytext());}

/* Dos puntos */
( ":" ) {return  symbol(symUsuario.DosPuntos, yytext());}

/* Coma */
( "," ) {return symbol(symUsuario.Coma,  yytext());}

/* Numero */
{D} {return  symbol(symUsuario.Numero, yytext());}

/* Texto */
{TEXTO} {return  symbol(symUsuario.ID, yytext());}

/* Error */
{ERRORES} {/*Ignore*/}


