public class Product {
    String name;
    int price;
    int stock;

    public Product(String name, int price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void reduceProduct(){
       stock--;
    }

    public void increaseProduct(){
        stock++;
    }

    public int getCurrentStock(){
    return stock;
    }

}
