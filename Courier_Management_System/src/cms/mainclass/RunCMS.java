package cms.mainclass;

import java.util.Scanner;

import cms.entity.Customer;
import cms.services.AgentServiceImplementation;
import cms.services.CustomerServicesImplementation;
import cms.services.DeliveryLocationServiceImplement;

public class RunCMS {

	public static void main(String[] args) {
		int firstChoice, agentChoice, choiceForAgent,locationChoice, customerChoice;
		String userName, password;
		System.err.println("\t\t\t\t **Welcome to Courier_Management_System**");
		System.out.println("\t\t\t\t=============Menu Driven Program===========");

//		OBJECTS**
		Scanner intInput = new Scanner(System.in);
		Scanner stringInput = new Scanner(System.in);
		AgentServiceImplementation agent = new AgentServiceImplementation();
		DeliveryLocationServiceImplement delLocation = new DeliveryLocationServiceImplement();
		CustomerServicesImplementation customer = new CustomerServicesImplementation();
		
		
		do {
			System.out.println(
					"-----------------------------------------------------------------------------------------");
			System.out.print("\t|1. Admin|\t|2. Customer|\t    |3. Exit| \n");
			System.out.println(
					"-----------------------------------------------------------------------------------------");
			firstChoice = intInput.nextInt();

			switch (firstChoice) {
//	** ADMIN SECTION
			case 1:
				System.out.print("Enter username : ");
				userName = stringInput.nextLine();
				System.out.print("Enter password** : ");
				password = stringInput.nextLine();

				if (userName.equals("a") && password.equals("a")) {
					do {
						System.out.print("\t\t\t----------------------------------");
						System.out.print("\n\t\t\t\t** Admin Section**\n");
						System.out.print("\t\t\t----------------------------------\n");

						System.out.println(
								"1. Agent\t2. Customer\t3. Delivery Location\t4. press any number to back(<-)");
						System.out.println(
								"----------------------------------------------------------------------------------------");
						choiceForAgent = intInput.nextInt();
						if (choiceForAgent == 1) {
							
//AGENTS
							System.out.print("\n1. Add Agent\n2. View Agent\n3. Delete Agent\n4. press any number to back(<-)");

							agentChoice = intInput.nextInt();
							switch (agentChoice) {
							case 1:

//					** FOR ADDING AGENTS **
								System.out.println("Enter no of agent you want to register.");
								int noOfagent = intInput.nextInt();
								for (int i = 1; i <= noOfagent; i++) {
									System.out.print("\n" + i + ". Agents details \n");
									agent.addAgent();
									System.out.println("SUccessfully add Agent details");
								}
								break;

							case 2:

//					** FOR VIEWING LIST OF AGENTS **
								System.out.print("\nView Agents\n");
								System.out.print("-----------------\n");

								agent.viewAgent();
								
								break;
							case 3:

//					** FOR DELETE AGENTS WITH ID **
								System.out.println("Give which agent you want to delete(Sl_no) : \n");
								int deleteId = intInput.nextInt();
								deleteId -= 1; // coz list index always starts with 0.
								agent.deleteAgent(deleteId);
								break;
							default:
								System.err.println("<--");
							}
						} else if (choiceForAgent == 2) {
//	CUSTOMER			
							System.out.print("\n1. View registered customer\n2. view all placed request\n3. Delete customer\n4. press any number to back(<-) ");
							customerChoice = intInput.nextInt();
							switch (customerChoice) {
							case 1:
								customer.viewCustomer();
								break;
							case 2:
								customer.getPlacedRequest();
								break;
							case 3:
								System.out.println("Enter UserId to delete.");
								int id = intInput.nextInt();
								customer.deleteCustomer(id);
								break;

							default:
								break;
							}
								
							
						} else if (choiceForAgent == 3) {
//	LOCATIONS
							System.out.print("\n1. Add Location\n2. View All_Location\n3. Delete Location\n4. press any number to back(<-) ");
							locationChoice = intInput.nextInt();	
							switch(locationChoice){
							case 1:
								delLocation.addLocation();
								System.out.println("Successfully adding the location");
								break;
							case 2:
//			** VIEW LOCATIONS THAT WE HAVE
								delLocation.getAllLocationDetails();								
								break;
							case 3:
//			** DELETE THE LOCATION
								System.out.println("Give which agent you want to delete(Sl_no) : \n");
								int deleteId = intInput.nextInt();
								deleteId -= 1;
								delLocation.deleteLocation(deleteId);
								break;
							default:
								System.err.println("<--");								
							}

//							
						} else {
							System.err.println("<--");
						}
					} while (choiceForAgent < 4);
				} else {
					System.err.println("Invalid credential. ");
				}

				break;
			case 2:
				do {
					System.out.print(
							"\n1. Register yourself\n2. View Your Details\n3. Edit your details Request\n4. View available delivery location\n5. Courier Request\n6. Get all placed orders\n7. Print bill and request order\n8. press any number to back(<-) \n");
					customerChoice = intInput.nextInt();
					switch (customerChoice) {
					case 1:
						customer.registerCustomer();

						break;
					case 2:
						customer.viewCustomer();
						break;
					case 3:
						customer.editCustomer();
						break;
					case 4:
						customer.getLocations();
						break;
					case 5:
						customer.courierRequests();
						break;
					case 6:
						customer.getPlacedRequest();
						break;
					case 7:
						customer.printBill();

						break;

					default:
						System.err.println("<--\n");
						break;
					}
				} while (customerChoice<7);
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.err.println("Enter valid input");
			}
		} while (firstChoice <= 3);

	}
}
