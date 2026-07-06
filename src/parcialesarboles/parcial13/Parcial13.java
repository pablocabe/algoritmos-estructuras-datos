package parcialesarboles.parcial13;

import tp3.ejercicio01.GeneralTree;

public class Parcial13 {
    
    public Integer resolver(GeneralTree<Integer> arbol) {
        int resultado = 0;
        SumaEnteros sumaEnteros = new SumaEnteros();
        if ((arbol != null) && (!arbol.isEmpty())) {
            resolver(arbol, sumaEnteros);
        }
        if ((sumaEnteros.getSumaTotal() % 2) == 0)
            resultado = sumaEnteros.getSumaPositivos();
        else
            resultado = sumaEnteros.getSumaNegativos();
        return resultado;
    }

    private void resolver(GeneralTree<Integer> nodoActual, SumaEnteros sumaEnteros) {
        for (GeneralTree<Integer> child: nodoActual.getChildren()) {
            resolver(child, sumaEnteros);
        }
        int num = nodoActual.getData();
        sumaEnteros.incrementarTotal(num);
        if (num >= 0)
            sumaEnteros.incrementarPositivos(num);
        else
            sumaEnteros.incrementarNegativos(num);
    }
}
