public class PaymentResult {
    //true-> 재고존재 한다
    //false-> 재고 없다
    //boolean success;
    OrderStatus status;
    int change;

    public PaymentResult(OrderStatus status, int change){
        this.status = status;
        this.change = change;
    }
}
