class Solution {

    public String findLexSmallestString(String s, int a, int b) {
        int len = s.length();
        String findLexSmallestStringAns = s;
        s = s + s;
        int g = findGCDOFnum(b, len);

        for (int i = 0; i < len; i += g) {

            char[] temp = s.substring(i, i + len).toCharArray();
            add(temp, len, a, 1);
            if (b % 2 != 0) {
                add(temp, len, a, 0);
            }

            String tempStr = new String(temp);
            if (tempStr.compareTo(findLexSmallestStringAns) < 0) {
                findLexSmallestStringAns = tempStr;
            }
        }
        return findLexSmallestStringAns;
    }

    public void add(char[] t, int n, int a, int start) {
        int minVal = 10;
        int noOfTimes = 0;
        for (int i = 0; i < 10; i++) {
            int added = ((t[start] - '0') + i * a) % 10;
            if (added < minVal) {
                minVal = added;
                noOfTimes = i;
            }
        }
        for (int i = start; i < n; i += 2) {
            t[i] = (char) ('0' + (((t[i] - '0') + noOfTimes * a) % 10));
        }
    }

    public int findGCDOFnum(int n1, int n2) {
        while (n2 != 0) {
            int temp = n1;
            n1 = n2;
            n2 = temp % n2;
        }
        return n1;
    }
}