package io.github.emuman;

import java.util.Arrays;

// I named this WordSearch, but I think the classname on the LeetCode thing was Solution.
public class WordSearch {

    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        char[][] board2 = new char[][] {
                {'A','A','B','E'},
                {'B','B','C','S'},
                {'F','C','D','E'},
                {'D','D','E','E'},
                {'E','C','E','E'}
        };

        System.out.println(exist(board, "ABCCED")); // true
        System.out.println(exist(board, "SEE")); // true
        System.out.println(exist(board, "ABCB")); // false
        System.out.println(exist(board, "ASADEESECCFB")); // true
        System.out.println(exist(board, "ASADEESECCFBA")); // false
        System.out.println(exist(board, "ASADECCBA")); // false
        System.out.println(exist(board2, "AABCDCE")); // true (valid, but does not work without backtracking)
    }

    /**
     * Checks whether a word can be formed by drawing a path along adjacent tiles of a given board.
     * An element on the board cannot be used in the sequence more than once.
     *
     * Mostly recursive, but with a nested loop to get things started. I hope that's okay.
     *
     * Diagram of a single iteration/branch of the tree (4 possible branches):
     *          [A]
     *           |
     *     [D]--[X]--[B]
     *           |
     *          [C]
     *
     * The max recursion depth is max(n, xy) (see below for explanation)
     *
     * For each branch, there are four connecting branches, one to check each tile adjacent to the current one.
     * Basically, it checks (x+1, y), (x-1, y), (x, y+1), and (x, y-1).
     *
     * Time complexity: O(x*y*n*4^n)
     * Space complexity: O(n)
     *
     * Note about time complexity: I wasn't sure what to write there. x and y refer to the dimensions of the array,
     * since we have to iterate across all elements in the worst case scenario, which is x*y. n refers to the length
     * of the word, and each character has 4 more adjacent to it. Even though this algorithm doesn't count the same
     * letter twice, meaning technically there are only three paths available off of any existing element (except for
     * the first), it still checks those repeated elements, so I think the time complexity is still 4^n. The extra
     * standalone n is there because the algorithm has to go through checked[] (length of word - 1) to see if a tile was
     * previously checked (which could be optimized). Or maybe I'm completely wrong about everything. I don't know.
     *
     * Also, n should technically be represented as max(n, xy), because if the word is longer than the number of
     * elements on the board, all sequences will just be cut off after all elements of the board have been checked
     * because there is nowhere left to go.
     *
     * Worst case would be all characters the same, and the word is longer than the number of characters on the board.
     * All cases fail, and it still has to check every path possible because all characters are the same. I think.
     *
     * @param board the board of characters to find the word in.
     * @param word the word to search for in the board of characters.
     * @return true if a path that contains the word was found, false otherwise.
     */
    public static boolean exist(char[][] board, String word) {
        // we should start a check chain for every item on the board
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                // we will never be adding the last character from word to checked,
                // so int array can be size of word length - 1
                // also initialize the 2d array to all -1 because unlike 0 (default),
                // an item can never have a coordinate of -1, so there's no way for
                // there to be a false positive on any tile
                int[][] found = new int[word.length() - 1][2];
                for (int[] coords : found) Arrays.fill(coords, -1);
                if (pathExists(board, word, x, y, found)) return true;
            }
        }

        return false;
    }

    // helper method for exist()
    private static boolean pathExists(char[][] board, String word, int x, int y, int[][] checked) {

        // check if this square has already been checked
        if (Arrays.stream(checked).anyMatch(coords -> coords[0] == x && coords[1] == y)) return false;
        // could technically be improved by breaking off at the first occurrence of -1

        // check if the character on the board matches the sequence
        if (board[y][x] == word.charAt(0)) {

            // end condition (the last character of the word is equal to the current character on the board)
            if (word.length() == 1) return true;

            // checked.length = max word.length() - 1, so we have to add one to properly add to the array
            checked[checked.length - word.length() + 1] = new int[]{x, y};

            // if any of the chains returns true, it has found a match, so this link should return true as well
            // also include initial checks to make sure we do not step outside of the board, if one of those
            // verification conditions is false it will not even bother checking that chain because of short-circuiting
            if ((x < board[y].length - 1 && pathExists(board, word.substring(1), x + 1, y, checked)) ||
                    (x > 0 && pathExists(board, word.substring(1), x - 1, y, checked)) ||
                    (y < board.length - 1 && pathExists(board, word.substring(1), x, y + 1, checked)) ||
                    (y > 0 && pathExists(board, word.substring(1), x, y - 1, checked))
                    ) {
                return true;
            } else {
                // backtracking. initially i didn't think it was necessary because checked[] values just get overwritten
                // as the next chain forms, but if that next chain intersects the failed chain with a shorter path,
                // checked[] contains a false positive, and the new chain is erroneously failed. (example in main())
                checked[checked.length - word.length() + 1] = new int[]{-1, -1};
                return false;
            }
        }

        // this character did not match the word sequence, stop the chain by returning false
        return false;
    }

}
