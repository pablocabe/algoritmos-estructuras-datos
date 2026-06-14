package parcialesarboles.parcial03;

import java.util.List;
import java.util.ArrayList;
import tp2.ejercicio01.BinaryTree;

public class Parcial03 {

    public List<Integer> resolver (BinaryTree<Integer> arbol, Integer inf, Integer sup) {
        List<Integer> listaResultado = new ArrayList<>();
        if ((arbol != null) && (!arbol.isEmpty()))
            recorrerArbol(arbol, inf, sup, listaResultado);
        return listaResultado;
    }

    private void recorrerArbol (BinaryTree<Integer> nodo, Integer inf, Integer sup, List<Integer> listaResultado) {
        if (nodo.hasLeftChild())
            recorrerArbol(nodo.getLeftChild(), inf, sup, listaResultado);
        if (nodo.hasRightChild())
            recorrerArbol(nodo.getRightChild(), inf, sup, listaResultado);
        if (nodo.isLeaf() && nodo.getData() > inf && nodo.getData() < sup)
            listaResultado.add(nodo.getData());
    }
    
}
