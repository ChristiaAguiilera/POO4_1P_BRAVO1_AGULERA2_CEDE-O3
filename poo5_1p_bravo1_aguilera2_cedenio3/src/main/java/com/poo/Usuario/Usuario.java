package com.poo.Usuario;

import java.util.Date;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import io.github.cdimascio.dotenv.Dotenv;

import com.poo.Enums.Estado;
import com.poo.Enums.Rol;

public class Usuario {
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
    public Usuario(int codigo, String cedula, String nombre, String apellido, String usuario, String contrasena,
            String correo, Rol rol) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.usuario = usuario;
        this.rol = rol;
        this.correo = correo;
    }

    // Metodo de enviar correo para estudiantes
    public void enviar_correo(Date fecha, String nombre, String decision) {
        // Se instancia el dotenv lo que sirve para poder enviar el correo
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
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        // Se verifica si son canchas o aulas
        if (decision.toUpperCase().equals("CANCHA") == true) {
            // Se envia el correo al administrador
            try {
                Message mes = new MimeMessage(session);
                mes.setFrom(new InternetAddress(user, "Reserva Estudiante"));
                mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse("riicte@gmail.com"));
                mes.setSubject("Reserva realizada");
                mes.setText("El estudiante" + getNombre() + getApellido()
                        + " ha realizado una reservación con codigo " +
                        getCodigo() + " para la fecha " + fecha + " en la cancha" + nombre
                        + ". Ingrese al sistema para aprobar o rechazar.");
                Transport.send(mes);
                System.out.println("Mensaje enviado");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else if (decision.toUpperCase().equals("AULA") == true) {
            // Se envia el correo al administrador
            try {
                Message mes = new MimeMessage(session);
                mes.setFrom(new InternetAddress(user, "Reserva Estudiante"));
                mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse("riicte@gmail.com"));
                mes.setSubject("Reserva realizada");
                mes.setText("El estudiante" + getNombre() + getApellido()
                        + " ha realizado una reservación con codigo " +
                        getCodigo() + " para la fecha " + fecha + " en el aula" + nombre
                        + ". Ingrese al sistema para aprobar o rechazar.");
                Transport.send(mes);
                System.out.println("Mensaje enviado");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Envía un correo de notificación al administrador dependiendo del tipo de
     * espacio reservado (aula, laboratorio o auditorio).
     * 
     * @param materia  la materia asociada a la reserva.
     * @param nombre   el nombre del espacio reservado (por ejemplo, "Aula 101").
     * @param decision el tipo de espacio reservado ("AULA", "LABORATORIO" o
     *                 "AUDITORIO").
     */

    // Metodo enviar correo para profesores
    public void enviar_correo(String materia, String nombre, String decision) {
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
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        // Se verifica que tipo de espacio elegio
        if (decision.toUpperCase().equals("AULA") == true) {
            // Se envia el correo al administrador
            try {
                Message mes = new MimeMessage(session);
                mes.setFrom(new InternetAddress(user, "Reserva Profesor"));
                mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse("riicte@gmail.com"));
                mes.setSubject("Reserva realizada");
                mes.setText("Se le notifica que el profesor " + getNombre() + getApellido()
                        + " ha realizado una reserva con códigov" + getCodigo() + " en el aula " + nombre
                        + " para la materia " + materia);
                Transport.send(mes);
                System.out.println("Mensaje enviado");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else if (decision.toUpperCase().equals("LABORATORIO") == true) {
            // Se envia el correo al administrador
            try {
                Message mes = new MimeMessage(session);
                mes.setFrom(new InternetAddress(user, "Reserva Profesor"));
                mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse("riicte@gmail.com"));
                mes.setSubject("Reserva realizada");
                mes.setText("Se le notifica que el profesor " + getNombre() + getApellido()
                        + " ha realizado una reserva con códigov" + getCodigo() + " en el laboratorio " + nombre
                        + " para la materia " + materia);
                Transport.send(mes);
                System.out.println("Mensaje enviado");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else if (decision.toUpperCase().equals("AUDITORIO") == true) {
            // Se envia el correo al administrador
            try {
                Message mes = new MimeMessage(session);
                mes.setFrom(new InternetAddress(user, "Reserva Profesor"));
                mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse("riicte@gmail.com"));
                mes.setSubject("Reserva realizada");
                mes.setText("Se le notifica que el profesor " + getNombre() + getApellido()
                        + " ha realizado una reserva con código " + getCodigo() + " en el auditorio " + nombre
                        + " para la materia " + materia);
                Transport.send(mes);
                System.out.println("Mensaje enviado");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Enviar correo por parte del administrador
    public void enviar_correo(Estado estado, String motivo) {
        // Se instancia el dotenv lo que sirve para poder enviar el correo
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
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        // Se verifica si son canchas o aulas
        if (estado.equals(Estado.RECHAZADO) == true) {
            // Se envia el correo al administrador
            try {
                Message mes = new MimeMessage(session);
                mes.setFrom(new InternetAddress(user, "Reserva Estudiante"));
                mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse("riicte@gmail.com"));
                mes.setSubject("Reserva rechazada");
                mes.setText(
                        "Se ha rechazado su reserva con codigo " + getCodigo() + "por el siguiente motivo: " + motivo);
                Transport.send(mes);
                System.out.println("Mensaje enviado");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else if (estado.equals(Estado.APROBADO) == true) {
            // Se envia el correo al administrador
            try {
                Message mes = new MimeMessage(session);
                mes.setFrom(new InternetAddress(user, "Reserva Estudiante"));
                mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse("riicte@gmail.com"));
                mes.setSubject("Reserva aprovada");
                mes.setText("Se ha aprovado la reserva con codigo " + getCodigo());
                Transport.send(mes);
                System.out.println("Mensaje enviado");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
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
