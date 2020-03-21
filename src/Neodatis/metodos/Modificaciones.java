/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Neodatis.metodos;

import Mongo.metodos.*;
import com.mongodb.client.MongoDatabase;
import java.io.BufferedReader;
import java.io.IOException;
import org.bson.Document;

/**
 *
 * @author Usuario
 */
public class Modificaciones {

    public static void modifCV(MongoDatabase db,BufferedReader lee, String dni) {//Modificar cv
        //Session sesion = NewHibernateUtil.getSession();
        int op = 0;
        try {
            //Curriculum curr = (Curriculum) sesion.get(Curriculum.class, cv);
            do {
                System.out.println("MENU Modificacion"
                        + "\n1. Experiencia"
                        + "\n2. Permiso de coche"
                        + "\n3. Añadir Formacion"
                        + "\n0. Salir");
                op = Integer.parseInt(lee.readLine());
                switch (op) {
                    case 1://Experiencia
                        
                        System.out.println("Introduzca Experiencia");
                        String experiencia = lee.readLine();
                        db.getCollection("curriculums").updateOne(new Document("usuario", dni),
                        new Document("$set", new Document("experiencia",experiencia)));
                        System.out.println("Se ha modificado la experiencia");
                        

                        break;
                    case 2://Permiso
                        System.out.println("Tiene permiso de coche? (s/n)");
                        String coche = lee.readLine();
                        String permiso;
                        if (coche.equalsIgnoreCase("s")){
                            permiso ="Sí";
                        
                        }else{
                            permiso = "No";
                        }
                        
                        db.getCollection("curriculums").updateOne(new Document("usuario", dni),
                        new Document("$set", new Document("premiso_coche",permiso)));
                        System.out.println("Se ha modificado el permiso de coche");
                        
                        break;
                    case 3://Formacion
                    
                    //formacion = (Formacion) sesion.get(Formacion.class, codigo);
                    case 4:
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Error , los valores deben estar comprendidos entre 0 y 4");
                }
            } while (op != 0);

        } catch (IOException e) {
            System.out.println("Error modificar cv");
            System.out.println("Error : " + e.getMessage());
        }
    }

}
