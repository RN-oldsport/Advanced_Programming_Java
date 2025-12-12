package Queue;

public class Queue<Type> {

    private int size;
    private int capacity = 2;
    private Type[] array;

    public Queue() {
        this.size = 0;
        this.array = (Type[]) new Object[capacity];
    }

    public void enqueue(Type element) {
        checkCapacity();
        array[size++] = element;
    }

    public Type dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Type frontElement = array[0];

        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
        return frontElement;
    }

    public Type peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return array[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    private void checkCapacity() {
        if (size == capacity) {
            extendCapacity();
        }
    }

    private void extendCapacity() {
        int newCapacity = capacity * 2;
        Type[] newArray = (Type[]) new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
        capacity = newCapacity;
    }
}
