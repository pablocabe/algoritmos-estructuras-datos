package tp5.ejercicio03;

import tp5.ejercicio01.Graph;

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

    
}
