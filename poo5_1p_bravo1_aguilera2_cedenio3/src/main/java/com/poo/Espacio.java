package com.poo;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.poo.Enums.Estado;
import com.poo.Enums.Rol;
import com.poo.Enums.Tipo;

public class Espacio {
    // Atributos
    private int codigo;
    private Tipo tipo;
    private String nombre;
    private int capacidad;
    private Estado estado;
    private Rol rol;

    // Constructor
    public Espacio(int codigo, Tipo tipo, String nombre, int capacidad, Estado estado, Rol rol) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.estado = estado;
        this.rol=rol;
    }

    // Método para cargar los espacios desde un archivo
    public static List<Espacio> leerEspaciosDesdeArchivo() {
        List<Espacio> listaEspacios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(new File("src/main/java/com/poo/Archivos/Espacios.txt")))) {
            String linea;
            // Ignorar la primera línea (cabecera)
            br.readLine();

            while ((linea = br.readLine()) != null) {
                // Separar los atributos por comas
                String[] datos = linea.split("|");

                // Convertir los datos leídos a los atributos del objeto
                int codigo = Integer.parseInt(datos[0].trim());
                Tipo tipo = Tipo.valueOf(datos[1].trim().toUpperCase());
                String nombre = datos[2].trim();
                int capacidad = Integer.parseInt(datos[3].trim());
                Estado estado = Estado.valueOf(datos[4].trim().toUpperCase());
                Rol rol = Rol.valueOf(datos[5].trim().toUpperCase());

                // Crear un nuevo objeto Espacio y agregarlo a la lista
                Espacio espacio = new Espacio(codigo, tipo, nombre, capacidad, estado, rol);
                listaEspacios.add(espacio);
            }
            System.out.println("Espacios leídos exitosamente del archivo.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error en el formato de los datos del archivo: " + e.getMessage());
        }

        return listaEspacios;
    }





    // Método para mostrar la disponibilidad de un espacio
    public void mostrarDisponibilidad() {
        System.out.println("----- Información del Espacio -----");
        System.out.println("Código: " + codigo);
        System.out.println("Tipo: " + tipo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Capacidad: " + capacidad);
        System.out.println("Estado: " + estado);
        System.out.println("ROL: " + rol);
        System.out.println("-----------------------------------");
    }

    // Método para mostrar los espacios disponibles 
    public static void mostrarEspaciosDisponibles(List<Espacio> espacios) {
        for (Espacio espacio : espacios) {
            if (espacio.estado == Estado.DISPONIBLE) {
                espacio.mostrarDisponibilidad();
            }
        }
    }

    

    public int getCodigo() {
        return codigo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Estado getEstado() {
        return estado;
    }

    public Rol getRol() {
        return rol;
    }

    @Override
    public String toString() {
        return "Espacio [codigo=" + codigo + ", tipo=" + tipo + ", nombre=" + nombre + ", capacidad=" + capacidad
                + ", estado=" + estado + ", ROL=" + rol + "]";
    }
}


