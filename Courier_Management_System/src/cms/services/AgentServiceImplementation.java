package cms.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import cms.entity.Agent;
import cms.interfaces.AgentsInterface;

public class AgentServiceImplementation implements AgentsInterface {
	static List<Agent> agentList = new ArrayList<>();
	
		public AgentServiceImplementation() {
			Agent agent1 = new Agent(101, "Agent-1", "agent1@gmail.com", "1234567890", LocalDate.parse("1999-10-12"));
			Agent agent2 = new Agent(102, "Agent-2", "agent2@gmail.com", "9678123765", LocalDate.parse("1996-04-11"));
			Agent agent3 = new Agent(103, "Agent-3", "agent3@gmail.com", "1234567890", LocalDate.parse("1998-06-05"));
			agentList.add(agent1);
			agentList.add(agent2);
			agentList.add(agent3);	
		}


	@Override
	public void addAgent() {
		
// *******	ADD AGENT  *******
		Scanner intInput = new Scanner(System.in);
		Scanner stringInput = new Scanner(System.in);
		System.out.print("Enter agent_id : ");
		int id = intInput.nextInt();
		System.out.print("Enter agent_name : ");
		String name = stringInput.nextLine();
		System.out.print("Enter agent_email : ");
		String email = stringInput.nextLine();
		System.out.print("Enter agent_phone_no : ");
		String phno = stringInput.nextLine();
		System.out.print("Enter agent_Date-Of-birth(yyyy-mm-dd) : ");
		String dob = stringInput.nextLine();
		LocalDate date = LocalDate.parse(dob);
		
		
//		Agent agent = new Agent(id, name, email, phno, date);
		
//		Using setter method
		Agent agent = new Agent();
		agent.setAgentId(id);
		agent.setName(name);
		agent.setEmail(email);
		agent.setPhoneNo(phno);
		agent.setDob(date);

		agentList.add(agent);
	}

// *******	VIEW AGENT LIST *******
	public void viewAgent() {
		if(agentList == null) {
			System.err.println("Empty agent");
		}
		else{
			int i =0;
		
			for (Agent eachAgent : agentList) {
				i++;			
				System.out.print("");		
				System.out.print(i+") ");
				System.out.println(eachAgent);
			}
		}
	}
// *******	DELETE AGENT *******
	public void deleteAgent(int deleteId) {
		if(deleteId < 0) {
			System.err.println("Give valid ID of agent.");
		}
		else {
			agentList.remove(deleteId);
			System.err.println("Agent deleted successfully whose ID :"+(deleteId+1));
		}
	}

}
