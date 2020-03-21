/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import com.mongodb.client.MongoDatabase;
import comprobaciones.*;
import java.io.*;
import Mongo.metodos.*;
import validaciones.Validar;

/**
 *
 * @author a16raulic
 */
public class MenuMongo {
    
    
    

    public static int menuPrincipal(MongoDatabase db, BufferedReader lee) throws IOException {

        int opc;

        System.out.println("JUST JOBS"
                + "\n1. Iniciar sesión"
                + "\n2. Registrarse"
                + "\n0. Salir");
        opc = Integer.parseInt(lee.readLine());

        return opc;
    }

    public static int menuRegister(BufferedReader lee) throws IOException {

        int opc;

        System.out.println("Desea registrarse como empresario o como candidato?"
                + "\n1. Empresario"
                + "\n2. Candidato"
                + "\n0. Salir");
        opc = Integer.parseInt(lee.readLine());

        return opc;

    }

    public static int menuLogin(MongoDatabase db, BufferedReader lee) throws IOException {

        int d = 0;
        String dni;
        int opc;

        System.out.println("LOG IN"
                + "\nIntroduzca su DNI");

        try {
            do {
                dni = lee.readLine();
                if (dni.equals("555")) {
                    opcionMenuAdmin(db, lee);

                } else {
                    d = Validar.validarDNI(dni);
                }
            } while (d == 1);

            if (!dni.equals("555")){
                
            
            
            Object o = null;
            String usuario = Comprobar.compDni(db, dni);
            

            if (usuario.equalsIgnoreCase("empresario")) {

                opcionMenuEmpresario(db, lee,dni);

            } else if (usuario.equalsIgnoreCase("candidato")) {

                opcionMenuCandidato(db,lee, dni);
            } else {
                System.out.println("El usuario no existe");
            }
            }
        } catch (NullPointerException e) {
            System.out.println("El usuario no existe");

        } finally {
            return d;
        }
    }

    public static int menuCandidato(BufferedReader lee) throws IOException {

        int opc;

        System.out.println("MENU CANDIDATO"
                + "\n1. Ver anuncios"
                + "\n2. Editar curriculum"
                + "\n3. Darse de baja"
                + "\n0. Salir");
        opc = Integer.parseInt(lee.readLine());

        return opc;
    }

    public static int menuEmpresario(BufferedReader lee) throws IOException {

        int opc;

        System.out.println("MENU EMPRESARIO"
                + "\n1. Crear anuncio"
                + "\n2. Eliminar anuncio"
                + "\n3. Visualizar tus anuncios"
                + "\n4. Ver solicitudes"
                + "\n0. Salir");
        opc = Integer.parseInt(lee.readLine());

        return opc;

    }

    public static int menuAdmin(BufferedReader lee) throws IOException {

        int opc;

        System.out.println("MENU ADMINISTRADOR"
                + "\n1. Altas"
                + "\n2. Bajas"
                + "\n3. Modificaciones"
                + "\n4. Visualizaciones"
                + "\n0. Salir");
        opc = Integer.parseInt(lee.readLine());

        return opc;

    }

    public static int menuAltas(BufferedReader lee) throws IOException {

        int opc;

        System.out.println("MENU ALTAS"
                + "\n1. Formacion"
                + "\n0. Salir");
        opc = Integer.parseInt(lee.readLine());

        return opc;
    }

    public static int menuBajas(BufferedReader lee) throws IOException {

        int opc;

        System.out.println("MENU BAJAS"
                + "\n1. Candidato"
                + "\n2. Empresario"
                + "\n3. Formacion"
                + "\n0. Salir");
        opc = Integer.parseInt(lee.readLine());

        return opc;
    }

    public static int menuMod(BufferedReader lee) throws IOException {

        int opc;

        System.out.println("MENU MODIFICACIONES"
                + "\n1. Curriculum"
                + "\n0. Salir");
        opc = Integer.parseInt(lee.readLine());

        return opc;
    }

    public static int menuVisualizar(BufferedReader lee) throws IOException {

        int opc;

        System.out.println("MENU VISUALIZACIONES"
                + "\n1. Usuario"
                + "\n2. Formacion"
                + "\n0. Salir");
        opc = Integer.parseInt(lee.readLine());

        return opc;
    }

    public static int filtroAnuncio(BufferedReader lee) throws IOException {

        int opc;
        System.out.println("FILTRAR"
                + "\n1. Filtrar por Formacion"
                + "\n2. Filtrar por Localidad"
                + "\n3. Todos"
                + "\n0. Salir");
        opc = Integer.parseInt(lee.readLine());

        return opc;

    }

