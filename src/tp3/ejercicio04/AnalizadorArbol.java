package tp3.ejercicio04;

import tp1.ejercicio08.Queue;
import tp3.ejercicio01.GeneralTree;

// Se utilizará un recorrido por niveles (también conocido como Búsqueda en Anchura o BFS).
// El recorrido por niveles es el algoritmo idóneo para esto porque visita el árbol de manera horizontal
// (de arriba hacia abajo, de izquierda a derecha), procesando todos los nodos del nivel actual antes
// de pasar a los descendientes del siguiente nivel.

public class AnalizadorArbol {

    public double devolverMaximoPromedio (GeneralTree<AreaEmpresa> arbol) {
        
        double promedioMax = -1;

        if ((arbol != null) && (!arbol.isEmpty())) {
            Queue<GeneralTree<AreaEmpresa>> queue = new Queue<>();
            queue.enqueue(arbol);
            while (!queue.isEmpty()) {
                int cantNodosNivelActual = queue.size();
                int tiempoTotalNivelActual = 0;

                for (int i = 0; i < cantNodosNivelActual; i++) {
                    GeneralTree<AreaEmpresa> aux = queue.dequeue();
                    tiempoTotalNivelActual += aux.getData().getTiempoTardanza();
                    for (GeneralTree<AreaEmpresa> child: aux.getChildren())
                        queue.enqueue(child);
                }
                double promedioNivelActual = (double) tiempoTotalNivelActual / cantNodosNivelActual;
                if (promedioNivelActual > promedioMax)
                    promedioMax = promedioNivelActual;
                
            }
            
        }

        return promedioMax;
    }

    
}
