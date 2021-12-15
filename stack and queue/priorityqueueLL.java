import java.util.Scanner;
public class priorityqueueLL {
    public static void main(String[] args){
        priorityqueueLL pq=new priorityqueueLL();
        int choice,element,elementPriority;
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("1.Insert a new element in the queue");
            System.out.println("2.Delete an element from the queue");
            System.out.println("3.Display the queue");
            System.out.println("4.Quit");
            System.out.println("Enter your choice \t");
            choice= sc.nextInt();
            if(choice==4)break;
            switch (choice){
                case 1:
                    System.out.println("enter the element to be inserted");
                    element= sc.nextInt();
                    System.out.println("enter it's priority");
                    elementPriority= sc.nextInt();
                    pq.insert(element,elementPriority);
                    break;
                case 2:
                    System.out.println("Deleted element is "+pq.delete());
                    break;
                case 3:
                    pq.display();
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
            System.out.println("");
    }
    }
    public Node front=null;
    class Node {
        int data;
        int priority;
        Node next;
        Node(int d,int p){
            data = d;
            priority=p;
            this.next = null;
        }
    }
    public void insert(int element,int elementpriority){
        Node temp,p;
        temp=new Node(element,elementpriority);
        if(isEmpty()||elementpriority<front.priority){
            temp.next= front;
            front=temp;
        }
        else{
            p=front;
            while (p.next!=null && p.next.priority<=elementpriority)p=p.next;
            temp.next=p.next;
            p.next= temp;
        }
    }
    public int delete(){
        int element;
        if(isEmpty()){
            System.out.println("Queue Underflow");
            return -1;
        }
        else {
            element=front.data;
            front=front.next;
        }
        return element;
    }
    public boolean isEmpty(){
        return (front==null);
    }
    public void display(){
        Node p=front;
        if(isEmpty()){
            System.out.println("Queue is empty");
        }
        else{
            System.out.println("Queue is: \n");
            System.out.println("Element -   Priority");
            while (p!=null){
                System.out.println(p.data+"     "+p.priority);
                p=p.next;
            }
            System.out.println("");
        }
    }
}
