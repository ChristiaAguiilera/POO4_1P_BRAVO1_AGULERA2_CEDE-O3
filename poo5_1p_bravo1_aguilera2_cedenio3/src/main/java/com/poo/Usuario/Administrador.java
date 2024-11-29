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

    public void reservar(){

    }
    public void CambiarReserva(){

    }

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