    public static void opcionMenuAdmin(MongoDatabase db, BufferedReader lee) throws IOException {
        int opc = 999;
        int opc2 = 999;
        do {
            try {

                            opc = menuAdmin(lee);
                        } catch (java.lang.NumberFormatException error) {
                            System.out.println("La opcion debe ser un numero");
                            opc = 999;
                        }
                            
            switch (opc) {
                case 1:
                    do {

                        try {

                            opc2 = menuAltas(lee);
                        } catch (java.lang.NumberFormatException error2) {
                            System.out.println("La opcion debe ser un numero");
                            opc2 = 999;

                        }
                        switch (opc2) {

                            case 1:
                                Inserciones.altasFormaciones(db, lee);
                                break;

                            case 999:
                                break;
                                
                            case 0:
                                break;

                            

                            
                        }
                    } while (opc2 != 0);
                    break;

                 case 2:
                    do{
                        try {

                            opc2 = menuBajas(lee);
                        } catch (java.lang.NumberFormatException error2) {
                            System.out.println("La opcion debe ser un numero");
                            opc2 = 999;

                        }
                        switch(opc2){
                            
                            case 1: 
                                Bajas.bajaCandidato(lee,db);
                                break;
                                
                            case 2:
                                Bajas.bajaEmpresario(lee,db);
                                break;    
                                
                            case 3:
                                Bajas.bajaFormacion(lee,db);
                                break;
                                
                            case 4:
                             
                                break;
                                
                            case 999:    
                                break;
                                
                            case 0:
                                break;
                                
                            case -1: 
                                System.out.println("Error, el valor introducido debe ser un número entre 0 y 4");    
                                break;
                                
                            default: 
                                System.out.println("Error, el valor introducido debe ser un número entre 0 y 4");
                                break;
                        }
                        
                    }while (opc2!=0);   
                break;
                
                case 3: 
                    do{
                        try {

                            opc2 = menuMod(lee);
                        } catch (java.lang.NumberFormatException error2) {
                            System.out.println("La opcion debe ser un numero");
                            opc2 = 999;

                        }
                        switch(opc2){
                            
                            case 1: 
                               // Modificaciones.modifCV(lee, c);
                                break;
                                
                            case 999:
                                break;
                                
                            case 0:
                                break;
                                
                            case -1: 
                                System.out.println("Error, el valor introducido debe ser un número entre 0 y 1");    
                                break;
                                
                            default: 
                                System.out.println("Error, el valor introducido debe ser un número entre 0 y 4");
                                break;
                        }
                        
                    }while (opc2!=0);  
                break;
                
                case 4:
                    do{
                        try {

                            opc2 = menuVisualizar(lee);
                        } catch (java.lang.NumberFormatException error3) {
                            System.out.println("La opcion debe ser un numero");
                            opc2 = 999;

                        }
                        switch(opc2){
                            
                            case 1: 
                                System.out.println("Introduzca el tipo de usuarios a visualizar"
                                        + "\n1. Empresarios"
                                        + "\n2. Candidatos");
                                int opcV=Integer.parseInt(lee.readLine());
                                
                        switch (opcV) {
                            case 1:
                                Visualizar.visualizarEmpresario(db);
                                break;
                            case 2:
                                Visualizar.visualizarCandidato(db);
                                break;
                                
                            case 0:
                                break;
                                
                            case -1:
                                System.out.println("Error, el valor introducido debe ser un número entre 0 y 2");
                                break;
                            default:
                                System.out.println("Error, el valor introducido debe ser un número entre 0 y 2");
                                break;
                        }
                            break;
                                
                            case 2:Visualizar.visualizarFormacion(db);
                                break;
                                
                                
                            case 999:
                                break;
                                
                            case 0:
                                break;
                                
                            case -1: 
                                System.out.println("Error, el valor introducido debe ser un número entre 0 y 3");    
                                break;
                                
                            default: 
                                System.out.println("Error, el valor introducido debe ser un número entre 0 y 3");
                                break;
                        }
                        
                    }while (opc2!=0);
                break;
                 
                case 0:
                    break;

                case 999:
                    break;

                case -1:
                    System.out.println("Error, el valor introducido debe ser un número entre 0 y 4");
                    break;

                default:
                    System.out.println("Error, el valor introducido debe ser un número entre 0 y 4");
                    break;
            }
        } while (opc != 0);
        
    }

    public static void opcionMenuEmpresario(MongoDatabase db, BufferedReader lee,String dni) throws IOException {
        int opcE = 999;
        do {
            try {

                opcE = menuEmpresario(lee);
            } catch (java.lang.NumberFormatException error) {
                System.out.println("La opcion debe ser un numero");
                opcE = 999;
            }

            switch (opcE) {
                case 1:
                    Inserciones.altaAnuncio(db, lee,dni);
                    break;

                case 2:
                    Bajas.bajaAnuncio(lee);
                   // Bajas.bajaAnuncio(lee, e);

                    break;

                case 3:
                    Visualizar.visualizarAnuncioEmpresario(dni,db);
                    break;

                case 4:
                    Visualizar.visualizarSolicitudes(lee, db, dni);
                  //  Visualizar.visualizarSolicitudes(e, lee);
                    break;

                case 999:
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Error , los valores deben estar comprendidos entre 0 y 2"
                            + "");
            }

        } while (opcE != 0);
    }

    public static void opcionMenuCandidato(MongoDatabase db,BufferedReader lee, String dni) throws IOException {

        int opcC = 999;
        do {
            try {

                opcC = menuCandidato(lee);
            } catch (java.lang.NumberFormatException error) {
                System.out.println("La opcion debe ser un numero");
                opcC = 999;
            }
            switch (opcC) {
                case 1:
                    opcC = filtroAnuncio(lee);
                        switch(opcC){
                            case 1://Formacion
                                Visualizar.visualizarAnuncioFormacion(lee, db, dni);
                                break;
                            case 2://Localidad
                                Visualizar.visualizarAnuncioLocalidad(lee, db,dni);
                                break;
                            case 3://Todos;
                                Visualizar.visualizarAnuncio(lee, db,dni);
                                break;
                            default:
                                System.out.println("Error , los valores deben estar comprendidos entre 0 y 3");
                        
                        }
                    
                    break;

                case 2:
                    Modificaciones.modifCV(db,lee, dni);
                    break;

                case 3:
                   // Bajas.bajaCandidato(lee, dni);
                    break;

                case 999:
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Error , los valores deben estar comprendidos entre 0 y 3"
                            + "");
            }

        } while (opcC != 0);

    }

}

    
    

