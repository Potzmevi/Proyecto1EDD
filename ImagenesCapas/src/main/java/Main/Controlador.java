 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Estructuras.ArbolAVL;
import Estructuras.Cola;
import Estructuras.ListaDoble;
import Estructuras.MatrizDispersa;
import Objetos.Capa;
import Objetos.Imagen;
import Objetos.Usuario;
import Nodos.NodoAVL;
import Nodos.NodoAb;
import Nodos.NodoLista;
import Nodos.NodoMatriz;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Main.NodoDuplicado;

/**
 *
 * @author meza4
 */
public class Controlador {
    
   
    private static ArbolAVL usuarios = new ArbolAVL();
    private static ListaDoble imagenes = new ListaDoble();
    
    
    public static void insertarUsuario(String id) throws Exception{
        usuarios.insertar(id,null);
    }
    
    
    
   
    
   public static void insertarUsuario(String id,List<Integer> a) throws NodoDuplicado {
        Usuario usuario;
        ListaDoble lista = new ListaDoble();
        if(!a.isEmpty()) {
            NodoLista nodo;
            for (Integer i : a) {
                nodo = imagenes.buscar(i+"");
                if(nodo != null) {
                    lista.insertar(nodo); }
                
            }
            usuario = new Usuario(id,lista);
        } else {
            usuario = new Usuario(id);
        }
        usuarios.insertar(id,usuario);
    }
    
    public static int getUsersSize(){
        return usuarios.size;
    }

    public static void graficarUsuarios(){
        String salida = "diagraph {\n";
    }
    
    public static void graficarCapas(){
        String salida = "diagraph g {\n";
        
    }
    
    public static void modificarUsuario(String id,String newId,String as){
        Usuario usuario = buscarUsuario(id);
        ListaDoble nuevalista = new ListaDoble();
        if(usuario != null) {
            String[] a = as.split(",");
            for (String i : a) {
                NodoLista nodo = imagenes.buscar(i);
                if(nodo != null)
                    nuevalista.insertar(nodo);
            }
            usuario.setListaImagenes(nuevalista);
            usuario.setId(newId);
        }
    }
    
    public static Usuario buscarUsuario(String id) {
        NodoAVL userNode = usuarios.buscar(id);
        if(userNode!= null) 
            return (Usuario)userNode.getInfo();
        return null;
    }
    
    public static void crearUsuario(String id,String as) {
        List<Integer> a = new ArrayList<>();
        String[] p = as.split(",");
        for (String string : p) {
            a.add(Integer.parseInt(string));
        }
        try{
            insertarUsuario(id,a);
            JOptionPane.showMessageDialog(null, "Usuario "+id+" insertado cantidad de usuarios:"+String.valueOf(getUsersSize()));
        } catch(NodoDuplicado ex) {
            JOptionPane.showMessageDialog(null, "Usuario duplicado");
        }   
    }   
}
