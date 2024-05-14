package api.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.endpoints.Userendpoints;
import api.payload.User;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Ddtests {
	
	@Test(priority=1, dataProvider = "Data", dataProviderClass=DataProvider.class)
	
	public void testPostUser(String UserID, String UserName, String fname, String lname, String useremail, String pwd, String ph) 
	{
		User userPayLoad= new User();
		userPayLoad.setId(Integer.parseInt(UserID));
		userPayLoad.setUsername(UserName);
		userPayLoad.setFirstName(fname);
		userPayLoad.setLastName(lname);
		userPayLoad.setEmail(useremail);
		userPayLoad.setPassword(pwd);
		userPayLoad.setPhone(ph);
		
		 Response response= Userendpoints.CreteEndpoints(userPayLoad);
		 Assert.assertEquals(response.statusCode(), 200);
		
		
	}
	@Test(priority =2, dataProvider="UserNames", dataProviderClass = DataProvider.class)
	public void testDeleteUserByName(String userNames) {
		Response response =Userendpoints.deleteuser(userNames);
		Assert.assertEquals(response.statusCode(), 200);
				
		
	}

}
