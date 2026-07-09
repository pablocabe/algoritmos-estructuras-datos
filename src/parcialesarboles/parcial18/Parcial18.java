package parcialesarboles.parcial18;

import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio01.GeneralTree;

public class Parcial18 {

    public List<String> resolver(int valor, GeneralTree<Integer> arbol) {
        List<String> resultado = new LinkedList<String>();
        if ((arbol != null) && (!arbol.isEmpty())){
            resolverAux(arbol, valor, resultado, 1);
        }
        return resultado;
    }

    private void resolverAux(GeneralTree<Integer> nodoActual, int valor, List<String> resultado, int nivel) {
        // Inorden
        List<GeneralTree<Integer>> children = nodoActual.getChildren();
        // Procesar hijo izquierdo
        if (nodoActual.hasChildren()) {
            resolverAux(children.get(0), valor, resultado, nivel + 1);
        }
        // Procesar actual
        if (nodoActual.getData() > valor){
            String elem = nodoActual.getData() + "nivel " + nivel;
            resultado.add(elem);
        }
        // Procesar hijos restantes
        for (int i = 1; i < children.size(); i++) {
            resolverAux(children.get(i), valor, resultado, nivel + 1);
        }
    }
        
}
