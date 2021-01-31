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
      if (root == null) {
        root = new SearchTreeNode<E>(value);
      } else if (value.compareTo(root.data) > 0) {
        root.left = add(root.left, value);
      } else if (value.compareTo(root.data) < 0) {
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
      } else if (value.compareTo(root.data) > 0) {
        return contains(root.left, value);
      } else if (value.compareTo(root.data) < 0) {
         return contains(root.right, value);
      } else { // value.compareTo(root.data) == 0
        return true;
      }
    }
    
    // post: value removed from tree so as to preserve binary search tree
    public void remove(E value) {
//    	TO DO:
    }
    
    
 // post: value removed to tree so as to preserve binary search tree
    private SearchTreeNode<E> remove(SearchTreeNode<E> root, E value) {
//    	TO DO:
        return null;
    }
    
 // post: return the smallest value in the binary search tree  
    private E findSmallest(SearchTreeNode<E> root) {
//    	TO DO:
      return null;
    }

    // post: prints the data of the tree, one per line
    public void print() {
//    	TO DO:
    }

    // post: prints the data of the tree using an inorder traversal
    private void printInorder(SearchTreeNode<E> root) {
//    	TO DO:
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
