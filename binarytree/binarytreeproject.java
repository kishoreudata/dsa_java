import java.util.LinkedList;
import java.util.Queue;

public class binarytreeproject {
    public static void main(String[]args){
        binarytreeproject bt=new binarytreeproject();
        bt.createtree();
        bt.display();
        System.out.println("Preorder: ");
        bt.preorder();
        System.out.println("Inorder");
        bt.inorder();
        System.out.println("Postorder");
        bt.postorder();
        System.out.println("Height of the tree is: "+bt.height());

    }
    class Node{
        public Node lchild;
        public char data;
        public Node rchild;
        public Node(char ch){
            data=ch;
            lchild=null;
            rchild=null;
        }
    }
    private Node root;
    public binarytreeproject(){
        root=null;
    }
    public void display(){
        display(root,0);
        System.out.println("\n");
    }
    private void display(Node p, int level){
        int i;
        if(p==null)return;
        display(p.rchild,level+1);
        System.out.println("\n");
        for (i=0;i<level;i++)
            System.out.println(" ");
        System.out.println(p.data);
        display(p.lchild,level+1);
    }
    public void preorder(){
        preorder(root);
        System.out.println("\n");
    }
    private void preorder(Node p){
        if(p==null)return;
        System.out.println(p.data+" ");
        preorder(p.lchild);
        preorder(p.rchild);
    }
    public void inorder(){
        inorder(root);
        System.out.println("\n");
    }
    private void inorder(Node p){
        if(p==null)return;
        inorder(p.lchild);
        System.out.println(p.data+" ");
        inorder(p.rchild);
    }
    public void postorder(){
        postorder(root);
        System.out.println("\n");
    }
    private void postorder(Node p){
        if(p==null)return;
        postorder(p.lchild);
        postorder(p.rchild);
        System.out.println(p.data+" ");
    }
    public void levelorder(){
        if(root==null){
            System.out.println("Tree is empty");
            return;
        }
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        Node p;
        while (qu.size()!=0){
            p=qu.remove();
            System.out.println();
            if(p.lchild!=null)qu.add(p.lchild);
            if(p.rchild!=null)qu.add(p.rchild);
        }
        System.out.println("\n");
    }
    public int height(){
        return height(root);
    }
    private int height(Node p){
        if(p==null)return 0;
        int hl=height(p.lchild);
        int hr=height(p.rchild);
        if(hl>hr)return 1+hl;
        else return 1+hr;
    }
    public void createtree(){
        root=new Node('P');
        root.lchild=new Node('Q');
        root.rchild=new Node('R');
        root.lchild.lchild=new Node('A');
        root.lchild.rchild=new Node('B');
        root.rchild.lchild=new Node('X');
    }
}
