package parciales;

import java.util.ArrayList;
import java.util.List;

import tp3.ejercicio01.GeneralTree;

public class Parcial02 {

    public static List<Integer> caminoSignoAlternante(GeneralTree<Integer> arbol) {
        List<Integer> mejorCamino = new ArrayList<>();
        
        if ((arbol != null) && (!arbol.isEmpty())) {
            List<Integer> actualCamino = new ArrayList<>();
            caminoSignoAlternanteRecursivo(arbol, mejorCamino, actualCamino);
        }

        return mejorCamino;
    }

    private static void caminoSignoAlternanteRecursivo(GeneralTree<Integer> nodoActual, List<Integer> mejorCamino, List<Integer> actualCamino) {

    }
}
