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
    public Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        }

        return root;
    }

    public void insertRoot(int key) {
        root = insert(root, key);
    }

    public void printTree(Node node, String path) {
        if (node == null) {
            return;
        }

        if (path.isEmpty()) {
            path += node.data;
        } else {
            path += " -> " + node.data;
        }

        if (node.left == null && node.right == null) {
            System.out.println(path);
        }

        printTree(node.left, path);
        printTree(node.right, path);
    }
}

public class Ex1 {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insertRoot(6);
        tree.insertRoot(13);
        tree.insertRoot(2);
        tree.insertRoot(1);
        tree.insertRoot(7);
        tree.insertRoot(14);

        System.out.println("Árvore:");
        tree.printTree(tree.root, "");
    }
}