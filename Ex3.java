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

    public Node deleteHNumb(Node node) {
        if (node == null) {
            return null;
        }

        if (node.right == null) {
            return node.left;
        }

        node.right = deleteHNumb(node.right);

        return node;
    }

    public void printTree(Node node, String path) {
        if (node == null) {
            return;
        }

        path += node.data + " -> ";

        if (node.left == null && node.right == null) {
            System.out.println(path);
        } else {
            printTree(node.left, path);
            printTree(node.right, path);
        }
    }
}

public class Ex3 {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] elements = {6, 13, 2, 1, 7, 14};

        for (int element : elements) {
            tree.insertRoot(element);
        }

        System.out.println("Árvore original:");
        tree.printTree(tree.root, "");

        tree.root = tree.deleteHNumb(tree.root);
        System.out.println("\nÁrvore após remover o maior elemento:");
        tree.printTree(tree.root, "");
    }
}