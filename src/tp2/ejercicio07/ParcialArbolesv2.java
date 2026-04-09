package tp2.ejercicio07;

import tp2.ejercicio01.BinaryTree;

public class ParcialArbolesv2 {

    private BinaryTree<Integer> arbolBinario;

    public ParcialArbolesv2(BinaryTree<Integer> arbolBinario) {
        this.arbolBinario = arbolBinario;
    }

    public boolean isLeftTree(int num) {
        
        if (this.arbolBinario == null || this.arbolBinario.isEmpty()) return false;

        int cantHijosUnicosSubArbolIzquierdo = 0;
        int cantHijosUnicosSubArbolDerecho = 0;

        BinaryTree<Integer> nuevaRaiz = buscarNodo(num, this.arbolBinario);
        // Si no encontré num entonces nuevaRaiz es null
        if (nuevaRaiz == null) return false;

        // Si tiene un hijo contabilizo, sino le asigno -1
        cantHijosUnicosSubArbolIzquierdo = nuevaRaiz.hasLeftChild() ? contabilizarHijos(nuevaRaiz.getLeftChild()) : -1;
        cantHijosUnicosSubArbolDerecho = nuevaRaiz.hasRightChild() ? contabilizarHijos(nuevaRaiz.getRightChild()) : -1;
        return (cantHijosUnicosSubArbolIzquierdo > cantHijosUnicosSubArbolDerecho);
    }

    private BinaryTree<Integer> buscarNodo(int num, BinaryTree<Integer> nodo) {
        if (nodo.getData() != null && nodo.getData() == num)
            return nodo;
        BinaryTree<Integer> nuevaRaiz = null;
        if (nodo.hasLeftChild())
            nuevaRaiz = buscarNodo(num, nodo.getLeftChild());
        if (nuevaRaiz == null && nodo.hasRightChild())
            nuevaRaiz = buscarNodo(num, nodo.getRightChild());
        return nuevaRaiz;
    }

    private int contabilizarHijos(BinaryTree<Integer> nodo) {
        if (nodo.isLeaf())
            return 0;
        else if (nodo.hasLeftChild() && !nodo.hasRightChild())
            return 1 + contabilizarHijos(nodo.getLeftChild());
        else if (!nodo.hasLeftChild() && nodo.hasRightChild())
            return 1 + contabilizarHijos(nodo.getRightChild());
        // Por descarte, si no cumple ninguna de las otras condiciones, tiene ambos hijos
        else
            return 0 + contabilizarHijos(nodo.getLeftChild()) + contabilizarHijos(nodo.getRightChild());
    }
    
}
