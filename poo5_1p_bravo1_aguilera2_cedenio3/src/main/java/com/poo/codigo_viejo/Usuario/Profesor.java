//La clase Profesor usa uno de los pilares de la programacion orientada a objetos que es la herencia. 

package com.poo.Usuario;

import com.poo.Enums.*;
import com.poo.codigo_viejo.Espacio;
import com.poo.codigo_viejo.Reserva;
import com.poo.codigo_viejo.Sistema;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Profesor extends Usuario {
    // Atributos específicos
    private String facultad;
    private ArrayList<String> listaMaterias; // Lista de materias que imparte el profesor

    // Constructor
    public Profesor(int codigo, String cedula, String nombre, String apellido, String usuario, String contrasena,
            String correo, String facultad, ArrayList<String> listaMaterias) {
        super(codigo, cedula, nombre, apellido, usuario, contrasena, correo, Rol.PROFESOR);

        this.facultad = facultad;
        this.listaMaterias = listaMaterias;
    }

    /**
     * Permite realizar una reserva para un aula, laboratorio o auditorio.
     * 
     * @param materia la materia asociada con la reserva.
     */
    // Métodos específicos
    public void reservar(String materia) {
        Espacio espacio_reser = null;
        Scanner sc = new Scanner(System.in);
        for (Espacio espacio : Sistema.listaEspacio) {
            if (espacio.getTipo() == Tipo.AULA || espacio.getTipo() == Tipo.LABORATORIO
                    || espacio.getTipo() == Tipo.AUDITORIO && espacio.getEstado() == Estado.DISPONIBLE) {
                System.out.println("-" + espacio.getNombre());
            }
        }
        System.out.println("Escriba el espacio q quiere reservar(Aula, Laboratorio, Auditorio)"); // SOlicita input
                                                                                                   // para tipo de
                                                                                                   // espacio
        String decision = sc.nextLine();
        System.out.println("Ingrese el nombre del aula, laboratorio o auditorio: ");
        String nombre = sc.nextLine();
        for (Espacio espacio : Sistema.listaEspacio) {
            if (espacio.getTipo() == Tipo.AULA || espacio.getTipo() == Tipo.LABORATORIO
                    || espacio.getTipo() == Tipo.AUDITORIO && espacio.getEstado() == Estado.DISPONIBLE) {
                espacio_reser = espacio;
                espacio.setEstado(Estado.RESERVADO);
            }
        }
        System.out.println("Deseas crear la reserva?");
        String respuesta = sc.nextLine();
        System.out.println("Ingrese la fecha: (28/11/2024) "); // SE pide fecha
        Date date = null;
        try {
            date = Sistema.getDateFromString(sc.nextLine()); // Se procesa la fecha
        } catch (Exception a) {
            a.printStackTrace();
        }
        ;
        if (respuesta.toUpperCase().equals("SI")) {
            enviar_correo(materia, nombre, decision);
            int codigo = ThreadLocalRandom.current().nextInt(1000, 10000);
            Reserva r = new Reserva(codigo, this.getCodigo(), this.getCedula(), date, nombre, Estado.PENDIENTE,
                    Tipo.CANCHA, this, espacio_reser.getCapacidad(), "Clases de " + materia);
            Sistema.listaReserva.add(r);
        } else {
            Sistema.mostrar_menu(this);
        }
        sc.close();
    }

    /**
     * Devuelve una representación en forma de cadena del objeto `Profesor`.
     * 
     * @return una cadena que representa el objeto `Profesor` con sus atributos
     *         clave.
     */

    @Override
    public String toString() {
        return "Profesor {" +
                "Código: " + getCodigo() +
                ", Nombre: " + getNombre() + " " + getApellido() +
                ", Facultad: " + facultad +
                ", Materias: " + listaMaterias +
                "}";
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

    @Override
    public void reservar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reservar'");
    }

}
