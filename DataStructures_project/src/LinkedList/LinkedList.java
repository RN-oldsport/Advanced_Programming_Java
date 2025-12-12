package LinkedList;

class Node<Type> {
    Type data;
    Node<Type> next;

    public Node(Type data) {
        this.data = data;
        this.next = null;
    }
}


public class LinkedList<Type> {

    private Node<Type> head;

    public LinkedList() {
        this.head = null;
    }

    public void insert(Type value) {
        Node<Type> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node<Type> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void insertAt(Type value, int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }

        Node<Type> newNode = new Node<>(value);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node<Type> current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    public void printList() {
        Node<Type> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int sizeOfList() {
        int count = 0;
        Node<Type> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void deleteByKey(Type value) {
        if (head == null) return;

        if (head.data.equals(value)) {
            head = head.next;
            return;
        }

        Node<Type> current = head;
        while (current.next != null && !current.next.data.equals(value)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void deleteByIndex(int index) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            head = head.next;
            return;
        }

        Node<Type> current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current.next == null) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }
}
