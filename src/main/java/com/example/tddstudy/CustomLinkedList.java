package com.example.tddstudy;

public class CustomLinkedList<T> {
    private CustomNode<T> head;
    private CustomNode<T> tail;

    public long getSize() {
        return size;
    }

    private long size;

    public CustomLinkedList() {
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
        CustomNode<T> targetNode = getTargetNode(targetIndex);
        return targetNode.getNodeValue();
    }

    private CustomNode<T> getTargetNode(int targetIndex) {
        CustomNode<T> current = this.head;
        int currentIndex = 0;
        CustomNode<T> targetNode = getDeeperNode(current, currentIndex, targetIndex);
        return targetNode;
    }

    private CustomNode<T> getDeeperNode(CustomNode<T> current, int currentIndex, int targetIndex) {
        if (currentIndex == targetIndex) {
            return current;
        } else {
            currentIndex++;
            return getDeeperNode(current.getNextNode(), currentIndex, targetIndex);
        }
    }

    public void remove(int indexToRemove) {
        CustomNode<T> previousNode = getPreviousNode(indexToRemove);

        CustomNode<T> nextNode = getNextNode(indexToRemove);

        if (previousNode == null) {
            this.head = nextNode;
        }
        if (nextNode != null) {
            this.tail = previousNode;
        }

        previousNode.setNextNode(nextNode);
        size--;
    }

    private CustomNode<T> getNextNode(int indexToRemove) {
        if (indexToRemove != size - 1) {
            return getTargetNode(indexToRemove + 1);
        } else {
            return null;
        }
    }

    private CustomNode<T> getPreviousNode(int indexToRemove) {
        if (indexToRemove != 0) {
            return getTargetNode(indexToRemove - 1);
        } else {
            return null;
        }
    }
}
