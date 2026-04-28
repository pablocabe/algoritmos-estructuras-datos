package tp3.ejercicio07;

import java.util.ArrayList;
import java.util.List;

import tp3.ejercicio01.GeneralTree;

public class Caminos {

    private GeneralTree<Integer> arbol;
    
    public List<Integer> caminoAHojaMasLejana() {
        List<Integer> mejorCamino = new ArrayList<Integer>();
        List<Integer> caminoActual = new ArrayList<Integer>();
        if ((this.arbol != null) && (!this.arbol.isEmpty()))
            caminoAHojaMasLejanaRecursivo(mejorCamino, caminoActual, this.arbol);
        return mejorCamino;
    }

    private void caminoAHojaMasLejanaRecursivo(List<Integer> mejorCamino, List<Integer> caminoActual, GeneralTree<Integer> nodoActual) {
        caminoActual.add(nodoActual.getData());
        if (nodoActual.isLeaf() && caminoActual.size() > mejorCamino.size())
            mejorCamino.clear();
            mejorCamino.addAll(caminoActual);
        for (GeneralTree<Integer> child: nodoActual.getChildren()) {
            caminoAHojaMasLejanaRecursivo(mejorCamino, caminoActual, child);
        }
        caminoActual.remove(caminoActual.size()-1);
    }
}
