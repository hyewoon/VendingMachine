public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.takeOrder(1);
        vendingMachine.makePayment(1, 5000);
        vendingMachine.takeOrder(3);
        vendingMachine.makePayment(3, 100);
    }



}