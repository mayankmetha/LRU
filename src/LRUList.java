
public class LRUList {
	int Capacity;
	int cnt=0;
	Node head;
	Node tail;
	LRUList() {
		head = new Node("head");
		tail = new Node("tail");
		head.next = tail;
		tail.next = head;
		head.prev = tail;
		tail.prev = head;
	}
	void setCapacity(int capacity) {
		Capacity=capacity;
	}
	
	Node addPage(String data) {
		Node toAdd = new Node(data);
		(head.next).prev = toAdd;
		toAdd.next = head.next;
		head.next = toAdd;
		toAdd.prev = head;
		return head;
	}
	
	Node delPage() {
		tail.prev = tail.prev.prev;
		tail.prev.next = tail;
		return head;
	}
	
	void Set(String value) {
		if(cnt<Capacity) {
			addPage(value);
			cnt++;
		} else {
			addPage(value);
			delPage();
		}
	}
	
	void disp() {
		System.out.println("Content of LRU Stack:");
		Node temp;
		for(temp = head.next;temp.next!=tail;temp=temp.next)
			System.out.print(temp.data+"->");
		System.out.println(temp.data);
	}
}
