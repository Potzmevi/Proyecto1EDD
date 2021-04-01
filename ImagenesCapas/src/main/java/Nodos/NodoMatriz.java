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
public class NodoMatriz {
    int x;
    int y;
    String hexaColor;
    NodoMatriz antColumna,antFila,sigColumna,sigFila;
    
    public NodoMatriz(int x, int y, String hexaColor) {
        this.x = x;
        this.y = y;
        this.hexaColor = hexaColor;
        antColumna = antFila = sigColumna = sigFila = null;
    }

    public NodoMatriz getSigColumna() {
        return sigColumna;
    }

    public NodoMatriz getSigFila() {
        return sigFila;
    }

    public void setSigColumna(NodoMatriz sigColumna) {
        this.sigColumna = sigColumna;
    }

    public void setSigFila(NodoMatriz sigFila) {
        this.sigFila = sigFila;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getHexaColor() {
        return hexaColor;
    }

    public void setHexaColor(String hexaColor) {
        this.hexaColor = hexaColor;
    }

    public NodoMatriz getAntColumna() {
        return antColumna;
    }

    public void setAntColumna(NodoMatriz antColumna) {
        this.antColumna = antColumna;
    }

    public NodoMatriz getAntFila() {
        return antFila;
    }

    public void setAntFila(NodoMatriz antFila) {
        this.antFila = antFila;
    }
    
}
