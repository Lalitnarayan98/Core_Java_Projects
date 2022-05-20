package cms.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import cms.entity.CourierDetails;
import cms.entity.Customer;
import cms.entity.PickupDeliveryDetails;
import cms.interfaces.CustomerAccess;
import cms.superr.entity.Person;

public class CustomerServicesImplementation implements CustomerAccess {
	Map<String,PickupDeliveryDetails> pickupDeliveryDetailsList = new HashMap<>();
	Customer customer = new Customer();
	CourierDetails c_details = new CourierDetails();
	DeliveryLocationServiceImplement locn = new DeliveryLocationServiceImplement();
	PickupDeliveryDetails pickDeliDetails = new PickupDeliveryDetails();
	
	Scanner stringInput = new Scanner(System.in);
	Scanner intInput = new Scanner(System.in);
	int id = 000;
	String gift_type =null;
	float gift_weight = 0;
	
	
//	Test case
	
	@Override
	public void registerCustomer() {
		System.out.print("Enter name : ");
		String name = stringInput.nextLine();
		System.out.print("Enter your e-mail : ");
		String email = stringInput.nextLine();
		System.out.print("Enter phone No : ");
		String phNo = stringInput.nextLine();
		System.out.print("Enter gender : ");
		String gender = stringInput.nextLine();
		System.out.print("Enter your age : ");
		int age = stringInput.nextInt();
//
		customer.setCustomerId(id+1);
		customer.setPerson(new Person(name, email, phNo));
		customer.setGender(gender);
		customer.setAge(age);
		
		System.out.println("\nHey " + customer.getPerson().getName() + ", You completed the registration !!");
	}

	@Override
	public void viewCustomer() {
		if(customer != null) {
			if (customer.getCustomerId() == 0) {
				System.err.println("You need to register first");

//				registerCustomer();
			} else {
				System.out.println(
						"--------------------------------------------------------------------------------------------------------------------");
				System.out.format("%5s%15s%25s%28s%20s%15s", "| ID | ", " | Name | ", "| Email |", "| PhoneNo |",
						"| Gender |", "| Age |", "\n");
				System.out.println(
						"\n------------------------------------------------------------------------------------------------------------------");

				System.out.format("%3s%23s%30s%18s%17s%17s", customer.getCustomerId(), customer.getPerson().getName(),
						customer.getPerson().getEmail(), customer.getPerson().getPhoneNo(), customer.getGender(),
						customer.getAge(), "\n");

				System.out.println(
						"\n...............................................................................................................");

			}
			
		}
		else {
			System.out.println("\nCustomer is not Found !");
		}

	}

	@Override
	public void editCustomer() {
		System.out.println("Enter ID for update");
		int id = intInput.nextInt();

		if (id == customer.getCustomerId()) {
			System.out.print("Enter yor name : ");
			stringInput.nextLine();
			String name = stringInput.nextLine();
			System.out.print("Enter yor email : ");
			String email = stringInput.nextLine();
			System.out.print("Enter yor phone_no :");
			String phNo = stringInput.nextLine();
			System.out.print("Enter yor gender : ");
			String gender = stringInput.nextLine();
			System.out.print("Enter yor age : ");
			int age = intInput.nextInt();

//			System.out.println(name+" "+email+" "+phNo+" "+gender+" "+age);

			customer.setCustomerId(id);
			customer.setPerson(new Person(name, email, phNo));
			customer.setGender(gender);
			customer.setAge(age);

			System.out.println("\n Updated.. Successfully\n");

		}
		else {
			System.err.println("Register first.");
			registerCustomer();
		}
	}

	@Override
	public void deleteCustomer(int id) {
		if(customer.getCustomerId() != id) {
			System.err.println("User ID is not available");
		}
		else {
			customer = null;
			System.out.println("Customer is deleted successfully.");
		}

	}

