package ShopingCart;

import java.awt.*;
import java.util.Scanner;

public class Shop {

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Cart cart1=new Cart();

        char conti='n';
        do {
            System.out.println("1. Add to cart.\n2. Remove Item\n3. View Cart\n4. Checkout\n5. Exit");
            short choice= sc.nextShort();
            switch (choice)
            {
                case 1:
                {
                    System.out.println("Enter Item and quantity...");
                    cart1.addItemToChart(sc.next(),sc.nextInt());
                    break;
                }
                case 2:
                {
                    System.out.println("Enter Item to remove...");
                    cart1.removeFromCart(sc.next());
                    break;
                }
                case 3:
                {
                    cart1.showCart();
                    break;
                }
                case 4:
                {
                    System.out.println(cart1.checkOut());
                    break;
                }
                case 5:
                {
                    System.exit(0);
                }
                default:
                {
                    System.out.println("Please Enter Valid Choice...");
                    break;
                }

            }
            System.out.println("Continue (Y/N)?");
            conti=sc.next().charAt(0);
        }while(conti=='y');
    }
}
