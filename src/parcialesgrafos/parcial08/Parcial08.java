package parcialesgrafos.parcial08;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio01.Edge;
import tp5.ejercicio01.Graph;
import tp5.ejercicio01.Vertex;

public class Parcial08 {
    
    List<List<String>> rutasMultiples(Graph<String> zona, String baseRescate, String objetivo, int maxDuracion) {
        List<List<String>> listaFinal = new LinkedList<List<String>>();
        if (!zona.isEmpty()) {
            Vertex<String> origen = zona.search(baseRescate);
            Vertex<String> destino = zona.search(objetivo);
            if ((origen != null) && (destino != null)) {
                boolean[] marcas = new boolean[zona.getSize()];
                List<String> listaActual = new LinkedList<String>();
                rutasMultiples(zona, listaFinal, listaActual, origen, destino, marcas, maxDuracion);
            }
        }
        return listaFinal;
    }

    private void rutasMultiples(Graph<String> zona, List<List<String>> listaFinal, List<String> listaActual, Vertex<String> origen, Vertex<String> destino, boolean[] marcas, int maxDuracion) {
        marcas[origen.getPosition()] = true;
        listaActual.add(origen.getData());
        if (origen == destino) {
            listaFinal.add(new LinkedList<String>(listaActual));
        }
        else {
            for (Edge<String> ady: zona.getEdges(origen)) {
                Vertex<String> vertexAux = ady.getTarget();
                int j = vertexAux.getPosition();
                int peso = ady.getWeight();
                if ((!marcas[j]) && (maxDuracion >= peso)) {
                    rutasMultiples(zona, listaFinal, listaActual, vertexAux, destino, marcas, maxDuracion);
                }
            }
        }
        listaActual.remove(listaActual.size() - 1);
        marcas[origen.getPosition()] = false;
    }
}
