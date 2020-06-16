package LeetCode;

/*
In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.



Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 */

public class VerifyingAlienDictionary {
    public static void main(String[] args) {
        VerifyingAlienDictionary verifyingAlienDictionary=new VerifyingAlienDictionary();
        String words[] ={ "hello","leetcode"}, order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(verifyingAlienDictionary.isAlienSorted(words,order));

    }

    public boolean isAlienSorted(String[] words, String order) {
        if(words.length<=1)
            return true;
        int orderArray[] = new int[26];
        for(int  i=0; i<order.length(); i++){
            orderArray[order.charAt(i) -'a'] = i;
        }
        String prev= words[0];
        for( int i=1; i<words.length; i++){
            int j=0;
            while(j<Math.min(prev.length(), words[i].length())){
                if(prev.charAt(j)!=words[i].charAt(j)){
                    if(orderArray[prev.charAt(j)- 'a']<orderArray[words[i].charAt(j) - 'a'])
                        break;
                    else
                        return false;
                }
                j++;
            }
            if(j==Math.min(prev.length(),words[i].length()) && prev.length()>words[i].length())
                return false;
            prev= words[i];
        }
        return true;
    }
}
