package com.contactsunny.poc.DoubleLinkedListImplementationPOC.linkedList;

public class DoubleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public void push(T value) {

        if (this.head == null) {
            this.head = new Node<T>();
            this.head.setData(value);
            this.tail = this.head;
        } else {
            Node<T> newNode = new Node<T>();
            newNode.setData(value);
            newNode.setNext(this.head);

            this.head.setPrevious(newNode);

            this.head = newNode;
        }
    }

    public void traverse() {

        if (this.head != null) {
            Node<T> currentNode = this.head;

            System.out.print("Forward traverse: ");

            while (currentNode != null) {
                System.out.print(currentNode.getData() + " -> ");
                currentNode = currentNode.getNext();
            }

            System.out.println("END");

        } else {
            System.out.println("Linked list is empty.");
        }
    }

    public void reverseTraverse() {

        if (this.tail != null) {
            Node<T> currentNode = this.tail;

            System.out.print("Reverse traverse: ");

            while (currentNode != null) {
                System.out.print(currentNode.getData() + " -> ");
                currentNode = currentNode.getPrevious();
            }

            System.out.println("END");

        } else {
            System.out.println("Linked list is empty.");
        }
    }

    public void addToTail(T value) {

        if (this.head == null) {
            this.head = new Node<T>();
            this.head.setData(value);
            this.tail = this.head;
        } else {
            Node<T> newNode = new Node<T>();
            newNode.setData(value);
            newNode.setPrevious(this.tail);

            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }

    public void delete(T value) {

        if (this.head != null) {
            Node<T> currentNode = this.head;
            Node<T> previousNode = this.head;

            while (currentNode != null) {
                if (currentNode.getData() == value) {
                    previousNode.setNext(currentNode.getNext());

                    if (currentNode.getNext() != null) {
                        currentNode.getNext().setPrevious(previousNode);
                    }

                    System.out.println("Deleted first node with value " + value);
                    break;
                } else {
                    previousNode = currentNode;
                    currentNode = currentNode.getNext();
                }
            }
        }
    }

    public void addAfterIndex(T value, int index) {

        if (this.head == null) {
            this.head = new Node<T>();
            this.head.setData(value);
            this.tail = this.head;
        } else {

            int nodeIndex = 0;

            Node<T> currentNode = this.head;

            while (index > nodeIndex) {
                if (currentNode.getNext() != null) {
                    currentNode = currentNode.getNext();
                }

                nodeIndex++;
            }

            if (nodeIndex == index) {
                Node<T> newNode = new Node<T>();
                newNode.setData(value);
                newNode.setNext(currentNode.getNext());
                newNode.setPrevious(currentNode);

                if (currentNode.getNext() != null) {
                    currentNode.getNext().setPrevious(newNode);
                }

                currentNode.setNext(newNode);
            }
        }
    }

    public void deleteNodeAtIndex(int index) {

        if (this.head != null) {

            int nodeIndex = 0;

            Node<T> currentNode = this.head;
            Node<T> previousNode = this.head;

            while (nodeIndex != index) {

                previousNode = currentNode;

                if (currentNode.getNext() != null) {
                    currentNode = currentNode.getNext();
                }

                nodeIndex++;
            }

            previousNode.setNext(currentNode.getNext());

            if (currentNode.getNext() != null) {
                currentNode.getNext().setPrevious(previousNode);
            }
        }
    }

    public void deleteNodeAfterIndex(int index) {

        if (this.head != null) {

            int nodeIndex = 0;

            Node<T> currentNode = this.head;

            while (nodeIndex != index) {

                if (currentNode.getNext() != null) {
                    currentNode = currentNode.getNext();
                }

                nodeIndex++;
            }

            if (currentNode.getNext() != null) {

                Node<T> nodeToBeDeleted = currentNode.getNext();

                currentNode.setNext(nodeToBeDeleted.getNext());

                if (nodeToBeDeleted.getNext() != null) {
                    nodeToBeDeleted.getNext().setPrevious(nodeToBeDeleted.getPrevious());
                }
            } else {
                currentNode.setNext(null);
            }
        }
    }
}
