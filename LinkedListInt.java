package ru.itis.collections.list;

public class LinkedListInt implements IntList {
    private static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node first;
//    old
    private Node last;
//    new
    private int count = 0;

    @Override
    public void add(int x) {
        if(last == null) {
            first = new Node(x);
            last = first;
            count++;
            return;
        }
        Node node = new Node(x);
        last.next = node;
        last = node;
        count++;
    }
//  -4-  <- 5 -> <- 6 -
    @Override
    public void add(int x, int index) {
        if ((index == count) && (count != 0)) {
            Node node = new Node(x);
            last.next = node;
            last = node;
        }
        if (index == 0) {
            first = new Node(x);
            last = first;
        }
        if ((index != 0) && (index!= count)) {
            Node node = first;
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            Node nodeNew = new Node(x);
            Node nodeOld = node.next;
//            nodeOld = index + 2
            nodeNew.next = nodeOld;
            node.next = nodeNew;
        }
        count++;
    }

    @Override
    public void set(int x, int index) {
        Node node = first;
        for (int i = 0; i < index - 1 ; i++) {
            node = node.next;
        }
        Node nodeNew = new Node(x);
        node.next = nodeNew;
    }

    @Override
    public int get(int index) {
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    @Override
    public void remove(int index) {
        Node node = first;
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        Node nodeRem = node.next;
        Node nodeRemNext = nodeRem.next;
        node.next = nodeRemNext;
        nodeRem = null;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        count = 0;
    }

    @Override
    public int size() {
        return count;
    }
}
