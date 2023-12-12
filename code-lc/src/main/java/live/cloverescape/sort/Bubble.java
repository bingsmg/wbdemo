package live.cloverescape.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author weibb
 * @date 2023-12-12
 */
public class Bubble {
    public static void main(String[] args) {
        int[] nums = new int[10];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(50);
        }
        System.out.println(Arrays.toString(nums));
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 1; j < a.length - i; j++)
                if (less(a[j], a[j-1])) exch(a, j, j-1);
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
