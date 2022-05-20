package cms.mainclass;

import java.util.Scanner;

import cms.services.AgentServiceImplementation;

public class CMS {

	public static void main(String[] args) {
		int userChoice, adminChoice;
		String userName, password;
		System.out.println("\t\t\t **Welcome to Courier_management_system**");
		System.out.println("\t\t\t==========================================");

		Scanner sc = new Scanner(System.in);
		AgentServiceImplementation agent = new AgentServiceImplementation();

		while (true) {
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.print("|1. Admin|\t\t|2. Customer|\t\t|3. Delivery AgentsInterface|\t\t|4. Exit| \n");
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("Enter your code. ");
			userChoice = sc.nextInt();

//			Admin Section
			if (userChoice == 1) {
				System.out.print("Enter username : ");
				sc.nextLine();
				userName = sc.nextLine();
				System.out.print("Enter password** : ");
				password = sc.nextLine();

				if (userName.equals("admin") && password.equals("admin")) {
					System.out.print("\n|1. Agent|\t|2. Customers|\t\n|press any number to back |\n");
					System.out.println("--------------------------------------------------------------------------------------------\n");
					adminChoice = sc.nextInt();
					switch (adminChoice) {
					case 1:
						System.out.print(
								"\n|1. Add Agent|\t|2. View Agent|\t|3. Delete Agent|\n|press any number to back |\n");
						System.out.println("--------------------------------------------------------------------------------------------");
//						Choice for agent field
						int agentChoice = sc.nextInt();
						switch (agentChoice) {
						case 1:
//	**FOR ADDING AGENTS**
							System.out.println("Enter no of agent you want to register.");
							int noOfagent = sc.nextInt();
							for (int i = 1; i <= noOfagent; i++) {
								System.out.print("\n" + i + ". Agents details \n");
								agent.addAgent();
							}
							break;
						case 2:
//	**FOR VIEWING LIST OF AGENTS**
							agent.viewAgent();
							break;
						case 3:
//	**FOR DELETE AGENTS WITH ID**
							int deleteId = sc.nextInt();
							deleteId -= 1;  //coz list index always starts with 0.
							agent.deleteAgent(deleteId);
						}
						break;
					case 2:
						break;
					default:
						System.err.println("<--");
					}
				} else {
					System.err.println("Invalid credential");
				}

			}

			else if (userChoice == 2) {

			} else if (userChoice == 3) {

			} else if (userChoice == 4) {
				System.exit(0);
			} else {
				System.err.println("Please provide valid input!!!");
			}
		}
	}

}
