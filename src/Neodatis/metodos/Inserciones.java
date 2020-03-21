package Neodatis.metodos;

import Mongo.metodos.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Indexes.descending;
import static com.mongodb.client.model.Sorts.orderBy;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Date;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.bson.Document;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;
import pojos.*;
import validaciones.Validar;

public class Inserciones {

    private static int contF = 0, contC = 0, contA = 0;

    public static void altaUsuarioNeo(BufferedReader lee) throws IOException, ParseException {

        System.out.println("Quiere darse de alta como candidato o como empresario (c/e)");
        String cand = lee.readLine();

        if (cand.equalsIgnoreCase("e")) {
            altaEmpresarioNeo(lee); //METODO PARA OPCION EMPRESARIO
        } else if (cand.equalsIgnoreCase("c")) {
            altaCandidatoNeo(lee);//METOD PARA OPCION CANDIDATO
        } else {
            System.out.println("Opcion incorrecta");
        }

    }

    public static void altaEmpresarioNeo(BufferedReader lee) throws IOException {
        ODB odb = ODBFactory.open("justjobs.db");
        String dni, correo;
        int telefono;

        do {
            System.out.println("Inserte su DNI ");
            dni = lee.readLine();
        } while (Validar.validarDNI(dni) != 0);

        System.out.println("Inserte el nombre");
        String nombre = lee.readLine();
        System.out.println("Inserte el apellido");
        String apellidos = lee.readLine();

        do {
            System.out.println("Inserte el correo");
            correo = lee.readLine();
        } while (Validar.validarCorreo(correo) != 0);

        do {
            System.out.println("Inserte el telefono");
            telefono = Integer.parseInt(lee.readLine());
        } while (Validar.validarTlf(telefono) != 0);

        System.out.println("Inserte el nombre de la empresa");
        String nombre_empresa = lee.readLine();
        System.out.println("Introduzca el Sector");
        String sector = lee.readLine();
        System.out.println("Introduzca la localidad");
        String localidad = lee.readLine();

        Empresario e = new Empresario(nombre_empresa, sector, localidad, dni, nombre, apellidos, correo, telefono);//CREAR EL OBJETO EMPRESARIO

        odb.store(e);

        odb.close();
        System.out.println("Empresario añadido correctamente");

    }

    private static void altaCandidatoNeo(BufferedReader lee) throws IOException, ParseException {
       // ODB odb = ODBFactory.open("justjobs.db");
        String dni, correo, opsex;
        int telefono;

        do {
            System.out.println("Inserte su DNI ");
            dni = lee.readLine();
        } while (Validar.validarDNI(dni) != 0);

        System.out.println("Inserte el nombre");
        String nombre = lee.readLine();
        System.out.println("Inserte el apellido");
        String apellidos = lee.readLine();

        do {
            System.out.println("Inserte el correo");
            correo = lee.readLine();
        } while (Validar.validarCorreo(correo) != 0);

        do {
            System.out.println("Inserte el telefono");
            telefono = Integer.parseInt(lee.readLine());
        } while (Validar.validarTlf(telefono) != 0);

        System.out.println("Introduce fecha nacimiento");
        String fecha_nac = lee.readLine();

        do {
            System.out.println("Sexo Hombre o Mujer (h/m)");
            opsex = lee.readLine();
        } while (Validar.validarSexo(opsex) != 0);

        Candidato cand = new Candidato(fecha_nac, opsex, dni, nombre, apellidos, correo, telefono);
   

       altaCurriculumNeo(lee, dni,cand);
        
        System.out.println("Candidato introducido correctamente");
    }

    public static void altasFormacionesNeo(BufferedReader lee) throws IOException {
        ODB odb = ODBFactory.open("justjobs.db");

        String nombreForm;

        System.out.println("Introduzca la formacion a guardar");
        nombreForm = lee.readLine();

        Values val = odb.getValues(new ValuesCriteriaQuery(Formacion.class).count("nombre"));
        ObjectValues ov =val.nextValues();
        BigInteger bi = (BigInteger) ov.getByAlias("nombre");
        int contador = bi.intValue();
        contador++;

        Formacion f = new Formacion(contador,nombreForm);
       odb.store(f);
       odb.close();
        
        System.out.println("Formación introducida correctamente");

        
        
    }

