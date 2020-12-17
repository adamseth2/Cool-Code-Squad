import java.util.ArrayList;
import java.util.List;

public class AllValidParenthesis {

    public static void main(String[] args) {
        System.out.println(findAllParenthesis(1).toString());
        System.out.println(findAllParenthesis(2).toString());
        System.out.println(findAllParenthesis(3).toString());
        System.out.println(findAllParenthesis(4).toString());
    }

    /**
     * Finds every valid permutation of a specified number of pairs of parenthesis.
     *
     * Decision tree:
     *
     *            if there are available open parenthesis sets, add a closed parenthesis and recurse.
     *                 /
     * Current string + - if few enough open parenthesis were added, add another one and recurse.
     *                \
     *            if string is complete, add to array and stop branch.
     *
     * Time complexity: I'm going to say O(2^n) here, because although it's much more complex than that, the growth
     *                  would follow that general pattern.
     * Space complexity: O(n)
     *
     * A few notes on some decisions I made:
     *  1. I could have calculated validityScore and openParenCount on the fly, but I figured that passing them along as
     *     parameters would technically be faster? I'm not sure about that though.
     *  2. I probably could have done the same for the total expected length, but I didn't want to clutter the arguments
     *     too much I guess? I suppose it's a helper function, so it doesn't really matter, but still. And I'm not sure
     *     just how much faster that would have really been.
     *
     * @param numPairs the number of pairs to evaluate.
     * @return an ArrayList containing every possible permutation of parenthesis.
     */
    public static List<String> findAllParenthesis(int numPairs) {
        List<String> permutations = new ArrayList<>();
        allParenthesisHelper(permutations, "", numPairs * 2, 0, 0);
        return permutations;
    }

    /**
     * A private helper function for the recursive process of finding all valid parenthesis.
     *
     * @param currentPermutation the string containing the current set of parenthesis.
     * @param parenthesisLeft the number of parenthesis that are yet to be added.
     * @param validityScore the validity score of the string (open = 1, closed = -1, if score >= 0, string is valid).
     */
    private static void allParenthesisHelper(List<String> permutations,
                                             String currentPermutation,
                                             int parenthesisLeft,
                                             int validityScore,
                                             int openParenCount) {
        if (parenthesisLeft == 0) {
            // end case, the parenthesis string is complete.
            permutations.add(currentPermutation);
        } else {
            if (validityScore > 0) {
                // we can add another closed parenthesis (see javadoc comments)
                allParenthesisHelper(permutations, currentPermutation + ")",
                        parenthesisLeft - 1, validityScore - 1, openParenCount);
            }
            if (openParenCount < (currentPermutation.length() + parenthesisLeft) / 2) {
                // the number of open parenthesis makes up less than half of the total parenthesis, so we can add more
                allParenthesisHelper(permutations, currentPermutation + "(",
                        parenthesisLeft - 1, validityScore + 1, openParenCount + 1);

            }
        }
    }

}
