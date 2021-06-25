package Sort;

import Sort.util.ArrayGenerate;
import Sort.util.ISort;
import Sort.util.SortingHelper;

import java.util.Random;

/**
 * 三路快速排序
 */
public class QuickSortByThreeWays implements ISort {

    private final Random random = new Random();

    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 三路快速排序实现
     */
    private <T extends Comparable<T>> void sort(T[] arr, int l, int r) {
        if (l >= r) return;

        // 随机标兵（针对完全有序数组所进行的优化）
        SortingHelper.swap(arr, l, l + random.nextInt(r - l + 1));

        int lt = l, i = l + 1, gt = r + 1;
        while (i < gt) {

            if (arr[i].compareTo(arr[l]) < 0) {
                SortingHelper.swap(arr, ++lt, i++);
                continue;
            }
            if (arr[i].compareTo(arr[l]) > 0) {
                SortingHelper.swap(arr, i, --gt);
                continue;
            }

            i++;
        }
        SortingHelper.swap(arr, l, lt);

        sort(arr, l, lt - 1);
        sort(arr, gt, r);
    }

    public static void main(String[] args) {
        int[] dataSize = {10_000, 100_000, 5_000_000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerate.generateOrderedArray(n);
            SortingHelper.sortTest(new QuickSortByThreeWays(), arr);
        }
    }
}
