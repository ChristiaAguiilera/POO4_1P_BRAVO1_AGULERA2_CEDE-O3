//La clase estudiante usa uno de los pilares de la programacion orientada a objetos que es la herencia. 

package com.poo.Usuario;
 import com.poo.Espacio;
import com.poo.Reserva;
// import com.poo.Espacio;
 // import com.poo.Reserva;
import com.poo.Sistema;
import com.poo.Enums.*;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;



public class Estudiante extends Usuario {
    private int numMatricula;
    private String carrera;

    public Estudiante(int codigo, String cedula, String nombre, String apellido, String usuario, String contrasena,
            String correo, int numMatricula, String carrera) {
        super(codigo, cedula, nombre, apellido, usuario, contrasena, correo, Rol.ESTUDIANTE);
        this.numMatricula = numMatricula;
        this.carrera = carrera; 
    }
    public void reservar(Date fecha) { 
        Espacio espacio_reser=null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Deseas reservar una cancha o un aula?");
        String decision = sc.nextLine();
        if (decision.toUpperCase().equals("CANCHA")==true) {
            System.out.println("Las canchas disponibles son las siguientes: ");
            for(Espacio espacio: Sistema.listaEspacio){
                if(espacio.getTipo()==Tipo.CANCHA && espacio.getEstado()==Estado.DISPONIBLE){
                    System.out.println(espacio.getNombre());
                }
            }
            System.out.println("Ingrese el nombre de la cancha que desee: ");
            String nombre = sc.nextLine();
            //Para poder encontrar la cancha por su nombre 
            for(Espacio espacio: Sistema.listaEspacio){
                if(espacio.getTipo()==Tipo.CANCHA && espacio.getEstado()==Estado.DISPONIBLE){
                    if(espacio.getNombre().equals(nombre)==true){
                        espacio_reser=espacio;
                        espacio.setEstado(Estado.RESERVADO);
                    }
                }
            }
            System.out.println("Motivo de uso");
            String motivo = sc.nextLine();     
            System.out.println("Deseas crear la reserva?");
            String respuesta = sc.nextLine();
            if (respuesta.toUpperCase().equals("SI")) {
                enviar_correo(fecha, nombre, decision);
                int codigo = ThreadLocalRandom.current().nextInt(1000, 10000);
                Reserva r= new Reserva(codigo,this.getCodigo(),this.getCedula(),fecha, nombre, Estado.PENDIENTE, Tipo.CANCHA, this, espacio_reser.getCapacidad(),motivo);
                Sistema.listaReserva.add(r);
            } else {
                System.out.println("Volviendo al menu");
            }   
        } else if (decision.toUpperCase().equals("AULA")==true) {
            System.out.println("Las aulas disponibles son las siguientes: ");
            // Se presentan las aulas disponibles
            for(Espacio espacio: Sistema.listaEspacio){
                if(espacio.getTipo()==Tipo.AULA && espacio.getEstado()==Estado.DISPONIBLE){
                    System.out.println(espacio.getNombre());
                }
            }
            System.out.println("Ingrese el nombre del aula que desee: ");
            String nombre = sc.nextLine();
            for(Espacio espacio: Sistema.listaEspacio){
                if(espacio.getTipo()==Tipo.AULA && espacio.getEstado()==Estado.DISPONIBLE){
                    if(espacio.getNombre().equals(nombre)==true){
                        espacio_reser=espacio;
                    }
                }
            }
            System.out.println("Motivo de uso");
            String motivo = sc.nextLine();     
            System.out.println("Deseas crear la reserva?");
            String respuesta = sc.nextLine();
            if (respuesta.toUpperCase().equals("SI")) {
                int codigo = ThreadLocalRandom.current().nextInt(1000, 10000);
                Reserva r= new Reserva(codigo,this.getCodigo(),this.getCedula(),fecha, nombre, Estado.PENDIENTE, Tipo.CANCHA, this, espacio_reser.getCapacidad(),motivo);
                Sistema.listaReserva.add(r);
                enviar_correo(fecha, nombre, decision);
            } else {
                System.out.println("Volviendo al menu");
            }
        } else {
            // Si no inserta un tipo valido se le muestra el menu nuevamente
            System.out.println("No valido vuelva a intentarlo");
            System.out.println("Volviendo al menu");
        }
        sc.close();
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

    @Override
    public String toString() {
        return "Estudiante [numMatricula=" + numMatricula + ", carrera=" + carrera + ", getCodigo()=" + getCodigo()
                + ", getCedula()=" + getCedula() + ", getNombre()=" + getNombre() + ", getApellido()=" + getApellido()
                + ", getContrasena()=" + getContrasena() + ", getCorreo()=" + getCorreo() + ", getRol()=" + getRol()
                + "]";
    }

    @Override
    public void reservar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reservar'");
    }
}