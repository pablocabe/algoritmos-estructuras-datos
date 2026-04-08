package tp2.ejercicio05;

import tp2.ejercicio01.BinaryTree;

public class ProfundidadDeArbolBinario {

    private BinaryTree<Integer> arbolBinario;

    public ProfundidadDeArbolBinario (BinaryTree<Integer> arbolBinario) {
        this.arbolBinario = arbolBinario;
    }

    public int sumaElementosProfundidad(int p) {
        return sumaRecursiva(this.arbolBinario, p);
    }

    // Consultar sobre si es necesasario preguntar siempre o solo una vez.
    public int sumaRecursiva(BinaryTree<Integer> nodo, int profundidadRestante) {
        // 1. Caso base nulo: si el árbol está vacío o llegamos a un nodo nulo
        if (nodo == null || nodo.isEmpty()) {
            return 0;
        }

        // 2. Caso base de éxito: llegamos al nivel que estábamos buscando
        if (profundidadRestante == 0) {
            return nodo.getData();
        }

        // 3. Paso recursivo: aún falta bajar más niveles (profundidadRestante > 0)
        int sumaIzquierda = 0;
        int sumaDerecha = 0;

        // Bajamos por la rama izquierda restando 1 a la profundidad
        if (nodo.hasLeftChild()) {
            sumaIzquierda = sumaRecursiva(nodo.getLeftChild(), profundidadRestante - 1);
        }
        
        // Bajamos por la rama derecha restando 1 a la profundidad
        if (nodo.hasRightChild()) {
            sumaDerecha = sumaRecursiva(nodo.getRightChild(), profundidadRestante - 1);
        }

        // Devolvemos la suma de lo que encontramos en ambas ramas
        return sumaIzquierda + sumaDerecha;
    }
    
}
