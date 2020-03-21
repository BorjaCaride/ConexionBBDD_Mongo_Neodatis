/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.sql.*;

/**
 *
 * @author a16borjacr
 */
public class Crear {

    public static void crearColeccion(MongoDatabase db) {

        try {
            //Sentencia.execute("DROP DATABASE IF EXISTS EMPLEAME");
           //Sentencia.execute("DROP DATABASE IF EXISTS PROXECTO_GRUPO7");
            /*
            Sentencia.execute("CREATE DATABASE IF NOT EXISTS PROXECTO_GRUPO7");
            Sentencia.execute("USE PROXECTO_GRUPO7");
            
            
            Sentencia.execute("CREATE TABLE IF NOT EXISTS USUARIOS("//si
                    + "DNI CHAR(9)  NOT NULL , "
                    + "NOMBRE VARCHAR(45) NOT NULL, "
                    + "APELLIDOS VARCHAR(45) NOT NULL, "
                    + "CORREO VARCHAR(50) NOT NULL,"
                    + "TELEFONO INT(9) NOT NULL,"
                    + "PRIMARY KEY(DNI)"
                    + ")");
             Sentencia.execute("CREATE TABLE IF NOT EXISTS EMPRESARIO("
                    + "DNI CHAR(9) NOT NULL, "
                    + "NOMBRE_EMPRESA VARCHAR(80) NOT NULL, "
                    + "SECTOR VARCHAR(40) NOT NULL, "
                    + "LOCALIDAD VARCHAR(50) NOT NULL,"
                    + "PRIMARY KEY(DNI),"
                    + "FOREIGN KEY (DNI) REFERENCES USUARIOS (DNI)"
                    + " ON DELETE CASCADE"
                    + " ON UPDATE CASCADE"
                    + ")");
            Sentencia.execute("CREATE TABLE IF NOT EXISTS ANUNCIO("//si
                    + "ID_ANUNCIO INT(2) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, "
                    + "TITULO VARCHAR(40) NOT NULL,"
                    + "DESCRIPCION VARCHAR(200) NOT NULL,"
                    + "VACANTES INT(2) NOT NULL, "
                    + "LOCALIDAD VARCHAR(50) NOT NULL,"
                    + "FECHA DATE NOT NULL,"
                    + "SALARIO FLOAT(4) NOT NULL,"
                    + "DNI_EMPRESARIO CHAR(9) NOT NULL,"
                    + "PRIMARY KEY(ID_ANUNCIO),"
                    + "FOREIGN KEY (DNI_EMPRESARIO) REFERENCES EMPRESARIO(DNI)"
                    + " ON DELETE CASCADE"
                    + " ON UPDATE CASCADE"
                    + ")");

            Sentencia.execute("CREATE TABLE IF NOT EXISTS CURRICULUM("//si
                    + "ID_CURRICULUM INT(2) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, "
                    + "EXPERIENCIA VARCHAR(400) NOT NULL, "
                    + "PERMISO_COCHE BIT NOT NULL,"//0 = FALSE | 1 =  TRUE
                    + "PRIMARY KEY(ID_CURRICULUM)"
                    + ")");

            Sentencia.execute("CREATE TABLE IF NOT EXISTS CANDIDATO("
                    + "DNI CHAR(9)  NOT NULL, "
                    + "FECHA_NAC DATE NOT NULL, "
                    + "SEXO ENUM('HOMBRE','MUJER') NOT NULL, "
                    + "ID_CURRICULUM INT(2) UNSIGNED ZEROFILL , "
                    + "PRIMARY KEY (DNI), "
                    + "FOREIGN KEY (DNI) REFERENCES USUARIOS (DNI)"
                    + " ON DELETE CASCADE"
                    + " ON UPDATE CASCADE,"
                    + "FOREIGN KEY (ID_CURRICULUM) REFERENCES CURRICULUM (ID_CURRICULUM)"
                    + " ON DELETE CASCADE"
                    + " ON UPDATE CASCADE "
                    + ")");
           
            Sentencia.execute("CREATE TABLE IF NOT EXISTS FORMACION("//si
                    + "ID_FORMACION INT(2) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,"
                    + "ESTUDIO VARCHAR(30) NOT NULL,"
                    + "PRIMARY KEY (ID_FORMACION)"
                    + ")");
            Sentencia.execute("CREATE TABLE IF NOT EXISTS CURRIUCULUM_FORMACION("//si
                    + "FORMACION INT(2) UNSIGNED ZEROFILL NOT NULL,"
                    + "CURRICULUM INT(2) UNSIGNED ZEROFILL NOT NULL,"
                    + "PRIMARY KEY(FORMACION,CURRICULUM),"
                    + "FOREIGN KEY (FORMACION) REFERENCES FORMACION (ID_FORMACION)"
                    + " ON DELETE CASCADE"
                    + " ON UPDATE CASCADE,"
                    + "FOREIGN KEY (CURRICULUM) REFERENCES CURRICULUM (ID_CURRICULUM)"
                    + " ON DELETE CASCADE"
                    + " ON UPDATE CASCADE)");
            Sentencia.execute("CREATE TABLE IF NOT EXISTS ANUNCIO_FORMACION("//si
                    + "ANUNCIO INT(2) UNSIGNED ZEROFILL NOT NULL,"
                    + "FORMACION INT(2) UNSIGNED ZEROFILL NOT NULL,"
                    + "PRIMARY KEY (ANUNCIO,FORMACION),"
                    + "FOREIGN KEY (ANUNCIO) REFERENCES ANUNCIO (ID_ANUNCIO)"
                    + " ON DELETE CASCADE"
                    + " ON UPDATE CASCADE,"
                    + "FOREIGN KEY (FORMACION) REFERENCES FORMACION (ID_FORMACION)"
                    + " ON DELETE CASCADE"
                    + " ON UPDATE CASCADE)");
            Sentencia.execute("CREATE TABLE IF NOT EXISTS ANUNCIO_CANDIDATO("
                    + "ANUNCIO INT(2) UNSIGNED ZEROFILL NOT NULL,"
                    + "CANDIDATO CHAR(9) NOT NULL,"
                    + "FOREIGN KEY (ANUNCIO) REFERENCES ANUNCIO(ID_ANUNCIO)"
                    + " ON DELETE CASCADE"
                    + " ON UPDATE CASCADE,"
                    + "FOREIGN KEY (CANDIDATO) REFERENCES CANDIDATO (DNI)"
                    + " ON DELETE CASCADE"
                    + " ON UPDATE CASCADE)");
*/
            db.createCollection("usuarios");
            db.createCollection("empresarios");
            db.createCollection("candidatos");
            db.createCollection("anuncios");
            db.createCollection("curriculums");
            db.createCollection("formaciones");
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
