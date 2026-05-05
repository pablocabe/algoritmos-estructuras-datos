package parciales;

import tp2.ejercicio01.BinaryTree;

public class Parcial04Optimizado {

    private class Valores {
        int sumaNumerosPositivos = 0;
        int cantNodos = 0;
        int cantHojas = 0;
    }

    public Integer resolver (BinaryTree<Integer> arbol) {
        int valorResultado = -1;
        if ((arbol != null) && (!arbol.isEmpty())) {
            Valores valores = new Valores();
            recorrerArbol(arbol, valores);
            if (valores.sumaNumerosPositivos % 2 == 0)
                valorResultado = valores.cantNodos;
            else
                valorResultado = valores.cantHojas;
        }
        return valorResultado;
    }

    private void recorrerArbol (BinaryTree<Integer> nodo, Valores valores) {
        if (nodo.hasLeftChild())
            recorrerArbol(nodo.getLeftChild(), valores);
        if (nodo.getData() > 0)
            valores.sumaNumerosPositivos += nodo.getData();
        valores.cantNodos++;
        if (nodo.isLeaf())
            valores.cantHojas++;
        if (nodo.hasRightChild())
            recorrerArbol(nodo.getRightChild(), valores);
    }

}
