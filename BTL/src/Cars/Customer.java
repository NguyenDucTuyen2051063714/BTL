package Cars;

public class Customer extends Person{
	private String GIOI_TINH,DIA_CHI;
	private int NAM_SINH,SDT;
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
	public Customer(String iD, String nAME, String gIOI_TINH, String dIA_CHI, int nAM_SINH, int sDT) {
		super(iD, nAME);
		GIOI_TINH = gIOI_TINH;
		DIA_CHI = dIA_CHI;
		NAM_SINH = nAM_SINH;
		SDT = sDT;
	}
	public Customer(String iD, String nAME) {
		super(iD, nAME);
	}
	public Customer() {
		super();
	}
	
	
}
