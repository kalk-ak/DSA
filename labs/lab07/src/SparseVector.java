public class SparseVector {

	private Node head;
	private int length;

	public SparseVector(int len) {
		head = null;
		length = len;
	}

	// Prints out a sparse vector (including zeros)
	public String toString() {

		String result = "";
		Node currNode = head;
		int currIndex = 0;
		while (currNode != null) {    // while we are not at the end of the node
			int idx = currNode.getIndex();

			// Pad the space between nodes with zero
			while (currIndex < idx) { // get the zeros in between the numbers
				result += "0, ";
				currIndex++;
			}
			result += currNode; // add the element in the index as a string
			currNode = currNode.getNext(); // move to the next non-zero element
			currIndex++;

			// Only add a comma if this isn't the last element
			if (currNode != null) {
				result += ", ";
			}
		}
		return result;
	}

	// TODO: I
	public void addElement(int index, double value) {
		if (index < length && index >= 0) {
			if (head == null) {
				Node newest = new Node(index, value);
				head = newest;
				return;
			} else {
				Node start = head;
				while (start.getNext() != null) {
					start = start.getNext();
				}
				Node newest = new Node(index, value);
				start.setNext(newest);
				return;
			}
		}

	}

	public int getLength() {
		return length;
	}

	public Node getHead() {
		return head;
	}


	public static double dot(SparseVector x, SparseVector y) {
		double answer = 0;
		if (x.getLength() == y.getLength() && x.getHead() != null) {
			Node xVal = x.getHead();
			Node yVal = y.getHead();

			while (xVal != null) {
				while (yVal != null) {
					if (xVal.getIndex() == yVal.getIndex()) {
						answer += xVal.getValue() * yVal.getValue();
						break;
					}
					yVal = yVal.getNext();
				}
				xVal = xVal.getNext();
				yVal = y.getHead();
			}
		}
		return answer;
	}


	// TODO: Test out your code here!
	public static void main(String[] args) {


		SparseVector x = new SparseVector(100000000);
		x.addElement(0, 1.0);
		x.addElement(10000000, 3.0);
		x.addElement(10000001, -2.0);
		SparseVector y = new SparseVector(100000000);
		y.addElement(0, 2.0);
		y.addElement(10000001, -4.0);
		double result = dot(x, y);
		System.out.println(result);

	}
}



