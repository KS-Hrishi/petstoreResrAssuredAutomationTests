package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


import api.endpoints.UserEndPoints_ByUsingPropertiesFile;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests_ByUsingPropFile {

	Faker faker;
	User userPayload;
	public Logger logger;
	
	@BeforeClass
	public void setupData()
	{
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		logger = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority = 1)
	public void testPostUser() {
		
		logger.info("************* Creating User***************");
		Response response = UserEndPoints_ByUsingPropertiesFile.CreateUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("************* User Created***************");
	}
	
	@Test(priority = 2)
     public void testGetUserbyName() {
		
		Response response = UserEndPoints_ByUsingPropertiesFile.ReadUser(this.userPayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority = 3)
     public void testUpdateUserbyName() {
    	 
    	 userPayload.setFirstName(faker.name().firstName());
 		userPayload.setLastName(faker.name().lastName());
 		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndPoints_ByUsingPropertiesFile.UpdateUser(userPayload,this.userPayload.getUsername());
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//checking data after response
		Response responseAfterupdate = UserEndPoints_ByUsingPropertiesFile.ReadUser(this.userPayload.getUsername());
		responseAfterupdate.then().log().body();
		Assert.assertEquals(responseAfterupdate.getStatusCode(), 200);
		
	}
	
	
	@Test(priority = 4)
    public void testDeleteUserbyName() {
		
		Response response = UserEndPoints_ByUsingPropertiesFile.DeleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	
	
	
	
	
}
