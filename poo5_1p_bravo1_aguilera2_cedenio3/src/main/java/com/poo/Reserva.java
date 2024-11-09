package com.poo;

import java.util.Date;

public class Reserva {
    private int codigo;
    private Date fecha;
    private ESTADO tipo_reserva;
    private TIPO tipo_espacio;
    private String nombre;
    private int capacidad;
    private Usuario nombre_user;
    public static int numeroReservas;

    public void consultar(Date fecha){

    }

    public void mostrar_datos_reserva(){

    }

    public void consultar_reserva(Usuario rol){

    }

    public int getCodigo(){
        return codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public Date getFecha(){
        return fecha;
    }

    public void setFecha(Date fecha){
        this.fecha = fecha;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(Sting nombre){
        this.nombre = nombre;
    }

    public int getCapacidad(){
        return capacidad;
    }

    public void setCapacidad(int capacidad){
        this.capacidad = capacidad;
    }

    public Usuario getUsuario(){
        return Usuario;
    }
}
