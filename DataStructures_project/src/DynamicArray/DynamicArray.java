package DynamicArray;

public class DynamicArray<Type> {

    private int size;
    private int capacity = 2;
    private Type[] array;

    public DynamicArray() {
        this.size = 0;
        this.array = (Type[]) new Object[capacity];
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Type get(int index) {
        return this.array[index];
    }

    public void add(Type element) {
        checkCapacity();
        array[size++] = element;
        }

    public void insert(int index, Type element) {
        checkCapacity();
        shiftRightFrom(index);
        array[index] = element;
    }

    private void shiftRightFrom(int index) {
        for (int i = size; i >= index; i--) {
            this.array[i] = this.array[i-1];
        }
    }

    private void shiftLeftFrom(int index) {
        for (int i = index; i < size-1; i++) {
           this.array[i] = this.array[i+1];
        }
    }

    public void remove(int index) throws IllegalAccessException {
        if (isEmpty()) {
            throw new IllegalAccessException("Array is empty");
        }
        shiftLeftFrom(index);
        this.array[size - 1] = null;
        size--;
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

        this.capacity = newCapacity;
        this.array = newArray;
    }
}


