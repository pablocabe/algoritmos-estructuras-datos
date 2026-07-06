package parcialesarboles.parcial12;

import tp3.ejercicio01.GeneralTree;

public class Parcial12 {
    
    public int resolver(GeneralTree<Integer> arbol) {
        int valorMax = Integer.MIN_VALUE;
        if ((arbol != null) && (!arbol.isEmpty())) {
            valorMax = resolverRecursivo(arbol);
        }
        return valorMax;
    }

    private int resolverRecursivo(GeneralTree<Integer> nodoActual) {
        int localMax = Integer.MIN_VALUE;
        for (GeneralTree<Integer> child : nodoActual.getChildren()) {
            int childMax = resolverRecursivo(child);
            if (childMax > localMax) {
                localMax = childMax;
            }
        }
        if (nodoActual.getData() > localMax) {
            localMax = nodoActual.getData();
        }
        return localMax;
    }
}
