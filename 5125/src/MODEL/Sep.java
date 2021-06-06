package MODEL;

public class Sep {
	private static Sep sep=new Sep();
    private Sep(){}
    public static Sep getInstance(){
        return sep;
    }
	
	private String SID;
	private String PAS;
	private String SNAME;
	private String TYPE;
	public String getSID() {
		return SID;
	}
	public void setSID(String sID) {
		SID = sID;
	}
	public String getPAS() {
		return PAS;
	}
	public void setPAS(String pAS) {
		PAS = pAS;
	}
	
	public String getSNAME() {
		return SNAME;
	}
	public void setSNAME(String sNAME) {
		SNAME = sNAME;
	}
	public String getTYPE() {
		return TYPE;
	}
	public void setPTYPE(String tYPE) {
		TYPE = tYPE;
	}
}
