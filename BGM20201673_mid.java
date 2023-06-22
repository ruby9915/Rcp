import java.util.Random;
import java.util.Scanner;
import java.lang.System;//시스템을 인식못하는 버그 발생 코드 문제가 아닌 외부의 다른 버그로 판단하여 추가

public class BGM20201673_mid {

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
        System.out.println("게임을 시작하려면 -2를 입력하세요.");
        System.out.println("대출을 시작하려면 -3를 입력하세요.");
        System.out.print("시작 포인트를 입력하세요: ");

        while (true) {
            double totalPoints = scanner.nextDouble();//초기 시작 포인트 설정
            scanner.nextLine();
            
                if (totalPoints < 100000 || totalPoints > 10000000){
                        System.out.println("잘못된 입력입니다. 다시 시작하세요. 초기 최대 설정 포인트는 10만포 부터 1000만포 까지 입니다"); 
                        continue;
                    }// 초기 포인트 오류시 프로그램 재실행 if문 사용할 경우 예외값 입력시 처리 목적으로 while문을 사용
                int totalLoan = 0;//대출 총합
                int loanCount = 0;//대출 횟수 카운팅
                double asset = 0.0;//총 자산

                System.out.println("시작 포인트는" + totalPoints + "입니다.");

                while (totalLoan <= 100000000) {    //메인 게임 대괄호
                        System.out.println("선택해 주십시오");
                        System.out.print("종료, 게임시작, 대출을 선택 할 수 있습니다.");
                        String player1Choice = scanner.nextLine();//플레이어의 선택 입력 받음
                        

                        if (!player1Choice.equals("-1") && !player1Choice.equals("-2") && !player1Choice.equals("-3")) {
                            System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                            continue;//선택 오류시 처리 문자열 -를 같이 입력 하기 때문에 실수로 문자열만 입력 할 경우 
                        } else if ((player1Choice.equals("-2"))) {
                            if (totalPoints <= 0) {
                                System.out.println("배팅 할 수 있는 포인트가 없습니다. 대출 혹은 게임을 종료 해주세요");
                                continue;//배팅금액 확인
                            }
                            System.out.print("포인트를 걸어주세요: ");
                            double betPoints = scanner.nextDouble();//초기 배팅 설정
                            scanner.nextLine();
                            
                            if (betPoints < 10000 || betPoints > totalPoints) {
                                System.out.println("잘못된 포인트입니다. 다시 입력하세요.배팅 포인트는 최소10000포 입니다.");
                                continue;
                            } else if (betPoints % 10000 != 0) {
                                System.out.println("배팅 금액은 10000의 배수여야 합니다. 다시 입력하세요.");
                                continue;
                            }//포인트 잘못 설정 할 경우 그리고 100원 미만은 소숫점 계산이 안되기 떄문에 최소 배팅금액을 정함
                            System.out.println("낼것을 선택 해 주세요");
                            System.out.println("가위:0");
                            System.out.println("바위:1");
                            System.out.println("보:2");
                            System.out.print("입력:");

                            int player1Choicen = scanner.nextInt();//낼것 선택
                                if (player1Choicen > 2 || player1Choicen < 0) {
                                    System.out.println("손모가지 말짱한거 마이 바준기다 알제?"); 
                                    System.out.println();
                                    totalPoints -= betPoints;
                                    System.out.println("포인트가 " + betPoints + "만큼 차감 되었습니다.");
                                    System.out.println("현재 포인트는: " + totalPoints + "입니다");
                                    scanner.nextLine();
                                    continue; //잘못 입력 했을 경우 징벌적 차감
                                }

                            int player2Choice = random.nextInt(3);  // 랜덤으로 컴퓨터의 선택을 생성
                            
                            String player1Move = outcomes[player1Choicen][0];//위의 선택자랑 이름이 곂쳐서 따로 n을 붙혀 차이점을 둠
                            String player2Move = outcomes[player2Choice][1];
                            System.out.println("플레이어 1의 선택: " + player1Choicen);
                            System.out.println("컴퓨터의 선택: " + player2Choice);
                            System.out.println("가위는 0, 바위는 1, 보는 2입니다.");
                            
                            // 결과 출력
                            if (player1Move.equals(player2Move)) { //equals를 사용해 같은걸 냈는지 비교
                                double deduction = (Double) (betPoints * 0.01);  // 비겼을 경우 차감될 포인트 계산
                                totalPoints -= deduction;//총 포인트합산
                                asset -= deduction;//총 자산 합산
                                System.out.println("비겼습니다. 포인트가 " + deduction + "만큼 차감됩니다.");
                            } else if (((player1Move.equals("가위") && player2Move.equals("바위")) ||
                            (player1Move.equals("바위") && player2Move.equals("보")) ||
                            (player1Move.equals("보") && player2Move.equals("가위")))) {
                                totalPoints -= betPoints;
                                asset -= betPoints;
                                //졌을 경우 배열 비교를 통해 반환
                                System.out.println("컴퓨터가 이겼습니다. 포인트가 " + betPoints + " 차감됩니다.");//졌을 경우 포인트 차감 
                            } else {
                                totalPoints += betPoints;
                                asset += betPoints;
                                System.out.println("플레이어 1이 이겼습니다. 포인트가 " + betPoints + "만큼 추가됩니다.");//이겼을 경우 포인트 추가
                            }
                        }//-2 닫힘 괄호
                        else if (player1Choice.equals("-1")) {
                            System.out.println("게임을 종료합니다.");
                            asset += totalPoints;
                            if (asset == -100000000.0){
                                System.out.println("갚을 능력도 안되면서 돈을 꾀나 빌렸더군요.....");
                                System.out.println("당신은 강안리 앞바다 밑 '드럼통' 이 되었습니다.");
                                System.out.println("다음생엔 도박 같은건 하지 마시길 바랍니다");//총 자산이 -1억일 경우(최대 대출을 떙기고 모두 잃었을 경우)
                            } else if (asset > -100000000 && asset < 0){
                                System.out.println("당신은 도박에서 손해를 보셨습니다 인생의 교훈이 되셨길 바랍니다");//총 자산이 0원 이하일 경우
                            } else if (asset < 10000000 && asset > 0) {
                                System.out.println("즐거운 게임 되셨나요? 또 다시 찾아주시길 바라며 좋은하루 되십시오");//1천만 포인트 보다 적고 0원보다 많이 남은 경우
                            } else if (asset <= 200000000 && asset >= 10000000){
                            System.out.println("본전은 건지셨군요 당신의 현재 자산은" + asset + "입니다."); //1천만 포인트이상이고 2억 이하일 경우
                            } else if (asset > 200000000 && asset < 1000000000){
                                System.out.println("축하합니다 당신은 가위바위보로 20배 이상의 수익을 내셨습니다!!");//2억 초과이고 10억 미만일 경우
                                System.out.println("당신의 현재 자산은" + asset + "입니다!!!");
                            } else if (asset >= 1000000000) {
                                System.out.println("축하합니다 당신은 가위바위보로 100배 이상의 수익을 내셨습니다!!");//10억 포인트 이상일 경우
                                System.out.println("당신의 현재 자산은" + asset + "입니다!!!");
                                System.out.println("행님 그.. 뽀찌좀.....");
                            }
                            System.exit(0);
                        }//게임 종료시 구문
                        else if (player1Choice.equals("-3")){
                            if (loanCount < 6 && totalLoan <= 100000000) {
                                System.out.print("대출할 포인트를 입력하세요: ");
                                double player1loan = scanner.nextDouble();
                                
                                
                                if (player1loan <= 0 || player1loan > 20000000) {
                                    System.out.println("대출 조건에 부합하지 않습니다.");
                                    System.out.print("대출을 다시 받으시겠습니까? (Y/N): ");
                                    String continueLoan = scanner.next(); //잘못된 입력을 할 경우
                                    if (continueLoan.equalsIgnoreCase("Y")) {
                                        scanner.nextLine();
                                        continue; // 대출을 다시 받기 위해 반복문의 처음으로 돌아감
                                    } else {
                                        scanner.nextLine();
                                        continue;}
                                }
                                    if (loanCount >= 5 || totalLoan >= 100000000) {
                                    System.out.println("대출 조건이 충족되지 않습니다.");
                                    System.out.println("대출을 5회 이상 하셨는지 혹은 총 대출 금액이 1억 포인트가 넘었는지 확인 해 주십시오");
                                    System.out.println("현재 대출 횟수는" + loanCount + "회 이며");
                                    System.out.println("총 대출 금액은" + totalLoan + "포인트 입니다"); 
                                    scanner.nextLine();
                                    continue; //대출 조건 미충족시 조건을 알리고 현재 상태를 확인
                                }
                                else {
                                    totalLoan += player1loan;
                                    totalPoints += player1loan;            
                                    asset -= player1loan ;
                                    loanCount++;
                                    
                                }
                            }
                        }//대출 실행 구문
                        System.out.println("현재 포인트: " +totalPoints); //게임한판 하고 현재 포인트 말해주기
                        System.out.println();
                        scanner.nextLine();
                        continue;
                }//대괄호 종료료
                scanner.close();
            }
            
        }
        
    }
