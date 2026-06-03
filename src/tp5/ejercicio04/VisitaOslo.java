package tp5.ejercicio04;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio01.Graph;
import tp5.ejercicio01.Vertex;
import tp5.ejercicio01.Edge;

public class VisitaOslo {

    public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos) {
        List<String> camino = new LinkedList<String>();
        if (!lugares.isEmpty()) {
            Vertex<String> origenVertex = lugares.search("Ayuntamiento");
            Vertex<String> destinoVertex = lugares.search(destino);
            if ((origenVertex != null) && (destinoVertex != null)) {
                boolean[] marcas = new boolean[lugares.getSize()];
                marcarLugaresRestringidos(lugares, marcas, lugaresRestringidos);
                paseoEnBici(lugares, origenVertex, destinoVertex, camino, marcas, maxTiempo);
            }
        }
        return camino;
    }

    private void marcarLugaresRestringidos(Graph<String> lugares, boolean[] marcas, List<String> lugaresRestringidos) {
        for (String lugar: lugaresRestringidos) {
            Vertex<String> lugarVertex = lugares.search(lugar);
            if (lugarVertex != null) {
                marcas[lugarVertex.getPosition()] = true;
            }
        }
    }

    private boolean paseoEnBici(Graph<String> lugares, Vertex<String> origenVertex, Vertex<String> destinoVertex, List<String> camino, boolean[] marcas, int maxTiempo) {
        boolean encontre = false;
        marcas[origenVertex.getPosition()] = true;
        camino.add(origenVertex.getData());
        if (origenVertex == destinoVertex) {
            encontre = true;
        }
        else {
            List<Edge<String>> ady = lugares.getEdges(origenVertex);
            Iterator<Edge<String>> it = ady.iterator();
            while ((!encontre) && (it.hasNext())) {
                Edge<String> e = it.next();
                int j = e.getTarget().getPosition();
                if ((marcas[j]) && (maxTiempo - e.getWeight() >= 0)) {
                    paseoEnBici(lugares, e.getTarget(), destinoVertex, camino, marcas, maxTiempo - e.getWeight());
                }
            }
        }

        if (!encontre) {
            camino.remove(camino.size() - 1);
        }
        marcas[origenVertex.getPosition()] = false;
        return encontre;
    }
    
}
