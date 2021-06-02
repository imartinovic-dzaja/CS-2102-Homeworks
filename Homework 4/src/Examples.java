import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

// Student who worked on the assignment: Ivan Martinovic

public class Examples {
	
	////////////////////////////////////////// Testing Helpers ///////////////////////////////////////////////////
																										
	DataHeap element1 = new DataHeap (99);
	DataHeap element2 = new DataHeap (90);
	DataHeap element3 = new DataHeap (80, element1, element2);
	
	DataHeap element4 = new DataHeap (85);
	DataHeap element5 = new DataHeap (88);
	DataHeap element6 = new DataHeap (80, element4, element5);

	DataHeap element7 = new DataHeap (20, element3, element6);
	
	DataHeap element8 = new DataHeap (86, element4, element5);
	DataHeap element9 = new DataHeap (20, element3, element8);
	
	/*Valid Heap							InvalidHeap
	/*		 20									  20
	/*	  / 	 \							   /      \
	/*	 80		 80							  80	  86
	/*	/	\	/	\						 /  \    /	\
	/*	99	90	85	88						99	90	85	88
	 */
	
	
	HeapChecker checker1 = new HeapChecker ();
	
	@Test
	public void testIsHeapOnAEmptyHeap() {
		assertTrue((new MtHeap().isHeap()));
	}
	
	@Test
	public void
	testIsHeapOnASingleNode() {
		assertTrue(element1.isHeap());
	}
	
	@Test
	public void testIsHeapOnAValidHeap() {
		assertTrue(element7.isHeap());
	}
	
	
	@Test 
	public void testIsHeapOnAInvalidHeap() {
		assertFalse(element9.isHeap());
	}
	
	@Test
	public void testListElements() {
		LinkedList<Integer> expectedList = new LinkedList<Integer> ();
		expectedList.add(99);
		expectedList.add(90);
		expectedList.add(80);
		expectedList.add(85);
		expectedList.add(88);
		expectedList.add(86);
		expectedList.add(20);
		  assertTrue(element9.listElements().list.equals(expectedList));
		  }
	
	@Test 
	public void testhasUnexpectedElements1() {
		
		/*Valid Heap (element 7)  			 	 OtherHeap (element 9)
		/*		 20									  20
		/*	  / 	 \							   /      \
		/*	 80		 80							  80	  86
		/*	/	\	/	\						 /  \    /	\
		/*	99	90	85	88						99	90	85	88
		 */
		
		assertTrue(element7.hasUnexpectedElements(element7.listElements().list, element9));
	}
	
	@Test 
	public void testhasUnexpectedElements2() {
		DataHeap element10 = new DataHeap(80, element3, element6);
		/*Valid Heap (element 7)  			 	 OtherHeap (element 10)
		/*		 20									  80
		/*	  / 	 \							     /  \
		/*	 80		 80							  80	 80
		/*	/	\	/	\						 /  \    / \
		/*	99	90	85	88						99	90	85  88
		 */
		assertFalse(element7.hasUnexpectedElements(element7.listElements().list, element10));
	}
		
	@Test
	public void testStoreUniqueInListDataBTVersion1() {
		System.out.println("Testing DataBT.StoreUniqueInList (Without parameters)");
		/*Valid Heap (element 7)  			 	
		/*		 20									  
		/*	  / 	 \							     
		/*	 80		 80							  
		/*	/	\	/	\						 
		/*	99	90	85	88						
		 */
		
		LinkedList<DataPoint> list = element7.storeUniqueInList();
		
		for(DataPoint element : list) {
			System.out.println("Data Value: " + element.data + " 	Occurences: " + element.numberOfOccurences);
		}
		System.out.println("Expected results are: 20 occurs 1 time");
		System.out.println("		    : 80 occurs 2 times");
		System.out.println("		    : 85 occurs 1 time");
		System.out.println("		    : 88 occurs 1 time");
		System.out.println("		    : 90 occurs 1 time");
		System.out.println("		    : 99 occurs 1 time");


	}
	
	@Test
	public void testStoreUniqueInListDataBtVersion2() {
		System.out.println("Testing DataBT.StoreUniqueInList (With parameters)");
		/*Valid Heap (element 7)  			 	
		/*		 20									  
		/*	  / 	 \							     
		/*	 80		 80							  
		/*	/	\	/	\						 
		/*	99	90	85	88						
		 */
		
		LinkedList<DataPoint> list = element7.storeUniqueInList(element7.listElements().list);
		
		for(DataPoint element : list) {
			System.out.println("Data Value: " + element.data + " 	Occurences: " + element.numberOfOccurences);
		}
		System.out.println("Expected results are: 20 occurs 1 time");
		System.out.println("		    : 80 occurs 2 times");
		System.out.println("		    : 85 occurs 1 time");
		System.out.println("		    : 88 occurs 1 time");
		System.out.println("		    : 90 occurs 1 time");
		System.out.println("		    : 99 occurs 1 time");
	}
	
