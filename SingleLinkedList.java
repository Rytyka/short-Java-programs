package programs;

public class SingleLinkedList {
	
	SingleLinkedListNode head;
	int count;
	static int count_2 = 0;

	public SingleLinkedList() {
		head = null;
		count = 0;
	}
	
	public SingleLinkedList(SingleLinkedListNode newNode) {
		head = newNode;
		count = 1;
	}
	
	public void add(int newData) {
		SingleLinkedListNode tmp = new SingleLinkedListNode(newData);
		
		if(head == null) {head = tmp; count=1;}
		else {
		SingleLinkedListNode current = head;
		while(current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(tmp);
		count++;
		}
	}
	
	public int get(int index) {
		if(index <=0 || head==null) return -1;
		SingleLinkedListNode current = head;
		while(index>0 && current.getNext()!=null) {
			current = current.getNext();
			index--;
		}
		return current.getData();
	}
	
	public SingleLinkedListNode getNode(int index) {
		if(index <=0 || head==null) return null;
		SingleLinkedListNode current = head;
		while(index>0 && current.getNext()!=null) {
			current = current.getNext();
			index--;
		}
		return current;
	}
	
	public int size() {
		return count;
	}

	public boolean isEmpty() {
		if(head == null) return true;
		return false;
	}
	
	public void remove() {
		//remove from the back of the list
		SingleLinkedListNode current = head;
		if(head == null) return;
		while(current.getNext().getNext()!=null) {
			current = current.getNext();
		}
		current.setNext(null);
		count--;
	}
	
	public void printList() {
		SingleLinkedListNode current = head;
		while(current.getNext()!=null) {
			System.out.print(current.getData()+"->");
			current = current.getNext();
		}
		System.out.println(current.getData());
	}
	

	public void removeDuplicates() {
		//SingleLinkedListNode current = head;
		if(head == null) return;
		SingleLinkedListNode prev = head;
		SingleLinkedListNode current = prev.getNext();
		while(current != null) {
			SingleLinkedListNode runner = head;
		while(runner!=current) {
			if(runner.data == current.data) {
				SingleLinkedListNode tmp = current.getNext();
				prev.setNext(tmp);
				current = tmp;
				break;
			}
			runner = runner.getNext();

		}
		if(runner == current) {
			prev = current;
			current = current.getNext();
		}
	}
	}
	
	
	public void nthFromLastElement(SingleLinkedListNode head,int n) {
		SingleLinkedListNode current = head;
		if(current == null) return;
		nthFromLastElement(current.getNext(),n);
		if(++count_2 == n) System.out.println(current.data);
		
	}
	
	public void deleteFromMiddle(SingleLinkedListNode mid) {
		SingleLinkedListNode current = head;
		while(current.getNext() != mid) {
			current = current.getNext();
		}
		current.setNext(mid.getNext());
		
	}
	
	public SingleLinkedList addition(SingleLinkedListNode a, SingleLinkedListNode b) {
		SingleLinkedListNode curr_a = a;
		SingleLinkedListNode curr_b = b;
		int carry = 0;
		int sum;
		
		SingleLinkedList ans = new SingleLinkedList();
		while(curr_a!=null || curr_b!=null) {
			sum = carry;
			if(curr_a!=null) {sum += curr_a.getData(); curr_a=curr_a.getNext();}
			if(curr_b!=null) {sum += curr_b.getData(); curr_b = curr_b.getNext();}
				carry = sum/10;
				sum = sum%10;
			    ans.add(sum);
		}
		if(carry >0 ) ans.add(carry);
		return ans;
	}
	
	public SingleLinkedListNode circularStart(SingleLinkedListNode a) {
		SingleLinkedListNode slow = a;
		SingleLinkedListNode fast = a;
		SingleLinkedListNode runner = a;
		SingleLinkedListNode walker = a;
		slow = slow.getNext();
		fast = fast.getNext().getNext();
		while(slow!=fast) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		int len = 1;
		slow = slow.getNext();
		while(slow!=fast) {
			slow = slow.getNext();
			len++;
		}
		System.out.println("len: "+len);
		while(len>0) {
			runner = runner.getNext();
			len--;
		}
		while(walker!=runner) {
			walker=walker.getNext();
			runner=runner.getNext();
		}
		return walker;		
		
	}
	
	
	public static void main(String[] args) {
		
		SingleLinkedListNode ritika = new SingleLinkedListNode(5);
		SingleLinkedListNode ritika_2 = new SingleLinkedListNode(2);
		SingleLinkedList ll = new SingleLinkedList(ritika);
		ll.add(5);
		ll.add(7);
		
		ll.add(10);
		ll.add(19);
		ll.add(4);
		ll.add(6);
		
		System.out.println(ll.count);
		ll.printList();
		//ll.removeDuplicates();
		//ll.printList();
		ll.nthFromLastElement(ritika,4);
		//System.out.println(ans.getData());
		SingleLinkedListNode mid = ll.getNode(ll.size()/2);
		ll.deleteFromMiddle(mid);
		ll.printList();
		
		SingleLinkedListNode a1= new SingleLinkedListNode(3);
		SingleLinkedListNode b1 = new SingleLinkedListNode(5);
		SingleLinkedList a = new SingleLinkedList(a1); a.add(1); a.add(5);  //3 -> 1 -> 5
		SingleLinkedList b = new SingleLinkedList(b1); b.add(9); b.add(4); b.add(1); //5 -> 9 -> 4 -> 1
		SingleLinkedList ans = ll.addition(a1,b1);
		System.out.println();
		ans.printList();
		
		//Circular list
		ll.printList();
		ll.getNode(ll.size()-1).setNext(ll.getNode(3));
		SingleLinkedListNode cs= ll.circularStart(ritika);
		System.out.println(cs.getData());
	}

}
