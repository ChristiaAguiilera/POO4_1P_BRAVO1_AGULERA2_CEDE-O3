package com.poo.Usuario;

import com.poo.Espacio;
import com.poo.Sistema;
import com.poo.Enums.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Estudiante extends Usuario {
    private int numMatricula;
    private String carrera;

    public Estudiante(int codigo, String cedula, String nombre, String apellido, String usuario, String contrasena,
            String correo, Rol rol, int numMatricula, String carrera) {
        super(codigo, cedula, nombre, apellido, usuario, contrasena, correo, Rol.valueOf("E"));
        this.numMatricula = numMatricula;
        this.carrera = carrera;

    }

    public void reservar(Date fecha) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Deseas reservar una cancha o un aula?");
        String decision = sc.nextLine();
        ArrayList<String> lineas = LeeFichero("Espacio.txt");

        if (decision.toUpperCase() == "CANCHA") {
            System.out.println("Las canchas disponibles son las siguientes: ");
            for (int i = 0; i < lineas.size(); i++) {
                String[] palabras = lineas.get(i).split("|");
                if (palabras[4] != "RESERVADO" & palabras[1] == "CANCHA") {
                    System.out.println(palabras[2] + " - " + palabras[3]);
                }
            }
            System.out.println("Ingrese el nombre de la cancha que desee: ");
            String nombre = sc.nextLine();
            System.out.println("Deseas crear la reserva?");
            String respuesta = sc.nextLine();
            if (respuesta.toUpperCase().equals("SI")) {
                enviar_correo(fecha, nombre, decision);
            } else {
                Sistema.mostrar_menu();
            }
        } else if (decision.toUpperCase() == "AULA") {
            System.out.println("Las aulas disponibles son las siguientes: ");
            // Se presentan las aulas disponibles
            for (int i = 0; i < lineas.size(); i++) {
                String[] palabras = lineas.get(i).split("|");
                if (palabras[4] != "RESERVADO" & palabras[1] == "AULA") {
                    System.out.println(palabras[2] + " - " + palabras[3]);
                }
            }
            System.out.println("Ingrese el nombre del aula que desee: ");
            String nombre = sc.nextLine();
            System.out.println("Deseas crear la reserva?");
            String respuesta = sc.nextLine();
            if (respuesta.toUpperCase().equals("SI")) {
                enviar_correo(fecha, nombre, decision);
            } else {
                Sistema.mostrar_menu();
            }
        } else {
            // Si no inserta un tipo valido se le muestra el menu nuevamente
            System.out.println("No valido vuelva a intentarlo");
            Sistema.mostrar_menu();
        }

        sc.close();

    }

    public void ConsultarReserva() {

    }

    public int getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}