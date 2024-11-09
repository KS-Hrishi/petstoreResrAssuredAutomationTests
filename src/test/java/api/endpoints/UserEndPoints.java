package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import  io.restassured.http.ContentType;
import io.restassured.response.Response;




public class UserEndPoints {

	public static Response CreateUser(User payload)
	{
		Response response =given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		.when()
		    .post(Routes.post_url);
		
		
		return response;
	}
	
	public static Response ReadUser(String Username)
	{
		Response response =given()
                   .pathParams("username",Username)
		   .when()
		       .get(Routes.get_url);
		
		
		return response;
	}
	
	public static Response UpdateUser(User payload,String Username)
	{
		Response response =given()
				   .contentType(ContentType.JSON)
				   .accept(ContentType.JSON)
				   .pathParams("username",Username)
				   .body(payload)
				.when()
				    .post(Routes.update_url);
				
				
				return response;
	}
	
	
	public static Response DeleteUser(String Username)
	{
		Response response =given()
                   .pathParams("username",Username)
		   .when()
		       .get(Routes.delete_url);
		
		
		return response;
	}
	
	
	
	
}
