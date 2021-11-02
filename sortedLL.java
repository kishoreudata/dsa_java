import java.util.Scanner;

public class sortedLL {
    public static void main(String[] args) {
        sortedLL list1 = new sortedLL();
        list1.createList();
        list1.display();
    }
        class Node {
        int data;
        Node next;

        Node(int x) {
            data=x;
            this.next = null;
        }
    }
    public Node head;
    public sortedLL(){
        head=null;
    }
    public void insertinorder(int data){
        Node temp=new Node(data);
        if(head==null||data<head.data){
            temp.next=head;
            head=temp;
            return;
        }
        Node p=head;
        while (p.next!=null && p.next.data<=data)
            p=p.next;
        temp.next=p.next;
        p.next=temp;
    }
    public void createList(){
        System.out.println("Enter no of nodes \t ");
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream
        int n = sc.nextInt();
        if(n==0)return;
        System.out.println("Enter the elements to be inserted \t ");
        for(int i=1;i<=n;i++)insertinorder(sc.nextInt());
    }
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

}
