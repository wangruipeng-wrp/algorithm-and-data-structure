package Sort.util;

/**
 * 排序测试工具类
 */
public class SortingHelper {

    /**
     * 测试排序性能方法
     */
    public static <T extends Comparable<T>> void sortTest(ISort sort, T[] arr) {

        long startTime = System.nanoTime();
        sort.sort(arr);
        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1_000_000_000.0;

        if (!SortingHelper.isSorted(arr))
            throw new RuntimeException("sort failed!");

        Class<? extends ISort> cl = sort.getClass();
        System.out.printf("%s n = %d \t: time = %f s%n", cl.getName(), arr.length, time);
    }

    /**
     * 检查排序是否正确
     * 注：默认数组按照从小到大排序
     */
    public static <T extends Comparable<T>> boolean isSorted(T[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i - 1].compareTo(arr[i]) > 0)
                return false;

        return true;
    }

    /**
     * 交换arr中i和j的位置
     */
    public static <T> void swap(T[] arr, int i, int j) {
        if (i == j) return;

        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
