package cms.entity;

public class CourierDetails {
	private String slNo ;
	private int weight;
//	private String type;
	private String pkg_type;
	
	
	public CourierDetails() {
	}
	public CourierDetails(String slNo, int weight, String pkg_type) {
		this.slNo = slNo;
		this.weight = weight;
		this.pkg_type = pkg_type;
	}
	public String getSlNo() {
		return slNo;
	}
	public void setSlNo(String slNo) {
		this.slNo = slNo;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getPkg_type() {
		return pkg_type;
	}
	public void setPkg_type(String pkg_type) {
		this.pkg_type = pkg_type;
	}

	
}
