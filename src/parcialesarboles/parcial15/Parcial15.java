package parcialesarboles.parcial15;

import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio01.GeneralTree;

public class Parcial15 {

    public List<GeneralTree<Integer>> resolver(GeneralTree<Integer> arbol) {
        List<GeneralTree<Integer>> listaSubarboles = new LinkedList<GeneralTree<Integer>>();
        if ((arbol != null) && (!arbol.isEmpty())) {
            resolver(arbol, listaSubarboles);
        }
        return listaSubarboles;
    }

    private void resolver(GeneralTree<Integer> nodoActual, List<GeneralTree<Integer>> listaSubarboles) {
        if (!nodoActual.isLeaf()) {
            List<GeneralTree<Integer>> children = nodoActual.getChildren();
            resolver(children.get(0), listaSubarboles);
            if ((children.size() % 2) == 0) {
                listaSubarboles.add(nodoActual);
            }
            for (int i = 1; i < children.size(); i++) {
                resolver(children.get(i), listaSubarboles);
            }
        }
        
    }

}
