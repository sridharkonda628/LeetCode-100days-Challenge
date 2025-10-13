class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> removeAnagrams = new ArrayList<>();

        removeAnagrams.add(words[0]);

        int lengthOfGivenWord = words.length;

        for(int i=1;i<lengthOfGivenWord;i++){
            if(!checkAnagram(words[i-1],words[i])){
                removeAnagrams.add(words[i]);
            }
        }

        return removeAnagrams;

    }

    public static boolean checkAnagram(String w1, String w2){
        int[] fq = new int[26];

        boolean flg = true;
        for(int i=0;i<w1.length();i++){
            fq[w1.charAt(i)-'a']++;
        }
        for(int i=0;i<w2.length();i++){
            fq[w2.charAt(i)-'a']--;
        }

        for(int num : fq){
            if(num!=0){
                flg = false;
                break;
            }
        }

        return flg;
    }
}