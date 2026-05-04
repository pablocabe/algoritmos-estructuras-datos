package tp3.ejercicio01;

import tp1.ejercicio08.Queue;
import java.util.LinkedList;
import java.util.List;


public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}

	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {
		if (!this.isEmpty())
			return this.alturaHelper();
		else
			return 0;
	}
	
	private int alturaHelper() {
		if (this.isLeaf())
			return 0;
		else {
			int alturaMax = -1; // Nunca va a quedar en -1 porque no es hoja = tiene hijos
			List<GeneralTree<T>> children = this.getChildren();
			for (GeneralTree<T> child: children)
				alturaMax = Math.max(alturaMax, child.alturaHelper());
			return alturaMax + 1;
		}
	}

	public int nivel(T dato){
		if (!this.isEmpty())
			return this.nivelHelper(dato);
		else
			return 0;
	}

	private int nivelHelper(T dato) {
		int cont = 0;
        int act;
        GeneralTree<T> aux;
        Queue<GeneralTree<T>> cola = new Queue<>();
        cola.enqueue(this);
        while(!cola.isEmpty()){
            act = cola.size();
            for(int i = 0; i < act; ++i){
                aux = cola.dequeue();
                if (aux.getData().equals(dato)){
                    return cont;
                }
                else {
                	for (GeneralTree<T> child : aux.getChildren())
                        cola.enqueue(child);
                }
            }
            cont++;
        }
        return -1;
	}

	public int ancho(){
		return 0;
	}

	// Devuelve true si el valor “a” es ancestro del valor “b”.
	public boolean esAncestro(T a, T b) {
		if (!this.isEmpty())
			return esAncestroAux(a, b);
		else
			return false;
	}

	private boolean esAncestroAux(T a, T b) {
		boolean esAncestro = false;
		boolean encontreA = false;
		boolean encontreB = false;
		return true;
	}

	// Método que retorna una lista con los elementos impares del árbol “a” 
    // que sean mayores al valor “n” pasados como parámetros, recorrido en preorden.
    public List<Integer> numerosImparesMayoresQuePreOrden (Integer n) {
        List<Integer> listaImparesMayores = new LinkedList<Integer>();
        if ((this != null) && (!this.isEmpty()))
            this.numerosImparesMayoresQuePreOrden(n, listaImparesMayores);
        return listaImparesMayores;
    }

    private void numerosImparesMayoresQuePreOrden(Integer n, List<Integer> listaImparesMayores) {
        int datoActual = (int) this.getData();
        if ((datoActual % 2 != 0) && (datoActual > n))
            listaImparesMayores.add(datoActual);
        List<GeneralTree<T>> children = this.getChildren();
        for (GeneralTree<T> child: children)
            child.numerosImparesMayoresQuePreOrden(n, listaImparesMayores);
    }

    // Método que retorna una lista con los elementos impares del árbol “a” 
    // que sean mayores al valor “n” pasados como parámetros, recorrido en inorden.
    public List<Integer> numerosImparesMayoresQueInOrden (Integer n) {
        List<Integer> listaImparesMayores = new LinkedList<Integer>();
        if ((this != null) && (!this.isEmpty()))
            this.numerosImparesMayoresQueInOrden(n, listaImparesMayores);
        return listaImparesMayores;
    }

    private void numerosImparesMayoresQueInOrden(Integer n, List<Integer> listaImparesMayores) {
        List<GeneralTree<T>> children = this.getChildren();
        if (this.hasChildren())
            children.get(0).numerosImparesMayoresQueInOrden(n, listaImparesMayores);
        int datoActual = (int) this.getData();
        if ((datoActual % 2 != 0) && (datoActual > n))
                listaImparesMayores.add(datoActual);
        for (int i = 1; i < children.size(); i++)
            children.get(i).numerosImparesMayoresQueInOrden(n, listaImparesMayores);
    }

    // Método que retorna una lista con los elementos impares del árbol “a” 
    // que sean mayores al valor “n” pasados como parámetros, recorrido en postorden.
    public List<Integer> numerosImparesMayoresQuePostOrden (Integer n) {
        List<Integer> listaImparesMayores = new LinkedList<Integer>();
        if ((this != null) && (!this.isEmpty()))
            this.numerosImparesMayoresQuePostOrden(n, listaImparesMayores);
        return listaImparesMayores;
    }

    private void numerosImparesMayoresQuePostOrden(Integer n, List<Integer> listaImparesMayores){
        List<GeneralTree<T>> children = this.getChildren();
        for (GeneralTree<T> child: children)
            child.numerosImparesMayoresQuePreOrden(n, listaImparesMayores);
        int datoActual = (int) this.getData();
        if ((datoActual % 2 != 0) && (datoActual > n))
                listaImparesMayores.add(datoActual);
    }

    // Método que retorna una lista con los elementos impares del árbol “a”
    // que sean mayores al valor “n” pasados como parámetros, recorrido por niveles.
    public List<Integer> numerosImparesMayoresQuePorNiveles(Integer n) {
        List<Integer> listaImparesMayores = new LinkedList<Integer>();
        if ((this != null) && (!this.isEmpty())) {
            int datoActual;
            GeneralTree<T> aux;
            Queue<GeneralTree<T>> queue = new Queue<>();
            queue.enqueue(this);
            while (!queue.isEmpty()) {
                aux = queue.dequeue();
                datoActual = (int) aux.getData();
                if ((datoActual % 2 != 0) && (datoActual > n))
                    listaImparesMayores.add(datoActual);
                for (GeneralTree<T> child: aux.getChildren())
                    queue.enqueue(child);
            }
        }
        return listaImparesMayores;
    }

}