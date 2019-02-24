public class MaxHeap<E extends Comparable<E>> extends Heap<E> {

    public MaxHeap() { super(); }

    public MaxHeap(E val) { super(val); }

    public void bubbleUp(int idx) {
        int p_idx = parent(idx);

        while (p_idx >= 0 && arr.get(idx).compareTo(arr.get(p_idx)) > 0) {
            swap(idx, p_idx);
            idx = p_idx;
            p_idx = parent(idx);
        }
    }

    public void bubbleDown(int idx) {
        int l_idx = leftChild(idx);
        int r_idx = rightChild(idx);

        while (true) {
            int large_child;

            if (inBounds(l_idx) && inBounds(r_idx)) {
                large_child = arr.get(l_idx).compareTo(arr.get(r_idx)) > 0 ? l_idx : r_idx;
            } else if (inBounds(l_idx)) {
                large_child = l_idx;
            } else {
                break;
            }

            if (arr.get(idx).compareTo(arr.get(large_child)) < 0) {
                swap(idx, large_child);
                idx = large_child;
            } else {
                break;
            }

            l_idx = leftChild(idx);
            r_idx = rightChild(idx);
        }
    }
}
