package live.cloverescape.sort;

/**
 * @author weibb
 * @date 2023-12-12
 */
public class Quick {

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    public static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1; // 左右扫描指针
        int v = a[lo];
        while (true) {
            while (less(a[++i], v)) if(i == hi) break;
            while (less(v, a[--j])) if(j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
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
