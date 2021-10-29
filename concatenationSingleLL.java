public class concatenationSingleLL {
    public static void main(String[] args) {
        concatenationSingleLL list1=new concatenationSingleLL();
        concatenationSingleLL list2=new concatenationSingleLL();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(3);
        list1.addNode(4);
        System.out.println("list 1");
        list1.display();
        list2.addNode(5);
        list2.addNode(6);
        list2.addNode(7);
        list2.addNode(8);
        System.out.println("list 2");
        list2.display();
        System.out.println("Lists after concatenating");
        Node newnode = concatenateLL(list1.head,list2.head);
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
        static Node concatenateLL(Node p1,Node p2){
            Node head;
            if (p1==null){
                head=p2;
                return head;
            }
            if (p2==null)return p1;
            while (p1.next!=null) p1=p1.next;
            p1.next=p2;
            head=p1;
            return head;
        }
}
