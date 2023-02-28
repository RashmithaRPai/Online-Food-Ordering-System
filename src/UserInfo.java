import java.util.ArrayList;

public class UserInfo {
    ArrayList<String> orderedItems;
    ArrayList<Integer> orderedQuantity;
    private int orderNumber;
    private String modeOfPayment;
    private String orderStatus;

    public ArrayList<String> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(ArrayList<String> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public ArrayList<Integer> getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(ArrayList<Integer> orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public UserInfo(ArrayList<String> orderedItems, ArrayList<Integer> orderedQuantity, int orderNumber, String modeOfPayment, String orderStatus) {
        this.orderedItems = orderedItems;
        this.orderedQuantity = orderedQuantity;
        this.orderNumber = orderNumber;
        this.modeOfPayment = modeOfPayment;
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "{" +
                "orderedItems=" + orderedItems +
                ", orderedQuantity=" + orderedQuantity +
                ", orderNumber=" + orderNumber +
                ", modeOfPayment='" + modeOfPayment + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
