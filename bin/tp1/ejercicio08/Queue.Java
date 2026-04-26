package tp1.ejercicio08;

import java.util.ArrayList;
import java.util.List;
import tp1.ejercicio08.Sequence;

public class Queue<T> extends Sequence {

    private List<T> data;

    public Queue() {
        data = new ArrayList<>();
    }

    public void enqueue(T dato) {
        data.add(dato);
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("La cola está vacía");
        return data.remove(0);
    }

    public T head() {
        if (isEmpty()) throw new RuntimeException("La cola está vacía");
        return data.get(0);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public String toString() {
        return data.toString();
    }

}