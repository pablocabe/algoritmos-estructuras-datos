package parcialesarboles.parcial19;

import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio01.GeneralTree;

public class Parcial19 {
    
    public List<String> resolver(int menor, int mayor, GeneralTree<Integer> arbol) {
        List<String> lista = new LinkedList<String>();
        if ((arbol != null) && (!arbol.isEmpty())) {
            int nivel = 0;
            resolver(menor, mayor, arbol, lista, nivel);
        }
        return lista;
    }

    private void resolver(int menor, int mayor, GeneralTree<Integer> nodoActual, List<String> lista, int nivel) {
        for (GeneralTree<Integer> child: nodoActual.getChildren()) {
            resolver(menor, mayor, child, lista, nivel + 1);
        }
        if ((nodoActual.getData() >= menor) && (nodoActual.getData() <= mayor)) {
            lista.add(nodoActual.getData() + " nivel " + nivel);
        }
    }
}
