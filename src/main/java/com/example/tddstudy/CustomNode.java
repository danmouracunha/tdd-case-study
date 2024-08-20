package com.example.tddstudy;

public class CustomNode<T> {
    private T nodeValue;
    private CustomNode<T> nextNode;

    public CustomNode(T nodeValue) {
        this.nodeValue = nodeValue;
    }

    public void setNodeValue(T nodeValue) {
        this.nodeValue = nodeValue;
    }

    public void setNextNode(CustomNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    public T getNodeValue() {
        return nodeValue;
    }

    public CustomNode<T> getNextNode() {
        return nextNode;
    }


}
