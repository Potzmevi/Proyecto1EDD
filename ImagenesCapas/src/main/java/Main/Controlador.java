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
import Estructuras.ColaImagenes;
import Estructuras.ListaDoble;
import Estructuras.ListaDobleCircular;
import Estructuras.MatrizDispersa;
import Objetos.Usuario;
import Nodos.NodoAVL;
import Nodos.NodoAb;
import Nodos.NodoCola;
import Nodos.NodoListaDoble;
import Nodos.NodoMatriz;
import Objetos.Capa;
import Objetos.Imagen;
import java.io.File;
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
        ColaImagenes cola = new ColaImagenes();
        if (!a.isEmpty()) {
            NodoListaDoble nodo;
            for (Integer i : a) {
                nodo = listaimagenes.buscar(i + "");
                Imagen ima=(Imagen) nodo.getContenido();
                if (nodo != null) {
                    cola.insertar(ima);
                    
                }
            }
            usuario = new Usuario(id, cola);
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

    public static void graficarListaImagenes() throws IOException {
        String salida = "digraph G{   \n";
        salida += "subgraph Lista { node [shape = square,height=.1]; label=\"Lista doble circular\"; \n";
        NodoListaDoble aux = listaimagenes.getInicio();
        for (int i = 0; i < listaimagenes.size; i++) {

            salida += aux.getId() + "->" + aux.getSiguiente().getId() + " [constraint=false]; \n";
            salida += aux.getSiguiente().getId() + "->" + aux.getSiguiente().getAnterior().getId() + "[constraint=false]; \n";
            aux = aux.getSiguiente();
        }
        salida = salida + "}";
        NodoListaDoble aux2 = listaimagenes.getInicio();
        for (int i = 0; i < listaimagenes.size; i++) {
            Imagen ima = (Imagen) aux2.getContenido();
            Cola cola = ima.getCapas();
            salida += "subgraph cluster_" + i + "{node [shape = square,height=.1]; rankdir=LR; label=\"Cola" + i + "\";  \n";
            NodoListaDoble nodoCola = cola.getInicio();
            for (int j = 0; j < cola.size(); j++) {
                salida += "Cola" + i + "_" + "Capa" + nodoCola.getId();
                if (nodoCola.getSiguiente() != null) {
                    salida += "->" + "Cola" + i + "_" + "Capa" + nodoCola.getSiguiente().getId() + "; \n";
                    nodoCola = nodoCola.getSiguiente();
                }
                if (j + 2 == cola.size()) {
                    break;
                }
            }
            salida += " } \n";
            nodoCola = cola.getInicio();
            salida += aux2.getId() + "->" + "Cola" + i + "_" + "Capa" + nodoCola.getId() + "[lhead = cluster_" + i + "]; \n";
            aux2 = aux2.getSiguiente();
        }
        salida = salida + "}";

        File imagenSalida = new File("./ListaImagenes.dot");
        if (!imagenSalida.exists()) {
            imagenSalida.createNewFile();
        } else {
            imagenSalida.delete();
            imagenSalida.createNewFile();
        }
        Main.saveFile(salida, imagenSalida.getAbsolutePath());
        String command = "dot -Tpng ListaImagenes.dot -o ListaImagenes.png";
        Runtime.getRuntime().exec(command);
    }

    public static void graficarCapas() throws IOException {
        String capastexto = null;
        capastexto = capas.obtenerGrafica();
        String salida = "digraph G {\n";
        salida += "subgraph cluster_0 {\n";
        salida += capastexto;
        salida += "label = \" Arbol de Capas \";\n";
        salida += "}\n";
        salida += "}\n";

        File imagenSalida = new File("./Capas.dot");
        if (!imagenSalida.exists()) {
            imagenSalida.createNewFile();
        } else {
            imagenSalida.delete();
            imagenSalida.createNewFile();
        }
        Main.saveFile(salida, imagenSalida.getAbsolutePath());
        String command = "dot -Tpng Capas.dot -o ArbolCapas.png";
        Runtime.getRuntime().exec(command);
    }

    public static void modificarUsuario(String id, String newId, String lista) {
        NodoAVL userNode = usuarios.buscar(id);
        NodoAVL userNew = usuarios.buscar(newId);
        Usuario usuario = buscarUsuario(id);
        ColaImagenes nuevalista = new ColaImagenes();
        
        if (userNew == null) {
            String[] a = lista.split(",");
            for (String i : a) {
                NodoListaDoble nodo = listaimagenes.buscar(i);
                Imagen ima = (Imagen)nodo.getContenido();
                System.out.println("si");
                if (nodo != null) {
                    nuevalista.insertar(ima);
                }
            }
            usuario.setId(newId);
            usuario.setListaImagenes(nuevalista);
            userNode.setInfo(usuario);
            userNode.setClave(newId);
            System.out.println("si");
            JOptionPane.showMessageDialog(null, "Usuario modificado");
        } else {
            JOptionPane.showMessageDialog(null, "Usuario con ese ID ya existe");
        }
    }

    public static void graficarImagenArbolCapas(String id) throws IOException {
        String capastexto = null;
        capastexto = capas.obtenerGrafica();
        NodoListaDoble nodo = listaimagenes.buscar(id);
        if (nodo != null) {
            Imagen ima = (Imagen) nodo.getContenido();
            Cola cola = ima.getCapas();
            String salida = "digraph G {\n";
            salida += "subgraph cluster_1 {\n";
            salida += capastexto;
            salida += "label = \" Arbol de Capas \";\n";
            salida += "}\n";
            salida += "subgraph cluster_0 {\n";
            NodoListaDoble nodoCola = cola.getInicio();
            for (int j = 0; j < cola.size(); j++) {
                salida += "Capa" + nodoCola.getId();
                if (nodoCola.getSiguiente() != null) {
                    salida += "->" + "Capa" + nodoCola.getSiguiente().getId() + "; \n";
                    if (capas.buscar(Integer.parseInt(nodoCola.getId())) != null) {
                        salida += "Capa" + nodoCola.getId() + "->" + nodoCola.getId() + "[lhead = cluster_1]; \n";
                    }
                    if (capas.buscar(Integer.parseInt(nodoCola.getSiguiente().getId())) != null && j + 2 == cola.size()) {
                        salida += "Capa" + nodoCola.getSiguiente().getId() + "->" + nodoCola.getSiguiente().getId() + "[lhead = cluster_1]; \n";
                    }
                    nodoCola = nodoCola.getSiguiente();
                }
                if (j + 2 == cola.size()) {
                    break;
                }

            }
            salida += "label = \" Capas Imagen \";\n";
            salida += "}\n";
            nodoCola = cola.getInicio();
            salida += "Imagen" + nodo.getId() + "->" + "Capa" + nodoCola.getId() + "[lhead = cluster_0]; \n";
            salida += "}\n";

            File imagenSalida = new File("./ImagenArbolCapas.dot");
            if (!imagenSalida.exists()) {
                imagenSalida.createNewFile();
            } else {
                imagenSalida.delete();
                imagenSalida.createNewFile();
            }
            Main.saveFile(salida, imagenSalida.getAbsolutePath());
            String command = "dot -Tpng ImagenArbolCapas.dot -o ImagenArbolCapasCola.png";
            Runtime.getRuntime().exec(command);
        } else {
            JOptionPane.showMessageDialog(null, "La imagen no existe");
        }

    }

    public static void graficarUsuarios() throws IOException {
        String capastexto = null;
        capastexto = usuarios.obtenerGrafica();
        String salida = "digraph G {\n";
        salida += "subgraph cluster_0 {\n";
        salida += capastexto;
        salida += "label = \" Arbol de Usuarios \";\n";
        salida += "}\n";
        salida += "}\n";

        File imagenSalida = new File("./Usuarios.dot");
        if (!imagenSalida.exists()) {
            imagenSalida.createNewFile();
        } else {
            imagenSalida.delete();
            imagenSalida.createNewFile();
        }
        Main.saveFile(salida, imagenSalida.getAbsolutePath());
        String command = "dot -Tpng Usuarios.dot -o ArbolUsuarios.png";
        Runtime.getRuntime().exec(command);
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
