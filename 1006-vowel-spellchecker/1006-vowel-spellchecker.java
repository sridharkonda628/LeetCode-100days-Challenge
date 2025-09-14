class Solution {
    Set<String> perfect_Words;
    Map<String, String> words_cap;
    Map<String, String> words_vow;

    public String[] spellchecker(String[] wordListing, String[] queres) {
        perfect_Words = new HashSet();
        words_cap = new HashMap();
        words_vow = new HashMap();

        for (String word: wordListing) {
            perfect_Words.add(word);

            String wordlow = word.toLowerCase();
            words_cap.putIfAbsent(wordlow, word);

            String wordlowDV = devowel(wordlow);
            words_vow.putIfAbsent(wordlowDV, word);
        }

        String[] resStr = new String[queres.length];
        int t = 0;
        for (String query: queres)
            resStr[t++] = solve(query);
        return resStr;
    }

    public String solve(String query) {
        if (perfect_Words.contains(query))
            return query;

        String queryL = query.toLowerCase();
        if (words_cap.containsKey(queryL))
            return words_cap.get(queryL);

        String queryLV = devowel(queryL);
        if (words_vow.containsKey(queryLV))
            return words_vow.get(queryLV);

        return "";
    }

    public String devowel(String word) {
        StringBuilder resStr = new StringBuilder();
        for (char ch: word.toCharArray())
            resStr.append(isVowel(ch) ? '*' : ch);
        return resStr.toString();
    }

    public boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
}