import java.util.Random;
import java.util.Scanner;

public class Bgm_20201673_mid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        var outcomes = new String[][] {
                {"가위", "가위"},
                {"가위", "바위"},
                {"가위", "보"},
                {"바위", "가위"},
                {"바위", "바위"},
                {"바위", "보"},
                {"보", "가위"},
                {"보", "바위"},
                {"보", "보"}
        };

        System.out.println("가위 바위 보 게임을 시작합니다.");
        System.out.println("가위는 0, 바위는 1, 보는 2를 입력하세요.");
        System.out.println("게임을 종료하려면 -1을 입력하세요.");

        while (true) {
            System.out.print("플레이어 1의 선택: ");
            int player1Choice = scanner.nextInt();

            if (player1Choice == -1) {
                System.out.println("게임을 종료합니다.");
                break;
            }

            if (player1Choice < 0 || player1Choice > 2) {
                System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                continue;
            }

            int player2Choice = random.nextInt(3);  // 랜덤으로 컴퓨터의 선택을 생성

            String player1Move = outcomes[player1Choice][0];
            String player2Move = outcomes[player2Choice][1];

            System.out.println("플레이어 1의 선택: " + player1Choice);
            System.out.println("컴퓨터의 선택: " + player2Choice);
            System.out.println("가위는 0, 바위는 1, 보는 2입니다.");

            // 결과 출력
            if (player1Move.equals(player2Move)) {
                System.out.println("비겼습니다.");
            } else if 
                ((player1Move.equals("가위") && player2Move.equals("바위")) ||
                (player1Move.equals("바위") && player2Move.equals("보")) ||
                (player1Move.equals("보") && player2Move.equals("가위"))) {
                System.out.println("컴퓨터가 이겼습니다.");
            } else {
                System.out.println("플레이어 1이 이겼습니다.");
            }
            System.out.println();
        }
        scanner.close();
    }
}
