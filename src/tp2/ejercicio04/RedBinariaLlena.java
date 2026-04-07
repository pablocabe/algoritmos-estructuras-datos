package tp2.ejercicio04;
import tp2.ejercicio01.BinaryTree;


public class RedBinariaLlena {

    private BinaryTree<Integer> arbol;

    public RedBinariaLlena(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public int retardoReenvio() {
        // Si el árbol existe y tiene al menos un nodo, se recorre 
        if (this.arbol != null && !this.arbol.isEmpty())
            return calcularRetardoMaximo(this.arbol);
        return 0;
    }

    // Pero si está lleno, es necesario preguntar con los ifs?
    public int calcularRetardoMaximo(BinaryTree<Integer> nodo) {

        int retardoIzquierdo = 0;
        int retardoDerecho = 0;

        if (nodo.hasLeftChild())
            retardoIzquierdo = calcularRetardoMaximo(nodo.getLeftChild());

        if (nodo.hasRightChild())
            retardoDerecho = calcularRetardoMaximo(nodo.getRightChild());

        return (Math.max(retardoIzquierdo, retardoDerecho) + nodo.getData());
    }

    // Segunda opción
    public int calcularRetardoMaximo(BinaryTree<Integer> nodo) {

        int retardoIzquierdo = 0;
        int retardoDerecho = 0;

        if (nodo.isLeaf()) {
            return nodo.getData();
        }
        return (Math.max(calcularRetardoMaximo(nodo.getLeftChild()), calcularRetardoMaximo(nodo.getRightChild()) + nodo.getData()));
    }
    
}
