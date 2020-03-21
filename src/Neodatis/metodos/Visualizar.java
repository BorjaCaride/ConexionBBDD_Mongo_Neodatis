package Neodatis.metodos;

import Mongo.metodos.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.inc;
import comprobaciones.Comprobar;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bson.Document;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import pojos.*;

public class Visualizar {

    public static int visualizarEmpresarioNeo() {

        ODB odb = ODBFactory.open("justjobs.db");
        Objects<Empresario> empresarios = odb.getObjects(Empresario.class);

        System.out.println("DNI\tNOMBRE\tTELEFONO");

        while (empresarios.hasNext()) {
            Empresario e = empresarios.next();
            System.out.println(e.getDni() + "\t" + e.getNombre() + "\t" + e.getTelefono());
        }
        odb.close();

        return 1;

    }

    public static int visualizarCandidatoNeo() {
          ODB odb = ODBFactory.open("justjobs.db");
        Objects<Candidato> candidatos = odb.getObjects(Candidato.class);

        System.out.println("DNI\tNOMBRE\tTELEFONO");

        while (candidatos.hasNext()) {
            Candidato c = candidatos.next();
            System.out.println(c.getDni() + "\t" + c.getNombre() + "\t" + c.getTelefono());
        }
        odb.close();

       
        return 1;

    }

    public static int visualizarFormacionNeo() {

        ODB odb = ODBFactory.open("justjobs.db");
        Objects<Formacion> formaciones = odb.getObjects(Formacion.class);
        System.out.println("ID\tFORMACION");

        while (formaciones.hasNext()) {
            Formacion f = formaciones.next();
            System.out.println(f.getId_formacion() + "\t" + f.getNombre());
        }
        odb.close();

        return 1;

    }

    public static int visualizarAnuncioNeo(BufferedReader lee, MongoDatabase db, String dni) throws IOException {

        MongoCollection<Document> coleccion = db.getCollection("anuncios");

        List<Document> consulta = coleccion.find().into(new ArrayList<Document>());
        System.out.println("------------ANUNCIOS--------------");

        if (consulta != null) {
            System.out.println("ID\tTÍTULO\tSALARIO");

            for (int i = 0; i < consulta.size(); i++) {
                Document anuncio = consulta.get(i);
                System.out.println(anuncio.getInteger("id") + "\t" + anuncio.getString("titulo") + "\t" + anuncio.getDouble("salario"));
            }
            Inserciones.añadirCandidatoAnuncioNeo(lee, db, dni);
        } else {
            System.out.println("No hay anuncios");

        }

        /* try{
            Session sesion;
            sesion = NewHibernateUtil.getSession();
            
            List<Object> anuncios = sesion.createCriteria(Anuncio.class).list();
            sesion.close();
            
            
            if (!anuncios.isEmpty()){
                System.out.println("TIPO");
                for(Object usuario : anuncios){
                    System.out.println(((Anuncio) usuario).getId_anuncio());
                    System.out.println(((Anuncio) usuario).getTitulo());
                }
                
                
                Inserciones.añadirCandidatoAnuncioNeo(lee, c);
                
                
                
                
                return 1;
                
            }
            else {
                System.out.println("No hay anuncios disponibles");
                return 0;
            }
            
            
            
            
            
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            
        }*/
        return 1;

    }

    public static int visualizarAnuncioEmpresarioNeo(String dni, MongoDatabase db) {

        MongoCollection<Document> coleccion = db.getCollection("anuncios");

        //crear en insertar . altaAnuncioNeo una linea para empresario que tenga el dni
        List<Document> consulta = coleccion.find(eq("empresario", dni)).into(new ArrayList<Document>());
        System.out.println("------------ANUNCIOS--------------");

        if (consulta != null) {
            System.out.println("ID\tTÍTULO\tSALARIO\tLOCALIDAD");

            for (int i = 0; i < consulta.size(); i++) {
                Document anuncio = consulta.get(i);
                System.out.println(anuncio.getInteger("id") + "\t" + anuncio.getString("titulo") + "\t" + anuncio.getDouble("salario") + "\t" + anuncio.getString("localidad"));
            }
        } else {
            System.out.println("No hay anuncios");

        }
        /*Session sesion = NewHibernateUtil.getSession();
        
        int numAnuncios=0;
        
        
        List<Anuncio> listAn=sesion.createCriteria(Anuncio.class).list();
        

            System.out.println("ANUNCIOS DISPONIBLES");

            
            
            
            
                for(Anuncio a: listAn){
                if (a.getEmpresario().getDni().equalsIgnoreCase(e.getDni())){
            
                        System.out.println("\n\tID ANUNCIO: "+a.getId_anuncio()
                        + "\n\tTitulo: "+a.getTitulo()
                        +" \n\tEmpresario: "+a.getEmpresario().getDni());
                        numAnuncios++;
                        
                        }
                
                }
                
                if (numAnuncios==0){
                    System.out.println("Usted no tiene ningún usuario creado");
                    return 0;
                }
                else{*/
        return 1;
    }
    //}

