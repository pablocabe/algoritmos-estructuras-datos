package tp2.ejercicio06;

import tp2.ejercicio01.BinaryTree;

public class Transformacion {

    private BinaryTree<Integer> arbolBinario;

    public Transformacion (BinaryTree<Integer> arbolBinario) {
        this.arbolBinario = arbolBinario;
    }

    // Método principal que pide la consigna
    public BinaryTree<Integer> suma() {
        if (this.arbolBinario != null && !this.arbolBinario.isEmpty()) {
            sumaRecursiva(this.arbolBinario);
        }
        return this.arbolBinario; // Devolvemos el árbol ya modificado
    }

    // Método privado auxiliar
    private int sumaRecursiva(BinaryTree<Integer> nodo) {
        
        // 1. Guardamos el dato original de este nodo.
        // Asumimos 0 si el dato llega a ser null (por precaución).
        int valorOriginal = 0;
        if (nodo.getData() != null) {
            valorOriginal = nodo.getData();
        }

        // 2. Paso recursivo (Post-Orden: primero los hijos)
        int sumaIzquierda = 0;
        int sumaDerecha = 0;

        if (nodo.hasLeftChild()) {
            sumaIzquierda = sumaRecursiva(nodo.getLeftChild());
        }

        if (nodo.hasRightChild()) {
            sumaDerecha = sumaRecursiva(nodo.getRightChild());
        }

        // 3. Modificamos el nodo actual: Su nuevo valor es la suma de los subárboles
        nodo.setData(sumaIzquierda + sumaDerecha);

        // 4. ¿Qué le devolvemos al padre? 
        // Le devolvemos EL TOTAL: lo que sumaban sus hijos MÁS su valor original.
        return valorOriginal + sumaIzquierda + sumaDerecha;
    }
}
