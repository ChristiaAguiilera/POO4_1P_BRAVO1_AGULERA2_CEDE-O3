package com.poo;

import java.util.Date;


import com.poo.Enums.Estado;
import com.poo.Enums.Tipo;
import com.poo.Usuario.Usuario;

public class Reserva {
    private int codigo;
    private int codigo_usuario;
    private String cedula;
    private Date fecha;
    private Estado estado;
    private Tipo tipo_espacio;
    private String nombre_espacio;
    private int capacidad;
    private Usuario nombre_user;
    private String Motivo_reserva;
    public static int numeroReservas;

    public Reserva(int codigo,int codigo_usuario,String cedula, Date fecha, String nombre, Estado estado, Tipo tipo_espacio, Usuario nombre_user, int capacidad,String motivo){
        this.codigo = codigo;
        this.codigo_usuario=codigo_usuario;
        this.cedula=cedula;
        this.fecha = fecha;
        this.nombre_espacio = nombre;
        this.capacidad = capacidad;
        this.estado = estado;
        this.tipo_espacio = tipo_espacio;
        this.nombre_user = nombre_user;
        this.Motivo_reserva=motivo;
    }
    
    public void consultar(Date fecha){

    }

    public void mostrar_datos_reserva(){

    }

    public void ConsultarReserva(Usuario rol){

    }

    // getters y setters

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

    public Estado getEstado(){
        return estado;
    }

    public void setEstado(Estado estado){
        this.estado = estado;
    }

    public Tipo getTipoEspacio(){
        return tipo_espacio;
    }

    public void setTipoEspacio(Tipo tipo_espacio){
        this.tipo_espacio = tipo_espacio;
    }


    public String getNombreEspacio(){
        return nombre_espacio;
    }

    public void setNombreEspacio(String nombre){
        this.nombre_espacio = nombre;
    }

    public int getCapacidad(){
        return capacidad;
    }

    public void setCapacidad(int capacidad){
        this.capacidad = capacidad;
    }

    public Usuario getUsuario(){
        return nombre_user;
    }

    public void setUsuario(Usuario usuario){
        this.nombre_user = usuario;
    }

    @Override
public String toString() {
    return String.format(
        "Código Único de Reserva: %d | Código Único del Usuario: %d | Cédula del Usuario: %s | Fecha de Reserva: %s | Código Único del Espacio Reservado: %s | Tipo de Espacio: %s | Estado: %s | Motivo de la Reserva: %s",
        codigo, 
        nombre_user.getCodigo(), // Asumiendo que Usuario tiene un método getCodigoUnico
        nombre_user.getCedula(),     // Asumiendo que Usuario tiene un método getCedula
        fecha.toString(), 
        nombre_espacio, 
        tipo_espacio.name(), 
        estado.name(), 
        "Motivo no especificado" // Puedes modificar este campo si tienes una propiedad específica para el motivo
    );
}

}
