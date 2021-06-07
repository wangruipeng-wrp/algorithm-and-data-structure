package Sort;

import Sort.util.ArrayGenerate;
import Sort.util.ISort;
import Sort.util.SortingHelper;

/**
 * 插入排序
 */
public class InsertionSort implements ISort {

    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
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

    public static void main(String[] args) {
        // 测试插入排序
        int[] dataSize = {10_000, 100_000, 1_000_000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerate.generateRandomArray(n, Integer.MAX_VALUE);
            SortingHelper.sortTest(new InsertionSort(), arr);
        }
    }
}
