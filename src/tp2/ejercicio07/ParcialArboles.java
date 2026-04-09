package tp2.ejercicio07;

import tp2.ejercicio01.BinaryTree;

public class ParcialArboles {

    private BinaryTree<Integer> arbolBinario;

    public ParcialArboles(BinaryTree<Integer> arbolBinario) {
        this.arbolBinario = arbolBinario;
    }

    public boolean isLeftTree(int num) {
        int cantHijosUnicosSubArbolIzquierdo = 0;
        int cantHijosUnicosSubArbolDerecho = 0;
        
        if (this.arbolBinario != null && !this.arbolBinario.isEmpty()){
            BinaryTree<Integer> nuevaRaiz = buscarNodo(num, this.arbolBinario);
            // Si no encontré num entonces nuevaRaiz es null
            if (nuevaRaiz != null) {
                // Si tiene un hijo contabilizo, sino le asigno -1
                if (nuevaRaiz.hasLeftChild()) {
                    cantHijosUnicosSubArbolIzquierdo = contabilizarHijos(nuevaRaiz.getLeftChild());
                }
                else {
                    cantHijosUnicosSubArbolIzquierdo = -1;
                }
                if (nuevaRaiz.hasRightChild()) {
                    cantHijosUnicosSubArbolDerecho = contabilizarHijos(nuevaRaiz.getRightChild());
                }
                else {
                    cantHijosUnicosSubArbolDerecho = -1;
                }
            }
        }
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
