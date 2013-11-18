package linkedlist;
public class Stack {
	private Node top;

	public Stack() {
		top = null;
	}

	private class Node {
		Node next = null;
		Object data;
	}

	void push(Object data) {
		Node node = new Node();
		node.data = data;
		node.next = top;
		top = node;
	}

	Node pop() {
		try {
			Node ret = top;
			top = top.next;
			return ret;
		} catch (NullPointerException ex) {
			System.out.println("Stack is empty!");
			return null;
		}
	}

	void clear() {
		top = null;
	}

	void printStack() {
		Node tmp = this.top;
		while (tmp != null) {
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}
}
