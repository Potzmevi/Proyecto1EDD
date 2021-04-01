/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import UI.MenuPrincipal;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author meza4
 */
public class Main {
    public static void main(String[] args) {
          MenuPrincipal menu=new MenuPrincipal();
    }
    
    public static void saveFile(String texto,String absolutePath) {
        
	FileWriter escritor = null;
	try {
            escritor = new FileWriter(absolutePath,true);
            BufferedWriter out = new BufferedWriter(escritor);
            out.write("");
            out.write(texto);
            out.close();
	} catch (IOException e) {
            System.out.println("============== error escribiendo en archivo");
	} finally {
            try {
                escritor.close();
            } catch (IOException ex) {
                System.out.println("========no se pudo cerrar archivo");
            }
        }

    }
}
