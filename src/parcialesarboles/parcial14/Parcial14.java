package parcialesarboles.parcial14;

import java.util.List;

import tp3.ejercicio01.GeneralTree;

public class Parcial14 {
    
    public Integer resolver(GeneralTree<Integer> arbol) {
        int resultado = 0;
        ContadorNodos contadorNodos = new ContadorNodos();
        if ((arbol != null) && (!arbol.isEmpty())) {
            resolver(arbol, contadorNodos);
        }
        if ((contadorNodos.getCantNodos() % 2) == 0)
            resultado = contadorNodos.getCantPositivos();
        else
            resultado = contadorNodos.getCantNegativos();
        return resultado;
    }

    private void resolver(GeneralTree<Integer> nodoActual, ContadorNodos contadorNodos) {
        List<GeneralTree<Integer>> children = nodoActual.getChildren();
        if (nodoActual.hasChildren()) {
            resolver(children.get(0), contadorNodos);
        }
        int num = nodoActual.getData();
        contadorNodos.incrementarCantNodos();
        if (num >= 0)
            contadorNodos.incrementarPositivos();
        else
            contadorNodos.incrementarNegativos();
        for (int i = 1; i < children.size(); i++) {
            resolver(children.get(i), contadorNodos);
        }
    }
}
