package Sort;

import Sort.util.ArrayGenerate;
import Sort.util.SortingHelper;

/**
 * 选择排序法
 */
public class SelectionSort {

    private SelectionSort() {
    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex].compareTo(arr[j]) > 0)
                    minIndex = j;
            }

            SortingHelper.swap(arr, i, minIndex);
        }
    }

    public static <T extends Comparable<T>> void sortByRecursion(T[] arr) {
        sortByRecursion(arr, 0);
    }

    private static <T extends Comparable<T>> void sortByRecursion(T[] arr, int n) {
        if (n == arr.length - 1) return;

        int minIndex = n;
        for (int i = n; i < arr.length; i++) {
            if (arr[minIndex].compareTo(arr[i]) > 0)
                minIndex = i;
        }

        SortingHelper.swap(arr, n, minIndex);
        sortByRecursion(arr, ++n);
    }

    public static void main(String[] args) {
        for (int n : SortingHelper.dataSize) {
            Integer[] arr = ArrayGenerate.generateRandomArray(n, Integer.MAX_VALUE);
            SortingHelper.sortTest(SelectionSort.class, "sort", arr);
        }
        System.out.println();
        for (int n : SortingHelper.dataSize) {
            Integer[] arr = ArrayGenerate.generateRandomArray(n, Integer.MAX_VALUE);
            SortingHelper.sortTest(SelectionSort.class, "sortByRecursion", arr);
        }
    }
}
