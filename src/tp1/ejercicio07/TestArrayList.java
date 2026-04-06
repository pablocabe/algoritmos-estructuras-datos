package tp1.ejercicio07;
 
import java.util.ArrayList;
import java.util.Scanner;
 
public class TestArrayList {

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        // ArrayList<Integer> lista = new ArrayList<Integer>(); es válido
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese números enteros (escriba 'fin' para terminar):");

        while (scanner.hasNextInt()) {
            lista.add(scanner.nextInt());
        }

        System.out.println("\nContenido de la lista:");
        for (Integer numero : lista) {
            System.out.println(numero);
        }

        scanner.close();
    }
}


