package Sort.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 排序测试工具类
 */
public class SortingHelper {

    public static final int[] dataSize = {10_000, 100_000};
    public static final int recursionDataSize = 1000;

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
     * 测试排序性能方法
     */
    public static <T extends Comparable<T>> void sortTest(Class<?> cl, String methodName, T[] arr) {
        Method sortMethod;
        try {
            sortMethod = cl.getDeclaredMethod(methodName, Comparable[].class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException("create sort method failed");
        }

        long startTime = System.nanoTime();
        try {
            sortMethod.invoke(null, new Object [] {arr});
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("invoke sort method failed");
        }
        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1_000_000_000.0;

        if (!SortingHelper.isSorted(arr))
            throw new RuntimeException(cl.getName() + " failed");
        System.out.printf("%s.%s n = %d : time = %f s%n", cl.getName(), methodName, arr.length, time);
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
