package tp2.ejercicio09;

import tp2.ejercicio01.BinaryTree;

public class ParcialArboles {
    
    public ParcialArboles() {}
    
    public BinaryTree<ObjSumDif> sumAndDif(BinaryTree<Integer> arbol) {
        // Instancio el árbol porque si o si tiene que retornarse aunque en el primer paso esté vacío
        BinaryTree<ObjSumDif> arbolSumDif = new BinaryTree<ObjSumDif>();
        // Si es null o está vacío no se recorre
        if (arbol != null && !arbol.isEmpty()) {
            // Está bien que instancie acá ya el primer nodo? Porque en realidad no se
            arbolSumDif.setData(new ObjSumDif(arbol.getData(), arbol.getData()));

        }

        return arbolSumDif;
    }

}
