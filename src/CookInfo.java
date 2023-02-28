import java.util.ArrayList;
import java.util.Map;

public class CookInfo {
    //String->hotel,arr=cookList
    Map<String,ArrayList<String>> cooksInHotel;
    //string=cookname
    Map<String,Map<Integer,UserInfo>> cookHandelingUserInfo;




    public Map<String, ArrayList<String>> getCooksInHotel() {
        return cooksInHotel;
    }

    public void setCooksInHotel(Map<String, ArrayList<String>> cooksInHotel) {
        this.cooksInHotel = cooksInHotel;
    }

    public Map<String, Map<Integer, UserInfo>> getCookHandelingUserInfo() {
        return cookHandelingUserInfo;
    }

    public void setCookHandelingUserInfo(Map<String, Map<Integer, UserInfo>> cookHandelingUserInfo) {
        this.cookHandelingUserInfo = cookHandelingUserInfo;
    }

    public CookInfo( Map<String, ArrayList<String>> cooksInHotel, Map<String, Map<Integer, UserInfo>> cookHandelingUserInfo) {

        this.cooksInHotel = cooksInHotel;
        this.cookHandelingUserInfo = cookHandelingUserInfo;
    }

    @Override
    public String toString() {
        return "CookInfo{" +
                "cooksInHotel=" + cooksInHotel +
                ", cookHandelingUserInfo=" + cookHandelingUserInfo +
                '}';
    }
}
