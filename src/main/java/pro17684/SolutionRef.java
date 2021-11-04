package pro17684;

import java.util.ArrayList;
import java.util.HashMap;

public class SolutionRef {

    public int[] solution(String msg) {
        ArrayList<Integer> compress = new ArrayList<>();
        HashMap<String, Integer> dic = new HashMap<>();

        initDic(dic);

        int dicIdx = 27;
        boolean isEnd = false;

        for (int idx = 0; idx < msg.length(); idx++) {
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(idx));

            while (dic.containsKey(sb.toString())) {
                idx++;
                if (idx == msg.length()) {
                    isEnd = true;
                    break;
                }
                sb.append(msg.charAt(idx));
            }

            // 나온 시점에는 포함되지 않는 문자열이다.
            // idx가 end를 가리키고 있다면, 끝내야한다.
            if (isEnd) {
                compress.add(dic.get(sb.toString()));
                break;
            }

            // 새로운 String을 등록한다.
            dic.put(sb.toString(), dicIdx++);

            // 이전까지의 찾아진 값을 더해준다.
            compress.add(dic.get(sb.substring(0, sb.length() - 1)));
            idx--;
        }

        for (Integer integer : compress) {
            System.out.println(integer);
        }

        return compress.stream().mapToInt(Integer::intValue).toArray();
    }

    public void initDic(HashMap<String, Integer> dic) {
        char ch = 'A';

        for (int i = 1; i < 27; i++) {
            dic.put(ch + "", i);
            ch += 1;
        }
    }

    public static void main(String[] args) {
        SolutionRef s = new SolutionRef();
        s.solution("KAKAO");
    }
}