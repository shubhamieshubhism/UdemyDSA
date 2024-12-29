package DataStructure;

public class LinkedList {
    private Node  head;
    private Node tail;
    private int length;


    public  class Node{
        public int value;
        Node next;
        Node(int value){
            this.value=value;
        }
    }

    public LinkedList(int value){
        Node newNode = new Node(value);
        head=newNode;
        tail=newNode;
        length=1;
    }

    public void printList(){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.value);
            temp=temp.next;
        }
    }
    public void getHead(){
        System.out.println("Head : "+head.value);
    }
    public void getTail(){
        System.out.println("Tail : "+tail.value);
    }
    public void getLength(){
        System.out.println("Length : "+length);
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next=newNode;
            tail=newNode;
        }
        length++;
    }

    public Node removeLast(){
        if(length == 0 ) return null;
        Node temp=head;
        Node pre = head;
        while(temp.next!=null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next=null;
        length--;
        if(length == 0 ){
            head=null;
            tail=null;
        }
        return temp;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if(length == 0 ){
            head=newNode;
            tail=newNode;
        }else{
            newNode.next=head;
            head=newNode;
        }
        length++;
    }

    public Node removeFirst(){
        //if LL contains only one element
        if(length == 0 ) return null;
        //when LL contains multiple elements
        Node temp = head;
        head = temp.next;
        temp.next=null;
        length--;
        /*if LL contains only one element then tail still pointing toward
        to the element to overcome this problem we are using
        below code snippet.
        */
        if(length==0){
            tail=null;
        }
        return temp;
    }

    public Node get(int index){
        /*if the index is less than zero or greater than length of the LL*/
        if(index < 0 || index>=length) return null;
        Node temp = head;
        /*Now we need to iterate through the LL to get the element*/
        for (int i = 0; i < index; i++) {
            temp=temp.next;
        }
        return temp;

    }

    public boolean set(int index , int value){
        Node temp = get(index);
        if(temp != null ){
            temp.value=value;
            return true;
        }
        return false;
    }

    public boolean insert(int index , int value){
        if(index<0 || index > length) return false;
        if(index == 0){
            prepend(value);
            return true;
        }
        if(index == length){
            append(value);
            return true;
        }

        Node newnode = new Node(value);
        Node temp = get(index-1);
        newnode.next=temp.next;
        temp.next=newnode;
        length++;
        return true;
    }

    public Node remove(int index){
        if(index<0 || index >= length) return null;
        if(index == 0) return removeFirst();
        if(index == length) return removeLast();
        Node prev = get(index -1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse(){
        Node temp = head;
        head =  tail;
        tail = temp;
        Node after= temp.next;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after=temp.next;
            temp.next = before;
            /*to change the direction of null in to reverse
            * direction we are using below condition */
            before=temp;
            temp=after;
        }
    }

    /* lEET CODE PROBLEMS */
    /*LL: Find Middle Node ( ** Interview Question)
Implement a method called findMiddleNode that returns the middle node of the linked list.

If the list has an even number of nodes, the method should return the second middle node.

Note: this LinkedList implementation does not have a length member variable.*/

    public Node findMiddleNode() {
        // Initialize slow pointer to the head of the linked list
        Node slow = head;

        // Initialize fast pointer to the head of the linked list
        Node fast = head;

        // Traverse the linked list with two pointers: slow and fast
        // slow moves one node at a time, while fast moves two nodes at a time
        while (fast != null && fast.next != null) {
            // Move slow pointer to the next node
            slow = slow.next;

            // Move fast pointer to the next two nodes
            fast = fast.next.next;
        }

        // Return the Node object representing the middle node of the linked list
        return slow;
    }


    /*LL: Has Loop ( ** Interview Question)
Write a method called hasLoop that is part of the linked list class.

The method should be able to detect if there is a cycle or loop present in the linked list.

You are required to use Floyd's cycle-finding algorithm (also known as the "tortoise and the hare" algorithm) to detect the loop.

This algorithm uses two pointers: a slow pointer and a fast pointer.
The slow pointer moves one step at a time, while the fast pointer moves two steps at a time.
If there is a loop in the linked list, the two pointers will eventually meet at some point.
If there is no loop, the fast pointer will reach the end of the list.*/
    public boolean hasLoop() {
        // Initialize slow pointer to the head of the linked list
        Node slow = head;

        // Initialize fast pointer to the head of the linked list
        Node fast = head;

        // Traverse the linked list with two pointers: slow and fast
        // slow moves one node at a time, while fast moves two nodes at a time
        while (fast != null && fast.next != null) {
            // Move slow pointer to the next node
            slow = slow.next;

            // Move fast pointer to the next two nodes
            fast = fast.next.next;

            // If slow pointer meets fast pointer, then there is a loop in the linked list
            if (slow == fast) {
                return true;
            }
        }

        // If the loop has not been detected after the traversal, then there is no loop in the linked list
        return false;
    }

    /*LL: Find Kth Node From End ( ** Interview Question)
Implement a method called findKthFromEnd that returns the k-th node from the end of the list.

If the list has fewer than k nodes, the method should return null.

Note: This implementation of the Linked List class does not have the length attribute.*/
    public Node findKthFromEnd(int k) {
        Node slow = head; // Initialize slow pointer at head
        Node fast = head; // Initialize fast pointer at head

        // Move fast pointer k steps ahead
        for (int i = 0; i < k; i++) {
            if (fast == null) { // If k is out of bounds, return null
                return null;
            }
            fast = fast.next; // Move the fast pointer to the next node
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next; // Move the slow pointer to the next node
            fast = fast.next; // Move the fast pointer to the next node
        }

        return slow; // Return the kth node from the end (slow pointer)
    }



}
