public class MergeSortRecSingleLL {
    public static void main(String[] args) {
        MergeSortRecSingleLL list1 = new MergeSortRecSingleLL();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(3);
        list1.addNode(9);
        list1.addNode(4);
        list1.addNode(7);
        list1.addNode(0);
        list1.addNode(-1);
        System.out.println("Before Sorting");
        list1.display();
        System.out.println("After Sorting");
        list1.MergeSort();
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
    public void MergeSort(){
        head=MergesortRec(head);
    }
    private Node MergesortRec(Node head){
        if(head==null || head.next==null) return head;
        Node head1=head;
        Node head2=DivideList(head);
        head1=MergesortRec(head1);
        head2=MergesortRec(head2);
        Node start = Merge(head1,head2);
        return start;
    }
    private Node DivideList(Node p){
        Node q = p.next.next;
        while(q!=null && q.next!=null){
            p=p.next;
            q=q.next.next;
        }
        Node head2 =p.next;
        p.next=null;
        return head2;
    }
    private Node Merge(Node p1, Node p2) {
        Node head;
        if (p1.data <= p2.data) {
            head = p1;
            p1 = p1.next;
        } else {
            head = p2;
            p2 = p2.next;
        }
        Node current = head;
        while (p1 != null & p2 != null) {
            if (p1.data <= p2.data) {
                current.next = p1;
                current = current.next;
                p1 = p1.next;
            } else {
                current.next = p2;
                current = current.next;
                p2 = p2.next;
            }
        }
        if (p1 == null) current.next = p2;
        else current.next = p1;
        return head;
    }
}
