import java.util.*;

class Main {
    public int solution(String pos) {
        // A7
        int answer = 0;
        final int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
        final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        // (0, 7)
        int curY = Character.getNumericValue(pos.charAt(1)) - 1; // (1, 5), (2, 6), (2, 7)
        int curX = ((int)pos.charAt(0)-64) - 1;

        for(int i = 0; i < 8; i++) {
            int nextX = curX + dx[i];
            int nextY = curY + dy[i];

            if(nextX < 0 || nextX >= 8 || nextY < 0 || nextY >= 8) {
                continue;
            } else {
                answer++;
            }
        }

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Main sol = new Main();
        String pos = "A7";
        int ret = sol.solution(pos);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}