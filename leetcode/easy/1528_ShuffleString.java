/*
    2022-08-22
    [Leetcode][Easy] 1528. Shuffle String
*/
class ShuffleString {
    /*
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Shuffle String.
     * Memory Usage: 45 MB, less than 39.33% of Java online submissions for Shuffle String.
     */
    public String restoreString(String s, int[] indices) {
        char[] chStr = s.toCharArray();
        char[] shuffled = new char[indices.length];

        for(int i=0; i<indices.length; i++) {
            shuffled[indices[i]] = chStr[i];
        }
        return String.valueOf(shuffled);
    }
}