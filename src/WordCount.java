import java.io.*;
import java.util.*;

/*PARTICIPATION
ADAM: Push initial commit; completed getCountMap method;took screenshot of console results


*/
public class WordCount {
	// minimum number of occurrences needed to be printed - 2000;
	// read the book into a map
	// to do
	public static final int OCCURRENCES = 2000;
	public static void main(String[] args) throws FileNotFoundException {
		//Fix file system probably
		Scanner input = new Scanner(new File("./mobydick.txt"));
		// Sort values by accending order
		System.out.println(getCountMap(input));



	}

	// Reads book text and returns a map from words to counts.
	public static Map<String, Integer> getCountMap(Scanner in) {
		// to do
		Map<String, Integer> wordCountMap = new TreeMap<>();
		while(in.hasNext()) {
			String word = in.next();
			if (wordCountMap.containsKey(word)) wordCountMap.put(word,1);
			else {
				int initialCount = wordCountMap.get(word);
				wordCountMap.put(word, initialCount + 1);
			}
		}
		return wordCountMap;
	}
}
