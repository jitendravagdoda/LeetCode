package LeetCode;

public class LongestPalindromeSubstring {

    public int longestPalindromeSubstringEasy(char arr[]) {

        int longest_substring = 1;
        for (int i = 0; i < arr.length; i++) {

            int x, y;
            int palindrome;
            x = i;
            y = i + 1;
            palindrome = 0;
            while (x >= 0 && y < arr.length && arr[x] == arr[y]) {
                x--;
                y++;
                palindrome += 2;
            }
            longest_substring = Math.max(longest_substring, palindrome);

            x = i - 1;
            y = i + 1;
            palindrome = 1;
            while (x >= 0 && y < arr.length && arr[x] == arr[y]) {
                x--;
                y++;
                palindrome += 2;
            }
            longest_substring = Math.max(longest_substring, palindrome);
        }
        return longest_substring;
    }

    /**

     */
    public int longestPalindromicSubstringLinear(char input[]) {
        int index = 0;
        char newInput[] = new char[2*input.length + 1];
        for(int i=0; i < newInput.length; i++) {
            if(i % 2 != 0) {
                newInput[i] = input[index++];
            } else {
                newInput[i] = '$';
            }
        }


        int T[] = new int[newInput.length];
        int start = 0;
        int end = 0;

        for(int i=0; i < newInput.length; ) {

            while(start >0 && end < newInput.length-1 && newInput[start-1] == newInput[end+1]) {
                start--;
                end++;
            }

            T[i] = end - start + 1;

            if(end == T.length -1) {
                break;
            }

            int newCenter = end + (i%2 ==0 ? 1 : 0);

            for(int j = i + 1; j <= end; j++) {

                T[j] = Math.min(T[i - (j - i)], 2 * (end - j) + 1);
                if(j + T[i - (j - i)]/2 == end) {
                    newCenter = j;
                    break;
                }
            }
            i = newCenter;
            end = i + T[i]/2;
            start = i - T[i]/2;
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < T.length; i++) {
            int val;
            val = T[i]/2;
            if(max < val) {
                max = val;
            }
        }
        return max;
    }

    public int longestPalindromeDynamic(char []str){
        boolean T[][] = new boolean[str.length][str.length];

        for(int i=0; i < T.length; i++){
            T[i][i] = true;
        }

        int max = 1;
        for(int l = 2; l <= str.length; l++){
            int len = 0;
            for(int i=0; i < str.length-l+1; i++){
                int j = i + l-1;
                len = 0;
                if(l == 2){
                    if(str[i] == str[j]){
                        T[i][j] = true;
                        len = 2;
                    }
                }else{
                    if(str[i] == str[j] && T[i+1][j-1]){
                        T[i][j] = true;
                        len = j -i + 1;
                    }
                }
                if(len > max){
                    max = len;
                }
            }
        }
        return max;
    }

    public static void main(String args[]) {
        LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
        System.out.println(lps.longestPalindromicSubstringLinear("abba".toCharArray()));
        System.out.println(lps.longestPalindromicSubstringLinear("abbababba".toCharArray()));
        System.out.println(lps.longestPalindromicSubstringLinear("babcbaabcbaccba".toCharArray()));
        System.out.println(lps.longestPalindromicSubstringLinear("cdbabcbabdab".toCharArray()));
    }

}
