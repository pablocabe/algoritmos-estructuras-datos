package parcialesarboles.parcial21;

import java.util.LinkedList;
import java.util.List;
import tp1.ejercicio08.Queue;
import tp3.ejercicio01.GeneralTree;

public class Parcial21 {
    
    GeneralTree<Integer> arbol;
    
    public List<Integer> nivel (int num) {
        List<Integer> lista = new LinkedList<Integer>();
        if ((arbol != null) && (!arbol.isEmpty())) {
            Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>(); 
            queue.enqueue(this.arbol);
            queue.enqueue(null);
            boolean encontre = false;
            boolean nodoCumple = true;
            while ((!queue.isEmpty()) && (!encontre)) {
                GeneralTree<Integer> nodoActual = queue.dequeue();
                if (nodoActual != null) {
                    lista.add(nodoActual.getData());
                    List<GeneralTree<Integer>> children = nodoActual.getChildren();
                    for (GeneralTree<Integer> child: children) {
                        queue.enqueue(child);
                    }
                    if (children.size() < num) {
                        nodoCumple = false;
                    }
                }
                // Entonces es null
                else if (nodoCumple) {
                        encontre = true;
                }
                // Si el nivel no cumplió siempre vaciamos la lista, sin importar si quedan más niveles
                else {
                    nodoCumple = true;
                    lista.clear();
                    // Solo volvemos a encolar null si la cola no quedó vacía
                    if (!queue.isEmpty())
                        queue.enqueue(null);
                }
            }
        }
        return lista;
    }

}
