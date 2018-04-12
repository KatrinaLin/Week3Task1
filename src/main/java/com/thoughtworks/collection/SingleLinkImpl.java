package com.thoughtworks.collection;

public class SingleLinkImpl implements SingleLink {

    private Node head;
    private Node tail;
    private int size;

    public SingleLinkImpl() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Object getHeaderData() {
        if (head == null) {
            return null;
        }

        return head.data;
    }

    @Override
    public Object getTailData() {
        if (tail == null) {
            return null;
        }

        return tail.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean deleteFirst() {
        if (head == null) {
            return false;
        }

        head = head.next;
        size--;
        return true;
    }

    @Override
    public boolean deleteLast() {
        if (head == null) { // list has no element
            return false;
        }

        if (head == tail) {    // list has only one element
            head = null;
            tail = null;
            size--;
            return true;
        }

        Node cur = head;

        // move cur to point to the second last element
        while (cur.next != tail) {
            cur = cur.next;
        }

        tail = cur;
        cur.next = null;
        size--;

        return true;
    }

    @Override
    public void addHeadPointer(Object item) {
        Node newHead = new Node(item);

        if (head != null) {
            newHead.next = head;
        } else {
            tail = newHead;
        }
        size++;
        head = newHead;
    }

    @Override
    public void addTailPointer(Object item) {

        Node newTail = new Node(item);
        size++;

        if (head == null || tail == null) {
            head = newTail;
            tail = newTail;
            return;
        }

        tail.next = newTail;
        tail = newTail;

    }

    @Override
    public Object getNode(int index) {
        if (index <= 0) {
            return null;
        }

        Node cur = head;

        while (cur.next != null && index > 1) {
            cur = cur.next;
            index--;
        }

        if (index > 1) {
            return null;
        }

        return cur.data;
    }
}
