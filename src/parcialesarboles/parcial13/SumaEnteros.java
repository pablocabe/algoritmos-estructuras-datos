package parcialesarboles.parcial13;

public class SumaEnteros {
    
    private int sumaTotal;
    private int sumaPositivos;
    private int sumaNegativos;

    public SumaEnteros(){
        this.sumaTotal = 0;
        this.sumaPositivos = 0;
        this.sumaNegativos = 0;
    }

    public void incrementarTotal(int num) {
        this.sumaTotal += num;
    }

    public void incrementarPositivos(int num) {
        this.sumaPositivos += num;
    }

    public void incrementarNegativos(int num) {
        this.sumaNegativos += num;
    }

    public int getSumaTotal() {
        return this.sumaTotal;
    }

    public int getSumaPositivos() {
        return this.sumaPositivos;
    }

    public int getSumaNegativos() {
        return this.sumaNegativos;
    }
    
}
