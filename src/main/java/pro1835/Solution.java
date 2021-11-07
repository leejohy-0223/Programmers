package pro1835;

public class Solution {

    static char[] character = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    boolean[] check = new boolean[8];
    StringBuilder sb = new StringBuilder();
    String[] save;
    int result = 0;

    public int solution(int n, String[] data) {
        int answer = 0;
        save = data;
        DFS(0);
        answer = result;

        return answer;
    }

    private void DFS(int L) {
        if (L == 8) {
            boolean check = false;
            for (int j = 0; j < save.length; j++) {
                String tmp1 = String.valueOf(save[j].charAt(0));
                String tmp2 = String.valueOf(save[j].charAt(2));
                String comp = String.valueOf(save[j].charAt(3));
                int value = Character.getNumericValue(save[j].charAt(4));

                int a = sb.indexOf(tmp1);
                int b = sb.indexOf(tmp2);

                if (comp.equals("=")) {
                    if (value + 1 != Math.abs(a - b)) {
                        check = true;
                        break;
                    }
                }
                if (comp.equals(">")) {
                    if (!(Math.abs(a - b) > value + 1)) {
                        check = true;
                        break;
                    }
                }
                if (comp.equals("<")) {
                    if (!(Math.abs(a - b) <= value)) {
                        check = true;
                        break;
                    }
                }
            }
            if (!check) {
                result++;
            }
        } else {
            for (int i = 0; i < character.length; i++) {
                if (!check[i]) {
                    check[i] = true;
                    sb.append(character[i]);
                    DFS(L + 1);
                    sb.deleteCharAt(L);
                    check[i] = false;
                }
            }
        }
    }

}
