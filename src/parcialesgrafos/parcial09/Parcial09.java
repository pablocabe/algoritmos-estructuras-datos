package parcialesgrafos.parcial09;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio01.Edge;
import tp5.ejercicio01.Graph;
import tp5.ejercicio01.Vertex;

public class Parcial09 {
    
    public List<String> rutaOptimaDistribucion(Graph<String> reino, String castillo, String aldea, int maxPociones) {
        List<String> caminoOptimo = new LinkedList<String>();
        if (!reino.isEmpty()) {
            Vertex<String> origen = reino.search(castillo);
            Vertex<String> destino = reino.search(aldea);
            if ((origen != null) && (destino != null)) {
                boolean[] marcas = new boolean[reino.getSize()];
                List<String> caminoActual = new LinkedList<String>();
                rutaOptimaDistribucion(reino, origen, destino, marcas, caminoOptimo, caminoActual, maxPociones);
            }
        }
        return caminoOptimo;
    }

    private void rutaOptimaDistribucion(Graph<String> grafo, Vertex<String> origen, Vertex<String> destino, boolean[] marcas, List<String> caminoOptimo, List<String> caminoActual, int maxPociones) {
        marcas[origen.getPosition()] = true;
        caminoActual.add(origen.getData());
        if ((origen == destino) && (caminoActual.size() > caminoOptimo.size())) {
            caminoOptimo.clear();
            caminoOptimo.addAll(caminoActual);
        }
        else {
            for (Edge<String> e: grafo.getEdges(origen)) {
                int peso = e.getWeight();
                int j = e.getTarget().getPosition();
                if ((!marcas[j]) && (maxPociones >= peso)) {
                    rutaOptimaDistribucion(grafo, e.getTarget(), destino, marcas, caminoOptimo, caminoActual, maxPociones - peso);
                }
            }
        }
        marcas[origen.getPosition()] = false;
        caminoActual.remove(caminoActual.size() - 1);
    }
}
