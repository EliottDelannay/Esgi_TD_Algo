package tD_algo3;

public class BinaryTree {
    Node root;
    
    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        
        if (value < current.value) {
            //add the lower value to the left side
            current.left = addRecursive(current, value);
        }
        else if(value > current.value) {
            //add the upper value to the right side 
            current.right = addRecursive(current,value);
        } else {
            return current;
        }
        
        return current;
    }
    
    public void add(int value) {
        root = addRecursive(root, value);
    }
    
    private BinaryTree createStaticBinaryTree() {
        BinaryTree bt = new BinaryTree();
        
        bt.add(20);
        bt.add(5);
        bt.add(25);
        bt.add(3);
        bt.add(12);
        bt.add(21);
        bt.add(28);
        bt.add(8);
        bt.add(13);
        bt.add(6);
        bt.add(19);
        bt.add(50);
        
        return bt;
    }
    
    // parcours infixe (première valeur de la node -> node gauche  -> node droit)
    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }
     
     private generateRandomList()
     {
         size = 10000;
        List r;
        for ( i++ < size) {
            r.i.(random);
        }
        return r;
     }
     
     private BinaryTree createBinaryTreeFromList(list random){
        BinaryTree bt = new BinaryTree();
        
        while(i < random.size) {
            bt.add(random.i);
            i += 1;
        }
        return bt;
     }
     
     public void IsEqual(Node node) {
         String l = 0;
         String r = 0;
         if (node != null) {
             
             traversePreOrder(node.left);
             l+=1; 
             traversePreOrder(node.right);
             r+=1;
             if (l != r) {
                 System.out.print("arbre non équilibré");
             }
         }
     }
    
}
