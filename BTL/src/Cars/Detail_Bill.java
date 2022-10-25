package Cars;

public class Detail_Bill {
	private String ma_hd,ma_xe,ten_xe,mau_xe;
	public String getMa_hd() {
		return ma_hd;
	}
	public void setMa_hd(String ma_hd) {
		this.ma_hd = ma_hd;
	}
	public String getMa_xe() {
		return ma_xe;
	}
	public void setMa_xe(String ma_xe) {
		this.ma_xe = ma_xe;
	}
	public String getTen_xe() {
		return ten_xe;
	}
	public void setTen_xe(String ten_xe) {
		this.ten_xe = ten_xe;
	}
	public String getMau_xe() {
		return mau_xe;
	}
	public void setMau_xe(String mau_xe) {
		this.mau_xe = mau_xe;
	}
	public double getGia_xe() {
		return gia_xe;
	}
	public void setGia_xe(double gia_xe) {
		this.gia_xe = gia_xe;
	}
	public double getGiam_gia() {
		return giam_gia;
	}
	
	public Detail_Bill(String ma_hd, String ma_xe, String ten_xe, String mau_xe, double gia_xe, double giam_gia) {
		super();
		this.ma_hd = ma_hd;
		this.ma_xe = ma_xe;
		this.ten_xe = ten_xe;
		this.mau_xe = mau_xe;
		this.gia_xe = gia_xe;
		this.giam_gia = giam_gia;
	}
	public void setGiam_gia(double giam_gia) {
		this.giam_gia = giam_gia;
	}
	private double gia_xe,giam_gia;
	public Detail_Bill() {
		super();
	}
	
}
