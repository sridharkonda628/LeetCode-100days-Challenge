
class Solution {
    public String sortVowels(String s) {
        List<Character> vowls = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            if(isVowel(s.charAt(i))){
                vowls.add(s.charAt(i));
            }
        }
        Collections.sort(vowls);
        String ans ="";
        int ptr =0;

        for(int i=0;i<s.length();i++){
            if(isVowel(s.charAt(i))){
                ans+= vowls.get(ptr);
                ptr++;
            }else{
                ans+=s.charAt(i);

            }
        }

        return ans;
    }
    public static boolean isVowel(char ch){
        return (ch =='A' || ch =='E' || ch =='I' || ch =='O' ||ch =='U' || ch =='a' ||ch =='e' || ch =='i' ||ch =='o' || ch =='u');
    }
}