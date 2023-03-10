class LinkedList {

	Node head;
	Node tail;

	LinkedList(Node headNode) {
		head = headNode;
		tail = headNode;
	}

	void prependNode(Node node) {
		node.next = head;
		head = node;
	}

	void appendNode(Node node) {
		tail.next = node;
		tail = tail.next;
	}
	//insert after the nth node, with indexing starting at 0
	void insertNode(Node node, int n) {
		Node current = head;
		int count = 0;
		while (count<n) {
			current = current.next;
			count++;
		}
		Node inter = current.next;
		current.next = node;
		node.next = inter;
	}
	//delete the node at the nth position, with indexing starting again at 0
	void deleteNode(int n) {
		Node current = head;
		int count = 0;
		if (n!=0) {
			while(count<n-1) {
				current = current.next;
				count++;
			}
			Node inter = current.next.next;
			current.next = inter;
		}
		else {
			head = current.next;
		}
	}

	void traverseAndPrint() {
		Node current = head;
		while (current != null) {
			System.out.print(current.value); // Print out value of node
			if (current == head || current == tail) {
				System.out.println(" <");
			} else {
				System.out.println();
			}
			current = current.next; // Move to next node
		}
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList(new Node(2));
		ll.appendNode(new Node(1));
		ll.appendNode(new Node(3));
		ll.prependNode(new Node(5));
		ll.insertNode(new Node(4), 0);
		ll.traverseAndPrint();
		ll.deleteNode(1);
		ll.traverseAndPrint();
		ll.deleteNode(0);
		ll.traverseAndPrint();
	}

}