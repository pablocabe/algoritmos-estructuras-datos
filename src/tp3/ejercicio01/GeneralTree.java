package tp3.ejercicio01;

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
			int alturaMax = -1;
			List<GeneralTree<T>> children = this.getChildren();
			for (GeneralTree<T> child: children)
				alturaMax = Math.max(alturaMax, child.alturaHelper());
			return alturaMax+1;
		}
	}

	public int nivel(T dato){
		return 0;
	  }

	public int ancho(){
		return 0;
	}
}