	@Test
	public void testStoreUniqueInListMtBTVersion1()
	{
		assertTrue(emptyHeap.storeUniqueInList().equals(new LinkedList<DataPoint> ()));
	}
	
	@Test
	public void testStoreUniqueInListMtBTVersion2()
	{
		assertTrue(emptyHeap.storeUniqueInList(new LinkedList<Integer> ()).equals(new LinkedList<DataPoint> ()));
	}
	
	@Test 
	public void testhasSameOccurancesDataBT1() {
		
		DataHeap element10 = new DataHeap(20, element4, element5);
		DataHeap element11 = new DataHeap(20, element3, element10);
		/*First Heap (element 7)  			 	 Second Heap(element 11)
		/*		 20									  20
		/*	  / 	 \							   /      \
		/*	 80		 80							  80	  20
		/*	/	\	/	\						 /  \    /	\
		/*	99	90	85	88						99	90	85	88
		 */
		
		assertFalse(element7.hasSameOccurances(element7.listElements().list, element11));
		}	
	
	@Test 
	public void testcompareOccurancesDataBT2() {
		DataHeap element10 = new DataHeap(20, element4, element5);
		DataHeap element11 = new DataHeap(80, element3, element10);
		/*First Binary Tree (element 7)  		 Second Binary Tree(element 11)
		/*		 20									  80
		/*	  / 	 \							   /      \
		/*	 80		 80							  80	  20
		/*	/	\	/	\						 /  \    /	\
		/*	99	90	85	88						99	90	85	88
		 */
		
		assertTrue(element7.hasSameOccurances(element7.listElements().list, element11));
		}	
	
	
	@Test 
	public void testcompareOccurancesMtBT1() {
		assertTrue(emptyHeap.hasSameOccurances(emptyHeap.listElements().list, new MtHeap()));
		}	
	
	@Test 
	public void testcompareOccurancesMtBT2() {
		assertFalse(emptyHeap.hasSameOccurances(emptyHeap.listElements().list, element1));
		}	
	
	// One test of addEltTester Ran agains AddElt
	@Test
	public void testAddElt () {
		assertTrue(checker1.addEltTester(element7, 0, element7.addElt(0)));
	}
	
	// One test of remMinEltTester Ran against remMinElt
	@Test
	public void testRemElt () {
		assertTrue(checker1.remMinEltTester(element7, element7.remMinElt()));
	}
	
	
	
	//////////////////////////////////////////// Testing AddEltTester; ///////////////////////////////////////////////////

	MtHeap emptyHeap = new MtHeap();
	DataHeap node1 = new DataHeap (100);
	DataHeap node2 = new DataHeap (60);
	DataHeap node3 = new DataHeap (60, node1, node1);
	
	/// Empty Heap

	@Test
	public void testAddEltTesterOnAnEmptyHeapAndResultIsValid() {
		System.out.println(emptyHeap.hasUnexpectedElements(emptyHeap.listElements().add(100), node1));
		System.out.println(emptyHeap.hasSameOccurances(emptyHeap.listElements().add(100), node1));
		
		assertTrue(checker1.addEltTester(emptyHeap, 100, node1));
	}
	
	@Test
	public void testAddEltTesterOnAnEmptyHeapAndResultIsAUnexpectedNode() {
		assertFalse(checker1.addEltTester(emptyHeap, 100, node2));
	}
	
	@Test
	public void testAddEltTesterOnAnEmptyHeapAndResultHasCorrectElementsButIncorrectOccurrances() {
		assertFalse(checker1.addEltTester(emptyHeap, 100, node3));
	}
	
	@Test
	public void testAddEltTesterOnAnEmptyHeapAndResultDidNotAddTheElement() {
		assertFalse(checker1.addEltTester(emptyHeap, 100, emptyHeap));
	}
	
	DataHeap node4 = new DataHeap(10);
	DataHeap node5 = new DataHeap(20);
	DataHeap node6 = new DataHeap(0);
	
	/// Single Node Case a)

	@Test
	public void testAddEltTesterOnASingleNodeHeapAddingADifferentSmallerElementAndValidResult() {
		DataHeap node7 = new DataHeap(0, node4, new MtHeap());
		/*
		 * 				0
		 * 			   / \
  		 *			 10   
		 */
		
		
		assertTrue(checker1.addEltTester(node4, 0, node7));
	}
	
