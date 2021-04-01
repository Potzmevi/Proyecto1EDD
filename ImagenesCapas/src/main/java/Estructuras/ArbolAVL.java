/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Nodos.NodoAVL;
import Main.NodoDuplicado;
import Objetos.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author meza4
 */
public class ArbolAVL {
    
    private NodoAVL raiz;
    public int size;
    
    public ArbolAVL(){
        this.raiz = null;
        size = 0;
    }
    
    public NodoAVL buscar(String id,NodoAVL raiz) {
        if(raiz == null) {
            return null;
        } if (id.compareTo(raiz.getClave()) == 0) {
            return raiz;
        } if (id.compareTo(raiz.getClave()) > 0) {
            return buscar(id,raiz.getDer());
        } if (id.compareTo(raiz.getClave()) < 0){
            return buscar(id,raiz.getIzq());
        }
        return null;
    }
    
    public NodoAVL buscar(String id) {
        return buscar(id,this.raiz);
    }
    
    public int obtenerAltura(NodoAVL x){
        if(x == null) {
            return -1;
        }
        return x.getFactorEquilibrio();
    }
    
    public NodoAVL rotacionIzquierda(NodoAVL c){
        NodoAVL aux = c.getIzq();
        c.setIzq(aux.getDer());
        aux.setDer(c);
        c.setFactorEquilibrio(Math.max(obtenerAltura(c.getIzq()), obtenerAltura(c.getDer())) + 1);
        aux.setFactorEquilibrio(Math.max(obtenerAltura(aux.getIzq()), obtenerAltura(aux.getDer())) + 1);
        return aux;
    }
    
    public NodoAVL rotacionDerecha(NodoAVL c){
        NodoAVL aux = c.getDer();
        c.setDer(aux.getIzq());
        aux.setIzq(c);
        c.setFactorEquilibrio(Math.max(obtenerAltura(c.getIzq()), obtenerAltura(c.getDer())) + 1);
        aux.setFactorEquilibrio(Math.max(obtenerAltura(aux.getIzq()), obtenerAltura(aux.getDer())) + 1);
        return aux;
    }   
    
    public NodoAVL rotacionDobleIzquierda(NodoAVL c) {
        NodoAVL aux;
        c.setIzq(rotacionDerecha(c.getIzq()));
        aux = rotacionIzquierda(c);
        return aux;
    }
    
    public NodoAVL rotacionDobleDerecha(NodoAVL c) {
        NodoAVL aux;
        c.setDer(rotacionIzquierda(c.getDer()));
        aux = rotacionDerecha(c);
        return aux;
    }
    
   public NodoAVL insertarAVL(NodoAVL nuevo, NodoAVL subAr) throws NodoDuplicado{
        NodoAVL nuevoPadre = subAr;
        if(nuevo.getClave().compareTo(subAr.getClave()) < 0) {
            if (subAr.getIzq() == null) {
                subAr.setIzq(nuevo);
            } else {
                subAr.setIzq(insertarAVL(nuevo,subAr.getIzq() ));
                if(obtenerAltura(subAr.getIzq()) - obtenerAltura(subAr.getDer()) == 2) {
                    if(nuevo.getClave().compareTo(subAr.getIzq().getClave()) < 0) {
                        
                        nuevoPadre = rotacionIzquierda(subAr);
                    } else {
                        nuevoPadre = rotacionDerecha(subAr);
                    }
                }
            }
        } else if (nuevo.getClave().compareTo(subAr.getClave()) > 0) {
            if(subAr.getDer() == null) {
                subAr.setDer(nuevo);
            } else {
                subAr.setDer(insertarAVL(nuevo,subAr.getDer()));
                if (obtenerAltura(subAr.getDer()) - obtenerAltura(subAr.getIzq()) == 2) {
                    if (nuevo.getClave().compareTo(subAr.getDer().getClave()) > 0) {
                        nuevoPadre = rotacionDerecha(subAr);
                    } else {
                        nuevoPadre = rotacionIzquierda(subAr);   
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null,"Nodo duplicado");
            throw new NodoDuplicado();
        }
        if(subAr.getIzq() == null && subAr.getDer() != null) {
            subAr.setFactorEquilibrio(subAr.getDer().getFactorEquilibrio() + 1);
        } else if (subAr.getDer() == null && subAr.getIzq() != null) {
            subAr.setFactorEquilibrio(subAr.getIzq().getFactorEquilibrio() + 1);
        } else {
            subAr.setFactorEquilibrio(Math.max(obtenerAltura(subAr.getIzq()), obtenerAltura(subAr.getDer())) + 1);
        }
        return nuevoPadre;
    }
    
   public void insertar(String id,Object info) throws NodoDuplicado{
        JOptionPane.showMessageDialog(null,((Usuario)info).getImString());
        NodoAVL nuevo = new NodoAVL(id,info);
        if(raiz == null) {
            raiz = nuevo;
        } else {
            raiz = insertarAVL(nuevo,raiz);
        }
        size++;
    }
    
    private void inOrden(NodoAVL nodo)
    {
        if( null == nodo ) return;
        inOrden( nodo.getIzq() );
        System.out.println( "{ Llave: " + nodo.getClave() + " }\n" );
        inOrden( nodo.getDer() );
    }
    
    private void preOrden(NodoAVL nodo)
    {
        if( null == nodo ) return;
        System.out.println( "{ Llave: " + nodo.getClave() + " }\n" );
        preOrden( nodo.getIzq() );
        preOrden( nodo.getDer() );
    }
    
    private void postOrden(NodoAVL nodo)
    {
        if( null == nodo ) return;
        postOrden( nodo.getIzq() );
        postOrden( nodo.getDer() );
        System.out.println( "{ Llave: " + nodo.getClave() + " }\n" );
    }
    
    public void inOrden()
    {
        inOrden(this.raiz);
    }
    
    public void preOrden(){
        preOrden(this.raiz);
    }
    
    public void postOrden(){
        postOrden(this.raiz);
    }    
}
