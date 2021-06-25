package Sort.util;

import java.util.Arrays;
import java.util.Random;

public class ArrayGenerate {

    /**
     * 生成顺序数组
     */
    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = i;

        return arr;
    }

    /**
     * 生成倒序数组
     */
    public static Integer[] generateReverseOrderArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = n - i;

        return arr;
    }

    /**
     * 生成随机数组
     */
    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++)
            arr[i] = random.nextInt(bound);

        return arr;
    }

    /**
     * 生成相同数组
     */
    public static Integer[] generateIdenticalArray(int n, int numbers) {
        Integer[] arr = new Integer[n];
        Arrays.fill(arr, numbers);
        return arr;
    }
}