	@Test
	public void testAddEltTesterOnASingleNodeHeapAddingADifferentSmallerElementAndResultHasRightElementsAndOccurencesButIsNotAHeap() {
		DataHeap node7 = new DataHeap(10, node6, new MtHeap());
		/*
		 * 				10
		 * 			   / \
  		 *			  0   
		 */

		assertFalse(checker1.addEltTester(node4, 0, node7));
	}
	
	@Test
	public void testAddEltTesterOnASingleNodeHeapAddingADifferentSmallerElementAndResultIsAHeapButHasUnexpectedElements() {
		DataHeap node7 = new DataHeap(0, node4, node5);
		
		/*
		 * 				0
		 * 			   / \
  		 *			 10  20 
		 */
		assertFalse(checker1.addEltTester(node4, 0, node7));
	}
	
	@Test
	public void testAddEltTesterOnASingleNodeHeapAddingADifferentSmallerElementAndResultIsAHeapWithExpectedElementsButWithIncorrectNumberOfOccurencesForOtherElements() {
		DataHeap node7 = new DataHeap(0, node4, node4);
		/*
		 * 				0
		 * 			   / \
  		 *			 10  10 
		 */
		assertFalse(checker1.addEltTester(node4, 0, node7));
	}
	
	@Test
	public void testAddEltTesterOnASingleNodeHeapAddingADifferentSmallerElementAndResultIsAHeapWithExpectedElementsButWithIncorrectNumberOfOccurencesForAddedElement() {
		DataHeap node7 = new DataHeap(0, node4, node6);
		
		/*
		 * 				0
		 * 			   / \
  		 *			 10   0 
		 */

		assertFalse(checker1.addEltTester(node4, 0, node7));	
	}
	
	/// Single Node Case b)

	@Test
	public void testAddEltTesterOnASingleNodeHeapAddingADifferentBiggerElementAndValidResult() {
		DataHeap node7 = new DataHeap (10, node5, new MtHeap());
		/*
		 * 				10
		 * 			   / \
  		 *			 20   
		 */

		assertTrue(checker1.addEltTester(node4, 20, node7));
	}
	
	@Test
	public void testAddEltTesterOnASingleNodeHeapAddingADifferentBiggerElementAndResultHasRightElementsAndOccurencesButIsNotAHeap() {
		DataHeap node7 = new DataHeap (20, node4,  new MtHeap());
		/*
		 * 				20
		 * 			   / \
  		 *			 10   
		 */
		assertFalse(checker1.addEltTester(node4, 20, node7));
	}
	
	@Test
	public void testAddEltTesterOnASingleNodeHeapAddingADifferentBiggerElementAndResultIsAHeapButHasUnexpectedElements() {
		DataHeap node7 = new DataHeap (10, node5,  node6);
		/*
		 * 				10
		 * 			   / \
  		 *			 20   
		 */
		assertFalse(checker1.addEltTester(node4, 20, node7));
	}
	

	@Test
	public void testAddEltTesterOnASingleNodeHeapAddingADifferentBiggerElementAndResultIsAHeapWithExpectedElementsButWithIncorrectNumberOfOccurencesForOtherElements() {
		DataHeap node7 = new DataHeap (10, node5,  node4);
		/*
		 * 				10
		 * 			   / \
  		 *			 20  10 
		 */
		assertFalse(checker1.addEltTester(node4, 20, node7));
	}
	
	@Test
	public void testAddEltTesterOnASingleNodeHeapAddingADifferentBiggerElementAndResultIsAHeapWithExpectedElementsButWithIncorrectNumberOfOccurencesForAddedElement() {
		DataHeap node7 = new DataHeap (10, node5,  node5);
		/*
		 * 				10
		 * 			   / \
  		 *			 20   20
		 */
		System.out.println(node4.storeUniqueInList().size());
		System.out.println(node7.storeUniqueInList().size());

		assertFalse(checker1.addEltTester(node4, 20, node7));
	}
	
	/// Single Node Case c)

	@Test
	public void testAddEltTesterOnASingleNodeHeapAddingAEqualElementAndResultIsValid() {
		DataHeap node7 = new DataHeap (10, node4,  new MtHeap());
		
		/*
		 * 				10
		 * 			   / \
  		 *			 10   
		 */
		assertTrue(checker1.addEltTester(node4, 10, node7));
	}
	
	@Test
	public void testAddEltTesterOnASingleNodeHeapAddingAEqualElementAndIsAHeapButHasUnexpectedElements() {
		DataHeap node7 = new DataHeap (10, node4,  node5);
		/*
		 * 				10
		 * 			   / \
  		 *			 20   
		 */

		assertFalse(checker1.addEltTester(node4, 10, node7));
	}
	
