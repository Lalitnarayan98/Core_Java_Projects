package cms.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import cms.services.AgentServiceImplementation;

public class Testing {

	@Test
	public void deleteAgent(int id) {
		AgentServiceImplementation obj = new AgentServiceImplementation();
		 obj.deleteAgent(id);
	}

}
