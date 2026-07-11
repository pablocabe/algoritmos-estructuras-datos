package parcialesarboles.parcial23;

import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio01.GeneralTree;

public class Parcial23 {
    
    public static List<String> sucursalesAutosuficientes(GeneralTree<Sucursal> arbol) {
        List<String> lista = new LinkedList<String>();
        if (arbol != null && !arbol.isEmpty()) {
            resolver(arbol, lista);
        }
        return lista;
    }

    private static int resolver(GeneralTree<Sucursal> nodoActual, List<String> lista) {
        int cantAcumulado = 0;
        if (nodoActual.isLeaf()) {
            lista.add(nodoActual.getData().getNombre());
        }
        else {
            List<GeneralTree<Sucursal>> children = nodoActual.getChildren();
            for (GeneralTree<Sucursal> child : children) { 
                cantAcumulado += resolver(child, lista);
            }
            if (nodoActual.getData().getCantPaquetes() > cantAcumulado) { 
                lista.add(nodoActual.getData().getNombre());
            }
        }
        return cantAcumulado + nodoActual.getData().getCantPaquetes();
    }
}
