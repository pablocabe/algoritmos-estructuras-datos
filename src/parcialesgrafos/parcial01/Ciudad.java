package parcialesgrafos.parcial01;

public class Ciudad {

    private String nombre;
    private int dias;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public Ciudad(String nombre, int dias) {
        this.nombre = nombre;
        this.dias = dias;
    }

}
