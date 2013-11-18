package trees.and.graphs;

public class Main {

	public static void main(String[] args) {
		BinaryTree<Integer> bt = new BinaryTree<Integer>(new Integer(1));
		bt.balancedAdd(bt.root, new Integer(2));
		bt.balancedAdd(bt.root, new Integer(3));
		bt.balancedAdd(bt.root, new Integer(4));
		bt.balancedAdd(bt.root, new Integer(5));
		bt.balancedAdd(bt.root, new Integer(6));
		bt.balancedAdd(bt.root, new Integer(7));
		bt.balancedAdd(bt.root, new Integer(8));
		
		
		bt.printTree(bt.root);
	}

}
