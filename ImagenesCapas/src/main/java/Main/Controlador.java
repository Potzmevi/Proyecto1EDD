 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Estructuras.ArbolAVL;
import Estructuras.ListaDoble;
import Objetos.Usuario;
import Nodos.NodoAVL;
import Nodos.NodoLista;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author meza4
 */
public class Controlador {
    
   
    public static ArbolAVL usuarios = new ArbolAVL();
    public static ListaDoble imagenes = new ListaDoble();
    
    
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
    
    public static void modificarUsuario(String id,String newId,String lista){
        NodoAVL userNode = usuarios.buscar(id);
        NodoAVL userNew = usuarios.buscar(newId);
        Usuario usuario = buscarUsuario(id);
        ListaDoble nuevalista = new ListaDoble();
        if(userNew == null) {
            String[] a = lista.split(",");
            for (String i : a) {
                NodoLista nodo = imagenes.buscar(i);
                if(nodo != null)
                    nuevalista.insertar(nodo);
            }
            usuario.setId(newId);
            usuario.setListaImagenes(nuevalista);
            userNode.setInfo(usuario);
            userNode.setClave(newId);
            JOptionPane.showMessageDialog(null, "Usuario modificado");
        }else{
            JOptionPane.showMessageDialog(null, "Usuario con ese ID ya existe");
        }
    }
    
    public static Usuario buscarUsuario(String id) {
        NodoAVL userNode = usuarios.buscar(id);
        if(userNode!= null) 
            return (Usuario)userNode.getInfo();
        return null;
    }
    
     public static void eliminarNodo(String id){
        NodoAVL user = usuarios.buscar(id);
        usuarios.eliminar(user);
        JOptionPane.showMessageDialog(null, "Usuario "+id+" Eliminado");
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
