package parciales;

import tp2.ejercicio01.BinaryTree;

public class Parcial10 {
    
    public static int resolverParcial (BinaryTree<Integer> arbol) {
        int resultadoFinal = 0;
        if ((arbol != null) && (!arbol.isEmpty())) {
            resultadoFinal = resolverRecursivo(arbol);
        }
        return resultadoFinal;
    }

    private static int resolverRecursivo (BinaryTree<Integer> nodo) {
        int resultado = 0;
        if (nodo.hasLeftChild())
            resultado += resolverRecursivo(nodo.getLeftChild());
        if (nodo.hasRightChild())
            resultado += resolverRecursivo(nodo.getRightChild());
        boolean esPar = (nodo.getData() % 2 == 0);
        if ((esPar) && (nodo.hasLeftChild()) && (nodo.hasRightChild()))
            resultado += nodo.getData();
        else if ((!esPar) && ((nodo.hasLeftChild() & !nodo.hasRightChild()) | (nodo.hasRightChild() & !nodo.hasLeftChild())))
            resultado -= nodo.getData();
        return resultado;
    }
}
