package view;

import java.util.Map;
import java.util.Scanner;

import domain.OrderStatus;
import domain.PaymentResult;
import domain.Product;
import domain.VendingMachine;

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
        showMenu();
        int menu = chooseMenu();
        int money = insertMoney();

        PaymentResult result = vendingMachine.takeOrder(menu, money);
        showResult(result);
    }

    private int chooseMenu() {
        while (true) {
            System.out.println("음료를 선택하세요.");
            int menu = checkInputValidation();
            if (vendingMachine.checkKey(menu)) return menu;
            System.out.println("존재하지 않는 메뉴입니다. 다시 선택해주세요.");
        }
    }

    private int insertMoney() {
        while (true) {
            System.out.println("금액을 입력하세요.");
            int money = checkInputValidation();
            if (money < 0) {
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


    private void showResult(PaymentResult result) {
        switch (result.getStatus()) {
            case SUCCESS -> {
                System.out.println("결제완료");
                System.out.println("거스름돈:" + result.getChange() + "원");
            }
            case OUT_OF_STOCK -> {
                System.out.println("결제불가 : 재고가 부족합니다.");
                System.out.println("환불액:" + result.getChange() + "원");
            }
            case NOT_ENOUGH_MONEY -> {
                System.out.println("결제불가 : 잔액이 부족합니다.");
                System.out.println("환불액:" + result.getChange() + "원");
            }
        }

    }
}
