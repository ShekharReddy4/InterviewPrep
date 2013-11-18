package trees.and.graphs;

import linkedlist.Queue;

public class BinarySearchTree<T extends Comparable> {
	public BinaryTreeNode<T> root;
	
	public BinarySearchTree(T rootData) {
		root = new BinaryTreeNode<T>(rootData);
	}
	
	private class BinaryTreeNode<T extends Comparable> {
		private T data;
		private BinaryTreeNode<T> parent;
		private BinaryTreeNode<T> left;
		private BinaryTreeNode<T> right;
		
		private BinaryTreeNode(T data) {
			this.data = data;
			parent = null;
			left = null;
			right = null;
		}
		
		public BinaryTreeNode<T> getParent() { return parent; }
		public BinaryTreeNode<T> getLeft() { return left; }
		public BinaryTreeNode<T> getRight() { return right; }
		public T getData() { return data; }
		
		public void setLeft(BinaryTreeNode<T> setMe) {
			left = setMe;
		}
		public void setRight(BinaryTreeNode<T> setMe) {
			right = setMe;
		}
	}
	
	void add(T data) {
		BinaryTreeNode<T> curr = this.root;
		BinaryTreeNode<T> parent = this.root;
		
		while (curr != null) {
			if (data.compareTo(curr.data) <= 0) {
				parent = curr;
				curr = curr.getLeft();
			}
			else {
				parent = curr;
				curr = curr.getRight();
			}
		}
		BinaryTreeNode<T> addNode = new BinaryTreeNode<T>(data);
		// Need to determine if this is the left or right child
		if (data.compareTo(parent.data) <= 0) {
			parent.setLeft(addNode);
		}
		else {
			parent.setRight(addNode);
		}
	}
	
	// If the search tree isn't allowed duplicates because it is a TreeSet...
	// Note this is extremely bad OOP practice; a different class should
	// extend this class and override add instead.
	boolean setAdd() {
		
		return false;
	}
	
	void breadthTraverse(BinaryTreeNode<T> curr, Queue queue) {
		if (curr != null) {
			queue.enqueue(curr);
		}
		if (curr.left != null) {
			breadthTraverse(curr.left, queue);
		}
		if (curr.right != null) {
			breadthTraverse(curr.right, queue);
		}
	}
	
	int getHeight() {
		
		return 0;
	}
	
	void printTree(BinaryTreeNode<T> curr) {
		if (curr != null) {
			System.out.println(curr.data);
		}
		if (curr.left != null) {
			printTree(curr.left);
		}
		if (curr.right != null) {
			printTree(curr.right);
		}
	}
}
