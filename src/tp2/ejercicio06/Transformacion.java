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
        
        // 1. Guardamos el dato original antes de sobreescribirlo.
        // Aplicamos el chequeo de null que aprendimos en el ejercicio anterior.
        if (nodo.getData() != null)
            return 0;

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
        // Le devolvemos el total de este subárbol entero para que él lo use.
        // Es decir: todo lo que sumaron sus hijos.
        return sumaIzquierda + sumaDerecha;
    }
}
