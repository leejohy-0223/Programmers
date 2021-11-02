package pro12939;

public class Solution {
    public String solution(String s) {
        String answer = "";

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        String[] sp = s.split(" ");

        for (String s1 : sp) {
            int tmp = Integer.parseInt(s1);
            max = Math.max(max, tmp);
            min = Math.min(min, tmp);
        }

        answer = min + " " + max;
        return answer;
    }
}
