/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;

/**
 *
 * @author meza4
 */
public class NodoAb {
    public NodoAb izq;
    public int llave;
    public Object dato;
    public NodoAb der;
    
    public NodoAb(int llave, Object dato)
    {
        this( llave, dato, null, null );
    }
    
    public NodoAb(int llave, Object dato, NodoAb izq, NodoAb der)
    {
        this.llave = llave;
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }
    
    public void insertar(int llave, Object dato)
    {
        if( llave < this.llave )
        {
            if( null == this.izq )
                izq = new NodoAb( llave, dato );
            else
                izq.insertar( llave, dato );
        }
        else if( llave > this.llave )
        {
            if( null == this.der )
                der = new NodoAb( llave, dato );
            else
                der.insertar( llave, dato );
        }
        else
        {
            System.out.println( "Objeto repetido" );
        }
    }
    
    public void insertar(NodoAb nodo)
    {
        
        if( llave < this.llave )
        {
            
            if( null == this.izq )
                izq = nodo;
            else
                
                izq.insertar( nodo );
        }
        else if( llave > this.llave )
        {
             
            if( null == this.der )
                der = nodo;
            else
                der.insertar( nodo );
        }
        else
        {
            System.out.println( "Objeto repetido" );
        }
    }
}
