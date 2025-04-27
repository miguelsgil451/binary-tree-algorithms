package org.gilcode.common;

import java.util.NoSuchElementException;
import java.util.Optional;

public abstract class BinaryTree {
    protected Node root;

    public BinaryTree(Node root){
        this.root = root;
    }

    public abstract void insert(int value);
    protected abstract void insertRec(int value, Node parent);

    public abstract Optional<Node> search(int value);
    protected abstract Optional<Node> searchRec(int value, Node parent);

    public abstract void remove(int value) throws NoSuchElementException;
    protected abstract void removeRec(int value, Node parent) throws NoSuchElementException;

    public int getChildrenQuantity(Node node){
        int childrenQuantity = 0;

        if(node.getLeft() != null){
            childrenQuantity++;
        }

        if(node.getRight() != null){
            childrenQuantity++;
        }

        return childrenQuantity;
    }
}
