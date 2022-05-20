package cms.entity;

import cms.superr.entity.Address;

public class AvailableLocation {
	private int locationID;
	private String locationCode;
	Address address;
	
	public AvailableLocation() {}
	
	public AvailableLocation(int locationId,String locationCode, Address address ) {
		this.locationID = locationId;
		this.locationCode = locationCode ;
		this.address = address;
	}

	public int getLocationID() {
		return locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	

	
	@Override
	public String toString() {
		return "AvailableLocation [locationID=" + locationID + ", locationCode=" + locationCode + ", address=" + address
				+ "]";
		
	}
	
	

}
