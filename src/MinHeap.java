public class MinHeap<E extends Comparable<E>> extends Heap<E> {

    public MinHeap() { super(); }

    public MinHeap(E val) { super(val); }

    public void bubbleUp(int idx) {
        int p_idx = parent(idx);

        while (p_idx >= 0 && arr.get(idx).compareTo(arr.get(p_idx)) < 0) {
            swap(idx, p_idx);
            idx = p_idx;
            p_idx = parent(idx);
        }
    }

    public void bubbleDown(int idx) {
        int l_idx = leftChild(idx);
        int r_idx = rightChild(idx);

        while (true) {
            int small_child;

            if (inBounds(l_idx) && inBounds(r_idx)) {
                small_child = arr.get(l_idx).compareTo(arr.get(r_idx)) < 0 ? l_idx : r_idx;
            } else if (inBounds(l_idx)) {
                small_child = l_idx;
            } else {
                break;
            }

            if (arr.get(idx).compareTo(arr.get(small_child)) > 0) {
                swap(idx, small_child);
                idx = small_child;
            } else {
                break;
            }

            l_idx = leftChild(idx);
            r_idx = rightChild(idx);
        }
    }
}
