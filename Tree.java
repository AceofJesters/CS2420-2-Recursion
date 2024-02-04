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
        if (root == null) {
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

        // print tree in order
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
        // TODO:

        // if node has no parent, add to new tree as base node
        // add node's right to new tree's equivalent node's left
        // add node's left to new tree's equivalent node's right
    }

    /**
     * Returns the in-order successor of the specified node
     *
     * @param node node from which to find the in-order successor
     */
    public BinaryTreeNode inOrderSuccessor(BinaryTreeNode node) {

        if (node == null) {
            return null;
        }

        return root.findInOrderSuccessor(node.key);

    }

    public BinaryTreeNode binaryTreeChildSearch(BinaryTreeNode node) {
        // if node has left child
        if (node.left != null) {
            // binaryTreeChildSearch left child
            return binaryTreeChildSearch(node.left);
        } else {
            // else return value of node
            return node;
        }
    }

    public BinaryTreeNode binaryTreeParentSearch(BinaryTreeNode node, BinaryTreeNode start) {

        Integer nodeKey = (Integer) node.key;
        Integer startKey = (Integer) start.key;

        // if node is smaller than analysed value
        if (nodeKey < startKey) {
            // if parent exists
            if (node.parent != null) {
                // binaryTreeParentSearch parent
                return binaryTreeParentSearch(node.parent, start);
            } else {
                // else return null
                return null;
            }
        } else {
            // else return value of node
            return node;
        }
    }

    /**
     * Counts number of nodes in specified level
     *
     * @param level Level in tree, root is zero
     * @return count of number of nodes at specified level
     */
    public int nodesInLevel(int level) {
        return root.countNodesInLevel(level, 0);
    }

    /**
     * Print all paths from root to leaves
     */
    public void printAllPaths() {
        ArrayList<String> path = new ArrayList<String>();
        root.printingPaths(path);
    }

    /**
     * Counts all non-null binary search trees embedded in tree
     *
     * @return Count of embedded binary search trees
     */
    public int countBST() {
        int bstCounter = 0;

        return bstCounter;
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
        return root.searchForKey(key);
    }

    /**
     * Balance the tree
     */
    public void balanceTree() {
        new Tree(root.toArray(), name);
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

        public String parseToString(int layer) {
            String resultingString = "";

            // call toString for right child if child exists
            if (right != null) {
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
            if (left != null) {
                resultingString += left.parseToString(layer + 1);
            }

            return resultingString;
        }

        String orderedTraversal(int layer) {
            String resultingString = "";

            if (left != null) {
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
            if (right != null) {
                resultingString += right.orderedTraversal(layer + 1);
            }

            return resultingString;
        }

        BinaryTreeNode searchForKey(E objective) {
            // if nodekey == searched key
            if (objective.equals(this.key)) {
                // return node
                return this;
            } else {
                // continue searching
                if (objective.compareTo(this.key) > 0) {
                    if (right != null) {
                        return right.searchForKey(objective);
                    }
                } else {
                    if (left != null) {
                        return left.searchForKey(objective);
                    }
                }
            }
            return null;
        }

        BinaryTreeNode findInOrderSuccessor(E toFind) {
            // TODO:

            // if toFind > me
            // get right child's successor
            // get left child's successor
            // if left child's successor null
            // return me
            // else
            // return left child's successor

            return null;
        }

        int countNodesInLevel(int searchFor, int searching) {
            int thisTree = 0;

            // if node level == searched level
            if (searchFor == searching) {
                return 1;
            } else {
                // count left child node
                if (left != null) {
                    thisTree += left.countNodesInLevel(searchFor, searching + 1);
                }
                // count right child node
                if (right != null) {
                    thisTree += right.countNodesInLevel(searchFor, searching + 1);
                }
                return thisTree;
            }
        }

        void printingPaths(ArrayList<String> path) {
            // save node to array
            path.add(key.toString());

            // if node is leaf node
            if (right == null && left == null) {
                // print array
                for (int i = 0; i < path.size(); i++){
                    System.out.print(path.get(i) + " ");
                }
                System.out.println();
            } else {
                // printAllPaths for left branch
                if (left != null) {
                    left.printingPaths(path);
                }
                // for right branch
                if (right != null) {
                    right.printingPaths(path);
                }
            }

            path.remove(path.size() - 1);
        }

        ArrayList<E> toArray() {
            //TODO:

            ArrayList<E> treeArray = new ArrayList<E>();

            //self
            treeArray.add(root.key);

            //left
            if (left != null) {
                treeArray.addAll(left.toArray());
            }

            //right
            if (right != null) {
                treeArray.addAll(right.toArray());
            }

            return treeArray;
        }
    }
}