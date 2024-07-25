import java.util.Scanner;
public class BankingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    } 
}

class bankaccount {
    int balance, previousTransaction;

    void deposit(int amount){
        if (amount !=0){
            balance =balance+amount;
            previousTransaction =amount;
        }
    }

    void withdraw(int amount){
        if (amount != 0){
            balance = balance-amount;
            previousTransaction= -amount;
        }
    }
    
    void getpreviousTransaction(){
        if(previousTransaction>0){
            System.out.println("Deposited :- "+ previousTransaction);
        }
        else if(previousTransaction<0){

            System.out.println("Withdrawn :- "+Math.abs(previousTransaction));
        }
    }
}