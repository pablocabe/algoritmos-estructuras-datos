package parcialesarboles.parcial02;

import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio01.GeneralTree;

public class Parcial02Optimizado {

    public static List<Integer> caminoSignoAlternante(GeneralTree<Integer> arbol) {
        List<Integer> caminoFinal = new LinkedList<Integer>();
        if ((arbol != null) && (!arbol.isEmpty())) {
            List<Integer> caminoActual = new LinkedList<Integer>();
            boolean esperaPositivo = !(arbol.getData() >= 0);
            Maximo valorCaminoFinal = new Maximo();
            int valorCaminoActual = 0;
            metodoRecursivo(arbol, caminoFinal, caminoActual, esperaPositivo, valorCaminoFinal, valorCaminoActual);
        }
        return caminoFinal;
    }

    public static void metodoRecursivo(GeneralTree<Integer> nodoActual, List<Integer> caminoFinal, List<Integer> caminoActual, boolean esperaPositivo, Maximo valorCaminoFinal, int valorCaminoActual) {
        caminoActual.add(nodoActual.getData());
        valorCaminoActual += nodoActual.getData();
        if ((nodoActual.isLeaf()) && (valorCaminoActual > valorCaminoFinal.getValor())) {
            caminoFinal.clear();
            caminoFinal.addAll(caminoActual);
            valorCaminoFinal.setValor(valorCaminoActual);
        }
        else {
            for (GeneralTree<Integer> child: nodoActual.getChildren()) {
                if (esperaPositivo == (child.getData() >= 0)) {
                    metodoRecursivo(child, caminoFinal, caminoActual, !esperaPositivo, valorCaminoFinal, valorCaminoActual);
                }
            }
        }
        caminoActual.remove(caminoActual.size() - 1);
    }
}