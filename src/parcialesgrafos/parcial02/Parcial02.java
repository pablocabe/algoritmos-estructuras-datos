package parcialesgrafos.parcial02;

import java.util.Iterator;

import tp5.ejercicio01.Graph;
import tp5.ejercicio01.Vertex;

public class Parcial02 {
    
    public int resolver(Graph<Recinto> sitios, int tiempo) {
        int cantidadMaximaRecintos = 0;
        if (!sitios.isEmpty()) {
            Vertex<Recinto> origen = buscar(sitios);
            if (origen != null) {
                int tiempoOrigen = origen.getData().getTiempo();
                if (tiempo > tiempoOrigen) {
                    boolean[] marcas = new boolean[sitios.getSize()];
                    // cantidadMaximaRecintos = resolverRecursivo(sitios, origen, marcas, tiempo - tiempoOrigen);
                }
                

            }
        }
        return cantidadMaximaRecintos;
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
