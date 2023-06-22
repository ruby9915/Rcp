import java.util.Random;
import java.util.Scanner;
import java.lang.System;//�ý����� �νĸ��ϴ� ���� �߻� �ڵ� ������ �ƴ� �ܺ��� �ٸ� ���׷� �Ǵ��Ͽ� �߰�

public class BGM20201673_mid {

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
        System.out.println("������ �����Ϸ��� -2�� �Է��ϼ���.");
        System.out.println("������ �����Ϸ��� -3�� �Է��ϼ���.");
        System.out.print("���� ����Ʈ�� �Է��ϼ���: ");

        while (true) {
            double totalPoints = scanner.nextDouble();//�ʱ� ���� ����Ʈ ����
            scanner.nextLine();
            
                if (totalPoints < 100000 || totalPoints > 10000000){
                        System.out.println("�߸��� �Է��Դϴ�. �ٽ� �����ϼ���. �ʱ� �ִ� ���� ����Ʈ�� 10���� ���� 1000���� ���� �Դϴ�"); 
                        continue;
                    }// �ʱ� ����Ʈ ������ ���α׷� ����� if�� ����� ��� ���ܰ� �Է½� ó�� �������� while���� ���
                int totalLoan = 0;//���� ����
                int loanCount = 0;//���� Ƚ�� ī����
                double asset = 0.0;//�� �ڻ�

                System.out.println("���� ����Ʈ��" + totalPoints + "�Դϴ�.");

                while (totalLoan <= 100000000) {    //���� ���� ���ȣ
                        System.out.println("������ �ֽʽÿ�");
                        System.out.print("����, ���ӽ���, ������ ���� �� �� �ֽ��ϴ�.");
                        String player1Choice = scanner.nextLine();//�÷��̾��� ���� �Է� ����
                        

                        if (!player1Choice.equals("-1") && !player1Choice.equals("-2") && !player1Choice.equals("-3")) {
                            System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��ϼ���.");
                            continue;//���� ������ ó�� ���ڿ� -�� ���� �Է� �ϱ� ������ �Ǽ��� ���ڿ��� �Է� �� ��� 
                        } else if ((player1Choice.equals("-2"))) {
                            if (totalPoints <= 0) {
                                System.out.println("���� �� �� �ִ� ����Ʈ�� �����ϴ�. ���� Ȥ�� ������ ���� ���ּ���");
                                continue;//���ñݾ� Ȯ��
                            }
                            System.out.print("����Ʈ�� �ɾ��ּ���: ");
                            double betPoints = scanner.nextDouble();//�ʱ� ���� ����
                            scanner.nextLine();
                            
                            if (betPoints < 10000 || betPoints > totalPoints) {
                                System.out.println("�߸��� ����Ʈ�Դϴ�. �ٽ� �Է��ϼ���.���� ����Ʈ�� �ּ�10000�� �Դϴ�.");
                                continue;
                            } else if (betPoints % 10000 != 0) {
                                System.out.println("���� �ݾ��� 10000�� ������� �մϴ�. �ٽ� �Է��ϼ���.");
                                continue;
                            }//����Ʈ �߸� ���� �� ��� �׸��� 100�� �̸��� �Ҽ��� ����� �ȵǱ� ������ �ּ� ���ñݾ��� ����
                            System.out.println("������ ���� �� �ּ���");
                            System.out.println("����:0");
                            System.out.println("����:1");
                            System.out.println("��:2");
                            System.out.print("�Է�:");

                            int player1Choicen = scanner.nextInt();//���� ����
                                if (player1Choicen > 2 || player1Choicen < 0) {
                                    System.out.println("�ո��� ��¯�Ѱ� ���� ���ر�� ����?"); 
                                    System.out.println();
                                    totalPoints -= betPoints;
                                    System.out.println("����Ʈ�� " + betPoints + "��ŭ ���� �Ǿ����ϴ�.");
                                    System.out.println("���� ����Ʈ��: " + totalPoints + "�Դϴ�");
                                    scanner.nextLine();
                                    continue; //�߸� �Է� ���� ��� ¡���� ����
                                }

                            int player2Choice = random.nextInt(3);  // �������� ��ǻ���� ������ ����
                            
                            String player1Move = outcomes[player1Choicen][0];//���� �����ڶ� �̸��� ���ļ� ���� n�� ���� �������� ��
                            String player2Move = outcomes[player2Choice][1];
                            System.out.println("�÷��̾� 1�� ����: " + player1Choicen);
                            System.out.println("��ǻ���� ����: " + player2Choice);
                            System.out.println("������ 0, ������ 1, ���� 2�Դϴ�.");
                            
                            // ��� ���
                            if (player1Move.equals(player2Move)) { //equals�� ����� ������ �´��� ��
                                double deduction = (Double) (betPoints * 0.01);  // ����� ��� ������ ����Ʈ ���
                                totalPoints -= deduction;//�� ����Ʈ�ջ�
                                asset -= deduction;//�� �ڻ� �ջ�
                                System.out.println("�����ϴ�. ����Ʈ�� " + deduction + "��ŭ �����˴ϴ�.");
                            } else if (((player1Move.equals("����") && player2Move.equals("����")) ||
                            (player1Move.equals("����") && player2Move.equals("��")) ||
                            (player1Move.equals("��") && player2Move.equals("����")))) {
                                totalPoints -= betPoints;
                                asset -= betPoints;
                                //���� ��� �迭 �񱳸� ���� ��ȯ
                                System.out.println("��ǻ�Ͱ� �̰���ϴ�. ����Ʈ�� " + betPoints + " �����˴ϴ�.");//���� ��� ����Ʈ ���� 
                            } else {
                                totalPoints += betPoints;
                                asset += betPoints;
                                System.out.println("�÷��̾� 1�� �̰���ϴ�. ����Ʈ�� " + betPoints + "��ŭ �߰��˴ϴ�.");//�̰��� ��� ����Ʈ �߰�
                            }
                        }//-2 ���� ��ȣ
                        else if (player1Choice.equals("-1")) {
                            System.out.println("������ �����մϴ�.");
                            asset += totalPoints;
                            if (asset == -100000000.0){
                                System.out.println("���� �ɷµ� �ȵǸ鼭 ���� �ҳ� ���ȴ�����.....");
                                System.out.println("����� ���ȸ� �չٴ� �� '�巳��' �� �Ǿ����ϴ�.");
                                System.out.println("�������� ���� ������ ���� ���ñ� �ٶ��ϴ�");//�� �ڻ��� -1���� ���(�ִ� ������ ����� ��� �Ҿ��� ���)
                            } else if (asset > -100000000 && asset < 0){
                                System.out.println("����� ���ڿ��� ���ظ� ���̽��ϴ� �λ��� ������ �Ǽ̱� �ٶ��ϴ�");//�� �ڻ��� 0�� ������ ���
                            } else if (asset < 10000000 && asset > 0) {
                                System.out.println("��ſ� ���� �Ǽ̳���? �� �ٽ� ã���ֽñ� �ٶ�� �����Ϸ� �ǽʽÿ�");//1õ�� ����Ʈ ���� ���� 0������ ���� ���� ���
                            } else if (asset <= 200000000 && asset >= 10000000){
                            System.out.println("������ �����̱��� ����� ���� �ڻ���" + asset + "�Դϴ�."); //1õ�� ����Ʈ�̻��̰� 2�� ������ ���
                            } else if (asset > 200000000 && asset < 1000000000){
                                System.out.println("�����մϴ� ����� ������������ 20�� �̻��� ������ ���̽��ϴ�!!");//2�� �ʰ��̰� 10�� �̸��� ���
                                System.out.println("����� ���� �ڻ���" + asset + "�Դϴ�!!!");
                            } else if (asset >= 1000000000) {
                                System.out.println("�����մϴ� ����� ������������ 100�� �̻��� ������ ���̽��ϴ�!!");//10�� ����Ʈ �̻��� ���
                                System.out.println("����� ���� �ڻ���" + asset + "�Դϴ�!!!");
                                System.out.println("��� ��.. ������.....");
                            }
                            System.exit(0);
                        }//���� ����� ����
                        else if (player1Choice.equals("-3")){
                            if (loanCount < 6 && totalLoan <= 100000000) {
                                System.out.print("������ ����Ʈ�� �Է��ϼ���: ");
                                double player1loan = scanner.nextDouble();
                                
                                
                                if (player1loan <= 0 || player1loan > 20000000) {
                                    System.out.println("���� ���ǿ� �������� �ʽ��ϴ�.");
                                    System.out.print("������ �ٽ� �����ðڽ��ϱ�? (Y/N): ");
                                    String continueLoan = scanner.next(); //�߸��� �Է��� �� ���
                                    if (continueLoan.equalsIgnoreCase("Y")) {
                                        scanner.nextLine();
                                        continue; // ������ �ٽ� �ޱ� ���� �ݺ����� ó������ ���ư�
                                    } else {
                                        scanner.nextLine();
                                        continue;}
                                }
                                    if (loanCount >= 5 || totalLoan >= 100000000) {
                                    System.out.println("���� ������ �������� �ʽ��ϴ�.");
                                    System.out.println("������ 5ȸ �̻� �ϼ̴��� Ȥ�� �� ���� �ݾ��� 1�� ����Ʈ�� �Ѿ����� Ȯ�� �� �ֽʽÿ�");
                                    System.out.println("���� ���� Ƚ����" + loanCount + "ȸ �̸�");
                                    System.out.println("�� ���� �ݾ���" + totalLoan + "����Ʈ �Դϴ�"); 
                                    scanner.nextLine();
                                    continue; //���� ���� �������� ������ �˸��� ���� ���¸� Ȯ��
                                }
                                else {
                                    totalLoan += player1loan;
                                    totalPoints += player1loan;            
                                    asset -= player1loan ;
                                    loanCount++;
                                    
                                }
                            }
                        }//���� ���� ����
                        System.out.println("���� ����Ʈ: " +totalPoints); //�������� �ϰ� ���� ����Ʈ �����ֱ�
                        System.out.println();
                        scanner.nextLine();
                        continue;
                }//���ȣ �����
                scanner.close();
            }
            
        }
        
    }
