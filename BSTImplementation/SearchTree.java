// Class SearchTree stores and prints a binary search tree of
// objects of type E.  E must implement the Comparable<E>
// interface.

/*
PARTICIPATION:
 Adam: Implemented constructor, add, contains
 Jacob: Kelleran:
 Justin Zhu:

 */

public class SearchTree<E extends Comparable<E>> {

    private SearchTreeNode<E> overallRoot; // root of overall tree

    // post: constructs an empty search tree
    public SearchTree() {
//      TO DO:
        overallRoot = new SearchTreeNode<E>(null);
    }

    // post: value added to tree so as to preserve binary search tree
    public void add(E value) {
//    	TO DO:
        overallRoot = add(overallRoot, value);
    }

    // post: value added to tree so as to preserve binary search tree
    private SearchTreeNode<E> add(SearchTreeNode<E> root, E value) {
//    	TO DO:
        if (root == null || root.data == null) {
            root = new SearchTreeNode<E>(value);
        } else if (value.compareTo(root.data) < 0) {
            root.left = add(root.left, value);
        } else if (value.compareTo(root.data) > 0) {
            root.right = add(root.right, value);
        }
        return root;
    }

    // post: returns true if tree contains value, returns false otherwise
    public boolean contains(E value) {
//    	TO DO:
        return contains(overallRoot, value);
    }

    // post: returns true if given tree contains value, returns false otherwise
    private boolean contains(SearchTreeNode<E> root, E value) {
//    	TO DO:
        if (root == null) {
            return false;
        } else if (value.compareTo(root.data) < 0) {
            return contains(root.left, value);
        } else if (value.compareTo(root.data) > 0) {
            return contains(root.right, value);
        } else { // value.compareTo(root.data) == 0
            return true;
        }
    }

    // post: value removed from tree so as to preserve binary search tree
    //Justin Zhu
    public void remove(E value) {
        this.overallRoot = remove(overallRoot, value);
    }


    // post: value removed to tree so as to preserve binary search tree
    //Justin Zhu
    private SearchTreeNode<E> remove(SearchTreeNode<E> root, E value) {
        if(root == null || root.data == null){
            return null;
        } else if(value.compareTo(root.data) > 0){
            //if the value that is going to be removed is greater than the current node, recursive call with the right branch because the right branch is bigger values
            root.right = remove(root.right, value);
        } else if(value.compareTo(root.data) < 0){
            //if the value that is being removed is smaller than the current root node, recursively call the left branch
            root.left = remove(root.left, value);
        } else{
            //this code runs when the value to be removed is found
            if(root.right == null){ //must first check right branch because that would go before the left branch
                return root.left;
            } else if(root.left == null){
                return root.right;
            } else{
                root.data = findSmallest(root.right);
                root.right = remove(root.right, root.data);
            }
        }
        return root;
    }

    // post: return the smallest value in the binary search tree
    //Justin Zhu
    private E findSmallest(SearchTreeNode<E> root) {
        if(root.left == null){
            return root.data;
        } else{
            return findSmallest(root.left);
        }
    }

    // post: prints the data of the tree, one per line
    // Jacob Kelleran
    public void print() {
        printInorder(overallRoot);
    }

    // post: prints the data of the tree using an inorder traversal
    // Jacob Kelleran
    private void printInorder(SearchTreeNode<E> root) {
//    	TO DO:
        if (root.left != null)  printInorder(root.left);
        System.out.println(root.data);
        if (root.right != null) printInorder(root.right);
    }


    private static class SearchTreeNode<E> {
        public E data;                   // data stored in this node
        public SearchTreeNode<E> left;   // left subtree
        public SearchTreeNode<E> right;  //  right subtree

        // post: constructs a leaf node with given data
        public SearchTreeNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with the given data and links
        public SearchTreeNode(E data, SearchTreeNode<E> left,
                              SearchTreeNode<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

}
