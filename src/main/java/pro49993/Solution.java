package pro49993;

public class Solution {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        char[] chars = skill.toCharArray();
        for (String s : skill_trees) {
            char[] tmp = s.toCharArray();
            int idx = 0;
            boolean chk = false;
            for (char c : tmp) {
                if (skill.contains(c + "")) {
                    if (chars[idx] == c) {
                        idx++;
                    } else {
                        chk = true;
                        break;
                    }
                }
            }
            if(!chk) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        System.out.println(s.solution(skill, skill_trees));
    }
}
