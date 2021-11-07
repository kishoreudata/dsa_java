public class TraverseSearchSingleLL {
    public static void main(String[] args) {
        TraverseSearchSingleLL list1 = new TraverseSearchSingleLL();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(3);
        list1.TraverseLL();
        list1.display();
        list1.Search(2);

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

    public void TraverseLL(){
        Node current=head;
        int n=0;
        while(current!=null){
            System.out.println(current.data);
            n++;
            current=current.next;
        }
        System.out.println("no of nodes are   " + n);
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
    public void Search(int x){
        Node y=head;
        int position =1;
        while(y!=null){
            if(y.data==x){
                System.out.println(x+" is present at  position no : "+position);
                break;
            }
            position++;
            y=y.next;
        }
        if(y==null)System.out.println(x+" is not found in the list");
    }
}
