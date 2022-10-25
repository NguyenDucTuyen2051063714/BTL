package Cars;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Process_Bill {
	public static  Connection getCon() {
		Connection cn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost/db_banxe","root","12345678");
			
		}catch (ClassNotFoundException | SQLException e) {}
		return cn;
	}
	public ArrayList<Bill> getListBill(){
		Connection cn= getCon() ;
		String sql = "SELECT * FROM tb_hoadon";
		ArrayList<Bill> lssbill= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 
			cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Bill b= new Bill();
			
			b.setMaHD(rs.getNString("MaHD"));
			b.setMa_nv_Bill(rs.getNString("MaNV"));
			b.setMa_kh_Bill(rs.getNString("MaKH"));
			b.setMa_xe_Bill(rs.getNString("Ma_xe"));
			b.setTongTien(rs.getDouble("TongTien"));
			b.setHTThanhToan(rs.getNString("HTThanhToan"));
			b.setNgayLapHD(rs.getNString("NgayLapHD"));
			
			
			
			lssbill.add(b) ;
			
		}
		}
		catch (SQLException e) {}
		return lssbill;
}
	/////////////////
	public ArrayList<Bill> getListBill_MaHD (String mahd){
		Connection cn= getCon() ;
		String sql = "SELECT * FROM tb_hoadon where MaHD=?";
		ArrayList<Bill> lsbill= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 		
			cn.prepareStatement(sql);
			ps.setString(1, mahd);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Bill b= new Bill();
			b.setMaHD(rs.getNString("MaHD"));
			b.setMa_nv_Bill(rs.getNString("MaNV"));
			b.setMa_kh_Bill(rs.getNString("MaKH"));
			b.setMa_xe_Bill(rs.getNString("Ma_xe"));
			b.setTongTien(rs.getDouble("TongTien"));
			b.setHTThanhToan(rs.getNString("HTThanhToan"));
			b.setNgayLapHD(rs.getNString("NgayLapHD"));
			 lsbill.add(b) ;
			
		}
		}
		catch (SQLException e) {}
		return lsbill;
}
	public ArrayList<Bill> getListBill_MaNV (String manv){
		Connection cn= getCon() ;
		String sql = "SELECT * FROM tb_hoadon where MaNV=?";
		ArrayList<Bill> lsbill= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 		
			cn.prepareStatement(sql);
			ps.setString(1, manv);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Bill b= new Bill();
			b.setMaHD(rs.getNString("MaHD"));
			b.setMa_nv_Bill(rs.getNString("MaNV"));
			b.setMa_kh_Bill(rs.getNString("MaKH"));
			b.setMa_xe_Bill(rs.getNString("Ma_xe"));
			b.setTongTien(rs.getDouble("TongTien"));
			b.setHTThanhToan(rs.getNString("HTThanhToan"));
			b.setNgayLapHD(rs.getNString("NgayLapHD"));
			 lsbill.add(b) ;
			
		}
		}
		catch (SQLException e) {}
		return lsbill;
}
	public ArrayList<Bill> getListBill_MaKH (String makh){
		Connection cn= getCon() ;
		String sql = "SELECT * FROM tb_hoadon where MaKH=?";
		ArrayList<Bill> lsbill= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 		
			cn.prepareStatement(sql);
			ps.setString(1, makh);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Bill b= new Bill();
			b.setMaHD(rs.getNString("MaHD"));
			b.setMa_nv_Bill(rs.getNString("MaNV"));
			b.setMa_kh_Bill(rs.getNString("MaKH"));
			b.setMa_xe_Bill(rs.getNString("Ma_xe"));
			b.setTongTien(rs.getDouble("TongTien"));
			b.setHTThanhToan(rs.getNString("HTThanhToan"));
			b.setNgayLapHD(rs.getNString("NgayLapHD"));
			 lsbill.add(b) ;
			
		}
		}
		catch (SQLException e) {}
		return lsbill;
}
	public ArrayList<Bill> getListBill_MaXE (String maxe){
		Connection cn= getCon() ;
		String sql = "SELECT * FROM tb_hoadon where Ma_xe=?";
		ArrayList<Bill> lsbill= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 		
			cn.prepareStatement(sql);
			ps.setString(1, maxe);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Bill b= new Bill();
			b.setMaHD(rs.getNString("MaHD"));
			b.setMa_nv_Bill(rs.getNString("MaNV"));
			b.setMa_kh_Bill(rs.getNString("MaKH"));
			b.setMa_xe_Bill(rs.getNString("Ma_xe"));
			b.setTongTien(rs.getDouble("TongTien"));
			b.setHTThanhToan(rs.getNString("HTThanhToan"));
			b.setNgayLapHD(rs.getNString("NgayLapHD"));
			 lsbill.add(b) ;
			
		}
		}
		catch (SQLException e) {}
		return lsbill;
}
	public ArrayList<Bill> getListBill_HTTT (String httt){
		Connection cn= getCon() ;
		String sql = "SELECT * FROM tb_hoadon where HTThanhToan=?";
		ArrayList<Bill> lsbill= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 		
			cn.prepareStatement(sql);
			ps.setString(1, httt);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Bill b= new Bill();
			b.setMaHD(rs.getNString("MaHD"));
			b.setMa_nv_Bill(rs.getNString("MaNV"));
			b.setMa_kh_Bill(rs.getNString("MaKH"));
			b.setMa_xe_Bill(rs.getNString("Ma_xe"));
			b.setTongTien(rs.getDouble("TongTien"));
			b.setHTThanhToan(rs.getNString("HTThanhToan"));
			b.setNgayLapHD(rs.getNString("NgayLapHD"));
			 lsbill.add(b) ;
			
		}
		}
		catch (SQLException e) {}
		return lsbill;
}
	public ArrayList<Bill> getListBill_NgayLapHD (String ngaylaphd){
		Connection cn= getCon() ;
		String sql = "SELECT * FROM tb_hoadon where NgayLapHD=?";
		ArrayList<Bill> lsbill= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 		
			cn.prepareStatement(sql);
			ps.setString(1, ngaylaphd);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Bill b= new Bill();
			b.setMaHD(rs.getNString("MaHD"));
			b.setMa_nv_Bill(rs.getNString("MaNV"));
			b.setMa_kh_Bill(rs.getNString("MaKH"));
			b.setMa_xe_Bill(rs.getNString("Ma_xe"));
			b.setTongTien(rs.getDouble("TongTien"));
			b.setHTThanhToan(rs.getNString("HTThanhToan"));
			b.setNgayLapHD(rs.getNString("NgayLapHD"));
			 lsbill.add(b) ;
			
		}
		}
		catch (SQLException e) {}
		return lsbill;
}
	
	

	///////////////////tim kiếm bằng
	public ArrayList<Bill> getShowMaHD (){
		Connection cn= getCon() ;
		String sql = "SELECT DISTINCT MaHD FROM tb_hoadon";
		ArrayList<Bill> lsbill= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 
			cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Bill b= new Bill();
			 b.setMaHD(rs.getNString("MaHD"));;
			 lsbill.add(b) ;
			
		}
		}
		catch (SQLException e) {}
		return lsbill;
}
	public ArrayList<Bill> getShowMaNV (){
		Connection cn= getCon() ;
		String sql = "SELECT DISTINCT MaNV FROM tb_hoadon";
		ArrayList<Bill> lsbill= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 
			cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Bill b= new Bill();
			 b.setMaHD(rs.getNString("MaNV"));;
			 lsbill.add(b) ;
			
		}
		}
		catch (SQLException e) {}
		return lsbill;
}
	
	public ArrayList<Bill> getShowMaKH (){
		Connection cn= getCon() ;
		String sql = "SELECT DISTINCT MaKH FROM tb_hoadon";
		ArrayList<Bill> lsbill= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 
			cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Bill b= new Bill();
			 b.setMaHD(rs.getNString("MaKH"));;
			 lsbill.add(b) ;
			
		}
		}
		catch (SQLException e) {}
		return lsbill;
}

	public ArrayList<Bill> getShowMaXE (){
		Connection cn= getCon() ;
		String sql = "SELECT DISTINCT Ma_xe FROM tb_hoadon";
		ArrayList<Bill> lsbill= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 
			cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Bill b= new Bill();
			 b.setMaHD(rs.getNString("Ma_xe"));;
			 lsbill.add(b) ;
			
		}
		}
		catch (SQLException e) {}
		return lsbill;
}
	public ArrayList<Bill> getShowHTTT (){
		Connection cn= getCon() ;
		String sql = "SELECT DISTINCT HTThanhToan FROM tb_hoadon";
		ArrayList<Bill> lsbill= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 
			cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Bill b= new Bill();
			 b.setMaHD(rs.getNString("HTThanhToan"));;
			 lsbill.add(b) ;
			
		}
		}
		catch (SQLException e) {}
		return lsbill;
}
	public ArrayList<Bill> getShowNgayLapHD (){
		Connection cn= getCon() ;
		String sql = "SELECT DISTINCT NgayLapHD FROM tb_hoadon";
		ArrayList<Bill> lsbill= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 
			cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Bill b= new Bill();
			 b.setMaHD(rs.getNString("NgayLapHD"));;
			 lsbill.add(b) ;
			
		}
		}
		catch (SQLException e) {}
		return lsbill;
}
	
	public static boolean Insert_getlistBill (String MaHD,String MaNV,String MaKH,String MaXE,String TongTien,String HTTT,String NgayLap){
		Connection cn=getCon();
		String sql="insert into tb_hoadon (MaHD, MaNV, MaKH, Ma_xe, TongTien, HTThanhToan,NgayLapHD) values (?,?,?,?,?,?,?);";
		
		double tongtien= Double.parseDouble(TongTien);
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, MaHD);
			ps.setString(2, MaNV);
			ps.setString(3, MaKH);
			ps.setString(4, MaXE);
			ps.setDouble(5, tongtien);
			ps.setString(6, HTTT);
			ps.setString(7, NgayLap);
			ps.executeUpdate();
			cn.close();
			return true;
			
		}
		catch(SQLException e) {
			return false;
		}
	}
	public static boolean Del_getlistBill (String mahd){
		Connection cn=getCon();
		String sql="delete from tb_hoadon where MaHD=?";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, mahd);
			ps.executeUpdate();
			cn.close();
			return true;
			
		}
		catch(SQLException e) {
			return false;
		}
	}
}
