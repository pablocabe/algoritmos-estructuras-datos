package tp1.ejercicio08;

public class CircularQueue<T> extends Queue<T> {

    public T shift() {
        T elemento = dequeue();  // saca del frente
        enqueue(elemento);       // lo manda al final
        return elemento;
    }
    
}