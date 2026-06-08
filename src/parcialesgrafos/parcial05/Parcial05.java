package parcialesgrafos.parcial05;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio01.Edge;
import tp5.ejercicio01.Graph;
import tp5.ejercicio01.Vertex;

public class Parcial05 {
    
    public List<String> estadios(Graph<Estadio> mapaEstadios, String estadioOrigen, int cantKm) {
        List<String> listaEstadios = new LinkedList<String>();
        if (!mapaEstadios.isEmpty()) {
            Vertex<Estadio> origen = buscar(mapaEstadios, estadioOrigen);
            if (origen != null) {
                boolean[] marcas = new boolean[mapaEstadios.getSize()];
                List<String> listaActual = new LinkedList<String>();
                estadios(mapaEstadios, origen, marcas, listaEstadios, listaActual, cantKm);
            }
        }
        return listaEstadios;
    }

    private void estadios(Graph<Estadio> grafo, Vertex<Estadio> origen, boolean[] marcas, List<String> listaEstadios, List<String> listaActual, int cantKm) {
        marcas[origen.getPosition()] = true;
        listaActual.add(origen.getData().getNombre());
        for (Edge<Estadio> ady: grafo.getEdges(origen)) {
            int peso = ady.getWeight();
            Vertex<Estadio> vertexAux = ady.getTarget();
            if ((!marcas[vertexAux.getPosition()]) && (cantKm >= peso)) {
                estadios(grafo, vertexAux, marcas, listaEstadios, listaActual, cantKm - peso);
            }
        }
        if (listaActual.size() > listaEstadios.size()) {
            listaEstadios.clear();
            listaEstadios.addAll(listaActual);
        }
        marcas[origen.getPosition()] = false;
        listaActual.remove(listaActual.size() - 1);
    }

    private Vertex<Estadio> buscar(Graph<Estadio> mapaEstadios, String estadioOrigen) {
        Vertex<Estadio> estadioEncontrado = null;
        Iterator<Vertex<Estadio>> it = mapaEstadios.getVertices().iterator();
        while ((estadioEncontrado == null) && (it.hasNext())) {
            Vertex<Estadio> vertexAux = it.next();
            if (vertexAux.getData().getNombre().equals(estadioOrigen)) {
                estadioEncontrado = vertexAux;
            }
        }
        return estadioEncontrado;
    }
}
