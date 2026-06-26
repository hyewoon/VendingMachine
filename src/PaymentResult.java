public class PaymentResult {
    //true-> 재고존재 한다
    //false-> 재고 없다
    boolean success;
    int change;

    public PaymentResult(boolean success, int change){
        this.success = success;
        this.change = change;
    }
}
