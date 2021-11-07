public class headerLL {
    public static void main(String args[]){
        headerLL list1 = new headerLL();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(3);
        list1.addNode(4);
        list1.addNode(5);
        list1.insertAtEnd(6);
        list1.insertBefore(0,6);    
        list1.insertAtposition(7,7);
        list1.display();
        list1.deleteNode(0);
        list1.display();
    }
    class Node {
        int data;
        Node next;

        Node(int x) {
            data=x;
            this.next = null;
        }
    }
    private Node head;
    void addNode(int data){
        Node newNode = new Node(data);
        if(head.next==null){
            head.next=newNode;
            tail=newNode;
        }
        else{
            tail.next=newNode;
            tail=newNode;
        }
    }
    public Node tail = null;
    public headerLL(){
        head=new Node(0);
    }
    public void display(){
        if(head.next==null) {
            System.out.println("Empty list");
            return;
        }
        Node current = head.next;
        System.out.println("List:");
        while(current!=null){
            System.out.print(current.data+"\t");
            current=current.next;
        }
        System.out.println("\n");
    }
    public void insertAtEnd(int data){
        Node temp = new Node(data);
        Node p = head;
        while(p.next!=null)
            p=p.next;
        p.next=temp;
        temp.next=null;
    }
    public void insertBefore(int data,int x){
        Node p= head;
        while (p.next!=null){
            if(p.next.data==x)break;
            p=p.next;
        }
        if(p.next==null)System.out.println(x+" is not present in the list");
        else{
            Node temp=new Node(data);
            temp.next=p.next;
            p.next=temp;
        }
    }
    public void insertAtposition(int data,int k){
        Node p=head;
        int i;
        for(i =1;i<=k-1&&p!=null;i++)
            p=p.next;
        if(p==null)System.out.println("You can insert only upto " +(i-1)+" positions");
        else {
            Node temp=new Node(data);
            temp.next=p.next;
            p.next=temp;
        }
    }
    public void deleteNode(int d){
        Node p = head;
        while (p.next!=null){
            if(p.next.data==d)break;
            p=p.next;
        }
        if(p.next==null)System.out.println(d+" is not present in the list");
        else p.next=p.next.next;
    }
}
