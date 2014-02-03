package trees.and.graphs;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BST<T extends Comparable> {
	Node root;
	Node lastVisited;
	
	BST() {
		root = null;
	}
	
	class Node {
		Node left;
		Node right;
		T data;
		
		Node(T data) {
			this.data = data;
			left = null;
			right = null;
		}
		
		void add(T data) {
			if (data.compareTo(this.data) <= 0) {
				if (this.left == null) {
					this.left = new Node(data);
				} else {
					left.add(data);
				}
			} else {
				if (this.right == null) {
					this.right = new Node(data);
				} else {
					right.add(data);
				}
			}
		}
		
		void inOrderPrint(Node n) {
			if (n == null) {
				return;
			} else {
				inOrderPrint(n.left);
				System.out.print(n.data + " ");
				inOrderPrint(n.right);
			}
		}
		
		boolean isBST(Node n) {
			if (n == null) {
				return true;
			} else {
				inOrderPrint(n.left);
				
				if (lastVisited.data.compareTo(n.data) > 0) {
					return false;
				}
				
				lastVisited = n;
				inOrderPrint(n.right);
			}
			return true;
		}
	}
	
	void add(T data){
		if (root == null) {
			root = new Node(data);
		} else {
			root.add(data);
		}
	}
	
	void BFprint() {
		LinkedList<Node> q = new LinkedList<Node>();
		
		Node dq = root;
		
		int a = 1;
		int b = 0;
		
		while (dq != null) {
			System.out.print(dq.data + " ");
			
			if (dq.left != null) {
				q.add(dq.left);
				++b;
			}
			if (dq.right != null) {
				q.add(dq.right);
				++b;
			}
			
			if (--a < 1) {
				a = b;
				b = 0;
				System.out.println();
			}
			try {
				dq = q.removeFirst();
			} catch (NoSuchElementException ex) {
				dq = null;
			}
		}
	}
	
	void inOrderPrint() {
		root.inOrderPrint(root);
	}
}
