class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb =new StringBuilder("");
        for(String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i=0;int j=0;
        List<String> strs = new ArrayList<>();
        while(i<str.length()){
            i= j;
            while(str.charAt(j)!='#')
                j++;
            int length = Integer.parseInt(str.substring(i,j));
            i = j+1;
            j = i+ length;
            strs.add(new String(str.substring(i, j)));
            i = j;
        }
        return strs;
    }
}
