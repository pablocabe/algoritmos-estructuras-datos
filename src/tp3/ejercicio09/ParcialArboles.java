package tp3.ejercicio09;

import tp3.ejercicio01.GeneralTree;

import java.util.Iterator;
import java.util.List;

// Un árbol general es de selección si cada nodo tiene en su raíz el valor del menor de sus hijos

public class ParcialArboles {

    // Devuelve true si el árbol recibido por parámetro es de selección, falso sino lo es
    public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
        if (arbol != null && !arbol.isEmpty()){
            return esDeSeleccionRecursivo(arbol);
        }
        return false;
    }

    private static boolean esDeSeleccionRecursivo(GeneralTree<Integer> arbol) {
        if (arbol.isLeaf())
            return true;

        int minimoHijos = Integer.MAX_VALUE;
        boolean ok = true;
        List<GeneralTree<Integer>> children = arbol.getChildren();
        Iterator<GeneralTree<Integer>> iterator = children.iterator();
        while ((ok) && (iterator.hasNext())) {
            GeneralTree<Integer> child = iterator.next();
            minimoHijos = Math.min(minimoHijos, child.getData());
            ok = esDeSeleccionRecursivo(child);
        }

        return ((ok) && (arbol.getData().equals(minimoHijos)));
    }

    
}
