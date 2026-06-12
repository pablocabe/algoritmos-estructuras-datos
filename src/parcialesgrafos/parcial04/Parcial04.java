package parcialesgrafos.parcial04;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio01.Edge;
import tp5.ejercicio01.Graph;
import tp5.ejercicio01.Vertex;

public class Parcial04 {
    
    public List<Camino> resolver(Graph<String> sitios, String origen, String destino, List<String> evitarPasarPor) {
        List<Camino> listaCaminos = new LinkedList<>();
        if (!sitios.isEmpty()) {
            Vertex<String> vertexOrigen = sitios.search(origen);
            Vertex<String> vertexDestino = sitios.search(destino);
            if ((vertexOrigen != null) && (vertexDestino != null)) {
                boolean[] marcas = new boolean[sitios.getSize()];
                if (evitarPasarPor != null) {
                    marcarSitios(sitios, evitarPasarPor, marcas);
                }
                List<String> caminoActual = new LinkedList<String>();
                int cantCuadrasAcumuladas = 0;
                resolver(sitios, vertexOrigen, vertexDestino, marcas, listaCaminos, caminoActual, cantCuadrasAcumuladas);
            }
        }
        return listaCaminos;
    }

    private void resolver(Graph<String> grafo, Vertex<String> origen, Vertex<String> destino, boolean[] marcas, List<Camino> listaCaminos, List<String> caminoActual, int cantCuadrasAcumuladas) {
        marcas[origen.getPosition()] = true;
        caminoActual.add(origen.getData());
        if (origen == destino) {
            listaCaminos.add(new Camino (new LinkedList<String>(caminoActual), cantCuadrasAcumuladas));
        }
        else {
            for (Edge<String> e: grafo.getEdges(origen)) {
                int j = e.getTarget().getPosition();
                int peso = e.getWeight();
                if (!marcas[j]) {
                    resolver(grafo, e.getTarget(), destino, marcas, listaCaminos, caminoActual, cantCuadrasAcumuladas + peso);
                }
            }
        }
        caminoActual.remove(caminoActual.size() - 1);
        marcas[origen.getPosition()] = false;
    }

    private void marcarSitios(Graph<String> grafo, List<String> lista, boolean[] marcas) {
        Vertex<String> v = null;
        for (String l: lista) {
            v = grafo.search(l);
            if (v != null) {
                marcas[v.getPosition()] = true;
            }
        }
    }
}