	@Override
	public void courierRequests() {
		String requestId=null;
		if (customer.getCustomerId() == 0) {
			System.err.println("Register first, Then only you can request a service.");
			System.out.println("Do you want to register with us ?(y/n)");
			char choice = intInput.next().charAt(0);
			if (choice == 'y' || choice == 'Y') {
				registerCustomer();
			}
		} else {
			System.out.println(
					"Do you want to change your details, Beacause U cant't change the details during the courier request ?(y/n)");
			char decission = stringInput.next().charAt(0);
			if (decission == 'Y' || decission == 'y') {
				editCustomer();
			} else {

				System.out.println("Pick_up address . . .  \n===================>>>\n");
				pickDeliDetails.setPname(customer.getPerson().getName());
				pickDeliDetails.setPemail(customer.getPerson().getEmail());
				pickDeliDetails.setpPhNo(customer.getPerson().getPhoneNo());

				getLocations();

				System.out.print("Choose location ID to pickUp :");
				int pikLocnId = intInput.nextInt();
				pikLocnId -= 1;
				if (pikLocnId < locn.locationList.size()) {
					pickDeliDetails.setPlocnCode(locn.locationList.get(pikLocnId).getLocationCode());
					pickDeliDetails.setPcity(locn.locationList.get(pikLocnId).getAddress().getCity());
					pickDeliDetails.setPstate(locn.locationList.get(pikLocnId).getAddress().getState());
					pickDeliDetails.setPcountry(locn.locationList.get(pikLocnId).getAddress().getCountry());

//				
					System.out.print("\nEnter pin code for pickup : ");
					int pin = intInput.nextInt();
					pickDeliDetails.setPpinCode(pin);
//				
					System.out.println("Delivery address . . .  \n===================>>>");
					stringInput.nextLine();
					System.out.print("Name : ");
					String delName = stringInput.nextLine();
					System.out.print("Email : ");
					String delEmail = stringInput.nextLine();
					System.out.print("Phone_No : ");
					String delPhNo = stringInput.nextLine();
					pickDeliDetails.setDname(delName);
					pickDeliDetails.setDemail(delEmail);
					pickDeliDetails.setdPhNo(delPhNo);

					getLocations();

					System.out.print("Choose location ID to pickUp :");
					int delLocnId = intInput.nextInt();
					delLocnId -= 1;
					if (delLocnId < locn.locationList.size()) {
						pickDeliDetails.setDlocnCode(locn.locationList.get(delLocnId).getLocationCode());
						pickDeliDetails.setDcity(locn.locationList.get(delLocnId).getAddress().getCity());
						pickDeliDetails.setDstate(locn.locationList.get(delLocnId).getAddress().getState());
						pickDeliDetails.setDcountry(locn.locationList.get(delLocnId).getAddress().getCountry());

						System.out.print("\nEnter pin code for ddelivery : ");
						int delPin = intInput.nextInt();
						pickDeliDetails.setDpinCode(delPin);
					} else {
						System.err.println("enter valid location ID");
					}
					System.out.println("Courier Details . . .  \n===================>>>");
					System.out.print("Weight of courier in gms: ");
					float weight = intInput.nextFloat();
					System.out.print("Courier type [gift/plain]: ");
					String type = stringInput.nextLine();
					if (type.equalsIgnoreCase("gift") || type.equalsIgnoreCase("plain") || type.equalsIgnoreCase("g")
							|| type.equalsIgnoreCase("p")) {
						pickDeliDetails.setWeight_pkg(weight);
						pickDeliDetails.setPkg_type(type);
						
					requestId = "RQSTID000" + (pickupDeliveryDetailsList.size() + 1);
					}
				} else {
					System.err.println("enter valid location ID");
				}
//				String requestId = "RQSTID000" + (pickupDeliveryDetailsList.size() + 1);
				pickupDeliveryDetailsList.put(requestId, pickDeliDetails);
				System.out.println(pickDeliDetails);
				if(requestId != null) {
						System.out.println("\n\nRequest is accepted, with in 2days product will pickup from your given location..\n\n");
				}
				
			}
		}
	}
	String placedID = null;
	String senderName = null, senderEmail = null, senderPhNo = null, senderPickUpAddress = null;
	String recieverName = null, recieverEmail = null, recieverPhNo = null, recieverDeliveryAddress = null;
	
