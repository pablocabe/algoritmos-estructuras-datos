package tp1.ejercicio07;

import java.util.ArrayList;

import tp1.ejercicio03.Estudiante;

public class ListaTest {

    public static void main(String[] args) {

        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Pablo", "Cabe", "1A", "pablocabe0@gmail.com", "32"));
        estudiantes.add(new Estudiante("Pablo", "Cabe", "2A", "pablocabe1@gmail.com", "33"));
        estudiantes.add(new Estudiante("Pablo", "Cabe", "2B", "pablocabe2@gmail.com", "34"));

        ArrayList<Estudiante> estudiantesCopia = new ArrayList<>(estudiantes);

        System.out.println("\nContenido de la primera lista:");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.tusDatos());
        }

        System.out.println("\nContenido de la segunda lista:");
        for (Estudiante estudiante : estudiantesCopia) {
            System.out.println(estudiante.tusDatos());
        }

        estudiantes.get(1).setNombre("Matias");

        System.out.println("\nContenido de la primera lista:");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.tusDatos());
        }

        System.out.println("\nContenido de la segunda lista:");
        for (Estudiante estudiante : estudiantesCopia) {
            System.out.println(estudiante.tusDatos());
        }
    }
    
}