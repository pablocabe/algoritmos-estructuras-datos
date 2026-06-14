package parcialesarboles.parcial06;

import tp2.ejercicio01.BinaryTree;

public class Parcial06Optimizado1 {

    public Boolean resolver(BinaryTree<Integer> arbol) {
        boolean esMayor = true;
        if ((arbol != null) && (!arbol.isEmpty())) {
            esMayor = resolverRecursivo(arbol);
        }
        return esMayor;
    }

    private Boolean resolverRecursivo(BinaryTree<Integer> nodoActual) {
        boolean cumple = true;
        if (!nodoActual.isLeaf()) {
            int sumaHijos = 0;
            if (nodoActual.hasLeftChild())
                sumaHijos += nodoActual.getLeftChild().getData();
            if (nodoActual.hasRightChild())
                sumaHijos += nodoActual.getRightChild().getData();
            if (!(nodoActual.getData() > sumaHijos))
                cumple = false;
            if ((cumple) && (nodoActual.hasLeftChild()))
                cumple = resolverRecursivo(nodoActual.getLeftChild());
            if ((cumple) && (nodoActual.hasRightChild()))
                cumple = resolverRecursivo(nodoActual.getRightChild());
        }
        return cumple;
    }
    
}
