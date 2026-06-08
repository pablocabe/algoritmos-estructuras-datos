package parcialesgrafos.parcial06;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio01.Edge;
import tp5.ejercicio01.Graph;
import tp5.ejercicio01.Vertex;

public class Parcial06 {
    
    public List<String> caminoConPresupuesto(Graph<String> ciudades, String origen, String destino, int montoMaximo) {
        List<String> camino = new LinkedList<String>();
        if (!ciudades.isEmpty()) {
            Vertex<String> vertexOrigen = ciudades.search(origen);
            Vertex<String> vertexDestino = ciudades.search(destino);
            if ((vertexOrigen != null) && (vertexDestino != null)) {
                boolean[] marcas = new boolean[ciudades.getSize()];
                caminoConPresupuesto(ciudades, vertexOrigen, vertexDestino, camino, marcas, montoMaximo);
            }
        }
        return camino;
    }

    private boolean caminoConPresupuesto(Graph<String> grafo, Vertex<String> origen, Vertex<String> destino, List<String> camino, boolean[] marcas, int montoMaximo) {
        boolean encontre = false;
        marcas[origen.getPosition()] = true;
        camino.add(origen.getData());
        if (origen == destino) {
            encontre = true;
        }
        else {
            Iterator<Edge<String>> it = grafo.getEdges(origen).iterator();
            while ((!encontre) && (it.hasNext())) {
                Edge<String> e = it.next();
                int peso = e.getWeight();
                Vertex<String> vertexAux = e.getTarget();
                if ((!marcas[vertexAux.getPosition()]) && (montoMaximo >= peso)) {
                    encontre = caminoConPresupuesto(grafo, vertexAux, destino, camino, marcas, montoMaximo - peso);
                }
            }
        }

        if (!encontre) {
            camino.remove(camino.size() - 1);
        }
        marcas[origen.getPosition()] = false;
        return encontre;
    }
}
