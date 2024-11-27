package com.poo.Usuario;

import java.util.Date;

public class Estudiante extends Usuario {
    private int numMatricula;
    private String carrera;


    public Estudiante(int codigo, String cedula, String nombre, String apellido, String usuario, 
                        String contrasena, String correo, int numMatricula, String carrera) {
        super(codigo, cedula, nombre, apellido, usuario, contrasena, correo, "ESTUDIANTE");
        this.numMatricula = numMatricula;
        this.carrera = carrera;

    }
    
    public void reservar(Date fecha) {
        enviar_correo(fecha);
        
    }

    public int getNumMatricula(){
        return numMatricula;
    }

    public void setNumMatricula(int numMatricula){
        this.numMatricula = numMatricula;
    }

    public String Carrera(){
        return carrera;
    }

    public void setCarrera(String carrera){
        this.carrera = carrera;
    }
}