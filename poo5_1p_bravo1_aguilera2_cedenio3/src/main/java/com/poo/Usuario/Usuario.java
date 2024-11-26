package com.poo.Usuario;

import java.util.Date;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import io.github.cdimascio.dotenv.*;
import java.util.Properties;

public abstract class Usuario {
    private int codigo;
    private int cedula;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasena;
    private String correo;
    private String rol;

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
    public void enviar_correo(){

    }
    public void enviar_correo(String materia){
        
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
