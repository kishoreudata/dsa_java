package binarytree;
import java.util.Scanner;

public class bstproject {
    public static void main(String[] args){
        bstproject bst=new bstproject();
        int choice,x;
        Scanner sc= new Scanner(System.in);
        while (true){
            System.out.println("1.Display tree");
            System.out.println("2.Search");
            System.out.println("3.Insert a new node");
            System.out.println("4.Delete a node");
            System.out.println("5.Preorder Traversal");
            System.out.println("6.Inorder Traversal");
            System.out.println("7.Postorder Traversal");
            System.out.println("8.Height of tree");
            System.out.println("9.Find minimum key");
            System.out.println("10.Find maximum key");
            System.out.println("11.Quit");
            System.out.println("Enter your choice");
            choice=sc.nextInt();
            if(choice==11)break;
            switch (choice){
                case 1:bst.display();break;
                case 2:
                    System.out.println("Enter the key to be searched");
                    x=sc.nextInt();
                    if(bst.search(x))System.out.println("Key found");
                    else System.out.println("Key not found");
                    break;
                case 3:
                    System.out.println("Enter the key to  be inserted");
                    x=sc.nextInt();
                    bst.insert(x);
                    break;
                case 4:
                    System.out.println("Enter the key to be deleted");
                    x=sc.nextInt();
                    bst.delete(x);
                    break;
                case 5:bst.preorder();break;
                case 6:bst.inorder();break;
                case 7:bst.postorder();break;
                case 8:System.out.println("Height of tree is "+bst.height());break;
                case 9:System.out.println("Minimum key is "+bst.min());break;
                case 10:System.out.println("Maximum key is "+bst.max());break;
            }
        }
    }
    class node{
        public node lchild;
        public int data;
        public node rchild;
        public node(int d){
            data=d;
            lchild=null;
            rchild=null;
        }
    }
    private node root;
    public bstproject(){
        root=null;
    }
    public boolean isEmpty(){
        return (root==null);
    }
    public void insert(int x){
        root=insert(root,x);
    }
    private node insert(node p,  int x){
        if(p==null)p=new node(x);
        else if(x<p.data)p.lchild=insert(p.lchild,x);
        else if (x>p.data)p.rchild=insert(p.rchild,x);
        else  System.out.println(x+"  already present in tree");
        return p;
    }
    public void insert1(int x){
        node p=root;
        node par=null;
        while (p!=null){
            par= p;
            if(x<p.data)p=p.lchild;
            else if(x>p.data)p=p.rchild;
            else {
                System.out.println(x+" already present in the tree");
                return;
            }
        }
        node temp=new node(x);
        if(par==null)root=temp;
        else if(x<par.data)par.lchild=temp;
        else par.rchild=temp;
    }
    public boolean search(int x){
        return (search(root,x))!=null;
    }
    private node search(node p, int x){
        if(p==null)return null;
        if(x<p.data)return search(p.lchild,x);
        if(x>p.data)return search(p.rchild,x);
        return p;
    }
    public boolean search1(int x){
        node p = root;
        while (p!=null){
            if(x<p.data)p=p.lchild;
            else if(x>p.data)p=p.rchild;
            else return true;
        }
        return false;
    }
    public void delete(int x){
        root=delete(root,x);
    }
    private node delete(node p,int x){
        node ch,s;
        if(p==null){
            System.out.println(x+" not found");
            return p;
        }
        if(x<p.data)p.lchild=delete(p.lchild,x);
        else if(x>p.data)p.rchild=delete(p.rchild,x);
        else {
            if(p.lchild!=null && p.rchild!=null){
                //2 children
                s=p.rchild;
                while (s.lchild!=null)s=s.lchild;
                p.data=s.data;
                p.rchild=delete(p.rchild,s.data);
            }
            else {
                // lchild or rchild
                if(p.lchild!=null)ch=p.lchild;
                else ch=p.rchild;
                p=ch;
            }
        }
        return p;
    }
    public void delete1(int x){
        node p=root;
        node par=null;
        while (p!=null){
            if(x==p.data)break;
            par=p;
            if(x<p.data)p=p.lchild;
            else p=p.rchild;
        }
        if(p==null){
            System.out.println(x+" not found");
            return;
        }
        node s,ps;
        if(p.lchild!=null && p.rchild!=null){
            ps=p;
            s=p.rchild;
            while (s.lchild!=null){
                ps=s;
                s=s.lchild;
            }
            p.data=s.data;
            p=s;
            par=ps;
        }
        node ch;
        if(p.lchild!=null)ch=p.lchild;
        else ch=p.rchild;
        if(par==null)root=ch;//node to be deleted is root
        else if(p==par.lchild) par.lchild=ch;
        else par.rchild=ch;
    }
    public int min(){
        if(isEmpty()){
            System.out.println("Tree is empty");
            return -1;
        }
        return min(root).data;
    }
    private node min(node p){
        if(p.lchild==null)return p;
        return min(p.lchild);
    }
    public int min1(node p){
        if(isEmpty()){
            System.out.println("Tree is empty");
            return -1;
        }
        p = root;
        while (p.lchild!=null)p=p.lchild;
        return p.data;
    }
    public int max(){
        if(isEmpty()){
            System.out.println("Tree is empty");
            return -1;
        }
        return max(root).data;
    }
    private node max(node p){
        if(p.rchild==null)return p;
        return max(p.rchild);
    }
    public int max1(node p){
        if(isEmpty()){
            System.out.println("Tree is empty");
            return -1;
        }
        p = root;
        while (p.rchild!=null)p=p.rchild;
        return p.data;
    }
    public void display(){
        display(root,0);
        System.out.println("\n");
    }
    private void display(node p, int level){
        int i;
        if(p==null)return;
        display(p.rchild,level+1);
        System.out.println("\n");
        for (i=0;i<level;i++){
            System.out.println("  ");
        }
        System.out.println(p.data);
        display(p.lchild,level+1);
    }
    public void preorder(){
        preorder(root);
        System.out.println("\n");
    }
    private void preorder(node p){
        if(p==null)return;
        System.out.println(p.data+" ");
        preorder(p.lchild);
        preorder(p.rchild);
    }
    public void inorder(){
        inorder(root);
        System.out.println("\n");
    }
    private void inorder(node p){
        if(p==null)return;
        preorder(p.lchild);
        System.out.println(p.data+" ");
        preorder(p.rchild);
    }
    public void postorder(){
        postorder(root);
        System.out.println("\n");
    }
    private void postorder(node p){
        if(p==null)return;
        preorder(p.lchild);
        preorder(p.rchild);
        System.out.println(p.data+" ");
    }
    public int height(){
        return height(root);
    }
    private int height(node p){
        int hL,hR;
        if(p==null)return 0;
        hL=height(p.lchild);
        hR=height(p.rchild);
        return Math.max(hL,hR)+1;
    }

}
