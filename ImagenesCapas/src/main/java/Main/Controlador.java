/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Archivos.parserCapas;
import Estructuras.ArbolAVL;
import Estructuras.ArbolBB;
import Estructuras.Cola;
import Estructuras.ListaDoble;
import Estructuras.ListaDobleCircular;
import Estructuras.MatrizDispersa;
import Objetos.Usuario;
import Nodos.NodoAVL;
import Nodos.NodoAb;
import Nodos.NodoListaDoble;
import Nodos.NodoMatriz;
import Objetos.Capa;
import Objetos.Imagen;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author meza4
 */
public class Controlador {

    public static ArbolBB capas = new ArbolBB();
    public static ArbolAVL usuarios = new ArbolAVL();
    public static ListaDoble imagenes = new ListaDoble();
    public static ListaDobleCircular listaimagenes = new ListaDobleCircular();

    public static void insertarCapa(int id, MatrizDispersa capa) {
        capas.insertar(id, new Capa(id, capa));
        //capa.graficarMatriz();
    }

    public static void insertarCapa(MatrizDispersa matriz) {
        capas.insertar(capas.totalNodos() + 1, matriz);
    }

    public static void insertarUsuario(String id) throws Exception {
        usuarios.insertar(id, null);
    }

    public static void insertarImagen(String id, List<Integer> a) throws IOException {
        Imagen ima;
        Cola cola = new Cola();
        if (!a.isEmpty()) {
            NodoAb nodo;
            Capa capa;
            for (int i : a) {
                nodo = capas.buscar(i);
                if (nodo != null) {
                    capa = (Capa) nodo.dato;
                    cola.encolar(new NodoListaDoble(String.valueOf(i), capa));
                }
            }

        }
        ima = new Imagen(id, cola);
        NodoListaDoble nodo = new NodoListaDoble(id, ima);
        listaimagenes.insertarNodo(nodo);
    }

    public static void insertarUsuario(String id, List<Integer> a) throws NodoDuplicado {
        Usuario usuario;
        ListaDoble lista = new ListaDoble();
        if (!a.isEmpty()) {
            NodoListaDoble nodo;
            for (Integer i : a) {
                nodo = listaimagenes.buscar(i + "");
                if (nodo != null) {
                    lista.insertar(nodo);
                }
            }
            usuario = new Usuario(id, lista);
        } else {
            usuario = new Usuario(id);
        }
        usuarios.insertar(id, usuario);
    }

    public static MatrizDispersa buscarCapa(int a) {
        NodoAb ab = capas.buscar(a);
        if (ab != null) {
            return ((Capa) ab.dato).getMatriz();
        }
        return null;
    }

    public static int getUsersSize() {
        return usuarios.size;
    }

    public static void graficarUsuarios() {
        String salida = "diagraph {\n";
    }

    public static void graficarCapas() {
        String salida = "diagraph g {\n";

    }

    public static void modificarUsuario(String id, String newId, String lista) {
        NodoAVL userNode = usuarios.buscar(id);
        NodoAVL userNew = usuarios.buscar(newId);
        Usuario usuario = buscarUsuario(id);
        ListaDoble nuevalista = new ListaDoble();
        if (userNew == null) {
            String[] a = lista.split(",");
            for (String i : a) {
                NodoListaDoble nodo = listaimagenes.buscar(i);
                if (nodo != null) {
                    nuevalista.insertar(nodo);
                }
            }
            usuario.setId(newId);
            usuario.setListaImagenes(nuevalista);
            userNode.setInfo(usuario);
            userNode.setClave(newId);
            JOptionPane.showMessageDialog(null, "Usuario modificado");
        } else {
            JOptionPane.showMessageDialog(null, "Usuario con ese ID ya existe");
        }
    }

    public static Usuario buscarUsuario(String id) {
        NodoAVL userNode = usuarios.buscar(id);
        if (userNode != null) {
            return (Usuario) userNode.getInfo();
        }
        return null;
    }

    public static void eliminarNodo(String id) {
        NodoAVL user = usuarios.buscar(id);
        usuarios.eliminar(user);
        JOptionPane.showMessageDialog(null, "Usuario " + id + " Eliminado");
    }

    public static void crearUsuario(String id, String as) {
        List<Integer> a = new ArrayList<>();
        String[] p = as.split(",");
        for (String string : p) {
            a.add(Integer.parseInt(string));
        }
        try {
            insertarUsuario(id, a);
            JOptionPane.showMessageDialog(null, "Usuario " + id + " insertado cantidad de usuarios:" + String.valueOf(getUsersSize()));
        } catch (NodoDuplicado ex) {
            JOptionPane.showMessageDialog(null, "Usuario duplicado");
        }
    }

    public static void generarImagenInOrden(String id, String as) throws IOException {
        NodoListaDoble nodoprueba = listaimagenes.buscar(id);
        ArbolBB arbol = generarArbol(as);
        if (nodoprueba == null) {
            if (!arbol.estaVacio()) {
                Imagen ima = new Imagen(id, arbol.inOrden());
                // System.out.println(((Capa)arbol.preOrden().getFinal().getInfo()).getId());
                NodoListaDoble nodo = new NodoListaDoble(id, ima);
                listaimagenes.insertarNodo(nodo);
                ima.graficar();
                JOptionPane.showMessageDialog(null, "Imagen InOrden Creada con exito");
            } else {
                JOptionPane.showMessageDialog(null, "Las capas no existen");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Una imagen con ese id ya existe");
        }
    }

    public static void generarImagenPreOrden(String id, String as) throws IOException {
        NodoListaDoble nodoprueba = listaimagenes.buscar(id);
        ArbolBB arbol = generarArbol(as);
        if (nodoprueba == null) {
            if (!arbol.estaVacio()) {
                Imagen ima = new Imagen(id, arbol.preOrden());
                NodoListaDoble nodo = new NodoListaDoble(id, ima);
                listaimagenes.insertarNodo(nodo);
                ima.graficar();
                JOptionPane.showMessageDialog(null, "Imagen PreOrdern Creada con exito");
            } else {
                JOptionPane.showMessageDialog(null, "Las capas no existen");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Una imagen con ese id ya existe");
        }
    }

    public static void generarImagenPostOrden(String id, String as) throws IOException {
        NodoListaDoble nodoprueba = listaimagenes.buscar(id);
        ArbolBB arbol = generarArbol(as);
        if (nodoprueba == null) {
            if (!arbol.estaVacio()) {
                Imagen ima = new Imagen(id, arbol.postOrden());
                NodoListaDoble nodo = new NodoListaDoble(id, ima);
                listaimagenes.insertarNodo(nodo);
                ima.graficar();
                JOptionPane.showMessageDialog(null, "Imagen PostOrdern Creada con exito");
            } else {
                JOptionPane.showMessageDialog(null, "Las capas no existen");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Una imagen con ese id ya existe");
        }
    }

    private static ArbolBB generarArbol(String as) {
        String[] a = as.split(",");
        ArbolBB arbol = new ArbolBB();
        for (String string : a) {
            arbol.insertar(capas.buscar(Integer.parseInt(string)));
        }
        return arbol;
    }

    public static void Graficarimagen() throws IOException {

    }
}
