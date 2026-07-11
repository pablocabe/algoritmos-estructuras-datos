package parcialesarboles.parcial22;

import tp2.ejercicio01.BinaryTree;

public class Parcial22 {

    BinaryTree<Integer> arbol;
    
    public BinaryTree<Integer> nuevoTree() {
        BinaryTree<Integer> arbolNuevo = new BinaryTree<Integer>();
        if ((this.arbol != null) && (!this.arbol.isEmpty())) {
            int valorPadre = 0;
            resolver(this.arbol, arbolNuevo, valorPadre);
        }
        return arbolNuevo;
    }

    private void resolver(BinaryTree<Integer> nodoActual, BinaryTree<Integer> arbolNuevo, int valorPadre) {
        int valorOriginal = nodoActual.getData();
        arbolNuevo.setData(nodoActual.getData() + valorPadre);
        if (nodoActual.hasLeftChild()) {
            arbolNuevo.addLeftChild(new BinaryTree<Integer>());
            resolver(nodoActual.getLeftChild(), arbolNuevo.getLeftChild(), valorOriginal);
        }
        if (nodoActual.hasRightChild()) {
            arbolNuevo.addRightChild(new BinaryTree<Integer>());
            resolver(nodoActual.getRightChild(), arbolNuevo.getRightChild(), 0);
        }
    }
}
