package com.contactsunny.poc.DoubleLinkedListImplementationPOC;

import com.contactsunny.poc.DoubleLinkedListImplementationPOC.linkedList.DoubleLinkedList;

public class App {

    public static void main(String[] args) {

        DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();

        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);

        linkedList.addToTail(4);

        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);

        linkedList.traverse();

        System.out.println("Deleting first node with value 2");
        linkedList.delete(2);

        linkedList.traverse();

        System.out.println("Adding value 5 after the node with index 1");
        linkedList.addAfterIndex(5, 1);

        linkedList.traverse();

        System.out.println("Deleting node at index 2");
        linkedList.deleteNodeAtIndex(2);

        linkedList.traverse();

        System.out.println("Deleting node after index 3");
        linkedList.deleteNodeAfterIndex(3);

        linkedList.traverse();
        linkedList.reverseTraverse();
    }
}
