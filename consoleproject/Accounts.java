package consoleproject;

import java.util.ArrayList;


abstract class Account{
	String name;
	int accno;
	double balance;
	abstract void checkbalance();
	abstract void deposit(double amount);
	abstract void withdraw(double amount);
	protected abstract void listAll();
}
class Current extends Account
{
	static ArrayList<Current> al=new ArrayList<Current>();
	
	Current(String name, int accno, double balance) {
		this.name=name;
		this.accno=accno;
		this.balance=balance;
	}
	static void createAccount(String name, int accno, double balance) {
       Current account = new Current(name, accno, balance);
        al.add(account);
        
    }
	 static void initializeAccounts() {
	       
		 al.add(new Current("john",23333,54221));
		 al.add(new Current("tom",74854,45362));
		 al.add(new Current("ibraham",34552,45121));
	    }
	protected void checkbalance() {
		System.out.println("welcome:"+name);
		System.out.println("ur account type is:Current");
		System.out.println("the total balance in ur account is:"+balance);
		
	}
	protected void deposit(double amount) {
		balance=balance+amount;
		
	}
	protected void withdraw(double amount) {
		balance=balance-amount;
	}
	
	protected void listAll() {
		for(Current c:al) 
			System.out.println("name:"+c.name+"accno:"+c.accno+"balance:"+c.balance);
	}
		
	
}


class Fixed extends Account
{
	static ArrayList<Fixed> al=new ArrayList<Fixed>();
	
	Fixed(String name, int accno, double balance){
		this.name=name;
		this.accno=accno;
		this.balance=balance;
	}
	static void createAccount(String name, int accno, double balance) {
        Fixed account = new Fixed(name, accno, balance);
        al.add(account);
        
    }
	 static void initializeAccounts() {
	        al.add(new Fixed("sam", 76333, 37229));
	        al.add(new Fixed("ram", 1214, 45122));
	        al.add(new Fixed("joice", 31292, 88121));
	    }
	
	@Override
	void checkbalance() {
		System.out.println("welcome:"+name);
		System.out.println("ur account type is: Fixed");
		double interest=balance*0.06;
		System.out.println("the interest is:"+interest);
		double total=interest+balance;
		System.out.println("the total balance in ur account is:"+total);
		
	}

	@Override
	void deposit(double amount) {
		balance=balance+amount;
		
	}

	@Override
	void withdraw(double amount) {
		balance=balance-amount;
		
	}
	protected void listAll() {
		for(Fixed f:al) 
			System.out.println("name:"+f.name+"accno:"+f.accno+"balance:"+f.balance);
		
	}
	
}



class Savings extends Account
{
	static ArrayList<Savings> al=new ArrayList<Savings>();
	Savings(String name, int accno, double balance){
		this.name=name;
		this.accno=accno;
		this.balance=balance;
		
	}
	static  void createAccount(String name, int accno, double balance) {
        Savings account = new Savings(name, accno, balance);
        al.add(account);
       
    }
	 static void initializeAccounts() {
	        al.add(new Savings("charlie", 67483, 23866));
	        al.add(new Savings("sai", 348922, 67493));
	        al.add(new Savings("candella", 22192, 86321));
	    }
	@Override
	void checkbalance() {
		System.out.println("welcome:"+name);
		System.out.println("ur account type is: Fixed");
		double interest=balance*0.02;
		System.out.println("the interest is:"+interest);
		double total=interest+balance;
		System.out.println("the total balance in ur account is:"+total);
		
		
	}

	@Override
	protected void deposit(double amount) {
		balance=balance+amount;
		
	}

	@Override
	protected void withdraw(double amount) {
		balance=balance-amount;
		
	}
	
	protected void listAll() {
		for(Savings s:al) 
			System.out.println("name:"+s.name+"accno:"+s.accno+"balance:"+s.balance);
	}
	
	
	
}

