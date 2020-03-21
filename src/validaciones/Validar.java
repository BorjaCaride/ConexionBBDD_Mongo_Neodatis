
package validaciones;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.List;
import java.sql.Date;
import java.util.ArrayList;
import org.bson.Document;
import proyecto.*;
/**
 *
 * @author a16raulic
 */
public class Validar {
    
    public static int validarDNI(String dni){
        
    int d=0;
        try{
        
            if (dni.length() != 9) {
                d = 1;
                throw new MisExcepciones("Longitud Errónea");
            }
            if (dni.substring(0,8).matches("[0-9]*")) {
                //Coge desde la posición 0 a la 7 incluídas
                d = 0;}
                else{
                        
                        d=1;
                        throw new MisExcepciones("Número Erróneo");
                       }
            if (dni.substring(8).matches("[A-Za-z]")) {
                //coge a partir de la pos 8 hasta el final
                d = 0;

            } else {
                d = 1;
                throw new MisExcepciones("Letra  Errónea");
            }
             
        
         
             }
        catch(MisExcepciones e)
            {
                System.out.println(e.getError());
            }
        return d;
    }
    
    public static int validarTlf(int tlf){
     
        int d=0;
        
        try{
        
            if (tlf < 100000000 || tlf > 999999999) {
                d = 1;
                throw new MisExcepciones("Número no válido");
            }
             
             }
        catch(MisExcepciones e)
            {
                System.out.println(e.getError());
            }
        
        
        
        return d;
    }
    
    
    public static int validarCorreo(String correo){
        
       /* int d=0;
        
        try{
            
            if ((correo.contains("@") && (correo.contains(".com") | correo.contains(".es")))==false){
                d=1;
                throw new MisExcepciones("El correo tiene que tener el caracter @ y .com o .es");
            }
            
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
            

            
            
            
        }catch(MisExcepciones e){
            System.out.println(e.getError());
        }


        return d;
   */
       return 0;
    }
    
    
    public static int validarSexo(String sexo){
        
        int d=0;
        
        /*try{
            if (sexo.equalsIgnoreCase("Hombre") || sexo.equalsIgnoreCase("Mujer")){
                d=0;
            }
            else{
                d=1;
                throw new MisExcepciones("El sexo debe tener los valores Hombre o Mujer");
            }
            
            
        }catch(MisExcepciones e){
            System.out.println(e.getError());
        }
        */
        
        return d;
    }
    
    
    
    
    public static int validarPermiso(String permiso){
        
        int d=0;
        
       /* try{
            if (permiso.equalsIgnoreCase("Si") || permiso.equalsIgnoreCase("Sí") || permiso.equalsIgnoreCase("No")){
                d=0;
            }
            else{
                d=1;
                throw new MisExcepciones("El sexo debe tener los valores Hombre o Mujer");
            }
            
            
        }catch(MisExcepciones e){
            System.out.println(e.getError());
        }
        */
        
        return d;
    }
    
    

    
}

