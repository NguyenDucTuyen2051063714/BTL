package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Process_Sinhvien {
	public static  Connection getCon() {
		Connection cn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost/sinhvien","root","12345678");
			
		}catch (ClassNotFoundException | SQLException e) {}
		return cn;
	}
	public static void main(String[] args) {
		System.out.print(getCon());
	}
	public ArrayList<Sinhvien> getList(){
		Connection cn= getCon() ;
		String sql = "SELECT * FROM sinhvien.tb_sinhvien;";
		ArrayList<Sinhvien> list_sinhvien= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 
			cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Sinhvien c= new Sinhvien();
			
			c.setMaSv(rs.getNString("MaSv"));
			c.setTenSv(rs.getNString("TenSv"));
			c.setGender(rs.getNString("Gender"));
			c.setClassSv(rs.getNString("ClassSv"));
			c.setDiem(rs.getNString("Diem"));
			
			list_sinhvien.add (c) ;
			
		}
		}
		catch (SQLException e) {}
		return list_sinhvien;
}
	public static boolean Insert (String MaSv, String TenSv, String Gender, String ClassSv, String Diem){
		Connection cn=getCon();
		String sql="insert into sinhvien.tb_sinhvien (MaSv, TenSv, Gender , ClassSv, Diem) values (?,?,?,?,?);";	
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, MaSv);
			ps.setString(2, TenSv);
			ps.setString(3, Gender);
			ps.setString(4, ClassSv);
			ps.setString(5, Diem);
			
			ps.executeUpdate();
			cn.close();
			return true;
			
		}
		catch(SQLException e) {
			return false;
		}
	}
	public static boolean Update (String masv, String tensv, String gender, String classsv, String diem){
		Connection cn=getCon();
		String sql="Update sinhvien.tb_sinhvien set TenSv=?,Gender=?,ClassSv=?,Diem=? where MaSv=?";	
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			
			ps.setString(1, tensv);
			ps.setString(2, gender);
			ps.setString(3, classsv);
			ps.setString(4, diem);
			ps.setString(5, masv);
			ps.executeUpdate();
			cn.close();
			return true;
			
		}
		catch(SQLException e) {
			return false;
		}
	}
	public static boolean Delete (String masv){
		Connection cn=getCon();
		String sql="delete from sinhvien.tb_sinhvien where MaSv=?;";		
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			
			ps.setString(1, masv);
			ps.executeUpdate();
			cn.close();
			return true;
			
		}
		catch(SQLException e) {
			return false;
		}
	}
}
