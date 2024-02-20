package view;

import controller.CommonOperations;
import controller.CustomerOperations;
import model.Customer;
import model.Mobile;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerView {
    private Scanner sc=Store.sc;
    public void view(String user_Gmail,String user_Password) {
        Customer customer= CustomerOperations.validCustomer(user_Gmail,user_Password);
        if(customer!=null) {
            int customer_Loop=1;
            do {
                System.out.println("Enter Your Option :\n1) View All Mobiles.\n2) Search Mobile By Name.\n3) Cart.\n4) Logout.");
                int customerOption=sc.nextInt();
                sc.nextLine();
                switch (customerOption) {
                    case 1: {
                        ArrayList<Mobile> mobiles= CommonOperations.viewAllMobiles();
                        if(mobiles!=null) {
                            printMobiles(mobiles);
                            add_to_cart(customer.getCustomerId());
                        }
                        else {
                            System.out.print("-".repeat(19));
                            System.out.println("No Stock Available!");
                            System.out.print("-".repeat(19));
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("Enter Mobile Name : ");
                        String mobileName=sc.nextLine();
                        ArrayList<Mobile> mobiles= CommonOperations.viewAllMobiles(mobileName);
                        if(mobiles!=null) {
                            printMobiles(mobiles);
                            add_to_cart(customer.getCustomerId());
                        }
                        else {
                            System.out.print("-".repeat(19));
                            System.out.println("No Stock Available!");
                            System.out.print("-".repeat(19));
                        }
                    }
                    case 3: {
                        CartView cartView=new CartView();
                        cartView.view(customer);
                        break;
                    }
                    case 4: {
                        customer_Loop=0;
                        break;
                    }
                    default: {
                        System.out.println("-".repeat(17));
                        System.out.println("Invalid Option...!");
                        System.out.println("-".repeat(17));
                    }
                }
            }
            while(customer_Loop!=0);
        }
        else {
            System.out.println("-".repeat(26));
            System.out.println("No Such Admin Exist...!");
            System.out.println("-".repeat(26));
        }
    }
    public void add_to_cart(int user_Id) {
        System.out.println("Enter '1' For Add To Cart or '0' To exit");
        int loop=sc.nextInt();
        sc.nextLine();
        while(loop==1) {
            System.out.println("Enter Mobile_Id : ");
            int mobile_Id=sc.nextInt();
            sc.nextLine();
            if(CustomerOperations.containMobile(mobile_Id)) {
                CustomerOperations.addToCart(user_Id, mobile_Id);
                System.out.println("Enter '1' For Add To Cart Again or '0' To exit");
                loop = sc.nextInt();
                sc.nextLine();
            }
            else {
                System.out.println("Please Enter The Correct Mobile_Id...!");
            }
        }
    }
    public void printMobiles(ArrayList<Mobile> mobiles) {
        for(Mobile list:mobiles){
            System.out.println("-".repeat(35));
            System.out.println("Mobile Id : "+list.getMobileId());
            System.out.println("Mobile Name : "+list.getMobileName());
            System.out.println("Mobile Price : "+list.getMobilePrice());
            String[] mobile_Description= list.getMobileDescription().split(",");
            for (String s : mobile_Description) {
                System.out.println("* "+s);
            }
            System.out.println("-".repeat(35));
        }
    }
}
