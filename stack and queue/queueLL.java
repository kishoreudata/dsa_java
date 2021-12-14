import java.util.Scanner;
public class queueLL {
    public static void main(String[] args){
        queueLL qL = new queueLL();
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
    private Node front=null;
    private Node rear=null;
    public int size(){
        int s=0;
        Node p =front;
        while(p!=null){
            p=p.next;
            s++;

        }
        return s;
    }
    public void insert(int x){
        Node temp = new Node(x);
        if(front==null)front=temp;
        else rear.next=temp;
        rear=temp;
    }
    public int delete(){
        int x;
        if(front==null){ //or if(IsEmpty()){
            System.out.println("Queue Underflow");
            return -1;
        }
        x=front.data;
        front=front.next;
        return x;
    }
    public int peek(){
        if(front==null){ //or if(IsEmpty()){
            System.out.println("Queue Underflow");
            return -1;
        }
        return front.data;

    }
    public boolean isEmpty(){
        return (front==null);
    }
    public void display(){
        Node p = front;
        if(front==null){ //or if(IsEmpty()){
            System.out.println("Queue Underflow");
        }
        else {
            while (p!=null){
                System.out.println(p.data+" ");
                p=p.next;
            }
            System.out.println("\n");
        }
    }

}

