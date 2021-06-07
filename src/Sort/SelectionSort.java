package Sort;

import Sort.util.ArrayGenerate;
import Sort.util.ISort;
import Sort.util.SortingHelper;

/**
 * 选择排序
 */
public class SelectionSort implements ISort {

    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex].compareTo(arr[j]) > 0)
                    minIndex = j;
            }

            SortingHelper.swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        // 测试选择排序
        int[] dataSize = {10_000, 100_000, 1_000_000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerate.generateRandomArray(n, Integer.MAX_VALUE);
            SortingHelper.sortTest(new SelectionSort(), arr);
        }
    }
}