	public void getPlacedRequest() {	
		for(Map.Entry<String, PickupDeliveryDetails> placedOrder : pickupDeliveryDetailsList.entrySet()) {
			placedID = placedOrder.getKey();
		}
		if(placedID != null) {
			System.out.println(
					"..........................................................................................................................................................................................................");
			System.out.format("%5s%12s%15s%17s%40s%25s%20s%19s%25s", "Request_ID", "S_Name", "S_Email", "S_PhNo","Pickup_Address", "R_Name", "R_Email", "R_PhNo", "R_Address","OrdrType","Ordr_Weight \n");
			System.out.println("..........................................................................................................................................................................................................");
			

			for (Map.Entry<String, PickupDeliveryDetails> placedOrder : pickupDeliveryDetailsList.entrySet()) {
				placedID = placedOrder.getKey();
				senderName = placedOrder.getValue().getPname();
				senderEmail = placedOrder.getValue().getPemail();
				senderPhNo = placedOrder.getValue().getpPhNo();
				senderPickUpAddress = placedOrder.getValue().getPlocnCode() + ", " + placedOrder.getValue().getPcity()
						+ ", pin-" + placedOrder.getValue().getPpinCode() + ", " + placedOrder.getValue().getPstate() + ", "
						+ placedOrder.getValue().getPcountry();

				recieverName = placedOrder.getValue().getDname();
				recieverEmail = placedOrder.getValue().getDemail();
				recieverPhNo = placedOrder.getValue().getdPhNo();
				recieverDeliveryAddress = placedOrder.getValue().getDlocnCode() + ", " + placedOrder.getValue().getDcity()
						+ ", pin-" + placedOrder.getValue().getDpinCode() + ", " + placedOrder.getValue().getDstate() + ", "
						+ placedOrder.getValue().getDcountry();
				
				
				gift_type = placedOrder.getValue().getPkg_type();
				gift_weight = placedOrder.getValue().getWeight_pkg();
			
					System.out.format("%5s%13s%20s%15s%50s%14s%25s%17s%50s%10s%8s", placedID, senderName, senderEmail, senderPhNo,senderPickUpAddress, recieverName, recieverEmail, recieverPhNo, recieverDeliveryAddress,gift_type , gift_weight);	
			}	
			System.out.println("\n..........................................................................................................................................................................................................");
			System.out.println("[S_ -=> Sender, R-=> Reciever]");
		}
		else {
			System.err.println("Place a courier request first");
		}
		
	}

	public void getLocations() {
		locn.getAllLocationDetails();
		
	}

	public void printBill() {
		String type = gift_type;
		float weight = gift_weight;
		double gift_price = weight*0.01;

		
		double price = 0,total_Bill = 0,gst = 0;
		double PriceWithGift_price = 0;
	
		
		if(placedID != null) {
		if(weight <= 500 && type.equals("gift") ) {  //
			PriceWithGift_price = weight+(500*.20)+gift_price;
			price = weight/2;
		}
		else {
			PriceWithGift_price = weight+(500*0.3);
		}
		gst = PriceWithGift_price*.18;
		total_Bill = PriceWithGift_price + gst+price; 
			System.out.println(".....................................................................................................................");
			System.out.println("\t\t\t\t\t\tYour bill Mr/Mrs. "+senderName);
			System.out.println(".....................................................................................................................");
			System.out.format("%1s%80s","PickUp address"," Delivery Address \n");
			System.out.format("%1s%80s","--------------","----------------\n");
			
			System.out.format("%1s%80s","Name : "+senderName,"Name : "+recieverName+"\n");
			System.out.format("%1s%80s","Email : "+senderEmail,"Email : "+recieverEmail+"\n");
			System.out.format("%1s%80s","Phnoe : "+senderPhNo,"Phone : "+recieverPhNo+"\n");
			System.out.format("%1s%80s","Address : "+senderPickUpAddress,"Address : "+recieverDeliveryAddress+"\n");
			
			System.out.format("\n%55s",".Transaction. \n");
			System.out.format("%55s","-------------- \n");
			System.out.format("%25s%50s","Product_weight  = ",weight+" in gms\n");
			System.out.format("%25s%50s","Product_Type  = ",type+" \n");
			System.out.format("%25s%50s","Initial Price  = ",price+" \n");
			System.out.format("%25s%50s","Initial+gift Price  = ",PriceWithGift_price+" \n");
			System.out.format("%25s%50s","GST-18%  = ",gst+" \n");
			System.out.println("\t----------------------------------------------------------------------\n");
			System.out.print("\t\tTotal price = \t\t\t"+total_Bill+" Rs\n");
			
		}
		else {
			System.err.println("Place a request first ! !");
		}
		
		
	}

}
