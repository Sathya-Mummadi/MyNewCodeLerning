package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.response.Response;

import io.restassured.http.ContentType;

//User End points.java
//created for perform create, Read, Update, Delete requests the user API

public class Userendpoints {
	
	 static ResourceBundle getURL(){
		ResourceBundle resource= ResourceBundle.getBundle("routes");
		return resource;
	}
	
			
   public static Response CreteEndpoints(User Payload){
	  String post_url= getURL().getString("post_url");
		Response response= given().contentType(ContentType.JSON).
				accept(ContentType.JSON).
				body(Payload).
				when().
				post(post_url);
		return response;
	}
   
  public static Response readuser(String userName){
	  String get_url= getURL().getString("get_url");
	   Response response =given().pathParam("username", userName).when().
				post(get_url);
		return response;
	}
   public static Response updateuser(String userName, User Payload){
	   String update_url=  getURL().getString("update_url");
	   
		Response response= given().contentType(ContentType.JSON).
				accept(ContentType.JSON).
				pathParam(userName, Payload).
				body(Payload).
				when().
				post(update_url);
		return response;
	}
	
	  public static Response deleteuser(String userName){ 
		   String delete_url=getURL().getString("delete_url");
		  Response response= given().pathParam("username",userName). 
	  when().delete(Routers.delete_url);
      return response; 
      }
	 
  
   }


