package tp1.ejercicio3;

public class Test {

    public static void main(String[] args) {
        Estudiante[] arrayEstudiantes = new Estudiante[2];
        Profesor[] arrayProfesores = new Profesor[3];

        // Asignar valores a los Estudiantes
        arrayEstudiantes[0] = new Estudiante();
        arrayEstudiantes[0].setNombre("Pablo");
        arrayEstudiantes[0].setApellido("Cabe");
        arrayEstudiantes[0].setComision("A");
        arrayEstudiantes[0].setEmail("pablocabe0@gmail.com");
        arrayEstudiantes[0].setDireccion("Calle 32");

        arrayEstudiantes[1] = new Estudiante();
        arrayEstudiantes[1].setNombre("Federico");
        arrayEstudiantes[1].setApellido("Isla");
        arrayEstudiantes[1].setComision("A");
        arrayEstudiantes[1].setEmail("fedeisla@gmail.com");
        arrayEstudiantes[1].setDireccion("Calle 25");

        // Asignrar valores a los Profesores
        arrayProfesores[0] = new Profesor("", "", "", "", "");
        arrayProfesores[0].setNombre("Carlos");
        arrayProfesores[0].setApellido("López");
        arrayProfesores[0].setEmail("carlos@unlp.edu.ar");
        arrayProfesores[0].setCatedra("Algoritmos");
        arrayProfesores[0].setFacultad("Informática");

        arrayProfesores[1] = new Profesor("", "", "", "", "");
        arrayProfesores[1].setNombre("Ana");
        arrayProfesores[1].setApellido("Martínez");
        arrayProfesores[1].setEmail("ana@unlp.edu.ar");
        arrayProfesores[1].setCatedra("Bases de Datos");
        arrayProfesores[1].setFacultad("Informática");

        arrayProfesores[2] = new Profesor("", "", "", "", "");
        arrayProfesores[2].setNombre("Luis");
        arrayProfesores[2].setApellido("Rodríguez");
        arrayProfesores[2].setEmail("luis@unlp.edu.ar");
        arrayProfesores[2].setCatedra("Redes");
        arrayProfesores[2].setFacultad("Informática");

        System.out.println("ESTUDIANTES");
        for (Estudiante e: arrayEstudiantes){
            System.out.println(e.tusDatos());
        }

        System.out.println("PROFESORES");
        for (Profesor p: arrayProfesores){
            System.out.println(p.tusDatos());
        }
    }
    
}
