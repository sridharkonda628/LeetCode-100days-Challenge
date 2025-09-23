class Solution {
    public int compareVersion(String vers1, String vers2) {
        String[] v1 = vers1.split("\\.");

        String[] v2 = vers2.split("\\.");

        int maxiLen = Math.max(v1.length, v2.length);
        for (int i = 0; i < maxiLen; i++) {
            int n1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            
            int n2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (n1 < n2) return -1;
            if (n1 > n2) return 1;
        }
        return 0;
    }
}