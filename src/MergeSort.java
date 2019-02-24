import java.util.ArrayList;

public class MergeSort {
    public static  <T extends Comparable<T>> void sort(ArrayList<T> arr) {
        sort(arr, 0, arr.size());
    }

    private static <T extends Comparable<T>> void sort(ArrayList<T> arr, int s, int e) {
        if (e - s == 1) { return; }

        int m = (s + e) / 2;

        sort(arr, s, m);
        sort(arr, m, e);

        ArrayList<T> arr_copy = new ArrayList<>(e - s);

        int p1 = s;
        int p2 = m;
        int p3 = s;
        int p4 = 0;

        while (p1 < m && p2 < e) {
            if (arr.get(p1).compareTo(arr.get(p2)) < 0) {
                arr_copy.add(arr.get(p1++));
            } else {
                arr_copy.add(arr.get(p2++));
            }
        }

        while (p1 < m) {
            arr_copy.add(arr.get(p1++));
        }

        while (p2 < e) {
            arr_copy.add(arr.get(p2++));
        }

        while (p3 < e) {
            arr.set(p3++, arr_copy.get(p4++));
        }
    }
}
