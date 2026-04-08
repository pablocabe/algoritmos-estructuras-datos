package tp2.ejercicio04;
import tp2.ejercicio01.BinaryTree;


public class RedBinariaLlenav1 {

    private BinaryTree<Integer> arbol;

    public RedBinariaLlenav1(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public int retardoReenvio() {
        // Si el árbol existe y tiene al menos un nodo, se recorre 
        if (this.arbol != null && !this.arbol.isEmpty())
            return calcularRetardoMaximo(this.arbol);
        return 0;
    }

    // Pero si está lleno, es necesario preguntar con los ifs? Para eso es la v2
    public int calcularRetardoMaximo(BinaryTree<Integer> nodo) {

        int retardoIzquierdo = 0;
        int retardoDerecho = 0;

        if (nodo.hasLeftChild())
            retardoIzquierdo = calcularRetardoMaximo(nodo.getLeftChild());

        if (nodo.hasRightChild())
            retardoDerecho = calcularRetardoMaximo(nodo.getRightChild());

        return (Math.max(retardoIzquierdo, retardoDerecho) + nodo.getData());
    }
    
}
