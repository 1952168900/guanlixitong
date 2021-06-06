package MODEL;

public class Prj {
	private static Prj prj=new Prj();
    private Prj(){}
    public static Prj getInstance(){
        return prj;
    }
	
    private String PRID;
	private String CID;
	private String CON;
	private String STARTTIME;
	private String ENDTIME;
	private String TYPE;
	public String getPRID() {
		return PRID;
	}
	public void setPRID(String prID) {
		PRID = prID;
	}
	public String getCID() {
		return CID;
	}
	public void setCID(String cID) {
		CID = cID;
	}
	public String getCON() {
		return CON;
	}
	public void setCON(String cON) {
		CON = cON;
	}
	
	public String getSTARTTIME() {
		return STARTTIME;
	}
	public void setSTARTTIME(String sTARTTIME) {
		STARTTIME = sTARTTIME;
	}
	public String getENDTIME() {
		return ENDTIME;
	}
	public void setENDTIME(String eNDTIME) {
		ENDTIME = eNDTIME;
	}
	public String getTYPE() {
		return TYPE;
	}
	public void setPTYPE(String tYPE) {
		TYPE = tYPE;
	}
}
