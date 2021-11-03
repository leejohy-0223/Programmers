package pro17687;

public class SolutionRef {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        int startNum = 0;

        StringBuilder target = new StringBuilder();

        while (target.length() < m * t) {
            target.append(Integer.toString(startNum++, n));
        }

        for (int i = 0; i < t; i++) {
            answer.append(target.charAt(p - 1 + i * m));
        }

        return answer.toString().toUpperCase();
    }

    public static void main(String[] args) {
        SolutionRef s = new SolutionRef();
//        System.out.println(s.solution(2, 4, 2, 1));
//        System.out.println(s.solution(16, 16, 2, 1));
        System.out.println(s.solution(16, 16, 2, 2));
    }
}