	@Test
	public void testAddEltTesterOnASingleNodeHeapAddingAEqualElementAndResultIsAHeapWithExpectedElementsButWithIncorrectNumberOfOccurences() {
		DataHeap node7 = new DataHeap (10, node4,  node4);
		/*
		 * 				10
		 * 			   / \
  		 *			 10  10 
		 */

		assertFalse(checker1.addEltTester(node4, 10, node7));
	}
	
	DataHeap node8 = new DataHeap (50);
	DataHeap node9 = new DataHeap (40);
	DataHeap node10 = new DataHeap (20, node8, node9);
	
	DataHeap node11 = new DataHeap (40);
	DataHeap node12 = new DataHeap (30);
	DataHeap node13 = new DataHeap (20, node11, node12);

	DataHeap node14 = new DataHeap (10, node10, node13);
	
	
	/// Heap of Height 3 Case a)
		
	/*Heap							
	 *		 10									
	 *	  / 	 \							   
	 *	 20		 20							
	 *	/	\	/	\						
	 *	50	40	40	30						
	 */
	
	@Test
	public void testAddEltTesterOnAHeapOfHeightThreeAddingANewRootAndResultIsValid() {
		DataHeap node15 = new DataHeap (0, node14, new MtHeap());
		assertTrue(checker1.addEltTester(node14, 0, node15));
		/*Heap							
	 	 *			 0
		 *  		/ \
		 *		   10									
	  	 *	 	  /  \							   
	 	 *		20	  20							
		 *	   /  \	 /	\						
  		 *	  50 40	40	30						
		 */
		
	}
	
	@Test
	public void testAddEltTesterOnAHeapOfHeightThreeAddingANewRootAndResultHasCorrectOccurancesButIsNotAHeap() {
		DataHeap node15 = new DataHeap (0);
		DataHeap node16 = new DataHeap(50, node15, new MtHeap());
		DataHeap node17 = new DataHeap(20, node16, node9);
		
		DataHeap node18 = new DataHeap (10, node17, node13);
		
		/*Heap							
		 *		  10									
		 *	     /  \							   
		 *	   20    20							
		 *	  /  \	/	\						
		 *	 50	40	40	30						
		 *  /
		 * 0
		 */
		
		assertFalse(checker1.addEltTester(node14, 0, node18));
	}
	
	@Test
	public void testAddEltTesterOnAHeapOfHeightThreeAddingANewRootAndResultHasUnexpectedElements() {
		DataHeap node15 = new DataHeap (100);
		DataHeap node16 = new DataHeap(50, node15, new MtHeap());
		DataHeap node17 = new DataHeap(20, node16, node9);
		
		DataHeap node18 = new DataHeap (10, node17, node13);
		
		DataHeap node19 = new DataHeap (0, node18, new MtHeap());
		
		/*Heap		
		 * 				 0
		 * 				/ \					
		 *		       10									
		 *	         / 	 \							   
		 *	      20     20							
		 *	     /	\	/	\						
		 *      50	40	40	30	
		 * 		/
		 *     100			
		 */
		
		assertFalse(checker1.addEltTester(node14, 0, node19));
	}
	
	@Test
	public void testAddEltTesterOnAHeapOfHeightThreeAddingANewRootAndResultHasIncorrectOccurencesForOtherElements(){
		DataHeap node15 = new DataHeap (0, node14, node8);
		
		/*Heap		
		 * 				 0
		 * 				/ \					
		 *		       10 50									
		 *	         / 	 \							   
		 *	      20     20							
		 *	     /	\	/	\						
		 *      50	40	40	30	
		 * 					
		 */

		
		assertFalse(checker1.addEltTester(node14, 0, node15));
	}
	
	@Test
	public void testAddEltTesterOnAHeapOfHeightThreeAddingANewRootAndResultHasIncorrectOccurencesForAddedElements(){
		DataHeap node15 = new DataHeap (0, node14, new DataHeap (0));
		
		assertFalse(checker1.addEltTester(node14, 0, node15));
	}
	
	/*Heap		
	 * 				 
	 * 									
	 *		       10  									
	 *	         / 	 \							   
	 *	      20     20							
	 *	     /	\	/	\						
	 *      50	40	40	30	
	 * 					
	 */
	
	/// Heap of Height 3 Case b)

	@Test
	public void testAddEltTesterOnAHeapOfHeightThreeAddingADuplicateElementAndResultIsValid() {
		DataHeap node15 = new DataHeap (50);
		DataHeap node16 = new DataHeap (20, node15, new MtHeap());
		DataHeap node17 = new DataHeap (40);
		DataHeap node18 = new DataHeap (20, node16, node17);
		
		DataHeap node19 = new DataHeap (40);
		DataHeap node20 = new DataHeap (30);
		DataHeap node21 = new DataHeap (20, node19, node20);

		DataHeap node22 = new DataHeap (10, node18, node21);
		
		/*Heap						
		 *		       10  									
		 *	         / 	 \							   
		 *	      20     20							
		 *	     /	\	/	\						
		 *      20	40	40	30	
		 * 		/
		 *     50			
		 */
		assertTrue(checker1.addEltTester(node14, 20, node22));
	}
	
