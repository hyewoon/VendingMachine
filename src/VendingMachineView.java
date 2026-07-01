import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineView {

    Scanner scanner = new Scanner(System.in);
    VendingMachine vendingMachine = new VendingMachine();

    public void startVendingMachine() {
        while (true) {
            System.out.println("자판기 프로그램");
            System.out.println("[0].종료  [1].주문하기");
            System.out.println("탭을 선택하세요.");

            int inputValue = checkInputValidation();

            if (inputValue == 1) {
                makeOrder();
                continue;
            } else if (inputValue == 0) break;
            else System.out.println("다시 입력해 주세요.");
        }
    }


    //입력값이 존재하는 지, 그 입력값이 형식(숫자)맞는지 확인 용
    private int checkInputValidation() {

        while (true) {
            String inputValue = scanner.nextLine();
            if (inputValue.trim().isEmpty()) {
                System.out.println("입력값이 없습니다.");
                System.out.println("다시 입력해 주세요.");
                continue;
            }

            try {
                return Integer.parseInt(inputValue.trim());
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해 주세요.");
            }
        }
    }

    public void makeOrder() {
        int menu = 0;
        int money = 0;

            showMenu();
            menu = chooseMenu();
            money = insertMoney();

            PaymentResult result = vendingMachine.takeOrder(menu, money);
            showResult(result);

    }

    private int chooseMenu() {
            int menu = 0;
            System.out.println("음료를 선택하세요.");
            menu = checkInputValidation();

            //menu번호 가져오기
            return menu;

    }

    private int insertMoney() {
        while (true) {
            System.out.println("금액을 입력하세요.");
            int money = checkInputValidation();
            if ( money < 0) {
                System.out.println("입금액이 없습니다.");
                continue;
            }
            return money;
        }

    }

    private void showMenu() {

        System.out.println("============== 메뉴창 ==========");
        Map<Integer, Product> menu = vendingMachine.getMenu();
        for (Map.Entry<Integer, Product> entry : menu.entrySet()) {
            System.out.println(entry.getKey() + "."
                    + entry.getValue().getProductName() + " : "
                    + entry.getValue().getProductPrice() + "원");
        }
        System.out.println("===============================");
    }


    private int checkValidation(int min, int max, String message) {
        while (true) {
            System.out.println(message);
            String inputValue = scanner.nextLine();
            // 빈 입력 먼저 거르기
            if (inputValue.trim().isEmpty()) {
                System.out.println("입력값이 없습니다.");
                continue;
            }
            //숫자로 변환-> 이 값을 메뉴/가격/되돌아가기/ 무슨의미로 보는가?
            //메뉴랑-가격의 입력값은 하나의 takeOrder()의 파라미터로 넘어간다. 하나로 묶을 수 있다.
            try {
                int tempNumber = 0;
                tempNumber = Integer.parseInt(inputValue.trim());
                //menu, price, choice
                if (tempNumber < min || tempNumber > max) {
                    System.out.println("유효하지 않은 번호입니다.");
                    continue;
                }
                return tempNumber;
            } catch (NumberFormatException e) {
                System.out.println(" 숫자만 입력해주세요.");
            }
            scanner.close();
        }

    }

    private void showResult(PaymentResult result) {
        if (result.success) {
            System.out.println("결제완료");
            System.out.println("거스름돈:" + result.change + "원");
        } else {
            System.out.println("결제불가 : 잔액이 부족합니다.");
            System.out.println("환불액:" + result.change + "원");
        }
    }
}
