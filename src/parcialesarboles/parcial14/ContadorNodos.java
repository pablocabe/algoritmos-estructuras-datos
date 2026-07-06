package parcialesarboles.parcial14;

public class ContadorNodos {
    
    private int cantNodos;
    private int cantPositivos;
    private int cantNegativos;

    public ContadorNodos(){
        this.cantNodos = 0;
        this.cantPositivos = 0;
        this.cantNegativos = 0;
    }

    public void incrementarCantNodos() {
        this.cantNodos++;
    }

    public void incrementarPositivos() {
        this.cantPositivos++;
    }

    public void incrementarNegativos() {
        this.cantNegativos++;
    }

    public int getCantNodos() {
        return this.cantNodos;
    }

    public int getCantPositivos() {
        return this.cantPositivos;
    }

    public int getCantNegativos() {
        return this.cantNegativos;
    }

}
