package org.gilcode.searchtree;

import org.gilcode.common.BinaryTree;
import org.gilcode.common.Node;

import java.util.NoSuchElementException;
import java.util.Optional;

public class BST extends BinaryTree {
    public BST(Node root) {
        super(root);
    }

    @Override
    public void insert(int value) {
        this.insertRec(value, this.root);
    }

    @Override
    protected void insertRec(int value, Node parent) {
        Node newNode = new Node(value);

        if(value > parent.getValue()){
            if(parent.getRight() == null){
                parent.setRight(newNode);
                return;
            }

            insertRec(value, parent.getRight());
        }else {
            if(parent.getLeft() == null){
                parent.setLeft(newNode);
                return;
            }

            insertRec(value, parent.getLeft());
        }
    }

    @Override
    public Optional<Node> search(int value) {
        return searchRec(value, root);
    }

    @Override
    protected Optional<Node> searchRec(int value, Node parent) {

        if(parent == null){
            return Optional.empty();
        }

        if(value == parent.getValue()){
            return Optional.of(parent);
        }

        if (value > parent.getValue()) {
            return searchRec(value, parent.getRight());
        } else {
            return searchRec(value, parent.getLeft());
        }
    }

    @Override
    public void remove(int value) throws NoSuchElementException {
        removeRec(value, root);
    }

    @Override
    protected void removeRec(int value, Node parent) throws NoSuchElementException {
        if(parent == null) throw new NoSuchElementException("The value " + value + " doesn't exists in the tree.");
    }
}
