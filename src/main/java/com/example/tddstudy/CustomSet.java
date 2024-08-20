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
            this.tail = head;
        } else {
            CustomNode<T> newTail = new CustomNode<>(data);
            this.tail.setNextNode(newTail);
            this.tail = newTail;
        }
        this.size++;
    }



    public T get(int targetIndex) {
        CustomNode<T> current = this.head;
        int currentIndex = 0;
        CustomNode<T> targetNode = getDeeperNode(current, currentIndex, targetIndex);
        return targetNode.getNodeValue();
    }

    private CustomNode<T> getDeeperNode(CustomNode<T> current, int currentIndex, int targetIndex) {
         if (currentIndex == targetIndex) {
             return current;
         } else {
             currentIndex++;
             return getDeeperNode(current.getNextNode(),currentIndex,targetIndex);
         }
    }
}
