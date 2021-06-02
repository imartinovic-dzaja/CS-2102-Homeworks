import java.util.LinkedList;

class MtBT implements IBinTree {

	MtBT(){}
 
	// returns false since empty tree has no elements
	public boolean hasElt(int e) {
		return false;
 }
	
 // returns 0 since empty tree has no elements
 public int size() {
  return 0;
 }
 
 // returns 0 since empty tree has no branches
 public int height() {
  return 0;
 }
 
 /**
  * returns true if the node of a binary tree is greater or equal than the 
  * given element
  * Used as a helper to isHeap()
  * Returns true since an empty element can never have any subtrees
  * And therefore within a heap it has to be the largest element
  * @param e the element we are comparing the node to
  * @return true 
  */
  public boolean isBigger(int e) {
	  return true;
	 }
 
  /**
   * Check if a Binary Tree is a valid Heap 
   * An empty Binary Tree is still a valid heap, hence always returns true
   * @return true 
   */
 public boolean isHeap() {return true;}
 
 
 /**
  * Puts all elements of a Binary Tree in a LinkedList
  * @return a ModifiedLinkedList containing a empty LinkedList field
  */
 public ModifiedLinkedList<Integer> listElements() {

	 return new ModifiedLinkedList<Integer> ((new LinkedList<Integer> ()));
}
 
 /**
  * Compares two Binary Trees and returns true if they have different unique elements
  * @param is irrelevant and assumed to be an empty LinkedList
  * @param other is the other Binary Tree
  * @return true the other binary tree is a empty node
  */
 public boolean hasUnexpectedElements(LinkedList<Integer> original, IBinTree other) {
	 return (other.listElements().list.isEmpty());    //if the other Bin Tree is also empty return true, otherwise false
 }
 

 /**
  * stores elements of a binary tree in a list of unique integers (DataPoints) 
  * and keeps track of their number of occurrences
  * for an empty Binary Tree just returns a new DataPoint LinkedList
  * @return the LinkedList of all the unique elements of the Binary Tree and their occurrances
  */
 public LinkedList<DataPoint> storeUniqueInList() {
	 return new LinkedList<DataPoint> ();
 }
 
 /**
  * An overloaded version of storeUniqueInList()
  * This function takes in the elements of the Binary Tree stored in a LinkedList
  * This function is the same for an Empty Binary Tree as the original one
  * @param listToBeSorted is the list of elements of the Binary Tree itself stroed as a LinekdList (assumed to be empty)
  * @return the LinkedList of all the unique elements of the Binary Tree and their occurrances
  */
 public LinkedList<DataPoint> storeUniqueInList(LinkedList<Integer> listToBeSorted) {
	 return new LinkedList<DataPoint> ();
 }
 
/**
 * Compares Binary Trees  with same unique values,  and returns true 
 * if their unique values have the same number of occurrences
 * @param original are all elements of the current Binary Tree itself stored in a LinkedList
 * They were stored in a LinkedList so that an element could be easily added or removed 
 * In the function parameter
 * @param other is the other Binary Tree to which we are comparing the current tree
 * @return
 */
 public boolean hasSameOccurances (LinkedList<Integer> original, IBinTree other) {
	 return (original.equals(other.listElements().list));
 }
}
