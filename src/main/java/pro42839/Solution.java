///programmers(소수 찾기) https://programmers.co.kr/learn/courses/30/lessons/42839

package pro42839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static boolean[] chk;
    static char[] pm;
    static int answer;
    static int size;
    static ArrayList<Integer> arr = new ArrayList<>();
    public int solution(String numbers) {

        // TODO : https://programmers.co.kr/learn/courses/30/lessons/42839/solution_groups?language=java
        char[] chars = numbers.toCharArray();
        size = numbers.length();

        for (int i = 1; i <= size; i++) {
            chk = new boolean[size];
            pm = new char[i];
            makeNumber(chars, i, 0);
        }

        return answer;
    }

    private void makeNumber(char[] chars, int size, int depth) {

        if (depth == size) {
            // 소수 체크
            StringBuilder sb = new StringBuilder();
            for (char aChar : pm) {
                sb.append(aChar);
            }
            if(checkPrime(sb.toString())) {
                answer++;
            }
            return;

        }
        for (int i = 0; i < chars.length; i++) {
            if (!chk[i]) {
                pm[depth] = chars[i];
                chk[i] = true;
                makeNumber(chars, size, depth + 1);
                chk[i] = false;
            }
        }
    }

    private boolean checkPrime(String s) {
        int num = Integer.parseInt(s);

        if(arr.contains(num)) return false;
        arr.add(num);

        if(num == 0 || num == 1) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);


        Solution s = new Solution();
        System.out.println(s.solution("17"));
//        System.out.println(s.solution("011"));

    }
}
