package busreservation;

import java.sql.SQLException;
import java.util.Scanner;



public class BusMain {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		BusDAO dao=new BusDAO();
		Bookings bs=new Bookings();
		Busregisterlogin brl=new Busregisterlogin();
		int register=1;
		
		while(register==1) {
		System.out.println("---Welcome to Bus Reservation Application");
		System.out.println("------1-To-ReGISTER-OR-2-To LOGiN--------");
		System.out.println("Enter Number: ");
		int nochoice=sc.nextInt();
		sc.nextLine();
		if(nochoice==1) 
		register=brl.registerdetails();
		else if(nochoice==2) 
			register=brl.logindetails();
		
		}
		boolean userinput=true;
		while(userinput) {
			
			
			System.out.println("---Welcome to Bus Reservation Application");
			System.out.println("1. Show Available buses");
			System.out.println("2. Book Bus");
			System.out.println("3. Exit");
			System.out.println("Enter a option to Initiate: ");
			int choice=sc.nextInt();
			
			switch(choice) {
				case 1:
					dao.showbus();
					break;
				case 2:
					bs.book();
					dao.insertpassengers(bs);
					break;
				case 3:
					System.out.println("Thanks for using this application");
					userinput=false;
					
					break;
			
			}
			
			


		}
	}

}
