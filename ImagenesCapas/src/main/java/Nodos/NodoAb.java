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
    public String llave;
    public Object dato;
    public NodoAb der;
    
    public NodoAb(String llave, Object dato)
    {
        this( llave, dato, null, null );
    }
    
    public NodoAb(String llave, Object dato, NodoAb izq, NodoAb der)
    {
        this.llave = llave;
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }
    
    public void insertar(String llave, Object dato)
    {
        
        if( llave.compareTo(this.llave) <0 )
        {
            if( null == this.izq )
                izq = new NodoAb( llave, dato );
            else
                izq.insertar( llave, dato );
        }
        else if( llave.compareTo(this.llave) >0 )
        {
            if( null == this.der )
                der = new NodoAb( llave, dato );
            else
                der.insertar( llave, dato );
        }
        else
        {
            System.out.println( "Datos repetidos" );
        }
    }
    
    public void insertar(NodoAb nodo)
    {
        if( llave.compareTo(this.llave) <0 )
        {
            if( null == this.izq )
                izq = nodo;
            else
                izq.insertar( nodo );
        }
        else if( llave.compareTo(this.llave) >0 )
        {
            if( null == this.der )
                der = nodo;
            else
                der.insertar( nodo );
        }
        else
        {
            System.out.println( "Datos repetidos" );
        }
    }
}
