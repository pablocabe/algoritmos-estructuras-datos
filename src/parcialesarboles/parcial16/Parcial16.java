package parcialesarboles.parcial16;

import java.util.List;
import tp1.ejercicio08.Queue;
import tp3.ejercicio01.GeneralTree;

public class Parcial16 {
    
    public int resolver(GeneralTree<Integer> arbol) {
        int resultado = 0;
        if ((arbol != null) && (!arbol.isEmpty())) {
            Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
            queue.enqueue(arbol);
            while (!queue.isEmpty()) {
                int size = queue.size();
                // Reinicio resultado
                resultado = 1;
                for (int i = 0; i < size; i++) {
                    GeneralTree<Integer> nodoActual = queue.dequeue();
                    if (nodoActual.isLeaf()) {
                        resultado *= nodoActual.getData();
                    }
                    else {
                        List<GeneralTree<Integer>> children = nodoActual.getChildren();
                        for (GeneralTree<Integer> child: children) {
                            queue.enqueue(child);
                        }
                    }
                }
            }
        }
        return resultado;
    }

}