    public static void visualizarSolicitudesNeo(BufferedReader lee, MongoDatabase db, String dni) throws IOException {

        //dni empresario
        MongoCollection<Document> coleccion_solicitudes = db.getCollection("solicitudes");
        MongoCollection<Document> coleccion_candidatos = db.getCollection("candidatos");
        MongoCollection<Document> coleccion_anuncios = db.getCollection("anuncios");

        List<Document> consulta_anuncios = coleccion_anuncios.find(eq("empresario", dni)).into(new ArrayList<Document>());
        System.out.println("--------SOLICITUDES-----------");

        if (consulta_anuncios != null) {

            for (int i = 0; i < consulta_anuncios.size(); i++) {
                Document anu = consulta_anuncios.get(i);
                System.out.println("TITULO : " + anu.getString("titulo") + " con ID : " + anu.getInteger("id"));
                List<Document> consulta_solicitudes = coleccion_solicitudes.find(eq("anuncio", anu.getInteger("id"))).into(new ArrayList<Document>());
                int o = 0;
                for (o = 0; o < consulta_solicitudes.size(); o++) {
                    Document soli = consulta_solicitudes.get(o);
                    List<Document> consulta_candidatos = coleccion_candidatos.find(eq("dni", soli.getString("candidato"))).into(new ArrayList<Document>());
                    for (int e = 0; e < consulta_candidatos.size(); e++) {
                        Document cand = consulta_candidatos.get(e);
                        System.out.println("\tDNI :" + cand.getString("dni") + ""
                                + "\n\tNombre : " + cand.getString("nombre") + "\n"
                                + "\tApellido :" + cand.getString("apellido") + "\n"
                                + "\tTelefono : " + cand.getInteger("telefono") + "\n");

                    }

                }

            }

        } else {
            System.out.println("No tienes anuncios");

        }

    }

    public static void visualizarAnuncioFormacionNeo(BufferedReader lee, MongoDatabase db, String dni) throws IOException {

        visualizarFormacionNeo();

        System.out.println("Pon el id");
        int codigo = Integer.parseInt(lee.readLine());

        MongoCollection<Document> coleccion = db.getCollection("anuncios");

        List<Document> consulta = coleccion.find(eq("formacion", codigo)).into(new ArrayList<Document>());
        System.out.println("------------ANUNCIOS--------------");

        if (consulta != null) {
            System.out.println("ID\tTÍTULO\tSALARIO\tLOCALIDAD");

            for (int i = 0; i < consulta.size(); i++) {
                Document anuncio = consulta.get(i);
                System.out.println(anuncio.getInteger("id") + "\t" + anuncio.getString("titulo") + "\t" + anuncio.getDouble("salario") + "\t" + anuncio.getString("localidad"));
            }
            Inserciones.añadirCandidatoAnuncioNeo(lee, db, dni);
        } else {
            System.out.println("No hay anuncios");

        }
        /*visualizarFormacionNeo();
        System.out.println("Seleccione el id de la formación");
        int op = Integer.parseInt(lee.readLine());

        Session sesion = NewHibernateUtil.getSession();
        List<Anuncio> listAn = sesion.createCriteria(Anuncio.class).list();

        if (!listAn.isEmpty()) {
            System.out.println("ID\tTITULO");
            
            for (Anuncio a : listAn) {
                int cod = a.getFormacion().hashCode();
                if(cod==op){
                   System.out.println(((Anuncio) a).getId_anuncio() + "\t" + ((Anuncio) a).getTitulo());
                }
            }
            Inserciones.añadirCandidatoAnuncioNeo(lee, c);
        }*/

    }

    public static void visualizarAnuncioLocalidadNeo(BufferedReader lee, MongoDatabase db, String dni) throws IOException {
        System.out.println("Escriba la localidad");
        String localidad = lee.readLine();

        MongoCollection<Document> coleccion = db.getCollection("anuncios");

        List<Document> consulta = coleccion.find(eq("localidad", localidad)).into(new ArrayList<Document>());
        System.out.println("------------ANUNCIOS--------------");

        if (consulta != null) {
            System.out.println("ID\tTÍTULO\tSALARIO\tLOCALIDAD");

            for (int i = 0; i < consulta.size(); i++) {
                Document anuncio = consulta.get(i);
                System.out.println(anuncio.getInteger("id") + "\t" + anuncio.getString("titulo") + "\t" + anuncio.getDouble("salario") + "\t" + anuncio.getString("localidad"));
            }
            Inserciones.añadirCandidatoAnuncioNeo(lee, db, dni);
        } else {
            System.out.println("No hay anuncios");

        }

        /*System.out.println("Escriba la localidad");
        String localidad = lee.readLine();

        Session sesion = NewHibernateUtil.getSession();
        List<Anuncio> listAn = sesion.createCriteria(Anuncio.class).list();

        if (!listAn.isEmpty()) {
            System.out.println("ID\tTITULO");
            for (Anuncio a : listAn) {
                if (((Anuncio) a).getLocalidad().equalsIgnoreCase(localidad)) {
                    System.out.println(((Anuncio) a).getId_anuncio() + "\t" + ((Anuncio) a).getTitulo());
                }
            }
            Inserciones.añadirCandidatoAnuncioNeo(lee, c);

        } else {
            System.out.println("No hay anuncios disponibles");

        }*/
    }

    private static void bajarVacantesNeo(MongoDatabase db, String dni, int idanuncio) {

        MongoCollection<Document> coleccion = db.getCollection("anuncios");

        List<Document> consulta = coleccion.find(eq("empresario", dni)).into(new ArrayList<Document>());

        coleccion.updateOne(eq("id", idanuncio), inc("vacantes", 1));
    }
}
