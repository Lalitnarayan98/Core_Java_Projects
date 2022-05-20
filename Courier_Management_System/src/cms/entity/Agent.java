package cms.entity;

import java.time.LocalDate;

import cms.superr.entity.Person;

public class Agent extends Person{
	private int agentId;
	public Agent(){	
		super();
	}
	
	public Agent(int agentId,String name, String email, String phoneNo, LocalDate dob) {
		super(name, email, phoneNo, dob);
		this.agentId = agentId ;
	}
	
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	@Override
	public String toString() {
		return "AgentId : " + agentId + super.toString() + "\n* * * * * * * * * * * * * * *";
	}

	
	
	
	


	

}
