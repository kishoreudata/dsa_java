public class InsertioninSingleLL {
    public static void main(String[] args) {
        InsertioninSingleLL list1 = new InsertioninSingleLL();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(3);
        list1.addNode(9);
        System.out.println("Before Insertion");
        list1.display();
        list1.InsertInBeginning(4);
        list1.InsertAtEnd(5);
        System.out.println("After Insertion at start,end");
        list1.display();
        System.out.println("After Insertion at before or after an item, insertion at kth position");
        list1.InsertBefore(7,1);
        list1.InsertAfter(6,5);
        list1.InsertAtPosition(0,4);
        list1.display();


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
    void addNode(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
        }
        else{
            tail.next=newNode;
            tail=newNode;
        }
    }
    public Node head = null;
    public Node tail = null;
    public void InsertInBeginning(int data){
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }
    public void InsertAtEnd(int data){
        Node temp = new Node(data);
        if(head == null){
            head =temp;
            return;
        }
        Node current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=temp;
    }
    public void InsertAfter(int data , int x){
        Node current = head;
        while(current!=null){
            if(current.data==x)break;
            current=current.next;
        }
        if(current==null){
            System.out.println(x+" is not present in the list");
            return;
        }
        else{
            Node temp = new Node(data);
            temp.next=current.next;
            current.next=temp;
        }
    }
    public void InsertBefore(int data, int x){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(x==head.data){
            Node temp = new Node(data);
            temp.next=head;
            head=temp;
            return;
        }
        Node current = head;
        while(current.next!=null){
            if(current.next.data==x)break;
            current=current.next;
        }
        if(current.next==null){
            System.out.println(x+" is not present in the list");
            return;
        }
        else{
            Node temp = new Node(data);
            temp.next=current.next;
            current.next=temp;
        }
    }
    public void InsertAtPosition(int data,int k){
        int position=1;
        if(k==1){
            Node temp = new Node(data);
            temp.next=head;
            head = temp;
        }
        Node current = head;
        for(;position<k-1&&current!=null;position++)current=current.next;
        if(current==null)System.out.println("You can insert only upto "+position+"th position");
        else{
            Node temp = new Node(data);
            temp.next=current.next;
            current.next = temp;
        }

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
