package com.poo.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import io.github.cdimascio.dotenv.*;
import java.util.Properties;

import com.poo.Espacio;
import com.poo.Sistema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public abstract class Usuario {
    private int codigo;
    private int cedula;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasena;
    private String correo;
    private String rol;
    private Administrador administrador;
    private Espacio espacio;

    public Usuario(int codigo, int cedula, String nombre, String apellido, 
                    String usuario, String contrasena, String correo, String rol){
        this.codigo=codigo;
        this.cedula=cedula;
        this.nombre=nombre;
        this.apellido=apellido;
        this.contrasena=contrasena;
        this.usuario = usuario;
    }

    //metodos
    public void reservar(){
    }

    public void consultar_reserva(){

    }

    public void enviar_correo(Date fecha){
        Dotenv dot = Dotenv.load(); 
        String host = dot.get("MAIL_HOST");
        String port = dot.get("MAIL_PORT");
        String user = dot.get("MAIL_USER");
        String pass = dot.get("MAIL_PASS");

        Properties prop = new Properties();
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", port);
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", true); // Usar STARTTLS
        prop.put("mail.smtp.ssl.trust", host); // Confiar en el host
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2"); // Forzar TLSv1.2
        
        // Crear sesión
        Session session = Session.getInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(user, pass);
            }
        });

        Scanner sc = new Scanner(System.in);
        System.out.println("Deseas reservar una cancha o un aula?");
        String decision = sc.nextLine();
        ArrayList<String> lineas = LeeFichero("Espacio.txt");
        
        if (decision.toUpperCase() == "CANCHA"){
            System.out.println("Las canchas disponibles son las siguientes: ");
            for(int i = 0; i < lineas.size(); i++){
                String[] palabras = lineas.get(i).split("|");
                if(palabras[4] != "RESERVADO" & palabras[1] == "CANCHA"){
                  System.out.println(palabras[2]+" - "+palabras[3]);
                }
            }
            System.out.println("Ingrese el nombre de la cancha que desee: ");
            String nombre = sc.nextLine();
            System.out.println("Deseas crear la reserva?");
            String respuesta = sc.nextLine();
            if(respuesta.toUpperCase().equals("SI")){
                try {
                    Message mes = new MimeMessage(session);             
                    mes.setFrom(new InternetAddress(user, "Reserva Estudiante")); 
                    mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse(administrador.getCorreo()));
                    mes.setSubject("Reserva realizada");
                    mes.setText("El estudiante"+ getNombre()+ " y " + getApellido() + " ha realizado una reservación con codigo "+ 
                        getCodigo()+" para la fecha"+ fecha+ " en la cancha" + nombre + ". Ingrese al sistema para aprobar o rechazar." );
                    Transport.send(mes);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }else{
                Sistema.mostrar_menu();
            }
            
            
        }else if(decision.toUpperCase() == "AULA"){
            System.out.println("Las aulas disponibles son las siguientes: ");
            for(int i = 0; i < lineas.size(); i++){
                String[] palabras = lineas.get(i).split("|");
                if(palabras[4] != "RESERVADO" & palabras[1] == "AULA"){
                  System.out.println(palabras[2]+" - "+palabras[3]);
                }
            }
            System.out.println("Ingrese el nombre del aula que desee: ");
            String nombre = sc.nextLine();
            System.out.println("Deseas crear la reserva?");
            String respuesta = sc.nextLine();
            if(respuesta.toUpperCase().equals("SI")){
                try {
                    Message mes = new MimeMessage(session);             
                    mes.setFrom(new InternetAddress(user, "Reserva Estudiante")); 
                    mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse(administrador.getCorreo()));
                    mes.setSubject("Reserva realizada");
                    mes.setText("El estudiante"+ getNombre()+ " y " + getApellido() + " ha realizado una reservación con codigo "+ 
                        getCodigo()+" para la fecha"+ fecha+ " en el aula" + nombre + ". Ingrese al sistema para aprobar o rechazar." );
                    Transport.send(mes);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                
            }else{
                Sistema.mostrar_menu();
            }
            
        }else{
            System.out.println("No valido vuelva a intentarlo");
        }
    }
    
    public void enviar_correo(String materia){

        
    }

    public static ArrayList<String> LeeFichero(String nombrearchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo,StandardCharsets.UTF_8);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                lineas.add(linea);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
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

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    

}
