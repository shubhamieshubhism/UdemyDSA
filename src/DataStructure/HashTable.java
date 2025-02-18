package DataStructure;

import java.util.ArrayList;

public class HashTable {
    public int size = 7;
    public Node[] dataMap;
    class Node{
        public String key;
        public int value;
        public Node next;
        Node(String key,int value){
            this.key=key;
            this.value=value;
        }
    }
    public HashTable(){
        dataMap=new Node[size];
    }
    public void printHashTable(){
        for(int i =0;i<dataMap.length;i++){
            System.out.println(i+":");
            Node temp=dataMap[i];
            while(temp!=null){
                System.out.println(" {"+temp.key+" = "+temp.value+"}");
                temp=temp.next;
            }
        }
    }
    private int hash(String key){
        int hash = 0;
        char [] keyChar=key.toCharArray();
        for(int i =0 ; i<keyChar.length;i++){
            int asciivalue = keyChar[i];
            hash = (hash + asciivalue * 23) % dataMap.length;
        }
        return hash;
    }
    public void set(String key, int value){
        int index = hash(key);
        Node newNode = new Node(key,value);
        if(dataMap[index]==null){
            dataMap[index]=newNode;
        }else{
            Node temp = dataMap[index];
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
    }
    public int get(String key){
        int index = hash(key);
        Node temp = dataMap[index];
        while(temp!=null){
            if(temp.key==key) return temp.value;
            temp=temp.next;
        }
        return 0;
    }
    public ArrayList keys(){
        ArrayList<String>allKeys = new ArrayList<>();
        for(int i = 0 ; i <dataMap.length;i++){
            Node temp = dataMap[i];
            while(temp!=null){
                allKeys.add(temp.key);
                temp=temp.next;
            }
        }
        return allKeys;
    }
}
/*
* HashTable myHashTable = new HashTable();
        myHashTable.set("paint",140);
        myHashTable.set("bolts",200);
        myHashTable.set("nails",100);
        myHashTable.set("tile",50);
        myHashTable.set("lumber",80);*/
