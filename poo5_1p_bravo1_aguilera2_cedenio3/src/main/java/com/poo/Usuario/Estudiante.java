package com.poo.Usuario;

import java.util.Scanner;
import java.util.Date;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import io.github.cdimascio.dotenv.*;
import java.util.Properties;

import com.poo.Espacio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Estudiante extends Usuario {
    private int numMatricula;
    private String carrera;


    public Estudiante(int codigo, int cedula, String nombre, String apellido, String usuario, 
                        String contrasena, String correo, int numMatricula, String carrera) {
        super(codigo, cedula, nombre, apellido, usuario, contrasena, correo, "ESTUDIANTE");
        this.numMatricula = numMatricula;
        this.carrera = carrera;

    }
    
    public void reservar(Date fecha) {
        enviar_correo(fecha);
        
    }

    
}