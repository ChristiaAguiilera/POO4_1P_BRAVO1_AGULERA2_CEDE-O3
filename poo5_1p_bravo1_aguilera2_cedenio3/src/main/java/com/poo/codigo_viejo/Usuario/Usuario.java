package com.poo.Usuario;

import javax.mail.*;
import java.util.ArrayList;
import java.util.Date;


// Se importan paquetes para poder enviar el correo
import javax.mail.*;
import io.github.cdimascio.dotenv.*;

import java.util.Properties;

import com.poo.Enums.*;
import com.poo.codigo_viejo.Reserva;
import com.poo.codigo_viejo.Sistema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public abstract class Usuario { // se usa uno de los pilares de la programacion, abstract. 
    private int codigo;
    private String cedula;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasena;
    private String correo;
    private Rol rol;
    private Administrador administrador;
    
    // Constructor
    public Usuario(int codigo, String cedula, String nombre, String apellido, String usuario, String contrasena,String correo, Rol rol) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.usuario = usuario;
        this.rol=rol;
        this.correo=correo;
    }

    // metodos

    /**Método abstracto que define la lógica para realizar una reserva.*/
    public abstract void reservar();

    
    /**
     * Consulta y muestra las reservas realizadas en una fecha específica, es un metodo void por ende no retorna nada.
     * @param date la fecha de la reserva que se desea consultar.
     */
    public void ConsultarReserva(Date date) {
        for(Reserva r: Sistema.listaReserva){
            if(r.getFecha().equals(date)) System.out.println(r.toString());
        }

    }

    /**
     * Envía un correo de notificación al administrador cuando un estudiante realiza una reserva
     * para un espacio específico (cancha o aula) en una fecha determinada.
     * @param fecha    la fecha de la reserva.
     * @param nombre   el nombre del espacio reservado.
     * @param desicion el tipo de espacio reservado ("CANCHA" o "AULA").
     */

    
    /**
     * Lee las líneas de un archivo de texto ubicado en la carpeta de recursos y las devuelve como una lista de cadenas.
     * @param nombreArchivo el nombre del archivo que se desea leer (debe estar ubicado en `resources/Archivos/`).
     * @return una lista de cadenas (`ArrayList<String>`) que contiene todas las líneas del archivo leído.
     *         Si el archivo no se encuentra, devuelve una lista vacía.
     */

    // Metodo para leer archivos
    public static ArrayList<String> LeeFichero(String nombreArchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        InputStream inputStream = null;
        BufferedReader br = null;
        
        try {
            // Usamos ClassLoader para cargar el archivo desde resources
            inputStream = Usuario.class.getClassLoader().getResourceAsStream("Archivos/" + nombreArchivo);

            // Se verfica si se cargo
            if (inputStream == null) {
                System.out.println("El archivo no se encontró en el classpath");
                return lineas; 
            }

            // Creamos el BufferedReader para leer el archivo
            br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                lineas.add(linea);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Aseguramos el cierre del BufferedReader
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return lineas;
    }

    // getteres y setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return this.usuario;
    }

}
