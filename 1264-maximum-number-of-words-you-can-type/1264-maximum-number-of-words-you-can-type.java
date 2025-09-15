class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int cnt =0;
        String[] words = text.split(" ");
        //
        int[] broken = new int[26];
        for(int i=0;i<brokenLetters.length();i++){
            broken[brokenLetters.charAt(i)-97]++;
        }
        
        for(String word : words){
            for(int i =0;i<word.length();i++){
                if(broken[word.charAt(i)-'a']!=0){
                    cnt++;
                    break;
                }
            }
        }
        return (words.length-cnt);
    }
   
}