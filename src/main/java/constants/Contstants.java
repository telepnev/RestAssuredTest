package constants;
public class Contstants {

    public static class RunVeriable {
        public static String server = Servers.PlacesHolder_URL;
        public static String path = "";

    }
    public static class Servers {
        public static String PlacesHolder_URL = "https://jsonplaceholder.typicode.com/";
        public static String SWAPI_URL = "https://swapi.dev/";
        public static String GOOGLE_PLACES_URL;



    }
    public static class PATH {
        public static String SWAPI_PATH = "";
        public static String GOOGLE_PLACES_PATH;
    }
    public static class Actions {
        //swapi
        public static String SWAPI_GET_PEOPLE = "people/";

        //google
        public static String GOOGLE_PLACES_ACTIONS;
        // PlacesHolder
        public static String PlacesHolder_GET = "comments/";

    }
}
