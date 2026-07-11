package parcialesarboles.parcial23;

public class Sucursal {

    private String nombre;
    private int cantPaquetes;

    public Sucursal(String nombre, int cantPaquetes) {
        this.nombre = nombre;
        this.cantPaquetes = cantPaquetes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setCantPaquetes(int cantPaquetes) {
        this.cantPaquetes = cantPaquetes;
    }

    public int getCantPaquetes() {
        return this.cantPaquetes;
    }

}