	@Test
	public void testAddEltTesterOnAHeapOfHeightThreeAddingADuplicateElementAndResultHasCorrectOccurancesButIsNotAHeap() {
		DataHeap node15 = new DataHeap (20, node14, new MtHeap());
		
		/*Heap		
		 * 				 20
		 * 				/ \					
		 *		       10  									
		 *	         / 	 \							   
		 *	      20     20							
		 *	     /	\	/	\						
		 *      50	40	40	30	
		 * 					
		 */
		
		assertFalse(checker1.addEltTester(node14, 20, node15));
	}
	
	@Test
	public void testAddEltTesterOnAHeapOfHeightThreeAddingADuplicateElementAndResultHasUnexpectedElements() {
		DataHeap node15 = new DataHeap (50);
		DataHeap node23 = new DataHeap (60);
		DataHeap node16 = new DataHeap (20, node15, node23);
		DataHeap node17 = new DataHeap (40);
		DataHeap node18 = new DataHeap (20, node16, node17);
		
		DataHeap node19 = new DataHeap (40);
		DataHeap node20 = new DataHeap (30);
		DataHeap node21 = new DataHeap (20, node19, node20);

		DataHeap node22 = new DataHeap (10, node18, node21);
		
		/*Heap						
		 *		       10  									
		 *	         / 	 \							   
		 *	      20     20							
		 *	     /	\	/	\						
		 *      20	40	40	30	
		 * 	   / \
		 *    50  60			
		 */
		assertFalse(checker1.addEltTester(node14, 20, node22));
	}
	
	@Test
	public void testAddEltTesterOnAHeapOfHeightThreeAddingADuplicateElementAndResultHasIncorrectOccurencesForOtherElements (){
		/*Heap						
		 *		       10  									
		 *	         / 	 \							   
		 *	      20     20							
		 *	     /	\	/	\						
		 *      20	40	40	30	
		 * 	   / \
		 *    50  20			
		 */
		DataHeap node15 = new DataHeap (50);
		DataHeap node23 = new DataHeap (20);
		DataHeap node16 = new DataHeap (20, node15, node23);
		DataHeap node17 = new DataHeap (40);
		DataHeap node18 = new DataHeap (20, node16, node17);
		
		DataHeap node19 = new DataHeap (40);
		DataHeap node20 = new DataHeap (30);
		DataHeap node21 = new DataHeap (20, node19, node20);

		DataHeap node22 = new DataHeap (10, node18, node21);

		
		assertFalse(checker1.addEltTester(node14, 20, node22));
	}
	/// Heap of Height 3 Case c)

	/*Heap							
	 *		  	 10									
	 *	      /  	 \							   
	 *	   	 20		 20							
	 *	 	/	\	/	\						
	 *	  50	40	40	30						
	 */

	@Test
	public void testAddEltTesterOnAHeapOfHeightThreeAddingAUniqueElementAndResultIsValid() {
		DataHeap node15 = new DataHeap (50);
		DataHeap node16 = new DataHeap (20, node15, new MtHeap());
		DataHeap node17 = new DataHeap (40);
		DataHeap node18 = new DataHeap (15, node16, node17);
	
		DataHeap node19 = new DataHeap (40);
		DataHeap node20 = new DataHeap (30);
		DataHeap node21 = new DataHeap (20, node19, node20);

		DataHeap node22 = new DataHeap (10, node18, node21);
		
		/*Heap							
		 *		  	 10									
		 *	      /  	 \							   
		 *	   	 15		 20							
		 *	 	/	\	/	\						
		 *	  20	40	40	30	
		 *    /
		 *   50					
		 */
		
		assertTrue(checker1.addEltTester(node14, 15, node22));
	}

	@Test
	public void testAddEltTesterOnAHeapOfHeightThreeAddingAUniqueeElementAndResultHasCorrectOccurancesButIsNotAHeap() {
		DataHeap node15 = new DataHeap (15, node14, new MtHeap());
		
		/*Heap		
		 * 				 15
		 * 				/ \					
		 *		       10  									
		 *	         / 	 \							   
		 *	      20     20							
		 *	     /	\	/	\						
		 *      50	40	40	30	
		 * 					
		 */
	
		assertFalse(checker1.addEltTester(node14, 15, node15));
	}

