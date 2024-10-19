package StepDefenitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class S2StepDefenition {
    @Given("User is authenticated")
    public void user_is_authenticated() {
        // Logic for user authentication
        System.out.println("User authentication step is executed : "+System.getProperty("APIkey"));
    }
	
	
	@Given("I have {int} values")
	public void i_have_values(Integer int1, io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> a = dataTable.asLists();
		for(List<String> x : a){
			for(String y : x) {
				System.out.println(y);
			}
			System.out.println(x);
		}
	}
	
	@Given("I have {int} values {int} and {int}")
	public void i_have_values_and(Integer int1, Integer int2, Integer int3) {
	 System.out.println("Sum: "+ Math.addExact(int2, int3));
	}
	
	@When("I add them")
	public void i_add_them() {
	   System.out.println("Addition");
	}
	
	@Then("validate the SUM")
	public void validate_the_sum() {
	    System.out.println("Sum successful");
	}
	@Then("check if its a odd or even")
	public void check_if_its_a_odd_or_even() {
		  System.out.println("evrn successful");
	}
	
//	@Then("deal properties")
//	public void deal_properties() throws IOException {
//		FileInputStream fis = new FileInputStream("G:\\Mani Eclipse New Workspace\\Mani Eclipse New Workspace\\CucumberSelenium\\src\\test\\java\\Features\\S2.feature");
//		Properties prop = new Properties();
//		prop.load(fis);
//		System.out.println(prop.get("APIkey"));
//		System.out.println(prop.get("cucumber.filter.tags"));
//		Properties a =System.getProperties();
//		System.out.println(a);
//		prop.put("APIkey", System.getProperty("APIkey"));
//		prop.put("APIkey", System.getProperty("cucumber.filter.tags"));
//		System.out.println(prop.get("APIkey"));
//		System.out.println(prop.get("cucumber.filter.tags"));
//		
//	}
}
