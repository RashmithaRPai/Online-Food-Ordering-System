import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HotelHelperFunctions {
    public void HotelOption(HotelRegisteredOnApp hotelRegisteredOnApp,CookInfo cook,Scanner sc,Map<String,Map<String,HotelInfo>> appHotelRegistry,Map<String, ArrayList<UserInfo>> hotelRegistryInfo,HotelInfo hotelInfo,Menu menu,UserInfo userInfo)
    {
        System.out.println("Is your hotel registered on the app?:yes/No");
        String hotelOnApp=sc.next();
        if(hotelOnApp.equals("yes")){
            System.out.println("Please enter the city the hotel is located:");
            String city=sc.next();
            System.out.println("Please enter your hotel name:");
            String hotelName=sc.next();
            Map<String,HotelInfo> HotelInfoMap=appHotelRegistry.get(city);
            hotelInfo=HotelInfoMap.get(hotelName);
            System.out.println("Enter a option:1.Update the menu\n               2.Check reviews\n" +
                    "               3.Check all orders Status\n               4.Hire a cook\n" +
                    "               5.Check cooks status\n               6.Check Backlog orders\n" +
                    "               7.exit");
            sc.nextLine();
            int hotelOptions=sc.nextInt();
            switch (hotelOptions){
                case 1:{
                    updateMenu(hotelName,city,sc,hotelInfo, hotelRegisteredOnApp.getAppHotelRegistry(), menu);
                    break;
                    }
                case 2:{
                    checkReviews(sc,hotelInfo);
                    break;
                }
                case 3:{
                    orderStatus(sc,hotelInfo,hotelRegistryInfo,userInfo);
                    break;
                }
                case 4:{
                    hireCook(sc,cook,hotelInfo,userInfo,hotelRegistryInfo);
                    break;

                }
                case 5:{
                    cookStatus(sc,cook,hotelInfo,userInfo);
                    break;
                }
                case 6:{
                    backLogOrders(sc,cook,hotelInfo,userInfo);
                    break;

                    }
                case 7:{
                    break;
                }
                default:{
                    System.out.println("Invalid Option");
                    break;
                }
            }
        }
        else
        {
            appHotelRegistry=hotelRegisteredOnApp.getAppHotelRegistry();
            Map<String,HotelInfo> hotelInfoMap=new HashMap<>();
            System.out.println("Please enter the city the hotel is located:");
            String city=sc.next();
            if(hotelRegisteredOnApp.getAppHotelRegistry().containsKey(city)){
                hotelInfoMap=hotelRegisteredOnApp.getAppHotelRegistry().get(city);
            }
            //if(appHotelRegistry.containsKey(city))
            System.out.println("Please enter your hotel name:");
            String hotelName=sc.next();

            System.out.println("Please enter the type of food served veg/nonveg:");
            String typeOfFoodServed=sc.next();
            Map<String,Map<String,Integer>> Menu=new HashMap<>();
            Map<String,Integer> items;
            System.out.println("Please enter some items into menu");
            boolean addMenu=true;
            while(addMenu) {
                System.out.println("Please enter a category");
                String category=sc.next();
                if(Menu.containsKey(category)){
                    items=Menu.get(category);
                }
                else{
                    items=new HashMap<>();
                }
                System.out.println("Enter the item name");
                String itemName=sc.next();
                sc.nextLine();
                System.out.println("Enter the price");
                int price=sc.nextInt();
                items.put(itemName,price);
                Menu.put(category,items);
                System.out.println("Do you wanna add more items into menu");
                String moreItems=sc.next();
                if(moreItems.equals("no")){
                    addMenu=false;
                }
            }
            menu=new Menu(Menu);
            Map<Integer, ArrayList<String>> ratingAndReview=null;
            hotelRegistryInfo=null;
            hotelInfo=new HotelInfo(hotelName,city,menu,typeOfFoodServed,ratingAndReview,cook);
            hotelInfoMap.put(hotelName,hotelInfo);
            appHotelRegistry.put(city,hotelInfoMap);
            hotelRegisteredOnApp=new HotelRegisteredOnApp(appHotelRegistry, hotelRegistryInfo);
        }
            hotelRegisteredOnApp=new HotelRegisteredOnApp(appHotelRegistry, hotelRegistryInfo);
    }
    public void updateMenu(String hotelName,String city,Scanner sc,HotelInfo hotelInfo,Map<String,Map<String,HotelInfo>> appHotelRegistry,Menu menu){
        boolean addMenu=true;
        menu=hotelInfo.getMainMenu();
        Map<String,Map<String,Integer>> Menu=menu.getMenu();
        Map<String,Integer> items;
        while(addMenu) {
            System.out.println("Please enter a category");
            String category = sc.next();
            if (Menu.containsKey(category)) {
                items = Menu.get(category);
            } else {
                items = new HashMap<>();
            }
            System.out.println("Enter the item name");
            String itemName = sc.next();
            sc.nextLine();
            System.out.println("Enter the price");
            int price = sc.nextInt();
            items.put(itemName, price);
            Menu.put(category, items);
            System.out.println("Do you wanna add more items into menu");
            String moreItems = sc.next();
            if (moreItems.equals("no")) {
                addMenu = false;
            }
        }
        menu=new Menu(Menu);
        hotelInfo.setMainMenu(menu);


    }
    public void checkReviews(Scanner sc,HotelInfo hotelInfo) {
        if (hotelInfo.getRatingAndReview() == null) {
            System.out.println("Sorry :( "+hotelInfo.getHotelName()+" has no reviews yet");
        }
        else
        {
            System.out.println("Reviews of " + hotelInfo.getHotelName());
            Map<Integer, ArrayList<String>> ratingAndReview = hotelInfo.getRatingAndReview();
            ArrayList<String> reviews = new ArrayList<>();
            for (int i : ratingAndReview.keySet()) {
                reviews = ratingAndReview.get(i);

            }
            System.out.println(reviews);

        }
    }
    public void orderStatus(Scanner sc,HotelInfo hotelInfo,Map<String, ArrayList<UserInfo>> hotelRegistryInfo,UserInfo userInfo){
       ArrayList<UserInfo> userInfoList=hotelRegistryInfo.get(hotelInfo.getHotelName());
       if(userInfoList==null)
       {
           System.out.println("sorry:( "+hotelInfo.getHotelName()+"has no current orders yet");
       }
       else
       {
           for(int i=0;i<userInfoList.size();i++)
           {
               userInfo=userInfoList.get(i);
               System.out.println("Orderno : "+userInfo.getOrderNumber()+",order status : "+userInfo.getOrderStatus());
           }
       }

    }
    public void hireCook(Scanner sc,CookInfo cookInfo,HotelInfo hotelInfo,UserInfo userInfo,Map<String, ArrayList<UserInfo>> hotelRegistryInfo)
    {
        boolean addCook=true;
        Map<Integer, UserInfo> userId=null;
        Map<String, ArrayList<String>> cooksInHotel = cookInfo.getCooksInHotel();
        ArrayList<String> cooks=new ArrayList<>();
        while(addCook) {
            System.out.println("Print cook name");
            String cookName = sc.next();
            if (cooksInHotel.containsKey(hotelInfo.getHotelName()))
            {
                cooks=cooksInHotel.get(hotelInfo.getHotelName());
            }
            cooks.add(cookName);
            cooksInHotel.put(hotelInfo.getHotelName(),cooks);
            cookInfo.setCooksInHotel(cooksInHotel);
            System.out.println("Do you want to add more cooks:");
            String addMore=sc.next();
            if(addMore.equals("no"))
            {
                addCook=false;
            }
            cookInfo.setCooksInHotel(cooksInHotel);

        }
        ArrayList<UserInfo> userInfoList=hotelRegistryInfo.get(hotelInfo.getHotelName());
        hotelInfo.setCook(cookInfo);
        String cookNm=null;
        if(cookInfo.getCookHandelingUserInfo()==null) {
            Map<String, Map<Integer, UserInfo>> cookHandelingUserInfo = new HashMap<>();
            int cookLimit = cooks.size();
            int userInfoLimit = userInfoList.size();
            if (cooks.size() > userInfoList.size()) {
                while (userInfoLimit > 0) {
                     userInfoLimit=userInfoLimit-1;
                     for(int i=0;i<cooks.size();i++){
                         cookNm=cooks.get(i);
                         userInfo=userInfoList.get(i);
                         userInfo.setOrderStatus("Preparing");
                         userId=new HashMap<>();
                         userId.put(userInfo.getOrderNumber(),userInfo);
                     }

                }
            }
            else
            {
              while(cookLimit>0){
                  cookLimit=cookLimit-1;
                  for(int i=0;i<userInfoList.size();i++){
                      userInfo=userInfoList.get(i);
                      cookNm=cooks.get(i);
                      userId=new HashMap<>();
                      userId.put(userInfo.getOrderNumber(),userInfo);
                      cookHandelingUserInfo.put(cookNm,userId);


                  }

              }
              for(int i=cooks.size()-1;i<userInfoList.size();i++){
                  userInfo=userInfoList.get(i);
                  userInfo.setOrderStatus("TBD");
              }
            }
            cookHandelingUserInfo.put(cookNm,userId);
        }
        else
        {
            cookInfo=hotelInfo.getCook();
            Map<String,Map<Integer,UserInfo>> cookHandelingUserInfo=cookInfo.getCookHandelingUserInfo();
            ArrayList<String> cooksList=cookInfo.getCooksInHotel().get(hotelInfo.getHotelName());
            ArrayList<String> cooksAvailable=new ArrayList<>();
            for(int i=0;i<cooksList.size();i++){
                if(cookHandelingUserInfo.containsKey(cooksList.get(i)))
                {
                    Map<Integer,UserInfo> User=cookHandelingUserInfo.get(cooksList.get(i));
                    for(int u:User.keySet()){
                        userInfo=User.get(u);
                        if(userInfo.getOrderStatus().equals("served"))
                        {
                            cookHandelingUserInfo.remove(cooksList.get(i));
                            cooksAvailable.add(cooksList.get(i));
                        }
                    }
                }
                else
                {
                    cooksAvailable.add(cooksList.get(i));
                }
            }
            for(int i=0;i<userInfoList.size();i++) {
                while (cooksAvailable.size() > 0) {
                    userInfo = userInfoList.get(i);
                    if (userInfo.getOrderStatus().equals("TBD")) {
                        for (int j = 0; j < cooksAvailable.size(); j++) {
                            Map<Integer, UserInfo> User = new HashMap<>();
                            userInfo.setOrderStatus("preparing");
                            User.put(userInfo.getOrderNumber(), userInfo);
                            cookHandelingUserInfo.put(cooksAvailable.get(i), User);
                            cooksAvailable.remove(cooksAvailable);
                        }
                    }
                }
            }

        }


    }
    public void cookStatus(Scanner sc,CookInfo cook,HotelInfo hotelInfo,UserInfo userInfo) {
        cook = hotelInfo.getCook();
        Map<String, Map<Integer, UserInfo>> cookHandelingUserInfo = cook.cookHandelingUserInfo;
        if (cookHandelingUserInfo == null) {
            System.out.println("No cooks available :(");
        }
        else
        {
        System.out.println("Order Status:");
        for (String i : cookHandelingUserInfo.keySet()) {
            Map<Integer, UserInfo> user = cookHandelingUserInfo.get(i);
            for (int j : user.keySet()) {
                userInfo = user.get(j);
                System.out.println("Order No : " + userInfo.getOrderNumber() + " Order Status : " + userInfo.getOrderStatus());
            }
        }
    }
    }
    public void backLogOrders(Scanner sc,CookInfo cook,HotelInfo hotelInfo,UserInfo userInfo) {
        System.out.println("Enter a option:1..See order status which is yet to be done\\n               2.Name of cook\\n\" +\n" +
                "                    \"               3.exit");
        int option = sc.nextInt();
        cook = hotelInfo.getCook();
        Map<String, Map<Integer, UserInfo>> cookHandelingUserInfo = cook.getCookHandelingUserInfo();
        if (cookHandelingUserInfo == null) {
            System.out.println("No cooks available :(");
        }
        else {
            switch (option) {
                case 1: {
                    for (String i : cookHandelingUserInfo.keySet()) {
                        Map<Integer, UserInfo> user = cookHandelingUserInfo.get(i);
                        for (int j = 0; j < user.size(); j++) {
                            userInfo = user.get(j);
                            System.out.println("Order No : " + userInfo.getOrderNumber() + " Order Status : " + userInfo.getOrderStatus());
                        }
                    }
                    break;
                }
                case 2: {
                    for (String i : cookHandelingUserInfo.keySet()) {
                        Map<Integer, UserInfo> user = cookHandelingUserInfo.get(i);
                        for (int j = 0; j < user.size(); j++) {
                            userInfo = user.get(j);
                            System.out.println("Order No : " + userInfo.getOrderNumber() + " Cook name " + i);
                        }
                    }
                    break;
                }
                case 3: {
                    break;
                }
                default: {
                    System.out.println("Invalid option");
                    break;
                }
            }
        }
        }
}
