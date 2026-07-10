package parcialesarboles.parcial21;

import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio08.Queue;
import tp3.ejercicio01.GeneralTree;

public class Parcial21Optimizado1 {
    
    GeneralTree<Integer> arbol;

    public List<Integer> nivel(int num) {
        List<Integer> lista = new LinkedList<Integer>();
        if ((this.arbol != null) && (!this.arbol.isEmpty())) {
            Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
            queue.enqueue(this.arbol);
            boolean cumpleNivel = false;
            while ((!queue.isEmpty()) && (!cumpleNivel)) {
                int size = queue.size();
                boolean cumpleNodo = true;
                for (int i = 0; i < size; i++) {
                    GeneralTree<Integer> nodoActual = queue.dequeue();
                    lista.add(nodoActual.getData());
                    List<GeneralTree<Integer>> children = nodoActual.getChildren();
                    for (GeneralTree<Integer> child: children) {
                        queue.enqueue(child);
                    }
                    if (children.size() < num) {
                        cumpleNodo = false;
                    }
                }
                if (cumpleNodo) {
                    cumpleNivel = true;
                }
                else {
                    lista.clear();
                }
            }
        }
        return lista;
    }

}
