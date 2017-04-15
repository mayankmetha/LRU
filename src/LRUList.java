
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
	
	void addPage(String data) {
		Node toAdd = new Node(data);
		(head.next).prev = toAdd;
		toAdd.next = head.next;
		head.next = toAdd;
		toAdd.prev = head;
	}
	
	void delPage() {
		tail.prev = tail.prev.prev;
		tail.prev.next = tail;
	}
	
	void repos(int nodePos) {
		Node temp = head.next;
		for(int i=1;i<=nodePos;i++) {
			temp = temp.next;
			if(temp==tail) break;
		}
		head.next.prev = temp;
		temp.next = head.next;
		temp.prev = head;
		head.next = temp;
	}
	
	void Set(String value) {
		if(cnt<Capacity) {
			addPage(value);
			cnt++;
		} else {
			if(search(value)==0)
			{	addPage(value);
				delPage();
			} else {
				repos(search(value));
			}
		}
	}
	
	int search(String value) {
		Node temp = head;
		int i=1;
		for(temp=head.next;temp!=tail;temp=temp.next) {
			if(temp.data==value)
				return i;
			i++;
		}
		return 0;
	}
	
	void disp() {
		System.out.println("Content of LRU Stack:");
		Node temp;
		for(temp = head.next;temp.next!=tail;temp=temp.next)
			System.out.print(temp.data+"->");
		System.out.println(temp.data);
	}
}
