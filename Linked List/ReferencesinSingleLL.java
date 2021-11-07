public class ReferencesinSingleLL {
    public static void main(String[] args) {
        ReferencesinSingleLL list1 = new ReferencesinSingleLL();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(3);
        list1.addNode(9);
        list1.lastnode();
        list1.secondlastnode();
        list1.Search(9);
        list1.positionk(2);
        list1.positionk(5);
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
    public void lastnode(){
        Node current = head;
        while(current!=null){
            if(current.next==null){
                System.out.println("Last Node :  "+current.data);
                break;
            }
            current=current.next;
        }
        if(current==null)System.out.println("List is empty");
    }
    public void secondlastnode(){
        Node current = head;
        while(current!=null){
            if(current.next.next==null){
                System.out.println("Second Last Node :  "+current.data);
                break;
            }
            current=current.next;
        }
        if(current==null)System.out.println("List is empty");
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
    public void positionk(int k){
        Node y=head;
        int position =1;
        while(y!=null && position < k){
            position++;
            y=y.next;
        }
        if(y==null)System.out.println("position exceeds size of the list");
        else System.out.println("Element at position "+k+" is : "+y.data);
    }
}
