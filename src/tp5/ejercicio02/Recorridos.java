package tp5.ejercicio02;

import java.util.LinkedList;
import java.util.List;
import tp5.ejercicio01.Graph;
import tp5.ejercicio01.Vertex;
import tp5.ejercicio01.Edge;

public class Recorridos<T> {


    // Retorna una lista con los datos de los vértices, con el recorrido en profundidad del grafo recibido como parámetro.
    // O(V+E) V: numero de vertices y E: numero de aristas
    public List<T> dfs(Graph<T> grafo) {
        boolean[] marca = new boolean[grafo.getSize()];
        List<T> listaResultado = new LinkedList<T>();
        for (int i = 0 ; i < grafo.getSize() ; i++) {
            if (!marca[i]) {
                System.out.println("Parto desde: " + grafo.getVertex(i).getData());
                dfs(grafo, listaResultado, marca, i);
            }
        }
        return listaResultado;
    }


    public void dfs(Graph<T> grafo, List<T> listaResultado, boolean[] marca, int i) {
        marca[i] = true;
        Vertex<T> verticeAux = grafo.getVertex(i);
        // System.out.println("Vertice: " + verticeAux);
        listaResultado.add(verticeAux.getData());
        List<Edge<T>> edges = grafo.getEdges(verticeAux);
        for (Edge<T> e: edges) {
            int j = e.getTarget().getPosition();
            if (!marca[j]) {
                dfs(grafo, listaResultado, marca, j);
            }
        }

        /*
        El for es equivalente a:
        Iterator<Edge<T>> it = adyacentes.iterator();
        while (it.hasNext()) {
            int j = it.next().getTarget().getPosition();
            if (!marca[j]){ 
                dfs(j, grafo, marca);
            }
        }
        */
    }
    

    // Retorna una lista con los datos de vértices, con el recorrido en amplitud del grafo recibido como parámetro.
    public List<T> bfs(Graph<T> grafo){
        return null;
    }
    
}
