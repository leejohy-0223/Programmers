package pro12930;

public class Solution {
    public String solution(String s) {

        int frontVoidCount = 0;
        int backVoidCount = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                frontVoidCount++;
            } else {
                break;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                backVoidCount++;
            } else {
                break;
            }
        }


        String[] splits = s.split(" ", -1);
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp;

        for (String split : splits) {
            if (split.length() == 0) {
                sb.append(" ");
                continue;
            }
            tmp = new StringBuilder();
            for (int i = 0; i < split.length(); i++) {
                if (i % 2 == 0) {
                    tmp.append(Character.toUpperCase(split.charAt(i)));
                    continue;
                }
                tmp.append(Character.toLowerCase(split.charAt(i)));
            }
            sb.append(tmp).append(" ");
        }

        StringBuilder result = new StringBuilder(sb.toString().trim());
        for (int i = 0; i < frontVoidCount; i++) {
            result.insert(0, " ");
        }
        result.append(" ".repeat(Math.max(0, backVoidCount)));
        return result.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String result = s.solution("  ab  bBB    ccc ");
        System.out.println(result);
    }
}
