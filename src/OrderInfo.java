import java.util.ArrayList;
import java.util.Map;

public class OrderInfo {
    //Integer->orderno
    Map<Integer,Map<HotelInfo,UserInfo>> OrderInfoMap;
    ArrayList<Integer> IncompleteorderNo;

    public Map<Integer, Map<HotelInfo, UserInfo>> getOrderInfoMap() {
        return OrderInfoMap;
    }

    public void setOrderInfoMap(Map<Integer, Map<HotelInfo, UserInfo>> orderInfo) {
        OrderInfoMap = OrderInfoMap;
    }

    public ArrayList<Integer> getIncompleteorderNo() {
        return IncompleteorderNo;
    }

    public void setIncompleteorderNo(ArrayList<Integer> incompleteorderNo) {
        IncompleteorderNo = incompleteorderNo;
    }

    public OrderInfo(Map<Integer, Map<HotelInfo, UserInfo>> OrderInfoMap, ArrayList<Integer> incompleteorderNo) {
        OrderInfoMap = OrderInfoMap;
        IncompleteorderNo = incompleteorderNo;
    }
}
