package ShopingCart;

import java.util.HashMap;

public class Cart {

    private Items menu = new Items();
    private HashMap<String,Integer> cart = new HashMap<>();

    public Cart()
    {

    }

    public void addItemToChart(String key, int quentity)
    {
        if(menu.isAvailable(key))
            cart.put(key,quentity);
        else
            System.out.println("Item not available");

    }

    public void removeFromCart(String key)
    {
        if(cart.containsKey(key))
        cart.remove(key);
        else
            System.out.println("Item was never added to cart...");
    }

    public void showCart()
    {
        cart.forEach((item,quentity) -> System.out.println(item+"  ("+quentity+")"));
    }

    public float checkOut()
    {
        float total =0.0f;
        for(String key : cart.keySet())
        {
            System.out.println(key+"("+cart.get(key)+") :\t"+cart.get(key)*menu.getPrice(key));
            total+= cart.get(key)*menu.getPrice(key);
        }
        return total;
    }

}
