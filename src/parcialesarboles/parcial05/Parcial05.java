package parcialesarboles.parcial05;

import tp2.ejercicio01.BinaryTree;

public class Parcial05 {

    public int[] resolver (BinaryTree <Integer> arbol) {
        // resultado[0] = entero par
        // resultado[1] = nivel
        int [] resultado = new int[2];
        int nivelActual = 0;
        if ((arbol != null) && (!arbol.isEmpty()))
            recorrerArbol(arbol, resultado, nivelActual);
        return resultado;
    }

    private boolean recorrerArbol (BinaryTree<Integer> nodo, int[] resultado, int nivelActual) {
        boolean encontrePar = false;
        if ((!encontrePar) && (nodo.hasLeftChild()))
            encontrePar = recorrerArbol(nodo.getLeftChild(), resultado, nivelActual + 1);
        if ((!encontrePar) && (nodo.hasRightChild()))
            encontrePar = recorrerArbol(nodo.getRightChild(), resultado, nivelActual + 1);
        if ((!encontrePar) && (nodo.getData() % 2 == 0)) {
            encontrePar = true;
            resultado[0] = nodo.getData();
            resultado[1] = nivelActual;
        }
        return encontrePar;
    }

}
