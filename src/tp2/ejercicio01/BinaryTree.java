package tp2.ejercicio01;

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
			nuevoNodo.addLeftChild(this.getRightChild());
		if (this.hasLeftChild())
			nuevoNodo.addRightChild(this.getLeftChild());
 		return nuevoNodo;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m) {
		
	}
		
}

