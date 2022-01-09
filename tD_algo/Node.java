package tD_algo;

public class Node {
	int value;
	private boolean isNode;  
	
	Node(int value){
		this.value = value;
		this.isNode = true;
	}
	
	Node(int value, boolean isNode) {
		this.value = value;
		this.isNode = isNode;
	}

}