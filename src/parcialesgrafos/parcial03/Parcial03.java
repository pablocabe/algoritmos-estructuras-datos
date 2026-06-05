package parcialesgrafos.parcial03;

import java.util.Iterator;

import tp5.ejercicio01.Edge;
import tp5.ejercicio01.Graph;
import tp5.ejercicio01.Vertex;

public class Parcial03 {
    
    public String resolver(Graph<Recinto> sitios, int tiempo) {
        String resultado = "No es alcanzable";
        boolean esAlcanzable = false;
        if (!sitios.isEmpty()) {
            Vertex<Recinto> origen = buscar(sitios);
            if (origen != null) {
                int tiempoOrigen = origen.getData().getTiempo();
                if (tiempo >= tiempoOrigen) {
                    boolean[] marcas = new boolean[sitios.getSize()];
                    int cantidadTotalSitios = sitios.getSize();
                    int cantActualSitios = 1;
                    esAlcanzable = resolverRecursivo(sitios, marcas, origen, tiempo - tiempoOrigen, cantidadTotalSitios, cantActualSitios);
                }
            }
        }
        if (esAlcanzable) {
            resultado = "Alcanzable";
        }
        return resultado;
    }

    private boolean resolverRecursivo(Graph<Recinto> grafo, boolean[] marcas, Vertex<Recinto> origen, int tiempo, int cantidadTotalSitios, int cantActualSitios) {
        boolean esAlcanzable = false;
        marcas[origen.getPosition()] = true;
        if (cantidadTotalSitios == cantActualSitios) {
            esAlcanzable = true;
        }
        else {
            Iterator<Edge<Recinto>> it = grafo.getEdges(origen).iterator();
            while ((!esAlcanzable) && (it.hasNext())) {
                Edge<Recinto> ady = it.next();
                Vertex<Recinto> vertexAux = ady.getTarget();
                int peso = ady.getWeight() + vertexAux.getData().getTiempo();
                int j = vertexAux.getPosition();
                if ((!marcas[j]) && (tiempo >= peso)) {
                    esAlcanzable = resolverRecursivo(grafo, marcas, vertexAux, tiempo - peso, cantidadTotalSitios, cantActualSitios + 1);
                }
            }
        }
        marcas[origen.getPosition()] = false;
        return esAlcanzable;
    }

    private Vertex<Recinto> buscar(Graph<Recinto> grafo) {
        Vertex<Recinto> sitioEncontrado = null;
        Iterator<Vertex<Recinto>> it = grafo.getVertices().iterator();
        while ((sitioEncontrado == null) && (it.hasNext())) {
            Vertex<Recinto> vertexAux = it.next();
            if (vertexAux.getData().getNombre().equals("Entrada")){
                sitioEncontrado = vertexAux;
            }
        }
        return sitioEncontrado;
    }

}
