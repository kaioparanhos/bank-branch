package System;
import System.Utilities.Utils;

public class Account {
    private static int counterAccount = 1; //contador de contas
    private int numberAccount;
    private AddUser user;
    private Double balance = 0.0; //balance = saldo

    public  Account (AddUser user){
        this.numberAccount = counterAccount;
        this.user = user;
        counterAccount += 1;
        //this.balance = balance;
    }
    public int getNumberAccount(){
        return numberAccount;
    }
    public void setNumberAccount(int numberAccount){
        this.numberAccount = numberAccount;
    }
    public AddUser getAddUser(){
        return user;
    }
    public void setAddUser(AddUser user){
        this.user = user;
    }
    public Double getBalance(){
        return balance;
    }
    public void setBalance( Double balance){
        this.balance = balance;
    }
    public  String toString(){
        return "\nAccount Number: "  + this.getNumberAccount() +
                "\nNome: "  + this.user.getNome()+
                "\nCPF: "  + this.user.getCPF()+
                "\nEmail: "  + this.user.getEmail()+
                "\nBalance: "  + Utils.doubleToString(this.getBalance())+
                "\n";
    }
    public void deposit(Double value){
        if (value > 0){
            setBalance(getBalance() + value);
            System.out.println("Sucess!");
        }else {
            System.out.println("Try again.");
        }
    }
    public void withdraw(Double value){ //saque
        if(value > 0 && this.getBalance() >= value){
            setBalance(getBalance() - value);
            System.out.println("Sucess!");
        }else{
            System.out.println("Try again.");
        }
    }
    public void transfer(Account accfordeposit, Double value){
        if(value > 0 && this.getBalance()>=value){
            setBalance(getBalance() - value);
            accfordeposit.balance = accfordeposit.getBalance() + value;
            System.out.println("sucess!!");
        }else {
            System.out.println("try again.");
        }
    }
}

