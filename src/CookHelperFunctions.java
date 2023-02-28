import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CookHelperFunctions {
    public void defaultCase(){
        System.out.println("Please enter an valid option");
    }
    public void cookOption(Scanner sc,CookInfo cookInfo,HotelInfo hotelInfo,UserInfo userInfo,HotelRegisteredOnApp hotelRegisteredOnApp) {
        if (hotelRegisteredOnApp.getHotelRegistryInfo() == null)
        {
            System.out.println("No hotels found............. Please try after some time!!...............");
        }
        else
        {
            System.out.println("Enter the city of hotel location");
            String city = sc.next();
            System.out.println("Enter the hotel name");
            String hotelName = sc.next();
            ArrayList<String> cooksAvailable = new ArrayList<>();
            Map<String, Map<String, HotelInfo>> appHotelRegistry = hotelRegisteredOnApp.getAppHotelRegistry();
            hotelInfo = appHotelRegistry.get(city).get(hotelName);
            cookInfo = hotelInfo.getCook();
            Map<String, Map<Integer, UserInfo>> cookHandelingUserInfo = cookInfo.getCookHandelingUserInfo();
            System.out.println("Enter the cook name to change order status\nCooks handeling orders are : ");
            for (String i : cookHandelingUserInfo.keySet()) {
                System.out.print(i + ",");
            }
            String cookName = sc.next();
            sc.nextLine();
            int cookHandelingUserInfoSize = cookHandelingUserInfo.size();

            Map<String, ArrayList<String>> cooksInHotel = cookInfo.getCooksInHotel();
            int cooksInHotelSize = cooksInHotel.get(hotelName).size();
            for (int i = 0; i < cooksInHotel.get(hotelName).size(); i++) {
                if (cooksInHotel.get(hotelName).size() > cookHandelingUserInfo.size()) {
                    while (cookHandelingUserInfoSize > 0) {
                        cookHandelingUserInfoSize = cookHandelingUserInfoSize - 1;
                        if (cookHandelingUserInfo.containsKey(cooksInHotel.get(hotelName).get(i))) {
                            Map<Integer, UserInfo> user = cookHandelingUserInfo.get(cooksInHotel.get(hotelName).get(i));
                            for (int j = 0; j < user.size(); j++) {
                                userInfo = user.get(i);
                                if (userInfo.getOrderStatus().equals("done")) {
                                    cooksAvailable.add(cooksInHotel.get(hotelName).get(i));
                                    cookHandelingUserInfo.remove(cooksInHotel.get(hotelName).get(i));

                                }
                            }

                        }
                    }
                } else {
                    while (cooksInHotelSize > 0) {
                        cooksAvailable.add(cooksInHotel.get(hotelName).get(i));
                    }
                }
            }
            Map<String, ArrayList<UserInfo>> hotelRegistryInfo = hotelRegisteredOnApp.getHotelRegistryInfo();
            ArrayList<UserInfo> user = hotelRegistryInfo.get(hotelName);
            if (user.size() > 0) {
                for (int i = 0; i < user.size(); i++) {
                    while (cooksAvailable.size() > 0) {
                        userInfo = user.get(i);
                        if (userInfo.getOrderStatus().equals("TBD")) {
                            Map<Integer, UserInfo> cookUserInfoMap = new HashMap<>();
                            cookUserInfoMap.put(userInfo.getOrderNumber(), userInfo);
                            cookHandelingUserInfo.put(cooksAvailable.get(i), cookUserInfoMap);
                            cooksAvailable.remove(i);
                        }
                    }
                }
            } else {
                System.out.println("Invalid option");
            }

        }
    }
}
