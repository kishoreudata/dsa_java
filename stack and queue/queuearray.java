import java.util.Scanner;
public class queuearray {
    public static void main(String[] args){
        queuearray qA = new queuearray(8);
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
                    qA.insert(x);
                    break;
                case 2:
                    x=qA.delete();
                    System.out.println("Deleted element is "+x);
                    break;
                case 3:
                    System.out.println("Element at the top is "+qA.peek());
                    break;
                case 4:
                    qA.display();
                    break;
                case 5:
                    System.out.println("Size of the queue is "+qA.size());
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
            System.out.println("");
        }
    }
    public int[] queueA;
    public int front;
    public int rear;
    public queuearray(){
        queueA = new int[10];
        front=-1;
        rear=-1;
    }
    public queuearray(int maxSize){
        queueA = new int[maxSize];
        front=-1;
        rear=-1;
    }
    public boolean isEmpty(){
        return (front==-1||front==rear+1);
    }
    public boolean isFull(){
        return (rear==queueA.length-1);
    }
    public int size(){
        if(isEmpty())return 0;
        else return rear-front+1;
    }
    public void insert(int x){
        if (isFull()){
            System.out.println("Queue overflow");
        }
        if(front==-1)
            front=0;
        rear=rear+1;
        queueA[rear]=x;

    }
    public int delete(){
        int x;
        if(isEmpty()){
            System.out.println("Queue Underflow");
            return -1;
        }
        x=queueA[front];
        front+=1;
        return x;
    }
    public int peek(){
        if (isEmpty()){
            System.out.println("Queue Underflow");
            return -1;
        }
        return queueA[front];
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Queue Underflow");
        }
        System.out.println("Queue is: \n");
        for (int i=front;i<=rear;i++){
            System.out.print(queueA[i]+"\t");
        }
        System.out.println("\n");

    }

}
