public class Solution {

    public int maxPartitionsAfterOperations(String s, int k) {
        int len = s.length();
        int[][] leftNums = new int[len][3];
        int[][] rightNumsarr = new int[len][3];

        int num = 0;
        int mask = 0;
        int cnt = 0;
        for (int i = 0; i < len - 1; i++) {
            int binr = 1 << (s.charAt(i) - 'a');
            if ((mask & binr) == 0) {
                cnt++;
                if (cnt <= k) {
                    mask |= binr;
                } else {
                    num++;
                    mask = binr;
                    cnt = 1;
                }
            }
            //
            leftNums[i + 1][0] = num;
            leftNums[i + 1][1] = mask;
            leftNums[i + 1][2] = cnt;
        }

        num = 0;
        mask = 0;
        cnt = 0;
        for (int i = len - 1; i > 0; i--) {
            int binr = 1 << (s.charAt(i) - 'a');
            if ((mask & binr) == 0) {
                cnt++;
                if (cnt <= k) {
                    mask |= binr;
                } else {
                    num++;
                    mask = binr;
                    cnt = 1;
                }
            }
            rightNumsarr[i - 1][0] = num;
            rightNumsarr[i - 1][1] = mask;
            rightNumsarr[i - 1][2] = cnt;
        }

        int maxiValuess = 0;
        for (int i = 0; i < len; i++) {
            int seg = leftNums[i][0] + rightNumsarr[i][0] + 2;
            int totMask = leftNums[i][1] | rightNumsarr[i][1];
            int totcnt = Integer.bitCount(totMask);
            if (leftNums[i][2] == k && rightNumsarr[i][2] == k && totcnt < 26) {
                seg++;
            } else if (Math.min(totcnt + 1, 26) <= k) {
                seg--;
            }
            maxiValuess = Math.max(maxiValuess, seg);
        }
        return maxiValuess;
    }
}