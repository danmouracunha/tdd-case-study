package com.example.tddstudy;

public class CustomSet<T> {
    private CustomNode<T> head;
    private CustomNode<T> tail;

    public long getSize() {
        return size;
    }

    private long size;

    public CustomSet() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T data) {
        if (head == null) {
            this.head = new CustomNode<>(data);
            this.tail = new CustomNode<>(data);
        } else {
            CustomNode<T> previousTail = this.tail;
            CustomNode<T> newTail = new CustomNode<>(data);
            previousTail.setNextNode(newTail);
            this.tail = newTail;
        }
        this.size++;
    }


}
