import java.util.Scanner;
public class stackusingLL {
    public static void main(String[] args) {
        stackusingLL stL = new stackusingLL();
        Scanner sc = new Scanner(System.in);
        int choice, x;
        while (true){
            System.out.println("1.Push an element from the stack");
            System.out.println("2.Pop an element from the stack");
            System.out.println("3.Display the top element");
            System.out.println("4.Display all stack elements");
            System.out.println("5.Display size of the stack");
            System.out.println("6.Quit");
            System.out.println("Enter your choice \t");
            choice= sc.nextInt();
            if(choice==6)break;
            switch (choice){
                case 1:
                    System.out.println("enter the element to be pushed");
                    x= sc.nextInt();
                    stL.push(x);
                    break;
                case 2:
                    x=stL.pop();
                    System.out.println("Popped element is "+x);
                    break;
                case 3:
                    System.out.println("Element at the top is "+stL.peek());
                    break;
                case 4:
                    stL.display();
                    break;
                case 5:
                    System.out.println("Size of the stack is "+stL.size());
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
    private Node top= null;
    public void display(){
        Node current = top;
        System.out.println("List:");
        if(current==null) System.out.println("Empty list");
        else
            while(current!=null){
                System.out.print(current.data+"\t");
                current=current.next;
            }
        System.out.println("\n");
    }
    public int size(){
        int s=0;
        Node p =top;
        while(p!=null){
            p=p.next;
            s++;

        }
        return s;
    }
    public void push(int x){
        Node temp= new Node(x);
        temp.next=top;
        top=temp;
    }
    public int pop (){
        int x;

        if(top==null){
            System.out.println("stLck Underflow");
            return -1;
        }
        x=top.data;
        top=top.next;
        return x;
    }
    public int peek(){
        if(top==null){
            System.out.println("stLck Underflow");
            return -1;
        }
        return top.data;
    }

}
