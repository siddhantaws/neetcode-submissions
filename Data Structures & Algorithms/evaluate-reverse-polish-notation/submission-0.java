
class Solution {
    public int evalRPN(String[] tokens) {
        final Stack<Integer> stack = new Stack<>();
        Map<String, java.util.function.BiFunction<Integer, Integer, Integer>> operator = new HashMap<>();
        operator.put("+", (a, b) -> a + b);
        operator.put("*", (a, b) -> a * b);
        operator.put("-", (a, b) -> b - a);
        operator.put("/", (a, b) -> b / a);
        for (String s : tokens) {
            if (operator.containsKey(s)) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(operator.get(s).apply(val1, val2));
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

}
