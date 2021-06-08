package Sort;

import Sort.util.ArrayGenerate;
import Sort.util.ISort;
import Sort.util.SortingHelper;

/**
 * 归并排序
 */
public class MergeSort implements ISort {

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Comparable<T>> void sort(T[] arr) {
        T[] temp = (T[]) new Comparable[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    /**
     * 归并排序的实现
     */
    private <T extends Comparable<T>> void sort(T[] arr, int l, int r, T[] temp) {
        if (l >= r) return;

        int mid = l + (r - l) / 2;
        sort(arr, l, mid, temp);
        sort(arr, mid + 1, r, temp);

        // 针对本身有序的数组所作出的优化
        if (arr[mid].compareTo(arr[mid + 1]) > 0)
            mergeArr(arr, l, mid, r, temp);
    }

    /**
     * 合并两个有序的区间 arr[l,mid] 和 arr[mid + 1, r]
     */
    private <T extends Comparable<T>> void mergeArr(T[] arr, int l, int mid, int r, T[] temp) {

        // 此处由于每次排序操作都有可能改变arr数组，所以将arr数组暂存于temp数组中
        System.arraycopy(arr, l, temp, l, r - l + 1);

        int lIndex = l, rIndex = mid + 1;
        for (int i = l; i <= r; i++) {
            if (lIndex == mid + 1) {
                for (int j = i; j <= r; j++)
                    arr[j] = temp[rIndex++];
                break;
            }

            if (rIndex == r + 1) {
                for (int j = i; j <= r; j++)
                    arr[j] = temp[lIndex++];
                break;
            }

            arr[i] = temp[lIndex].compareTo(temp[rIndex]) <= 0 ? temp[lIndex++] : temp[rIndex++];
        }
    }

    public static void main(String[] args) {
        // 测试归并排序
        int[] dataSize = {10_000, 100_000, 5_000_000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerate.generateRandomArray(n, Integer.MAX_VALUE);
            SortingHelper.sortTest(new MergeSort(), arr);
        }
    }
}
