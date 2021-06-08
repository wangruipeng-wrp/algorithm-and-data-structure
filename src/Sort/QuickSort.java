package Sort;

import Sort.util.ArrayGenerate;
import Sort.util.ISort;
import Sort.util.SortingHelper;

/**
 * 快速排序
 */
public class QuickSort implements ISort {

    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序实现
     */
    private <T extends Comparable<T>> void sort(T[] arr, int l, int r) {
        if (l >= r) return;
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    /**
     * 将arr[l]放到arr[j]的位置
     * 使得：arr[l...j-1] < arr[j]，arr[j+1...r] >= arr[j]
     */
    private <T extends Comparable<T>> int partition(T[] arr, int l, int r) {

        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0)
                SortingHelper.swap(arr, i, ++j);
        }
        SortingHelper.swap(arr, l, j);

        return j;
    }

    public static void main(String[] args) {
        // 测试快速排序
        int[] dataSize = {10_000, 100_000, 5_000_000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerate.generateRandomArray(n, Integer.MAX_VALUE);
            SortingHelper.sortTest(new QuickSort(), arr);
        }
    }
}
