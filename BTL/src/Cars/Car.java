package Cars;

public  class Car {
	public String MA_XE,HANG_XE,TEN_XE,MAU,LOAI_XE;
	public double GIA_XE,GIAM_GIA;
	public int SO_LUONG;
	public String getMA_XE() {
		return MA_XE;
	}
	public void setMA_XE(String mA_XE) {
		MA_XE = mA_XE;
	}
	public String getHANG_XE() {
		return HANG_XE;
	}
	public void setHANG_XE(String hANG_XE) {
		HANG_XE = hANG_XE;
	}
	public String getTEN_XE() {
		return TEN_XE;
	}
	public void setTEN_XE(String tEN_XE) {
		TEN_XE = tEN_XE;
	}
	public String getMAU() {
		return MAU;
	}
	public void setMAU(String mAU) {
		MAU = mAU;
	}
	public String getLOAI_XE() {
		return LOAI_XE;
	}
	public void setLOAI_XE(String lOAI_XE) {
		LOAI_XE = lOAI_XE;
	}
	public double getGIA_XE() {
		return GIA_XE;
	}
	public void setGIA_XE(double gIA_XE) {
		GIA_XE = gIA_XE;
	}
	public double getGIAM_GIA() {
		return GIAM_GIA;
	}
	public void setGIAM_GIA(double gIAM_GIA) {
		GIAM_GIA = gIAM_GIA;
	}
	public int getSO_LUONG() {
		return SO_LUONG;
	}
	public void setSO_LUONG(int sO_LUONG) {
		SO_LUONG = sO_LUONG;
	}
	public Car(String mA_XE, String hANG_XE, String tEN_XE, String mAU, String lOAI_XE, double gIA_XE, double gIAM_GIA,
			int sO_LUONG) {
		super();
		MA_XE = mA_XE;
		HANG_XE = hANG_XE;
		TEN_XE = tEN_XE;
		MAU = mAU;
		LOAI_XE = lOAI_XE;
		GIA_XE = gIA_XE;
		GIAM_GIA = gIAM_GIA;
		SO_LUONG = sO_LUONG;
	}
	public Car() {
		super();
	}
	

}
