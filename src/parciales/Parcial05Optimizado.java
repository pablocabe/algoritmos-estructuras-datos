package parciales;

import tp2.ejercicio01.BinaryTree;

public class Parcial05Optimizado {

    private class Resultado {
        int numeroPar = -1;
        int nivelActual = -1;
    }

    public Resultado resolver (BinaryTree <Integer> arbol) {
        Resultado resultado = new Resultado();
        int nivelActual = 0;
        if ((arbol != null) && (!arbol.isEmpty()))
            recorrerArbol(arbol, resultado, nivelActual);
        System.out.println(resultado.numeroPar);
        System.out.println(resultado.nivelActual);
        return resultado;
    }

    private boolean recorrerArbol (BinaryTree<Integer> nodo, Resultado resultado, int nivelActual) {
        boolean encontrePar = false;
        if ((!encontrePar) && (nodo.hasLeftChild()))
            encontrePar = recorrerArbol(nodo.getLeftChild(), resultado, nivelActual + 1);
        if ((!encontrePar) && (nodo.hasRightChild()))
            encontrePar = recorrerArbol(nodo.getRightChild(), resultado, nivelActual + 1);
        if ((!encontrePar) && (nodo.getData() % 2 == 0)) {
            encontrePar = true;
            resultado.numeroPar = nodo.getData();
            resultado.nivelActual = nivelActual;
        }
        return encontrePar;
    }

}
