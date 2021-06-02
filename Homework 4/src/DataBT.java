import java.lang.Math;
import java.util.LinkedList;


class DataBT implements IBinTree {
 int data;
 IBinTree left;
 IBinTree right;
 
 DataBT(int data, IBinTree left, IBinTree right) {
  this.data = data;
  this.left = left;
  this.right = right;
 }
 
 // an alternate constructor for when both subtrees are empty
 DataBT(int data) {
   this.data = data;
   this.left = new MtBT();
   this.right = new MtBT();
 }
 
 // an alternate constructor for when only one subtree is provided
 
 DataBT(int data, IBinTree left) {
	   this.data = data;
	   this.left = left;
	   this.right = new MtBT();
	 }
 
 // determines whether this node or node in subtree has given element
 public boolean hasElt(int e) {
  return this.data == e || this.left.hasElt(e) || this.right.hasElt(e) ;
 }
 
 // adds 1 to the number of nodes in the left and right subtrees
 public int size() {
  return 1 + this.left.size() + this.right.size();
 }

//adds 1 to the height of the taller subtree
public int height() {
return 1 + Math.max(this.left.height(), this.right.height());
}

/**
 * returns true if the node of a binary tree is greater or equal than the 
 * given element
 * Used as a helper to isHeap()
 * @param e the element we are comparing the node to
 * @return true if the node of is greater or equal to the given element
 */
public boolean isBigger(int e) {
	  return (this.data >= e);
	  }
	  

/**
 * Check if a Binary Tree is a valid Heap 
 * @return true if a Binary Tree is a valid Heap
 */
public boolean isHeap() {
	return  (this.left.isBigger(this.data) && this.right.isBigger(this.data) 
			&& this.left.isHeap() && this.right.isHeap()); }

/**
 * Puts all elements of the Binary Tree in a LinkedList
 * @return a ModifiedLinkedList containing all elements of the Binary Tree in its 
 * list field
 */
public ModifiedLinkedList<Integer> listElements() {
	
	ModifiedLinkedList<Integer> accumulatorList = this.left.listElements();
	 for (Integer i : this.right.listElements().list)
	 {
		 accumulatorList.add(i);
	 }
	 accumulatorList.add(this.data);
	  return (accumulatorList);
}

/**
 * Compares two Binary Trees and returns true if they have different unique elements
 * @param original is a LinkedList of all elements of the current BinaryTree
 * @param other is the other Binary Tree
 * @return true if the two Binary Trees have different unique elements
 */
public boolean hasUnexpectedElements(LinkedList<Integer> original, IBinTree other)  {
	ModifiedLinkedList<Integer> modified = other.listElements();

	for(Integer dataPointInModified : modified.list) {
		boolean hasUnexpected = true;
		for (Integer dataPointInOriginal : original) {
			if (dataPointInModified == dataPointInOriginal)
				{hasUnexpected = false;}
			}
		if (hasUnexpected == true) {return true;}
	}
	return false;
}

/**
 * stores elements of a binary tree in a list of unique integers (DataPoints) 
 * and keeps track of their number of occurrences
 * @return the LinkedList of all the unique elements of the Binary Tree and their occurrances
 */
public LinkedList<DataPoint> storeUniqueInList() {
	LinkedList<DataPoint> sortedValues = new LinkedList<DataPoint> ();
	LinkedList<Integer> listToBeSorted = this.listElements().list;
	
	if (listToBeSorted.isEmpty()) {return sortedValues;}
	
	sortedValues.add(new DataPoint(listToBeSorted.get(0), 0 ));
	
	for (Integer dataPointInListToBeSorted : listToBeSorted) {
		boolean shouldBeAdded = false;
		
		for (DataPoint uniqueDataPoint : sortedValues) {
			if (dataPointInListToBeSorted.equals(uniqueDataPoint.data)) {
				uniqueDataPoint.numberOfOccurences++;
				shouldBeAdded = false;
				break;
			}
			shouldBeAdded = true;
		}
		if (shouldBeAdded) {sortedValues.add(new DataPoint(dataPointInListToBeSorted, 1));}
	}
	return sortedValues;
}


/**
 * An overloaded version of storeUniqueInList()
 * This function takes in the elements of the Binary Tree stored in a LinkedList
 * Useful for producing the list of unique elements of Binary Trees to which an 
 * Element has just been added or removed
 * @param listToBeSorted is the list of elements of the Binary Tree itself stroed as a LinekdList
 * @return the LinkedList of all the unique elements of the Binary Tree and their occurrances
 */
public LinkedList<DataPoint> storeUniqueInList(LinkedList<Integer> listToBeSorted) {
	LinkedList<DataPoint> sortedValues = new LinkedList<DataPoint> ();
	
	if (listToBeSorted.isEmpty()) {return sortedValues;}
	
	sortedValues.add(new DataPoint(listToBeSorted.get(0), 0 ));
	
	for (Integer dataPointInListToBeSorted : listToBeSorted) {
		boolean shouldBeAdded = false;
		
		for (DataPoint uniqueDataPoint : sortedValues) {
			if (dataPointInListToBeSorted.equals(uniqueDataPoint.data)) {
				uniqueDataPoint.numberOfOccurences++;
				shouldBeAdded = false;
				break;
			}
			shouldBeAdded = true;
		}
		if (shouldBeAdded) {sortedValues.add(new DataPoint(dataPointInListToBeSorted, 1));}
	}
	return sortedValues;
}
 

/**
 * Compares Binary Trees  with same unique values,  and returns true 
 * if their unique values have the same number of occurrences
 * @param original are all elements of the current Binary Tree itself stored in a LinkedList
 * @param other is the other Binary Tree to which we are comparing the current tree
 * @return
 */
 public boolean hasSameOccurances (LinkedList<Integer> original, IBinTree other) {
	LinkedList<DataPoint> list1 = this.storeUniqueInList(original);
	LinkedList<DataPoint> list2 = other.storeUniqueInList();
	int numOfSameOccurances = 0;
	for (DataPoint pointInList1 : list1) {
		for(DataPoint pointInList2 : list2) {
			if(pointInList1.equals(pointInList2))
			{
				numOfSameOccurances++;
			}	
		}
	}
	return numOfSameOccurances == list1.size();
 }
}

