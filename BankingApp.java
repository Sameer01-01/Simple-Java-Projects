import java.util.Scanner;
public class BankingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        bankaccount bank1 = new bankaccount("xyz","01");
        bank1.showmenu();
    } 
}

class bankaccount {
    int balance, previousTransaction;
    String customername,customerid;

    bankaccount(String cname, String cid){
        customername=cname;
        customerid=cid;
    }

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
        else{
            System.out.println("No transaction occured.");
        }
    }

    void showmenu(){
        char option = '\0';
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + customername);
        System.out.println("Your ID is :- "+ customerid);
        System.out.println();
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit ");
        System.out.println("C. Withdraw ");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit ");

        do{
            System.out.println("Enter the Option ");
            option =sc.next().charAt(0);
            Character.toUpperCase(option);
            switch (option) {
                case 'A':
                System.out.println("Balance is :- "+balance);
                    
                    break;
                case 'B':
                System.out.println("Enter the amount to Deposit :- ");
                int amount = sc.nextInt();
                deposit(amount);
                System.out.println();
                break;

                case 'C':
                System.out.println("Enter the amount to Withdraw");
                int amount2 = sc.nextInt();
                withdraw(amount2);
                System.out.println();
                break;

                case 'D':
                getpreviousTransaction();
                System.out.println();
                break;

                case 'E':
                System.out.println("Thank You!!");
                break;


            
                default:
                System.out.println("Invalid Option! Please try again.");
                    break;
            }
        }while(option != 'E');
    }
}