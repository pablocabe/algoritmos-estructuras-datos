package parcialesarboles.parcial05;

public class Resultado {

    private int numeroPar;
    private int nivelActual;

    public Resultado() {
        this.numeroPar = -1;
        this.nivelActual = -1;
    }

    public void setNivelActual(int nivelActual) {
        this.nivelActual = nivelActual;
    }

    public void setNumeroPar(int numeroPar){
        this.numeroPar = numeroPar;
    }

    public int getNivelActual(){
        return this.nivelActual;
    }

    public int getNumeroPar() {
        return this.numeroPar;
    }

}
