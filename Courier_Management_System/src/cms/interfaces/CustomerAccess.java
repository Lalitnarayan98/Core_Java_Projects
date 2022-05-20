package cms.interfaces;

public interface CustomerAccess {
	
	public void registerCustomer();
	public void viewCustomer();
	public void deleteCustomer(int id);
	public void editCustomer();
	public void courierRequests();
	public void getPlacedRequest();
	public void printBill();


}
