import java.util.Scanner;
public class CqueueLL {
    public static void main(String[] args){
        CqueueLL qL = new CqueueLL();
        Scanner sc = new Scanner(System.in);
        int choice,x;
        while (true){
            System.out.println("1.Insert an element in the queue");
            System.out.println("2.Delete an element from the queue");
            System.out.println("3.Display the top element");
            System.out.println("4.Display all queue elements");
            System.out.println("5.Display size of the queue");
            System.out.println("6.Quit");
            System.out.println("Enter your choice \t");
            choice= sc.nextInt();
            if(choice==6)break;
            switch (choice){
                case 1:
                    System.out.println("enter the element to be inserted");
                    x= sc.nextInt();
                    qL.insert(x);
                    break;
                case 2:
                    x=qL.delete();
                    System.out.println("Deleted element is "+x);
                    break;
                case 3:
                    System.out.println("Element at the front is "+qL.peek());
                    break;
                case 4:
                    qL.display();
                    break;
                case 5:
                    System.out.println("Size of the queue is "+qL.size());
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
            System.out.println("");
        }
    }
    // Link list node
    class Node {
        int data;
        Node next;
        Node(int d){
            data = d;
            this.next = null;
        }
    }
    private Node rear=null;
    public int size(){
        int s=0;
        Node p =rear.next;
        do{
            p=p.next;
            s++;
        }while (p!=rear.next);
        return s;
    }
    public void insert(int x){
        Node temp = new Node(x);
        if(rear==null){
            rear=temp;
            rear.next=rear;
        }
        else {
            temp.next=rear.next;
            rear.next = temp;
            rear=temp;
        }
    }
    public int delete(){
        int x;
        if(rear==null){ //or if(IsEmpty()){
            System.out.println("Queue Underflow");
            return -1;
        }
        Node temp;
        if(rear.next==rear){
            temp=rear;
            rear=null;
        }
        else {
            temp=rear.next;
            rear.next=temp.next;
        }
        return temp.data;
    }
    public int peek(){
        if(rear==null){ //or if(IsEmpty()){
            System.out.println("Queue Underflow");
            return -1;
        }
        return rear.next.data;

    }
    public boolean isEmpty(){
        return (rear==null);
    }
    public void display(){
        if(rear==null){ //or if(IsEmpty()){
            System.out.println("Queue is Empty");
        }
        else {
            Node p = rear.next;
            System.out.println("Queue is : \t");
            do{
                System.out.println(p.data+" ");
                p=p.next;
            }while (p!=rear.next);
            System.out.println("\n");
        }
    }

}

