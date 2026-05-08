package parciales;

import tp2.ejercicio01.BinaryTree;

public class Parcial06Optimizado2 {

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
            BinaryTree<Integer> hijoIzquierdo = null;
            BinaryTree<Integer> hijoDerecho = null;
            if (nodoActual.hasLeftChild()) {
                hijoIzquierdo = nodoActual.getLeftChild();
                sumaHijos += hijoIzquierdo.getData();
            }
            if (nodoActual.hasRightChild()) {
                hijoDerecho = nodoActual.getRightChild();
                sumaHijos += hijoDerecho.getData();
            }
            if (!(nodoActual.getData() > sumaHijos))
                cumple = false;
            if ((cumple) && (nodoActual.hasLeftChild()))
                cumple = resolverRecursivo(hijoIzquierdo);
            if ((cumple) && (nodoActual.hasRightChild()))
                cumple = resolverRecursivo(hijoDerecho);
        }
        return cumple;
    }
    
}
