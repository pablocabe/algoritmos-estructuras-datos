package tp1.ejercicio01;

public class Ejercicio01 {
    public static void main(String[] args) {
        int a = 2;
        int b = 8;
        imprimirConFor(a, b);
        imprimirConWhile(a, b);
        imprimirConRecursion(a, b);
    }

    public static void imprimirConFor (int a, int b){
        for (int i = a; i <= b; i++){
            System.out.println(i);
        }
    }

    public static void imprimirConWhile (int a, int b){
        int i = a;
        while (i <= b) {
            System.out.println(i);
            i++;
        }
    }

    public static void imprimirConRecursion(int a, int b) {
        if (a > b) {
            return;
        }
        System.out.println(a);
        imprimirConRecursion(a+1, b);
    }

}
