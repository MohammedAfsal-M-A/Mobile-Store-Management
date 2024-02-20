package view;

import controller.CustomerOperations;
import model.Customer;

import static model.DBConnection.*;
import java.util.*;
public class Store
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] arg) {
        createConn();
        int user=1;
        do
        {
            System.out.println("Enter Your User Type :\n1) Admin.\n2) Customer.\n3) Register/SignUp(Only For Customer).\n4) Terminate.");
            int userType=sc.nextInt();
            sc.nextLine();
            String user_Gmail=null;
            String user_Password=null;
            if(userType==1 || userType==2)
            {
                System.out.println("Enter Your Gmail :");
                user_Gmail=sc.next();
                System.out.println("Enter Your Password :");
                user_Password=sc.next();
            }
            switch (userType)
            {
                case 1:
                {
                    AdminView adminView=new AdminView();
                    adminView.View(user_Gmail,user_Password);
                    break;
                }
                case 2:
                {
                    CustomerView customerView=new CustomerView();
                    customerView.view(user_Gmail,user_Password);

                    break;
                }
                case 3:
                {
                    System.out.println("Enter Your Name : ");
                    String name= sc.nextLine();
                    System.out.println("Enter Your Number : ");
                    long number=sc.nextLong();
                    System.out.println("Enter Your Gmail : ");
                    String gmail= sc.next();
                    System.out.println("Enter Your Password : ");
                    String password=sc.next();
                    System.out.println("Enter Your Confirm Password : ");
                    String confirm_Password=sc.next();
                    while(!password.equals(confirm_Password))
                    {
                        System.out.println("-".repeat(55));
                        System.out.println("Your Password And Confirm Password Should Be Same...!");
                        System.out.println("-".repeat(557));
                        System.out.println("Enter Your Password : ");
                        password=sc.next();
                        System.out.println("Enter Your Confirm Password : ");
                        confirm_Password=sc.next();
                    }
                    Customer customer=new Customer();
                    customer.setCustomerName(name);
                    customer.setCustomerPassword(password);
                    customer.setCustomerGmail(gmail);
                    customer.setCustomerNumber(number);
                    CustomerOperations.createCustomerAccount(customer);
                    System.out.println("-".repeat(45));
                    System.out.println("Your Account is Registered Successfully...!");
                    System.out.println("-".repeat(45));
                    break;
                }
                case 4:
                {
                    user=0;
                    break;
                }
                default:
                {
                    System.out.println("----------------------------------");
                    System.out.println("Please Enter Correct User Type...!");
                    System.out.println("----------------------------------");
                }
            }
        }
        while(user!=0);
        sc.close();
        closeConn();
    }
}
