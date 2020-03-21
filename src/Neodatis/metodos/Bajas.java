/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Neodatis.metodos;

import Mongo.metodos.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import java.io.BufferedReader;
import java.io.IOException;
import org.bson.Document;

/**
 *
 * @author a16borjacr
 */
public class Bajas {

    public static void bajaEmpresario(BufferedReader lee) throws IOException {
       /* Visualizar.visualizarEmpresario(db);
        System.out.println("Inserte el dni del empresario que quiera dar de baja");
        String dni = lee.readLine();
        
         MongoCollection <Document> coleccion = db.getCollection("empresarios");
        
     
        
        
        System.out.println("Seguro que quiere borrar el empresario con dni: "+dni+" (s/n)");
        String op = lee.readLine();
        if(op.equalsIgnoreCase("s")){
            db.getCollection("empresarios").deleteOne(new Document("dni", dni));
                    //crear en insertar . altaAnuncio una linea para empresario que tenga el dni

            db.getCollection("anuncios").deleteMany(new Document("empresario", dni));
            System.out.println("Se ha eliminado el empresario");
        }else if (op.equalsIgnoreCase("n")){
            System.out.println("Se ha cancelado el borrado del usuario");
        }
//Metodo por si el administrador quiere dar de baja un empresario
       /* try {
            Visualizar.visualizarEmpresario();//Se visualizan los datos del empresario
            System.out.println("Ponga el dni del empresario que quiera borrar");
            String dni = lee.readLine();
            Session sesion = NewHibernateUtil.getSession();
            Empresario user = (Empresario) sesion.get(Empresario.class, dni);//Segun el dni,, se obtiene el objeto
            sesion.close();
            if (user != null) {//Si el usuario existe
                System.out.println("Esta seguro que quiere borrar el empresario (s/n)");
                String op = lee.readLine();
                if (op.equalsIgnoreCase("s")) {
                    eliminar(user);//Se elimina el usuario
                    System.out.println("Se ha eliminado el usuario");
                }
            } else {
                System.out.println("No existe el usuario");
            }
        } catch (IOException e) {
            System.out.println("Error al borrar el Empresario");
        }*/
    }

    public static void bajaCandidato(BufferedReader lee) throws IOException {//Metodo por si el admin quiere dar de baja un candidato
       /* Visualizar.visualizarCandidato(db);
        
        System.out.println("Inserte el dni del candidato que quiera dar de baja");
        String dni = lee.readLine();
        
         MongoCollection <Document> coleccion = db.getCollection("candidatos");
        
     
        
        
        System.out.println("Seguro que quiere borrar el candidato con dni: "+dni+" (s/n)");
        String op = lee.readLine();
        if(op.equalsIgnoreCase("s")){
            db.getCollection("candidatos").deleteOne(new Document("dni", dni));
                    //crear en insertar . altaCv una linea para usuario que tenga el dni del candidato

            db.getCollection("curriculums").deleteOne(new Document("usuario", dni));
            System.out.println("Se ha eliminado el candidato");
        }else if (op.equalsIgnoreCase("n")){
            System.out.println("Se ha cancelado el borrado del usuario");
        }
        /*try {
            Visualizar.visualizarCandidato();//Se visualizan los datos del candidato
            System.out.println("Ponga el dni del candidato que desea borrar");
            String dni = lee.readLine();
            Session sesion = NewHibernateUtil.getSession();
            Usuario user = (Usuario) sesion.get(Usuario.class, dni);//Se obtiene el objeto usuario
            Candidato cand = (Candidato) sesion.get(Candidato.class, dni);//Segun el dni, se obtiene el objeto para sacar el cv
            int idcv = cand.getCurriculum();//Se obtiene a partir del usuario el id del cv
            Curriculum cv = (Curriculum) sesion.get(Curriculum.class, idcv);// Se obtiene el objeto del cv
            sesion.close();
            if (cand != null) {//Si existe el candidato
                System.out.println("Seguro que desea borrar el usuario?");
                String op = lee.readLine();
                if (op.equalsIgnoreCase("s")) {
                    eliminar(cv);//se borra el cv del usuario
                    eliminar(user);// se borra el usuario
                    System.out.println("Se ha eliminado el candidato");
                    Visualizar.visualizarCandidato();
                } else {
                    System.out.println("Se ha cancelado la eliminacion");
                }
            } else {
                System.out.println("El candidato no existe");
            }
        } catch (IOException e) {
            System.out.println("Error al borrar cancidato");

        }*/

    }
    

    
    public static void bajaAnuncio(BufferedReader lee) {//Metodo por si el admin quiere borrar un anuncio
        /*try {
            
            int comprobar = Visualizar.visualizarAnuncioEmpresario(e);
            if (comprobar != 0) {
                System.out.println("Selecciona el id del anuncio a borrar");
                int idAnuncio = Integer.parseInt(lee.readLine());
                Session sesion = NewHibernateUtil.getSession();
                Anuncio anuncio = (Anuncio) sesion.get(Anuncio.class, idAnuncio);//Obtiene el idioma a partir del id
                sesion.close();
                if (anuncio != null) {
                    System.out.println("Seguro que quiere borra el anuncio ?(s/n)");
                    String op = lee.readLine();

                    if (op.equalsIgnoreCase("s")) {
                        eliminar(anuncio);//Se elimina el idioma
                        System.out.println("Se ha borrado el anuncio");
                        Visualizar.visualizarAnuncioEmpresario(e);
                    } else {
                        System.out.println("No se ha borrado el anuncio");
                    }
                } else {
                    System.out.println("El anuncio que ha seleccionado no existe");
                }
            }
        } catch (IOException error) {
            System.out.println("Error al borrar el anuncio");
        }*/

    }
    

