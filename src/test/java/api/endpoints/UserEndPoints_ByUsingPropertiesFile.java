package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import  io.restassured.http.ContentType;
import io.restassured.response.Response;




public class UserEndPoints_ByUsingPropertiesFile {

	static ResourceBundle getURL()
	{
		 ResourceBundle routes = ResourceBundle.getBundle("routes");
		 return routes;
	}
	
	
	
	public static Response CreateUser(User payload)
	{
		String post_url = getURL().getString("post_url");
		
		Response response =given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		.when()
		    .post(post_url);
		
		
		return response;
	}
	
	public static Response ReadUser(String Username)
	{
		String get_url = getURL().getString("get_url");
		
		Response response =given()
                   .pathParams("username",Username)
		   .when()
		       .get(get_url);
		
		
		return response;
	}
	
	public static Response UpdateUser(User payload,String Username)
	{
		String update_url = getURL().getString("update_url");
		
		Response response =given()
				   .contentType(ContentType.JSON)
				   .accept(ContentType.JSON)
				   .pathParams("username",Username)
				   .body(payload)
				.when()
				    .post(update_url);
				
				
				return response;
	}
	
	
	public static Response DeleteUser(String Username)
	{
		String delete_url = getURL().getString("delete_url");
		
		Response response =given()
                   .pathParams("username",Username)
		   .when()
		       .get(delete_url);
		
		
		return response;
	}
	
	
	
	
}
