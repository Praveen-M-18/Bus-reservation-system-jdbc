package busreservation;

import java.security.DrbgParameters.Capability;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.util.Util;

public class BusDAO {
	String url="jdbc:mysql://localhost:3306/busRes";
	String username="root";
	String password="praveen(000)";
	Bookings bk=new Bookings();


	
	
	public void busregister(Busregisterlogin bs) throws SQLException {
		Connection con=DriverManager.getConnection(url,username,password);
		String querReg="insert into busregister values(?,?)";
		PreparedStatement pstr=con.prepareStatement(querReg);
		pstr.setString(1,bs.getname() );
		pstr.setString(2, bs.getpassword());
		int rows=pstr.executeUpdate();
		System.out.println("Rows: "+rows);
	}
	
	public boolean buslogin(String name,String pass) throws SQLException {
		Connection con=DriverManager.getConnection(url,username,password);
		String q="Select * from busregister where name=? and password=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1, name);
		pst.setString(2, pass);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			return true;
		}
		return false;
	}
	
	public void showbus() throws SQLException {
		Connection con=DriverManager.getConnection(url,username,password);
		Statement st=con.createStatement();
		String q="select * from bus";
		ResultSet rs=st.executeQuery(q);
		if (!rs.next()) {
		    System.out.println("No Data exists");
		} else {
		    do {
System.out.println("Bus No:"+rs.getInt(1)+",A/C: "+rs.getBoolean(2)+",Capacity: "+rs.getInt(3));
		    } while (rs.next());
		}

	}
	
	public void insertbus() throws SQLException {
		Connection con=DriverManager.getConnection(url,username,password);
		String que="insert into bus values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(que);
		ps.setInt(1, 1);
		ps.setBoolean(2, true);
		ps.setInt(3, 50);
		ps.addBatch();
		ps.setInt(1, 2);
		ps.setBoolean(2, true);
		ps.setInt(3, 50);
		ps.addBatch();
		ps.setInt(1, 3);
		ps.setBoolean(2, true);
		ps.setInt(3, 3);
		ps.addBatch();
		ps.executeBatch();
	}
	
	public void insertpassengers(Bookings bk) throws SQLException {
		Connection con=DriverManager.getConnection(url,username,password);
		String que="Select count(*) as booked from bookings where busno=? AND bookingdate=?";
		PreparedStatement pst=con.prepareStatement(que);
		pst.setInt(1, bk.getno());
		pst.setDate(2, new java.sql.Date(bk.getdate().getTime()));
		ResultSet rs1=pst.executeQuery();
		rs1.next();
		int booked=rs1.getInt("booked");
		String que3="Select capacity from bus where busno=?";
		PreparedStatement pst3=con.prepareStatement(que3);
		pst3.setInt(1,bk.getno());
		ResultSet rs3=pst3.executeQuery();
		rs3.next();
		int capacity = rs3.getInt("capacity");
		if(booked<capacity) {
			String quer="insert into bookings values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(quer);
			ps.setString(1, bk.getname());
			ps.setInt(2, bk.getno());
			java.sql.Date sqlDate = new java.sql.Date(bk.getdate().getTime());
			ps.setDate(3, sqlDate);
			int rows = ps.executeUpdate();
			System.out.println("Succesfully booked ticket:" + rows);
			
		}
		else {
			System.out.println("---Fully booked---");
			System.out.println("Try booking on other dates");
		}
		
		
		
		
	}

	


	
}
