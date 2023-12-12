package live.cloverescape.sort;

/**
 * @author weibb
 * @date 2023-12-12
 */
public class Merge {
    private static int[] aux;

    public static void sort(int[] a) {
        aux = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }

    public static void merge(int[] a, int lo, int mid, int hi) { // 将 a[lo...mid] 和 a[mid+1...hi]归并
        int i = lo, j = mid + 1;
        for (int k = 0; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public static void exch(int[] a, int i, int min) {
        int aux = a[i];
        a[i] = a[min];
        a[min] = aux;
    }

    public static boolean less(int a, int b) {
        return a < b;
    }
}
