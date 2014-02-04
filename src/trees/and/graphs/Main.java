package trees.and.graphs;

public class Main {

	public static void main(String[] args) {
		BST<Integer> bst = new BST<Integer>();
		bst.add(8);
		bst.add(3);
		bst.add(10);
		bst.add(6);
		bst.add(1);
		bst.add(4);
		bst.add(7);
		bst.add(14);
		bst.add(13);
		
		bst.BFprint();
		bst.inOrderPrint();
		bst.preOrderPrint();
		bst.postOrderPrint();
	}

}
