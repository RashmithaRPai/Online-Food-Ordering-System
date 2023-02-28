import java.util.ArrayList;
import java.util.Map;

public class HotelInfo {
    private String hotelName;
    private String hotelCity;
    //veg or nonveg food served
    private String foodServed;
    Menu mainMenu;
    CookInfo cook;

    //string
    Map<Integer,ArrayList<String>> ratingAndReview;

    public Menu  getMainMenu() {
        return mainMenu;
    }

    public void setMainMenu(Menu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelCity() {
        return hotelCity;
    }

    public void setHotelCity(String hotelCity) {
        this.hotelCity = hotelCity;
    }

    public String getFoodServed() {
        return foodServed;
    }

    public void setFoodServed(String foodServed) {
        this.foodServed = foodServed;
    }

    public Map<Integer, ArrayList<String>> getRatingAndReview() {
        return ratingAndReview;
    }

    public void setRatingAndReview(Map<Integer, ArrayList<String>> ratingAndReview) {
        this.ratingAndReview = ratingAndReview;
    }

    public CookInfo getCook() {
        return cook;
    }

    public void setCook(CookInfo cook) {
        this.cook = cook;
    }

    public HotelInfo(String hotelName, String hotelCity, Menu mainMenu, String foodServed, Map<Integer, ArrayList<String>> ratingAndReview,CookInfo cook) {
        this.hotelName = hotelName;
        this.hotelCity = hotelCity;
        this.foodServed = foodServed;
        this.ratingAndReview = ratingAndReview;
        this.mainMenu=mainMenu;
        this.cook = cook;
    }

    @Override
    public String toString() {
        return "{" +
                ", hotelCity='" + hotelCity + '\'' +
                ", foodServed='" + foodServed + '\'' +
                ", mainMenu=" + mainMenu +
                ", cook=" + cook +
                ", ratingAndReview=" + ratingAndReview +
                '}';
    }
}
