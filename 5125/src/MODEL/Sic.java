package MODEL;

public class Sic {
	private static Sic sic=new Sic();
    private Sic(){}
    public static Sic getInstance(){
        return sic;
    }
	
    private String CID;
	private String SID;
	private String CON;
	private String CNAME;	
	private String SNAME;
	public String getCID() {
		return CID;
	}
	public void setCID(String cID) {
		CID = cID;
	}
	public String getSID() {
		return SID;
	}
	public void setSID(String sID) {
		SID = sID;
	}
	public String getCON() {
		return CON;
	}
	public void setCONTENT(String cON) {
		CON = cON;
	}
	public String getCNAME() {
		return CNAME;
	}
	public void setCNAME(String cNAME) {
		CNAME = cNAME;
	}
	public String getSNAME() {
		return SNAME;
	}
	public void setSNAME(String sNAME) {
		SNAME = sNAME;
	}

}
