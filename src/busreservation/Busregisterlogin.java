package busreservation;

import java.sql.SQLException;
import java.util.Scanner;

public class Busregisterlogin {
	String name;
	String password;
	Scanner sc=new Scanner(System.in);
	BusDAO bdo=new BusDAO();
	public Busregisterlogin() {
		// TODO Auto-generated constructor stub
	}
	
	Busregisterlogin(String n,String pass){
		this.name=n;
		this.password=pass;
		
	}
	
	public int registerdetails() throws SQLException {
	System.out.println("Enter Name: ");
	String name=sc.nextLine();
	System.out.println("Enter password: ");
	String password=sc.nextLine();
	System.out.println("Re-Enter to Confirm password: ");
	String cpassword=sc.nextLine();
	if(password.equals(cpassword)) {
		Busregisterlogin brl=new Busregisterlogin(name,password);
		bdo.busregister(brl);
		return 0;
	}else {
		System.out.println("Password does not match");
		return 1;
	}
		
	}
	public int logindetails() throws SQLException {
		System.out.println("Enter name: ");
		String name=sc.nextLine();
		System.out.println("Enter password: ");
		String pass=sc.nextLine();
		boolean login=bdo.buslogin(name,pass);
		if(login) {
			return 0;
		}
		else {
			System.out.println("Wrong Username or password! Try again");
			return 1;
		}
		
	}
	
	
	
	public void setname(String name) {
		this.name=name;
	}
	public String getname() {
		return name;
	}
	
	public void setpassword(String password) {
		this.password=password;
	}

	public String getpassword() {
		return password;
	}
}
