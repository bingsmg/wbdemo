package live.cloverescape.sort;

/**
 * @author weibb
 * @date 2023-12-12
 */
public class Select {

    public static void sort(int[] a) { // 将a[]按升序排列
        int N = a.length; // 数组长度
        for (int i = 0; i < N; i++) { // 将a[i]和a[i+1..N]中最小的元素交换
            int min = i; // 最小元素的索引
            for (int j = i + 1; j < N; j++)
                if (less(a[j], a[min])) min = j;
            exch(a, i, min);
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
