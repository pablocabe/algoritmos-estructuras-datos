package parcialesarboles.parcial17;

import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio01.GeneralTree;

public class Parcial17 {
    
    public Integer resolver(GeneralTree<Integer> arbol, Integer min, Integer max) {
        Integer promedio = 0;
        List<Integer> lista = new LinkedList<Integer>();
        if ((arbol != null) && (!arbol.isEmpty())) {
            resolver(arbol,lista, min, max);
        }
        if (!lista.isEmpty()) {
            Integer suma = 0;
            for (Integer valor : lista) {
                suma += valor;
            }
            promedio = suma / lista.size();
        }
        return promedio;
    }

    private void resolver(GeneralTree<Integer> nodoActual, List<Integer> lista, Integer min, Integer max) {
        List<GeneralTree<Integer>> children = nodoActual.getChildren();
        if (nodoActual.hasChildren()) {
            resolver(children.get(0), lista, min, max);
        }
        if ((nodoActual.getData() >= min) && (nodoActual.getData() <= max)) {
            lista.add(nodoActual.getData());
        }
        for (int i = 1; i < children.size(); i++) {
            resolver(children.get(i), lista, min, max);
        }
    }
}
