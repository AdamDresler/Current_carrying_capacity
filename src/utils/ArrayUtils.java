package utils;

public class ArrayUtils {

    public static int findElementIndex(Double array[], double t)        {
        // if array is Null
        if (array == null) {
            return -1;
        }
        // find length of array
        int len = array.length;
        int i = 0;

        // traverse in the array
        while (i < len) {

            // if the i-th element is t
            // then return the index
            if (array[i] == t) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }
}
