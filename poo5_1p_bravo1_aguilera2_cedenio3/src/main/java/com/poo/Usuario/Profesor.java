//La clase Profesor usa uno de los pilares de la programacion orientada a objetos que es la herencia. 


package com.poo.Usuario;
import com.poo.Espacio;
import com.poo.Reserva;
import com.poo.Sistema;
import com.poo.Enums.*;

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
     * @param materia la materia asociada con la reserva.
     */
    // Métodos específicos
    public void reservar(String materia) {
        Espacio espacio_reser=null;
        Scanner sc = new Scanner(System.in);     
        
        System.out.println("Deseas reserar un aula, laboratorio o auditorio?"); //SOlicita input para tipo de espacio
            String decision = sc.nextLine();
            if (decision.toUpperCase().equals("AULA")==true) {
                System.out.println("Las aulas disponibles son las siguientes: ");
                for(Espacio espacio: Sistema.listaEspacio){
                    if(espacio.getTipo()==Tipo.AULA && espacio.getEstado()==Estado.DISPONIBLE){
                        System.out.println(espacio.getNombre());
                    }
                }
                System.out.println("Ingrese el nombre del aula que desee: ");
                String nombre = sc.nextLine();
                //Para poder encontrar el aula por su nombre 
                for(Espacio espacio: Sistema.listaEspacio){
                    if(espacio.getTipo()==Tipo.AULA && espacio.getEstado()==Estado.DISPONIBLE){
                        if(espacio.getNombre().equals(nombre)==true){
                            espacio_reser=espacio;
                            espacio.setEstado(Estado.RESERVADO);
                        }
                    }
                }    
                System.out.println("Deseas crear la reserva?");
                String respuesta = sc.nextLine();
                if (respuesta.toUpperCase().equals("SI")) {
                    System.out.println("Ingrese la fecha (28/11/2024):  "); //Se pide fecha
                    Date date=null;
                    try{
                        date = Sistema.getDateFromString(sc.nextLine()); //Se procesa la fecha
                    }catch (Exception a){
                    a.printStackTrace();
                    };
                    int codigo = ThreadLocalRandom.current().nextInt(1000, 10000);
                    Reserva r= new Reserva(codigo,this.getCodigo(),this.getCedula(),date, nombre, Estado.PENDIENTE, Tipo.CANCHA, this, espacio_reser.getCapacidad(),materia);
                    Sistema.listaReserva.add(r);
                    enviar_correo(date, nombre, decision);
                } else {
                    System.out.println("Volviendo al menu");
                }  

            } else if (decision.toUpperCase().equals("LABORATORIO")==true) {
                System.out.println("Los laboratorios disponibles son los siguientes: ");
                for(Espacio espacio: Sistema.listaEspacio){
                    if(espacio.getTipo()==Tipo.AULA && espacio.getEstado()==Estado.DISPONIBLE){
                        System.out.println(espacio.getNombre());
                    }
                }
                System.out.println("Ingrese el nombre del laboratorio que desea: ");
                String nombre = sc.nextLine();
                //Para poder encontrar el laboratorio por su nombre 
                for(Espacio espacio: Sistema.listaEspacio){
                    if(espacio.getTipo()==Tipo.AULA && espacio.getEstado()==Estado.DISPONIBLE){
                        if(espacio.getNombre().equals(nombre)==true){
                            espacio_reser=espacio;
                            espacio.setEstado(Estado.RESERVADO);
                        }
                    }
                }    
                System.out.println("Deseas crear la reserva?");
                String respuesta = sc.nextLine();
                if (respuesta.toUpperCase().equals("SI")) {
                    System.out.println("Ingrese la fecha (28/11/2024):  "); //Se pide fecha
                    Date date=null;
                    try{
                        date = Sistema.getDateFromString(sc.nextLine()); //Se procesa la fecha
                    }catch (Exception a){
                    a.printStackTrace();
                    };
                    int codigo = ThreadLocalRandom.current().nextInt(1000, 10000);
                    Reserva r= new Reserva(codigo,this.getCodigo(),this.getCedula(),date, nombre, Estado.PENDIENTE, Tipo.CANCHA, this, espacio_reser.getCapacidad(),materia);
                    Sistema.listaReserva.add(r);
                    enviar_correo(date, nombre, decision);
                } else {
                    System.out.println("Volviendo al menu");
                }  


            } else if (decision.toUpperCase().equals("AUDITORIO")==true){
                System.out.println("Los auditorios disponibles son los siguientes: ");
                for(Espacio espacio: Sistema.listaEspacio){
                    if(espacio.getTipo()==Tipo.AULA && espacio.getEstado()==Estado.DISPONIBLE){
                        System.out.println(espacio.getNombre());
                    }
                }
                System.out.println("Ingrese el nombre del auditorio que desea: ");
                String nombre = sc.nextLine();
                //Para poder encontrar el auditorio por su nombre 
                for(Espacio espacio: Sistema.listaEspacio){
                    if(espacio.getTipo()==Tipo.AULA && espacio.getEstado()==Estado.DISPONIBLE){
                        if(espacio.getNombre().equals(nombre)==true){
                            espacio_reser=espacio;
                            espacio.setEstado(Estado.RESERVADO);
                        }
                    }
                }    
                System.out.println("Deseas crear la reserva?");
                String respuesta = sc.nextLine();
                if (respuesta.toUpperCase().equals("SI")) {
                    System.out.println("Ingrese la fecha (28/11/2024):  "); //Se pide fecha
                    Date date=null;
                    try{
                        date = Sistema.getDateFromString(sc.nextLine()); //Se procesa la fecha
                    }catch (Exception a){
                    a.printStackTrace();
                    };
                    int codigo = ThreadLocalRandom.current().nextInt(1000, 10000);
                    Reserva r= new Reserva(codigo,this.getCodigo(),this.getCedula(),date, nombre, Estado.PENDIENTE, Tipo.CANCHA, this, espacio_reser.getCapacidad(),materia);
                    Sistema.listaReserva.add(r);
                    enviar_correo(date, nombre, decision);
                } else {
                    System.out.println("Volviendo al menu");
                }  

            }
            sc.close();
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
