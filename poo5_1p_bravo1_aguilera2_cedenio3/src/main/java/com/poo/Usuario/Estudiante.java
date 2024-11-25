package com.poo.Usuario;

import java.util.Scanner;
import java.util.Date;

public class Estudiante extends Usuario {
    private int numMatricula;
    private String carrera;

    public Estudiante(int codigo, int cedula, String nombre, String apellido, String usuario, String contrasena, String correo, int numMatricula, String carrera) {
        super(codigo, cedula, nombre, apellido, usuario, contrasena, correo, "ESTUDIANTE");
        this.numMatricula = numMatricula;
        this.carrera = carrera;
    }

    @Override
    public void reservar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reservar'");
    }
}