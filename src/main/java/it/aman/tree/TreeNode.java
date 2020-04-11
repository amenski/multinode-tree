package it.aman.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
	
	private T data;
	private List<TreeNode<T>> children;
	
	public TreeNode(T nodeData) {
		this.data = nodeData;
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public List<TreeNode<T>> getChildren() {
		if(children == null) {
			children = new ArrayList<>();
		}
		return children;
	}

	public void setChildren(List<TreeNode<T>> children) {
		this.children = children;
	}
	
	public Integer getDegree() {
		return children.size();
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreeNode other = (TreeNode) obj;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return data.toString();
	}
}
