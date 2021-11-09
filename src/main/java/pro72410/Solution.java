package pro72410;

public class Solution {
    public String solution(String new_id) {
        String answer = "";

        // 1. 대 -> 소문자 치환
        new_id = new_id.toLowerCase();

        // 2. 알파벳, -, _, ., 숫자 이외의 문자 제거
        new_id = new_id.replaceAll("[^a-z\\d-_.]", "");
        System.out.println("new_id = " + new_id);

        // 3. 두 개 이상의 점을 한 점으로 치환
//        new_id = new_id.replaceAll("\\.+", ".");
        new_id = new_id.replaceAll("[.]{2,}", "."); //{2,} -> 2개이상을 찾는다. {2} -> 딱 2개만, {2, 3} -> 2~3개
        System.out.println("new_id = " + new_id);

        // 4. 맨 앞, 맨 뒤가 .일경우 공백으로 치환
        new_id = new_id.replaceAll("^[.]|[.]$", ""); // ^는 first가 .일 경우, $는 마지막이 .일경우를 의미
        System.out.println("new_id = " + new_id);

        // 5. 빈 문자열일 경우, 'a' 대입
        if (new_id.length() == 0) {
            new_id = "a";
        }

        // 6. 길이가 16자 이상이면, 첫 15개 제외하고 모두 날리기
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.charAt(new_id.length() - 1) == '.') {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }

        // 7. 길이가 2자 이하라면, 마지막 문자를 총 길이가 3이 될때까지 반복해서 붙이기
        if (new_id.length() <= 2) {
            char last = new_id.charAt(new_id.length() - 1);
            while (new_id.length() != 3) {
                new_id += last;
            }
        }

        answer = new_id;
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("...!@BaT#*..y.abcdefghijklm.");
    }
}
