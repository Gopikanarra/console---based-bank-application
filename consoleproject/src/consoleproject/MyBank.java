package consoleproject;

import java.util.Scanner;

public class MyBank {
	static Scanner sc=new Scanner(System.in);
	static int option=0,type=0,accno=0;
	static double amount=0;
	static String name=null;
	static char ch='\0';
	static int lastAccountNumber = 10000;
	
	public static void main(String[] args) {
		
		Current.initializeAccounts();
	    Fixed.initializeAccounts();
	    Savings.initializeAccounts();
	    
		System.out.println("HELLO WELCOME TO \"OURBANK\"");
		
		int loop=1;
		while(loop==1) {
		System.out.println("A:Create New Account");
		System.out.println("B : Check Your Balance");
		System.out.println("C : Deposit");
		System.out.println("D : Withdraw");
		System.out.println("E : Exit The System");
		
		
		
		ch=sc.next().charAt(0);
		 Account myaccount=null;
		switch(ch) {
		case 'A':
		    System.out.println("1. Current \n2. Fixed \n3. Savings\nEnter the type of account you want:");
		    type = sc.nextInt();
		    System.out.println("Enter the name:");
		    name = sc.next();
		    System.out.println("Enter the initial deposit:");
		    amount = sc.nextDouble();
		    
		   
		    int newAccountNumber = ++lastAccountNumber;
		    
		    if (type == 1) {
		        Current c = new Current(name, newAccountNumber, amount);
		        c.createAccount(name, newAccountNumber, amount);
		        System.out.println("Your new account number is: " + formatAccountNumber(newAccountNumber));
		    } else if (type == 2) {
		        Fixed c = new Fixed(name, newAccountNumber, amount);
		        c.createAccount(name, newAccountNumber, amount);
		        System.out.println("Your new account number is: " + formatAccountNumber(newAccountNumber));
		    } else if (type == 3) {
		        Savings c = new Savings(name, newAccountNumber, amount);
		        c.createAccount(name, newAccountNumber, amount);
		        System.out.println("Your new account number is: " + formatAccountNumber(newAccountNumber));
		    } else {
		        System.out.println("Please select a valid account type.");
		    }
		    break;

		
		case 'B':
		    System.out.println("Enter your account number:");
		    accno = sc.nextInt();
		    System.out.println("Enter the account type (1. Current, 2. Fixed, 3. Savings):");
		    type = sc.nextInt();

		    Account foundAccount = findAccount(accno, type);

		    if (foundAccount != null) {
		        System.out.println("Welcome " + foundAccount.name);
		        System.out.println("Your ID is " + accno);
		        foundAccount.checkbalance();
		    } else {
		        System.out.println("Account not found.");
		    }
		    break;

				 
		case 'C':
			System.out.println("Enter your account number:");
		    accno = sc.nextInt();
		    System.out.println("Enter the account type (1. Current, 2. Fixed, 3. Savings):");
		    type = sc.nextInt();
			System.out.println("enter the amount to deposit:");
			amount = sc.nextInt();
			Account foundAccount1 = findAccount(accno, type);
			if(foundAccount1!=null) {
				System.out.println("welcome "+foundAccount1.name);
				System.out.println("Your ID is: "+accno);
				foundAccount1.deposit(amount);
			}
			
		    	break;
		    	
		case 'D':
			System.out.println("enter the account number:");
			accno=sc.nextInt();
			System.out.println("Enter the account type(1.Current, 2.Fixed,3.Savings):");
			type=sc.nextInt();
			System.out.println("Enter the ammount to withdraw:");
			amount=sc.nextInt();
			Account foundAccount2=findAccount(accno,type);
			if(foundAccount2!=null) {
				System.out.println("Welcome "+foundAccount2.name);
				System.out.println("Your ID is: "+accno);
				foundAccount2.withdraw(amount);
			}
			break;
			
		case 'E':System.out.println("you are exiting from system!!!");
				loop=0;
				System.exit(1);
		default:System.out.println("please enter the valid option!!");

		}
		
	}

	
}
	
	
	public static Account findAccount(int accno,int type) {
		switch(type) {
		case 1:
			for(Current c:Current.al) {
				if(c.accno==accno) {
					return c;
				}
			}
			break;
		case 2:
			for(Fixed f:Fixed.al) {
				if(f.accno==accno) {
					return f;
				}
			}
			break;
		case 3:
			for(Savings s:Savings.al) {
				if(s.accno==accno) {
					return s;
				}
			}
			break;
		}
		return null;
	}	
	
	private static String formatAccountNumber(int accountNumber) {
	    return String.format("%05d", accountNumber);
	}

}
