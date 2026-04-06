package tp2.ejercicio03;

import java.util.LinkedList;
import tp2.ejercicio01.BinaryTree;

public class ContadorArbol {

    private BinaryTree<Integer> arbol;

    public ContadorArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    // A) Izquierda, raíz, derecha
    public LinkedList<Integer> numerosParesInOrden() {
        LinkedList<Integer> pares = new LinkedList<Integer>();
        if (this.arbol != null && !this.arbol.isEmpty())
            recorridoInOrden(this.arbol, pares);
        return pares;
    }

    private void recorridoInOrden(BinaryTree<Integer> nodo, LinkedList<Integer> pares) {
        if (nodo.hasLeftChild())
            recorridoInOrden(nodo.getLeftChild(), pares);
        if (nodo.getData() != null && nodo.getData() % 2 == 0)
            pares.add(nodo.getData());
        if (nodo.hasRightChild())
            recorridoInOrden(nodo.getRightChild(), pares);
    }

    // B) Izquierda, derecha, raíz
    public LinkedList<Integer> numerosParesPostOrden() {
        LinkedList<Integer> pares = new LinkedList<Integer>();
        if (this.arbol != null && !this.arbol.isEmpty())
            recorridoPostOrden(this.arbol, pares);
        return pares;
    }

    private void recorridoPostOrden(BinaryTree<Integer> nodo, LinkedList<Integer> pares) {
        if (nodo.hasLeftChild())
            recorridoPostOrden(nodo.getLeftChild(), pares);
        if (nodo.hasRightChild())
            recorridoPostOrden(nodo.getRightChild(), pares);
        if (nodo.getData() != null && nodo.getData() % 2 == 0)
            pares.add(nodo.getData());
    }
}
