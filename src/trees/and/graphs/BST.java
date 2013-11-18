package trees.and.graphs;

// BinarySearchTree.java took an approach of defining a private Node class
// and having a wrapper class around it. Initially I thought it was more
// intuitive to use, but it restricted how I can use the data structure.
// Since a tree is a recursive structure, and a subtree should have access
// to all of the supertree's methods, it makes more sense to implement 
// as I've done here
public class BST<T extends Comparable> {
	T data;
	BST left;
	BST right;
	BST parent;
	
	public BST(T data) {
		this.data = data;
		left = null;
		right = null;
		parent = null;
	}
	
	void insert(BST node, T data) {
		if (data.compareTo(node.data) <= 0) {
			if (node.left == null) {
				node.left = new BST(data);
			}
			else {
				insert(node.left, data);
			}
		} 
		else {
			if (node.right == null) {
				node.right = new BST(data);
			}
			else {
				insert(node.right, data);
			}
		}
	}
	
	static int getHeight(BST root) {
		 if (root == null) {
			 return 0;
		 }
		 else {
			 return 1 + Math.max( getHeight(root.left), getHeight(root.right));
		 }
	}
	
	// Root, then left, then right
	static void preorderTraversal(BST root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data.toString());
		preorderTraversal( root.left );
		preorderTraversal( root.right );
	}
	
	// Left, then root, then right
	static void inorderTraversal(BST root) {
		if (root == null) {
			return;
		}
		inorderTraversal( root.left );
		System.out.println(root.data.toString());
		inorderTraversal( root.right );
	}
	
	// Left, then right, then root
	static void postorderTraversal(BST root) {
		if (root == null) {
			return;
		}
		postorderTraversal( root.left );
		postorderTraversal( root.right );
		System.out.println(root.data.toString());
	}
	
	BST findClosest(T data) {
		if(data == this.data) {
			return this;
		}
		if (data.compareTo(this.data) < 0) {
			if (this.left == null) {
				return this;
			}
			else {
				BST closest = this.left.findClosest(data);
				return Math.abs(this.data.compareTo(data)) < Math.abs(closest.data.compareTo(data)) ? this : closest;
			}
		}
		else {
			if (this.right == null) {
				return this;
			}
			else {
				BST closest = this.right.findClosest(data);
				return Math.abs(this.data.compareTo(data)) < Math.abs(closest.data.compareTo(data)) ? this : closest;
			}
		}
	}
}








