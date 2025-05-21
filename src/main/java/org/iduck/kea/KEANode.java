package org.iduck.kea;

public class KEANode {
    public Integer value;
    public KEANode left, right;

    public KEANode(Integer value) {
        this.value = value;
    }

    public KEANode(KEANode left, KEANode right) {
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return value != null;
    }
}
