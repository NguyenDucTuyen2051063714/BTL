package Cars;


public class Person {
	public String ID,NAME;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public Person(String iD, String nAME) {
		super();
		ID = iD;
		NAME = nAME;
	}

	public Person() {
		super();
	}
	
	
}
