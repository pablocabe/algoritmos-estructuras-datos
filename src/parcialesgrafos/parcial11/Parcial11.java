package parcialesgrafos.parcial11;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio01.Edge;
import tp5.ejercicio01.Graph;
import tp5.ejercicio01.Vertex;

public class Parcial11 {
    
    public List<String> distanciasMinimas(Graph<String> grafo) {
        List<String> resultados = new LinkedList<String>();
        
        if (grafo != null && !grafo.isEmpty()) {
            List<Vertex<String>> vertices = grafo.getVertices();
            // Evaluamos cada almacén como vértice origen 's'
            for (Vertex<String> origen : vertices) {
                // Obtenemos el arreglo de distancias mínimas (D)
                int[] D = dijkstra(grafo, origen);
                // Armamos las cadenas de resultado para este origen
                for (Vertex<String> destino : vertices) {
                    if (origen != destino) {
                        int dist = D[destino.getPosition()];
                        // Si la distancia no es infinito, existe un camino
                        if (dist != Integer.MAX_VALUE) {
                            resultados.add("(" + origen.getData() + " -> " + destino.getData() + ": " + dist + ")");
                        }
                    }
                }
            }
        }
        return resultados;
    }

    // Algoritmo de Dijkstra respetando el pseudocódigo de la cátedra
    private int[] dijkstra(Graph<String> grafo, Vertex<String> s) {
        List<Vertex<String>> vertices = grafo.getVertices();
        int n = vertices.size(); 
        // Estructuras de la cátedra
        int[] D = new int[n];
        boolean[] conocido = new boolean[n];
        // (1) y (2) Inicialización: para cada vértice v
        for (int i = 0; i < n; i++) {
            D[i] = Integer.MAX_VALUE; // Representa el infinito
            conocido[i] = false;
        }
        // (3) Distancia al origen s es 0
        D[s.getPosition()] = 0;
        // (4) para cada vértice v
        for (int i = 0; i < n; i++) {
            // (5) u = verticeDesconocidoMenorDist
            Vertex<String> u = null;
            int menorDist = Integer.MAX_VALUE;
            for (Vertex<String> v : vertices) {
                int pos = v.getPosition();
                if (!conocido[pos] && D[pos] <= menorDist) {
                    menorDist = D[pos];
                    u = v;
                }
            }
            // Si no quedan vértices alcanzables, cortamos
            if (u == null || menorDist == Integer.MAX_VALUE) {
                break;
            }
            // (6) Marcar u como conocido
            conocido[u.getPosition()] = true;
            int posU = u.getPosition();
            // (7) para cada vértice w adyacente a u
            for (Edge<String> arista : grafo.getEdges(u)) {
                Vertex<String> w = arista.getTarget();
                int posW = w.getPosition();
                int costo = arista.getWeight(); // c(u,w)
                // (8) si (w no está conocido)
                if (!conocido[posW]) {
                    // (9) si (D_w > D_u + c(u,w))
                    if (D[posW] > D[posU] + costo) {
                        // (10) D_w = D_u + c(u,w)
                        D[posW] = D[posU] + costo;
                    }
                }
            }
        }
        return D;
    }

}
