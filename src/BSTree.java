public class BSTree {
    private TreeNode root;

    public TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return root;
        }

        if (data > root.data) {
            root.right = insert(root.right, data);
        } else if (data < root.data) {
            root.left = insert(root.left, data);
        }
        return root;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    public TreeNode search(TreeNode root, int key) {
        if (root == null || key == root.data) {
            return root;
        }
        if (key > root.data) {
            return search(root.right, key);
        } else if (key < root.data) {
            return search(root.left, key);
        }
        return null;
    }

    public TreeNode search(int key) {
        return search(root, key);
    }

    private int maxValue(TreeNode root) {
        int maxValue = root.data;
        while (root.right != null) {
            maxValue = root.right.data;
            root = root.right;
        }
        return maxValue;
    }

    private int minValue(TreeNode root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public void delele(int key) {
        root = delete(root, key);
    }

    public TreeNode delete(TreeNode root, int key) {
        // TH0: Neu cay rong
        if (root == null) {
            return root;
        }

        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else if (key == root.data) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);

    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);

    }
}