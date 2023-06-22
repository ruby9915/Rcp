import java.util.Random;
import java.util.Scanner;

public class Bgm_20201673_mid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        var outcomes = new String[][] {
                {"����", "����"},
                {"����", "����"},
                {"����", "��"},
                {"����", "����"},
                {"����", "����"},
                {"����", "��"},
                {"��", "����"},
                {"��", "����"},
                {"��", "��"}
        };

        System.out.println("���� ���� �� ������ �����մϴ�.");
        System.out.println("������ 0, ������ 1, ���� 2�� �Է��ϼ���.");
        System.out.println("������ �����Ϸ��� -1�� �Է��ϼ���.");

        while (true) {
            System.out.print("�÷��̾� 1�� ����: ");
            int player1Choice = scanner.nextInt();

            if (player1Choice == -1) {
                System.out.println("������ �����մϴ�.");
                break;
            }

            if (player1Choice < 0 || player1Choice > 2) {
                System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��ϼ���.");
                continue;
            }

            int player2Choice = random.nextInt(3);  // �������� ��ǻ���� ������ ����

            String player1Move = outcomes[player1Choice][0];
            String player2Move = outcomes[player2Choice][1];

            System.out.println("�÷��̾� 1�� ����: " + player1Choice);
            System.out.println("��ǻ���� ����: " + player2Choice);
            System.out.println("������ 0, ������ 1, ���� 2�Դϴ�.");

            // ��� ���
            if (player1Move.equals(player2Move)) {
                System.out.println("�����ϴ�.");
            } else if 
                ((player1Move.equals("����") && player2Move.equals("����")) ||
                (player1Move.equals("����") && player2Move.equals("��")) ||
                (player1Move.equals("��") && player2Move.equals("����"))) {
                System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
            } else {
                System.out.println("�÷��̾� 1�� �̰���ϴ�.");
            }
            System.out.println();
        }
        scanner.close();
    }
}