    public static void altaAnuncioNeo(BufferedReader lee, String dni) throws IOException {
        ODB odb = ODBFactory.open("justjobs.db");

       IQuery query = new CriteriaQuery(Empresario.class, Where.equal("dni", dni));
        Empresario e = (Empresario) odb.getObjects(query).getFirst();
        
        System.out.println("Introduzca el titulo del anuncio");
        String titulo = lee.readLine();
        System.out.println("Introduce la descripcion");
        String descripcion = lee.readLine();
        System.out.println("Introduce el numero de vacantes");
        int vacantes = Integer.parseInt(lee.readLine());
        System.out.println("Localidad");
        String localidad = lee.readLine();
        System.out.println("Salario");
        float salario = Float.parseFloat(lee.readLine());

        java.sql.Date fecha = new java.sql.Date(Calendar.getInstance().getTime().getTime());

       Values val = odb.getValues(new ValuesCriteriaQuery(Anuncio.class).count("id_anuncio"));
        ObjectValues ov =val.nextValues();
        BigInteger bi = (BigInteger) ov.getByAlias("id_anuncio");
        int contador = bi.intValue();
        contador++;
        

        Anuncio anuncio = new Anuncio(contador,titulo, descripcion, vacantes, localidad, fecha.toString(), salario);
        odb.store(anuncio);
        e.getAnuncio().add(anuncio);
        odb.close();
        //anuncio.setEmpresario(e);
        //añadirFormAnuncio(lee, anuncio);
    }

    public static void altaCurriculumNeo(BufferedReader lee, String dni,Candidato cand) throws IOException {
        String permiso;
        boolean permiso_coche;
        int d = 0;

        System.out.println("---------------ESTA CREANDO SU CURRICULUM-------------\n");
        System.out.println("Introduzca su experiencia");
        String experiencia = lee.readLine();

        do {
            System.out.println("Tiene permiso de coche? (Si/No)");
            permiso = lee.readLine();
        } while (Validar.validarPermiso(permiso) != 0);

        if (permiso.equalsIgnoreCase("Si") || permiso.equalsIgnoreCase("Sí")) {
            permiso_coche = true;
        } else {
            permiso_coche = false;
        }

        
          ODB odb = ODBFactory.open("justjobs.db");
        Values val = odb.getValues(new ValuesCriteriaQuery(Curriculum.class).count("id_curriculum"));
        ObjectValues ov =val.nextValues();
        BigInteger bi = (BigInteger) ov.getByAlias("id_curriculum");
        int contador = bi.intValue();
        contador++;
        odb.close();
        Curriculum cv = new Curriculum(contador,experiencia, permiso_coche);
        //int codigo = cv.getId_curriculum();
        //cand.setCurriculum(codigo);
        cand.setCurriculum(cv.getId_curriculum());
       añadirFormCurriculumNeo(lee, cv,cand);
        
    }

    public static void añadirFormCurriculumNeo(BufferedReader lee, Curriculum curriculum,Candidato cand) throws IOException {
        Visualizar.visualizarFormacionNeo();

        System.out.println("Seleccione el id de la formacion: ");
        int codigo = Integer.parseInt(lee.readLine());
        ODB odb = ODBFactory.open("justjobs.db");
        IQuery query = new CriteriaQuery(Formacion.class, Where.equal("id_formacion", codigo));
        Formacion f = (Formacion) odb.getObjects(query).getFirst();
        
        curriculum.getFormacion().add(f);
        odb.store(curriculum);
        odb.store(cand);
        odb.close();
        
    
        
        
    }

    public static void añadirFormAnuncioNeo(BufferedReader lee, Document anuncio, MongoDatabase db) throws IOException {

        Visualizar.visualizarFormacionNeo();
        System.out.println("ID formacion");
        int codigo = Integer.parseInt(lee.readLine());

        MongoCollection coleccionForm = db.getCollection("formaciones");

        Document doc = (Document) coleccionForm.find(eq("id", codigo)).first();

        if (doc != null) {

            anuncio.put("formacion", codigo);
        }
    }

    public static void añadirCandidatoAnuncioNeo(BufferedReader lee, MongoDatabase db, String dni) throws IOException {

        System.out.println("Inserte id anuncio al que quiere realizar una solicitud (0 para salir)");
        int idAnuncio = Integer.parseInt(lee.readLine());

        MongoCollection<Document> coleccion = db.getCollection("anuncios");

        //crear en insertar . altaAnuncioNeo una linea para empresario que tenga el dni
        List<Document> consulta = coleccion.find(eq("id", idAnuncio)).into(new ArrayList<Document>());
        System.out.println("------------ANUNCIOS--------------");

        if (consulta != null) {
            Document anuncio = consulta.get(0);

            String empresario = anuncio.getString("empresario");

            MongoCollection<Document> coleccionCurr = db.getCollection("solicitudes");
            Document doc = coleccionCurr.find().sort(orderBy(descending("id"))).first();
            contC = 1;
            if (doc != null) {

                contC = doc.getInteger("id") + 1;

            }
            Document solicitudes = new Document();
            solicitudes.put("id", contC);
            solicitudes.put("candidato", dni);
            solicitudes.put("empresario", empresario);
            solicitudes.put("anuncio", idAnuncio);
            coleccionCurr.insertOne(solicitudes);

        } else {
            System.out.println("No existe");

        }

        /*
        Session sesion = NewHibernateUtil.getSession();
        
        Anuncio a = (Anuncio) sesion.get(Anuncio.class, idAnuncio);
        
        a.getCandidato().add(c);
        sesion.close();
        guardarModif(a);
        
        c.getAnuncio().add(a);
        guardarModif(c);
         */
    }

}
