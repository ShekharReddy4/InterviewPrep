package linkedlist;
public class LinkedList {
	private Node root;

	public LinkedList() {
		root = null;
	}

	private class Node {
		Node next = null;
		Object data;
	}

	void add(Object data) {
		Node node = new Node();
		node.data = data;
		node.next = root;
		root = node;
	}

	Node find(Object data) {
		Node tmp = this.root;
		while (tmp != null && tmp.data != data) {
			tmp = tmp.next;
		}
		return tmp;
	}

	void clear() {
		this.root = null;
	}

	void remove(Object data) {
		try {
			Node tmp = this.root;

			if (tmp.data == data) {
				root = tmp.next;
				return;
			}

			while (tmp != null) {
				if (tmp.next.data == data) {
					tmp.next = tmp.next.next;
					return;
				}
				tmp = tmp.next;
			}
		} catch (NullPointerException ex) {
			System.out.println("Data doesn't exist!");
		}
	}

	void printList() {
		Node tmp = this.root;
		while (tmp != null) {
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}

	Node returnLastMth(int m) throws IllegalArgumentException {
		if (m < 1) {
			System.out.println("Only 1 or more");
			throw new IllegalArgumentException();
		}

		// This is the guy that's going m nodes first
		Node scout = root;
		Node ret;
		try {
			while (m > 1) {
				scout = scout.next;
				m--;
			}
		} catch (NullPointerException ex) {
			System.out.println("The list isn't even that long!");
			throw new IllegalArgumentException();
		}
		ret = root;
		while (scout.next != null) {
			scout = scout.next;
			ret = ret.next;
		}
		return ret;
	}
}
