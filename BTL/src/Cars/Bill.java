package Cars;

public class Bill {
	public String MaHD,HTThanhToan,HTMuaXe,NgayLapHD,Ma_xe_Bill,Ma_kh_Bill,Ma_nv_Bill;
	public double TongTien,ThanhToan,TienThua;
	public String getMaHD() {
		return MaHD;
	}
	public void setMaHD(String maHD) {
		MaHD = maHD;
	}
	public String getHTThanhToan() {
		return HTThanhToan;
	}
	public void setHTThanhToan(String hTThanhToan) {
		HTThanhToan = hTThanhToan;
	}
	public String getHTMuaXe() {
		return HTMuaXe;
	}
	public void setHTMuaXe(String hTMuaXe) {
		HTMuaXe = hTMuaXe;
	}
	public String getNgayLapHD() {
		return NgayLapHD;
	}
	public void setNgayLapHD(String ngayLapHD) {
		NgayLapHD = ngayLapHD;
	}
	public String getMa_xe_Bill() {
		return Ma_xe_Bill;
	}
	public void setMa_xe_Bill(String ma_xe_Bill) {
		Ma_xe_Bill = ma_xe_Bill;
	}
	public String getMa_kh_Bill() {
		return Ma_kh_Bill;
	}
	public void setMa_kh_Bill(String ma_kh_Bill) {
		Ma_kh_Bill = ma_kh_Bill;
	}
	public String getMa_nv_Bill() {
		return Ma_nv_Bill;
	}
	public void setMa_nv_Bill(String ma_nv_Bill) {
		Ma_nv_Bill = ma_nv_Bill;
	}
	public double getTongTien() {
		return TongTien;
	}
	public void setTongTien(double tongTien) {
		TongTien = tongTien;
	}
	public double getThanhToan() {
		return ThanhToan;
	}
	public void setThanhToan(double thanhToan) {
		ThanhToan = thanhToan;
	}
	public double getTienThua() {
		return TienThua;
	}
	public void setTienThua(double tienThua) {
		TienThua = tienThua;
	}
	public Bill(String maHD, String hTThanhToan, String hTMuaXe, String ngayLapHD, String ma_xe_Bill, String ma_kh_Bill,
			String ma_nv_Bill, double tongTien, double thanhToan, double tienThua) {
		super();
		MaHD = maHD;
		HTThanhToan = hTThanhToan;
		HTMuaXe = hTMuaXe;
		NgayLapHD = ngayLapHD;
		Ma_xe_Bill = ma_xe_Bill;
		Ma_kh_Bill = ma_kh_Bill;
		Ma_nv_Bill = ma_nv_Bill;
		TongTien = tongTien;
		ThanhToan = thanhToan;
		TienThua = tienThua;
	}
	public Bill() {
		super();
	}

	

	
	
}
