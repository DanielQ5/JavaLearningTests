package PruebasBasicas;

public class LinkedListNode {

    private Node head;
    private Node tail;

    private int size;

    public LinkedListNode() {
        this.size = 0;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertSpecificPosition(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }

        if (index < 0 || index > size) {
            System.out.println("Error: Invalid index.");
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;

        size++;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteLastPosition() {
        if (size <= 1) {
            return deleteFirstPosition();
        }
        if (size == 1) {
            int val = head.value;
            head = tail = null;
            size = 0;
            return val;
        }

        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;

        return val;
    }

    public int deleteFirstPosition() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }


    public int deleteSpecificPosition(int index) {
        if (index == 0) {
            return deleteFirstPosition();
        }
        if (index == size - 1) {
            return deleteLastPosition();
        }

        Node previous = get(index - 1);
        int val = previous.next.value;

        previous.next = previous.next.next;

        return val;
    }

    public void display() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
