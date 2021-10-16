public class DeletionSingleLL {
    public static void main(String[] args) {
        DeletionSingleLL list1 = new DeletionSingleLL();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(3);
        list1.addNode(9);
        list1.addNode(4);
        list1.addNode(7);
        list1.addNode(0);
        System.out.println("List Before Deletion");
        list1.display();
        System.out.println("List After Deletion");
        list1.DeleteFirstNode();
        list1.DeleteLastNode();
        list1.DeleteNode(9);
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
    public void DeleteFirstNode(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        head=head.next;
    }
    public void DeleteLastNode(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(head.next==null){
            head=null;
            return;
        }
        Node current=head;
        while(current.next.next!=null){
            current=current.next;
        }
        current.next=null;
    }
    public void DeleteNode(int x){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(head.data==x){
            head=head.next;
            return;
        }
        Node current = head;
        while(current.next!=null){
            if(current.next.data==x)
                break;
            current=current.next;
        }
        if(current.next==null){
            System.out.println(x+" is not present in the list");
        }
        else
            current.next=current.next.next;
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
