package TreesAndGraphs;

public class BinaryTree {
	public Node root;
	
	public BinaryTree(Object rootData) {
		root = new Node(rootData);
	}
	
	private class Node {
		private Node left;
		private Node right;
		private Object data;
		
		private Node(Object data) {
			this.data = data;
			left = null;
			right = null;
		}
		
		public Node getLeft() { return left; }
		public Node getRight() { return right; }
		public Object getData() { return data; }
	}
	
	public void balancedAddNode(Object data) {
		Node curr = root;
		while (curr.getLeft() != null || curr.getRight() != null) {
			curr = curr.getLeft();
		}
	}
}
