package com.company;
import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String  password;
    private String  department;
    private String email;
    private String  alternateEmail;
    private int mailboxCapacity=300;
    private int defaultPasswordLenght=9;


    public Email(String firstName , String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.department=setDepartment();
        this.password = setPassword(defaultPasswordLenght);
        this.email= setEmail();
    }

    private String setDepartment() {
        int departmentChoice;
        Scanner departmentScanner = new Scanner(System.in);
        System.out.println("DEPARTMENTS");
        System.out.println("[1]-Sales");
        System.out.println("[2]-Development");
        System.out.println("[3]-Accounting");
        System.out.println("[0]-**********");
        System.out.println("Enter a Department :");
        departmentChoice = departmentScanner.nextInt();
        if (departmentChoice == 1) { return "Sales"; }
        else if (departmentChoice == 2) { return "Development";}
        else if (departmentChoice == 3) { return "Accounting";}
        else {return "";}
    }

    private String setPassword(int defaultPasswordLenght){
        String passwordCombination = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!?@&#";
        char [] password = new char[defaultPasswordLenght];
        for(int i = 0; i<defaultPasswordLenght;i++){
            int passChoice = (int) (Math.random()*passwordCombination.length());
            password[i]=passwordCombination.charAt(passChoice);
        }
        return new String(password);
    }

    private String setEmail(){
        String email = firstName.toLowerCase(Locale.ROOT) +"."+lastName.toLowerCase(Locale.ROOT)+"@"+department.toLowerCase(Locale.ROOT)+"."+"company.com";
        return email;
    }

    public void showInfo(){
        System.out.println("Welcome :" + firstName + " " + lastName + "\n");
        System.out.println("Your Department is :"+ department+"\n");
        System.out.println("Your password is :"+ password+"\n");
        System.out.println("Your e-mail is :" + email);
    }

    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity=capacity;
    }
    public int getMailboxCapacity(){return mailboxCapacity;}

    public void setAlternateEmail(String altEmail){
        this.alternateEmail=altEmail;
    }
    public String getAlternateEmail(){return alternateEmail;}

    public void changePassword(String password){
        this.password=password;
    }
    public String getPassword(){return password;}
}
