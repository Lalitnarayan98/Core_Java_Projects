package cms.entity;


import cms.superr.entity.Person;

public class Customer {
	private int customerId;
	Person person;
	private String gender;
	private int age;
	
	public Customer() {
	
	}
	public Customer(int customerId, Person person, String gender, int age) {
		this.customerId = customerId;
		this.person = person;
		this.gender = gender;
		this.age = age;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", person=" + person + ", gender=" + gender + ", age=" + age
				+ "]";
	}
	
	

	
}
