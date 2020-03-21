/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comprobaciones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.List;
import org.bson.Document;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import pojos.Candidato;
import pojos.Empresario;
import validaciones.MisExcepciones;

/**
 *
 * @author a16raulic
 */
public class Comprobar {

    public static String compDni(MongoDatabase db, String dni) {

        int d = 0;
        String usuario = null;

        MongoCollection<Document> coleccionEmp = db.getCollection("empresarios");
        Document empresario = new Document();

        MongoCollection<Document> coleccionCand = db.getCollection("candidatos");
        Document candidato = new Document();

        candidato = (Document) coleccionCand.find(eq("dni", dni)).first();

        if (candidato == null) {
            empresario = (Document) coleccionEmp.find(eq("dni", dni)).first();
            if (empresario == null) {

            } else {
                usuario = "empresario";
            }
        } else {
            usuario = "candidato";
        }
        return usuario;

    }

    public static boolean compCorreo(String correo) {

        boolean existe = false;
        /* 
        Session sesion = NewHibernateUtil.getSession();
        List<Usuario> listUser=sesion.createCriteria(Usuario.class).list();
            
            
            for(Usuario u: listUser){
                if (u.getCorreo().equalsIgnoreCase(correo)){
                    existe=true;
                }
                    
            } */
        return existe;
    }

    public static String compDniNeo(String dni) {

        String usuario = null;
        ODB odb = ODBFactory.open("justjobs.db");

        IQuery query = new CriteriaQuery(Empresario.class, Where.equal("dni", dni));
        Empresario e = (Empresario) odb.getObjects(query).getFirst();

        if (e != null) {
            usuario = "empresario";

        } 
        
       

        odb.close();
        return usuario;

    }

    /*  public static boolean compAnuncio(Anuncio a, Empresario e){
        
        boolean existe = false;
        
        Session sesion = NewHibernateUtil.getSession();
        List<Anuncio> listAnuncio=sesion.createCriteria(Anuncio.class).list();
        
        for(Anuncio anuncio: listAnuncio){
                if (anuncio.getEmpresario().getDni().equalsIgnoreCase(e.getDni()) && e.getAnuncio().contains(anuncio)){
                    existe=true;
                }
                    
            }
        
        
        return existe;
    }
     */
}
