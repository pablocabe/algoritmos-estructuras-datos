package tp1.ejercicio08;

import java.util.ArrayList;
import java.util.List;

public class DoubleEndedQueue<T> extends Queue<T> {

    public void enqueueFirst(T dato) {
        // No se puede usar data directamente porque es privado en Queue
        // Solución: desencolamos todo, agregamos el nuevo al frente, y re-encolamos
        List<T> temp = new ArrayList<>();

        while (!isEmpty()) {
            temp.add(dequeue());
        }

        enqueue(dato);          // primero el nuevo elemento

        for (T elemento : temp) {
            enqueue(elemento);  // después el resto
        }

    }

}