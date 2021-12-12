package pro67257;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    static List<List<String>> list = new ArrayList<>();

    public long solution(String expression) {
        long answer = 0;
        boolean[] visited = new boolean[3];
        String[] operationTypes = {"-", "+", "*"};
        // 연산자 우선순위 모든 경우의 수를 계산
        permutation(new ArrayList<>(), operationTypes, visited);

        // 숫자 파싱
        List<Long> numbers = Arrays.stream(expression.replaceAll("-|\\+|\\*", " ").split(" "))
            .map(Long::parseLong).collect(Collectors.toList());

        // 연산자 파싱
        List<String> operators = Arrays.stream(expression.replaceAll("[0-9]", "").split(""))
            .collect(Collectors.toList());

        // 각 연산자 케이스마다 계산 반복하가
        for (List<String> cases : list) {
            answer = Math.max(answer, solve(cases, numbers, operators));
        }
        return answer;
    }

    private long solve(List<String> cases, List<Long> numbers, List<String> operators) {

        // 결과를 변경하기 위해 numbers, operators 복사
        ArrayList<Long> copyNum = new ArrayList<>(numbers);
        ArrayList<String> copyOp = new ArrayList<>(operators);

        // 우선순위 높은 연산부터 수행
        for (String cOp : cases) {
            for (int i = 0; i < copyOp.size(); i++) {
                if (cOp.equals(copyOp.get(i))) {
                    long front = copyNum.get(i);
                    long back = copyNum.get(i + 1);
                    long temp = calc(front, back, copyOp.get(i));

                    // 연산 다 했으니 빼주자.
                    copyNum.remove(i + 1);
                    copyNum.remove(i);
                    copyOp.remove(i);

                    // 연산 결과는 더해주자.
                    copyNum.add(i, temp);

                    i--;
                }
            }
        }
        return Math.abs(copyNum.get(0));
    }

    private long calc(long front, long back, String operation) {

        switch (operation) {
            case "-":
                return front - back;
            case "+":
                return front + back;
            default:
                return front * back;
        }
    }

    private void permutation(ArrayList<String> arrayList, String[] operation, boolean[] visited) {
        if (arrayList.size() == 3) {
            list.add(arrayList);
            return;
        }

        for (int i = 0; i < operation.length; i++) {
            if (!visited[i]) {
                ArrayList<String> temp = new ArrayList<>(arrayList);
                temp.add(operation[i]);
                visited[i] = true;
                permutation(temp, operation, visited);
                visited[i] = false;
            }
        }
    }
}
