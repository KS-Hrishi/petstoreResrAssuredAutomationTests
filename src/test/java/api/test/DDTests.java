package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {

   @Test(priority=1, dataProvider = "Data", dataProviderClass = DataProviders.class)
   public void testPostuUser(String userID,String userName, String fname, String lname, String useremail,String pwd, String phoneno)      
   {
    	  
    	User userpayload = new User();
    	userpayload.setId(Integer.parseInt(userID));
    	userpayload.setUsername(userName);
    	userpayload.setFirstName(fname);
    	userpayload.setLastName(lname);
    	userpayload.setEmail(useremail);
    	userpayload.setPassword(pwd);
    	userpayload.setPhone(phoneno);
		
		Response response = UserEndPoints.CreateUser(userpayload);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
   @Test(priority=2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
   public void testDeleteUser(String userName)      
   {    
	   
		Response response = UserEndPoints.DeleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);		
	}
	
}
