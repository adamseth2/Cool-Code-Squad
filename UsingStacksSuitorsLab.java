import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/* 
 * 
 * UsingStacksSuitorsLab
 * By: Adam Chhor, Jacob Kelleran, and Justin Zhu
 * 
 * This class is mostly a driver for playing with Strings as palindromes, 
 * both iteratively and recursively.  The UsingStacksSuitorsLab class itself is
 * a runnable object, so it can be passed to a thread in our Queue demo
 * 
 * 
 */

public class UsingStacksSuitorsLab implements Runnable {
	private static int threadCount = 0;
	private String name;

	public UsingStacksSuitorsLab() {
		name = "#" + threadCount++ + "Thread";
	}

	public static void main(String[] args) {
		String s1 = "food"; // not a palindrome
		String s2 = "racecar"; // a palindrome

		System.out.println("String1 is \"" + s1 + "\"");
		System.out.println("String2 is \"" + s2 + "\"");

		System.out.println(s1 + " reversed is: ");
		printReverse(s1);
		System.out.println(s2 + " reversed is: ");
		printReverse(s2);
		System.out.println();

		recPrintReverse(s1);
		recPrintReverse(s2);
		System.out.println();

		System.out.println(s1 + " is a palindrome: " + isPalindrome(s1));
		System.out.println(s2 + " is a palindrome: " + isPalindrome(s2));

		System.out.println(s1 + " is a palindrome(recursively): " + isPalindromeRec(s1));
		System.out.println(s2 + " is a palindrome(recursively): " + isPalindromeRec(s2));
		/*
		 * System.out.println("Did we build a Queue of Threads and start them? " +
		 * buildThreadQueue());
		 *
		 */
		int n = 6; System.out.println("For " + n + " suitors, stand in place: " + findPlaceToStand(n));
		n = 10; System.out.println("For " + n + " suitors, stand in place: " + findPlaceToStand(n));
	}

	public static void printReverse(String target) {
		Stack<Character> wordStack = new Stack<>();
		for (char letter : target.toCharArray()) {
			wordStack.push(letter);
		}
		String reversedWord = "";
		while (!wordStack.isEmpty()) {
			reversedWord += wordStack.pop();
		}
		System.out.println(reversedWord);
	}

	public static void recPrintReverse(String target) {
		//first check if the String is only 1 character long
		if (target.length() < 2) {
			System.out.println(target);
		} else {
			System.out.print(target.charAt(target.length() - 1));
			recPrintReverse(target.substring(0, target.length() - 1));
		}
	}

	public static boolean isPalindrome(String input) {
		Stack<Character> wordStack = new Stack<>();
		char[] inputCharArray = input.toCharArray();
		char[] bannedCharArray = { '.', ',', '?' };
		for (char letter : inputCharArray) {
			boolean allowedLetter = true;
			for (char bannedChar : bannedCharArray) {
				if (letter == bannedChar) {
					allowedLetter = false;
					break;
				}
			}
			if (allowedLetter)
				wordStack.push(letter);
		}
		char[] reversedInputCharArray = new char[wordStack.size()];
		int index = 0;
		while (!wordStack.isEmpty()) {
			reversedInputCharArray[index] = wordStack.pop();
			index++;
		}
		if (Arrays.equals(inputCharArray, reversedInputCharArray))
			return true;
		else
			return false;
	}

	public static boolean isPalindromeRec(String sentence) {
		if (sentence.length() < 2) {
			return true;
		} else {
			if (sentence.charAt(0) == sentence.charAt(sentence.length() - 1)) {
				return isPalindrome(sentence.substring(1, sentence.length() - 1));
			}
		}
		return false;
	}

	public static int findPlaceToStand(int numSuitors) {
		//check for edge cases
		if (numSuitors==0){
			return -1;
		}
		if (numSuitors==1){
			return 1;
		}

		Queue<Integer> myQueue = new LinkedList<Integer>();
		//adding the suitor numbers to the queue
		int currentSuitor = 1;
		while (numSuitors>0){
			myQueue.add(currentSuitor);
			currentSuitor++;
			numSuitors--;
		}

		//removing every third suitor until there is only one suitor left in the queue
		while (myQueue.size()>1) {
			myQueue.add(myQueue.poll());
			myQueue.add(myQueue.poll());
			myQueue.remove();
		}

		return ((LinkedList<Integer>) myQueue).get(0);
	}

	public static boolean buildThreadQueue() { // returns true upon success
		Queue<Thread> q = new LinkedList<Thread>();

		// when our program starts up, it might create multiple threads to use
		// q.enqueue(new Thread(new UsingStacksSuitorsLab()));
		// q.enqueue(new Thread(new UsingStacksSuitorsLab()));
		// q.enqueue(new Thread(new UsingStacksSuitorsLab()));

		System.out.println("Initial Thread order:");
		q.toString();

		// We need to iterate over our pool of threads and call start() on each one
		// Make a loop that dequeues a thread, calls start on it, and //enqueues it
		// again
		// to do:
		// current = get a thread
		// current.start();
		// put the thread back

		System.out.println("Thread order after start()ing:");
		q.toString();

		return true; // on successful start
	}

	/*
	 * No need to edit anything below here, unless you'd like to change the
	 * behaviour of each thread in the thread pool above
	 */

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(name + ": " + i + "th iteration");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// do nothing here
			}
		}
	}
}
