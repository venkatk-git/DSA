package Bit.Breeze;


class Solution {
    public String addBinary(String a, String b) {
        StringBuilder binary = new StringBuilder();

        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while(i >= 0 || j >= 0 || carry != 0) {
            int digitA = i >= 0 ? a.charAt(i) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j) - '0' : 0;

            int total = digitA + digitB + carry;
            
            char ch = (char) ((total % 2) + '0');
            binary.append(ch);
            
            carry = total / 2;
            i--;
            j--;
        }

        return binary.reverse().toString();
    }
}

public class AddBinary {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";

        System.out.println(new Solution().addBinary(a, b));
    }    
}
