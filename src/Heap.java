import java.util.ArrayList;

public abstract class Heap<E extends Comparable<E>> {

    ArrayList<E> arr = new ArrayList<>();
    int last;

    protected Heap() {
        last = -1;
    }

    protected Heap(E val) {
        arr.add(val);
        last = 0;
    }

    public void add(E val) {
        this.last++;
        arr.add(this.last, val);

        if (this.last > 0) {
            bubbleUp(this.last);
        }
    }

    protected abstract void bubbleUp(int idx);

    public void remove() {
        swap(0, this.last);
        arr.remove(this.last);
        this.last--;

        if (this.last > 0) {
            bubbleDown(0);
        }
    }

    protected abstract void bubbleDown(int idx);

    public E peek() {
        return last == -1 ? null : arr.get(0);
    }

    public int size() {
        return this.last + 1;
    }

    public boolean isEmpty() {
        return this.last == -1;
    }

    protected int parent(int idx) {
        if (idx % 2 == 0) {
            return (idx - 2) / 2;
        } else {
            return (idx - 1) / 2;
        }
    }

    protected int leftChild(int idx) {
        return 2 * idx + 1;
    }

    protected int rightChild(int idx) {
        return 2 * idx + 2;
    }

    protected boolean inBounds(int idx) {
        return idx >= 0 && idx <= this.last;
    }

    protected void swap(int idx1, int idx2) {
        E temp = arr.get(idx1);
        arr.set(idx1, arr.get(idx2));
        arr.set(idx2, temp);
    }
}
