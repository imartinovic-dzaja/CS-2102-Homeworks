import java.lang.Math;
import java.util.LinkedList;

interface IBinTree {
	
 // determines whether element is in the tree
 boolean hasElt(int e);
 
 // returns number of nodes in the tree; counts duplicate elements as separate items
 int size();
 
 // returns depth of longest branch in the tree
 int height();

 /**
  * returns true if the node of a binary tree is greater or equal than the 
  * given element
  * Used as a helper to isHeap()
  * @param e the element we are comparing the node to
  * @return true if the node of is greater or equal to the given element
  */
 public boolean isBigger(int e);


/**
 * Check if a Binary Tree is a valid Heap 
 * @return true if a Binary Tree is a valid Heap
 */
 boolean isHeap();
 
/**
 * Puts all elements of the Binary Tree in a LinkedList
 * @return a ModifiedLinkedList containing all elements of the Binary Tree in its 
 * list field
 */
 public ModifiedLinkedList<Integer> listElements();
 
 
 /**
  * Compares two Binary Trees and returns true if they have different unique elements
  * @param original is a LinkedList of all elements of the current BinaryTree
  * @param other is the other Binary Tree
  * @return true if the two Binary Trees have different unique elements
  */
 public boolean hasUnexpectedElements(LinkedList<Integer> original, IBinTree other); 

/**
 * stores elements of a binary tree in a list of unique integers (DataPoints) 
 * and keeps track of their number of occurrences
 * @return the LinkedList of all the unique elements of the Binary Tree and their occurrances
 */
 public LinkedList<DataPoint> storeUniqueInList();
 
 
 /**
  * An overloaded version of storeUniqueInList()
  * This function takes in the elements of the Binary Tree stored in a LinkedList
  * Useful for producing the list of unique elements of Binary Trees to which an 
  * Element has just been added or removed
  * @param listToBeSorted is the list of elements of the Binary Tree itself stroed as a LinekdList
  * @return the LinkedList of all the unique elements of the Binary Tree and their occurrances
  */
 public LinkedList<DataPoint> storeUniqueInList(LinkedList<Integer> listToBeSorted);

 
/**
 * Compares Binary Trees  with same unique values,  and returns true 
 * if their unique values have the same number of occurrences
 * @param original are all elements of the current Binary Tree itself stored in a LinkedList
 * @param other is the other Binary Tree to which we are comparing the current tree
 * @return
 */
public boolean hasSameOccurances (LinkedList<Integer> original, IBinTree other);

}
