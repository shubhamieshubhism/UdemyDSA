package DataStructure;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree myTree = new BinarySearchTree();
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



    }
}
