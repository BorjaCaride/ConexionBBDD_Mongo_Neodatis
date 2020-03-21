/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Borja Caride, Raul Iglesias y Ismael Extremadouro
 */
public class Proyecto {

    static Connection conex;
    static Statement sentencia;
    static ResultSet res;

    public static void main(String[] args) throws SQLException, IOException, ParseException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));

        try {

            int opc, opc2, op;

            do {
                try {
                    op = Menu.menuBase(lee);
                } catch (java.lang.NumberFormatException e) {
                    System.out.println("La opcion debe ser un numero");
                    op = 999;
                }
                switch (op) {
                    case 1:
                        String host = "localhost";
                        int puerto = 27017;
                        String base = "proxecto7";

                        MongoClient cliente = new MongoClient(host, puerto);
                        MongoDatabase db = cliente.getDatabase(base);

                        do {
                            try {
                                opc = MenuMongo.menuPrincipal(db, lee);
                            } catch (java.lang.NumberFormatException o) {
                                System.out.println("La opcion debe ser un numero");
                                opc = 999;

                            }
                            switch (opc) {

                                case 1:
                                    MenuMongo.menuLogin(db, lee);

                                    break;

                                case 2:
                                    Mongo.metodos.Inserciones.altaUsuario(db, lee);
                                    break;

                                case 0:
                                    //Cerrar sesion
                                    break;

                                case 999:
                                    break;

                                default:
                                    System.out.println("Error, debe introducir un numero entre 0 y 2");
                                    break;

                            }

                        } while (opc != 0);

                        break;
                    case 2:
                        
                       do{
                           
                            try {
                                opc2 = MenuNeo.menuPrincipal(lee);
                            } catch (java.lang.NumberFormatException o) {
                                System.out.println("La opcion debe ser un numero");
                                opc2 = 999;

                            }
                            switch (opc2) {

                                case 1:
                                    MenuNeo.menuLogin(lee);

                                    break;

                                case 2:
                                    Neodatis.metodos.Inserciones.altaUsuarioNeo(lee);
                                   // Inserciones.altaUsuarioNeo(db, lee);
                                    break;

                                case 0:
                                    //Cerrar sesion
                                    break;

                                case 999:
                                    break;

                                default:
                                    System.out.println("Error, debe introducir un numero entre 0 y 2");
                                    break;

                            }
                       
                       
                       
                       }while(opc2!=0);
                        
                        
                        
                        
                        break;
                    case 0:

                        System.out.println("Fin del programa");
                        break;
                    case 999:
                        break;
                    default:
                        System.out.println("Error, debe introducir un numero entre 0 y 2");
                        break;

                }

            } while (op != 0);

        } catch (IOException | ParseException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
