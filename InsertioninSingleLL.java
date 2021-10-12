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
        System.out.println("After Insertion");
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
