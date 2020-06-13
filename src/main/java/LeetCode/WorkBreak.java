package LeetCode;
import java.awt.peer.WindowPeer;
import java.sql.SQLOutput;
import java.util.*;

/*
Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
 */

public class WorkBreak {
    public static void main(String[] args) {
        String s = "aaaaaaa";
        String wordDict[] = {"aaaa","aaa"};

        List<String> result=new ArrayList();

        HashMap<Integer, List<String>> map=new HashMap();
        Set<String> set=new HashSet(Arrays.asList(wordDict));

        for( String word : wordDict) {
                int start=0;
                while(s.indexOf(word,start)!=-1) {
                    int key = s.indexOf(word, start);
                    List<String> temp = map.getOrDefault(key, new ArrayList());
                    temp.add(word);
                    map.put(key, temp);
                    start= start+key+word.length();
                }
        }
        System.out.println(map.toString());
        WorkBreak wb= new WorkBreak();

        wb.helper(s,set,result,0, new StringBuilder());

    }
//
//     public void helper(HashMap<Integer, List<String>> map, String res, int current, int length, List<String> result) {
//         if (current == length) {
//             result.add(res);
//         }
//
//         if (map.containsKey(current)) {
//             List<String> temp = map.get(current);
//
//             for (String s : temp) {
//                 helper(map, res + " " + s, current + s.length(), length, result);
//             }
//         }
//     }

    private void helper(String s, Set<String> set, List<String> res, int index, StringBuilder sb) {
        if (index == s.length()) {
            sb.deleteCharAt(sb.length() - 1);
            res.add(new String(sb));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (set.contains(s.substring(index, i + 1))) {
                int length = sb.length();
                sb.append(s.substring(index, i + 1));
                sb.append(" ");
                helper(s, set, res, i + 1, sb);
                sb.setLength(length);
            }
        }
    }
    private boolean valid(String s, Set<String> set) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
