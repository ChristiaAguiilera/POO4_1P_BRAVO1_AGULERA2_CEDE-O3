package com.poo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.poo.Enums.*;
import com.poo.Enums.Tipo;
import com.poo.Usuario.Usuario;

public class Sistema {
    private ArrayList<Usuario> listaUsuario;
    private static ArrayList<Espacio> listaEspacio=new ArrayList<>();
    private ArrayList<Reserva> listaReserva;
    public static void main (String[] args){
        Scanner sc=new Scanner(System.in);
        cargarEspaciosDesdeArchivo("src/main/java/com/poo/Archivos/Espacios.txt");
        System.out.println("Bienvendio al sistema , Ingrese su usario y contraseña: ");
        System.out.println("Usario: ");
        String usuario= sc.nextLine();
        System.out.println("Contraseña: ");
        String contraseña= sc.nextLine();
    }
    public static void mostrar_menu(){
        System.out.println("Seleccione una de las opciones: ");
        System.out.println("1...Reservar");
        System.out.println("2...Consultar reserva");
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
                Rol rol = Rol.valueOf(datos[5].trim());
                // Crear y agregar espacio a la lista
              Espacio espacio = new Espacio(codigo, tipo, nombre, capacidad, estado, rol);
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
                                   ", Rol: " + espacio.getRol());
                hayDisponibles = true;
            }
        }
        if (!hayDisponibles) {
            System.out.println("No hay espacios disponibles en este momento.");
        }
        System.out.println("---------------------------------");
    }
    public static void CargarUsuarios(String Archivo){
        try (BufferedReader br = new BufferedReader(new FileReader(Archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");
                int codigo = Integer.parseInt(datos[0].trim());
                String cedula=datos[0].trim();
            }

    }catch(IOException e){
        e.printStackTrace();
   
}
}
}


