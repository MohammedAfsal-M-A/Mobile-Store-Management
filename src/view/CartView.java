package view;

import controller.CustomerOperations;
import model.Cart;
import model.Customer;
import model.Mobile;

import java.util.ArrayList;
import java.util.Scanner;

public class CartView {
    private Scanner sc=Store.sc;
    public void view(Customer customer)
    {
        ArrayList<Cart> cartList= CustomerOperations.viewCart(customer);
        int count=0;
        if(cartList!=null){
            for(Cart list:cartList) {
                System.out.println("-".repeat(35));
                System.out.println("Cart Id : " + list.getCartId());
                System.out.println("Customer Id : " + list.getCustomerId());
                System.out.println("Mobile Mobile : " + list.getMobileId());
                count++;
            }
        }
        if(count!=0)
        {
            int cartLoop=1;
            do
            {
                System.out.println("Enter Your Option : \n1) Purchase.\n2) Remove From Cart\n3) Back.");
                int cart_Choice=sc.nextInt(),cart_Id=-1;
                sc.nextLine();
                Cart cart=null;
                if(cart_Choice==1||cart_Choice==2)
                {
                    System.out.println("Enter Cart_Id : ");
                    cart_Id=sc.nextInt();
                    sc.nextLine();
                    cart=CustomerOperations.cartExist(customer,cart_Id);
                }
                if(cart_Choice==3||cart!=null)
                {
                    switch (cart_Choice)
                    {
                        case 1:
                        {
                            CustomerOperations.purchaseMobile(customer,cart_Id);
                            break;
                        }
                        case 2:
                        {
                            CustomerOperations.removeFromCart(customer, cart_Id,true);
                            break;
                        }
                        case 3:
                        {
                            cartLoop = 0;
                            break;
                        }
                        default:
                        {
                            System.out.println("Invalid Choice...!");
                        }
                    }
                }
            }
            while(cartLoop!=0);
        }
        else{
            System.out.println("-".repeat(14));
            System.out.println("Cart Is Empty!");
            System.out.println("-".repeat(14));
        }
    }
}
