package tp3.ejercicio02;

import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio01.GeneralTree;

public class RecorridosAG {

    private GeneralTree<Integer> a;

    public RecorridosAG() {}

    public RecorridosAG(GeneralTree<Integer> a) {
        this.a = a;
    }

    // Método que retorna una lista con los elementos impares del árbol “a” 
    // que sean mayores al valor “n” pasados como parámetros, recorrido en preorden.
    public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n) {
        List<Integer> listaImparesMayores = new LinkedList<Integer>();
        if (!a.isEmpty())
            this.numerosImparesMayoresQuePreOrden(a, n, listaImparesMayores);
        return listaImparesMayores;
    }

    private void numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n, List<Integer> listaImparesMayores) {
        int datoActual = a.getData();
        if ((datoActual % 2 != 0) && (datoActual > n))
            listaImparesMayores.add(datoActual);
        List<GeneralTree<Integer>> children = a.getChildren();
        for (GeneralTree<Integer> child: children)
            this.numerosImparesMayoresQuePreOrden(child, n, listaImparesMayores);
    }

    // Método que retorna una lista con los elementos impares del árbol “a” 
    // que sean mayores al valor “n” pasados como parámetros, recorrido en inorden.
    public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n) {
        List<Integer> listaImparesMayores = new LinkedList<Integer>();
        if (!a.isEmpty())
            this.numerosImparesMayoresQueInOrden(a, n, listaImparesMayores);
        return listaImparesMayores;
    }

    private void numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n, List<Integer> listaImparesMayores) {
        List<GeneralTree<Integer>> children = a.getChildren();
        if (a.hasChildren())
            this.numerosImparesMayoresQueInOrden(children.get(0), n, listaImparesMayores);
        int datoActual = a.getData();
        if ((datoActual % 2 != 0) && (datoActual > n))
                listaImparesMayores.add(datoActual);
        for (int i = 1; i < children.size(); i++)
            this.numerosImparesMayoresQueInOrden(children.get(i), n, listaImparesMayores);
    }

    // Método que retorna una lista con los elementos impares del árbol “a” 
    // que sean mayores al valor “n” pasados como parámetros, recorrido en postorden.
    public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n) {
        List<Integer> listaImparesMayores = new LinkedList<Integer>();
        if (!a.isEmpty())
            this.numerosImparesMayoresQuePostOrden(a, n, listaImparesMayores);
        return listaImparesMayores;
    }

    private void numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n, List<Integer> listaImparesMayores){
        List<GeneralTree<Integer>> children = a.getChildren();
        for (GeneralTree<Integer> child: children)
            this.numerosImparesMayoresQuePreOrden(child, n, listaImparesMayores);
        int datoActual = a.getData();
        if ((datoActual % 2 != 0) && (datoActual > n))
                listaImparesMayores.add(datoActual);
    }
    
}
