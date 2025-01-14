// la clase Espacios es una clase estructural para instanciar un objeto espacio. Por ende no es necesario 

package com.poo.codigo_viejo;
 // import java.io.*;
 // import java.util.ArrayList;

import com.poo.Enums.Estado;
import com.poo.Enums.Rol;
import com.poo.Enums.Tipo;

public class Espacio {
    // Atributos
    private int codigo;
    private Tipo tipo;
    private String nombre;
    private int capacidad;
    private Estado estado;
    private Rol Rol;

    // Constructor
    public Espacio(int codigo, Tipo tipo, String nombre, int capacidad, Estado estado, Rol rol) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.estado = estado;
        this.Rol = rol;
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

    public Rol getRol() {
        return Rol;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

/**
 * Devuelve una representación en cadena de texto del espacio.
 * @return Una cadena que representa todos los detalles del espacio en un formato legible, 
 *         con la siguiente información:
 *         - Código único del espacio
 *         - Tipo de espacio (por ejemplo, aula, cancha, laboratorio, etc.)
 *         - Nombre del espacio
 *         - Capacidad del espacio
 *         - Estado del espacio (por ejemplo, disponible, reservado)
 *         - Permiso asociado al rol (por ejemplo, un rol de usuario como "Administrador" o "Profesor").
 */

    @Override
    public String toString() {
        return "Espacio [codigo=" + codigo + ", tipo=" + tipo + ", nombre=" + nombre + ", capacidad=" + capacidad
                + ", estado=" + estado + ", permiso=" +Rol+ "]";
    }
}


