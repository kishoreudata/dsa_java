public class FindnRemoveCycleSingleLL {
    public static void main(String[] args) {
        FindnRemoveCycleSingleLL list1 = new FindnRemoveCycleSingleLL();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(3);
        list1.addNode(9);
        list1.addNode(4);
        list1.addNode(7);
        list1.addNode(0);
        list1.addNode(-1);
        System.out.println("Before Creating Cycle");
        list1.display();
        list1.hasCycle();
        list1.insertCycle(9);
        System.out.println("After Inserting Cycle");
        list1.hasCycle();
        list1.RemoveCycle();
        System.out.println("After Removing Cycle");
        list1.hasCycle();
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
    public void insertCycle(int x){
        if(head==null)return;
        Node p = head,px=null,prev=null;
        while(p!=null){
            if(p.data==x)
                prev=p;
            px=p;
            p=p.next;
        }
        if(prev!=null)px.next=prev;
        else System.out.println(x+" is not present in the list");
    }
    public boolean hasCycle(){
        if(findCycle()==null){
            System.out.println("No cycle found");
            return false;
        }
        else return true;
    }
    private Node findCycle(){
        if(head==null || head.next==null)
            return null;
        Node slow = head, fast = head;
        while(fast!=null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)return slow;
        }
        return null;
    }
    public void RemoveCycle(){
        Node c = findCycle();
        if(c==null)return;
        System.out.println("Node at which cycle is detected is "+c.data);
        Node p=c,q=c;
        int lencycle=0;
        do{
            lencycle++;
            q=q.next;
        }
        while(p!=q);
        System.out.println("Length of cycle is:"+lencycle);
        int lenremlist=0;
        p=head;
        while(p!=q){
            lenremlist++;
            p=p.next;
            q=q.next;
        }
        System.out.println("No of nodes not included in the cycle are : "+lenremlist);
        int len=lencycle+lenremlist;
        System.out.println("Length of the list is : "+len);
        p=head;
        for(int i=1;i<len;i++)p=p.next;
        p.next=null;

    }

}
