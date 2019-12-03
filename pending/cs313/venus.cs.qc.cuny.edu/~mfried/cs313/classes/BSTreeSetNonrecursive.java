
// Non-recursive add and contains methods (the remove method is recursive).
public class BSTreeSetNonrecursive<E extends Comparable<E>> implements Set<E> { // E must be a class that implements Comparable
   private Node<E> root;

   // Construct a new empty set.
   public BSTreeSetNonrecursive() {}

   // Adds the specified element (if it is not already in the set).
   public void add(E e) {
      if (root == null) { // If the set is empty, add the element.
         root = new Node<E>(e);
         return;
      }
      Node<E> current = root;
      while (true) {
         int compare = e.compareTo(current.data);
         if (compare < 0) {                    // If e < current.data, add it to the left subtree.
            if (current.left == null) {        // If there's no left subtree,
               current.left = new Node<E>(e);  // add it as the new left child of the current node.
               return;
            }
            current = current.left;            // If there's a left subtree, add it to the subtree.
         }
         else if (compare > 0) {               // If e > current.data, add it to the right subtree.
            if (current.right == null) {       // If there's no right subtree,
               current.right = new Node<E>(e); // add it as the new right child of the current node.
               return;
            }
            current = current.right;           // If there's a right subtree, add it to the subtree.
         }
         else return;                          // If e == current.data, don't add it.
      }
   }

   // Removes the specified element.
   public void remove(E e) {
      root = remove(e, root);
   }
   
   // Removes the specified element and returns the root.
   private Node<E> remove(E e, Node<E> root) {
      if (root == null) return null;         // Element not found.
      int compare = e.compareTo(root.data);
      if (compare < 0)                       // If e < root.data, remove it from the left subtree.
         root.left = remove(e, root.left);
      else if (compare > 0)                  // If e > root.data, remove it from the left subtree.
         root.right = remove(e, root.right);
      else {                                            // If e == root.data,
         if (root.left == null) return root.right;      // Case with 0 or 1 subtree (right).
         else if (root.right == null) return root.left; // Case with 1 subtree (left).
         Node<E> t = root.right;
         while (t.left != null) t = t.left;       // Case with 2 subtrees:
         root.data = t.data;                      // Replace root.data with min value in right subtree.
         root.right = remove(t.data, root.right); // Remove the min value from right subtree.
      }
      return root;
   }
   
   // Returns true if the set contains the specified element.
   public boolean contains(E e) {
      Node<E> current = root;
      while (current != null) {
         int compare = e.compareTo(current.data);
         if (compare < 0)           // If e < current.data, search the left subtree.
            current = current.left;
         else if (compare > 0)      // If e > current.data, search the right subtree.
            current = current.right;
         else                       // If e == current.data, return true.
            return true;
      }
      return false;                 // Element not found.
   }

   private static class Node<E extends Comparable<E>> {
      E data;
      Node<E> left = null, right = null;
      Node(E data) {
         this.data = data;
      }
   }
}
