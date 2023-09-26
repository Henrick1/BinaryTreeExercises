import java.util.Scanner;

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

    public Node deleteNumb(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.data) {
            root.left = deleteNumb(root.left, key);
        } else if (key > root.data) {
            root.right = deleteNumb(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = complete(root.right);
            root.right = deleteNumb(root.right, root.data);
        }

        return root;
    }

    private int complete(Node root) {
        int replace = root.data;
        while (root.left != null) {
            replace = root.left.data;
            root = root.left;
        }
        return replace;
    }

    public void printTree(Node node, String path) {
        if (node == null) {
            return;
        }

        path += node.data +  " -> ";

        if (node.left == null && node.right == null) {
            System.out.println(path);
        } else {
            printTree(node.left, path);
            printTree(node.right, path);
        }
    }
}

public class Ex5 {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] elements = {6, 13, 2, 1, 7, 14};

        for (int element : elements) {
            tree.insertRoot(element);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número que você deseja remover: ");
        int numberRemove = scanner.nextInt();

        tree.root = tree.deleteNumb(tree.root, numberRemove);

        System.out.println("Árvore após remover o número " + numberRemove + ":");
        tree.printTree(tree.root, "");
    }
}
