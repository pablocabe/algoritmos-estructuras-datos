package parcialesarboles.parcial04;

public class Valores {

    private int sumaNumerosPositivos;
    private int cantNodos;
    private int cantHojas;

    public Valores() {
        this.sumaNumerosPositivos = 0;
        this.cantNodos = 0;
        this.cantHojas = 0;
    }

    public int getSumaNumerosPositivos() {
        return sumaNumerosPositivos;
    }

    public void setSumaNumerosPositivos(int sumaNumerosPositivos) {
        this.sumaNumerosPositivos = sumaNumerosPositivos;
    }

    public int getCantNodos() {
        return cantNodos;
    }

    public void setCantNodos(int cantNodos) {
        this.cantNodos = cantNodos;
    }

    public int getCantHojas() {
        return cantHojas;
    }

    public void setCantHojas(int cantHojas) {
        this.cantHojas = cantHojas;
    }

}
