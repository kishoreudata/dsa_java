import java.util.Scanner;

public class circularLL {
    public static void main(String[] args){
        circularLL list1 = new circularLL();
        list1.createList();
        list1.insertAfter(4,3);
        list1.insertinBeginning(1);
        //input n=5 2 3 5 6 7
        list1.display();
    }
    class Node{
        public int data;
        public Node prev,next;
        public Node(int i){
            data = i;
            prev=null;
            next =null;
        }
    }
    public Node last=null;
    public void display(){
        if(last==null){
            System.out.println("List is empty\n");
            return;
        }
        Node p = last.next;
        System.out.println("List");
        do{
            System.out.print(p.data+" ");
            p=p.next;
        }while(p!=last.next);
    }
    public void createList(){
        int i,n, data;
        System.out.println("Enter the number of nodes");
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        if(n==0)return;
        System.out.println("Enter the first element to be inserted");
        data=sc.nextInt();
        insertinEmptylist(data);
        System.out.println("Enter the elements to be inserted");
        for(i=2;i<=n;i++){
            data=sc.nextInt();
            insertatEnd(data);
        }
    }
    public void insertinBeginning(int data){
        Node temp = new Node(data);
        temp.next=last.next;
        last.next=temp;
    }
    public void insertinEmptylist(int data){
        Node temp = new Node(data);
        last=temp;
        last.next=last;
    }
    public void insertatEnd(int data){
        Node temp = new Node(data);
        temp.next = last.next;
        last.next=temp;
        last = temp;
    }
    public void insertAfter(int data, int x){
        Node p = last.next;
        do{
            if(p.data==x)
                break;
            p=p.next;
        }while (p!=last.next);
        if(p==last.next&&p.data!=x)System.out.println(x+" is not present in the list");
        else {
            Node temp = new Node(data);
            temp.next = p.next;
            p.next=temp;
            if(p==last)last=temp;
        }
    }
}

