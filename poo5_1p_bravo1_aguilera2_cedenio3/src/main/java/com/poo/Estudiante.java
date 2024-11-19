package com.poo;
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
    public void reservar(Date fecha) {
        System.out.println("Reservando como estudiante para la fecha: " + fecha);
    }

    @Override
    public void consultarReserva(Date fecha) {
        System.out.println("Consultando reserva como estudiante para la fecha: " + fecha);
    }
}