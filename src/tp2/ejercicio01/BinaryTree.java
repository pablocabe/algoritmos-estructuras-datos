package tp2.ejercicio01;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());
	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}

	@Override
	public String toString() {
		return this.getData().toString();
	}

	// Un nodo es hoja cuando no tiene hijos = +1 cantHojas
	public int contarHojas() {
		if (this.isLeaf()) return 1;
		int cantHojas = 0;
		if (this.hasLeftChild())
			cantHojas += this.getLeftChild().contarHojas();
		if (this.hasRightChild())
			cantHojas += this.getRightChild().contarHojas();
		return cantHojas;
	}
    	 
	public BinaryTree<T> espejo() {
		if (this.isLeaf())
			return new BinaryTree<T>(this.getData());
		BinaryTree<T> nuevoNodo = new BinaryTree<T>(this.getData());
		if (this.hasRightChild())
			nuevoNodo.addLeftChild(this.getRightChild().espejo());
		if (this.hasLeftChild())
			nuevoNodo.addRightChild(this.getLeftChild().espejo());
 		return nuevoNodo;
    }

	// 0<=n<=m
    public void entreNiveles(int n, int m) {
        // Validación básica por si el árbol está vacío o los parámetros son ilógicos
        if (this.isEmpty() || n < 0 || n > m) {
            return;
        }

        Queue<BinaryTree<T>> cola = new LinkedList<>();
        cola.add(this); // Encolamos la raíz
        cola.add(null); // Encolamos nuestra marca de fin del nivel 0
        
        int nivelActual = 0;

        // Iteramos mientras haya elementos en la cola y no nos pasemos del nivel m
        while (!cola.isEmpty() && nivelActual <= m) {
            BinaryTree<T> nodoActual = cola.poll(); // Desencolamos

            if (nodoActual != null) {
                // Si el nodo no es la marca, verificamos si debemos imprimirlo
                if (nivelActual >= n && nivelActual <= m) {
                    System.out.print(nodoActual.getData() + " ");
                }

                // Encolamos a sus hijos para que se procesen en el siguiente nivel
                if (nodoActual.hasLeftChild()) {
                    cola.add(nodoActual.getLeftChild());
                }
                if (nodoActual.hasRightChild()) {
                    cola.add(nodoActual.getRightChild());
                }
            } else {
                // Si el nodoActual es null, significa que terminamos de procesar un nivel
                if (!cola.isEmpty()) {
                    System.out.println(); // Opcional: un salto de línea para separar visualmente los niveles
                    cola.add(null); // Ponemos la marca para el final del próximo nivel
                    nivelActual++;
                }
            }
        }
	}
		
}

