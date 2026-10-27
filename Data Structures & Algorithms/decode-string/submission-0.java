class Solution {
    public String decodeString(String s) {
        Stack<String> strings  =new Stack<>();
        Stack<Integer> counts  =new Stack<>();
        int k=0;
        StringBuilder sb  =new StringBuilder();

        for(char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) {
                k = k*10 + (ch-'0');
            } else if (ch =='[') {
                counts.push(k);
                k=0;
                strings.push(sb.toString());
                sb = new StringBuilder();
            } else if (ch ==']') {
                int x  = counts.pop();
                String tmp = sb.toString();
                sb = new StringBuilder(strings.pop());
                for(int  i=0;i<x;i++) {
                    sb.append(tmp);
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}