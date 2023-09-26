class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class BinaryTree {
    Node root;
    public BinaryTree() {
        root = null;
    }
    private Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }
    public void insertRoot(int data) {
        root = insert(root, data);
    }
    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " -> ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " -> ");
            inOrder(root.right);
        }
    }
    public void posOrder(Node root) {
        if (root != null) {
            posOrder(root.left);
            posOrder(root.right);
            System.out.print(root.data + " -> ");
        }
    }
}

public class Ex2 {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] entry = {6, 13, 2, 1, 7, 14};
        for (int i : entry) {
            tree.insertRoot(i);
        }

        System.out.println("Árvore em pré-ordem:");
        tree.preOrder(tree.root);
        System.out.println();

        System.out.println("Árvore em in-ordem:");
        tree.inOrder(tree.root);
        System.out.println();

        System.out.println("Árvore em pós-ordem:");
        tree.posOrder(tree.root);
    }
}