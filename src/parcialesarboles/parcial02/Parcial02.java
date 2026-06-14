package parcialesarboles.parcial02;

import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio01.GeneralTree;

public class Parcial02 {

    public static List<Integer> caminoSignoAlternante(GeneralTree<Integer> arbol) {
        List<Integer> mejorCamino = new LinkedList<>();
        if ((arbol != null) && (!arbol.isEmpty())) {
            List<Integer> actualCamino = new LinkedList<>();
            boolean esperaPositivo = !(arbol.getData() >= 0);
            caminoSignoAlternanteRecursivo(arbol, mejorCamino, actualCamino, esperaPositivo);
        }
        return mejorCamino;
    }

    private static void caminoSignoAlternanteRecursivo(GeneralTree<Integer> nodoActual, List<Integer> mejorCamino, List<Integer> actualCamino, boolean esperaPositivo) {
        actualCamino.add(nodoActual.getData());

        if ((nodoActual.isLeaf()) && (suma(actualCamino) > suma(mejorCamino))) {
            mejorCamino.clear();
            mejorCamino.addAll(actualCamino);
        }

        else {
            for (GeneralTree<Integer> child: nodoActual.getChildren()) {
                if (esperaPositivo == (child.getData() >= 0))
                    caminoSignoAlternanteRecursivo(nodoActual, mejorCamino, actualCamino, !esperaPositivo);
            }
        }
        
        actualCamino.remove(actualCamino.size() - 1);
    }

    private static int suma(List<Integer> lista) {
        int total = 0;
        for (int e: lista)
            total += e;
        return total;
    }
}
