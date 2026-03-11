package tp1.ejercicio5;

public class Ejercicio5 {

    public static void main(String[] args) {
        int[] arrayEnteros = {3, 7, 1, 9, 4, 6, 2, 8, 5, 10};

        int[] resultadoA = incisoA(arrayEnteros);
        System.out.println("INCISO A");
        System.out.println("Máximo: " + resultadoA[0]);
        System.out.println("Mínimo: " + resultadoA[1]);
        System.out.println("Promedio: " + resultadoA[2]);

        int[] resultadoB = new int[3];
        incisoB(arrayEnteros, resultadoB);
        System.out.println("INCISO B");
        System.out.println("Máximo: " + resultadoA[0]);
        System.out.println("Mínimo: " + resultadoA[1]);
        System.out.println("Promedio: " + resultadoA[2]);

        incisoC(arrayEnteros);
        System.out.println("INCISO C");
        System.out.println("Máximo: " + max);
        System.out.println("Mínimo: " + min);
        System.out.println("Promedio: " + promedio);

    }

    public static int[] incisoA(int[] arrayEnteros) {
        int max = arrayEnteros[0];
        int min = arrayEnteros[0];
        int total = 0;

        for (int i = 0 ; i < arrayEnteros.length ; i++ ) {
            if (arrayEnteros[i] > max)
                max = arrayEnteros[i];
            if (arrayEnteros[i] < min)
                min = arrayEnteros[i];
            total += arrayEnteros[i];
        }

        return new int[] {max, min, total/arrayEnteros.length};
    }

    public static void incisoB(int[] arrayEnteros, int[] resultadoB) {
        // Se reutiliza el código
        resultadoB = incisoA(arrayEnteros);
    }

    // Se utilizan variables de clase estáticas, sin parámetros de salida ni return
    static int max;
    static int min;
    static int promedio;

    public static void incisoC(int[] arrayEnteros) {
        max = arrayEnteros[0];
        min = arrayEnteros[0];
        int suma = 0;

        for (int i = 0; i < arrayEnteros.length; i++) {
            if (arrayEnteros[i] > max) max = arrayEnteros[i];
            if (arrayEnteros[i] < min) min = arrayEnteros[i];
            suma += arrayEnteros[i];
        }

        promedio = suma / arrayEnteros.length;
    }


}
