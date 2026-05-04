package parciales;

import tp2.ejercicio01.BinaryTree;

public class Parcial04 {

    public Integer resolver (BinaryTree<Integer> arbol) {
        int valorResultado = -1;
        if ((arbol != null) && (!arbol.isEmpty())) {
            // stats[0] = Suma de números positivos
            // stats[1] = Cantidad total de nodos
            // stats[2] = Cantidad total de hojas
            int [] stats = new int[3];
            recorrerArbol(arbol, stats);
            if (stats[0] % 2 == 0)
                valorResultado = stats[1];
            else
                valorResultado = stats[2];
        }
        return valorResultado;
    }

    private void recorrerArbol (BinaryTree<Integer> nodo, int[] stats) {
        if (nodo.hasLeftChild())
            recorrerArbol(nodo.getLeftChild(), stats);
        if (nodo.getData() > 0)
            stats[0] += nodo.getData();
        stats[1]++;
        if (nodo.isLeaf())
            stats[2]++;
        if (nodo.hasRightChild())
            recorrerArbol(nodo.getRightChild(), stats);
    }

}
