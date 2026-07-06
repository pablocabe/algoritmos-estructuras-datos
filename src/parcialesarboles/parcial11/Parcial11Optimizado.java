package parcialesarboles.parcial11;

import java.util.LinkedList;
import java.util.List;

import tp2.ejercicio01.BinaryTree;

public class Parcial11Optimizado {
    
    public List<Integer> resolver(BinaryTree<Integer> arbol) {
        List<Integer> listaValores = new LinkedList<Integer>();
        if ((arbol != null) && (!arbol.isEmpty())) {
            resolver(arbol, listaValores);
        }
        // Otra forma era invertir la lista una vez que terminó todo el recorrido
        // Collections.reverse(listaValores);
        return listaValores;
    }

    private int resolver(BinaryTree<Integer> nodoActual, List<Integer> listaValores) {
        int cantIzq = 0;
        int cantDer = 0;
        if (nodoActual.hasLeftChild()) {
            cantIzq += resolver(nodoActual.getLeftChild(), listaValores);
        }
        if (nodoActual.hasRightChild()) {
            cantDer += resolver(nodoActual.getRightChild(), listaValores);
        }
        if (cantIzq == cantDer) {
            listaValores.add(0, nodoActual.getData());
        }
        return cantIzq + cantDer + 1;
    }
}
