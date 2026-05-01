package parciales;

import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio01.GeneralTree;

public class Parcial01 {

    public static List<Integer> caminoParidadAlternante (GeneralTree<Integer> arbol) {
        List<Integer> mejorCamino = new LinkedList<Integer>();
        List<Integer> caminoActual = new LinkedList<Integer>();
        if (arbol != null && !arbol.isEmpty()) {
            boolean esperaPar = arbol.getData() % 2 == 0;
            resolver (arbol, mejorCamino, caminoActual, esperaPar);
		}
        return mejorCamino;
    }

    private static void resolver (GeneralTree<Integer> nodoActual, List<Integer> mejorCamino, List<Integer> caminoActual, boolean esperaPar) {
        caminoActual.add(nodoActual.getData());

        if (nodoActual.isLeaf() && caminoActual.size() > mejorCamino.size()) {
            mejorCamino.clear();
            mejorCamino.addAll(caminoActual);
        }

        else {

        }
        
        caminoActual.remove(caminoActual.size()-1);
            
        }
}

    
