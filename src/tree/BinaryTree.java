package tree;
import list.LinkedList;

public class BinaryTree implements Tree{

	private class TreeNode implements Comparable<TreeNode> {

		private TreeNode left;
		private TreeNode right;
		private String word;
		private LinkedList indices;
	
		private TreeNode(String word) {
			this.left = null;
			this.right = null;
			this.word = word;
			this.indices = new LinkedList();
		}
	
		public int compareTo(TreeNode n) {
			return word.compareTo(n.word);
		}
	}

	private TreeNode root;

	public BinaryTree() {
		root = null;
	}

	public void insert(String word, int index) {
		root = insert(root, word, index);
	}

	private TreeNode insert(TreeNode node, String word, int index) {
		if (node == null) {
			node = new TreeNode(word);
			node.indices.insertLast(index);
		} else {
			if (word.compareTo(node.word) < 0) {
				node.left = insert(node.left, word, index);
			} else if (word.compareTo(node.word) > 0) {
				node.right = insert(node.right, word, index);
			} else {
				node.indices.insertLast(index);// if the word word already exists in the tree
			}
		}
		return (node);
	}

	public void find(String word) {
		TreeNode node = find(root, word);
		if (node != null) {
			System.out.print("\n" + word + " found " + node.indices.size() + " times at indices:\n");
			node.indices.print();
		} else {
			System.out.println(word + " was not found in the input text");
		}
	}

	private TreeNode find(TreeNode node, String word) {
		if (node == null) {
			return null;
		}
		if (word.compareTo(node.word) == 0) {
			return node;
		} else if (word.compareTo(node.word) < 0) {
			return (find(node.left, word));
		} else {
			return (find(node.right, word));
		}
	}
}