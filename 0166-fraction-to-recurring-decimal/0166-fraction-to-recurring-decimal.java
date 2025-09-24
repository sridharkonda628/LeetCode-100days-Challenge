class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder strBuidrResult = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) strBuidrResult.append('-');

        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);

        strBuidrResult.append(n / d);
        long remInDiv = n % d;
        if (remInDiv == 0) return strBuidrResult.toString();

        strBuidrResult.append('.');

        
        Map<Long, Integer> seen = new HashMap<>();

        while (remInDiv != 0) {
            if (seen.containsKey(remInDiv)) {
                int pos = seen.get(remInDiv);
                strBuidrResult.insert(pos, "(");
                strBuidrResult.append(')');
                break;
            }
            seen.put(remInDiv, strBuidrResult.length());
            remInDiv *= 10;
            strBuidrResult.append(remInDiv / d);
            remInDiv = remInDiv % d;
        }
        return strBuidrResult.toString();
    }
}