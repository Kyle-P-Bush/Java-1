import java.util.ArrayList;
import java.util.Scanner;

public class ATM
{
	private ArrayList<Account> accounts;
	private Account loggedInAccount;
	private Scanner input;

	public ATM()
	{
		this.accounts = new ArrayList<Account>();
		this.input = new Scanner(System.in);
	}

	public void displayMainMenu()
	{
		System.out.print("\033[H\033[2J");
		System.out.print("======[Main Menu]======\n");
		System.out.print("1. Make a new Account\n");
		System.out.print("2. Show Accounts\n");
		System.out.print("3. Account Login\n");
		System.out.print("4. Quit\n");
		System.out.print("=======================\n");
	}

	public void addAccount()
	{
		System.out.print("\033[H\033[2J");
		System.out.print("Enter your full name: ");
		String name = input.nextLine();
		System.out.print("Enter a 4 digit PIN: ");
		String pin = input.nextLine();
		Account account = new Account(name, pin);
		accounts.add(account);
		System.out.println();
	}

	public void showAccounts()
	{
		System.out.print("\033[H\033[2J");
		System.out.println("=======[Accounts:]=======");
		if (accounts.size() == 0)
		{
			System.out.println("There are no accounts.");
		}
		else
		{
			for (Account account : this.accounts)
			{
				System.out.printf("ACCOUNT ID: %d: %s\n", account.getID(), account.getName() );
			}
		}
		System.out.println("=========================");
		System.out.println("Press [ENTER] key to return.");
		this.input.nextLine();
	}

	public void login()
	{
		System.out.print("\033[H\033[2J");
        System.out.print("Enter Account ID: ");
        int id = this.input.nextInt();
        this.input.nextLine();
        System.out.print("Enter PIN: ");
        String pin = this.input.nextLine();

        if (0 <= id && id < accounts.size())
        {
        	Account account = accounts.get(id);
            if (account.isPin(pin) )
            {
                this.loggedInAccount = account;
            }
            else
            {
                System.out.println("\n\nInvalid PIN.\n Press [ENTER] key to return.\n");
                this.input.nextLine();
            }
        }
        else
        {
        	System.out.println("\n\nInvalid Account ID.\n Press [ENTER] key to return\n");
        	this.input.nextLine();
        }

	}

	public void mainMenu()
	{
		boolean isDone = false;
		while (isDone == false)
		{
			if (loggedInAccount != null)
				this.userMenu();

			this.displayMainMenu();
			String choice = this.input.nextLine();
			switch(choice)
			{
				case "1": this.addAccount();   break;
				case "2": this.showAccounts(); break;
				case "3": this.login();	       break;
				case "4": isDone = true;
			}
		}
	}

	public void userMenu()
	{
		boolean isDone = false;
		while (isDone == false)
		{
			this.displayUserMenu();
			String choice = this.input.nextLine();
			switch(choice)
			{
				case "1": this.accountDetails();  break;
				case "2": this.accountDeposit();  break;
				case "3": this.accountWithdraw(); break;
				case "4": isDone = true;
			}
		}
		this.loggedInAccount = null;
		//this.mainMenu();
	}

	public void displayUserMenu()
	{
		System.out.print("\033[H\033[2J");
		System.out.printf("Welcome %s,\n", this.loggedInAccount.getName());
		System.out.print("1. Show Details\n");
		System.out.print("2. Deposit\n");
		System.out.print("3. Withdraw\n");
		System.out.print("4. Quit\n");
	}

	public void accountDetails()
	{
		System.out.print("\033[H\033[2J");
		System.out.printf("\n\n%s\n",this.loggedInAccount);
		System.out.println("Press [ENTER] key to return");
		this.input.nextLine();
	}

	public void accountDeposit()
	{
		System.out.print("\033[H\033[2J");
		System.out.print("\n\nEnter depsoit $: ");
		double money = this.input.nextDouble();
		this.input.nextLine();

		this.loggedInAccount.deposit(money);
	}

	public void accountWithdraw()
	{
		System.out.print("\033[H\033[2J");
		System.out.print("\n\nEnter withdraw $: ");
		double money = this.input.nextDouble();
		this.input.nextLine();

		this.loggedInAccount.withdraw(money);
	}

	public static void main(String[] args)
	{
		ATM atm = new ATM();
		atm.mainMenu();

	}


}