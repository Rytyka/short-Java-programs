package programs;

public class SingleLinkedListNode {
	
	SingleLinkedListNode next;
	int data;

	public SingleLinkedListNode(int newData) {
		next = null;
		data = newData;
	}
	
	public SingleLinkedListNode(int newData, SingleLinkedListNode nextNode) {
		next = nextNode;
		data = newData;
	}
	
	//Getters and Setters
	
	public SingleLinkedListNode getNext() {
		return next;
	}
	
	public int getData() {
		return data;
	}
	
	public void setNext(SingleLinkedListNode nextNode) {
		next = nextNode;
	}
	
	public void setData(int newData) {
		data = newData;		
	}
}
