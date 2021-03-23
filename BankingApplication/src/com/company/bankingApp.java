package com.company;
import java.util.Scanner;

public class bankingApp {
    int money;
    int previousMoney;
    String customerName;
    String customerId;

    bankingApp(String cname , String cıd){
        customerId = cıd;
        customerName = cname;
    }

    void addMoney (int amaount){
        if(amaount != 0){
            money = money + amaount;
            previousMoney = amaount;
        }
        else{
            System.out.println("You didn't add money. Please Try Again.");
        }
    }

    void withdraw(int amaount){
        if(amaount>money){
            System.out.println("You don't have that much money..!!! Please try again");
        }
        else{
            money=money-amaount;
            previousMoney=amaount;
        }
    }

    void getPrevioudTransaction(){
        if(previousMoney>0){
            System.out.println("Deposited:"+previousMoney);
        }
        else if(previousMoney<0){
            System.out.println("Withdrawn: "+Math.abs(previousMoney));
        }
        else{
            System.out.println("No transaction occured");
        }
    }

    void showMenu(){
        char resume=' ';
        Scanner menuScan = new Scanner(System.in);
        System.out.println("Welcome "+customerName);
        System.out.println("Your ID is "+customerId);
        System.out.println("\n");
        System.out.println("[1]-Check Balance");
        System.out.println("[2]-Deposit");
        System.out.println("[3]-Withdraw");
        System.out.println("[4]-Previous Transaction");
        System.out.println("[5]-Exit");

        do {
            System.out.println("Enter a option:");
            resume=menuScan.next().charAt(0);
            System.out.println("\n");
            switch (resume){

                case '1':
                    System.out.println("Balance:" + money);
                    System.out.println("\n\n");
                    showMenu();
                    break;

                case '2':
                    Scanner depositScan = new Scanner(System.in);
                    System.out.println("Enter an amonut to deposit:");
                    int amaount=depositScan.nextInt();
                    addMoney(amaount);
                    System.out.println("\n\n");
                    showMenu();
                    break;

                case '3':
                    Scanner withdrawScan = new Scanner(System.in);
                    System.out.println("Enter an amonut to withdraw:");
                    int amaount2=withdrawScan.nextInt();
                    withdraw(amaount2);
                    System.out.println("\n\n");
                    showMenu();
                    break;

                case '4':
                    getPrevioudTransaction();
                    System.out.println("\n\n");
                    showMenu();
                    break;


                case '5':
                        System.out.println("---------------------------------");
                    break;

                default:
                    System.out.println("Invalid Option!!.Please enter again");
                    break;


            }
        }while(resume!='5');
            System.out.println("Thank you for using our services");
    }
}
