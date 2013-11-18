package linkedlist;
public class AlternateLL {
	private Node root;

	// This alternate implementation removes by checking reference of object
	// instead of value of the data in the node
	public AlternateLL() {
		root = null;
	}

	private class Node {
		Object data;
		Node next;

		private Node(Object data) {
			this.data = data;
		}
	}

	void insertInFront(Object data) {
		Node insertMe = new Node(data);
		insertMe.next = root;
		root = insertMe;
	}

	void remove(Node removeMe) {
		try {
			Node tmp = root;
			if (tmp == removeMe) {
				root = tmp.next;
				return;
			}

			while (tmp.next != removeMe) {
				tmp = tmp.next;
			}
			tmp.next = removeMe.next;
		} catch (NullPointerException nex) {
			System.out.println("The passed in Node doesn't exist in the list!");
		}

	}

	Node find(Object data) {
		Node tmp = root;
		while (tmp != null && tmp.data != data) {
			tmp = tmp.next;
		}
		return tmp;
	}

	void printList() {
		Node tmp = this.root;
		while (tmp != null) {
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}
}
