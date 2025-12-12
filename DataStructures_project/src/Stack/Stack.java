package Stack;

public class Stack<Type> {

    private int size;
    private int capacity = 2;
    private Type[] array;

    public Stack() {
        this.size = 0;
        this.array = (Type[]) new Object[capacity];
    }

    public void push(Type element) {
        checkCapacity();
        array[size++] = element;
    }

    public Type pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        Type topElement = array[size - 1];
        array[size - 1] = null;
        size--;
        return topElement;
    }

    public Type peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return array[size - 1];
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
        if (size+1 == capacity) {
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

