class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mapOfAnagram = new HashMap<>();
        for (String str :strs) {
            char ch[] = new char[26];
            for(char c :str.toCharArray()) {
                ch[c - 'a']++;
            }
            final String newStr = Arrays.toString(ch);
            mapOfAnagram.putIfAbsent(newStr, new ArrayList<>());
            mapOfAnagram.get(newStr).add(str);
        }
        return new ArrayList<>(mapOfAnagram.values());
    }
}
