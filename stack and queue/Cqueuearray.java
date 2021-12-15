import java.util.Scanner;
public class Cqueuearray {
    public static void main(String[] args){
        Cqueuearray qL = new Cqueuearray();
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
    public int[] queuearray;
    public int front;
    public int rear;
    public Cqueuearray(){
        queuearray=new int[10];
        front=-1;
        rear=-1;
    }
    public Cqueuearray(int maxSize){
        queuearray=new int[maxSize];
        front=-1;
        rear=-1;
    }
    public boolean isEmpty(){
        return (front==-1);
    }
    public boolean isFull(){
        return ((front==0 && rear== queuearray.length-1)||(front==rear+1));
    }
    public void insert(int x){
        if(isFull())System.out.println("Queue overflow");
        if(front==-1)front=0;
        if(rear==queuearray.length-1)rear=0;
        else rear+=1;
        queuearray[rear]=x;
    }
    public int delete(){
        if(isEmpty()){
            System.out.println("Queue underflow");
        }
        int x=queuearray[front];
        if(front==rear){
            front=-1;rear=-1;
        }
        else if(front==queuearray.length-1)front=0;
        else
            front+=1;
        return x;
    }
    public int peek(){
        if(isEmpty())System.out.println("Queue Underflow");
        return queuearray[front];
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Queue is: ");
        int i=front;
        if(front<=rear){
            while (i<=rear)System.out.println(queuearray[i++]+" ");
        }
        else {
            while (i<=queuearray.length-1)System.out.println(queuearray[i++]+" ");
            i=0;
            while (i<=rear)System.out.println(queuearray[i++]+" ");
        }
        System.out.println("\n");
    }
    public int size(){
        if(isEmpty())return 0;
        if(isFull())return queuearray.length;
        int i=front;
        int sz=0;
        if(front<=rear)
            while (i<=rear){
                sz++;i++;
            }
        else{
            while (i<=queuearray.length-1){
                sz++;i++;
            }
            i=0;
            while (i<=rear){
                sz++;i++;
            }
        }
        return sz;
    }
}
