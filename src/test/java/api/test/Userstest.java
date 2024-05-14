package api.test;

import org.junit.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Userendpoints;
import api.payload.User;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Userstest {
	Faker faker;
	User UserPayload;
	
	@BeforeClass
	public void setupData() {
		faker=new Faker();
		UserPayload =new User();
		UserPayload.setId(faker.idNumber().hashCode());
		UserPayload.setUsername(faker.name().username());
		UserPayload.setFirstName(faker.name().firstName());
		UserPayload.setLastName(faker.name().lastName());
		UserPayload.setEmail(faker.internet().safeEmailAddress());
		UserPayload.setPassword(faker.internet().password(2,5));
		UserPayload.setPhone(faker.phoneNumber().cellPhone());
	}
	@Test(priority=1)
   public void testPostUser() {
	 Response response=  Userendpoints.CreteEndpoints(UserPayload);
	 response.then().log().all();
	 Assert.assertEquals(response.statusCode(), 200);
}
	@Test(priority=2)
	public void testGetUserByName() {
		Response response= Userendpoints.readuser(this.UserPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	public void testUpdateuser() {
		
		//update data using payload
		UserPayload.setFirstName(faker.name().firstName());
		UserPayload.setLastName(faker.name().lastName());
		UserPayload.setEmail(faker.internet().safeEmailAddress());
	Response response=Userendpoints.updateuser(this.UserPayload.getUsername(),UserPayload);
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(),200);	
	Response responseAfterupdate= Userendpoints.CreteEndpoints(UserPayload);
	Assert.assertEquals(responseAfterupdate.statusCode(), 200);
	
	}
	public void testDeleteUserByName() {
		 Response response=  Userendpoints.deleteuser(this.UserPayload.getUsername());
	}
	
	
	
}
