package it.aman.tree;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GraphTest {

	@Test
	public void test() {
		GenericTree<String> graph = buildGraph();
		Assert.assertEquals(graph.get("A").getData(), "A");
	}
	
	@Test
	public void test1() {
		GenericTree<String> graph = buildGraph();
		List<TreeNode<String>> children = graph.getChildrenAt("C");
		Assert.assertTrue(children.contains(new TreeNode<String>("E")));
	}
	
	private GenericTree<String> buildGraph() {
		GenericTree<String> graph = new GenericTree<>();
		TreeNode<String> A = new TreeNode<>("A");
		TreeNode<String> B = new TreeNode<>("B");
		TreeNode<String> C = new TreeNode<>("C");
		TreeNode<String> D = new TreeNode<>("D");
		TreeNode<String> E = new TreeNode<>("E");
		TreeNode<String> F = new TreeNode<>("F");
		
		A.getChildren().add(B);
		A.getChildren().add(C);
		A.getChildren().add(D);
		
		C.getChildren().add(E);
		C.getChildren().add(F);
		
		graph.setRoot(A);
		
		return graph;
	}
}
