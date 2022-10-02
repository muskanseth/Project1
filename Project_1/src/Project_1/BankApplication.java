package Project_1;
//Operation to perform 
//Transfer amount, View Balance, Deposit Amount, Withdraw Amount.

import java.util.Scanner;

class IDFC {  //Creating Class "Idfc" with 1.Fields and 2.Methods. 

	//1.Fields
	private String account_no;  // These are fields that is account_no , name_of_customer etc
	private String name_of_customer; //The private access modifier is accessible only within the class.  
	private String type_of_account;  
	private int balance;
	int amount;
	int transfer;
	
	//2.Methods
  @SuppressWarnings("resource")
	public void account_open() { //First we must have an account to perform various operation
  	
  	//Using scanner class for getting value from the user
      Scanner sc = new Scanner(System.in); 
      System.out.print("Enter Account Number of the customer:");  
      account_no=sc.nextLine();
      
      System.out.print("Enter type of account you want to open:");
      System.out.print(" 1.Salary Account "+" 2.Savings Account "+" 3.Current Account ");
      type_of_account=sc.nextLine();
      
      System.out.print("Enter Name of customer:");  
      name_of_customer=sc.nextLine();
      
      System.out.print("Enter Balance:");  
      balance=sc.nextInt();  
  }  
  
  public void display_account(){   //method to display account details of the customer  
  	System.out.println("Name of account holder:"+ name_of_customer);  
      System.out.println("Account no.: "+account_no);  
      System.out.println("Account type: "+type_of_account);  
      System.out.println("Balance: "+balance);  
  }
  
  public void view_balance() { 
 	System.out.println(balance);
  }
  
  @SuppressWarnings("resource")
	public void deposit(){
  	Scanner sc = new Scanner(System.in);
      System.out.println("Enter the amount you want to deposit: ");  
      amount=sc.nextInt();  
      balance=balance+amount;  
  }
  
  
  @SuppressWarnings("resource")
	public void withdrawal() {  
  	Scanner sc = new Scanner(System.in);  
      System.out.println("Enter the amount you want to withdraw: ");  
      amount=sc.nextInt();  
      if (balance >=amount) {  
          balance = balance-amount;  
          System.out.println("Balance after withdrawal: "+balance);  
      }
      else {
      	System.out.println("Your balance is less than "+amount);
      }
  }
  
  @SuppressWarnings("resource")
	public void transfer() {
  	Scanner sc = new Scanner(System.in);  
      System.out.println("Enter the amount you want to transfer: ");  
      transfer=sc.nextInt();  
      if (balance>=transfer) {  
          balance=balance-transfer;
          System.out.println("Transfer Successful amounting"+ transfer); 
          System.out.println("Balance after withdrawal:"+balance);  
      }
      else {
      	System.out.println("Your balance is less than "+amount);
      }
  	
  }
      
      
  public boolean search(String ac_no) {  
      if (account_no.equals(ac_no)) {  
          display_account();  
          return (true);  
      }  
      return (false);  
  } 
    
}
public class BankApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);  
        //Creating Account  
        System.out.print("How many number of customers do you want to input? ");  
        int n = sc.nextInt();  
        IDFC C[]=new IDFC[n]; 
        
        for(int i=0; i<C.length; i++) {  
            C[i] = new IDFC ();  
            C[i].account_open();  
        }  
     // loop runs until number 5 is not pressed to exit  
        int ch;  
        do {  
            System.out.println("\n ***Banking System Application***");  
            System.out.println("1. Display all account details \n 2. View Balance\n 3. Search\n 4. Deposit the amount \n 5. Withdraw the amount \n 6. Transfer the amount \n 7.Exit ");  
            System.out.println("Enter your choice: ");  
            ch = sc.nextInt();  
                switch (ch) {  
                    case 1:  
                        for (int i=0;i<C.length;i++) {  
                            C[i].display_account();  
                        }  
                        break;  
                    case 2:  
                        System.out.print("View Balance: ");  
                        for (int i=0;i<C.length;i++) {  
                            C[i].view_balance();  
                        } 
                        break;
                    case 3:
                    	System.out.print("Enter account no. you want to search: ");  
                        String ac_no = sc.next();  
                        boolean found = false;  
                        for (int i = 0; i < C.length; i++) {  
                            found = C[i].search(ac_no);  
                            if (found) {  
                                break;  
                            }  
                        }  
                        if (!found) {  
                            System.out.println("Search failed! Account doesn't exist..!!");  
                        }  
                        break;
                    case 4:  
                        System.out.print("Enter Account no. : ");  
                        ac_no = sc.next();  
                        found = false;  
                        for (int i = 0; i < C.length; i++) {  
                            found = C[i].search(ac_no);  
                            if (found) {  
                                C[i].deposit();  
                                break;
                            }  
                        }  
                        if (!found) {  
                            System.out.println("Search failed! Account doesn't exist..!!");  
                        }
                    case 5:
                    	System.out.print("Enter Account No : ");  
                        ac_no = sc.next();  
                        found = false;  
                        for (int i = 0; i < C.length; i++) {  
                            found = C[i].search(ac_no);  
                            if (found) {  
                                C[i].withdrawal();  
                                break;  
                            }  
                        }  
                        if (!found) {  
                            System.out.println("Search failed! Account doesn't exist..!!");  
                        }  
                        break;
                    case 6:
                    	System.out.print("Enter Account No : ");  
                        ac_no = sc.next();  
                        found = false;  
                        for (int i = 0; i < C.length; i++) {  
                            found = C[i].search(ac_no);  
                            if (found) {  
                                C[i].transfer();  
                                break;  
                               }  
                        }  
                        if (!found) {  
                            System.out.println("Search failed! Account doesn't exist..!!");  
                        }  
                        break;
                        
                    case 7:
                    	System.out.println("exit");  
                        break;
                 		}  
                }while (ch != 7);

	}

}
