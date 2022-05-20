package cms.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cms.entity.AvailableLocation;
import cms.interfaces.Deliverylocation;
import cms.superr.entity.Address;

public class DeliveryLocationServiceImplement implements Deliverylocation {

	Scanner input = new Scanner(System.in);
	List<AvailableLocation> locationList = new ArrayList<>();

	public DeliveryLocationServiceImplement() {
		AvailableLocation location1 = new AvailableLocation(1, "BLR", new Address("Banglore", "Karnataka", "India"));
		AvailableLocation location2 = new AvailableLocation(2, "MUM", new Address("Mumbai City", "Maharastra", "India"));
		AvailableLocation location3 = new AvailableLocation(3, "SURT", new Address("Surat", "Gujurat", "India"));
		AvailableLocation location4 = new AvailableLocation(4, "CHE", new Address("Chennai", "TamilNadu", "India"));

		locationList.add(location1);
		locationList.add(location2);
		locationList.add(location3);
		locationList.add(location4);

	}

//	Add the address or location
	@Override
	public void addLocation() {
//		System.out.print("Enter Id:");
		int id = locationList.size()+1;
//		System.err.println(id);
		System.out.print("Enter LocationCode like [Chennai -> CHE] :");
		String locnCode = input.nextLine();
		System.out.print("Enter city name :");
		String city = input.nextLine();
		System.out.print("Enter State name :");
		String state = input.nextLine();
		System.out.print("Enter country name :");
		String country = input.nextLine();

		AvailableLocation locationSet = new AvailableLocation();
		locationSet.setLocationID(id);
		locationSet.setLocationCode(locnCode);
		locationSet.setAddress(new Address(city, state, country));

//		int[] idCount = new int[11];
//		for(int i=0;i<locationList.size();i++) {
//			idCount[i] = i+1;
//		}
//		if(id<12) {
//			 while (id != idCount[1]&&id != idCount[2]&&id != idCount[3]&&id != idCount[4]&&id != idCount[5]&&id != idCount[6]&&id != idCount[7]&&id != idCount[8]&&id != idCount[9]&&id != idCount[10]) {
//				 locationList.add(locationSet);
//				 break;
//			 }
//		}
//		else {
//			System.err.println("You can add upto "+id+" City");
//		}
		
		if(locationList.size() < id) {
			locationList.add(locationSet);
		}
		
	
	}

//	Get all location
	@Override
	public void getAllLocationDetails() {
		
		System.out.println("--------------------------------------------------------------------------------");
		System.out.format("%5s%15s%17s%18s%20s", "| ID | ", " | LocationCode | ", "| City |", "| State |","| Country |\n");
		System.out.println("--------------------------------------------------------------------------------");

		for (AvailableLocation locn : locationList) {
			System.out.format("%5s%12s%25s%18s%16s", locn.getLocationID(), locn.getLocationCode(),
					locn.getAddress().getCity(), locn.getAddress().getState(), locn.getAddress().getCountry()+"\n");
			System.out.println();
		}
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("\t!! If you want more location contact admin !!");
		System.out.println("--------------------------------------------------------------------------------");

	}
	
// DELETE LOCATION
	@Override
	public void deleteLocation(int id) {
		if(id < 0) {
			System.err.println("Give valid ID of agent.");
		}
		else {
			locationList.remove(id);
			System.err.println("Location deleted successfully whose ID :"+(id+1));
		}
		
	}

}
