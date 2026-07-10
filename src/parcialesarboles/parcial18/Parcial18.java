package parcialesarboles.parcial18;

import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio01.GeneralTree;

public class Parcial18 {

    public List<String> resolver(int valor, GeneralTree<Integer> arbol) {
        List<String> lista = new LinkedList<String>();
        if ((arbol != null) && (!arbol.isEmpty())){
            int nivel = 0;
            resolver(arbol, valor, lista, nivel);
        }
        return lista;
    }

    private void resolver(GeneralTree<Integer> nodoActual, int valor, List<String> lista, int nivel) {
        List<GeneralTree<Integer>> children = nodoActual.getChildren();
        if (nodoActual.hasChildren()) {
            resolver(children.get(0), valor, lista, nivel + 1);
        }
        if (nodoActual.getData() > valor){
            lista.add(nodoActual.getData() + " nivel " + nivel);
        }
        for (int i = 1; i < children.size(); i++) {
            resolver(children.get(i), valor, lista, nivel + 1);
        }
    }
        
}
