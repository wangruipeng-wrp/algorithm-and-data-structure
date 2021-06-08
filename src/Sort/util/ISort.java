package Sort.util;

/**
 * 排序接口
 */
public interface ISort {

    /**
     * 排序
     *
     * @param arr 待排序数组
     * @param <T> 可比较泛型类
     */
    <T extends Comparable<T>> void sort(T[] arr);
}
