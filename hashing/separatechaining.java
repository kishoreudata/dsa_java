package hashing;

import com.sun.deploy.security.SelectableSecurityManager;
import netscape.security.UserTarget;

import java.util.Scanner;

public class separatechaining {
    public static class studentrecord{
        private int studentid;
        private String studentname;
        public studentrecord(int i,String name){
            studentid=i;
            studentname=name;
        }
        public int getstudentid(){
            return studentid;
        }
        public void setstudentid(int i){
            studentid=i;
        }
        public String tostring(){
            return studentid+" "+studentname+" ";
        }
    }
    public static class node{
        public studentrecord data;
        public node next;
        public node(studentrecord rec){
            data=rec;
            next=null;
        }
    }
    public static class singleLL{
        private node start;
        public singleLL(){
            start=null;
        }
        public void displaylist(){
            node p;
            if (start==null){
                System.out.println("___");
                return;
            }
            p=start;
            while (p!=null){
                System.out.println(p.data.tostring()+" ");
                p=p.next;
            }
            System.out.println("\n");
        }
        public studentrecord search(int x){
            node p=start;
            while (p!=null){
                if(p.data.getstudentid()==x)break;
                p=p.next;
            }
            if (p==null){
                System.out.println(x+" not found in list");
                return null;
            }
            else return p.data;
        }
        public void insertinbeginning(studentrecord data){
            node temp=new node(data);
            temp.next=start;
            start=temp;
        }
        public void deletenode(int x){
            if (start==null){
                System.out.println("Value "+x+" not present \n");
                return;
            }
            if (start.data.getstudentid()==x){
                start=start.next;
                return;
            }
            node p=start;
            while (p.next!=null){
               if (p.next.data.getstudentid()==x)break;
               p=p.next;
            }
            if (p.next==null)System.out.println("Value "+x+" not present \n");
            else p.next=p.next.next;
        }
    }
    public static class hashtable{
        private singleLL[] array;
        private int m;
        private int n;
        //public hashtable():this(11){}
        public hashtable(int tablesize){
            m=tablesize;
            n=0;
            array=new singleLL[tablesize];
        }
        int hash(int key){
            return (key%m);
        }
        public void displaytable(){
          for (int i=0;i<m;i++){
              System.out.println("["+i+"]  -->  ");
              if (array[i]!=null)array[i].displaylist();
              else System.out.println("___");
          }
        }
        public studentrecord search(int key){
            int h=hash(key);
            if (array[h]!=null)
                return array[h].search(key);
            return null;
        }
        public void insert(studentrecord newrecord){
            int key=newrecord.getstudentid();
            int h=hash(key);
            if (array[h]==null)array[h]=new singleLL();
            array[h].insertinbeginning(newrecord);
            n++;
        }
        public void delete(int key){
            int h=hash(key);
            if(array[h]!=null){
                array[h].deletenode(key);
                n--;
            }
            else System.out.println("Value "+key+" not present");
        }
    }
    public static void main(String[]args){
        int id,choice;
        String name;
        System.out.println("Enter initial size of table : ");
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        hashtable table=new hashtable(size);
        while (true) {
            System.out.println("1.Insert a record");
            System.out.println("2.Search a record");
            System.out.println("3.Delete a record");
            System.out.println("4.Display table");
            System.out.println("5.Exit");
            System.out.println("Enter your choice : ");
            choice=sc.nextInt();
            if (choice==5)break;
            switch (choice){
                case 1:
                    System.out.println("Enter student id: ");
                    id=sc.nextInt();
                    System.out.println("Enter student name");
                    name=sc.next();
                    studentrecord arecord= new studentrecord(id,name);
                    table.insert(arecord);
                    break;
                case 2:
                    System.out.println("Enter a key to be searched");
                    id=sc.nextInt();
                    arecord=table.search(id);
                    if (arecord==null)System.out.println("Key not found");
                    else System.out.println(arecord.tostring());
                    break;
                case 3:
                    System.out.println("Enter a key to be deleted");
                    id=sc.nextInt();
                    table.delete(id);
                    break;
                case 4:
                    table.displaytable();
                    break;
            }
        }
    }
}
