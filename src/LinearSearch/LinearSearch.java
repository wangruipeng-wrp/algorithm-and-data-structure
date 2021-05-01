package LinearSearch;

public class LinearSearch {

    public static <T> int search(T[] data, T target) {
        for (int i = 0; i < data.length; i++)
            if (data[i].equals(target))
                return i;

        return -1;
    }

    public static <T> int searchByRecursion(T[] data, T target) {
        return searchByRecursion(data, target, 0);
    }

    private static <T> int searchByRecursion(T[] data, T target, int i) {
        if (i == data.length - 1) return -1;

        if (data[i].equals(target)) return i;

        return searchByRecursion(data, target, ++i);
    }
}
