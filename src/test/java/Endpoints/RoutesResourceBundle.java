package Endpoints;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class RoutesResourceBundle {

     static ResourceBundle getUrl()
    {
        ResourceBundle routes = ResourceBundle.getBundle("Routes");
        return routes;
    }
}
