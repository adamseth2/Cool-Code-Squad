import java.io.*;
import java.util.*;

/*PARTICIPATION
ADAM: Push initial commit; completed getCountMap method;took screenshot of console results
JUSTIN: Fixed NullPointedException and fixed FileNotFound because file was in the wrong place; Added printing of results using the 2000 occurrences method

*/
/*REFLECTION
JUSTIN: Learned that every variable should have a purpose otherwise there's no point of it being there and that's how I figured out that the OCCURRENCES variable was meant for
*/
public class WordCount {
	// minimum number of occurrences needed to be printed - 2000;
	// read the book into a map
	// to do
	public static final int OCCURRENCES = 2000;
	public static void main(String[] args) throws FileNotFoundException {
		//Fix file system probably
		//Note to put text file in project folder and not in src folder
		Scanner input = new Scanner(new File("mobydick.txt"));
		// print out only words that occur more than 2000 times
		System.out.println("This program displays the most frequently occurring words from the book Moby-Dick: ");
		Map<String, Integer> result = getCountMap(input);

		//complexity of O(n) because it is just traversing through the entire map once and finding the words that occur more than 2000 times.
		for(Map.Entry<String, Integer> word: result.entrySet()){
			if(word.getValue()>OCCURRENCES){
				System.out.println(word.getKey() + " occurs " + word.getValue() + " times.");
			}
		}

		//sort entire map for alternative solution
		//TO DO

	}

	// Reads book text and returns a map from words to counts.
	public static Map<String, Integer> getCountMap(Scanner in) {
		// to do
		Map<String, Integer> wordCountMap = new TreeMap<>();
		while(in.hasNext()) {
			String word = in.next();
			if (!wordCountMap.containsKey(word)) wordCountMap.put(word,1);
			else {
				int initialCount = wordCountMap.get(word);
				wordCountMap.put(word, initialCount + 1);
			}
		}
		return wordCountMap;
	}
}
