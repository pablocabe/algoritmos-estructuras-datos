package parcialesgrafos.parcial15;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio01.Edge;
import tp5.ejercicio01.Graph;
import tp5.ejercicio01.Vertex;

public class Parcial15 {
    
    public List<String> rutaConCifrado(Graph<String> red, String destino) {
        List<String> lista = new LinkedList<String>();
        if (!red.isEmpty()) {
            Vertex<String> o = red.search("NodoRaiz");
            Vertex<String> d = red.search(destino);
            if ((o != null) && (d != null)) {
                boolean[] marcas = new boolean[red.getSize()];
                boolean esperaPar = false;
                rutaConCifrado(red, o, d, marcas, lista, esperaPar);
            }
        }
        return lista;
    }

    private boolean rutaConCifrado(Graph<String> grafo, Vertex<String> origen, Vertex<String> destino, boolean[] marcas, List<String> lista, boolean esperaPar) {
        marcas[origen.getPosition()] = true;
        boolean encontre = false;
        lista.add(origen.getData());
        if (origen == destino) {
            encontre = true;
        }
        else {
            List<Edge<String>> ady = grafo.getEdges(origen);
            Iterator<Edge<String>> it = ady.iterator();
            while ((!encontre) && (it.hasNext())) {
                // Me faltó <String>
                Edge<String> e = it.next();
                int j = e.getTarget().getPosition();
                int peso = e.getWeight();
                // Puse MOD en vez de %
                boolean esPar = (peso % 2 == 0);
                // Puse = en vez de ==
                if ((!marcas[j]) && (esperaPar == esPar)) {
                    encontre = rutaConCifrado(grafo, e.getTarget(), destino, marcas, lista, !esperaPar);
                }
            }
        }
        if (!encontre) {
            lista.remove(lista.size() - 1);
        }
        marcas[origen.getPosition()] = false;
        return encontre;
    }
}
