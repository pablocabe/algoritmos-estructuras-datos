package parcialesarboles.parcial20;

import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio01.GeneralTree;

public class Parcial20 {

    GeneralTree<Integer> arbol;

    public List<Integer> resolver() {
        List<Integer> lista = new LinkedList<Integer>();
        if ((this.arbol != null) && (!this.arbol.isEmpty())) {
            resolver(arbol, lista);
        }
        return lista;
    }

    private void resolver(GeneralTree<Integer> nodoActual, List<Integer> lista) {
        if (nodoActual.isLeaf()) {
            if (nodoActual.getData() % 2 == 0) {
                lista.add(nodoActual.getData());
            }
        }
        else {
            for (GeneralTree<Integer> child: nodoActual.getChildren()) {
                resolver(child, lista);
            }
        }
    }    
}
