package trees.and.graphs;

import arrays.and.strings.MySet;


public class TreeSetNode<T> {
	private T data;
	private MySet<TreeSetNode<T>> children;
	
	public TreeSetNode(T data) {
		this.data = data;
		children = new MySet<TreeSetNode<T>>();
	}
	
	public TreeSetNode<T> getNthChild(int n) {
		if (n < 1 || n > children.length()) {
			System.out.println("That child doesn't exist");
		}
		return children.getElemAt(n-1);
	}
	
	public void addChild (TreeSetNode<T> addMe) {
		children.add(addMe);
	}
	
	public void removeChild (TreeSetNode<T> removeMe) {
		children.remove(removeMe);
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
}
