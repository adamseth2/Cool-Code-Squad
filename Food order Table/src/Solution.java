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
    Map<Integer, Map<String, Integer>> tableFoodItemOrders = new TreeMap<>();
    // Keeps track of unique food items
    SortedSet<String> foodItems = new TreeSet<>();

    for (List<String> order : orders) {
      // Must convert table number from String to Int because it is given in a list of strings
      // Integer.valueOf() stores previous results, so with multiple orders per table, it is better than Integer.parseInt()
      int tableNumber = Integer.valueOf(order.get(1));
      String item = order.get(2);

      // If the table number doesn't exist, add a new table with that number
      Map<String, Integer> table = tableFoodItemOrders.computeIfAbsent(tableNumber, k -> new HashMap<>());

      // If the food item exist add 1 else add food item
      Integer orderCount = table.getOrDefault(item, 0) + 1;
      table.put(item, orderCount);

      //Adds unique food items
      foodItems.add(item);
    }

    List<List<String>> finalTable = new ArrayList<>();
    //first row of the table is the list of all dishes in alphabetical order
    finalTable.add(new ArrayList<>(Collections.singletonList("Table")));
    finalTable.get(0).addAll(foodItems);

    // Convert the map system to a list system
    List<String> currentRow;
    Integer currentValue;
    for (Map.Entry<Integer, Map<String,Integer>> tableEntry : tableFoodItemOrders.entrySet()) {
      // Add the table number to the beginning of the row
      currentRow = new ArrayList<>(Collections.singletonList(tableEntry.getKey().toString()));
      // For each menu item in the top row, add the appropriate value for this table
      for (String menuItem : foodItems) {
        // If there is at least one item in the table's orders, add that amount to the table. Else, add zero.
        // I don't know if this actually helps, but by not using .getOrDefault(), we can just use "0" instead
        // of creating a new Integer and calling .toString()
        currentValue = tableEntry.getValue().get(menuItem);
        if (currentValue != null) {
          currentRow.add(currentValue.toString());
        } else {
          currentRow.add("0");
        }
      }
      finalTable.add(currentRow);
    }

    return finalTable;
  }
}
