package tree;
import list.LinkedList;

public class AvlTree implements Tree {

	private class AvlNode implements Comparable<AvlNode> {

		private AvlNode left;
		private AvlNode right;
		private String word;
		private LinkedList indices;
		private int height;
	
		private AvlNode(String word) {
			this.left = null;
			this.right = null;
			this.word = word;
			this.indices = new LinkedList();
		}
	
		public int compareTo(AvlNode n) {
			return word.compareTo(n.word);
		}
	}

	private static final int ALLOWED_IMBALANCE = 1;
	private AvlNode root;

	public AvlTree() {
		root = null;
	}

	public void insert(String word, int index) {
		root = insert(word, index, root);
	}

	private AvlNode insert(String word, int index, AvlNode node) {
		if (node == null) {
			node = new AvlNode(word);
			node.indices.insertLast(index);
			return node;
		}
		if (word.compareTo(node.word) < 0) {
			node.left = insert(word, index, node.left);
		} else if (word.compareTo(node.word) > 0) {
			node.right = insert(word, index, node.right);
		} else {
			node.indices.insertLast(index); // if the word word already exists in the tree
		}
		return balance(node);
	}

	public void find(String word) {
		AvlNode node = root;
		while (node != null) {
			if (word.compareTo(node.word) < 0) {
				node = node.left;
			} else if (word.compareTo(node.word) > 0) {
				node = node.right;
			} else {
				break; // Match
			}
		}
		if (node != null) {
			System.out.print("\n" + word + " found " + node.indices.size() + " times at indices:\n");
			node.indices.print();
		} else {
			System.out.println(word + " was not found in the input text");
		}
	}

	private AvlNode balance(AvlNode node) {
		if (node == null) {
			return node;
		}
		if (height(node.left) - height(node.right) > ALLOWED_IMBALANCE) {
			if (height(node.left.left) >= height(node.left.right)) {
				node = rotateWithLeftChild(node);
			} else {
				node = doubleWithLeftChild(node);
			}
		} else if (height(node.right) - height(node.left) > ALLOWED_IMBALANCE) {
			if (height(node.right.right) >= height(node.right.left)) {
				node = rotateWithRightChild(node);
			} else {
				node = doubleWithRightChild(node);
			}
		}
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		return node;
	}

	// Return the height of node node, or -1, if null.
	private int height(AvlNode node) {
		return node == null ? -1 : node.height;
	}

	// Rotate AVL tree node with left child
	private AvlNode rotateWithLeftChild(AvlNode n) {
		AvlNode n2 = n.left;
		n.left = n2.right;
		n2.right = n;
		n.height = Math.max(height(n.left), height(n.right)) + 1;
		n2.height = Math.max(height(n2.left), n.height) + 1;
		return n2;
	}

	// Rotate AVL tree node with right child
	private AvlNode rotateWithRightChild(AvlNode n) {
		AvlNode n2 = n.right;
		n.right = n2.left;
		n2.left = n;
		n.height = Math.max(height(n.left), height(n.right)) + 1;
		n2.height = Math.max(height(n2.right), n.height) + 1;
		return n2;
	}

	// Double rotate AVL tree node: first left child with its right child; then node n with new left child.
	private AvlNode doubleWithLeftChild(AvlNode n) {
		n.left = rotateWithRightChild(n.left);
		return rotateWithLeftChild(n);
	}
	
	// Double rotate AVL tree node: first right child with its left child; then node n with new right child. 
	private AvlNode doubleWithRightChild(AvlNode n) {
		n.right = rotateWithLeftChild(n.right);
		return rotateWithRightChild(n);
	}
}