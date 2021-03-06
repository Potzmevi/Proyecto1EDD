
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package Archivos;

import java_cup.runtime.*;
import Estructuras.Cola;
import Estructuras.MatrizDispersa;
import Main.Controlador;
import Nodos.NodoMatriz;
import java_cup.runtime.XMLElement;
import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parserUsuarios extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return symUsuario.class;
}

  /** Default constructor. */
  @Deprecated
  public parserUsuarios() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parserUsuarios(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parserUsuarios(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\012\000\002\002\004\000\002\002\004\000\002\002" +
    "\002\000\002\003\006\000\002\003\003\000\002\004\004" +
    "\000\002\004\003\000\002\004\002\000\002\005\004\000" +
    "\002\005\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\016\000\010\002\uffff\003\uffff\010\uffff\001\002\000" +
    "\010\002\010\003\007\010\005\001\002\000\004\004\011" +
    "\001\002\000\010\002\000\003\000\010\000\001\002\000" +
    "\010\002\ufffd\003\ufffd\010\ufffd\001\002\000\004\002\001" +
    "\001\002\000\012\003\ufffa\005\ufffa\006\ufffa\007\012\001" +
    "\002\000\010\003\ufffb\005\ufffb\006\ufffb\001\002\000\010" +
    "\003\014\005\015\006\016\001\002\000\010\003\ufff8\005" +
    "\ufff8\006\ufff8\001\002\000\004\007\020\001\002\000\010" +
    "\002\ufffe\003\ufffe\010\ufffe\001\002\000\010\003\ufffc\005" +
    "\ufffc\006\ufffc\001\002\000\010\003\ufff9\005\ufff9\006\ufff9" +
    "\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\016\000\004\002\003\001\001\000\004\003\005\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\004\012\001\001\000\002\001" +
    "\001\000\004\005\016\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parserUsuarios$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parserUsuarios$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parserUsuarios$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



	List<Integer> lista = new ArrayList<>();
	public parserUsuarios(LexUsuario lex) {
        super(lex);
    }		 


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parserUsuarios$actions {
  private final parserUsuarios parser;

  /** Constructor */
  CUP$parserUsuarios$actions(parserUsuarios parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parserUsuarios$do_action_part00000000(
    int                        CUP$parserUsuarios$act_num,
    java_cup.runtime.lr_parser CUP$parserUsuarios$parser,
    java.util.Stack            CUP$parserUsuarios$stack,
    int                        CUP$parserUsuarios$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parserUsuarios$result;

      /* select the action based on the action number */
      switch (CUP$parserUsuarios$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= INICIO EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.elementAt(CUP$parserUsuarios$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.elementAt(CUP$parserUsuarios$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parserUsuarios$stack.elementAt(CUP$parserUsuarios$top-1)).value;
		RESULT = start_val;
              CUP$parserUsuarios$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.elementAt(CUP$parserUsuarios$top-1)), ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parserUsuarios$parser.done_parsing();
          return CUP$parserUsuarios$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // INICIO ::= INICIO SENTENCIA 
            {
              Object RESULT =null;

              CUP$parserUsuarios$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.elementAt(CUP$parserUsuarios$top-1)), ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.peek()), RESULT);
            }
          return CUP$parserUsuarios$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // INICIO ::= 
            {
              Object RESULT =null;

              CUP$parserUsuarios$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.peek()), RESULT);
            }
          return CUP$parserUsuarios$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // SENTENCIA ::= ID DosPuntos USUARIO PuntoComa 
            {
              Object RESULT =null;
		int I1left = ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.elementAt(CUP$parserUsuarios$top-3)).left;
		int I1right = ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.elementAt(CUP$parserUsuarios$top-3)).right;
		Token I1 = (Token)((java_cup.runtime.Symbol) CUP$parserUsuarios$stack.elementAt(CUP$parserUsuarios$top-3)).value;
		Controlador.insertarUsuario(I1.getLexeme()+"",lista);
              CUP$parserUsuarios$result = parser.getSymbolFactory().newSymbol("SENTENCIA",1, ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.elementAt(CUP$parserUsuarios$top-3)), ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.peek()), RESULT);
            }
          return CUP$parserUsuarios$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // SENTENCIA ::= error 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.peek()).right;
		Object e = (Object)((java_cup.runtime.Symbol) CUP$parserUsuarios$stack.peek()).value;
		  
              CUP$parserUsuarios$result = parser.getSymbolFactory().newSymbol("SENTENCIA",1, ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.peek()), ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.peek()), RESULT);
            }
          return CUP$parserUsuarios$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // USUARIO ::= USUARIO LINEA 
            {
              Object RESULT =null;

              CUP$parserUsuarios$result = parser.getSymbolFactory().newSymbol("USUARIO",2, ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.elementAt(CUP$parserUsuarios$top-1)), ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.peek()), RESULT);
            }
          return CUP$parserUsuarios$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // USUARIO ::= Numero 
            {
              Object RESULT =null;
		int R1left = ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.peek()).left;
		int R1right = ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.peek()).right;
		Token R1 = (Token)((java_cup.runtime.Symbol) CUP$parserUsuarios$stack.peek()).value;
		lista = new ArrayList<>();lista.add(Integer.parseInt(R1.getLexeme()));
              CUP$parserUsuarios$result = parser.getSymbolFactory().newSymbol("USUARIO",2, ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.peek()), ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.peek()), RESULT);
            }
          return CUP$parserUsuarios$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // USUARIO ::= 
            {
              Object RESULT =null;

              CUP$parserUsuarios$result = parser.getSymbolFactory().newSymbol("USUARIO",2, ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.peek()), RESULT);
            }
          return CUP$parserUsuarios$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // LINEA ::= Coma Numero 
            {
              Object RESULT =null;
		int R2left = ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.peek()).left;
		int R2right = ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.peek()).right;
		Token R2 = (Token)((java_cup.runtime.Symbol) CUP$parserUsuarios$stack.peek()).value;
		lista.add(Integer.parseInt(R2.getLexeme()));
              CUP$parserUsuarios$result = parser.getSymbolFactory().newSymbol("LINEA",3, ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.elementAt(CUP$parserUsuarios$top-1)), ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.peek()), RESULT);
            }
          return CUP$parserUsuarios$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // LINEA ::= error 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.peek()).right;
		Object e = (Object)((java_cup.runtime.Symbol) CUP$parserUsuarios$stack.peek()).value;
		  
              CUP$parserUsuarios$result = parser.getSymbolFactory().newSymbol("LINEA",3, ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.peek()), ((java_cup.runtime.Symbol)CUP$parserUsuarios$stack.peek()), RESULT);
            }
          return CUP$parserUsuarios$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parserUsuarios$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parserUsuarios$do_action(
    int                        CUP$parserUsuarios$act_num,
    java_cup.runtime.lr_parser CUP$parserUsuarios$parser,
    java.util.Stack            CUP$parserUsuarios$stack,
    int                        CUP$parserUsuarios$top)
    throws java.lang.Exception
    {
              return CUP$parserUsuarios$do_action_part00000000(
                               CUP$parserUsuarios$act_num,
                               CUP$parserUsuarios$parser,
                               CUP$parserUsuarios$stack,
                               CUP$parserUsuarios$top);
    }
}

}
