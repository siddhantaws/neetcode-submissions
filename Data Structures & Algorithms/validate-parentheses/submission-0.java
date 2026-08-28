class Solution {
    public boolean isValid(String s) {
        final Map<Character,Character> mapOfParenthesis = new HashMap<>();
        mapOfParenthesis.put(')', '(');
        mapOfParenthesis.put(']','[');
        mapOfParenthesis.put('}', '{');
        Stack<Character> parenthesisStaack = new Stack<>();
        for(char ch : s.toCharArray()) {
            if (mapOfParenthesis.containsKey(ch)) {
                if (!parenthesisStaack.isEmpty() && parenthesisStaack.peek() == mapOfParenthesis.get(ch)) {
                    parenthesisStaack.pop();
                } else {
                    return false;
                }
            } else {
                parenthesisStaack.push(ch);
            }
        }
        return parenthesisStaack.isEmpty();
    }
}
