package zj.ojd.ds;

import zj.ojd.util.RandTools;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class BinaryTree implements Tree {

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

        @Override
        public String toString() {
            return String.format("node:id=%2d data=%2d parent=%2d left=%d right=%2d",
                    id,
                    data,
                    parent == null ? -1 : parent.id,
                    left == null ? -1 : left.id,
                    right == null ? -1 : right.id);
        }

        public void midVist() {

            if (left != null) left.midVist();
            System.out.print(id + ",");
            if (right != null) right.midVist();
        }

        public void preVist() {
            System.out.print(id + ",");
            if (left != null) left.preVist();
            if (right != null) right.preVist();


        }

        public void postVist() {
            if (left != null) left.postVist();

            if (right != null) right.postVist();
            System.out.print(id + ",");
        }

        public String treePrint() {

            if (left == null && right == null) {
                return new StringBuffer("" + id).toString();
            }
            StringBuffer buffer = new StringBuffer(id + "(");
            if (left != null) {
                buffer.append(left.treePrint());
            }
            buffer.append(",");
            if (right != null) {
                buffer.append(right.treePrint());
            }

            return buffer.append(")").toString();

        }
    }
    private static void writeArray(Node currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // 保证输入的树不为空
        if (currNode == null) return;
        // 先将当前节点保存到二维数组中
        res[rowIndex][columnIndex] = String.valueOf(currNode.id);

        // 计算当前位于树的第几层
        int currLevel = ((rowIndex + 1) / 2);
        // 若到了最后一层，则返回
        if (currLevel == treeDepth) return;
        // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
        int gap = treeDepth - currLevel - 1;

        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }


    public static void show(Node root) {
        if (root == null) System.out.println("EMPTY!");
        // 得到树的深度
        int treeDepth = getTreeDepth(root);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i++) {
            for (int j = 0; j < arrayWidth; j++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth / 2, res, treeDepth);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
        for (String[] line : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2 : line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }

    private static int getTreeDepth(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return Math.max(getTreeDepth(root.left), getTreeDepth(root.right)) + 1;
    }


    Node root;
    LinkedList<Node> nodes = new LinkedList<>();

    BinaryTree() {
        this(1);
    }

    BinaryTree(int n) {
        this.root = new Node(0, 0);
        this.nodes.addLast(root);


        for (int i = 1; i < n; i++) {
            Node newNode = new Node(i, i);
            addNode(newNode);
        }
    }

    boolean randAddNode(Node node) {
        Vector<Node> candidate = new Vector<>();
        for (Node each : nodes) {
            if (each.left == null || each.right == null)
                candidate.add(each);
        }
        int pos = RandTools.randInt(0, candidate.size() - 1);
        if (candidate.get(pos).left != candidate.get(pos).right) {
            if (candidate.get(pos).left == null) {
                addNodeLeft(candidate.get(pos), node);

            } else {
                addNodeRight(candidate.get(pos), node);
            }
        } else if (Math.random() < 0.5) {
            addNodeLeft(candidate.get(pos), node);
        } else {
            addNodeRight(candidate.get(pos), node);
        }

        return true;
    }

    private boolean addNodeRight(Node parent, Node node) {
        if (nodes.contains(node)) return false;
        if (parent.right != null) return false;
        parent.right = node;
        node.parent = parent;
        nodes.add(node);
        return true;

    }

    private boolean addNodeLeft(Node parent, Node node) {
        if (nodes.contains(node)) return false;
        if (parent.left != null) return false;
        parent.left = node;
        node.parent = parent;
        nodes.add(node);
        return true;
    }

    boolean addNode(Node node) {
        if (nodes.contains(node)) return false;
        nodes.addLast(node);
        for (Node each : nodes) {
            if (each.left == null) {
                each.left = node;
                node.parent = each;
                break;
            }
            if (each.right == null) {
                each.right = node;
                node.parent = each;
                break;
            }
        }
        return true;
    }

    boolean removeNode(Node delNode) {
        if (delNode == null) {
            return false;
        }
        if (delNode == root) {
            nodes.clear();
            root = null;
            return true;
        }
        if (!nodes.contains(delNode))
            return false;
        if (delNode.left == null && delNode.right == null) {
            if (delNode.parent.left == delNode)
                delNode.parent.left = null;
            else
                delNode.parent.right = null;
            nodes.remove(delNode);
            return true;
        }
        if (delNode.left != null) {
            removeNode(delNode.left);
        }
        if (delNode.right != null) {
            removeNode(delNode.right);
        }
        if (delNode.parent.left == delNode)
            delNode.parent.left = null;
        else
            delNode.parent.right = null;
        nodes.remove(delNode);
        return true;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (Node node : nodes)
            buffer.append(node.toString() + "\n");
        return buffer.toString();

    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        System.out.println(tree);
        for (int i = 1; i < 10; i++) {
            Node node = new Node(i, i);
            tree.randAddNode(node);
            System.out.println(tree);
            System.out.println("-----------------------");
        }
        tree.midVist();
        System.out.println();
        tree.preVist();
        System.out.println();
        tree.postVist();
        System.out.println();
        System.out.println(tree.getRoot());
        for (Node leaf : tree.getLeaves())
            System.out.println(leaf);
        System.out.println(tree.root.treePrint());
        show(tree.root);
    }

    private void postVist() {
        root.postVist();
    }

    private void preVist() {
        root.preVist();
    }

    private void midVist() {
        root.midVist();
    }

    Node getRoot() {
        for (Node node : nodes) {
            if (node.parent == null)
                return node;
        }

        return null;
    }

    List<Node> getLeaves() {
        LinkedList<Node> ans = new LinkedList<>();
        for (Node node : nodes) {
            if (node.left == null && node.right == null)
                ans.add(node);
        }
        return ans;

    }
}
