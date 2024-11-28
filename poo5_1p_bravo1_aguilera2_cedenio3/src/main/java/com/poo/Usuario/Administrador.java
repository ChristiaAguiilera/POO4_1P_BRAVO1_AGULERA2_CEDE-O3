package com.poo.Usuario;

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

    }

    public Cargo getCargo(){
        return cargo;
    }

    public void setCargo(Cargo cargo){
        this.cargo = cargo;
    }
}
