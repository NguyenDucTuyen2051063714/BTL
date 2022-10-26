package ex1;

public class Sinhvien {
	private String MaSv,TenSv,Gender,ClassSv,Diem;

	public String getMaSv() {
		return MaSv;
	}

	public void setMaSv(String maSv) {
		MaSv = maSv;
	}

	public String getTenSv() {
		return TenSv;
	}

	public void setTenSv(String tenSv) {
		TenSv = tenSv;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getClassSv() {
		return ClassSv;
	}

	public void setClassSv(String classSv) {
		ClassSv = classSv;
	}

	public String getDiem() {
		return Diem;
	}

	public void setDiem(String diem) {
		Diem = diem;
	}

	public Sinhvien(String maSv, String tenSv, String gender, String classSv, String diem) {
		super();
		MaSv = maSv;
		TenSv = tenSv;
		Gender = gender;
		ClassSv = classSv;
		Diem = diem;
	}

	public Sinhvien() {
		super();
	}
	
}
