import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineView {

    Scanner scanner = new Scanner(System.in);
    VendingMachine vendingMachine = new VendingMachine();

    private void showMenu() {

        //getMemu()를 호출해서 그 return값을 받아서 화면에 출력함
        System.out.println("============== 메뉴 ==========");
        Map<Integer, Product> menu = vendingMachine.getMenu();
        for (Map.Entry<Integer, Product> entry : menu.entrySet()) {
            System.out.println(entry.getKey() + "."
                    + entry.getValue().getProductName() + " : "
                    + entry.getValue().getProductPrice() + "원");
        }
        System.out.println("===============================");
    }

    public void makeOrder() {
        int menu = 0;
        int money = 0;
        int input = 0;

        while (true) {
            showMenu();
            //입력값 받기
            menu = checkValidation(1, 4, "번호를 선택하세요");

            money = checkValidation(0, 1000000, "금액을 투입하세요");

            PaymentResult result = vendingMachine.takeOrder(menu, money);
            showResult(result);

            input = checkValidation(1, 2, "주문을 계속하시겠습니까? 1.YES 2.NO");
            if (input == 2) break;

        }
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
