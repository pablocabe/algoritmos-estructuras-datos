package tp3.ejercicio02;

import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio08.Queue;
import tp3.ejercicio01.GeneralTree;

public class RecorridosAG {

    // Método que retorna una lista con los elementos impares del árbol “a” 
    // que sean mayores al valor “n” pasados como parámetros, recorrido en preorden.
    public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n) {
        List<Integer> listaImparesMayores = new LinkedList<Integer>();
        if ((a != null) && (!a.isEmpty()))
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
        if ((a != null) && (!a.isEmpty()))
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
        if ((a != null) && (!a.isEmpty()))
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

    // Método que retorna una lista con los elementos impares del árbol “a”
    // que sean mayores al valor “n” pasados como parámetros, recorrido por niveles.
    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n) {
        List<Integer> listaImparesMayores = new LinkedList<Integer>();
        if ((a != null) && (!a.isEmpty())) {
            int datoActual;
            GeneralTree<Integer> aux;
            Queue<GeneralTree<Integer>> queue = new Queue<>();
            queue.enqueue(a);
            while (!queue.isEmpty()) {
                aux = queue.dequeue();
                datoActual = aux.getData();
                if ((datoActual % 2 != 0) && (datoActual > n))
                    listaImparesMayores.add(datoActual);
                for (GeneralTree<Integer> child: aux.getChildren())
                    queue.enqueue(child);
            }
        }
        return listaImparesMayores;
    }

}
