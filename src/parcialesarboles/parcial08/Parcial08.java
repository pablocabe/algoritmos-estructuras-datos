package parcialesarboles.parcial08;

import tp2.ejercicio01.BinaryTree;

public class Parcial08 {

    public BinaryTree<Integer> espejadoAcumulado(BinaryTree<Integer> arbol) {
        BinaryTree<Integer> nuevoArbol = new BinaryTree<Integer>();
        if ((arbol != null) && (!arbol.isEmpty())) {
            nuevoArbol.setData(arbol.getData());
            int valorAcumulado = 0;
            obtenerArbolEspejo(arbol, nuevoArbol, valorAcumulado);
        }
        return nuevoArbol;
    }

    private void obtenerArbolEspejo(BinaryTree<Integer> nodoActual, BinaryTree<Integer> nodoNuevo, int valorAcumulado) {
        valorAcumulado += nodoActual.getData();
        if (nodoActual.hasLeftChild()) {
            nodoNuevo.addRightChild(new BinaryTree<Integer>(valorAcumulado + nodoActual.getLeftChild().getData()));
            obtenerArbolEspejo(nodoActual.getLeftChild(), nodoNuevo.getRightChild(), valorAcumulado);
        }
        if (nodoActual.hasRightChild()) {
            nodoNuevo.addLeftChild(new BinaryTree<Integer>(valorAcumulado + nodoActual.getRightChild().getData()));
            obtenerArbolEspejo(nodoActual.getRightChild(), nodoNuevo.getLeftChild(), valorAcumulado);
        }
    }
}
