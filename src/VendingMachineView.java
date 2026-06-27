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

        while(true){

            int money = 0;
            int input = 0;
            int menu = 0;
            showMenu();
            //입력값 받기
            System.out.println("번호를 선택하세요.");
            try{
             menu = scanner.nextInt();
               if(menu< 1 || menu > 4) {
                    System.out.println("메뉴번호를 다시 선택해주세요. 유효하지 않는 번호입니다.");
                    continue;
                }
            }catch (InputMismatchException e){
                System.out.println("메뉴 번호를 다시 선택해주세요. 숫자만 입력해주세요");
                scanner.nextLine();
                continue;
            }
                System.out.println("금액을 투입하세요");
                 money = scanner.nextInt();

                    PaymentResult result = vendingMachine.takeOrder(menu, money);
                    showResult(result);

                System.out.println("주문을 계속 하시겠습니까?");
                System.out.println("번호를 입력하세요");
                System.out.println("1. yes  2.no");

                    input = scanner.nextInt();
                    if(input == 2) break;

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
