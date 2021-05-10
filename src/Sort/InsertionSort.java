package Sort;

import Sort.util.ArrayGenerate;
import Sort.util.SortingHelper;

/**
 * 插入排序
 */
public class InsertionSort {
    private InsertionSort() {
    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T temp = arr[i];
            int j = i;
            while (j > 0) {
                if (temp.compareTo(arr[j - 1]) < 0) {
                    arr[j] = arr[j - 1];
                    j--;
                } else break;
            }
            arr[j] = temp;
        }
    }

    public static <T extends Comparable<T>> void sortByRecursion(T[] arr) {
        sortByRecursion(arr, 1);
    }

    private static <T extends Comparable<T>> void sortByRecursion(T[] arr, int n) {
        if (n == arr.length) return;

        T temp = arr[n];
        for (int i = n - 1; i > 0; i--) {
            if (temp.compareTo(arr[i]) < 0)
                arr[i + 1] = arr[i];
            else break;
        }
        sortByRecursion(arr, ++n);
    }

    public static void main(String[] args) {
        for (int n : SortingHelper.dataSize) {
            Integer[] arr = ArrayGenerate.generateRandomArray(n, Integer.MAX_VALUE);
            SortingHelper.sortTest(InsertionSort.class, "sort", arr);
        }

        System.out.println();
        Integer[] arr = ArrayGenerate.generateRandomArray(SortingHelper.recursionDataSize, Integer.MAX_VALUE);
        SortingHelper.sortTest(InsertionSort.class, "sortByRecursion", arr);
    }
}
