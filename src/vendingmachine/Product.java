
package vendingmachine;
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

    public String getProductName(){
        return name;
    }

    public int getProductPrice(){
        return price;
    }

    public Product getProduct(){
        return this;
    }

}
