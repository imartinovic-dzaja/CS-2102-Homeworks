/*
 * Represents a data point in a BST which allows duplicates, stores it and its number of occurrences in the BST
 */

public class DataPoint {
	int data;
	int numberOfOccurences;
	
	// constructor
	public DataPoint (int data, int numberOfOccurences) {
		this.data = data;
		this.numberOfOccurences = numberOfOccurences;
	}
	
	/**
	 * Returns true if the current and another DataPoint object have same field values
	 * @param other is the other DataPoint object
	 * @return true if the field values are the same
	 */
	public boolean equals (DataPoint other) {
		return (this.data == other.data && this.numberOfOccurences == other.numberOfOccurences);
	}
}
