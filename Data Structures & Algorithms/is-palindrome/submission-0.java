class Solution {
    public boolean isPalindrome(String s) {
        int l =0;int r=s.length()-1;
        while(l<r) {
            while(l<r && !isValidChar(s.charAt(l)))
                l++;
            while(r>l && !isValidChar(s.charAt(r)))
                r--; 
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
                return false;
            l++;r--;           
        }
        return true;
    }

    public boolean isValidChar(char ch) {
        return (ch >='A' && ch<='Z') || (ch >='a' && ch<='z') || (ch >='0' && ch<='9');
    }
}