	@Test
	public void testAddEltTesterOnAHeapOfHeightThreeAddingAUniqueElementAndResultHasUnexpectedElements() {
		DataHeap node15 = new DataHeap (50);
		DataHeap node23 = new DataHeap (60);
		DataHeap node16 = new DataHeap (20, node15, node23);
		DataHeap node17 = new DataHeap (40);
		DataHeap node18 = new DataHeap (15, node16, node17);
		
		DataHeap node19 = new DataHeap (40);
		DataHeap node20 = new DataHeap (30);
		DataHeap node21 = new DataHeap (20, node19, node20);
		
		DataHeap node22 = new DataHeap (10, node18, node21);
		
		/*Heap							
		 *		  	 10									
		 *	      /  	 \							   
		 *	   	 15		 20							
		 *	 	/	\	/	\						
		 *	  20	40	40	30	
		 *    / \
		 *   50	 60				
		 */
		assertFalse(checker1.addEltTester(node14, 15, node22));
	}
	
	@Test
	public void testAddEltTesterOnAHeapOfHeightThreeAddingAUniqueElementAndResultHasIncorrectOccurencesForOtherElements() {
		DataHeap node15 = new DataHeap (50);
		DataHeap node23 = new DataHeap (20);
		DataHeap node16 = new DataHeap (20, node15, node23);
		DataHeap node17 = new DataHeap (40);
		DataHeap node18 = new DataHeap (15, node16, node17);
		
		DataHeap node19 = new DataHeap (40);
		DataHeap node20 = new DataHeap (30);
		DataHeap node21 = new DataHeap (20, node19, node20);
		
		DataHeap node22 = new DataHeap (10, node18, node21);
		
		/*Heap							
		 *		  	 10									
		 *	      /  	 \							   
		 *	   	 15		 20							
		 *	 	/	\	/	\						
		 *	  20	40	40	30	
		 *   /  \
		 *  50	20				
		 */
		
	
		assertFalse(checker1.addEltTester(node14, 15, node22));
		}	
	

	@Test
	public void testAddEltTesterOnAHeapOfHeightThreeAddingAUniqueElementAndResultHasIncorrectOccurencesForAddedElement() {
		DataHeap node15 = new DataHeap (50);
		DataHeap node23 = new DataHeap (20);
		DataHeap node16 = new DataHeap (20, node15, node23);

		DataHeap node17 = new DataHeap (40);
		DataHeap node24 = new DataHeap (15, node17, new MtHeap());
		DataHeap node18 = new DataHeap (15, node16, node24);
		
		DataHeap node19 = new DataHeap (40);
		DataHeap node20 = new DataHeap (30);
		DataHeap node21 = new DataHeap (20, node19, node20);
		
		DataHeap node22 = new DataHeap (10, node18, node21);
		
		/*Heap							
		 *		  	 10									
		 *	      /  	 \							   
		 *	   	 15		 20							
		 *	 	/	\	/	\						
		 *	  20	15	40	30	
		 *   /  \   /
		 *  50	20 40			
		 */
		
	
		assertFalse(checker1.addEltTester(node14, 20, node22));
		}	
	
	//////////////////////////////////////////// Testing RemEltTester; ///////////////////////////////////////////////////
	
DataHeap node15 = new DataHeap (100);
DataHeap node16 = new DataHeap (60);



	@Test
	public void testRemMinEltTesterOnAnEmptyHeapAndResultIsValid() {
		assertTrue(checker1.remMinEltTester(emptyHeap, emptyHeap));
	}

	@Test
	public void testRemMinEltTesterOnAnEmptyHeapAndResultIsInvalid1() {
		assertFalse(checker1.remMinEltTester(emptyHeap, node15));
	}

	@Test
	public void testRemMinEltTesterOnSingleNodeAndResultIsValid() {
		assertTrue(checker1.remMinEltTester(node15, emptyHeap));

	}


	@Test
	public void testRemMinEltTesterOnASingleNodeAndTheResultIsNotModified() {
	
		assertFalse(checker1.remMinEltTester(node15, node15));
	}

	@Test
	public void testRemMinEltTesterOnASingleNodeAndResultIsSomethignUnexpected() {

		assertFalse(checker1.remMinEltTester(node15, node16));
	}
	/*Heap							
	 *		  	 10									
	 *	      /  	 \							   
	 *	   	 20		 20							
	 *	 	/	\	/	\						
	 *	  50	40 40	30	
	 *  
	 *  			
	 */


