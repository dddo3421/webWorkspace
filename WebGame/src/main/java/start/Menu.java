//package start;
//
//import java.util.Scanner;
//
//import game.GaBaBo;
//import game.Guess;
//import info.AppInfo;
//
//public class Menu {
//
//    private Scanner sc = new Scanner(System.in);          
//
//    // 메뉴 실행
//    public void showMenu() {
//        int menuNum = 0;
//        boolean input;
//
//        do {
//            System.out.println("*********************************");
//            System.out.println("               메뉴               ");
//            System.out.println("---------------------------------");
//            System.out.println("1. 애플리케이션 정보");     // 앱 정보
//            System.out.println("2. 가위바위보 게임");       // 가위바위보
//            System.out.println("3. 숫자 알아맞히기 게임");  // 숫자 맞추기
//            System.out.println("4. 종료");                 // 프로그램 종료
//            System.out.println("---------------------------------");
//
//            // 메뉴번호 입력
//            do {
//                System.out.print("메뉴 번호를 입력 : ");
//                if (sc.hasNextInt()) {
//                    menuNum = sc.nextInt();
//                    System.out.println("*********************************");
//                    if (menuNum >= 1 && menuNum <= 4) {
//                        input = true;
//                    } else {
//                        System.out.println("잘못된 입력입니다. 1~4 사이 숫자를 입력하세요.");
//                        input = false;
//                    }
//                } else {
//                    System.out.println("숫자를 입력하세요.");
//                    sc.next();
//                    input = false;
//                }
//            } while (!input);
//
//            // 메뉴 실행
//            switch (menuNum) {
//                case 1: // 앱 정보
//                    new AppInfo().appinfo();
//                    break;
//                case 2: // 가위바위보
//                    new GaBaBo().gababo();
//                    break;
//                case 3: // 숫자 맞추기 게임
//                    new Guess().guess();
//                    break;
//                case 4: // 종료
//                    System.out.println("종료합니다!");
//                    System.out.println("*********************************");
//                    break;
//            }
//
//        } while (menuNum != 4);
//
//        sc.close();
//    }
//}
