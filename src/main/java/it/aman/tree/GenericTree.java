package it.aman.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenericTree<T> {

	private TreeNode<T> root;
	
	public GenericTree() {
		//
	}
	
	public TreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<T> root) {
		this.root = root;
		childNodesToVisit.add(this.root);
	}

	public TreeNode<T> get(T position) {
		if(position == null)
			return null;
		
		return find(position);
	}
	
	public List<TreeNode<T>> getChildrenAt(T position) {
		return getChildren(position);
	}
	
	public void addChild(T data) {
		TreeNode<T> node = new TreeNode<>(data);
		addChildAt(root, node);
	}
	
	public void addChildAt(TreeNode<T> child, T position) {
		TreeNode<T> parent = find(position);
		if(parent != null) {
			parent.getChildren().add(child);
		}
	}
	
	/**
	 * Get json representation of the tree
	 * 
	 * @return json string
	 */
	public String getJSON() {
		return null;
	}
	
	// ====== helpers =====
	private LinkedList<TreeNode<T>> childNodesToVisit = new LinkedList<>();
	
	private void addChildAt(TreeNode<T> parent, TreeNode<T> child) {
		TreeNode<T> prt = find(parent.getData());
		if(prt != null) {
			prt.getChildren().add(child);
		}
	}
	
	private List<TreeNode<T>> getChildren(T data) {
		TreeNode<T> prtNode = find(data);
		if(prtNode == null)
			return new ArrayList<>();
		
		return prtNode.getChildren();
	}
	
	/** 
	 * Use a deque to get items since this is queue, 
	 * search starts from root 
	 */
	private TreeNode<T> find(T toFind) {
		if(toFind == null)
			return null;
		
		TreeNode<T> nodeToVisit = childNodesToVisit.poll();
		TreeNode<T> result = findInternal(nodeToVisit, toFind);
		if(result != null)
			return result;
		
		if(nodeToVisit != null && Integer.signum(nodeToVisit.getDegree()) == 1) {
			childNodesToVisit.addAll(nodeToVisit.getChildren());
			find(toFind);
		}
		
		return null;
	}
	
	// breadth first
	private TreeNode<T> findInternal(TreeNode<T> node, T toFind) {
		if(node == null)
			return null;
		
		if(node.getData().equals(toFind))
			return node;
		for(TreeNode<T> leaf : node.getChildren()) {
			if(leaf.getData().equals(toFind))
				return leaf;
		}
		return null;
	}
}
