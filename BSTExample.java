import java.util.Scanner;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}
public class BSTExample {
    static Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static void postorder(Node root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("How many character values do you want to enter? ");
        int size = scanner.nextInt();

        char[] data = new char[size];
        int validCount = 0;

        // Get character values from the user
        for (int i = 0; i < size; i++) {

            System.out.print("Enter character " + (i + 1) + " (or null): ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("null")) {
                continue;
            }

            data[validCount] = input.charAt(0);
            validCount++;
        }

        // Build the Binary Search Tree
        Node root = null;

        for (int i = 0; i < validCount; i++) {
            root = insert(root, data[i]);
        }

        // Display traversal menu
        int choice;

        do {
            System.out.println("\n===== BST Traversal Menu =====");
            System.out.println("1. Inorder Traversal");
            System.out.println("2. Preorder Traversal");
            System.out.println("3. Postorder Traversal");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Inorder Traversal:");
                    inorder(root);
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Preorder Traversal:");
                    preorder(root);
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Postorder Traversal:");
                    postorder(root);
                    System.out.println();
                    break;

                case 4:
                    System.out.println("End of Program");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1-4.");
                    break;
            }

        } while (choice != 4);

        scanner.close();
    }
}