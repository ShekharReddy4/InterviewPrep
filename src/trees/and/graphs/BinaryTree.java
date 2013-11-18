package trees.and.graphs;

import linkedlist.Queue;

public class BinaryTree<T> {
	public BinaryTreeNode<T> root;
	
	public BinaryTree(T rootData) {
		root = new BinaryTreeNode<T>(rootData);
	}
	
	private class BinaryTreeNode<T> {
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
	
	boolean balancedAdd(BinaryTreeNode<T> curr, T data) {
		if (curr.left == null) {
			BinaryTreeNode<T> addMe = new BinaryTreeNode<T>(data);
			curr.left = addMe;
			return true;
		} else if (curr.right == null) {
			BinaryTreeNode<T> addMe = new BinaryTreeNode<T>(data);
			curr.right = addMe;
			return true;
		} else {
			
		}
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
