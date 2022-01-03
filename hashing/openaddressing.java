package hashing;

import java.util.Scanner;

public class openaddressing {
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
    public static class hastable{
        private studentrecord[]array;
        private int m;
        int n;
        //public hastable():this(11){}
        public hastable(int tablesize){
            m=tablesize;
            array=new studentrecord[m];
            n=0;
        }
        int hash(int key){
            return (key%m);
        }
        public void insert(studentrecord newrecord){
            int key=newrecord.getstudentid();
            int h=hash(key);
            int location=h;
            for (int i=1;i<m;i++){
                if (array[location]==null||array[location].getstudentid()==-1){
                    array[location]=newrecord;
                    n++;
                    return;
                }
                if (array[location].getstudentid()==key){
                    System.out.println("duplicate key");
                }
                location=(h+i)%m;
            }
            System.out.println("Table is full: record can't be inserted");
        }
        public studentrecord search(int key){
            int h=hash(key);
            int location=h;
            for (int i=1;i<m;i++){
                if (array[location]==null)return null;
                if (array[location].getstudentid()==key)
                    return array[location];
                location=(h+i)%m;//linear probing
                //location=(h+i*i)%m; for quadratic probing
            }
            return null;
        }
        public void displaytable(){
            for (int i=0;i<m;i++){
                System.out.print("["+i+"] --> " );
                if (array[i]!=null&&array[i].getstudentid()!=-1)
                    System.out.println(array[i].tostring());
                else System.out.println("___");
            }
        }
        public studentrecord delete(int key){
            int h=hash(key);
            int location=h;
            for (int i=1;i<m;i++){
                if (array[location]==null)return null;
                if(array[location].getstudentid()==key){
                    studentrecord temp=array[location];
                    array[location].setstudentid(-1);
                    n--;
                    return temp;
                }
                location=(h+i)%m;
            }
            return null;
        }
        //for double hashing
        public void insert1(studentrecord newrecord){
            if(n>=m/2){
                rehash(nextprime(2*m));
                System.out.println("New table size is : "+m);;
            }
            insert(newrecord);
        }
        int nextprime(int x){
            while(!isprime(x))x++;
            return x;
        }
        boolean isprime(int x){
            for (int i=2;i<x;i++){
                if(x%i==0)return false;
            }
            return true;
        }
        private void rehash(int newsize){
            hastable temp=new hastable(newsize);
            for (int i=0;i<m;i++){
                if (array[i]!=null&&array[i].getstudentid()!=-1)
                    temp.insert(array[i]);
            }
            array= temp.array;
            m=newsize;
        }
        public void delete1(int key){
            int h=hash(key);
            int location=h;
            for(int i=1;i<m;i++){
                if (array[location]==null)return;
                if (array[location].getstudentid()==key){
                    array[location].setstudentid(-1);
                    n--;
                    if (n>0&&n<=m/8){
                        rehash(nextprime(m/2));
                        System.out.println("New table size is : "+m);
                    }
                }
                location=(h+i)%m;
            }
        }
    }
    public static void main(String[]args){
        int id,choice;
        String name;
        System.out.println("Enter initial size of table");
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        hastable table=new hastable(size);
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
                  System.out.println("Enter student id : ");
                  id=sc.nextInt();
                  System.out.println("Enter student name");
                  name=sc.next();
                  studentrecord arecord=new studentrecord(id,name);
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
                    System.out.println("Enter a key to be deleted :");
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
