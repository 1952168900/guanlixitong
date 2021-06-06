package MODEL;

public class Cus {
	private static Cus cus=new Cus();
    private Cus(){}
    public static Cus getInstance(){
        return cus;
    }
	
	private String CID;
	private String PAS;
	private String CNAME;
	private String CINF;
	public String getCID() {
		return CID;
	}
	public void setCID(String cID) {
		CID = cID;
	}
	public String getPAS() {
		return PAS;
	}
	public void setPAS(String pAS) {
		PAS = pAS;
	}
	public String getCNAME() {
		return CNAME;
	}
	public void setCNAME(String cNAME) {
		CNAME = cNAME;
	}
	public String getCINF() {
		return CINF;
	}
	public void setCINF(String cINF) {
		CINF = cINF;
	}
}
