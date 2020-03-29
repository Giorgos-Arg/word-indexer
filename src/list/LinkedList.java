package list;

public class LinkedList {

	private class ListNode {
		private int index;
		private ListNode next;

		private ListNode(int index, ListNode next) {
			this.index = index;
			this.next = next;
		}

		private int getIndex() {
			return this.index;
		}
	}

	private ListNode head;
	private int size;

	public LinkedList() {
		this.head = null;
		size = 0;
	}

	public int size() {
		return this.size;
	}

	// Inserts index at the end of the list	 
	public void insertLast(int index) {
		ListNode newNode = new ListNode(index, null);
		ListNode tmp = this.head;
		if (this.head == null) {
			this.head = newNode;
		} else {
			while (tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = newNode;
		}
		size++;
	}

	public void print() {
		ListNode tmp = this.head;
		for (int i = this.size - 1; i >= 0; i--) {
			System.out.print(tmp.getIndex());
			if ((this.size - i) % 10 == 0){
				System.out.println();
			}
			else{
				System.out.print(", ");
			}
			tmp = tmp.next;
		}
		System.out.println();
	}
}
