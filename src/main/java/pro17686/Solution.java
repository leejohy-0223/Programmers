package pro17686;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public String[] solution(String[] files) {

        List<String> strings = Arrays.asList(files);

        strings.sort((o1, o2) -> {
            int s1 = 0, s2 = 0;

            // s1 추출
            for (int i = 0; i < o1.length(); i++) {
                if (Character.isDigit(o1.charAt(i))) {
                    s1 = i;
                    break;
                }
            }

            int e1 = s1 + 1;
            // e1 추출
            for (int i = s1 + 1; i < o1.length(); i++) {
                if (!Character.isDigit(o1.charAt(i))) { // i가 digit이 아니라면 e1을 갱신하고 break
                    e1 = i;
                    break;
                }
                // 만약 e1이 맨 끝 인덱스를 가리킨다면 outofbound를 가리키도록 변경 후 break
                if (e1 == o1.length() - 1) {
                    e1++;
                    break;
                }
                // Digit이 아닐때까지 올려준다.
                e1++;
            }

            // s2 추출
            for (int i = 0; i < o2.length(); i++) {
                if (Character.isDigit(o2.charAt(i))) {
                    s2 = i;
                    break;
                }
            }

            int e2 = s2 + 1;
            // e2 추출
            for (int i = s2 + 1; i < o2.length(); i++) {
                if (!Character.isDigit(o2.charAt(i))) {
                    e2 = i;
                    break;
                }
                if (e2 == o2.length() - 1) {
                    e2++;
                    break;
                }
                e2++;
            }

            String head1 = o1.substring(0, s1);
            String head2 = o2.substring(0, s2);

            int num1 = Integer.parseInt(o1.substring(s1, e1));
            int num2 = Integer.parseInt(o2.substring(s2, e2));

            if (head1.equalsIgnoreCase(head2)) {
                if (num1 == num2) {
                    return 0; // head1, head2가 같으며, num1, num2가 동일하면 그대로 둔다.
                }
                return num1 - num2; // head1, head2가 같으면 num1, num2를 비교한다.
            }
            return head1.compareToIgnoreCase(head2); // head1, head2기준으로 먼저 정렬한다.
        });

        for (String string : strings) {
            System.out.print(string + " ");
        }

        return strings.toArray(String[]::new);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        String[] solution = s.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
//        String[] solution = s.solution(new String[]{"MUZI10.zip", "amuzi10.jpg", "muzi012.TXT", "muzi9.txtt", "muzi0011.txt"});
//        String[] solution = s.solution(new String[]{"foo010bar02019.zip", "foo009bar02021.zip"});
        String[] solution = s.solution(new String[]{"ver 1000003", "ver 1000002"});
//        String[] solution = s.solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"});
//        for (String s1 : solution) {
//            System.out.print(s1 + ", ");
//        }
    }
}
