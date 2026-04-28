package tp3.ejercicio09;

import tp3.ejercicio01.GeneralTree;

import java.util.Iterator;
import java.util.List;

// Un árbol general es de selección si cada nodo tiene en su raíz el valor del menor de sus hijos

public class ParcialArbolesOptimizado {

    // Devuelve true si el árbol recibido por parámetro es de selección, falso sino lo es
    public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
        if (arbol != null && !arbol.isEmpty()){
            return esDeSeleccionRecursivo(arbol);
        }
        return false;
    }

    private static boolean esDeSeleccionRecursivo(GeneralTree<Integer> arbol) {
        if (arbol.isLeaf()) {
            return true;
        }

        int minimoHijos = Integer.MAX_VALUE;
        List<GeneralTree<Integer>> children = arbol.getChildren();
        Iterator<GeneralTree<Integer>> iterator = children.iterator();
        // Puedo usar un for en vez de un while?
        while (iterator.hasNext()) {
            GeneralTree<Integer> child = iterator.next();
            if (!esDeSeleccionRecursivo(child)) {
                return false;
            }
            minimoHijos = Math.min(minimoHijos, child.getData());
        }

        // Si el bucle logró terminar sin que ningún "return false" lo corte, 
        // significa que todos los hijos están bien. Solo nos queda revisar este nodo:
        return arbol.getData().equals(minimoHijos);
    }
}


/*
// Todo el while y el iterator se resumen a esto:
for (GeneralTree<Integer> child : arbol.getChildren()) {
    if (!esDeSeleccionRecursivo(child)) {
        return false;
    }
    minimoHijos = Math.min(minimoHijos, child.getData());
}
*/
