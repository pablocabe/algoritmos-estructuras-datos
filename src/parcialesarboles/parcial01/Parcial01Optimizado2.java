package parcialesarboles.parcial01;

import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio01.GeneralTree;

public class Parcial01Optimizado2 {
    
    public static List<Integer> caminoParidadAlternante(GeneralTree<Integer> arbol) {
        List<Integer> caminoMasLargo = new LinkedList<Integer>();
        if ((arbol != null) && (!arbol.isEmpty())) {
            List<Integer> caminoActual = new LinkedList<Integer>();
            boolean esperaPar = !(arbol.getData() % 2 == 0);
            caminoParidadAlternante(arbol, caminoMasLargo, caminoActual, esperaPar);
        }
        return caminoMasLargo;
    }

    private static void caminoParidadAlternante(GeneralTree<Integer> nodoActual, List<Integer> caminoMasLargo, List<Integer> caminoActual, boolean esperaPar) {
        caminoActual.add(nodoActual.getData());
        if (nodoActual.isLeaf()) {
            if (caminoActual.size() > caminoMasLargo.size()) {
                caminoMasLargo.clear();
                caminoMasLargo.addAll(caminoActual);
            }
        }
        else {
            for (GeneralTree<Integer> child: nodoActual.getChildren()) {
                if ((esperaPar) == (child.getData() % 2 == 0)) {
                    caminoParidadAlternante(child, caminoMasLargo, caminoActual, !esperaPar);
                }
            }
        }
        caminoActual.remove(caminoActual.size() - 1);
    }

}
