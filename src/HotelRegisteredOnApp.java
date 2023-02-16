import java.util.Map;

public class HotelRegisteredOnApp {
    //String->city
    Map<String,Map<String,HotelInfo>> hotelRegistryInfo;


    public Map<String, Map<String, HotelInfo>> getHotelRegistryInfo() {
        return hotelRegistryInfo;
    }

    public void setHotelRegistryInfo(Map<String, Map<String, HotelInfo>> hotelRegistryInfo) {
        this.hotelRegistryInfo = hotelRegistryInfo;
    }


    public HotelRegisteredOnApp(Map<String, Map<String, HotelInfo>> hotelRegistryInfo) {
        this.hotelRegistryInfo = hotelRegistryInfo;
    }
}
