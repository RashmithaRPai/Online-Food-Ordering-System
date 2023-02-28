import java.util.ArrayList;
import java.util.Map;

public class Menu {
    Map<String,Map<String,Integer>> Menu;

    public Map<String, Map<String, Integer>> getMenu() {
        return Menu;
    }

    public void setMenu(Map<String, Map<String, Integer>> menu) {
        Menu = menu;
    }

    public Menu(Map<String, Map<String, Integer>> menu) {
        Menu = menu;
    }

    @Override
    public String toString() {
        return "{" +
                "Menu=" + Menu +
                '}';
    }
}
