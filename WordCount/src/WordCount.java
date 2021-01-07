import java.io.*;
import java.util.*;

/*PARTICIPATION
ADAM: Push initial commit; completed getCountMap method;took screenshot of console results
JUSTIN: Fixed NullPointedException and fixed FileNotFound because file was in the wrong place; Added printing of results using the 2000 occurrences method
JACOB: Implemented simple word cleansing (cleaning maybe? Not sure if that's even the proper phrase...) algorithm and a String filter
*/
/*REFLECTION
JUSTIN: Learned that every variable should have a purpose otherwise there's no point of it being there and that's how I figured out that the OCCURRENCES variable was meant for
JACOB: Learned to think about what is being printed before debugging. While I was testing cleansing, the output
		contained "{=4752, " or something at the beginning, which I interpreted to mean that opening curly braces were
		somehow leaking past my algorithm. It turns out that it was just a bunch of blank characters, and I thought it
		was curly braces because that is what printed maps are wrapped in.
*/
public class WordCount {
	// minimum number of occurrences needed to be printed - 2000;
	// read the book into a map
	// to do
	public static final int OCCURRENCES = 2000;

	// string cleaning character lists
	private static final List<Character> starters = new ArrayList<>(Arrays.asList(
			'"', '\'', '(', '{', '}', '|', '~', '[', '-', '/', '.', ',', '&', '*'));
	private static final List<Character> finishers = new ArrayList<>(Arrays.asList(
			'"', '\'', ')', '}', ']', '-', '/', '.', ',', '!', '?', ';', ':'));

	public static void main(String[] args) throws FileNotFoundException {
		//Fix file system probably
		//Note to put text file in project folder and not in src folder
		Scanner input = new Scanner(new File("mobydick.txt"));
		// print out only words that occur more than 2000 times
		System.out.println("This program displays the most frequently occurring words from the book Moby-Dick: ");
		Map<String, Integer> result = getCountMap(input, true); // use string cleaning

		//complexity of O(n) because it is just traversing through the entire map once and finding the words that occur more than 2000 times.
		for(Map.Entry<String, Integer> word : result.entrySet()){
			if(word.getValue() > OCCURRENCES) {
				System.out.println(word.getKey() + " occurs " + word.getValue() + " times.");
			}
		}

		//sort entire map for alternative solution
		//TO DO

	}

	// by default do not clean strings
	public static Map<String, Integer> getCountMap(Scanner in) {
		return getCountMap(in, false);
	}

	// Reads book text and returns a map from words to counts.
	public static Map<String, Integer> getCountMap(Scanner in, boolean cleanStrings) {
		// to do
		Map<String, Integer> wordCountMap = new TreeMap<>();

		while(in.hasNext()) {
			String word = in.next();

			if (cleanStrings) {
				//simple string cleaning
				// lambdas can't use non-final variables, so as much as I don't like it, it's best to do it this way I think
				while (true) {
					if (word.length() > 0 && charInList(word.charAt(0), starters)) {
						word = word.substring(1);
					} else {
						break;
					}
				}

				while (true) {
					if (word.length() > 0 && charInList(word.charAt(word.length() - 1), finishers)) {
						word = word.substring(0, word.length() - 1);
					} else {
						break;
					}
				}

				word = word.toLowerCase(); // casing should not matter
			}

			// make sure the word is actually a word
			if (word != null && !word.equals("")) {
				if (!wordCountMap.containsKey(word)) wordCountMap.put(word, 1);
				else {
					int initialCount = wordCountMap.get(word);
					wordCountMap.put(word, initialCount + 1);
				}
			}
		}
		return wordCountMap;
	}

	// helper function, returns true if the character is in the list
	private static boolean charInList(char targetChar, List<Character> list) {
		return list.stream().anyMatch(c -> c == targetChar);
	}
}
