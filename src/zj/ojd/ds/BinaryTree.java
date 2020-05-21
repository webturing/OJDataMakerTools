package zj.ojd.ds;

import java.util.LinkedList;

public class BinaryTree {

    static class Node {
        int id;
        int data;
        Node parent, left, right;

        Node(int id, int data) {
            this.id = id;
            this.data = data;
            this.parent = null;
            this.left = null;
            this.right = null;
        }


    }

    Node root;
    LinkedList<Node> nodes = new LinkedList<>();

    BinaryTree(int n) {
        this.root = new Node(0, 0);
        this.nodes.addLast(root);
        Node cur = root;

        for (int i = 1; i < n; i++) {
            Node newNode = new Node(i, i);
            nodes.addLast(newNode);
            for (Node each : nodes) {
                if (each.left == null) {
                    each.left = newNode;
                    newNode.parent = each;

                    break;
                }
                if (each.right == null) {
                    each.right = newNode;
                    newNode.parent = each;
                    break;
                }
            }
        }
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (Node node : nodes)
            buffer.append(String.format("node:id=%d data=%d parent=%d left=%d right=%d\n",
                    node.id,
                    node.data,
                    node.parent == null ? -1 : node.parent.id,
                    node.left == null ? -1 : node.left.id,
                    node.right == null ? -1 : node.right.id));
        return buffer.toString();

    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(100);
        System.out.println(binaryTree);

    }
}
