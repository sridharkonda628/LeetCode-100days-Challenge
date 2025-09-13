import java.util.*;
class Solution {
    public int maxFreqSum(String s) {
        Map<Character,Integer> hp = new HashMap<>();
        Set<Character> s1 = new HashSet<>();
        s1.add('a');
        s1.add('e');
        s1.add('i');
        s1.add('o');
        s1.add('u');
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            hp.put(c,hp.getOrDefault(c,0)+1);
            
        }
        int vf =0 ,cf =0;

        for(var i:hp.keySet()){
            if(s1.contains(i)){
                vf = Math.max(vf,hp.get(i));
            }else{
                
            cf = Math.max(cf,hp.get(i));
            }
        }
        return cf+vf;
        
    }
}