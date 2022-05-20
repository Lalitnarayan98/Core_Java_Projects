import java.util.ArrayList;
import java.util.List;

import cms.entity.AvailableLocation;
import cms.services.CustomerServicesImplementation;
import cms.superr.entity.Address;

public class FormattingString {
	public static void main(String[] args) {
		FormattingString obj = new FormattingString();
//
//		CustomerServicesImplementation o = new CustomerServicesImplementation();
//		o.getPlacedRequest();
		obj.formatTet();

	}

	public void formatTet() {
		System.out.println(".............................................................................................................................................................................................");
		System.out.format("%5s%12s%15s%17s%40s%25s%20s%19s%25s","Request_ID","S_Name","S_Email","S_PhNo","Pickup_Address","R_Name","R_Email","R_PhNo","R_Address \n");
		System.out.println(".............................................................................................................................................................................................");
		System.out.format("%5s%11s%20s%15s%50s%14s%25s%17s%50s","RQSTID0001","Lalit","lalit@gmail.com","9583911973","BLR, Benaglore, 757086, Karnataka, India","Lalit","lalit@gmail.com","9583911973","BLR, Benaglore, 757086, Karnataka, India");
		
	}
}

/*
 * System.out.println(
 * "----------------------------------------------------------------------------------------------"
 * ); System.out.format("%5s%15s%17s%18s%20s%15s", "| ID | ", " | Name | ",
 * "| Email |", "| PhoneNo |","| Gender |","| Age |","\n"); System.out.println(
 * "\n----------------------------------------------------------------------------------------------"
 * );
 */
