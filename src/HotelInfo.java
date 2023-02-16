import java.util.ArrayList;
import java.util.Map;

public class HotelInfo {
    private String hotelName;
    private String hotelCity;
    //veg or nonveg food served
    private String foodServed;
    //string
    Map<Integer,ArrayList<String>> ratingAndReview;

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

    public HotelInfo(String hotelName, String hotelCity, String foodServed, Map<Integer, ArrayList<String>> ratingAndReview) {
        this.hotelName = hotelName;
        this.hotelCity = hotelCity;
        this.foodServed = foodServed;
        this.ratingAndReview = ratingAndReview;
    }
}
