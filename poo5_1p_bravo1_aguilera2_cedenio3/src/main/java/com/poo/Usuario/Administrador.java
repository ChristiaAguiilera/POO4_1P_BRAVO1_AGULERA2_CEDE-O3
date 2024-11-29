package com.poo.Usuario;

import com.poo.Reserva;
import com.poo.Sistema;
import com.poo.Enums.*;


public class Administrador extends Usuario{
    private Cargo cargo;

    public Administrador(int codigo, String cedula, String nombre, String apellido, String usuario, String contrasena, String correo, Rol rol, Cargo cargo){
        super(codigo, cedula, nombre, apellido, usuario, contrasena, correo, Rol.valueOf("ADMINISTRADOR"));

        this.cargo = cargo;
    }

    /**
    * Realiza una reserva de un espacio (cancha, aula, laboratorio, etc.) en el sistema.
    */
    public void reservar(){

    }

    /**
     * Cambia los detalles de una reserva existente en el sistema.
     */

    public void CambiarReserva(){
        

    }

    /**
     * Consulta y muestra todas las reservas almacenadas en el sistema.
     */

    public void ConsultarReserva(){
        System.out.println("Numero de reservas: "+Integer.toString(Sistema.listaReserva.size()));
        for (Reserva re: Sistema.listaReserva){
            System.out.println(re.getCodigo()+"-"+re.getEstado()+"-"+re.getUsuario()+"-"+ re.getFecha());
        }
    }
    public Cargo getCargo(){
        return cargo;
    }
    public void setCargo(Cargo cargo){
        this.cargo = cargo;
        
    }
}
