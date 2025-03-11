package DataStructure;

/*
* BinarySearchTree myTree = new BinarySearchTree();
        myTree.insert(47);
        myTree.insert(21);
        myTree.insert(76);
        myTree.insert(18);
        myTree.insert(27);
        myTree.insert(52);
        myTree.insert(82);*/

public class BinarySearchTree {
    public Node root;


    public class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value){
        Node newNode = new Node(value);
        if(root==null){
            root=newNode;
            return true;
        }
        Node temp = root;
        while(true){
            //to identify the duplicates in the tree
            if(newNode.value==temp.value) return false;
            if(newNode.value<temp.value){
                if(temp.left==null){
                    temp.left=newNode;
                    return true;
                }
                temp=temp.left;
            }else{
                if(temp.right==null){
                    temp.right=newNode;
                    return true;
                }
                temp=temp.right;
            }
        }
    }

    private boolean rContains(Node currentNode, int value){
        if(currentNode == null) return false;
        if(currentNode.value == value ) return true;
        if(value < currentNode.value){
            return rContains(currentNode.left, value);
        }else{
            return rContains(currentNode.right, value);
        }
    }

    public boolean rContains(int value){
        return rContains(root,value);
    }


    /*
    *  BinarySearchTree myTree = new BinarySearchTree();
        myTree.insert(2);
        myTree.insert(1);
        myTree.insert(3);


        System.out.println("\nRoot : "+myTree.root.value);
        System.out.println("\nRoot --> left : "+myTree.root.left.value);
        System.out.println("\nRoot --> right : "+myTree.root.right.value);
        * output
        * Root : 2

        Root --> left : 1

        Root --> right : 3
        * */
    private Node rInsert(Node currentNode, int value){
        if(currentNode == null) return new Node(value);

        if(value < currentNode.value){
            currentNode.left = rInsert(currentNode.left, value);
        }else if (value > currentNode.value){
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    public void rInsert(int value){
        if(root == null) root = new Node(value);
        rInsert(root , value);
    }

    /*
    * System.out.println(myTree.minValue(myTree.root));
      System.out.println(myTree.minValue(myTree.root.right));*/
    public int minValue(Node currentNode){
        while(currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    private Node deleteNode(Node currentNode , int value){
        if(currentNode == null) return null;

        if(value < currentNode.value){
            currentNode.left = deleteNode(currentNode.left,value);
        }else if (value > currentNode.value){
            currentNode.right = deleteNode(currentNode.right , value);
        }else{
            if(currentNode.left==null && currentNode.right==null){
                currentNode=null;
            }else if(currentNode.left==null){
                currentNode=currentNode.right;
            }else if(currentNode.right==null){
                currentNode=currentNode.left;
            }else{
                int subTreeMin = minValue(currentNode.right);
                currentNode.value=subTreeMin;
                currentNode.right=deleteNode(currentNode.right,subTreeMin);
            }
        }
        return currentNode;
    }
    /*
    * BinarySearchTree myTree = new BinarySearchTree();
        myTree.insert(2);
        myTree.insert(1);
        myTree.insert(3);


        System.out.println("\nRoot : "+myTree.root.value);
        System.out.println("\nRoot --> left : "+myTree.root.left.value);
        System.out.println("\nRoot --> right : "+myTree.root.right.value);

        myTree.deleteNode(2);

        System.out.println("\nRoot : "+myTree.root.value);
        System.out.println("\nRoot --> left : "+myTree.root.left.value);
        System.out.println("\nRoot --> right : "+myTree.root.right);
        * */

    public void  deleteNode(int value){
        deleteNode(root,value);
    }
}