	@Test
	public void testRemMinEltTesterOnAHeapOfHeightThreeAndResultIsValid() {
		
		DataHeap node15 = new DataHeap(50);
		DataHeap node16 = new DataHeap(40, node15, emptyHeap);
		
		DataHeap node17 = new DataHeap(40);
		DataHeap node18 = new DataHeap(30);
		DataHeap node19 = new DataHeap(20, node17, node18);
		
		DataHeap node20 = new DataHeap(20, node16, node19);
		
		/*Heap							
		 *		  	 20									
		 *	      /  	 \							   
		 *	   	 40		 20							
		 *	 	/	\	/	\						
		 *	  50	   40	30	
		 *   			
		 */
		
		assertTrue(checker1.remMinEltTester(node14, node20));
	}

	@Test
	public void testRemMinEltTesterOnAHeapOfHeightThreeAndResultHasCorrectOccurancesButIsNotAHeap() {
		DataHeap node15 = new DataHeap(20);
		DataHeap node16 = new DataHeap(40, node15, emptyHeap);
		
		DataHeap node17 = new DataHeap(40);
		DataHeap node18 = new DataHeap(30);
		DataHeap node19 = new DataHeap(20, node17, node18);
		
		DataHeap node20 = new DataHeap(50, node16, node19);
		
		/*Heap							
		 *		  	 50									
		 *	      /  	 \							   
		 *	   	 40		 20							
		 *	 	/	\	/	\						
		 *	  20	   40	30	
		 *   			
		 */
	
		assertFalse(checker1.remMinEltTester(node14, node20));
	}	
	
	@Test
	public void testRemMinEltTesterOnAHeapOfHeightThreeAndResultHasUnexpectedElements() {
		DataHeap node15 = new DataHeap(50);
		DataHeap node21 = new DataHeap(55);
		DataHeap node16 = new DataHeap(40, node15, node21);
		
		DataHeap node17 = new DataHeap(40);
		DataHeap node18 = new DataHeap(30);
		DataHeap node19 = new DataHeap(20, node17, node18);
		
		DataHeap node20 = new DataHeap(20, node16, node19);
		
		/*Heap							
		 *		  	 20									
		 *	      /  	 \							   
		 *	   	 40		 20							
		 *	 	/  \	/	\						
		 *	  50   55  40	30	
		 *   			
		 */
		
		assertFalse(checker1.remMinEltTester(node14, node20));
	}
	
	@Test
	public void testRemMinEltTesterOnAHeapOfHeightThreeAndResultHasIncorrectOccurencesForOtherElements (){
		DataHeap node15 = new DataHeap(50);
		DataHeap node21 = new DataHeap(50);
		DataHeap node16 = new DataHeap(40, node15, node21);
		
		DataHeap node17 = new DataHeap(40);
		DataHeap node18 = new DataHeap(30);
		DataHeap node19 = new DataHeap(20, node17, node18);
		
		DataHeap node20 = new DataHeap(20, node16, node19);
		
		/*Heap							
		 *		  	 20									
		 *	      /  	 \							   
		 *	   	 40		 20							
		 *	 	/  \	/	\						
		 *	  50   50  40	30	
		 *   			
		 */
		
	assertFalse(checker1.remMinEltTester(node14, node20));
	}
	
	// For Last Case Consider This Heap
	
	/*Heap							
	 *		  	 20									
	 *	      /  	 \							   
	 *	   	 40		 20							
	 *	 	/  \	/	\						
	 *	  50   50  40	30	
	 *   			
	 */
	
