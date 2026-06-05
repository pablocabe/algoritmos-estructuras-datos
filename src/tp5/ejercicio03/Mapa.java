package tp5.ejercicio03;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio01.Edge;
import tp5.ejercicio01.Graph;
import tp5.ejercicio01.Vertex;

public class Mapa {
    
    private Graph<String> mapaCiudades;

    public Mapa(Graph<String> mapa) {
        this.setMapaCiudades(mapa);
    }

    public Graph<String> getMapaCiudades() {
        return this.mapaCiudades;
    }

    public void setMapaCiudades(Graph<String> mapaCiudades) {
        this.mapaCiudades = mapaCiudades;
    }

    // Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso
    // de que se pueda llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible).
    // Devuelve el primer camino encontrado, por eso utilizo un while y no un for
    /* public List<String> devolverCamino(String ciudad1, String ciudad2) {
        List<String> camino = new LinkedList<String>();
        if (!this.mapaCiudades.isEmpty()) {
            Vertex<String> origen = this.mapaCiudades.search(ciudad1);
            Vertex<String> destino = this.mapaCiudades.search(ciudad2);
            if ((origen != null) && (destino != null)) {
                boolean[] marcas = new boolean[this.mapaCiudades.getSize()];
                devolverCamino(origen, destino, camino, marcas);
            }
        }
        return camino;
    }

    private boolean devolverCamino(Vertex<String> origen, Vertex<String> destino, List<String> camino, boolean[] marcas) {
        boolean encontre = false;
        marcas[origen.getPosition()] = true;
        camino.add(origen.getData());
        // Está bien así o es mejor utilizar equals?
        if (origen == destino) {
            encontre = true;
        }
        else {
            List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
            Iterator<Edge<String>> it = ady.iterator();
            while(!encontre && it.hasNext()) {
                Vertex<String> vertexAux = it.next().getTarget();
                int j = vertexAux.getPosition();
                if(!marcas[j]) {
                    encontre = devolverCamino(vertexAux, destino, camino, marcas);
                }
            }
        }
        if (!encontre) {
            camino.remove(camino.size() - 1);
        }
        return encontre;
    }
    */

    public List<String> devolverCamino(String ciudad1, String ciudad2) {
        List<String> camino = new LinkedList<String>();
        if (!this.mapaCiudades.isEmpty()) {
            Vertex<String> origen = this.mapaCiudades.search(ciudad1);
            Vertex<String> destino = this.mapaCiudades.search(ciudad2);
            if ((origen!= null) && (destino!= null)) {
                boolean[] marcas = new boolean[this.mapaCiudades.getSize()];
                devolverCamino(origen, destino, camino, marcas);
            }
        }
        return camino;
    }

    private boolean devolverCamino(Vertex<String> origen, Vertex<String> destino, List<String> camino, boolean[] marcas) {
        boolean encontre = false;
        marcas[origen.getPosition()] = true;
        camino.add(origen.getData());
        if (origen == destino) {
            encontre = true;
        }
        else {
            List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
            Iterator<Edge<String>> it = ady.iterator();
            while((!encontre) && (it.hasNext())) {
                Vertex<String> vertexAux = it.next().getTarget();
                int j = vertexAux.getPosition();
                if (!marcas[j]) {
                    encontre = devolverCamino(vertexAux, destino, camino, marcas);
                }
            }
        }
        if (!encontre) {
            camino.remove(camino.size() - 1);
        }
        return encontre;
    }

    // Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2, sin pasar por
    // las ciudades que están contenidas en la lista ciudades pasada por parámetro, si no existe
    // camino retorna la lista vacía. (Sin tener en cuenta el combustible).
    public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades) {
        List<String> camino = new LinkedList<String>();
        if (!this.mapaCiudades.isEmpty()) {
            Vertex<String> origen = this.mapaCiudades.search(ciudad1);
            Vertex<String> destino = this.mapaCiudades.search(ciudad2);
            if ((ciudad1 != null) && (ciudad2 != null)) {
                boolean[] marcas = new boolean[this.mapaCiudades.getSize()];
                marcasCiudadesRestringidas(ciudades, marcas);
                devolverCamino(origen, destino, camino, marcas);
            }
        }
        return camino;
    }

    public void marcasCiudadesRestringidas(List<String> ciudades, boolean[] marcas) {
        for (String ciudad: ciudades) {
            Vertex<String> vertexAux = this.mapaCiudades.search(ciudad);
            if (vertexAux != null) {
                marcas[vertexAux.getPosition()] = true;
            }
        }
    }

    // Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a
    // ciudad2, si no existe camino retorna la lista vacía. (Las rutas poseen la distancia).
    public List<String> caminoMasCorto(String ciudad1, String ciudad2) {
        List<String> caminoMinimo = new LinkedList<String>();
        if (!this.mapaCiudades.isEmpty()) {
            Vertex<String> origen = this.mapaCiudades.search(ciudad1);
            Vertex<String> destino = this.mapaCiudades.search(ciudad2);
            if ((origen != null) && (destino != null)) {
                boolean marcas[] = new boolean[this.mapaCiudades.getSize()];
                List<String> caminoActual = new LinkedList<String>();
                caminoMasCorto(origen, destino, caminoMinimo, caminoActual, marcas, 0, Integer.MAX_VALUE);
            }
        }
        return caminoMinimo;
    }

    private int caminoMasCorto(Vertex<String> origen, Vertex<String> destino, List<String> caminoMinimo, List<String> caminoActual, boolean[] marcas, int distanciaTotalActual, int distanciaMinima) {
        marcas[origen.getPosition()] = true;
        caminoActual.add(origen.getData());
        if ((origen == destino) && (distanciaTotalActual < distanciaMinima)) {
            caminoMinimo.removeAll(caminoMinimo);
            caminoMinimo.addAll(caminoActual);
            distanciaMinima = distanciaTotalActual;
        }
        else {
            List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
            Iterator<Edge<String>> it = ady.iterator();
            while ((distanciaTotalActual < distanciaMinima) && (it.hasNext())) {
                Edge<String> e = it.next();
                int j = e.getTarget().getPosition();
                int distanciaActualizada = distanciaTotalActual + e.getWeight();
                if ((!marcas[j] && (distanciaActualizada < distanciaMinima))) {
                    distanciaMinima = caminoMasCorto(e.getTarget(), destino, caminoMinimo, caminoActual, marcas, distanciaActualizada, distanciaMinima);
                }
            }
        }
        marcas[origen.getPosition()] = false;
        caminoActual.remove(caminoActual.size() - 1);
        return distanciaMinima;
    }

    // Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2. El auto
    // no debe quedarse sin combustible y no puede cargar. Si no existe camino retorna la lista vacía.
    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        List<String> camino = new LinkedList<String>();
        if (!this.mapaCiudades.isEmpty()) {
            Vertex<String> origen = this.mapaCiudades.search(ciudad1);
            Vertex<String> destino = this.mapaCiudades.search(ciudad2);
            if ((origen != null) && (destino != null)) {
                boolean[] marcas = new boolean[this.mapaCiudades.getSize()];
                int combustibleAcumulado = 0;
                caminoSinCargarCombustible(origen, destino, tanqueAuto, combustibleAcumulado, camino, marcas);
            }
        }
        return camino;
    }

    private boolean caminoSinCargarCombustible(Vertex<String> origen, Vertex<String> destino, int tanqueAuto, int combustibleAcumulado, List<String> camino, boolean[] marcas) {
        boolean encontre = false;
        marcas[origen.getPosition()] = true;
        camino.add(origen.getData());
        if (origen == destino) {
            encontre = true;
        }
        else {
            List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
            Iterator<Edge<String>> it = ady.iterator();
            while ((combustibleAcumulado < tanqueAuto) && (!encontre) && (it.hasNext())) {
                Edge<String> e = it.next();
                int j = e.getTarget().getPosition();
                // combustibleAcumulado <= tanqueAuto no es posible porque no puede quedarse sin combustible
                if ((!marcas[j]) && (combustibleAcumulado + e.getWeight() < tanqueAuto)) {
                    // La variable original combustibleAcumulado de la iteración actual no se modifica. Si devuelve false (no
                    // llega al destino), el while va a agarrar la siguiente arista (it.next()) y va a volver a hacer la suma
                    // partiendo del combustible original correcto, sin arrastrar el gasto de la ruta que falló.
                    encontre = caminoSinCargarCombustible(e.getTarget(), destino, tanqueAuto, combustibleAcumulado + e.getWeight(), camino, marcas);
                }
            }
        }
        if (!encontre) {
            camino.remove(camino.size() - 1);
        }
        marcas[origen.getPosition()] = false;
        return encontre;
    }

    // Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2
    // teniendo en cuenta que el auto debe cargar la menor cantidad de veces. El auto no se
    // debe quedar sin combustible en medio de una ruta, además puede completar su tanque al
    // llegar a cualquier ciudad. Si no existe camino retorna la lista vacía.
    public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        List<String> caminoMinimo = new LinkedList<String>();
        if (!this.mapaCiudades.isEmpty()) {
            Vertex<String> origen = this.mapaCiudades.search(ciudad1);
            Vertex<String> destino = this.mapaCiudades.search(ciudad2);
            if ((origen != null) && (destino != null)) {
                boolean[] marcas = new boolean[this.mapaCiudades.getSize()];
                List<String> caminoActual = new LinkedList<String>();
                int recargasActuales = 0;
                int recargasMinimas = Integer.MAX_VALUE;
                caminoConMenorCargaDeCombustible(origen, destino, marcas, caminoMinimo, caminoActual, tanqueAuto, tanqueAuto, recargasActuales, recargasMinimas);
            }
        }
        return caminoMinimo;
    }

    private int caminoConMenorCargaDeCombustible(Vertex<String> origen, Vertex<String> destino, boolean[] marcas, List<String> caminoMinimo, List<String> caminoActual, int tanqueAuto, int tanqueActual, int recargasActuales, int recargasMinimas) {
        marcas[origen.getPosition()] = true;
        caminoActual.add(origen.getData());
        if ((origen == destino) && (recargasActuales < recargasMinimas)) {
            caminoMinimo.removeAll(caminoMinimo);
            caminoMinimo.addAll(caminoActual);
            recargasMinimas = recargasActuales;
        }
        else {
            List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
            Iterator<Edge<String>> it = ady.iterator();
            while ((recargasActuales < recargasMinimas) && (it.hasNext())) {
                Edge<String> e = it.next();
                int j = e.getTarget().getPosition();
                int distancia = e.getWeight();
                if (!marcas[j]) {
                    if (tanqueActual >= distancia) {
                        recargasMinimas = caminoConMenorCargaDeCombustible(e.getTarget(), destino, marcas, caminoMinimo, caminoActual, tanqueAuto, tanqueActual - distancia, recargasActuales, recargasMinimas);
                    }
                    else if (tanqueAuto >= distancia) {
                        recargasMinimas = caminoConMenorCargaDeCombustible(origen, destino, marcas, caminoMinimo, caminoActual, tanqueAuto - distancia, tanqueActual, recargasActuales + 1, recargasMinimas);
                    }
                }
            }
        }
        marcas[origen.getPosition()] = false;
        caminoActual.remove(caminoActual.size() - 1);
        return recargasMinimas;
    }
}
