/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author a16borjacr
 */
public class Menu {
    public static int menuBase(BufferedReader lee) throws IOException{
     int op;

        System.out.println("Seleccione base de datos"
                + "\n1. Mongodb"
                + "\n2. Neodatis"
                + "\n0. Salir");
        op = Integer.parseInt(lee.readLine());

        return op;
    
    }
}