	@Test
	public void testRemMinEltTesterOnAHeapOfHeightThreeAndResultHasIncorrectOccurencesForRemovedElement (){
		DataHeap node15 = new DataHeap(50);
		DataHeap node21 = new DataHeap(50);
		DataHeap node16 = new DataHeap(40, node15, node21);
		
		DataHeap node17 = new DataHeap(40);
		DataHeap node18 = new DataHeap(30);
		DataHeap node19 = new DataHeap(20, node17, node18);
		
		DataHeap node20 = new DataHeap(20, node16, node19);
		
		
		DataHeap node22 = new DataHeap(30, node16, node17);
			
		/*Heap							
		 *		  	 30									
		 *	      /  	 \							   
		 *	   	 40		 40							
		 *	 	/  \								
		 *	  50   50  		
		 *   			
		 */
		
		assertFalse(checker1.remMinEltTester(node20, node22));
	}
	
///////////////////////////////Testing Bad Heaps /////////////////////////////////
/*	
@Test
public void testHeap1() {
	TestHeap node15 = new TestHeap (50, new MtHeap(), new MtHeap());
	TestHeap node16 = new TestHeap (20, node15, new MtHeap());
	TestHeap node17 = new TestHeap (40, new MtHeap(), new MtHeap());
	TestHeap node18 = new TestHeap (20, node16, node17);
	
	TestHeap node19 = new TestHeap (40, new MtHeap(), new MtHeap());
	TestHeap node20 = new TestHeap (30, new MtHeap(), new MtHeap());
	TestHeap node21 = new TestHeap (20, node19, node20);

	TestHeap node22 = new TestHeap (10, node18, node21);
	
	/*Heap						
	 *		       10  									
	 *	         / 	 \							   
	 *	      20     20							
	 *	     /	\	/	\						
	 *      20	40	40	30	
	 * 		/
	 *     50			
	 */
/*	
	assertFalse(checker1.addEltTester(node22, 50, node22.addElt(50)));
}

@Test
public void testHeap2() {
	TestHeap2 node15 = new TestHeap2 (50, new MtHeap(), new MtHeap());
	TestHeap2 node16 = new TestHeap2 (20, node15, new MtHeap());
	TestHeap2 node17 = new TestHeap2 (40, new MtHeap(), new MtHeap());
	TestHeap2 node18 = new TestHeap2 (20, node16, node17);
	
	TestHeap2 node19 = new TestHeap2 (40, new MtHeap(), new MtHeap());
	TestHeap2 node20 = new TestHeap2 (30, new MtHeap(), new MtHeap());
	TestHeap2 node21 = new TestHeap2 (20, node19, node20);

	TestHeap2 node22 = new TestHeap2 (10, node18, node21);
	
	/*Heap						
	 *		       10  									
	 *	         / 	 \							   
	 *	      20     20							
	 *	     /	\	/	\						
	 *      20	40	40	30	
	 * 		/
	 *     50			
	 */
	/*
	assertFalse(checker1.remMinEltTester(node22, node22.remMinElt()));
}
@Test
public void testHeap3() {
	TestHeap3 node15 = new TestHeap3 (50, new MtHeap(), new MtHeap());
	TestHeap3 node16 = new TestHeap3 (20, node15, new MtHeap());
	TestHeap3 node17 = new TestHeap3 (40, new MtHeap(), new MtHeap());
	TestHeap3 node18 = new TestHeap3 (20, node16, node17);
	
	TestHeap3 node19 = new TestHeap3 (40, new MtHeap(), new MtHeap());
	TestHeap3 node20 = new TestHeap3 (30, new MtHeap(), new MtHeap());
	TestHeap3 node21 = new TestHeap3 (20, node19, node20);

	TestHeap3 node22 = new TestHeap3 (10, node18, node21);
	
	/*Heap						
	 *		       10  									
	 *	         / 	 \							   
	 *	      20     20							
	 *	     /	\	/	\						
	 *      20	40	40	30	
	 * 		/
	 *     50			
	 */
	/*
	assertFalse(checker1.addEltTester(node22, 50, node22.addElt(50)));
}
@Test
public void testHeap4() {
	TestHeap4 node15 = new TestHeap4 (50, new MtHeap(), new MtHeap());
	TestHeap4 node16 = new TestHeap4 (20, node15, new MtHeap());
	TestHeap4 node17 = new TestHeap4 (40, new MtHeap(), new MtHeap());
	TestHeap4 node18 = new TestHeap4 (20, node16, node17);
	
	TestHeap4 node19 = new TestHeap4 (40, new MtHeap(), new MtHeap());
	TestHeap4 node20 = new TestHeap4 (30, new MtHeap(), new MtHeap());
	TestHeap4 node21 = new TestHeap4 (20, node19, node20);

	TestHeap4 node22 = new TestHeap4 (10, node18, node21);
	
	/*Heap						
	 *		       10  									
	 *	         / 	 \							   
	 *	      20     20							
	 *	     /	\	/	\						
	 *      20	40	40	30	
	 * 		/
	 *     50			
	 */
/*	
	assertFalse(checker1.remMinEltTester(node22, node22.remMinElt()));
}
@Test
public void testHeap5() {
	TestHeap5 node15 = new TestHeap5 (50, new MtHeap(), new MtHeap());
	TestHeap5 node16 = new TestHeap5 (20, node15, new MtHeap());
	TestHeap5 node17 = new TestHeap5 (40, new MtHeap(), new MtHeap());
	TestHeap5 node18 = new TestHeap5 (20, node16, node17);
	
	TestHeap5 node19 = new TestHeap5 (40, new MtHeap(), new MtHeap());
	TestHeap5 node20 = new TestHeap5 (30, new MtHeap(), new MtHeap());
	TestHeap5 node21 = new TestHeap5 (20, node19, node20);

	TestHeap5 node22 = new TestHeap5 (10, node18, node21);
	
	/*Heap						
	 *		       10  									
	 *	         / 	 \							   
	 *	      20     20							
	 *	     /	\	/	\						
	 *      20	40	40	30	
	 * 		/
	 *     50			
	 */
	/*
	assertFalse(checker1.addEltTester(node22, 50, node22.addElt(50)));
}*/
}