package com.poo;
import java.io.*;
import java.util.ArrayList;

import com.poo.Enums.Estado;
import com.poo.Enums.Tipo;

public class Espacio {
    // Atributos
    private int codigo;
    private Tipo tipo;
    private String nombre;
    private int capacidad;
    private Estado estado;
    private String permiso;

    // Constructor
    public Espacio(int codigo, Tipo tipo, String nombre, int capacidad, Estado estado, String permiso) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.estado = estado;
        this.permiso = permiso;
    }

    // Método para cargar los espacios desde un archivo
    

    // Método para mostrar la disponibilidad de un espacio

    // Método para mostrar los espacios disponibles
    

    public int getCodigo() {
        return codigo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getPermiso() {
        return permiso;
    }

    @Override
    public String toString() {
        return "Espacio [codigo=" + codigo + ", tipo=" + tipo + ", nombre=" + nombre + ", capacidad=" + capacidad
                + ", estado=" + estado + ", permiso=" + permiso + "]";
    }
}


