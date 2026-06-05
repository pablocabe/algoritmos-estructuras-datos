package parcialesgrafos.parcial02;

import java.util.Iterator;

import tp5.ejercicio01.Edge;
import tp5.ejercicio01.Graph;
import tp5.ejercicio01.Vertex;

public class Parcial02 {
    
    public int resolver(Graph<Recinto> sitios, int tiempo) {
        int cantidadMaxFinal = 0;
        if (!sitios.isEmpty()) {
            Vertex<Recinto> origen = buscar(sitios);
            if (origen != null) {
                int tiempoOrigen = origen.getData().getTiempo();
                if (tiempo > tiempoOrigen) {
                    boolean[] marcas = new boolean[sitios.getSize()];
                    int cantMax = 0;
                    int cantActual = 1; // Origen ya lo procese
                    cantidadMaxFinal = resolverRecursivo(sitios, origen, marcas, tiempo - tiempoOrigen, cantMax, cantActual);
                }
            }
        }
        return cantidadMaxFinal;
    }

    private int resolverRecursivo(Graph<Recinto> grafo, Vertex<Recinto> origen, boolean[] marcas, int tiempo, int cantMax, int cantActual) {
        marcas[origen.getPosition()] = true;
        for (Edge<Recinto> ady : grafo.getEdges(origen)) {
            Vertex<Recinto> destino = ady.getTarget();
            int peso = ady.getWeight() + destino.getData().getTiempo(); // Le sumo la arista para moverse + el peso del futuro vertice
            int j = destino.getPosition();
            if ((!marcas[j]) && (tiempo > peso)) {
                cantMax = resolverRecursivo(grafo, destino, marcas, tiempo - peso, cantMax, cantActual + 1);
            }
        }
        marcas[origen.getPosition()] = false;
        if (cantActual > cantMax) {
            cantMax = cantActual;
        }
        return cantMax;
    }

    private Vertex<Recinto> buscar(Graph<Recinto> sitios) {
        Vertex<Recinto> sitioEncontrado = null;
        Iterator<Vertex<Recinto>> it = sitios.getVertices().iterator();
        while ((sitioEncontrado == null) && (it.hasNext())) {
            Vertex<Recinto> vertexAux = it.next();
            if (vertexAux.getData().getNombre().equals("Entrada")) {
                sitioEncontrado = vertexAux;
            }
        }
        return sitioEncontrado;
    }
}
