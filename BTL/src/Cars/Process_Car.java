package Cars;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Process_Car {
	public static  Connection getCon() {
		Connection cn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost/db_banxe","root","12345678");
			
		}catch (ClassNotFoundException | SQLException e) {}
		return cn;
	}
	public static void main(String[] args) {
		System.out.print(getCon());
	}
	
	public ArrayList<Car> getListCar(){
		Connection cn= getCon() ;
		String sql = "SELECT * FROM tb_sanpham;";
		ArrayList<Car> lscar= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 
			cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Car c= new Car();
			
			c.setMA_XE(rs.getString("Ma_xe"));
			c.setHANG_XE(rs.getString("Hang_xe"));
			c.setTEN_XE(rs.getString("Ten_xe"));
			c. setGIA_XE(rs.getDouble("Gia_xe"));
			c. setGIAM_GIA(rs.getDouble("Giam_gia"));
			c.setLOAI_XE(rs.getString("Phan_loai_xe"));
			c.setMAU(rs.getString("Mau_xe"));
			c.setSO_LUONG(rs.getInt("So_luong_xe"));
			lscar.add (c) ;
			
		}
		}
		catch (SQLException e) {}
		return lscar;
}
	
	public ArrayList<Car> getListCarbyHANG_XE (String Hang_xe){
		Connection cn= getCon() ;
		String sql = "SELECT * FROM tb_sanpham where Hang_xe=?";
		ArrayList<Car> lscar= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 
			cn.prepareStatement(sql);
			ps.setString(1, Hang_xe);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Car c= new Car();
			
			c.setMA_XE(rs.getString("Ma_xe"));
			c.setHANG_XE(rs.getString("Hang_xe"));
			c.setTEN_XE(rs.getString("Ten_xe"));
			c. setGIA_XE(rs.getDouble("Gia_xe"));
			c. setGIAM_GIA(rs.getDouble("Giam_gia"));
			c.setLOAI_XE(rs.getString("Phan_loai_xe"));
			c.setMAU(rs.getString("Mau_xe"));
			c.setSO_LUONG(rs.getInt("So_luong_xe"));
			lscar.add (c) ;
			
		}
		}
		catch (SQLException e) {}
		return lscar;
}
	public ArrayList<Car> getListCarbyPhanLoai (String PhanLoai){
		Connection cn= getCon() ;
		String sql = "SELECT * FROM tb_sanpham where Phan_loai_xe=?";
		ArrayList<Car> lscar= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 
			cn.prepareStatement(sql);
			ps.setString(1, PhanLoai);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Car c= new Car();
			
			c.setMA_XE(rs.getString("Ma_xe"));
			c.setHANG_XE(rs.getString("Hang_xe"));
			c.setTEN_XE(rs.getString("Ten_xe"));
			c. setGIA_XE(rs.getDouble("Gia_xe"));
			c. setGIAM_GIA(rs.getDouble("Giam_gia"));
			c.setLOAI_XE(rs.getString("Phan_loai_xe"));
			c.setMAU(rs.getString("Mau_xe"));
			c.setSO_LUONG(rs.getInt("So_luong_xe"));
			lscar.add (c) ;
			
		}
		}
		catch (SQLException e) {}
		return lscar;
}
	public static boolean Insert_getlistKhoHang (String maxe, String hangxe, String tenxe, String giaxe, String giamgia, String phanloai,String mauxe,String soluong){
		Connection cn=getCon();
		String sql="insert into tb_sanpham (Ma_xe, Hang_xe, Ten_xe , Gia_xe, Giam_gia, Phan_loai_xe, Mau_xe, So_luong_xe) values (?,?,?,?,?,?,?,?);";
		int SOLUONG= Integer.parseInt(soluong);
		double GIAXE=Double.parseDouble(giaxe);
		double GIAMGIA=Double.parseDouble(giamgia);
		
		
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, maxe);
			ps.setString(2, hangxe);
			ps.setString(3, tenxe);
			ps.setDouble(4, GIAXE);
			ps.setDouble(5, GIAMGIA);
			ps.setString(6, phanloai);
			ps.setString(7, mauxe);
			ps.setInt(8, SOLUONG);
			ps.executeUpdate();
			cn.close();
			return true;
			
		}
		catch(SQLException e) {
			return false;
		}
	}
	public static boolean Update_getlistKhoHang (String maxe, String hangxe, String tenxe, String giaxe, String giamgia, String phanloai,String mauxe,String soluong){
		Connection cn=getCon();
		String sql="Update tb_sanpham set Hang_xe=?,Ten_xe=?,Gia_xe=?,Giam_gia=?,Phan_loai_xe=?,Mau_xe=?,So_luong_xe=? where Ma_xe=?";
		int SOLUONG= Integer.parseInt(soluong);
		double GIAXE=Double.parseDouble(giaxe);
		double GIAMGIA=Double.parseDouble(giamgia);
		
		
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			
			ps.setString(1, hangxe);
			ps.setString(2, tenxe);
			ps.setDouble(3, GIAXE);
			ps.setDouble(4, GIAMGIA);
			ps.setString(5, phanloai);
			ps.setString(6, mauxe);
			ps.setInt(7, SOLUONG);
			ps.setString(8, maxe);
			ps.executeUpdate();
			cn.close();
			return true;
			
		}
		catch(SQLException e) {
			return false;
		}
	}
	public static boolean Delete_getlistKhoHang (String maxe){
		Connection cn=getCon();
		String sql="delete from tb_sanpham where Ma_xe=?";		
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			
			ps.setString(1, maxe);
			ps.executeUpdate();
			cn.close();
			return true;
			
		}
		catch(SQLException e) {
			return false;
		}
	}
	////////////////////
	public ArrayList<Car> getShowHANGXE (){
		Connection cn= getCon() ;
		String sql = "SELECT DISTINCT Hang_xe FROM tb_sanpham";
		ArrayList<Car> lscar= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 
			cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Car b= new Car();
			 b.setHANG_XE(rs.getNString("Hang_xe"));
			 lscar.add(b) ;
			
		}
		}
		catch (SQLException e) {}
		return lscar;
}
	public ArrayList<Car> getShowPHANLOAI (){
		Connection cn= getCon() ;
		String sql = "SELECT DISTINCT Phan_loai_xe FROM tb_sanpham";
		ArrayList<Car> lscar= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 
			cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Car b= new Car();
			 b.setLOAI_XE(rs.getNString("Phan_loai_xe"));
			 lscar.add(b) ;
			
		}
		}
		catch (SQLException e) {}
		return lscar;
}
	
	
}
