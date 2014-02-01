package trees.and.graphs;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bt = new BinarySearchTree<Integer>(new Integer(1));
		bt.add(new Integer(2));
		bt.add(new Integer(3));
		bt.add(new Integer(4));
		bt.add(new Integer(5));
		bt.add(new Integer(6));
		bt.add(new Integer(7));
		bt.add(new Integer(8));
		
		bt.printTree(bt.root);
		
		BST<Integer> bst = new BST<Integer>(new Integer(0));
		bst.insert(bst, new Integer(1));
		bst.insert(bst, new Integer(2));
		bst.insert(bst, new Integer(-1));
		bst.insert(bst, new Integer(-5));
		
		System.out.println("Closest");
		System.out.println( (bst.findClosest(new Integer (-5))).data );
		
		
		//BST.preorderTraversal(bst);
		//BST.inorderTraversal(bst);
		//BST.postorderTraversal(bst);
		System.out.println( BST.getHeight(bst) );
		
		System.out.println( bt.isBST(bt.root));
	}

}
