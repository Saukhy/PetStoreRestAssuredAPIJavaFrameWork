package Endpoints;

public class UserRoutes {

	/*Create User	POST	https://petstore.swagger.io/v2/user
Get User	GET	https://petstore.swagger.io/v2/user/{username}
Update User	PUT	https://petstore.swagger.io/v2/user/{username}
Delete User	DELETE	https://petstore.swagger.io/v2/user/{username}
*/

    public static String base_url = "https://petstore.swagger.io/v2";

    //user module urls
    public static String  post_url = base_url + "/user";
    public static String Post_createWaitList = base_url +"/user/createWithList";
    public static String  get_url = base_url + "/user/{username}";
    public static String  put_url = base_url + "/user/{username}";
    public static String  del_url = base_url + "/user/{username}";
    public static String get_userLogin = base_url+"/user/login";
    public static  String get_userLogout = base_url+"/user/logout";
    public static String Post_createWithArray = base_url +"/user/createWithArray";



//pet module urls



//store module urls


}