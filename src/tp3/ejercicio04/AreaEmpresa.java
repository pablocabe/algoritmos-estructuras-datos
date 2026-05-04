package tp3.ejercicio04;

public class AreaEmpresa {

    String identificacion;
    int tiempoTardanza;

    public AreaEmpresa(String identificacion, int tiempoTardanza) {
        this.identificacion = identificacion;
        this.tiempoTardanza = tiempoTardanza;
    }

    public String getIdentificacion() {
        return this.identificacion;
    }

    public int getTiempoTardanza() {
        return this.tiempoTardanza;
    }
}
