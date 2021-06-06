package MODEL;

public class Man {
	private static Man man=new Man();
    private Man(){}
    public static Man getInstance(){
        return man;
    }
	
	private String MID;
	private String PAS;
	public String getMID() {
		return MID;
	}
	public void setMID(String mID) {
		MID = mID;
	}
	public String getPAS() {
		return PAS;
	}
	public void setPAS(String pAS) {
		PAS = pAS;
	}
	
}
