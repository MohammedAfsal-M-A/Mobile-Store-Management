package view;

import controller.AdminOperations;
import controller.CommonOperations;
import model.Admin;
import model.Mobile;
import model.Transaction;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminView {
    private Scanner sc=Store.sc;
    public void View(String user_Gmail,String user_Password) {
        Admin admin=AdminOperations.validAdmin(user_Gmail,user_Password);
        if(admin!=null) {
            int admin_Loop=1;
            do {
                System.out.println("Enter Your Option :\n1) View All Mobiles.\n2) Search Mobile By Name.\n3) Add Mobile.\n4) Remove Mobile.\n5) See Total Transactions.\n6) Add Another Admin.\n7) Logout.");
                int adminOption=sc.nextInt();
                sc.nextLine();
                switch (adminOption) {
                    case 1: {
                        ArrayList<Mobile> mobiles= CommonOperations.viewAllMobiles();
                        if(mobiles!=null) {
                            printMobiles(mobiles);
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
                        }
                        else {
                            System.out.print("-".repeat(19));
                            System.out.println("No Stock Available!");
                            System.out.print("-".repeat(19));
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Enter Mobile Name : ");
                        String mobileName=sc.nextLine();
                        System.out.println("Enter Mobile Price : ");
                        int mobilePrice=sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Description About Mobile \nFormat : 'Ram 4GB, Rom 64GB, ...' (Separate Each Field By Comma ',') : ");
                        String mobileDescription=sc.nextLine();
                        Mobile mobile=new Mobile();
                        mobile.setMobileName(mobileName);
                        mobile.setMobilePrice(mobilePrice);
                        mobile.setMobileDescription(mobileDescription);
                        AdminOperations.addMobile(mobile);
                        System.out.println("-".repeat(37));
                        System.out.println("Mobile Added To Stock Successfully...!");
                        System.out.println("-".repeat(37));
                        break;
                    }
                    case 4: {
                        ArrayList<Mobile> mobiles= CommonOperations.viewAllMobiles();
                        if(mobiles!=null) {
                            printMobiles(mobiles);
                            System.out.println("Enter Mobile Id : ");
                            int mobileId=sc.nextInt();
                            sc.nextLine();
                            AdminOperations.removeMobile(mobileId);
                            System.out.println("-".repeat(41));
                            System.out.println("Mobile Removed From Stock Successfully...!");
                            System.out.println("-".repeat(41));
                        }
                        else {
                            System.out.print("-".repeat(19));
                            System.out.println("No Stock Available!");
                            System.out.print("-".repeat(19));
                        }
                        break;
                    }
                    case 5: {
                        ArrayList<Transaction> transactions= AdminOperations.seeTransactions();
                        if(transactions!=null) {
                            for(Transaction list:transactions) {
                                System.out.println("-".repeat(35));
                                System.out.println("Mobile Id : " + list.getTransactionId());
                                System.out.println("Mobile Name : " + list.getCustomerId());
                                System.out.println("Mobile Price : " + list.getMobileId());
                                System.out.println("-".repeat(35));
                            }
                        }
                        else {
                            System.out.print("-".repeat(34));
                            System.out.println("No Transaction Is Still Processed!");
                            System.out.print("-".repeat(34));
                        }
                        break;
                    }
                    case 6: {
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
                        while(!password.equals(confirm_Password)) {
                            System.out.println("-".repeat(52));
                            System.out.println("Your Password And Confirm Password Should Be Same...!");
                            System.out.println("-".repeat(52));
                            System.out.println("Enter Your Password : ");
                            password=sc.next();
                            System.out.println("Enter Your Confirm Password : ");
                            confirm_Password=sc.next();
                        }
                        Admin newadmin=new Admin();
                        newadmin.setAdminName(name);
                        newadmin.setAdminPassword(password);
                        newadmin.setAdminGmail(gmail);
                        newadmin.setAdminNumber(number);
                        AdminOperations.createAdminAccount(newadmin);
                        System.out.println("-".repeat(60));
                        System.out.println(admin.getAdminName()+" New Admin Account Is Added Successfully...!");
                        System.out.println("-".repeat(60));
                        break;
                    }
                    case 7: {
                        admin_Loop=0;
                        break;
                    }
                    default: {
                        System.out.println("-".repeat(17));
                        System.out.println("Invalid Option...!");
                        System.out.println("-".repeat(17));
                    }
                }
            }
            while(admin_Loop!=0);
        }
        else {
            System.out.println("-".repeat(23));
            System.out.println("No Such Admin Exist...!");
            System.out.println("-".repeat(23));
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