    public static void bajaCurriculum(BufferedReader lee) {//Metodo por si el usuario quiere borrar su curriculum
        try {
            /*Prueba borrar cv*/
       //     Visualizar.visualizarCandidato();
            System.out.println("Quien eres");
            //Session sesion = NewHibernateUtil.getSession();
            String dni = lee.readLine();
            //Candidato cand = (Candidato) sesion.get(Candidato.class, dni);//se obtiene el candidato por el dni
           // int idcv = cand.getCurriculum();//se obtiene el id del curriculum del usuario
            System.out.println("Esta seguro que quiere borrar su curriculum? (s/n)");
           // Curriculum cv = (Curriculum) sesion.get(Curriculum.class, idcv);//Se obtiene el objeto curriculum del usuario
           // sesion.close();
            String op = lee.readLine();

            if (op.equalsIgnoreCase("s")) {
               // eliminar(cv);//Se borra el curriculum del usuario, y se pone a null
                System.out.println("Se ha borrado tu curriculum");
                /*
            System.out.println("Desea crear otro cv? (s/n)");
            String op2 = lee.readLine();
            if (op2.equalsIgnoreCase("s")) {
                System.out.println("Te la creite");
                //InsertarCV
            }*/
            } else {
                System.out.println("No se ha borrado tu cv");
            }
        } catch (IOException e) {
            System.out.println("Error baja curriculum");
        }
    }

    public static void bajaFormacion(BufferedReader lee) throws IOException {//M3etodo por si el admin quiere borrar una formacion
      /*  Visualizar.visualizarFormacion(db);
        System.out.println("Seleccione el id de la formacion a borrar: ");
        int codigo = Integer.parseInt(lee.readLine());
        
         MongoCollection <Document> coleccion = db.getCollection("formaciones");
        
     
        
        
        System.out.println("Seguro que quiere borrar la formacion con id: "+codigo+" (s/n)");
        String op = lee.readLine();
        if(op.equalsIgnoreCase("s")){
            db.getCollection("formaciones").deleteOne(new Document("id", codigo));
            System.out.println("Se ha eliminado la formación");
        }else if (op.equalsIgnoreCase("n")){
            System.out.println("Se ha cancelado el borrado de la formación");
        }*/
        
        
        /*try {

            int comprobar = Visualizar.visualizarFormacion();

            if (comprobar != 0) {
                System.out.println("Seleccione el id de la formacion a borrar: ");
                int codigo = Integer.parseInt(lee.readLine());
                Session sesion = NewHibernateUtil.getSession();
                Formacion formacion = (Formacion) sesion.get(Formacion.class, codigo);//Se obtiene el objeto formacion a partir del id
                sesion.close();
                if (formacion != null) {//Si no hay formacion
                    System.out.println("Seguro que quiere borrar la formacion? (s/n)");
                    String op = lee.readLine();
                    if (op.equalsIgnoreCase("s")) {
                        eliminar(formacion);
                        System.out.println("Se ha eliminado correctamente la formacion");
                        Visualizar.visualizarFormacion();
                    } else {
                        System.out.println("No se ha eliminado la formacion");
                    }
                } else {
                    System.out.println("La formacion que ha seleccionado no existe");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro al borrar formacion");
        }*/
    }


}
