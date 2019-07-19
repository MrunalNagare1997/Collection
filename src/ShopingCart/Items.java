package ShopingCart;

import java.util.HashMap;

public class Items {

    private HashMap <String,Float>itemList = new HashMap<>();

    Items()
    {
        itemList.put("Tomato",25.0f);
        itemList.put("Green_Chili",20.0f);
        itemList.put("Potato",15.0f);
        itemList.put("Peeper",30.0f);
        itemList.put("Capsicum",25.0f);
        itemList.put("Orange",40f);
        itemList.put("Mango",120.0f);
        itemList.put("Brinjal",25.0f);
    }

    public float getPrice(String key)
    {
        if(itemList.containsKey(key))
            return itemList.get(key);
        else
        return -1.0f;
    }

    public boolean isAvailable(String key)
    {
        if(itemList.containsKey(key))
            return true;
        else
            return false;
    }

    public void showMenu()
    {
        System.out.println("........Menu.......");
        itemList.forEach((I,P) -> System.out.println(I+"\t\t\t"+P));
    }
}
