package com.poo.Usuario;

import java.util.Scanner;
import java.util.Date;
import javax.mail.*;
import io.github.cdimascio.dotenv.*;
import java.util.Properties;

public class Estudiante extends Usuario {
    private int numMatricula;
    private String carrera;

    public Estudiante(int codigo, int cedula, String nombre, String apellido, String usuario, String contrasena, String correo, int numMatricula, String carrera) {
        super(codigo, cedula, nombre, apellido, usuario, contrasena, correo, "ESTUDIANTE");
        this.numMatricula = numMatricula;
        this.carrera = carrera;
    }
    
    public void reservar(Date fecha) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Deseas reservar una cancha o un aula?");
        String decision = sc.nextLine();
        if (decision.toUpperCase() == "CANCHA"){

        }



        
    }

    
}