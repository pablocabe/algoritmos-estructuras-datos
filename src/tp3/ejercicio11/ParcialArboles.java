package tp3.ejercicio11;

import java.util.List;

import tp3.ejercicio01.GeneralTree;
import tp1.ejercicio08.Queue;

public class ParcialArboles {

    public static boolean resolver(GeneralTree<Integer> arbol) {
        if ((arbol != null) && (!arbol.isEmpty())){
            boolean esCreciente = true;
            int nivelActual = 1; // Representa la cantidad de nodos que ESPERAMOS en este nivel
            Queue<GeneralTree<Integer>> cola = new Queue<>();
            cola.enqueue(arbol);
        
            while(!cola.isEmpty() && esCreciente) {
                // 1. "Sacamos la foto": cuántos nodos hay en ESTE nivel
                int nodosEnEsteNivel = cola.size();
                
                // 2. Verificamos la condición del parcial para este nivel
                if (nivelActual != nodosEnEsteNivel) {
                    esCreciente = false;
                } else {
                    // 3. Procesamos TODOS los nodos de este nivel usando la "foto"
                    for (int i = 0; i < nodosEnEsteNivel; i++) {
                        GeneralTree<Integer> aux = cola.dequeue();
                        List<GeneralTree<Integer>> children = aux.getChildren();
                        for(GeneralTree<Integer> child: children) {
                            cola.enqueue(child);
                        }
                    }
                    // 4. Preparamos la variable para la próxima vuelta del while (el próximo nivel)
                    nivelActual++;
                }
            }
            return esCreciente;
        }
        else
            return false;
        
    }

}
