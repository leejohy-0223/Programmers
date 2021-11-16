package pro70129;

public class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        int zeroErase = 0;
        int count = 0;
        while (!s.equals("1")){
            count++;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroErase++;
                }
            }
            s = s.replaceAll("0", "");
            s = Integer.toBinaryString(s.length());
        }

        // s -> 0제거
        answer[0] = count;
        answer[1] = zeroErase;

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] solution = s.solution("110010101001");
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
