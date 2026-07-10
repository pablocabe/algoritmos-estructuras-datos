package parcialesarboles.parcial21;

import java.util.LinkedList;
import java.util.List;
import tp1.ejercicio08.Queue;
import tp3.ejercicio01.GeneralTree;

public class Parcial21Optimizado2 {

    GeneralTree<Integer> arbol;

    public List<Integer> nivel(int num) {
        List<Integer> lista = new LinkedList<Integer>();
        if ((this.arbol != null) && (!this.arbol.isEmpty())) {
            Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
            queue.enqueue(this.arbol);
            boolean encontreNivel = false;
            while ((!queue.isEmpty()) && (!encontreNivel)) {
                int size = queue.size();
                int cantNodosCumplen = 0;
                for (int i = 0; i < size; i++) {
                    GeneralTree<Integer> nodoActual = queue.dequeue();
                    List<GeneralTree<Integer>> children = nodoActual.getChildren();
                    for (GeneralTree<Integer> child: children) {
                        queue.enqueue(child);
                    }
                    if (children.size() >= num) {
                        cantNodosCumplen++;
                        lista.add(nodoActual.getData());
                    }
                }
                encontreNivel = (size == cantNodosCumplen);
                if (!encontreNivel) {
                    lista.clear();
                }
            }
        }
        return lista;
    }

}
