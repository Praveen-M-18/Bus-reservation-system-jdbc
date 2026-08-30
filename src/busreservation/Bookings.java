package busreservation;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Bookings {

	private String passengername;
	private int busno;
	private Date date;
	Scanner sc = new Scanner(System.in);

	
	
	
	public void book() {
		System.out.println("Enter the Passenger name:");
		passengername = sc.nextLine();
		System.out.println("Enter the BusNumber:");
		busno = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the date(dd-mm-yyyy):");
		String Dat = sc.nextLine();
		DateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			date = dateformat.parse(Dat);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	
	
	
	public String getname() {
		return passengername;
	}
	public void setname(String name) {
		this.passengername=name;
	}
	
	public int getno() {
		return busno;
	}
	public void setno(int no) {
		this.busno=no;
	}
	
	public Date getdate() {
		return date;
	}
	public void setdate(Date date) {
		this.date=date;
	}
//	public boolean isAvailable() {
//		int booked = 0;
//		int capacity = 0;
//		
//		
//
//	}

}
