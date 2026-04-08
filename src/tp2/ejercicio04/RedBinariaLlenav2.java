package tp2.ejercicio04;
import tp2.ejercicio01.BinaryTree;

// Si el enunnciado especifica que está lleno
// No es necesario preguntar con los ifs: por eso la v2

public class RedBinariaLlenav2 {

    private BinaryTree<Integer> arbol;

    public RedBinariaLlenav2(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public int retardoReenvio() {
        // Si el árbol existe y tiene al menos un nodo, se recorre 
        if (this.arbol != null && !this.arbol.isEmpty())
            return calcularRetardoMaximo(this.arbol);
        return 0;
    }

    public int calcularRetardoMaximo(BinaryTree<Integer> nodo) {

        if (nodo.isLeaf())
            return nodo.getData();
        return  (Math.max
                (calcularRetardoMaximo(nodo.getLeftChild()), // valor 1
                calcularRetardoMaximo(nodo.getRightChild()))) // valor 2
                + nodo.getData(); // por fuera del paréntesis sumo mi valor actual
    }
    
}
