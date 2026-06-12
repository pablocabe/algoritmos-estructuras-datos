package parcialesgrafos.parcial04;

import java.util.List;

public class Camino {
    
    private List<String> sitios;
    private int cuadras;

    public Camino(List<String> sitios, int cuadras) {
        this.sitios = sitios;
        this.cuadras = cuadras;
    }

    public List<String> getSitios() {
        return sitios;
    }
    public void setSitios(List<String> sitios) {
        this.sitios = sitios;
    }
    public int getCuadras() {
        return cuadras;
    }
    public void setCuadras(int cuadras) {
        this.cuadras = cuadras;
    }

}
