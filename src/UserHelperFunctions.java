import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class UserHelperFunctions {
    public void Options(){
        System.out.println("\nWELCOME TO ONLINE FOOD ORDERING SYSTEM\n\nEnter a option:1.User\n" +
                "               2.Hotel Owner\n" +
                "               3.Cook");
    }
    public void userFunction(Scanner sc,Map<String, Map<String,HotelInfo>> hotelRegistryInfo,
                    Map<String,Map<String,Integer>> Menu,HotelInfo hotelInfo,Map<String,HotelInfo> hotelData,
                    int orderNo,UserInfo userInfo,Map<Integer,Map<String,UserInfo>> OrderInfo,Map<Integer,ArrayList<String>> ratingAndReview){
        System.out.println("Please Enter your city");
        String city=sc.next();
        sc.nextLine();
        if(hotelRegistryInfo.containsKey(city))
        {   boolean goBackOption=false;
            hotelData=hotelRegistryInfo.get(city);
            System.out.println("Are you a old customer");
            String oldCostomer=sc.next();
            sc.nextLine();
            if(oldCostomer.equals("yes"))
            {
                System.out.println("please enter your order no");
                orderNo=sc.nextInt();
                Map<String,UserInfo> cookInfo=OrderInfo.get(orderNo);
                for(String i:cookInfo.keySet()){
                    userInfo=cookInfo.get(i);
                    if(userInfo.getOrderStatus().equals("served")){
                        System.out.println("Enter a option:1.Write a review and give a rating to the hotel\n" +
                                "               2.exit\n" +
                                "               3.Look at other hotels.\n");
                        int reviewOption=sc.nextInt();
                        switch(reviewOption){
                            case 1:{
                                System.out.println("Please enter the hotel you  ordered previously");
                                String hotelName=sc.next();
                                sc.nextLine();
                                System.out.println("Please rate your experience out of 5");
                                int rating=sc.nextInt();
                                hotelInfo=hotelData.get(hotelName);
                                ratingAndReview=hotelInfo.getRatingAndReview();
                                for(int j: ratingAndReview.keySet()){
                                    ArrayList<String> reviews=ratingAndReview.get(j);
                                    if(reviews.size()>0){
                                        rating=(rating+(j*reviews.size()))/(reviews.size()+1);
                                    }
                                    System.out.println("Please provide a review");
                                    String review=sc.next();
                                    sc.nextLine();
                                    reviews.add(review);
                                    ratingAndReview.put(rating,reviews);


                                }
                                break;

                            }
                            case 2:{

                            }
                            case 3:{}
                            default:{System.out.println("Invalid option");}
                        }
                    }
                    else{
                        System.out.println("Food Status : "+userInfo.getOrderStatus());
                    }

                }

            }
            System.out.println("Please enter your option:1.veg " +
                    "\n                         2.Non veg" +
                    "\n                         3.Exit");
            int foodServedOption=sc.nextInt();
            switch(foodServedOption){
                case 1:{
                    int count=0;
                    for(String i: hotelData.keySet()){
                        hotelInfo=hotelData.get(i);
                        if(hotelInfo.getFoodServed().equals("veg")){
                            System.out.println(i);
                            count=+1;
                        }
                    }
                    if(count==0){
                        System.out.println("Sorry :(\n NO veg hotels found in your city");
                    }
                    else{
                        System.out.println("Enter your preffered hotel name");
                        String hotelName= sc.next();
                        sc.nextLine();
                        System.out.println(Menu.get(hotelName));
                        System.out.println("Enter a option:1.place a order \n" +
                                "               2.go back\n               3.Logout");
                        int orderOption=sc.nextInt();
                        ArrayList<String> orderedItems=new ArrayList<>();
                        ArrayList<Integer> orderedQuantity=new ArrayList<>();
                        switch(orderOption){
                            case 1:{
                                boolean orderCondition=true;
                                while(orderCondition){
                                System.out.println("please select from the menu"+Menu.get(hotelName));
                                String order=sc.next();
                                orderedItems.add(order);
                                sc.nextLine();
                                System.out.println("please enter  the quantity to be ordered");
                                int quantity= sc.nextInt();
                                orderedQuantity.add(quantity);
                                System.out.println("Do you want to order more items?");
                                String OrderNext=sc.next();
                                sc.nextLine();
                                if(OrderNext.equals("no")){
                                    orderCondition=false;
                                }
                                System.out.println("Please enter mode of payment");
                                String modeOfPayment=sc.next();

                                }
                            }
                            case 2:{}
                            case 3:{}
                            default:{
                                System.out.println("Invalid option");
                            }
                        }
                    }

                }
                case 2:{

                    }
                case 3:{
                    break;
                }
                default:{
                    System.out.println("Invalid option");
                }
            }
        }
        else
        {
            System.out.println("sorry!!!Cannot find any hotels nearby :(");
            return;
        }


    }
}
