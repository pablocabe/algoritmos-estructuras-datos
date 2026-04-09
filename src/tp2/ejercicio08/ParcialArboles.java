package tp2.ejercicio08;

import tp2.ejercicio01.BinaryTree;

public class ParcialArboles {

    public ParcialArboles(BinaryTree<Integer> arbolBinario) {}

    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
        
        // Primero valido los dos árboles
        if (arbol1 == null || arbol1.isEmpty()) return false;

        if (arbol2 == null || arbol2.isEmpty()) return false;

        return recorridoRecursivoComparando(arbol1, arbol2);
    }

    public boolean recorridoRecursivoComparando(BinaryTree<Integer> nodo1, BinaryTree<Integer> nodo2) {
        
        if (nodo1.getData() == null || nodo2.getData() == null) return false;

        if (nodo1.getData() != nodo2.getData()) return false;
        
        if (nodo1.hasLeftChild()) {
            if (!nodo2.hasLeftChild()) return false;
            if (!recorridoRecursivoComparando(nodo1.getLeftChild(), nodo2.getLeftChild())) return false;
        }

        if (nodo1.hasRightChild()) {
            if (!nodo2.hasRightChild()) return false;
            if (!recorridoRecursivoComparando(nodo1.getRightChild(), nodo2.getRightChild())) return false;
        }

        return true;
    }
    
}
