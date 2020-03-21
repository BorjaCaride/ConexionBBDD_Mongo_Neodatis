package Mongo.metodos;

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

public class Visualizar {

    public static int visualizarEmpresario(MongoDatabase db) {

        MongoCollection<Document> coleccion = db.getCollection("empresarios");

        List<Document> consulta = coleccion.find().into(new ArrayList<Document>());
        System.out.println("------------EMPRESARIOS--------------");

        if (consulta != null) {
            System.out.println("DNI\tNOMBRE\tTELEFONO");

            for (int i = 0; i < consulta.size(); i++) {
                Document emp = consulta.get(i);
                System.out.println(emp.getString("dni") + "\t" + emp.getString("nombre") + "\t" + emp.getInteger("telefono"));
            }

        } else {
            System.out.println("No hay ningún Empresario");
        }
        /* try {
            Session sesion;
            sesion = NewHibernateUtil.getSession();
            
            List<Object> empresarios = sesion.createCriteria(Empresario.class).list();
            sesion.close();
            
            if(!empresarios.isEmpty()){
                System.out.println("DNI\t\tNOMBRE\t\tNOM_EMPRESA");
                for(Object empresario : empresarios){
                    System.out.println(((Empresario) empresario).getDni() + "\t\t" + ((Empresario) empresario).getNombre() + "\t\t" + ((Empresario) empresario).getNombre_empresa());
                }
                return 1;
            }
            
            else {
                System.out.println("No hay empresarios");
             return 0;
            }
        }
        catch(HibernateException e){
            
            System.out.println(e.getMessage());
        }*/

        return 1;
    }

    public static int visualizarCandidato(MongoDatabase db) {
        MongoCollection<Document> coleccion = db.getCollection("candidatos");

        List<Document> consulta = coleccion.find().into(new ArrayList<Document>());
        System.out.println("------------CANDIDATOS--------------");

        if (consulta != null) {
            System.out.println("DNI\tNOMBRE\tTELEFONO");

            for (int i = 0; i < consulta.size(); i++) {
                Document cand = consulta.get(i);
                System.out.println(cand.getString("dni") + "\t" + cand.getString("nombre") + "\t" + cand.getInteger("telefono"));
            }

        } else {
            System.out.println("No hay ningún candidato");
        }
        /*System.out.println("            CANDIDATOS \n");
        
        
        try {
        Session sesion;
        sesion = NewHibernateUtil.getSession();
        
        List<Object> candidatos = sesion.createCriteria(Candidato.class).list();
        sesion.close();
        
        if(!candidatos.isEmpty()){
            System.out.println("DNI\t\tNOMBRE\t\tCORREO");
            for(Object candidato : candidatos){
                System.out.println(((Candidato) candidato).getDni() + "\t\t" + ((Candidato) candidato).getNombre() + "\t\t" + ((Candidato) candidato).getCorreo());
                
            }
            return 1;
        }
        
        else {
            
            System.out.println("No hay candidatos");
            return 0;
        }
        
       
    } catch(HibernateException e){
        System.out.println(e.getMessage());
    }*/
        return 1;

    }

    public static int visualizarFormacion(MongoDatabase db) {
        MongoCollection<Document> coleccion = db.getCollection("formaciones");

        List<Document> consulta = coleccion.find().into(new ArrayList<Document>());
        System.out.println("------------FORMACIONES--------------");

        if (consulta != null) {
            System.out.println("ID\tFORMACION");

            for (int i = 0; i < consulta.size(); i++) {
                Document formacion = consulta.get(i);
                System.out.println(formacion.getInteger("id") + "\t" + formacion.getString("nombre"));
            }

        } else {
            System.out.println("No hay formaciones");
        }
        /*System.out.println("        FORMACIONS");
        
        try{
            Session sesion;
            sesion = NewHibernateUtil.getSession();
            
            List<Object> formaciones = sesion.createCriteria(Formacion.class).list();
            sesion.close();
            
            if (!formaciones.isEmpty()){
                System.out.println("ID\tTIPO");
                for(Object formacion : formaciones){
                    System.out.println(((Formacion) formacion).getId_formacion()+"\t"+((Formacion) formacion).getNombre());
                }
                return 1;
                
            }
            else {
                System.out.println("No hay formaciones disponibles");
                return 0;
            }
            
            
            
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            
        }*/
        return 1;

    }

    public static int visualizarAnuncio(BufferedReader lee, MongoDatabase db, String dni) throws IOException {

        MongoCollection<Document> coleccion = db.getCollection("anuncios");

        List<Document> consulta = coleccion.find().into(new ArrayList<Document>());
        System.out.println("------------ANUNCIOS--------------");

        if (consulta != null) {
            System.out.println("ID\tTÍTULO\tSALARIO");

            for (int i = 0; i < consulta.size(); i++) {
                Document anuncio = consulta.get(i);
                System.out.println(anuncio.getInteger("id") + "\t" + anuncio.getString("titulo") + "\t" + anuncio.getDouble("salario"));
            }
            Inserciones.añadirCandidatoAnuncio(lee, db, dni);
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
                
                
                Inserciones.añadirCandidatoAnuncio(lee, c);
                
                
                
                
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

    public static int visualizarAnuncioEmpresario(String dni, MongoDatabase db) {

        MongoCollection<Document> coleccion = db.getCollection("anuncios");

        //crear en insertar . altaAnuncio una linea para empresario que tenga el dni
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

    public static void visualizarSolicitudes(BufferedReader lee, MongoDatabase db, String dni) throws IOException {

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
                                + "\tTelefono : " + cand.getInteger("telefono")+"\n");

                    }

                }

            }

        } else {
            System.out.println("No tienes anuncios");

        }

    }

    public static void visualizarAnuncioFormacion(BufferedReader lee, MongoDatabase db, String dni) throws IOException {

        visualizarFormacion(db);

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
            Inserciones.añadirCandidatoAnuncio(lee, db, dni);
        } else {
            System.out.println("No hay anuncios");

        }
        /*visualizarFormacion();
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
            Inserciones.añadirCandidatoAnuncio(lee, c);
        }*/

    }

    public static void visualizarAnuncioLocalidad(BufferedReader lee, MongoDatabase db, String dni) throws IOException {
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
            Inserciones.añadirCandidatoAnuncio(lee, db, dni);
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
            Inserciones.añadirCandidatoAnuncio(lee, c);

        } else {
            System.out.println("No hay anuncios disponibles");

        }*/
    }

    private static void bajarVacantes(MongoDatabase db, String dni, int idanuncio) {

        MongoCollection<Document> coleccion = db.getCollection("anuncios");

        List<Document> consulta = coleccion.find(eq("empresario", dni)).into(new ArrayList<Document>());

        coleccion.updateOne(eq("id", idanuncio), inc("vacantes", 1));
    }
}
