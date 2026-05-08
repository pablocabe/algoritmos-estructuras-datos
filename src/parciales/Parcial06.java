package parciales;

import tp2.ejercicio01.BinaryTree;

public class Parcial06 {

    public Boolean resolver(BinaryTree<Integer> arbol) {
        boolean esMayor = true;
        if ((arbol != null) && (!arbol.isEmpty())) {
            esMayor = resolverRecursivo(arbol);
        }
        return esMayor;
    }

    private Boolean resolverRecursivo(BinaryTree<Integer> nodoActual) {
        if (nodoActual.isLeaf())
            return true;
        int sumaHijos = 0;
        if (nodoActual.hasLeftChild())
            sumaHijos += nodoActual.getLeftChild().getData();
        if (nodoActual.hasRightChild())
            sumaHijos += nodoActual.getRightChild().getData();
        if (!(nodoActual.getData() > sumaHijos))
            return false;
        boolean izqOk = true;
        boolean derOk = true;
        if (nodoActual.hasLeftChild())
            izqOk = resolverRecursivo(nodoActual.getLeftChild());
        if ((izqOk) && (nodoActual.hasRightChild()))
            derOk = resolverRecursivo(nodoActual.getRightChild());
        return (izqOk && derOk);
    }
    
}
