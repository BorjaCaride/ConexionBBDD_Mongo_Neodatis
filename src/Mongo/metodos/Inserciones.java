package Mongo.metodos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Indexes.descending;
import static com.mongodb.client.model.Sorts.orderBy;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Date;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.bson.Document;
import validaciones.Validar;

public class Inserciones {
    
    private static int contF = 0, contC = 0, contA = 0;
    
    public static void altaUsuario(MongoDatabase db, BufferedReader lee) throws IOException, ParseException {
        
        MongoCollection<Document> coleccionEmp = db.getCollection("empresarios");
        
        System.out.println("Quiere darse de alta como candidato o como empresario (c/e)");
        String cand = lee.readLine();
        
        if (cand.equalsIgnoreCase("e")) {
            altaEmpresario(db, lee); //METODO PARA OPCION EMPRESARIO
        } else if (cand.equalsIgnoreCase("c")) {
            altaCandidato(db, lee);//METOD PARA OPCION CANDIDATO
        } else {
            System.out.println("Opcion incorrecta");
        }
        
    }
    
    public static void altaEmpresario(MongoDatabase db, BufferedReader lee) throws IOException {
        
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

        //Empresario e = new Empresario(nombre_empresa,sector,localidad,dni,nombre,apellidos,correo,telefono);//CREAR EL OBJETO EMPRESARIO
        MongoCollection<Document> coleccionEmp = db.getCollection("empresarios");
        Document empresario = new Document();
        empresario.put("dni", dni);
        empresario.put("nombre", nombre);
        empresario.put("apellido", apellidos);
        empresario.put("correo", correo);
        empresario.put("telefono", telefono);
        empresario.put("empresa", nombre_empresa);
        empresario.put("sector", sector);
        empresario.put("localidad", localidad);
        
        coleccionEmp.insertOne(empresario);
        
        System.out.println("Empresario añadido correctamente");
        
        
    }
    
    private static void altaCandidato(MongoDatabase db, BufferedReader lee) throws IOException, ParseException {
        
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

        //Candidato cand = new Candidato(fecha_nac, opsex, dni, nombre, apellidos, correo, telefono);
        MongoCollection<Document> coleccionCand = db.getCollection("candidatos");
        
        Document candidato = new Document();
        candidato.put("dni", dni);
        candidato.put("nombre", nombre);
        candidato.put("apellido", apellidos);
        candidato.put("correo", correo);
        candidato.put("telefono", telefono);
        candidato.put("fecha_nac", fecha_nac);
        candidato.put("sexo", opsex);
        
        coleccionCand.insertOne(candidato);
        
        altaCurriculum(db, lee, dni);
        
        System.out.println("Candidato introducido correctamente");
    }
    
    public static void altasFormaciones(MongoDatabase db, BufferedReader lee) throws IOException {
        
        String nombreForm;
        
        System.out.println("Introduzca la formacion a guardar");
        nombreForm = lee.readLine();
        
        
        MongoCollection<Document> coleccionForm = db.getCollection("formaciones");
        Document doc = coleccionForm.find().sort(orderBy(descending("id"))).first();
        contF = 1;
        if (doc != null) {
            
            contF = doc.getInteger("id") + 1;
        }
        Document formacion = new Document();
        formacion.put("id", contF);
        formacion.put("nombre", nombreForm);
        coleccionForm.insertOne(formacion);

        //Formacion f = new Formacion(nombreForm);
        System.out.println("Formación introducida correctamente");
        
    }
    
    public static void altaAnuncio(MongoDatabase db, BufferedReader lee, String dni) throws IOException {
        
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
        
        MongoCollection<Document> coleccionAn = db.getCollection("anuncios");
        Document doc = coleccionAn.find().sort(orderBy(descending("id"))).first();
        contA = 1;
        if (doc != null) {
            
            contA = doc.getInteger("id") + 1;
        }
        Document anuncio = new Document();
        anuncio.put("id", contA);
        anuncio.put("titulo", titulo);
        anuncio.put("descripcion", descripcion);
        anuncio.put("vacantes", vacantes);
        anuncio.put("localidad", localidad);
        anuncio.put("salario", salario);
        anuncio.put("empresario", dni);
        anuncio.put("fecha", fecha);
        añadirFormAnuncio(lee, anuncio, db);
        coleccionAn.insertOne(anuncio);

        //Anuncio anuncio = new Anuncio(titulo, descripcion, vacantes, localidad, fecha.toString(), salario);
        //anuncio.setEmpresario(e);
        //añadirFormAnuncio(lee, anuncio);
    }
    
    public static void altaCurriculum(MongoDatabase db, BufferedReader lee, String dni) throws IOException {
        
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
        
        MongoCollection<Document> coleccionCurr = db.getCollection("curriculums");
        Document doc = coleccionCurr.find().sort(orderBy(descending("id"))).first();
        contC = 1;
        if (doc != null) {
            
            contC = doc.getInteger("id") + 1;
            
        }
        Document curriculum = new Document();
        curriculum.put("id", contC);
        curriculum.put("experiencia", experiencia);
        curriculum.put("premiso_coche", permiso_coche);
        curriculum.put("usuario", dni);
        
        añadirFormCurriculum(lee, curriculum, db);
        coleccionCurr.insertOne(curriculum);

        //Curriculum cv = new Curriculum(experiencia, permiso_coche);
        //int codigo = cv.getId_curriculum();
        //cand.setCurriculum(codigo);
        //añadirFormCurriculum(lee, cv);
    }
    
    public static void añadirFormCurriculum(BufferedReader lee, Document curriculum, MongoDatabase db) throws IOException {
        Visualizar.visualizarFormacion(db);
        
        System.out.println("ID formacion");
        int codigo = Integer.parseInt(lee.readLine());
        
        MongoCollection coleccionForm = db.getCollection("formaciones");
        
        Document doc = (Document) coleccionForm.find(eq("id", codigo)).first();
        
        if (doc != null) {
            
            curriculum.put("formacion", codigo);
        }
    }
    
    public static void añadirFormAnuncio(BufferedReader lee, Document anuncio, MongoDatabase db) throws IOException {

        Visualizar.visualizarFormacion(db);
        System.out.println("ID formacion");
        int codigo = Integer.parseInt(lee.readLine());
        
        MongoCollection coleccionForm = db.getCollection("formaciones");
        
        Document doc = (Document) coleccionForm.find(eq("id", codigo)).first();
        
        if (doc != null) {
            
            anuncio.put("formacion", codigo);
        }
    }
    
    public static void añadirCandidatoAnuncio(BufferedReader lee, MongoDatabase db, String dni) throws IOException {
        
        System.out.println("Inserte id anuncio al que quiere realizar una solicitud (0 para salir)");
        int idAnuncio = Integer.parseInt(lee.readLine());
        
        MongoCollection<Document> coleccion = db.getCollection("anuncios");

        //crear en insertar . altaAnuncio una linea para empresario que tenga el dni
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
