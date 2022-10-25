package Cars;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Process_Staff {
	public static  Connection getCon() {
		Connection cn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost/db_banxe","root","12345678");
			
		}catch (ClassNotFoundException | SQLException e) {}
		return cn;
	}
	
	
	public ArrayList<Staff> getListStaff(){
		Connection cn= getCon() ;
		String sql = "SELECT * FROM tb_nv;";
		ArrayList<Staff> lsstaff= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 
			cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Staff st= new Staff();
			
			st.setID(rs.getString("MaNV"));
			st.setNAME(rs.getString("TenNV"));
			st.setGIOI_TINH(rs.getString("GioiTinh"));
			st.setNAM_SINH(rs.getInt("NamSinh"));
			st.setDIA_CHI(rs.getString("DiaChi"));
			
			st.setSDT(rs.getInt("SDT"));
			st.setLUONG(rs.getDouble("Luong"));
			st.setVI_TRI(rs.getString("Vitri"));
			
			lsstaff.add(st) ;
			
		}
		}
		catch (SQLException e) {}
		return lsstaff;
}
	
	public ArrayList<Staff> getListStaffbyNAME (String NAME){
		Connection cn= getCon() ;
		String sql = "SELECT * FROM tb_nv where TenNV like?";
		String Name = "%"+NAME+"%";
		ArrayList<Staff> lsstaff= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 
			cn.prepareStatement(sql);
			ps.setString(1, Name);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Staff st= new Staff();
			
			st.setID(rs.getString("MaNV"));
			st.setNAME(rs.getString("TenNV"));
			st.setGIOI_TINH(rs.getString("GioiTinh"));
			st.setNAM_SINH(rs.getInt("NamSinh"));
			st.setDIA_CHI(rs.getString("DiaChi"));		
			st.setSDT(rs.getInt("SDT"));
			st.setLUONG(rs.getDouble("Luong"));
			st.setVI_TRI(rs.getString("Vitri"));
			
			lsstaff.add(st) ;
			
		}
		}
		catch (SQLException e) {}
		return lsstaff;
}
	public ArrayList<Staff> getShowMaNV (){
		Connection cn= getCon() ;
		String sql = "SELECT DISTINCT MaNV FROM tb_nv";
		ArrayList<Staff> lsstaff= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 
			cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Staff st= new Staff();
			 st.setID(rs.getString("MaNV"));;
			 lsstaff.add(st) ;
			
		}
		}
		catch (SQLException e) {}
		return lsstaff;
}
	public static boolean Insert_getlistStaff (String manv, String tennv, String Gioitinh, String namSinh, String Diachi, String sdt,String luong, String Vitri){
		Connection cn=getCon();
		String sql="insert into tb_nv (MaNV, TenNV, GioiTinh, NamSinh, DiaChi, SDT, Luong, Vitri) values (?,?,?,?,?,?,?,?);";
		int NAMSINH= Integer.parseInt(namSinh);
		int SDT= Integer.parseInt(sdt);
		double LUONG= Double.parseDouble(luong);
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, manv);
			ps.setString(2, tennv);
			ps.setString(3, Gioitinh);
			ps.setInt(4, NAMSINH);
			ps.setString(5, Diachi);
			ps.setInt(6, SDT);
			ps.setDouble(7, LUONG);
			ps.setString(8, Vitri);
			ps.executeUpdate();
			cn.close();
			return true;
			
		}
		catch(SQLException e) {
			return false;
		}
	}
	public static boolean Del_getlistStaff (String manv){
		Connection cn=getCon();
		String sql="delete from tb_nv where MaNV=?";
		
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, manv);
			ps.executeUpdate();
			cn.close();
			return true;
			
		}
		catch(SQLException e) {
			return false;
		}
	}
	public static boolean Update_getlistStaff (String manv, String tennv, String Gioitinh, String namSinh, String Diachi, String sdt,String luong, String Vitri){
		Connection cn=getCon();
		String sql="Update tb_nv set TenNV=?,GioiTinh=?,NamSinh=?,DiaChi=?,SDT=?,Luong=?,Vitri=? where MaNV=?";
		int NAMSINH= Integer.parseInt(namSinh);
		int SDT= Integer.parseInt(sdt);
		double LUONG= Double.parseDouble(luong);
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			
			ps.setString(1, tennv);
			ps.setString(2, Gioitinh);
			ps.setInt(3, NAMSINH);
			ps.setString(4, Diachi);
			ps.setInt(5, SDT);
			ps.setDouble(6, LUONG);
			ps.setString(7, Vitri);
			ps.setString(8, manv);
			ps.executeUpdate();
			cn.close();
			return true;
			
		}
		catch(SQLException e) {
			return false;
		}
	}
}


