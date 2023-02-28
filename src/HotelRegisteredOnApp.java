import java.util.ArrayList;
import java.util.Map;

public class HotelRegisteredOnApp {
    //String->city
    Map<String,Map<String,HotelInfo>> appHotelRegistry;
    //String=hotelName
    Map<String, ArrayList<UserInfo>> hotelRegistryInfo;

    public Map<String, Map<String, HotelInfo>> getAppHotelRegistry() {
        return appHotelRegistry;
    }

    public void setAppHotelRegistry(Map<String, Map<String, HotelInfo>> appHotelRegistry) {
        this.appHotelRegistry = appHotelRegistry;
    }

    public Map<String, ArrayList<UserInfo>> getHotelRegistryInfo() {
        return hotelRegistryInfo;
    }

    public void setHotelRegistryInfo(Map<String, ArrayList<UserInfo>> hotelRegistryInfo) {
        this.hotelRegistryInfo = hotelRegistryInfo;
    }

    public HotelRegisteredOnApp(Map<String, Map<String, HotelInfo>> appHotelRegistry, Map<String, ArrayList<UserInfo>> hotelRegistryInfo) {
        this.appHotelRegistry = appHotelRegistry;
        this.hotelRegistryInfo = hotelRegistryInfo;
    }
}
