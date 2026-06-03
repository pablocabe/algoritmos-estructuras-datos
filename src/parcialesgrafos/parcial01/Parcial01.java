package parcialesgrafos.parcial01;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio01.Edge;
import tp5.ejercicio01.Graph;
import tp5.ejercicio01.Vertex;

public class Parcial01 {

    List<String> resolver (Graph<Ciudad> mapa, String ciudad, int cantDiasVacas) {
        List<String> caminoMaxCiudades = new LinkedList<String>();
        if (!mapa.isEmpty()) {
            Vertex<Ciudad> origen = this.buscar(mapa, ciudad);
            if (origen != null) {
                boolean[] marcas = new boolean[mapa.getSize()];
                List<String> caminoActual = new LinkedList<String>();
                int cantActuales = 0;
                resolverRecursivo(mapa, origen, marcas, caminoMaxCiudades, caminoActual, cantDiasVacas, cantActuales);
            }
        }
        return caminoMaxCiudades;
    }

    private void resolverRecursivo(Graph<Ciudad> mapa, Vertex<Ciudad> origen, boolean[] marcas, List<String> caminoMaxCiudades, List<String> caminoActual, int cantDiasVacas, int diasPreviosAcumulados) {
        marcas[origen.getPosition()] = true;
        caminoActual.add(origen.getData().getNombre());
        int diasTotalesAcumulados = diasPreviosAcumulados + origen.getData().getDias();
        if ((cantDiasVacas == diasTotalesAcumulados) && (caminoActual.size() > caminoMaxCiudades.size())) {
            caminoMaxCiudades.clear();
            caminoMaxCiudades.addAll(caminoActual);
        }
        else {
            List<Edge<Ciudad>> ady = mapa.getEdges(origen);
            for (Edge<Ciudad> e: ady) {
                Vertex<Ciudad> destino = e.getTarget();
                int j = destino.getPosition();
                if ((!marcas[j]) && (diasTotalesAcumulados + destino.getData().getDias() <= cantDiasVacas)) {
                    this.resolverRecursivo(mapa, destino, marcas, caminoMaxCiudades, caminoActual, cantDiasVacas, diasTotalesAcumulados);
                }
            }
        }
        marcas[origen.getPosition()] = false;
        caminoActual.remove(caminoActual.size() - 1);
    }

    private Vertex<Ciudad> buscar(Graph<Ciudad> mapa, String ciudad) {
        Vertex<Ciudad> ciudadEncontrada = null;
        Iterator<Vertex<Ciudad>> it = mapa.getVertices().iterator();
        while ((ciudadEncontrada == null) && (it.hasNext())) {
            Vertex<Ciudad> vertexAux = it.next();
            if (vertexAux.getData().getNombre().equals(ciudad)) {
                ciudadEncontrada = vertexAux;
            }
        }
        return ciudadEncontrada;
    }
}