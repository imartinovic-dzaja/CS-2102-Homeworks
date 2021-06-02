/*
 * Provides testing functionality for IHeap.addElt() and IHeap.remMinElt()
 */
public class HeapChecker {
	
	/**
	 * Consumes an element a Heap and a Binary Tree , then returns whether the  Binary Tree is a valid heap formed
	 * By adding the element to the  heap
	 * @param hOrig is the original heap
	 * @param elt is the element to e added to the heap
	 * @param hAdded is the supposed resulting Binary tree
	 * @return true if the Binary Tree is a valid heap formed by adding the element from the heap
	 */
	  boolean addEltTester(IHeap hOrig, int elt, IBinTree hAdded) {
		  
		  
		  if (!hAdded.isHeap()) {return false;}
		  
		  if (hOrig.hasUnexpectedElements(hOrig.listElements().add(elt), hAdded))
		  {
			  return false;
		  }
		  
		  
		  return (hOrig.hasSameOccurances(hOrig.listElements().add(elt), hAdded));
		  
		  
	  }	  
	
	  /**
		 * Consumes a Heap and a Binary Tree , then returns whether the  Binary Tree is a valid heap formed
		 * By removing the smallest element from the  heap
		 * @param hOrig is the original heap
		 * @param hRemoved is the supposed resulting Binary tree
		 * @return true if the Binary Tree is a valid heap formed by removing the smallest element from the heap
		 */
	  boolean remMinEltTester(IHeap hOrig, IBinTree hRemoved) {
		  
		  if (!hRemoved.isHeap()) {return false;}
		  
		  if(hOrig.listElements().list.isEmpty()) {
			  return (hRemoved.listElements().list.isEmpty());
		  }
		  
		  if (hOrig.hasUnexpectedElements(hOrig.listElements().removeLast(), hRemoved))
		  {
			  return false;
		  }
		  
		  
		  return (hOrig.hasSameOccurances(hOrig.listElements().removeLast(), hRemoved));
		  
	  }
	
	
}
	
	
	
