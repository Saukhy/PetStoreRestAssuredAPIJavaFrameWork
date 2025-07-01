package Utils;

import java.util.ResourceBundle;

public class RouteBundle {

    public static ResourceBundle getURL()
    {
        ResourceBundle routes = ResourceBundle.getBundle("Routes");//load Routes.properties
        return routes;
    }
}
