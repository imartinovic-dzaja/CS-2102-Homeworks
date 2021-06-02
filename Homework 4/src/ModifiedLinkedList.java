import java.util.LinkedList;

/*
 * Container for LinkedList
 * Acts as a way to override certain methods of LinkedLists
 */
public class ModifiedLinkedList<E> {

	public LinkedList<E> list;
	
	//Constructor
	public ModifiedLinkedList (LinkedList<E> inputList){
		this.list = inputList;
	}
	
	/**
	 * Takes in an element and adds it to the LinkedList list field
	 * (Difference between ModifiedLinkedList.add() and LinkedList.add()
	 * is that the former returns a linked list, while the latter returns a boolean
 	 * @param elt to be added
	 * @return returns the modified LinkedList
	 */
	public LinkedList<E> add (E elt) {
		this.list.add(elt);
		return this.list;
	}
	
	
	/**
	 * Removes the last element in the LinkedList list field
	 * (Difference between ModifiedLinkedList.removeLast() and LinkedList.removeLast()
	 * is that the former returns a linked list, while the latter returns a boolean
	 * @return returns the modified LinkedList
	 */
	public LinkedList<E> removeLast () {
		this.list.removeLast();
		return this.list;
	}
}
