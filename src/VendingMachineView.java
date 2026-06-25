import java.util.Map;

public class VendingMachineView {
    VendingMachine vendingMachine = new VendingMachine();

    public void showMenu() {
        //getMemu()를 호출해서 그 return값을 받아서 화면에 출력함
        Map<Integer, Product> menu = vendingMachine.getMenu();
        for (Map.Entry<Integer, Product> entry : menu.entrySet()) {
            System.out.println( entry.getKey() + "."
                            + entry.getValue().getProductName() + " : "
                            + entry.getValue().getProductPrice() + "원");
        }
    }
}
