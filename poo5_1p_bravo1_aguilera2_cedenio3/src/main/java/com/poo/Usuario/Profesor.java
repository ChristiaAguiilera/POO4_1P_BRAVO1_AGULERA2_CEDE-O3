package com.poo.Usuario;

import java.util.ArrayList;

public class Profesor extends Usuario {
    // Atributos específicos
    private String facultad;
    private ArrayList<String> listaMaterias; // Lista de materias que imparte el profesor

    // Constructor
    public Profesor(int codigo, String cedula, String nombre, String apellido, String usuario, String contrasena, 
                    String correo, String rol, String facultad, ArrayList<String> listaMaterias) {
        super(codigo, cedula, nombre, apellido, usuario, contrasena, correo, "PROFESOR"); 
        this.facultad = facultad;
        this.listaMaterias = listaMaterias;
    }
    // Getters y Setters
    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public ArrayList<String> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(ArrayList<String> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    // Métodos específicos
    public void reservar(String materia) {
        if (listaMaterias.contains(materia)) {
            System.out.println("Reserva realizada por el profesor: " + getNombre() + " para la materia: " + materia);
            
        } else {
            System.out.println("Error: La materia '" + materia + "' no está asociada al profesor.");
        }
    }

    public void consultar_reserva() {
        System.out.println("Consultando reservas realizadas por el profesor: " + getNombre());
    }

    @Override
    public String toString() {
        return "Profesor {" +
                "Código: " + getCodigo() +
                ", Nombre: " + getNombre() + " " + getApellido() +
                ", Facultad: " + facultad +
                ", Materias: " + listaMaterias +
                "}";
    }

   
}
