package xyz.r0r5chach.cpsAssist;

public class ArrayTools {
    /**
     * This method checks if any of the Strings stored in an array are empty
     * @param details The array to be checker
     * @return true if containing an empty String; false otherwise
     */
    public static boolean isEmpty(String[] details) {
        for (String detail: details) {
            if (detail.isEmpty()) {
                return true;
            }
        }
        return false;
    }
    /**
     * This method checks the Strings stored in an array to see if any of them contain the characters # or %
     * @param details The array to be checked
     * @return true if any String contains # or %; false otherwise
     */
    public static boolean hasInvalidChars(String[] details) {
        for (String detail: details) {
            if (detail.contains("#") || detail.contains("%")) {
                return true;
            }
        }
        return false;
    }
}
