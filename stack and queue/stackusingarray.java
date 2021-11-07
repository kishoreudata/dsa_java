import java.util.Scanner;
public class stackusingarray {
    public static void main(String[] args){
        stackusingarray stA = new stackusingarray(8);
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
                    stA.push(x);
                    break;
                case 2:
                    x=stA.pop();
                    System.out.println("Popped element is "+x);
                    break;
                case 3:
                    System.out.println("Element at the top is "+stA.peek());
                    break;
                case 4:
                    stA.display();
                    break;
                case 5:
                    System.out.println("Size of the stack is "+stA.size());
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
            System.out.println("");
        }
    }
    int[] stackarray;
    int top;
    public stackusingarray(){
        stackarray = new int[10];
        top=-1;
    }
    public stackusingarray(int maxSize){
        stackarray = new int[maxSize];
        top=-1;
    }
    public int size(){return top+1;}
    public boolean isempty(){return (top==-1);}
    public boolean isfull(){return (top==stackarray.length-1);}
    public void push(int x){
        if(isfull()){
            System.out.println("stack overflow");
            return;
        }
        top+=1;
        stackarray[top]=x;
    }
    public int pop(){
        if(isempty()){
            System.out.println("stack underflow");
            return 0;
        }
        int x=stackarray[top];
        top-=1;
        return x;
    }
    public int peek(){
        if(isempty()){
            System.out.println("stack underflow");
            return 0;
        }
        return stackarray[top];
    }
    public void display(){
        if (isempty()){
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Stack is: ");
        for (int i=top;i>=0;i--)
            System.out.println(stackarray[i]+" ");
        System.out.println("");

    }
}
