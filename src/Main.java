import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String [] arg){
        Scanner sc=new Scanner(System.in);
        CookHelperFunctions cookHelper=new CookHelperFunctions();
        HotelHelperFunctions hotelHelper=new HotelHelperFunctions();
        UserHelperFunctions userHelper=new UserHelperFunctions();
        Map<String, Map<String,HotelInfo>> hotelRegistryInfo=new HashMap<>();
        HotelRegisteredOnApp HotelRegisteredOnApp=new HotelRegisteredOnApp(hotelRegistryInfo);
        HotelInfo hotelInfo;
        UserInfo userInfo;
        //String->food category
        Map<String,Integer> foodItems;
        //String->hotelName
        Map<String,Map<String,Integer>> Menu=new HashMap<>();
        //string->hotelname
        Map<String,HotelInfo> hotelData ;
        boolean exitOption=false;
        int orderNo=1;

        while (true){
            userHelper.Options();
            int option=sc.nextInt();
            switch(option){
                case 1:{

                }
                case 2:{}
                case 3:{}
                default:
                {
                    cookHelper.defaultCase();
                }
            }
        }
    }
}