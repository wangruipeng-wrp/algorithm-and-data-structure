package Sort;

import Sort.util.ArrayGenerate;
import Sort.util.ISort;
import Sort.util.SortingHelper;

import java.util.Random;

/**
 * 双路快速排序
 */
public class QuickSortByTwoWays implements ISort {

    private final Random random = new Random();

    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 双路快速排序实现
     */
    private <T extends Comparable<T>> void sort(T[] arr, int l, int r) {
        if (l >= r) return;
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    /**
     * 标兵排序
     * 循环不变量：arr[l...i - 1] <= arr[l]; arr[j + 1...r] >= arr[j]
     *
     * @return 标兵排序后下标
     */
    private <T extends Comparable<T>> int partition(T[] arr, int l, int r) {

        // 随机标兵（针对完全有序数组所进行的优化）
        SortingHelper.swap(arr, l, l + random.nextInt(r - l + 1));

        int i = l + 1, j = r;
        while (true) {
            while (arr[i].compareTo(arr[l]) < 0) i++;
            while (arr[j].compareTo(arr[l]) > 0) j--;

            if (i >= j) break;

            SortingHelper.swap(arr, i++, j--);
        }

        SortingHelper.swap(arr, l, j);
        return j;
    }

    public static void main(String[] args) {
        int[] dataSize = {10_000, 100_000, 5_000_000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerate.generateRandomArray(n, Integer.MAX_VALUE);
            SortingHelper.sortTest(new QuickSortByOneWay(), arr);
        }
    }
}
