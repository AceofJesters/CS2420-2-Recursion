import java.util.ArrayList;

public class Tree<E extends Comparable<? super E>> {
    private BinaryTreeNode root;  // Root of tree
    private String name;     // Name of tree

    /**
     * Create an empty tree
     *
     * @param label Name of tree
     */
    public Tree(String label) {
        name = label;
    }

    /**
     * Create BST from ArrayList
     *
     * @param arr   List of elements to be added
     * @param label Name of tree
     */
    public Tree(ArrayList<E> arr, String label) {
        name = label;
        for (E key : arr) {
            insert(key);
        }
    }

    /**
     * Create BST from Array
     *
     * @param arr   List of elements to be added
     * @param label Name of  tree
     */
    public Tree(E[] arr, String label) {
        name = label;
        for (E key : arr) {
            insert(key);
        }
    }

    /**
     * Return a string containing the tree contents as a tree with one node per line
     */
    public String toString() {
        String returnString = "";

        // print tree name
        returnString += name;

        // if tree empty, return "empty tree"
        if (root == null){
            returnString += "Empty tree\n";
        }

        // call traversal function
        if (root != null) {
            returnString += root.parseToString(0);
        }

        // return updated string
        return returnString;
    }

    /**
     * Return a string containing the tree contents as a single line
     */
    public String inOrderToString() {
        String orderedString = "";

        // print name
        orderedString += name;

        // if tree empty, return "empty tree"
        if (root == null) {
            orderedString += "empty tree";
        }

        if (root != null) {
            orderedString += root.orderedTraversal(0);
        }

        // return updated array
        return orderedString;
    }

    /**
     * reverse left and right children recursively
     */
    public void flip() {
        // parameters: old tree node, new tree

        // if node has no parent, add to new tree as base node
        // add node's right to new tree's equivalent node's left
        // add node's left to new tree's equivalent node's right
    }

    /**
     * Returns the in-order successor of the specified node
     * @param node node from which to find the in-order successor
     */
    public BinaryTreeNode inOrderSuccessor(BinaryTreeNode node) {
        // if right child exists, run binaryTreeChildSearch()
        // else, run binaryTreeParentSearch
        return null;
    }

    public BinaryTreeNode binaryTreeChildSearch(BinaryTreeNode node) {
        // if node has left child
            // binaryTreeChildSearch left child
        // else return value of node
        return null;
    }

    public BinaryTreeNode binaryTreeParentSearch(BinaryTreeNode node) {
        // if node is smaller than analysed value
            // if parent exists
                // binaryTreeParentSearch parent
            // else return null
        // else return value of node
        return null;
    }

    /**
     * Counts number of nodes in specified level
     *
     * @param level Level in tree, root is zero
     * @return count of number of nodes at specified level
     */
    public int nodesInLevel(int level) {
        // parameters are level searched, current level, counter

        // if node level == searched level
        // add one to counter

        // if node level != searched level
        // add one to current level
        // count left child node
        // count right child node
        return 0;
    }

    /**
     * Print all paths from root to leaves
     */
    public void printAllPaths() {
        // save node to array

        // if node is not leaf node
            // printAllPaths for left branch
            // for right branch

        // if node is leaf node
            // print array
            // print newline

        // remove node from array
    }

    /**
     * Counts all non-null binary search trees embedded in tree
     *
     * @return Count of embedded binary search trees
     */
    public int countBST() {
        // parameters: node info, bstcounter
        // if left root is bst and right root is bst, add 1 to bstcounter
        return 0; // return bstcounter
    }

    /**
     * Insert into a bst tree; duplicates are allowed
     *
     * @param x the item to insert.
     */
    public void insert(E x) {
        root = insert(x, root, null);
    }

    public BinaryTreeNode getByKey(E key) {
        // if nodekey == searched key
            // return node
        // if nodekey != searched key
            // search left
            // search right
        return null;
    }

    /**
     * Balance the tree
     */
    public void balanceTree() {
        // arguments: tree info, stringed, indents, parent node value

        // if not stringed
            // call toString to put tree in string format
            // set stringed to true

        // insert (value of array space at len/2) at root node
        // save numbers to left of value to a temp array
        // balanceTree() for smaller array
        // save numbers to right of value to a temp array
        // balanceTree() for smaller array

    }

    /**
     * Internal method to insert into a subtree.
     * In tree is balanced, this routine runs in O(log n)
     *
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryTreeNode insert(E x, BinaryTreeNode t, BinaryTreeNode parent) {
        if (t == null) return new BinaryTreeNode(x, null, null, parent);

        int compareResult = x.compareTo(t.key);
        if (compareResult < 0) {
            t.left = insert(x, t.left, t);
        } else {
            t.right = insert(x, t.right, t);
        }

        return t;
    }


    /**
     * Internal method to find an item in a subtree.
     * This routine runs in O(log n) as there is only one recursive call that is executed and the work
     * associated with a single call is independent of the size of the tree: a=1, b=2, k=0
     *
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     *          SIDE EFFECT: Sets local variable curr to be the node that is found
     * @return node containing the matched item.
     */
    private boolean contains(E x, BinaryTreeNode t) {
        if (t == null)
            return false;

        int compareResult = x.compareTo(t.key);

        if (compareResult < 0)
            return contains(x, t.left);
        else if (compareResult > 0)
            return contains(x, t.right);
        else {
            return true;    // Match
        }
    }

    // Basic node stored in unbalanced binary trees
    public class BinaryTreeNode {
        E key;                 // The data/key for the node
        BinaryTreeNode left;   // Left child
        BinaryTreeNode right;  // Right child
        BinaryTreeNode parent; //  Parent node

        // Constructors
        BinaryTreeNode(E theElement) {
            this(theElement, null, null, null);
        }

        BinaryTreeNode(E theElement, BinaryTreeNode lt, BinaryTreeNode rt, BinaryTreeNode pt) {
            key = theElement;
            left = lt;
            right = rt;
            parent = pt;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Node:");
            sb.append(key);
            if (parent == null) {
                sb.append("<>");
            } else {
                sb.append("<");
                sb.append(parent.key);
                sb.append(">");
            }

            return sb.toString();
        }

        public String parseToString(int layer){
            String resultingString = "";

            // call toString for right child if child exists
            if (right != null){
                resultingString += right.parseToString(layer + 1);
            }

            // format spacing
            resultingString += "\n";
            for (int i = layer; i >= 1; i--) {
                resultingString += "   ";
            }

            // add self key to array
            resultingString += key.toString();

            // add parent to string
            if (parent == null) {
                resultingString += "[no parent]";
            } else {
                resultingString += "[" + parent.key + "]";
            }

            // call toString for node left child if child exists
            if (left != null){
                resultingString += left.parseToString(layer + 1);
            }

            return resultingString;
        }

        String orderedTraversal(int layer){
            String resultingString = "";

            if (left != null){
                resultingString += left.orderedTraversal(layer + 1);
            }

            // format spacing
            resultingString += "\n";
            for (int i = layer; i >= 1; i--) {
                resultingString += "   ";
            }

            // add self key to array
            resultingString += key.toString();

            // add parent to string
            if (parent == null) {
                resultingString += "[no parent]";
            } else {
                resultingString += "[" + parent.key + "]";
            }

            // call toString for right child if child exists
            if (right != null){
                resultingString += right.orderedTraversal(layer + 1);
            }

            return resultingString;
        }
    }
}
