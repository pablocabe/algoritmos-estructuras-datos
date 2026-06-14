package parcialesarboles.parcial07;

import tp2.ejercicio01.BinaryTree;

public class Parcial07 {

    public Boolean resolver(BinaryTree<Integer> arbol) {
        boolean esPaternal = true;
        if ((arbol != null) && (!arbol.isEmpty()))
            esPaternal = resolverRecursivo(arbol);
        return esPaternal;
    }

    private boolean resolverRecursivo(BinaryTree<Integer> nodoActual) {
        boolean cumple = true;
        if (!nodoActual.isLeaf()) {
            int sumaHijos = 0;
            if (nodoActual.hasLeftChild())
                sumaHijos += nodoActual.getLeftChild().getData();
            if (nodoActual.hasRightChild())
                sumaHijos += nodoActual.getRightChild().getData();
            if (nodoActual.getData() != sumaHijos)
                cumple = false;
            if ((cumple) && (nodoActual.hasLeftChild()))
                cumple = resolverRecursivo(nodoActual.getLeftChild());
            if ((cumple) && (nodoActual.hasRightChild()))
                cumple = resolverRecursivo(nodoActual.getRightChild());
        }
        return cumple;
    }
    
}
