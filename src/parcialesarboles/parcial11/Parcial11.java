package parcialesarboles.parcial11;

import java.util.LinkedList;
import java.util.List;
import tp2.ejercicio01.BinaryTree;

public class Parcial11 {
    
    public List<Integer> resolver(BinaryTree<Integer> arbol) {
        List<Integer> listaValores = new LinkedList<Integer>();
        if ((arbol != null) && (!arbol.isEmpty())) {
            resolver(arbol, listaValores);
        }
        return listaValores;
    }

    private void resolver(BinaryTree<Integer> nodoActual, List<Integer> listaValores) {
        int cantIzq = 0;
        int cantDer = 0;
        boolean okIzq = nodoActual.hasLeftChild();
        boolean okDer = nodoActual.hasRightChild();
        if (okIzq)
            cantIzq = contarNodos(nodoActual.getLeftChild());
        if (okDer)
            cantDer = contarNodos(nodoActual.getRightChild());
        if (cantIzq == cantDer)
            listaValores.add(nodoActual.getData());
        if (okIzq)
            resolver(nodoActual.getLeftChild(), listaValores);
        if (okDer)
            resolver(nodoActual.getRightChild(), listaValores);
    }

    private int contarNodos(BinaryTree<Integer> nodoActual) {
        int cant = 1;
        if (nodoActual.hasLeftChild())
            cant += contarNodos(nodoActual.getLeftChild());
        if (nodoActual.hasRightChild())
            cant += contarNodos(nodoActual.getRightChild());
        return cant;
    }
}
