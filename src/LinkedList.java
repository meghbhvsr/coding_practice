
public class LinkedList<E> {

    private ListNode<E> head;
    private ListNode<E> tail;
    private int size;

    public LinkedList() {}

    public LinkedList(E val) {
        this.head = new ListNode<>(val);
        this.tail = this.head;
        this.size++;
    }

    public void print() {
        ListNode<E> pointer = this.head;
        while(pointer != null) {
            System.out.print(pointer + ",");
            pointer = pointer.next;
        }
        System.out.println();
    }

    public void printRec() {
        printRec(head);
    }

    public void printRec(ListNode<E> node) {
        if (node != null) {
            System.out.print(node + ",");
            printRec(node.next);
        } else {
            System.out.println();
        }
    }

    public void add(E val) {
        if (tail == null) {
            tail = new ListNode<>(val);
            head = tail;
        } else {
            tail.next = new ListNode<>(val);
            tail = tail.next;
        }
        this.size++;
    }

    public boolean contains(E val) {
        ListNode<E> pointer = this.head;
        while(pointer != null) {
            if (pointer.val.equals(val)) {
                return true;
            }
            pointer = pointer.next;
        }
        return false;
    }

    public void remove(E val) {
         if (!contains(val)) {
             return;
         } else {
             this.size--;
         }

         if (head.val.equals(val)) {
             head = head.next;

             if (head == null) { tail = null; }
             return;
         }

         ListNode<E> node = this.head;
         while (!node.next.val.equals(val)) {
             node = node.next;
         }

         node.next = node.next.next;

         if (node.next == null) { tail = node; }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }
}
