public class BubbleSortSingleLL {
    public static void main(String[] args) {
        BubbleSortSingleLL list1 = new BubbleSortSingleLL();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(3);
        list1.addNode(9);
        list1.addNode(4);
        list1.addNode(7);
        list1.addNode(0);
        System.out.println("Before Sorting");
        list1.display();
        System.out.println("After Sorting by exchanging data");
        list1.BubbleSortExData();
        list1.display();
        System.out.println("New List");
        list1.addNode(-1);
        list1.display();
        System.out.println("After Sorting by exchanging links");
        list1.BubbleSortExLinks();
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
    public void BubbleSortExData(){
        Node end,p,q;
        for(end=null;end!=head.next;end=p){
            for(p=head;p.next!=end;p=p.next){
                q=p.next;
                if(p.data>q.data){
                    p.data=p.data+q.data;
                    q.data=p.data-q.data;
                    p.data=p.data-q.data;
                }
            }
        }
    }
    public void BubbleSortExLinks(){
        Node end,p,q,r,temp;
        for(end=null;end!=head.next;end=p){
            for(r=p=head;p.next!=end;r=p,p=p.next){
                q=p.next;
                if(p.data>q.data){
                    p.next=q.next;
                    q.next=p;
                    if(p!=head)r.next=q;
                    else head=q;
                    temp=p;
                    p=q;
                    q=temp;
                }
            }
        }
    }
}
