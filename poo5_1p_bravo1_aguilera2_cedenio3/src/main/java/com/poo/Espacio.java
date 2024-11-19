package com.poo;
import java.io.*;
import java.util.ArrayList;

public class Espacio {
    // Atributos
    private int codigo;
    private TIPO tipo;
    private String nombre;
    private int capacidad;
    private ESTADO estado;
    private String permiso;

    // Lista estática para almacenar todos los espacios
    private static ArrayList<Espacio> listaEspacios = new ArrayList<>();

    // Constructor
    public Espacio(int codigo, TIPO tipo, String nombre, int capacidad, ESTADO estado, String permiso) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.estado = estado;
        this.permiso = permiso;
    }

    // Método para cargar los espacios desde un archivo
    public static void cargarEspaciosDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");
                int codigo = Integer.parseInt(datos[0].trim());
                TIPO tipo = TIPO.valueOf(datos[1].trim());
                String nombre = datos[2].trim();
                int capacidad = Integer.parseInt(datos[3].trim());
                ESTADO estado = ESTADO.valueOf(datos[4].trim());
                String permiso = datos[5].trim();

                // Crear y agregar espacio a la lista
                Espacio espacio = new Espacio(codigo, tipo, nombre, capacidad, estado, permiso);
                listaEspacios.add(espacio);
            }
            System.out.println("Espacios cargados exitosamente desde el archivo.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error en el formato del archivo: " + e.getMessage());
        }
    }

    // Método para mostrar la disponibilidad de un espacio
    public void mostrarDisponibilidad() {
        System.out.println("----- Información del Espacio -----");
        System.out.println("Código: " + codigo);
        System.out.println("Tipo: " + tipo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Capacidad: " + capacidad);
        System.out.println("Estado: " + estado);
        System.out.println("Permiso: " + permiso);
        System.out.println("-----------------------------------");
    }

    // Método para mostrar los espacios disponibles
    public static void mostrar_espacios_disponibles() {
        System.out.println("----- Espacios Disponibles -----");
        boolean hayDisponibles = false;

        for (Espacio espacio : listaEspacios) {
            if (espacio.getEstado() == ESTADO.DISPONIBLE) {
                System.out.println("Código: " + espacio.getCodigo() +
                                   ", Tipo: " + espacio.getTipo() +
                                   ", Nombre: " + espacio.getNombre() +
                                   ", Capacidad: " + espacio.getCapacidad() +
                                   ", Permiso: " + espacio.getPermiso());
                hayDisponibles = true;
            }
        }

        if (!hayDisponibles) {
            System.out.println("No hay espacios disponibles en este momento.");
        }
        System.out.println("---------------------------------");
    }

    public int getCodigo() {
        return codigo;
    }

    public TIPO getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public ESTADO getEstado() {
        return estado;
    }

    public String getPermiso() {
        return permiso;
    }
}


