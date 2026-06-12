package parcialesgrafos.parcial10;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio01.Edge;
import tp5.ejercicio01.Graph;
import tp5.ejercicio01.Vertex;

public class Parcial10 {
    
    public List<String> caminoConMayorDistorsionDelRumor(Graph<String> red, String origen) {
        List<String> listaFinal = new LinkedList<String>();
        if (!red.isEmpty()) {
            Vertex<String> origenVertex = red.search(origen);
            if (origenVertex != null) {
                int cantPersonas = red.getSize();
                int distanciaActual = 0;
                int distanciaMaxima = -1;
                boolean[] marcas = new boolean[cantPersonas];
                List<String> listaActual = new LinkedList<String>();
                caminoConMayorDistorsionDelRumor(red, origenVertex, marcas, listaFinal, listaActual, cantPersonas, distanciaActual, distanciaMaxima);
            }
        }
        return listaFinal;
    }

    private int caminoConMayorDistorsionDelRumor(Graph<String> grafo, Vertex<String> origen, boolean[] marcas, List<String> listaFinal, List<String> listaActual, int cantPersonas, int distanciaActual, int distanciaMaxima) {
        marcas[origen.getPosition()] = true;
        listaActual.add(origen.getData());
        if (listaActual.size() == cantPersonas) {
            if (distanciaActual > distanciaMaxima) {
                distanciaMaxima = distanciaActual;
                listaFinal.clear();
                listaFinal.addAll(listaActual);
            }
        }
        else {
            for (Edge<String> ady: grafo.getEdges(origen)) {
                int j = ady.getTarget().getPosition();
                int peso = ady.getWeight();
                if (!marcas[j]) {
                    distanciaMaxima = caminoConMayorDistorsionDelRumor(grafo, ady.getTarget(), marcas, listaFinal, listaActual, cantPersonas, distanciaActual + peso, distanciaMaxima);
                }
            }
        }
        listaActual.remove(listaActual.size() - 1);
        marcas[origen.getPosition()] = false;
        return distanciaMaxima;
    }
}
