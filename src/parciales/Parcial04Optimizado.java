package parciales;

import tp2.ejercicio01.BinaryTree;

public class Parcial04Optimizado {

    public Integer resolver (BinaryTree<Integer> arbol) {
        int valorResultado = -1;
        if ((arbol != null) && (!arbol.isEmpty())) {
            Valores valores = new Valores();
            recorrerArbol(arbol, valores);
            if (valores.getSumaNumerosPositivos() % 2 == 0)
                valorResultado = valores.getCantNodos();
            else
                valorResultado = valores.getCantHojas();
        }
        return valorResultado;
    }

    private void recorrerArbol (BinaryTree<Integer> nodo, Valores valores) {
        if (nodo.hasLeftChild())
            recorrerArbol(nodo.getLeftChild(), valores);
        if (nodo.getData() > 0)
            valores.setSumaNumerosPositivos(valores.getSumaNumerosPositivos() + nodo.getData());
        valores.setCantNodos(valores.getCantNodos() + 1);
        if (nodo.isLeaf())
            valores.setCantHojas(valores.getCantHojas() + 1);
        if (nodo.hasRightChild())
            recorrerArbol(nodo.getRightChild(), valores);
    }

}
