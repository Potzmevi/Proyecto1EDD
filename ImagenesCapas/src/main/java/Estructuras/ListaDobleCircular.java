/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Nodos.NodoListaDoble;
import Objetos.Imagen;
import javax.swing.JOptionPane;

/**
 *
 * @author meza4
 */
public class ListaDobleCircular {
    private NodoListaDoble inicio;
    private NodoListaDoble fin;
    public int size;
    
    public ListaDobleCircular() {
        inicio = null;
        fin = null;
    }

    public void insertarNodo(NodoListaDoble nuevoNodo) {
        if (inicio == null)
        {
            inicio = nuevoNodo;
            fin = nuevoNodo;
            inicio.setSiguiente(inicio);
            inicio.setAnterior(fin);
            size++;
            ordenarLista();
        }else if (nodoNoExiste(nuevoNodo.getId())) {
            fin.setSiguiente(nuevoNodo);
            nuevoNodo.setSiguiente(inicio);
            nuevoNodo.setAnterior(fin);
            fin = nuevoNodo;
            inicio.setAnterior(fin);
            size++;
            ordenarLista();
        } else{
            System.out.println("El nodo ya existe: "+nuevoNodo.getId());
        }
        
    }
    
    public boolean nodoNoExiste(String id){
        NodoListaDoble aux = inicio;
        do
        {            
            if(aux.getId().equals(id)){
                return false;
            }
            aux = aux.getSiguiente();
            
        } while (aux!=inicio);
        
        return true;
    }
    
    public void mostrarDatos(){
        NodoListaDoble aux = inicio;
        System.out.println("Lista Circular Doblemente Enlazada");
        do{
            System.out.print("Nodo: "+aux.getId());
            if(aux.getSiguiente()!=null){
                System.out.print(" Siguiente: "+aux.getSiguiente().getId());
            }
            if(aux.getAnterior()!=null){
                System.out.print(" Anterior: "+aux.getAnterior().getId());
            }
            System.out.println("\n\n**********************************************");
            aux = aux.getSiguiente();
        }while(aux!=inicio);
        
        
    }
    
    public NodoListaDoble buscarNodo(String id){
        if(inicio!=null){
            NodoListaDoble aux = inicio;
            do{
                if(aux.getId().equals(id)){
                    return aux;
                }else{
                    aux = aux.getSiguiente();
                }
            }while(aux!=inicio);
        }
        
        return null;
    }
    
    
    
    public void eliminarNodo(String id){
        if(inicio != null){
            NodoListaDoble nodo = buscarNodo(id);
            NodoListaDoble nodoAnterior = nodo.getAnterior();
            NodoListaDoble nodoSiguiente = nodo.getSiguiente();
            nodoAnterior.setSiguiente(nodoSiguiente);
            nodoSiguiente.setAnterior(nodoAnterior);
            size--;
        }
    }
    
    public NodoListaDoble buscar(String id) {
        if (inicio != null) {
            NodoListaDoble aux = inicio;
            do {
                if (((Imagen)aux.getContenido()).getId().equals(id)) {
                    return aux;
                } else {
                    aux = aux.getSiguiente();
                }
            } while (aux != inicio);
        }
        return null;
    }
    
    public void ordenarLista() {
        if (size > 1)
        {
            for(int i = 0; i < size;i++){
                NodoListaDoble actual = inicio;
                NodoListaDoble siguiente = actual.getSiguiente();
                for(int j=1; j<size; j++){
                    if(actual.getId().compareTo(siguiente.getId()) > 0){
                        String id_1 = actual.getId();
                        Object imagen_1 = actual.getContenido();

                        actual.setId(siguiente.getId());
                        actual.setContenido(siguiente.getContenido());
                        siguiente.setId(id_1);
                        siguiente.setContenido(imagen_1);
                        actual = actual.getSiguiente();
                        siguiente = siguiente.getSiguiente();
                    }else{
                        actual = actual.getSiguiente();
                        siguiente = siguiente.getSiguiente();
                    }
                }
            }
        }
    }
}
