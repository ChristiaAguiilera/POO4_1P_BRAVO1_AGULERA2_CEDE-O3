package com.poo.Usuario;

import java.util.Scanner;
import java.util.Date;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.poo.Espacio;

import io.github.cdimascio.dotenv.*;
import java.util.Properties;

public class Estudiante extends Usuario {
    private int numMatricula;
    private String carrera;
    private Espacio espacio;
    Administrador administrador;

    public Estudiante(int codigo, int cedula, String nombre, String apellido, String usuario, 
                        String contrasena, String correo, int numMatricula, String carrera, 
                        Espacio espacio, Administrador administrador) {
        super(codigo, cedula, nombre, apellido, usuario, contrasena, correo, "ESTUDIANTE");
        this.numMatricula = numMatricula;
        this.carrera = carrera;
        this.espacio = espacio;
        this.administrador = administrador;
    }
    
    public void reservar(Date fecha) {
        
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

        if (decision.toUpperCase() == "CANCHA"){
            try {
            Message mes = new MimeMessage(session);             
            mes.setFrom(new InternetAddress(user, "Reserva Estudiante")); 
            mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse(administrador.getCorreo()));
            mes.setSubject("Reserva realizada");
            mes.setText("El estudiante"+ getNombre()+ " y " + getApellido() + " ha realizado una reservación con codigo "+ 
                getCodigo()+" para la fecha"+ fecha+ " en la cancha" + espacio.getNombre() + ". Ingrese al sistema para aprobar o rechazar." );
            Transport.send(mes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        }else if(decision.toUpperCase() == "AULA"){
            try {
                Message mes = new MimeMessage(session);             
                mes.setFrom(new InternetAddress(user, "Reserva Estudiante")); 
                mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse(administrador.getCorreo()));
                mes.setSubject("Reserva realizada");
                mes.setText("El estudiante"+ getNombre()+ " y " + getApellido() + " ha realizado una reservación con codigo "+ 
                    getCodigo()+" para la fecha"+ fecha+ " en el aula" + espacio.getNombre() + ". Ingrese al sistema para aprobar o rechazar." );
                Transport.send(mes);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }



        
    }

    
}