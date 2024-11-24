package com.poo.Usuario;

public class Administrador extends Usuario{
    private String cargo;

    public Administrador(int codigo, int cedula, String nombre, String apellido, String usuario, String contrasena, String correo, String rol, String cargo){
        super(codigo, cedula, nombre, apellido, usuario, contrasena, correo, rol);
        this.cargo = cargo;
    }

    
    
}
