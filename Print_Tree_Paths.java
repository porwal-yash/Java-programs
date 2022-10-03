import java.util.Scanner;

public class Print_Tree_Paths {

    class Node
    {
        int data;
        Node left;
        Node right;
    }

    void print(int paths[], int pathLength)
    {
        int i;

        for(i = 0; i < pathLength; i++)
            System.out.print(paths[i]+" ");

        System.out.print("\n");
    }

    void printPathsRecur(Node root, int paths[], int pathLength)
    {
        if (root == null)
            return;

        paths[pathLength++] = root.data;

        if(root.left == null && root.right == null)
            print(paths, pathLength);
        else
        {
            printPathsRecur(root.left, paths, pathLength);
            printPathsRecur(root.right, paths, pathLength);
        }
    }

    void printPaths(Node root)
    {
        int paths[] = new int[100];
        printPathsRecur(root, paths,0);
    }

    Node getNewNode(int val)
    {
        Node newNode = new Node();
        newNode.data   = val;
        newNode.left  = null;
        newNode.right = null;

        return newNode;
    }

    Node insert(Node root, int val)
    {
        if(root == null)
            return getNewNode(val);
        if(root.data < val)
            root.right = insert(root.right, val);
        else if(root.data > val)
            root.left = insert(root.left,val);

        return root;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Print_Tree_Paths obj = new Print_Tree_Paths();

        Node root = null;
        int n,val;

        n = sc.nextInt();

        while(n-- > 0)
        {
            val = sc.nextInt();
            root = obj.insert(root, val);
        }

        obj.printPaths(root);
    }
}
