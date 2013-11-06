public class Main {

	public static void main(String[] args) {
		linkedListTest();
		//stackTest();
		//queueTest();
	
	}

	public static void queueTest() {
		Queue q = new Queue();
		Integer a = new Integer(1);
		Integer b = new Integer(2);
		Integer c = new Integer(3);
		q.queue(a);
		q.queue(b);
		q.queue(c);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.queue(a);
		q.queue(b);
		q.printQueue();
	}
	
	public static void stackTest() {
		Stack stack = new Stack();
		Integer a = new Integer(1);
		stack.push(a);
		Integer b = new Integer(2);
		stack.push(b);
		Integer c = new Integer(3);
		stack.push(c);
		stack.printStack();
	}
	
	public static void linkedListTest() {
		LinkedList ll = new LinkedList();
		Integer a = new Integer(1);
		ll.add(a);
		Integer b = new Integer(2);
		ll.add(b);
		Integer c = new Integer(3);
		ll.add(c);

		//System.out.println(ll.find(c));
		//ll.remove(a);
		//ll.clear();
		ll.printList();
		
		if (c>b) {
			System.out.println("True");
		}
	}
}
