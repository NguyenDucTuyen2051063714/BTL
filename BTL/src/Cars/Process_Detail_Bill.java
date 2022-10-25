package Cars;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Process_Detail_Bill {
	public static  Connection getCon() {
		Connection cn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost/db_banxe","root","12345678");
			
		}catch (ClassNotFoundException | SQLException e) {}
		return cn;
	}
	public ArrayList<Detail_Bill> getListBill_ChiTietHD (String mahd){
		Connection cn= getCon() ;
		String sql = "SELECT tb_chitiet_hoadon.MaHD,tb_chitiet_hoadon.Ma_xe,tb_chitiet_hoadon.Ten_xe,"
				+ "tb_chitiet_hoadon.Mau_xe,tb_chitiet_hoadon.Gia_xe,tb_chitiet_hoadon.Giam_gia FROM tb_chitiet_hoadon,"
				+ "tb_hoadon where tb_chitiet_hoadon.MaHD=?";
		String Mahd=mahd;
		ArrayList<Detail_Bill> lsDetail_Bill= new ArrayList<>();
		try {
			PreparedStatement ps =(PreparedStatement) 		
			cn.prepareStatement(sql);
			
			ps.setString(1, Mahd);
			ResultSet rs = ps.executeQuery () ;
		while (rs.next()) {
			Detail_Bill b= new Detail_Bill();
			b.setMa_hd(rs.getNString("MaHD"));
			b.setMa_xe(rs.getNString("Ma_xe"));
			b.setTen_xe(rs.getNString("Ten_xe"));
			b.setMau_xe(rs.getNString("Mau_xe"));
			b.setGia_xe(rs.getDouble("Gia_xe"));
			b.setGiam_gia(rs.getDouble("Giam_gia"));
			
			 lsDetail_Bill.add(b) ;
			
		}
		}
		catch (SQLException e) {}
		return lsDetail_Bill;
}
	public static boolean Insert_getlistDetail_Bill (String mahd, String maxe, String tenxe, String mauxe, String giaxe, String giamgia){
		Connection cn=getCon();
		String sql="insert into tb_chitiet_hoadon (MaHD, Ma_xe, Ten_xe, Mau_xe, Gia_xe, Giam_gia) values (?,?,?,?,?,?);";
		double GIAXE= Double.parseDouble(giaxe);
		double GIAMGIA= Double.parseDouble(giamgia);
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, mahd);
			ps.setString(2, maxe);
			ps.setString(3, tenxe);
			ps.setString(4, mauxe);
			ps.setDouble(5, GIAXE);
			ps.setDouble(6, GIAMGIA);

			ps.executeUpdate();
			cn.close();
			return true;
			
		}
		catch(SQLException e) {
			return false;
		}
	}
}
