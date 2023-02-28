import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String [] arg){
        Scanner sc=new Scanner(System.in);
        CookHelperFunctions cookHelper=new CookHelperFunctions();
        HotelHelperFunctions hotelHelper=new HotelHelperFunctions();
        UserHelperFunctions userHelper=new UserHelperFunctions();
        //record of every order wrt order no
        Map<Integer,Map<HotelInfo,UserInfo>> OrderInfo=new HashMap<>();

        Map<String, Map<String,HotelInfo>> appHotelRegistryInfo=new HashMap<>();
        Map<String,ArrayList<String>> cooksInHotel=new HashMap<>();
        Map<String,Map<Integer,UserInfo>> cookHandelingUserInfo=new HashMap<>();
        ArrayList<String> cooksList=null;
        CookInfo cookInfo=new CookInfo(cooksInHotel,cookHandelingUserInfo);
        HotelInfo hotelInfo=null;
        UserInfo userInfo=null;
        Map<Integer,Map<HotelInfo,UserInfo>> OrderInfoMap=new HashMap<>();//OrderInfo
        ArrayList<Integer> IncompleteorderNo=new ArrayList<>();
        OrderInfo orderInfo=new OrderInfo(OrderInfoMap,IncompleteorderNo);
        //String->food category
        Map<String,Integer> foodItems;
        Map<String,ArrayList<UserInfo>>  hotelRegistry=null;///hotelRegistry

        HotelRegisteredOnApp HotelRegisteredOnApp=new HotelRegisteredOnApp(appHotelRegistryInfo, hotelRegistry);
        //String->hotelName
        Map<String,Map<String,Integer>> Menu=new HashMap<>();
        Menu menu=new Menu(Menu);
        //string->hotelname
        Map<String,HotelInfo> hotelData ;
        int orderNo=1;
            while (true) {
                userHelper.Options();
                int option = sc.nextInt();
                switch (option) {
                    case 1: {
                        userHelper.user(HotelRegisteredOnApp,orderNo,sc,orderInfo.getIncompleteorderNo(),orderInfo.getOrderInfoMap(),hotelInfo,userInfo);
                        break;
                    }
                    case 2: {
                        hotelHelper.HotelOption(HotelRegisteredOnApp,cookInfo,sc,HotelRegisteredOnApp.getAppHotelRegistry(),HotelRegisteredOnApp.getHotelRegistryInfo(),hotelInfo,menu,userInfo);
                        break;
                    }
                    case 3: {
                        cookHelper.cookOption(sc,cookInfo,hotelInfo,userInfo,HotelRegisteredOnApp);
                        break;
                        }
                    default: {
                        cookHelper.defaultCase();
                        break;
                    }
                }
            }

    }
}