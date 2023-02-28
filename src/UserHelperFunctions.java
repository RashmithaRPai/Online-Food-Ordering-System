import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserHelperFunctions {
    public void Options(){
        System.out.println("\nWELCOME TO ONLINE FOOD ORDERING SYSTEM\n\nEnter a option:1.User\n" +
                "               2.Hotel Owner\n" +
                "               3.Cook");
    }

    public void user(HotelRegisteredOnApp hotelRegisteredOnApp,int orderId,Scanner sc,ArrayList<Integer> IncompleteorderNo,Map<Integer,Map<HotelInfo,UserInfo>> OrderInfoMap,HotelInfo hotelInfo,UserInfo userInfo)
    {

            System.out.println("Are you a existing user?");
            String existingUser = sc.next();
            if (existingUser.equals("yes")) {
                System.out.println("Enter your order Id");
                sc.nextLine();
                orderId = sc.nextInt();
                if (IncompleteorderNo.contains(orderId)) {
                    oldUser(sc, IncompleteorderNo, OrderInfoMap, orderId, hotelInfo, userInfo);
                } else {
                    System.out.println("Thankyou for using the app");
                }
            }
            else
            {
                newUser(sc,hotelRegisteredOnApp.getAppHotelRegistry(),hotelInfo,orderId,userInfo,hotelRegisteredOnApp.getHotelRegistryInfo());

            }

    }
    public void oldUser(Scanner sc,ArrayList<Integer> IncompleteorderNo,Map<Integer,Map<HotelInfo,UserInfo>> OrderInfoMap,int orderId,HotelInfo hotelInfo,UserInfo userInfo) {
        if(OrderInfoMap.containsKey(orderId))
        {
        Map<HotelInfo, UserInfo> hotelUserMap = OrderInfoMap.get(orderId);
        for (HotelInfo i : hotelUserMap.keySet()) {
            hotelInfo = i;
            userInfo = hotelUserMap.get(i);
            if (userInfo.getOrderStatus().contains("served")) {
                System.out.println("Whould you like to rate your experience");
                String experience = sc.next();
                sc.nextLine();
                if (experience.contains("yes")) {
                    Map<Integer, ArrayList<String>> ratingAndReview = hotelInfo.getRatingAndReview();
                    int rate = 0;
                    ArrayList<String> reviews = new ArrayList<>();
                    if (ratingAndReview.size() < 1) {
                        for (int j : ratingAndReview.keySet()) {
                            System.out.println("Please rate out of 5");
                            rate = sc.nextInt();
                            System.out.println("PLease provide a review");
                            String review = sc.next();
                            reviews = ratingAndReview.get(j);
                            reviews.add(review);
                            sc.nextLine();
                            rate = (rate + (j * ratingAndReview.get(j).size())) / (ratingAndReview.get(j).size() + 1);

                        }
                        IncompleteorderNo.remove(orderId);
                    }
                    else
                    {
                        System.out.println("Please rate out of 5");
                        rate = sc.nextInt();
                        System.out.println("PLease provide a review");
                        String review = sc.next();
                        sc.nextLine();
                        reviews = new ArrayList<>();
                        reviews.add(review);
                    }
                    ratingAndReview.put(rate, reviews);
                    System.out.println("Thankyou for your ratings");
                    IncompleteorderNo.remove(orderId);
                }
                else
                {
                    IncompleteorderNo.remove(orderId);
                }
            } else {
                System.out.println("Your order status is : " + userInfo.getOrderStatus());
            }
        }
    }
        else
        {
            System.out.println("No previously placed order ....please place new order");
        }

    }
    public void newUser(Scanner sc,Map<String,Map<String,HotelInfo>> appHotelRegistry,HotelInfo hotelInfo,int orderNo,UserInfo userInfo,Map<String, ArrayList<UserInfo>> hotelRegistryInfo){
        System.out.println("Please enter your address city");
        String city=sc.next();
        System.out.println("Enter a option:1.veg\n               2.Non veg\n               3.exit");
        sc.nextLine();
        int foodPreference=sc.nextInt();
        System.out.println(appHotelRegistry.get("udupi"));
        switch (foodPreference){
            case 1:{
                boolean food=true;

                    if(appHotelRegistry.containsKey(city)){
                    Map<String,HotelInfo> HotelInfoMap=appHotelRegistry.get(city);

                    for(String i:HotelInfoMap.keySet())
                    {
                        hotelInfo=HotelInfoMap.get(i);
                        if(hotelInfo.getFoodServed().equals("veg"))
                        {
                            System.out.println(i);
                            food=false;
                        }
                    }
                if(food){
                    System.out.println("No veg hotels found nearby :(");
                }
                else{
                    System.out.println("Please choose a hotel name from above list");
                    String hotelName=sc.next();
                    sc.nextLine();
                    System.out.println("Enter a option:1.Look at menu\n               2.choose another hotel\n               3.exit");
                    int option=sc.nextInt();
                    switch (option){
                        case 1:{
                            hotelInfo=appHotelRegistry.get(city).get(hotelName);
                            System.out.println("Please choose from the menu\n"+hotelInfo.getMainMenu());
                            boolean orderNext=true;
                            ArrayList<String> orderedItems=new ArrayList<>();
                            ArrayList<Integer> orderedQuantity=new ArrayList<>();
                            while(orderNext){
                            System.out.println("Please select a food item");
                            String orderItem=sc.next();
                            orderedItems.add(orderItem);
                            sc.nextLine();
                            System.out.println("Mention the quantity");
                            int quantity=sc.nextInt();
                            orderedQuantity.add(quantity);
                                System.out.println("Do you want to order more?");
                                String orderMore=sc.next();
                                if(orderMore.equals("no")){
                                    orderNext=false;
                                }
                        }
                            System.out.println("Enter mode of payment");
                            String modeOfPayment=sc.next();
                            sc.nextLine();
                            String orderStatus="in queue";
                            userInfo=new UserInfo(orderedItems,orderedQuantity,orderNo,modeOfPayment,orderStatus);
                            if(hotelRegistryInfo.containsKey(hotelName)){
                            ArrayList<UserInfo> userDataOfTheHotel=hotelRegistryInfo.get(hotelName);
                            userDataOfTheHotel.add(userInfo);
                            hotelRegistryInfo.put(hotelName,userDataOfTheHotel);
                            }
                            else{
                                ArrayList<UserInfo> userDataOfTheHotel=new ArrayList<>();
                                userDataOfTheHotel.add(userInfo);
                                hotelRegistryInfo.put(hotelName,userDataOfTheHotel);
                            }
                            break;

                        }
                        case 2:{
                            newUser(sc,appHotelRegistry,hotelInfo,orderNo, userInfo,hotelRegistryInfo);
                            break;
                            }
                        case 3:{break;}
                        default:{
                            System.out.println("Invalid option");
                        }
                    }
                }
                orderNo=orderNo+1;
                break;
                    }
                    else
                    {
                        System.out.println("No hotels open in your city");
                        break;
                    }

            }
            case 2:{
                boolean food=true;

                if(appHotelRegistry.containsKey(city)){
                    Map<String,HotelInfo> HotelInfoMap=appHotelRegistry.get(city);

                    for(String i:HotelInfoMap.keySet())
                    {
                        hotelInfo=HotelInfoMap.get(i);
                        if(hotelInfo.getFoodServed().equals("nonveg"))
                        {
                            System.out.println(i);
                            food=false;
                        }
                    }

                }
                if(food){
                    System.out.println("No Non veg hotels found nearby :(");
                }
                else{
                    System.out.println("Please choose a hotel name from above list");
                    String hotelName=sc.next();
                    sc.nextLine();
                    System.out.println("Enter a option:1.Look at menu\n               2.choose another hotel\n               3.exit");
                    int option=sc.nextInt();
                    switch (option){
                        case 1:{
                            hotelInfo=appHotelRegistry.get(city).get(hotelName);
                            System.out.println("Please choose from the menu\n"+hotelInfo.getMainMenu());
                            boolean orderNext=true;
                            ArrayList<String> orderedItems=new ArrayList<>();
                            ArrayList<Integer> orderedQuantity=new ArrayList<>();
                            while(orderNext){
                                System.out.println("Please select a food item");
                                String orderItem=sc.next();
                                orderedItems.add(orderItem);
                                sc.nextLine();
                                System.out.println("Mention the quantity");
                                int quantity=sc.nextInt();
                                orderedQuantity.add(quantity);
                                System.out.println("Do you want to order more?");
                                String orderMore=sc.next();
                                if(orderMore.equals("no")){
                                    orderNext=false;
                                }
                            }
                            System.out.println("Enter mode of payment");
                            String modeOfPayment=sc.next();
                            sc.nextLine();
                            String orderStatus="in queue";
                            userInfo=new UserInfo(orderedItems,orderedQuantity,orderNo,modeOfPayment,orderStatus);
                            if(hotelRegistryInfo.containsKey(hotelName)){
                                ArrayList<UserInfo> userDataOfTheHotel=hotelRegistryInfo.get(hotelName);
                                userDataOfTheHotel.add(userInfo);
                                hotelRegistryInfo.put(hotelName,userDataOfTheHotel);
                            }
                            else{
                                ArrayList<UserInfo> userDataOfTheHotel=new ArrayList<>();
                                userDataOfTheHotel.add(userInfo);
                                hotelRegistryInfo.put(hotelName,userDataOfTheHotel);
                            }
                            break;
                        }

                        case 2:{
                            newUser(sc,appHotelRegistry,hotelInfo,orderNo, userInfo,hotelRegistryInfo);
                            break;
                        }
                        case 3:{break;}
                        default:{
                            System.out.println("Invalid option");
                        }
                    }
                }
                orderNo=orderNo+1;
                break;

            }
            case 3:{break;}
            default:{
                System.out.println("Invalid option");
            }
        }
    }



}
