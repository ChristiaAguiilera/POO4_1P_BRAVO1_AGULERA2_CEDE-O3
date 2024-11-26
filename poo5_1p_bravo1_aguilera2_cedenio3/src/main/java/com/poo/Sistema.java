package com.poo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.poo.Enums.Estado;
import com.poo.Enums.Tipo;
import com.poo.Usuario.Usuario;

public class Sistema {
    
    private ArrayList<Usuario> listaUsuario;
    private static ArrayList<Espacio> listaEspacio=new ArrayList<>();
    private ArrayList<Reserva> listaReserva;
    public static void main (String[] args){
        cargarEspaciosDesdeArchivo("src/main/java/com/poo/Archivos/Espacios.txt");
    }

    public static void mostrar_menu(){

    }

    public static void mostrar_menu_administrador(){


    }
    public static void cargarEspaciosDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");
                int codigo = Integer.parseInt(datos[0].trim());
                Tipo tipo = Tipo.valueOf(datos[1].trim());
                String nombre = datos[2].trim();
                int capacidad = Integer.parseInt(datos[3].trim());
                Estado estado = Estado.valueOf(datos[4].trim());
                String permiso = datos[5].trim();

                // Crear y agregar espacio a la lista
                Espacio espacio = new Espacio(codigo, tipo, nombre, capacidad, estado, permiso);
                listaEspacio.add(espacio);
            }
            System.out.println("Espacios cargados exitosamente desde el archivo.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error en el formato del archivo: " + e.getMessage());
        }
    }
    public  void mostrar_espacios_disponibles() {
        System.out.println("----- Espacios Disponibles -----");
        boolean hayDisponibles = false;

        for (Espacio espacio : listaEspacio) {
            if (espacio.getEstado() == Estado.DISPONIBLE) {
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
   

}


