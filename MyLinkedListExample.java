package com.anuj.algorithms;

/**
 *
 * @author anpatel
 * @source goldenpackagebyanuj.blogspot.com
 */
public class MyLinkedListExample {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        for (int i = 1; i <= 10; i++) {
            myLinkedList.add(i);
        }

        System.out.println("Total Size :" + myLinkedList.getSize());
        System.out.println("MyLinkedList : " + myLinkedList);

        System.out.println("Node with Element 4 :" + myLinkedList.get(4));

        System.out.println("Node with Element 6 removed : " + myLinkedList.remove(6));
        System.out.println("Total Size After removing Node:" + myLinkedList.getSize());
        System.out.println("MyLinked List After Removing Node :" + myLinkedList);
    }
}

/**
 * Node presenting data and next node
 *
 * @author anpatel
 *
 */
class Node {

    Object data;
    Node next;

    public Node() {

    }

    /**
     * set Node property with data and nextNode
     *
     * @param data
     * @param nextNode
     */
    public Node(Object data, Node nextNode) {
        this.next = nextNode;
        this.data = data;
    }

    /**
     * Next Node is null if only data provided
     *
     * @param data
     */
    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

/**
 * My Own LinkedList Implementation
 *
 * @author anpatel
 *
 */
class MyLinkedList {

    private Node headNode;
    private int totalSize;

    public MyLinkedList() {
        //create headNode with data as null and nextNode as Null
        headNode = new Node(null);
        totalSize = 0;
    }

    /**
     * add Element at tail of LinkedList with NextNode as Null
     *
     * @param data
     */
    public void add(Object data) {
        Node newNode = new Node(data);
        Node currentNode = headNode;

        //Starting from head Node, iterate over all node to find last Tail node and add NewNode there
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }

        //By this time, we found Tail Node which is currentNode, So add new Node
        currentNode.setNext(newNode);
        totalSize++;
    }

    /**
     * Insert new Node at Specific Index Location
     *
     * @param data
     * @param index
     */
    public void add(Object data, int index) {
        //Starting from Head, iterate and reach over Node having Index just less than provided index
        Node newNode = new Node(data);
        Node currentNode = headNode;

        int i = 1;
        while (currentNode.next != null && i < index) {
            currentNode = currentNode.getNext();
            i++;
        }

        //By This time , we have currentNode presenting node which is node just before Node having index provided
        //set NewNode's Next to Node existing at Specific Index
        Node existingNodeAtGivenIndex = currentNode.getNext();
        newNode.setNext(existingNodeAtGivenIndex);

        //Set CurrentNode's Next to newNode
        currentNode.setNext(newNode);

        totalSize++;

        System.out.println("Node " + newNode + " inserted at index " + index);
        System.out.println("Total Size of myLinkedList after inserting new Node - " + totalSize);
    }

    /**
     * Get Node at Specific Index and return it's Value
     *
     * @param index
     */
    public Object get(int index) {
        Node currentNode = headNode;
        if (index <= 0) {
            return null;
        }

        //Find Node at Index just before given Index
        for (int i = 1; i < index; i++) {
            if (currentNode.getNext() == null) {
                return null;
            }
            currentNode = currentNode.getNext();
        }

        //By This time we have node at given Index
        return currentNode.getData();
    }

    /**
     * Remove Element at Specific Index in myLinkedList
     *
     * @return
     */
    public boolean remove(int index) {
        boolean isRemoved = false;
        Node currentNode = headNode;
        if (index < 1 || index > totalSize) {
            isRemoved = false;
        }

        //Find Node at Index just before given Index
        for (int i = 1; i < index; i++) {
            if (currentNode.getNext() == null) {
                //we reached Last Node of HeadNode. TODO remove this one?
                isRemoved = false;
            } else {
                currentNode = currentNode.getNext();
            }

        }

        if (!isRemoved) {
            //By This time we have currentNode is not which is just before Node at given Index
            //currentNode's Next is node at Given Index
            //Current Node's Next's Next is node after just given Index
            currentNode.setNext(currentNode.getNext().getNext());
            isRemoved = true;
            totalSize--;
        }

        return isRemoved;
    }

    /**
     * Return size of MyLinkedList
     *
     * @return
     */
    public int getSize() {
        return totalSize;
    }

    @Override
    public String toString() {
        String myList = "";
        Node currentNode = headNode;
        while (currentNode != null) {
            Object data = currentNode.getData();
            Node node = currentNode.getNext();
            if (node != null) {
                myList += "[" + String.valueOf(data) + "->" + node + "] -->";
            } else {
                myList += "[" + String.valueOf(data) + "->" + node + "]";
            }
            currentNode = node;
        }
        return myList;
    }
}
