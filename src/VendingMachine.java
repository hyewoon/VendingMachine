
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class VendingMachine {
    //자판기 해야 할 일
    // 알아야 할 객체
    //메뉴리스트-> 이 메뮤리스트 수정 가능
    /*
     * 상품목록만들기
     * 주문받기
     * 계산하기
     * 상품 전달하기
     *
     * 제약조건-> 한번에 하나의 상품만 선택한다.
     * */
    //List<String> list = new ArrayList<>(List.of("COLA", "SIDER", "WATER"));
  /*  HashMap<String,Integer> drink = new HashMap<>();

    public VendingMachine(){
        drink.put("COLA", 10);
        drink.put("SIDER",8);
        drink.put("WATER",20);
    }
*/
    /*
     * 주문확인하기-> 상품을 확인하고 재고확인
     * */
  /*  public boolean takeOrder(String product){
        //상품 재고가 존재하는지 확인
        //있으면 true
       return (drink.containsKey(product)&& drink.get(product)>0);
    }*/

    Map<Integer, Product> drink = new TreeMap<>();


    public VendingMachine() {
        drink.put(1, new Product("COLA", 2000, 10));
        drink.put(2, new Product("SIDER", 1500, 8));
        drink.put(3, new Product("WATER", 2000, 20));
        drink.put(4, new Product("COFFEE", 2500, 15));

    }

   /*
   출력은 View로 넘긴다.
   for문 역시 출력을 위한 거니까 제거
   return Map<Integer, Product>

   public void makeMenu(){
      //Map.Entry<Integer,Product> entry = (Map.Entry<Integer, Product>) drink.entrySet();
      for(Map.Entry<Integer,Product> entry:drink.entrySet()){
          System.out.println(entry.getKey()+entry.getValue().getProductName() + entry.getValue().getProductPrice());
      }
    }*/

    public Map<Integer, Product> getMenu(){
        return drink;
    }


    public PaymentResult takeOrder(int num, int money) {
        if (checkStock(num)) return makePayment(num, money);
        else return new PaymentResult(false, money);
    }


    private boolean checkStock(int num) {

        return drink.containsKey(num) && drink.get(num).getCurrentStock() > 0;
    }

    /*
    * 주문확인 후 결제릃 한다.
    * 1. 고객이 넣은 금액을 확인하다. -> 이게 파라미터로 들어온다.
    * 2. 그 금액을 상품의 가격과 비교한다. -> 고객이 선택한 상품을 통해서 그 가격에 접근 Product 객체의 상품name에 접근
    *  -> 상품 가격 > 금액 -> 결제 불가
    *  -> 상품 가격 = 금액 -> 결제 완료 /거스름돈 X
    *  -> 상품 가격 < 금액 -> 결제 완료 / 거스름돈 0
    *
      이때 필요한것은 어떤
     */
    private PaymentResult makePayment(int num, int money) {
        Product target = drink.get(num);

        if (target.price <= money) {
            target.reduceProduct();
            return new PaymentResult(true, money - target.price);
        } else {
            return new PaymentResult(false, money);
        }
    }


}
