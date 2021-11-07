public class ReverseSingleLL
{
    public static void main(String[] args) {
        ReverseSingleLL list1 = new ReverseSingleLL();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(3);
        list1.addNode(9);
        list1.addNode(4);
        list1.addNode(7);
        list1.addNode(0);
        System.out.println("List Before Reversal");
        list1.display();
        System.out.println("List After Reversal");
        list1.ReverseList();
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
    public void ReverseList(){
        Node prev,current,next;
        prev=null;
        current=head;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
    }
}
