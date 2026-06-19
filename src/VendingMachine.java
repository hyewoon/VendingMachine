import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    HashMap<Integer,Product> product = new HashMap<>();
    boolean result = false;
    public VendingMachine(){
        product.put(1,new Product("COLA", 2000,10));
        product.put(2,new Product("SIDER", 1500,8));
        product.put(3,new Product("WATER", 2000,20));
        product.put(4,new Product("COFFEE", 2500,15));

    }

    public boolean takeOrder(int num){
        result = product.containsKey(num) && product.get(num).stock > 0 ;
        return result;
    }

/*
* 주문확인 후 결제릃 한다.
* */
    public void makePayment(int num,int money){
        int temp = product.get(num).price;
      if(money < temp){
          System.out.println("잔액이 부족합니다.");
      }else if(money == temp){
          //재고 하나 줄이기
      }else {
          //거스름돈 주기
      }
    }







}
