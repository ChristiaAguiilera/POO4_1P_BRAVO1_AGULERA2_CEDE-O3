package com.poo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

import com.poo.Enums.*;
import com.poo.Usuario.*;



public class Sistema {

    public static Scanner sc=new Scanner(System.in);
    private static ArrayList<Usuario> listaUsuario;
    private static ArrayList<Usuario> listaAdministradores;
    public static ArrayList<Espacio> listaEspacio=new ArrayList<>();
    private ArrayList<Reserva> listaReserva;
    static Usuario usuario;

    
    public static void main (String[] args){
        
        cargarEspaciosDesdeArchivo("src/main/java/com/poo/Archivos/Espacios.txt");
        CargarAdministradoresDesdeArchivo("src/main/java/com/poo/Archivos/Administradores.txt");
        CargarUsuariosDesdeArchivo("src/main/java/com/poo/Archivos/Usuarios.txt");
        actualizarEstudiantes();
        actualizarProfesores();


        System.out.println("Bienvendio al sistema , Ingrese su usario y contraseña: ");
        System.out.println("Usuario: ");
        String usuario=sc.nextLine();
        System.out.println("Contraseña: ");
        String contraseña= sc.nextLine();
        for(Usuario u: listaUsuario){
            if(usuario.equals(u.getUsuario())&&contraseña.equals(u.getContrasena())) Sistema.usuario = u;
        }
    }


    public static void mostrar_menu(){
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Seleccione una de las opciones: ");
            System.out.println("0...Salir");
            System.out.println("1...Reservar");
            System.out.println("2...Consultar reserva");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    usuario.reservar(new Date());
                    break;
                case 2:
                    usuario.ConsultarReserva();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

            System.out.println(); // Espaciado para legibilidad
        } while (opcion != 0);

        scanner.close();
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

    public static void CargarUsuariosDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");
                int codigo = Integer.parseInt(datos[0].trim());
                String cedula = datos[1].trim();
                String nombre = datos[2].trim();
                String apellido = datos[3].trim();
                String usuario = datos[4].trim();
                String contrasena = datos[5].trim();
                String correo = datos[6].trim();
                Rol rol = Rol.valueOf(datos[7].trim());
                // Crear y agregar espacio a la lista
                if (rol.equals(Rol.E)) listaUsuario.add(new Estudiante(codigo, cedula, nombre, apellido, usuario, contrasena, correo, rol, 0, ""));
                if (rol.equals(Rol.P)) listaUsuario.add(new Profesor(codigo, cedula, nombre, apellido, usuario, contrasena, correo, rol, "", new ArrayList<>()));
                if (rol.equals(Rol.A)) listaUsuario.add(new Administrador(codigo, cedula, nombre, apellido, usuario, contrasena, correo, rol, Cargo.ANALISTA));
            }
            System.out.println("Usuarios cargados exitosamente desde el archivo.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error en el formato del archivo: " + e.getMessage());
        }
    }

    public static void CargarAdministradoresDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");
                int codigo = Integer.parseInt(datos[0].trim());
                String cedula = datos[1].trim();
                String nombre = datos[2].trim();
                String apellido = datos[3].trim();
                String cargo = datos[4].trim();
                
                listaAdministradores.add(new Administrador(codigo, cedula, nombre, apellido, "", "", "", Rol.A, Cargo.valueOf(cargo)));
            }
            
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error en el formato del archivo: " + e.getMessage());
        }
    }

    public static void actualizarEstudiantes(){
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/poo/Archivos/Estudiante.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                int codigo = Integer.parseInt(linea.split("\\|")[0]);
                for(Usuario u:listaUsuario){
                    if (codigo==u.getCodigo()){
                        listaUsuario.remove(u);
                        Estudiante temp=(Estudiante) u;
                        temp.setNumMatricula(Integer.valueOf(linea.split("\\|")[4]));
                        temp.setCarrera(linea.split("\\|")[5]);
                        listaUsuario.add(temp);
                    }
                }
                
            }
        }catch(Exception e){
            System.out.println("Error");
        }
    }

    public static void actualizarProfesores(){
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/poo/Archivos/Estudiante.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                int codigo = Integer.parseInt(linea.split("\\|")[0]);
                for(Usuario u:listaUsuario){
                    if (codigo==u.getCodigo()){
                        listaUsuario.remove(u);
                        Profesor temp=(Profesor) u;
                        temp.setFacultad(linea.split("\\|")[4]);
                        String []amaterias=linea.split("\\|")[5].split(",");
                        ArrayList<String> materias= new ArrayList<>(Arrays.asList(amaterias));
                        temp.setListaMaterias(materias);
                        listaUsuario.add(temp);
                    }
                }
                
            }
        }catch(Exception e){
            System.out.println("Error");
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
    
}


