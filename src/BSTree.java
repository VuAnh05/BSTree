public class BSTree {
    private TreeNode root;

    public void insert(int data){
        root = insert(root, data);
    }
    public TreeNode insert(TreeNode root, int data){
        if ( root == null){
            root = new TreeNode(data);
            return root;
        }

        if ( data < root.data){
            root.left = insert(root.left, data);
        }
        else if ( data > root.data){
            root.right = insert(root.right, data);
        }
        return root;
    }

    public TreeNode search(TreeNode root, int key){
        if ( root == null || root.data == key){
            return root;
        }
        if ( key < root.data ){
            return search(root.left, key);
        }
        else if ( key > root.data){
            return search(root.right, key);
        }
        return root;
    }
}
