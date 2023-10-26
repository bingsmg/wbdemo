package live.cloverescape.lc.realq;

import java.util.Scanner;

/**
 * 攀比，顺丰真题 贪心算法
 * 第一行 2 个整数 n 和 k，表示木棍数量和小明能最多进行的移动操作次数
 * 第二行 n 个整数 a1, a2, ..., an，表示初始时木棍上的算珠数量。
 * 求输出一行 n 个整数表示移动最多 k 次后最小字典序数组。
 * @author weibb
 * @date 2023-10-26
 */
public class Real01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        // 贪心算法：直接把 k 次都加到最后一个元素即可，将前面的元素尽可能地减直到 k 次用完。
        // 1,2,2,4 [n:4, k:2]-> 0 1 2 6
        // 循环中会处理将 k 的值从左往右减直到 k 为 0 退出循环，最后把所有的 k 全部追加到末尾。
        int tk = k;
        for (int i = 1; i <= n; i++) {
            if (arr[i] <= k) {
                k -= arr[i];
                arr[i] = 0;
            } else {
                arr[i] -= k;
                break;
            }
        }
        arr[n] += tk;

        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
