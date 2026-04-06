package tp1.ejercicio02;

import java.util.Scanner;

public class Ejercicio02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresá un número n: ");
        int n = scanner.nextInt();

        int[] resultado = obtenerMultiplos(n);

        System.out.print("Múltiplos de " + n + ": [");
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i]);
            if (i < resultado.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        scanner.close();
    }
    
    // Devuelve un arreglo con los n primeros múltiplos de n
    public static int[] obtenerMultiplos(int n) {
        int[] resultado = new int[n];
        for (int i = 0; i < n; i++) {
            resultado[i] = n * (i + 1);
        }
        return resultado;
    }
}