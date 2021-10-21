import java.util.*;
public class DoubleLL {
    public static void main(String[] args){
        DoubleLL list1 = new DoubleLL();
        list1.createList();
        list1.insertinBeginning(0);
        list1.insertatEnd(7);
        list1.insertAfter(3,4);
        list1.insertBefore(6,7);
        list1.display();
        // input - no of nodes = 4 , list 1 2 4 5
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
    public Node head = null;
    public Node prev = null;
    public Node next = null;
    public void display(){
        Node current = head;
        System.out.println("List:");
        if(current==null) System.out.println("Empty list");
        else
            while(current!=null){
                System.out.print(current.data+"\t");
                current=current.next;
            }
        System.out.println("\n");
    }
    public void insertinEmptylist(int data){
        Node temp = new Node(data);
        head = temp;
    }
    public void insertinBeginning(int data){
        Node temp= new Node(data);
        temp.next=head;
        head.prev=temp;
        head=temp;
    }
    public void insertatEnd(int data){
        Node temp = new Node(data);
        Node current = head;
        while(current.next!=null)
            current=current.next;
        current.next=temp;
        temp.prev=current;
    }
    public void createList(){
        System.out.println("Enter no of nodes \t ");
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream
        int n = sc.nextInt();
        System.out.println("Enter the first element to be inserted \t");
        insertinEmptylist(sc.nextInt());
        System.out.println("Enter the next elements to be inserted \t ");
        for(int i=2;i<=n;i++)insertatEnd(sc.nextInt());
    }
    public void insertAfter(int data,int x){
        Node temp=new Node(data);
        Node current=head;
        while (current!=null){
            if(current.data==x)
                break;
            current=current.next;
        }
        if(current==null)System.out.println(x+" is not present in the list");
        else{
            temp.prev=current;
            temp.next=current.next;
            if(current.next!=null)
                current.next.prev=temp;//should not be done when p refers to last node
            current.next=temp;
        }
    }
    public void insertBefore(int data, int x){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node temp = new Node(data);
        if(head.data==x){
            temp.next=head;
            head.prev=temp;
            head=temp;// or directly call insertinBeginning(data);
        }
        Node current=head;
        while(current!=null){
            if(current.data==x)
                break;
            current=current.next;
        }
        if(current==null)System.out.println(x+" is not present in the list");
        else{
            temp.next=current;
            temp.prev=current.prev;
            current.prev.next=temp;
            current.prev=temp;
        }
    }
}
