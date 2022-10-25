package Cars;

public class Staff extends Person{
	private String GIOI_TINH,DIA_CHI,VI_TRI;
	private int NAM_SINH,SDT;
	private double LUONG;
	public String getGIOI_TINH() {
		return GIOI_TINH;
	}
	public void setGIOI_TINH(String gIOI_TINH) {
		GIOI_TINH = gIOI_TINH;
	}
	public String getDIA_CHI() {
		return DIA_CHI;
	}
	public void setDIA_CHI(String dIA_CHI) {
		DIA_CHI = dIA_CHI;
	}
	public String getVI_TRI() {
		return VI_TRI;
	}
	public void setVI_TRI(String vI_TRI) {
		VI_TRI = vI_TRI;
	}
	public int getNAM_SINH() {
		return NAM_SINH;
	}
	public void setNAM_SINH(int nAM_SINH) {
		NAM_SINH = nAM_SINH;
	}
	public int getSDT() {
		return SDT;
	}
	public void setSDT(int sDT) {
		SDT = sDT;
	}
	public double getLUONG() {
		return LUONG;
	}
	public void setLUONG(double lUONG) {
		LUONG = lUONG;
	}
	public Staff(String iD, String nAME, String gIOI_TINH, String dIA_CHI, String vI_TRI, int nAM_SINH, int sDT,
			double lUONG) {
		super(iD, nAME);
		GIOI_TINH = gIOI_TINH;
		DIA_CHI = dIA_CHI;
		VI_TRI = vI_TRI;
		NAM_SINH = nAM_SINH;
		SDT = sDT;
		LUONG = lUONG;
	}
	public Staff(String iD, String nAME) {
		super(iD, nAME);
	}
	public Staff() {
		super();
	}
	
}
