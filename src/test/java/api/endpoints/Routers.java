
package api.endpoints;
/*
 Swagger URI --> https://petstore.swagger.io
create usr(Post): https://petstore.swagger.io/v2/user
Get user(Get): https://petstore.swagger.io/v2/user/{username}
Update user(put): https://petstore.swagger.io/v2/user/{username}
Delete user(Delete): https://petstore.swagger.io/v2/user/{username}
 */

public class Routers {
	public static String base_url="https://petstore.swagger.io/v2";
	
	//User Module
	public static String post_url= base_url+"/user";
	public static String get_url= base_url+"/user/{username}";
	public static String update_url = base_url+"/user/{username}";
	public static String delete_url =base_url+"/user/{username}";
	
	//Store Module
	   // here we will for store module URLs
	//pet module
	  // here we will create pet module URL
	

}
