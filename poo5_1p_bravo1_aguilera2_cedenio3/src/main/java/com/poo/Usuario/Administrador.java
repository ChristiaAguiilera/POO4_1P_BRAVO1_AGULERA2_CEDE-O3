package com.poo.Usuario;

import com.poo.Enums.Cargo;

public class Administrador extends Usuario{
    private Cargo cargo;

    public Administrador(int codigo, int cedula, String nombre, String apellido, String usuario, 
                                        String contrasena, String correo, String rol, Cargo cargo){
        super(codigo, cedula, nombre, apellido, usuario, contrasena, correo, rol);
        this.cargo = cargo;
    }

    public void reservar(){

    }

    
}
