package parciales;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import tp3.ejercicio01.GeneralTree;

public class Parcial09 {

    private GeneralTree<Integer> arbol;

    public List<Integer> camino (int num) {
        List<Integer> listaResultado = new ArrayList<Integer>();
        if ((this.arbol != null) && (!this.arbol.isEmpty()))
            recorrerArbolRecursivo(this.arbol, listaResultado, num);
        return listaResultado;

    }

    private boolean recorrerArbolRecursivo (GeneralTree<Integer> nodoActual, List<Integer> listaResultado, int num) {
        listaResultado.add(nodoActual.getData());
        boolean ok = false;
        if (nodoActual.isLeaf())
            ok = true;
        else if (nodoActual.getChildren().size() >= num) {
            Iterator<GeneralTree<Integer>> iterator = nodoActual.getChildren().iterator();
            while ((!ok) && (iterator.hasNext())) {
                GeneralTree<Integer> child = iterator.next();
                ok = recorrerArbolRecursivo(child, listaResultado, num);
            }
        }
        if (!ok)
            listaResultado.remove(listaResultado.size() - 1); 
        return ok;
    }
    
}
