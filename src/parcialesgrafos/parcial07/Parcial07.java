package parcialesgrafos.parcial07;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio01.Edge;
import tp5.ejercicio01.Graph;
import tp5.ejercicio01.Vertex;

public class Parcial07 {
    
    public List<String> recorrido(Graph<String> grafo, int cantLocalidades, int cantNafta, List<String> localidadesExceptuadas) {
        LinkedList<String> camino = new LinkedList<String>();
        if (!grafo.isEmpty()) {
            Vertex<String> origen = grafo.search("Mendoza");
            if (origen != null) {
                boolean[] marcas = new boolean[grafo.getSize()];
                marcar(grafo, marcas, localidadesExceptuadas);
                recorrido(grafo, origen, camino, marcas, cantLocalidades, cantNafta);
            }
        }
        return camino;
    }

    private boolean recorrido(Graph<String> grafo, Vertex<String> origen, List<String> camino, boolean[] marcas, int cantLocalidades, int cantNafta) {
        boolean encontre = false;
        marcas[origen.getPosition()] = true;
        camino.add(origen.getData());
        if (camino.size() == cantLocalidades) {
            encontre = true;
        }
        else {
            Iterator<Edge<String>> it = grafo.getEdges(origen).iterator();
            while ((!encontre) && (it.hasNext())) {
                Edge<String> e = it.next();
                int peso = e.getWeight();
                int j = e.getTarget().getPosition();
                if ((!marcas[j] && (cantNafta >= peso))) {
                    encontre = recorrido(grafo, e.getTarget(), camino, marcas, cantLocalidades, cantNafta - peso);
                }
            }
        }
        if (!encontre) {
            camino.remove(camino.size() - 1);
        }
        marcas[origen.getPosition()] = false;
        return encontre;
    }

    private void marcar(Graph<String> grafo, boolean[] marcas, List<String> localidadesExceptuadas) {
        for (String l: localidadesExceptuadas) {
            Vertex<String> vertexAux = grafo.search(l);
            if (vertexAux != null) {
                marcas[vertexAux.getPosition()] = true;
            }
        }
    }

}
