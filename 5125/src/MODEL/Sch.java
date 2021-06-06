package MODEL;

public class Sch {
	private static Sch sch=new Sch();
    private Sch(){}
    public static Sch getInstance(){
        return sch;
    }
	
    private String SCID;
    private String SID;
	private String CON;
	public String getSCID() {
		return SCID;
	}
	public void setSCID(String scID) {
		SCID = scID;
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
	public void setCON(String cON) {
		CON = cON;
	}
}
