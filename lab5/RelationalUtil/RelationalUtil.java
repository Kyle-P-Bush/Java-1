//Problem 4 RelationalUtil
//Submitted by Kyle Bush

public class RelationalUtil {

    public static boolean isIncreasing(int x, int y, int z) {
        return x < y && y < z;
    }

    public static boolean isDecreasing(int x, int y, int z) {
        return x > y && y > z;
    }

    public static boolean isBetween(int x, int y, int z) {
        return isIncreasing(x, y, z) || isDecreasing(x, y, z);
    }

    public static boolean isPositive(int x) {
        return x > 0;
    }

    public static boolean isNegative(int x) {
        return x < 0;
    }

    public static boolean overlaps(int min1, int max1, int min2, int max2) {
        return isBetween(min1, min2, max1) || isBetween(min1, max2, max1) ||
                isBetween(min2, min1, max2) || isBetween(min2, max1, max2);
    }
}