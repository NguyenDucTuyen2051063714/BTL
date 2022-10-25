package Cars;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Process_Customer {
	public static  Connection getCon() {
		Connection cn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost/db_banxe","root","12345678");
			
		}catch (ClassNotFoundException | SQLException e) {}
		return cn;
	}
	public ArrayList<Customer> getListCustomer(){
		Connection cn= getCon() ;
		String sql = "SELECT * FROM tb_khachhang";
		ArrayList<Customer> lscustomer= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 
			cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Customer cus= new Customer();
			
			cus.setID(rs.getString("MaKH"));
			cus.setNAME(rs.getString("TenKH"));
			cus.setGIOI_TINH(rs.getString("GioiTinh"));
			cus.setNAM_SINH(rs.getInt("NamSinh"));
			cus.setDIA_CHI(rs.getString("DiaChi"));		
			cus.setSDT(rs.getInt("SDT"));
			lscustomer.add(cus) ;
			
		}
		}
		catch (SQLException e) {}
		return lscustomer;
}
	
	public ArrayList<Customer> getListCustomerbyName (String NAME){
		Connection cn= getCon() ;
		String sql = "SELECT * FROM tb_khachhang where TenKH like?";
		String Name = "%"+NAME+"%";
		ArrayList<Customer> lscustomer= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 
			cn.prepareStatement(sql);
			ps.setString(1, Name);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Customer cus= new Customer();
			
			cus.setID(rs.getString("MaKH"));
			cus.setNAME(rs.getString("TenKH"));
			cus.setGIOI_TINH(rs.getString("GioiTinh"));
			cus.setNAM_SINH(rs.getInt("NamSinh"));
			cus.setDIA_CHI(rs.getString("DiaChi"));		
			cus.setSDT(rs.getInt("SDT"));
			lscustomer.add(cus) ;
			
		}
		}
		catch (SQLException e) {}
		return lscustomer;
}
	public static boolean Insert_getlistCustomer (String makh, String tenkh, String Gioitinh, String namSinh, String Diachi, String sdt){
		Connection cn=getCon();
		String sql="insert into tb_khachhang (MaKH, TenKH, GioiTinh, NamSinh, DiaChi, SDT) values (?,?,?,?,?,?);";
		int NAMSINH= Integer.parseInt(namSinh);
		int SDT= Integer.parseInt(sdt);
		
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, makh);
			ps.setString(2, tenkh);
			ps.setString(3, Gioitinh);
			ps.setInt(4, NAMSINH);
			ps.setString(5, Diachi);
			ps.setInt(6, SDT);
			ps.executeUpdate();
			cn.close();
			return true;
			
		}
		catch(SQLException e) {
			return false;
		}
	}
	public static boolean Del_getlistCustomer (String makh, String tenkh, String Gioitinh, String namSinh, String Diachi, String sdt){
		Connection cn=getCon();
		String sql="delete from tb_khachhang where MaKH=?";
		
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, makh);
			ps.executeUpdate();
			cn.close();
			return true;
			
		}
		catch(SQLException e) {
			return false;
		}
	}
	public ArrayList<Customer> getShowMaKH (){
		Connection cn= getCon() ;
		String sql = "SELECT DISTINCT MaKH FROM tb_khachhang";
		ArrayList<Customer> lsCustomer= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 
			cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Customer c= new Customer();
			 c.setID(rs.getString("MaKH"));;
			 lsCustomer.add(c) ;
			
		}
		}
		catch (SQLException e) {}
		return lsCustomer;
}
	public static boolean Update_getlistCustomer (String makh, String tenkh, String Gioitinh, String namSinh, String Diachi, String sdt){
		Connection cn=getCon();
		String sql="Update tb_khachhang set TenKH=?,GioiTinh=?,NamSinh=?,DiaChi=?,SDT=? where MaKH=?";
		int NAMSINH= Integer.parseInt(namSinh);
		int SDT= Integer.parseInt(sdt);
		
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			
			ps.setString(1, tenkh);
			ps.setString(2, Gioitinh);
			ps.setInt(3, NAMSINH);
			ps.setString(4, Diachi);
			ps.setInt(5, SDT);
			ps.setString(6, makh);
			ps.executeUpdate();
			cn.close();
			return true;
			
		}
		catch(SQLException e) {
			return false;
		}
	}
}
