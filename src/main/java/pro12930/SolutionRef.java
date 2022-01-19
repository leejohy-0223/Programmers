package pro12930;

public class SolutionRef {
    public String solution(String s) {
        char[] chars = s.toCharArray();
        int idx = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                idx = 0;
                continue;
            }
            chars[i] = (idx++ % 2 == 0) ? Character.toUpperCase(chars[i]) : Character.toLowerCase(chars[i]);
        }
        return String.valueOf(chars);
    }
}
