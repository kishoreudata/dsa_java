public class Merge2SortedSingleLL {
    public static void main(String[] args) {
        Merge2SortedSingleLL list1 = new Merge2SortedSingleLL();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(3);
        list1.addNode(4);
        list1.addNode(7);
        list1.addNode(9);
        System.out.println("Before Merging the lists 1 and 2");
        list1.display();
        Merge2SortedSingleLL list2 = new Merge2SortedSingleLL();
        list2.addNode(10);
        list2.addNode(13);
        list2.addNode(17);
        list2.addNode(19);
        list2.addNode(21);
        list2.display();
        //System.out.println(list2.head.data);
        System.out.println("After merging two lists");
        Node newnode = Merge(list1.head, list2.head);
        list1.display();
    }
    // Link list node
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            this.next = null;
        }
    }
    void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Node head = null;
    public Node tail = null;
    public Node newhead = null;

    public  void display() {
        Node current = head;
        System.out.println("List:");
        if (current == null) System.out.println("Empty list");
        else
            while (current != null) {
                System.out.print(current.data + "\t");
                current = current.next;
            }
        System.out.println("\n");
    }
    static Node Merge(Node p1, Node p2) {
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