public class circularLL {
    public static void main(String[] args){
        circularLL list1 = new circularLL();
        list1.createList();
    }
    class Node{
        public int data;
        public Node prev,next;
        public Node(int i){
            data = i;
            prev=null;
            next =null;
        }
    }
    public Node last=null;
    public void display(){
        if(last==null){
            System.out.println("List is empty\n");
            return;
        }
        Node p = last.next;
        do{
            System.out.println(p.data+" ");
            p=p.next;
        }while(p!=last.next);
    }
    public void createList(){
        
    }
}

