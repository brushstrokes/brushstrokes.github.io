
public class AVLTreeSet<E extends Comparable<E>> implements Set<E> { // E must be a class that implements Comparable
   private Node<E> root;

   // Construct a new empty tree.
   public AVLTreeSet() {}

   // Adds the specified element to the tree.
   public void add(E e) {
      root = add(e, root);
   }
   
   // Adds the specified element to the tree (if it is not already in the tree) and returns the root.
   private Node<E> add(E e, Node<E> root) {
      if (root == null) return new Node<>(e); // Case where the tree is empty.
      int compare = e.compareTo(root.data);
      if (compare < 0)                    // If e < root.data, add it to the left subtree.
         root.left = add(e, root.left);
      else if (compare > 0)               // If e > root.data, add it to the right subtree.
         root.right = add(e, root.right);
      root.updateHeightAndBF();           // Update the root's height and balance factor.
      return rebalance(root);             // Rebalance the subtree if it is unbalanced.
   }
   
   // Rebalances the subtree if it is unbalanced with a single or double rotation.
   private Node<E> rebalance(Node<E> root) {
      if (root.bf == -2) { // Left-left or left-right case
         if (root.left.bf == 1) // Left-right case
            root.left = rotateLeft(root.left);
         return rotateRight(root);
      }
      else if (root.bf == 2) { // Right-right or right-left case
         if (root.right.bf == -1) // Right-left case
            root.right = rotateRight(root.right);
         return rotateLeft(root);
      }
      return root;
   }
   
   // Performs a left rotation, updates the heights, and returns the new root of the subtree.
   private Node<E> rotateLeft(Node<E> root) {
      Node<E> right = root.right;
      root.right = right.left;
      right.left = root;
      root.updateHeightAndBF();
      right.updateHeightAndBF();
      return right;
   }

   // Performs a right rotation, updates the heights, and returns the new root of the subtree.
   private Node<E> rotateRight(Node<E> root) {
      Node<E> left = root.left;
      root.left = left.right;
      left.right = root;
      root.updateHeightAndBF();
      left.updateHeightAndBF();
      return left;
   }

   // Removes the specified element from the tree (if it is in the tree).
   public void remove(E e) {
      root = remove(e, root);
   }
   
   // Removes the specified element from the tree and returns the root
   private Node<E> remove(E e, Node<E> root) {
      if (root == null) return null;         // Case where the tree is empty.
      int compare = e.compareTo(root.data);
      if (compare < 0)                       // If e < root.data, remove it from the left subtree.
         root.left = remove(e, root.left);
      else if (compare > 0)                  // If e > root.data, remove it from the left subtree.
         root.right = remove(e, root.right);
      else {                                            // If e == root.data,
         if (root.left == null) return root.right;      // Case with 0 or 1 subtree (right).
         else if (root.right == null) return root.left; // Case with 1 subtree (left).
         Node<E> t = root.right;                  // Case with 2 subtrees:
         while (t.left != null) t = t.left;       // Find the successor (min element in right subtree).
         root.data = t.data;                      // Replace root.data with min value in right subtree.
         root.right = remove(t.data, root.right); // Remove the min value from right subtree.
      }
      root.updateHeightAndBF();                   // Update the root's height and balance factor.
      return rebalance(root);                     // Rebalance the subtree if it is unbalanced.
   }
   
   // Returns true if the tree contains the specified element.
   public boolean contains(E e) {
      return contains(e, root);
   }
   
   // Returns true if the tree contains the specified element.
   private boolean contains(E e, Node<E> root) {
      if (root == null) return false;    // Case where the tree is empty.
      int compare = e.compareTo(root.data);
      if (compare < 0)                   // If e < root.data, search the left subtree.
         return contains(e, root.left);
      else if (compare > 0)              // If e > root.data, search the right subtree.
         return contains(e, root.right);
      return true;                       // If e == root.data, return true.
   }
   
   // Prints the tree pre-order with heights and balance factors
   public void print() {
      print(root, "");
   }
   
   private void print(Node<E> n, String indent) {
      if (n == null) return;
      System.out.println(indent + n.data + " (h=" + n.height + ", bf=" + n.bf + ")");
      print(n.left, indent + "   ");
      print(n.right, indent + "   ");
   }

   private static class Node<E extends Comparable<E>> {
      E data;
      Node<E> left = null, right = null;
      // bf (balance factor) is the height of the right subtree - the height of the left subtree
      int height = 0, bf = 0;
      Node(E data) {
         this.data = data;
      }
      void updateHeightAndBF() {
         int leftHeight = left == null ? -1 : left.height;
         int rightHeight = right == null ? -1 : right.height;
         height = 1 + Math.max(leftHeight, rightHeight);
         bf = rightHeight - leftHeight;
      }
   }
}
