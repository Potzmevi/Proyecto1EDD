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
public class NodoAVL {
    private String clave;
    private NodoAVL izq;
    private NodoAVL der;
    private Object info;
    private int fe;

    
    public NodoAVL(String clave,Object info){
        this.clave = clave;
        this.info = info;
        this.izq = null;
        this.der = null;
    }
    
    public Object getInfo(){
        return info;
    }

    public void setInfo(Object info){
        this.info = info;
    }
 
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public NodoAVL getIzq() {
        return izq;
    }

    public void setIzq(NodoAVL izq) {
        this.izq = izq;
    }

    public NodoAVL getDer() {
        return der;
    }

    public void setDer(NodoAVL der) {
        this.der = der;
    }

    public int getFactorEquilibrio(){
        return fe;
    }

    public void setFactorEquilibrio(int altura) {
        this.fe = altura;
    }
    
}
