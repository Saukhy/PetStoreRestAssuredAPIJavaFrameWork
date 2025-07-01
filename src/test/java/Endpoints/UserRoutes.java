package Endpoints;

public class UserRoutes {

	/*Create User	POST	https://petstore.swagger.io/v2/user
Get User	GET	https://petstore.swagger.io/v2/user/{username}
Update User	PUT	https://petstore.swagger.io/v2/user/{username}
Delete User	DELETE	https://petstore.swagger.io/v2/user/{username}
*/

    public static String base_url = "https://petstore.swagger.io/v2";

    //user module urls
    public static String  userRoutespost_url = base_url + "/user";
    public static String userRoutespost_urlPost_createWaitList = base_url +"/user/createWithList";
    public static String  userRoutespost_urlget_url = base_url + "/user/{username}";
    public static String  userRoutespost_urlput_url = base_url + "/user/{username}";
    public static String  userRoutespost_urldel_url = base_url + "/user/{username}";
    public static String userRoutespost_urlget_userLogin = base_url+"/user/login";
    public static  String userRoutespost_urlget_userLogout       = base_url+"/user/logout";
    public static String  userRoutespost_urlPost_createWithArray = base_url +"/user/createWithArray";



//pet module urls



//store module urls


}