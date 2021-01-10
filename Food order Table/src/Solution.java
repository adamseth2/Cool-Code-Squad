import java.util.*;
/**
Group Cool Code Squad
    Adam, Jacob, Justin


 **/
public class Solution {
  public static void main(String[] args) {
    //Test case
        List<List<String>> orders = new ArrayList<>();
    String[] order1arr = {"David","3","Ceviche"};
    String[] order2arr = {"David","3","Bob"};
    List<String> order1 = Arrays.asList(order1arr);
    List<String> order2 = Arrays.asList(order2arr);
    orders.add(order1);
    orders.add(order2);
    System.out.println(displayTable(orders));
  }
  public static List<List<String>> displayTable(List<List<String>> orders) {
    Map<Integer, TreeMap<String, Integer>> tableFoodItemOrders = new TreeMap<>();
    //Keeps track of unique food items
    SortedSet<String> foodItems = new TreeSet<>();

    for (List<String> order : orders) {
      //Must convert table number from String to Int because it is given in a list of strings
      int tableNumber = Integer.parseInt(order.get(1));
      String item = order.get(2);
      // If the table number doesn't exist, add the the number number
      if (tableFoodItemOrders.get(tableNumber) ==null) tableFoodItemOrders.put(tableNumber, new TreeMap<String, Integer>());
      Map currTableMap = tableFoodItemOrders.get(tableNumber);
      //If the food item exist add 1 else add food item
      if (currTableMap.containsKey(item)) {
        int originalCount = (int) currTableMap.get(item);
        currTableMap.put(item, originalCount + 1);
      } else currTableMap.put(item, 1);
      //Adds unique food items
      foodItems.add(item);
    }
    System.out.println();
    List<List<String>> bob = new ArrayList<>();
    //first row of the table is the list of all dishes in alphabetical order
    bob.add(new ArrayList<>());
    bob.get(0).add("Table");
    bob.get(0).addAll(foodItems);
    for(Map.Entry<Integer, TreeMap<String,Integer>> currentRow : tableFoodItemOrders.entrySet()){
        //TO DO: out the row number at the start of each arrayList and then the number of each dish, then add arrayList to bob

    }

    return bob;

    //Need to implement converting maps into List
  }
}
