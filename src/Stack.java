public class Stack<E> {

    private ListNode<E> head;
    private int size;

    public Stack() {}

    public Stack(E val) {
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

    public void push(E val) {
        ListNode<E> node = new ListNode<>(val);
        if (this.head == null) {
            this.head = node;
        } else {
        node.next = this.head;
        this.head = node;
    }
        this.size++;
    }

    public void pop() {
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
