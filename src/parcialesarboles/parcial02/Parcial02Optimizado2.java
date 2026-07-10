package parcialesarboles.parcial02;

import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio01.GeneralTree;

public class Parcial02Optimizado2 {

    public static List<Integer> caminoSignoAlternante(GeneralTree<Integer> arbol) {
        List<Integer> caminoMasCostoso = new LinkedList<Integer>();
        if ((arbol != null) && (!arbol.isEmpty())) {
            List<Integer> caminoActual = new LinkedList<Integer>();
            boolean esperaPositivo = !(arbol.getData() >= 0);
            caminoSignoAlternante(arbol, caminoMasCostoso, caminoActual, esperaPositivo);
        }
        return caminoMasCostoso;
    }

    private static void caminoSignoAlternante(GeneralTree<Integer> nodoActual, List<Integer> caminoMasCostoso, List<Integer> caminoActual, boolean esperaPositivo) {
        caminoActual.add(nodoActual.getData());
        if (nodoActual.isLeaf()) {
            if (caminoMasCostoso.isEmpty() || suma(caminoActual) > suma(caminoMasCostoso)) {
                caminoMasCostoso.clear();
                caminoMasCostoso.addAll(caminoActual);
            }
        }
        else {
            for (GeneralTree<Integer> child: nodoActual.getChildren()) {
                if ((esperaPositivo) == (child.getData() >= 0)) {
                    caminoSignoAlternante(child, caminoMasCostoso, caminoActual, !esperaPositivo);
                }
            }
        }
        caminoActual.remove(caminoActual.size() - 1);
    }

    private static int suma(List<Integer> lista) {
        int resultado = 0;
        for (Integer num: lista) {
            resultado += num;
        }
        return resultado;
    }
    
}
