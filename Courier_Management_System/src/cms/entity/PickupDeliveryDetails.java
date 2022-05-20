package cms.entity;

public class PickupDeliveryDetails {
	private String pname;
	private String pemail;
	private String pPhNo;
	private String plocnCode;
	private String pcity;
	private String pstate;
	private int ppinCode;
	private String pcountry;
	
	private String dname;
	private String demail;
	private String dPhNo;
	private String dlocnCode;
	private String dcity;
	private String dstate;
	private int dpinCode;
	private String dcountry;
	
	private float weight_pkg;
	private String pkg_type;

	public PickupDeliveryDetails() {
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPemail() {
		return pemail;
	}

	public void setPemail(String pemail) {
		this.pemail = pemail;
	}

	public String getpPhNo() {
		return pPhNo;
	}

	public void setpPhNo(String pPhNo) {
		this.pPhNo = pPhNo;
	}

	public String getPlocnCode() {
		return plocnCode;
	}

	public void setPlocnCode(String plocnCode) {
		this.plocnCode = plocnCode;
	}

	public String getPcity() {
		return pcity;
	}

	public void setPcity(String pcity) {
		this.pcity = pcity;
	}

	public String getPstate() {
		return pstate;
	}

	public void setPstate(String pstate) {
		this.pstate = pstate;
	}

	public int getPpinCode() {
		return ppinCode;
	}

	public void setPpinCode(int ppinCode) {
		this.ppinCode = ppinCode;
	}

	public String getPcountry() {
		return pcountry;
	}

	public void setPcountry(String pcountry) {
		this.pcountry = pcountry;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDemail() {
		return demail;
	}

	public void setDemail(String demail) {
		this.demail = demail;
	}

	public String getdPhNo() {
		return dPhNo;
	}

	public void setdPhNo(String dPhNo) {
		this.dPhNo = dPhNo;
	}

	public String getDlocnCode() {
		return dlocnCode;
	}

	public void setDlocnCode(String dlocnCode) {
		this.dlocnCode = dlocnCode;
	}

	public String getDcity() {
		return dcity;
	}

	public void setDcity(String dcity) {
		this.dcity = dcity;
	}

	public String getDstate() {
		return dstate;
	}

	public void setDstate(String dstate) {
		this.dstate = dstate;
	}

	public int getDpinCode() {
		return dpinCode;
	}

	public void setDpinCode(int dpinCode) {
		this.dpinCode = dpinCode;
	}

	public String getDcountry() {
		return dcountry;
	}

	public void setDcountry(String dcountry) {
		this.dcountry = dcountry;
	}

	public float getWeight_pkg() {
		return weight_pkg;
	}

	public void setWeight_pkg(float weight_pkg) {
		this.weight_pkg = weight_pkg;
	}

	public String getPkg_type() {
		return pkg_type;
	}

	public void setPkg_type(String pkg_type) {
		this.pkg_type = pkg_type;
	}

	@Override
	public String toString() {
		return "PickupDeliveryDetails [pname=" + pname + ", pemail=" + pemail + ", pPhNo=" + pPhNo + ", plocnCode="
				+ plocnCode + ", pcity=" + pcity + ", pstate=" + pstate + ", ppinCode=" + ppinCode + ", pcountry="
				+ pcountry + ", dname=" + dname + ", demail=" + demail + ", dPhNo=" + dPhNo + ", dlocnCode=" + dlocnCode
				+ ", dcity=" + dcity + ", dstate=" + dstate + ", dpinCode=" + dpinCode + ", dcountry=" + dcountry
				+ ", weight_pkg=" + weight_pkg + ", pkg_type=" + pkg_type + "]";
	}

	

	
	
}
