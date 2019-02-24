public class Queue<E> {
    private ListNode<E> head;
    private ListNode<E> tail;
    private int size;

    public Queue() {}

    public Queue(E val) {
        this.head = new ListNode<>(val);
        this.size++;
    }

    public void print() {
        ListNode<E> pointer = this.head;
        System.out.print("top: ");
        while (pointer != null) {
            System.out.print(pointer + ",");
            pointer = pointer.next;
        }
        System.out.println();
    }

    public void enqueue(E val) {
        ListNode<E> node = new ListNode<>(val);
        if (this.head == null) {
            this.head = node;
            this.tail = this.head;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    public void dequeue() {
        if (this.head != null) {
            this.head = this.head.next;
            this.size--;
        }
    }

    public ListNode<E> peek() {
        return this.head;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() { return head == null; }

    public boolean contains(E val) {
        ListNode<E> pointer = this.head;
        while (pointer != null) {
            if (pointer.val.equals(val)) {
                return true;
            }
            pointer = pointer.next;
        }
        return false;
    }
}
