package tD_algo;

public class Node {
	int value;
	private boolean isNode;  
	  
	 Node left;
	 Node right;
	
	Node(int value){
		this.value = value;
		this.isNode = true;
	}
	
	Node(int value, boolean isNode) {
		this.value = value;
		this.isNode = isNode;
	}
	
	Node(int value){
	        this.value = value;
	        right = null;
	        left = null;
	    }

}