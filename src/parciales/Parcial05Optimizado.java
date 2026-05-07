package parciales;

import tp2.ejercicio01.BinaryTree;

public class Parcial05Optimizado {

    public Resultado resolver (BinaryTree <Integer> arbol) {
        Resultado resultado = new Resultado();
        int nivelActual = 0;
        if ((arbol != null) && (!arbol.isEmpty()))
            recorrerArbol(arbol, resultado, nivelActual);
        System.out.println(resultado.getNumeroPar());
        System.out.println(resultado.getNivelActual());
        return resultado;
    }

    private boolean recorrerArbol (BinaryTree<Integer> nodo, Resultado resultado, int nivelActual) {
        boolean encontrePar = false;
        if ((!encontrePar) && (nodo.hasLeftChild()))
            encontrePar = recorrerArbol(nodo.getLeftChild(), resultado, nivelActual + 1);
        if ((!encontrePar) && (nodo.hasRightChild()))
            encontrePar = recorrerArbol(nodo.getRightChild(), resultado, nivelActual + 1);
        if ((!encontrePar) && (nodo.getData() % 2 == 0)) {
            encontrePar = true;
            resultado.setNumeroPar(nodo.getData());
            resultado.setNivelActual(nivelActual);
        }
        return encontrePar;
    }

}
